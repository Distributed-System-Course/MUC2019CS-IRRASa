#-- coding:UTF-8 --
#爬取安居客网站中民大附近的房源信息
import urllib.request
import sys
import pandas as pd
from bs4 import BeautifulSoup
name_list = []
rs_list = []
price_list = []
rt_list = []
rl_list = []

def parser_url(url):
    # 安居客租房url(指定民大附近)
    html = urllib.request.urlopen(url)
    soup = BeautifulSoup(html.read().decode('utf-8'), "lxml")
    return soup

def turn_page(soup):
    '''
    功能：储存下一页的url,实现翻页爬取
    '''
    page = soup.find("div", class_="multi-page")
    nxpg = page.find("a", class_="aNxt")
    pgurl = nxpg.get('href')
    # print(pgurl)
    return pgurl

def crawler(soup):
    '''
    主爬虫函数,爬取需要数据,并在分列表中添加
    '''
    rooms = soup.find_all("div", class_="zu-info")
    prices = soup.find_all("div", class_="zu-side")

    for r in rooms:
        # 爬取房屋名称
        name_list.append(r.find("b", class_="strongbox").string)


        room_details = r.find("p", class_="details-item tag").text.split('|')
        # 爬取面积
        rs_list.append(room_details[1])
        # 爬取房型，包括户型+楼层
        rt_list.append(room_details[2].split(' ', 1)[0] + ' ' + room_details[0][1:])

        location_details = r.find("address", class_="details-item").text.replace(' ', '').split('\n')
        # 爬取位置
        rl_list.append(location_details[1] + location_details[2])

    for pr in prices:
        # 爬取租价
        price_list.append(pr.find("b", class_="strongbox").string + '元/月')

def save(s):
    # s="中央民族大学"
    p=urllib.request .quote(s)
    url = "https://bj.zu.anjuke.com/?t=1&from=0&comm_exist=on&kw="+p
    temp_soup = parser_url(url)
    # turn_page(temp_soup)
    crawler(temp_soup)
    data_list =[]
    i = 0
    for i in range(len(name_list)):
        temp = []
        temp.append(s.replace(u'\xa0', u' '))
        temp.append(name_list[i].replace(u'\xa0', u' '))

        temp.append(rs_list[i].replace("平米","").replace(u'\xa0', u' '))
        temp.append(price_list[i].replace("元/月","").replace(u'\xa0', u' '))
        temp.append(rt_list[i].replace(u'\xa0', u' '))
        temp.append(rl_list[i].replace(u'\xa0', u' '))
        data_list.append(temp)
        if i==2:
            break
        i+=1
    data = pd.DataFrame(data_list, columns=['sourcePrompt', 'houseName','houseArea','housePrice','houseType','houseLocation'])
    data.to_csv('src/main/java/com/example/java_muc2019csirrasa/python/data.csv')
    return data_list
if __name__=="__main__":
    data_list = save(sys.argv[1])
    print(data_list)