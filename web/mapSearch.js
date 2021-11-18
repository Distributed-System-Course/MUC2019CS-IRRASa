var rns=new Array();
var rls=new Array();
function G(id) {
    return document.getElementById(id);
}
//房源数据显示
function roomPerform(){
    let irrsHTML = '';
    room_data.rooms.forEach(room=>{
        let thisRoomHTML = roomRow;
        thisRoomHTML = thisRoomHTML.replace('NAME',room.name);
        thisRoomHTML = thisRoomHTML.replace('AREA',room.area);
        thisRoomHTML = thisRoomHTML.replace('PRICE',room.price);
        thisRoomHTML = thisRoomHTML.replace('TYPE',room.type);
        thisRoomHTML = thisRoomHTML.replace('LOCATION',room.location);
        
        rns.push(room.name);
        rls.push(room.location);
        irrsHTML += thisRoomHTML;
    }
        );
    document.getElementById("rooms").innerHTML=irrsHTML;
}
// 按钮面积降序
function areaDescend(){

}
//按钮价格升序
function priceAscend(){
    
}
// 按钮的地图响应
function searchButton(){
    roomPerform();
    myValue = document.getElementById("suggestId").value;
    setPlace();
    for(var i=0;i<rns.length;i++){
        roomSearch(rls[i],rns[i]);
    }
    // for(var i=0;i<disp.length;i++){
    //     navigation(centerp,disp[i]);
    // }
    // navigation(pa,pos[0]);
} 
function setPlace(){
    map.clearOverlays();    //清除地图上所有覆盖物
    function myFun(){
        //获取搜索地点的经纬度
        var pp = local.getResults().getPoi(0).point; 
        alert(pp)   //获取第一个智能搜索的结果
        // var pp2 = local.getResults().getPoi(1).point;
        map.centerAndZoom(pp, 15);
        //根据经纬度添加标注
        map.addOverlay(new BMap.Marker(pp));    //添加标注
        // map.addOverlay(new BMap.Marker(new BMap.Point(116.404, 39.925)));    //添加标注
    }
    var local = new BMap.LocalSearch(map, { //智能搜索
      onSearchComplete: myFun
    });
    local.search(myValue);
}
//房源路径导航
function navigation(p2){
    var p1 = new BMap.Point(39.956624,116.327126);
    // var p2 = new BMap.Point(116.508328,39.919141);
    var driving = new BMap.DrivingRoute(map, {renderOptions:{map: map, autoViewport: true}});
    driving.search(p1, p2);
}
//房源位置具体搜索测试,在地图中标点并创建信息窗口
function roomSearch(locate,rname){
    function myFun(){
        //获取搜索地点的经纬度
        var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
        // navigation(pp);
        //根据经纬度添加标注
        var marker = new BMap.Marker(pp);
        map.addOverlay(marker);    //添加标注
        var infoWindow = new BMap.InfoWindow('地址:'+locate, opts);
        // 点标记添加点击事件
        marker.addEventListener('click', function () {
            map.openInfoWindow(infoWindow, pp); // 开启信息窗口
        });
    }
    var local = new BMap.LocalSearch(map, { //智能搜索
        onSearchComplete: myFun
      });
    local.search(locate);
    // 创建信息窗口
    var opts = {
        width: 200,
        height: 100,
        title: rname
    };    
}
var map = new BMap.Map("l-map");
map.centerAndZoom("北京",12);                   // 初始化地图,设置城市和地图级别。
// map.addOverlay(new BMap.Marker(new BMap.Point(116.404, 39.925)));    //添加标注

var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
    {"input" : "suggestId"
    ,"button" : "btn-search fr"
    ,"location" : map
});

ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
var str = "";
    var _value = e.fromitem.value;
    var value = "";
    if (e.fromitem.index > -1) {
        value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
    }    
    str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
    
    value = "";
    if (e.toitem.index > -1) {
        _value = e.toitem.value;
        value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
    }    
    str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
    G("searchResultPanel").innerHTML = str;
});

var myValue;
ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
var _value = e.item.value;
    myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
    G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
    
    setPlace();
});
var p1 = new BMap.Point(116.327126,39.956624);
var p2 = new BMap.Point(116.508328,39.919141);
var driving = new BMap.DrivingRoute(map, {renderOptions:{map: map, autoViewport: true}});
    driving.search(p1,p2);
//具体房源位置标记测试，房源数据从后端获取
// var rn1 = "地铁4号线白石桥站 气象局 南北2居出租";
// var rl1 = "中国气象局社区(南区)  海淀-白石桥中关村南大街46号";
// var rn2 = "口腔医院 大慧寺7号院朝南五层次卧出租 看房方便";
// var rl2 = "大慧寺7号院  海淀-魏公村大慧寺路7号";


// var point = new BMap.Point(116.404, 39.925);
// // 创建点标记
// var marker1 = new BMap.Marker(new BMap.Point(116.404, 39.925));
// var marker2 = new BMap.Marker(new BMap.Point(116.404, 39.915));
// var marker3 = new BMap.Marker(new BMap.Point(116.395, 39.935));
// var marker4 = new BMap.Marker(new BMap.Point(116.415, 39.931));
// // 在地图上添加点标记
// map.addOverlay(marker1);
// map.addOverlay(marker2);
// map.addOverlay(marker3);
// map.addOverlay(marker4);
// // 创建信息窗口
// var opts = {
//     width: 200,
//     height: 100,
//     title: '故宫博物院'
// };
// var infoWindow = new BMap.InfoWindow('地址：北京市东城区王府井大街88号乐天银泰百货八层', opts);
// // 点标记添加点击事件
// marker1.addEventListener('click', function () {
//     map.openInfoWindow(infoWindow, point); // 开启信息窗口
// });
