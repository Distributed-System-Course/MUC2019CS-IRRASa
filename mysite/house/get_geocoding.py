import requests
import json

def get_point(address):
    ak = 'rgkditHGQqDjme0T6k4KITrB3DPXajNB'
    url = 'http://api.map.baidu.com/geocoding/v3/?address={inputAddress}&output=json&ak={myAk}'.format(inputAddress=address,myAk=ak)  
    add_url = url 
   
    #lat,lng = getPosition(add_url)
    res = requests.get(add_url)
    json_data = json.loads(res.text)
    
    if json_data['status'] == 0:
        lat = json_data['result']['location']['lat'] #纬度
        lng = json_data['result']['location']['lng'] #经度
    else:
        print("Error output!")
        
    return lat,lng



address = ['上海市嘉定区科贸路8号','苏州市虎丘区青花路9号','沈阳辉山农业高新技术开发区宏业街73号','广东省佛山市魁奇一路9号','四川省成都市锦江区中纱帽街8号']
l=get_point(address[0])
print(l)