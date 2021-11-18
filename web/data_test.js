const room_data= 
{
    "rooms": [
        {   "id":0,
            "name": "地铁4号线白石桥站 气象局 南北2居出租",
            "area": 59,
            "price": 9200,
            "type": "共4层 2室1厅",
            "location": "中国气象局社区(南区)  海淀-白石桥中关村南大街46号"
        },
        {   "id":1,
            "name": "口腔医院 大慧寺7号院朝南五层次卧出租 看房方便",
            "area": 15,
            "price": 3600,
            "type": "共5层 3室1厅",
            "location": "大慧寺7号院  海淀-魏公村大慧寺路7号"
        },
        {   "id":2,
            "name": "民大附中家属区 3室1厅1卫 13000元月 92平",
            "area": 92,
            "price": 13000,
            "type": "高层(共9层) 3室1厅",
            "location": "民大附中家属区  海淀-魏公村民族大学西路"
        },
        {   "id":3,
            "name": "舞蹈学院 民族大学 魏公村 精装朝南 正规一居室出租",
            "area": 40,
            "price": 5800,
            "type": "共5层 1室1厅",
            "location": "魏公村南区  海淀-魏公村魏公村路"
        },
        {   "id":4,
            "name": "交大西门魏公村农科院大柳树钢研社区大慧寺次卧室出租",
            "area": 15,
            "price": 3500,
            "type": "共5层 4室1厅",
            "location": "大慧寺19号院  海淀-皂君庙大慧寺路19号"
        }

    ]
};
const tableHeaders=
    '<tr><th>房名</th><th>面积/平米</th><th>租价/元/月</th><th>房型</th><th>位置</th></tr>';
let irrsHTML = '';
irrsHTML += tableHeaders
const roomRow = 
    '<tr><td>NAME</td><td>AREA</td><td>PRICE</td><td>TYPE</td><td>LOCATION</td></tr>';