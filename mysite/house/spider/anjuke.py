#爬取安居客网站中民大附近的房源信息
import urllib.request
from bs4 import BeautifulSoup
from house.models import *
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
  
    s=urllib.request .quote(s)
    url = "https://bj.zu.anjuke.com/?t=1&from=0&comm_exist=on&kw="+s
    temp_soup = parser_url(url)
    # turn_page(temp_soup)
    crawler(temp_soup)
    col_name = ['名称', '面积', '租价', '房型', '位置']
    data_list = [list() for i in range(len(name_list))]
    for i in range(len(name_list)):
        data_list[i].append(name_list[i])
        data_list[i].append(rs_list[i])
        data_list[i].append(price_list[i])
        data_list[i].append(rt_list[i])
        data_list[i].append(rl_list[i])
    print(data_list)
    add_data((s),data_list)
    return data_list
def my_sort(f,data_list):
    if f=='a1':
        return sort_area(data_list)
    elif f=='a2':
        return sort_price(data_list)
    else:
        return data_list
def sort_area(data_list):
# col_name = ['名称', '面积', '租价', '房型', '位置']
    return sorted(data_list,key=lambda x:x[1])
    
def sort_price(data_list):
    return sorted(data_list,key=lambda x:x[2])

def add_data(s,data_list):
    for data in data_list:
        # try:
        #     print(0)
        # except django.db.utils.IntegrityError:
        #     pass
        # for i in data:
        #     if i=='' or i==[] :
        #         continue
        house = House(source_prompt=s,house_name=data[0],house_area=data[1],house_price=data[2],house_type=data[3],house_location=data[4])
        house.save()