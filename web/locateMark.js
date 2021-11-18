// var map = new BMapGL.Map('container');
// map.enableScrollWheelZoom(true);
// 创建点标记
// var marker1 = new BMap.Marker(new BMap.Point(116.404, 39.925));
// var marker2 = new BMap.Marker(new BMap.Point(116.404, 39.915));
// var marker3 = new BMap.Marker(new BMap.Point(116.395, 39.935));
// var marker4 = new BMap.Marker(new BMap.Point(116.415, 39.931));
// // 在地图上添加点标记
// map.addOverlay(marker1);
// map.addOverlay(marker2);
// map.addOverlay(marker3);
// map.addOverlay(marker4);
map = BMap.Map("l-map");
map.addOverlay(new BMap.Marker(new BMap.Point(116.404, 39.925)));    //添加标注
