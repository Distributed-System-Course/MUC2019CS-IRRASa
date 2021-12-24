
// 百度地图API功能
function G(id) {
    return document.getElementById(id);
}

var map = new BMap.Map("l-map");
map.centerAndZoom("北京",12);                   // 初始化地图,设置城市和地图级别。
var localSearch = new BMap.LocalSearch(map);
localSearch.enableAutoViewport(); //允许自动调节窗体大小   
// 将地址解析结果显示在地图上，并调整地图视野    
var keyword;
var poi;
var asd;
function searchByStationName(target) {
    keyword = target;
    // alert()
// 　　var keyword = document.getElementById("suggestId").value;
　　localSearch.setSearchCompleteCallback(function (searchResult) {
        poi = searchResult.getPoi(0);
　　　　document.getElementById("result_").value = poi.point.lng + "," + poi.point.lat; //获取经度和纬度，将结果显示在文本框中
        asd=document.getElementById("result_").value;

　　　　map.centerAndZoom(poi.point, 12);
　　});
　　localSearch.search(keyword);
 
    
}
var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
    {"input" : "suggestId"
    ,"button" : "btn-search fr"
    ,"location" : map
});
function navigation(point1){
    alert(poi);
    
}
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
// function setMyValue(){
//     myValue="天安门";
// }
// 按钮的地图响应
function searchButton(){
    myValue = document.getElementById("suggestId").value;
    
    setPlace();
}


function setPlace(){
    map.clearOverlays();    //清除地图上所有覆盖物
    function myFun(){
        var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
        map.centerAndZoom(pp, 18);
        map.addOverlay(new BMap.Marker(pp));    //添加标注
    }
    var local = new BMap.LocalSearch(map, { //智能搜索
      onSearchComplete: myFun
    });
    local.search(myValue);
}

