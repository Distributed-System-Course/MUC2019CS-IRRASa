// var map = new BMapGL.Map("l-map"); 
var riding = new BMap.RidingRoute(map, { 
    renderOptions: { 
        map: map, 
        autoViewport: true 
    }
});
map.centerAndZoom(new BMap.Point(116.404, 39.915), 14); 
var start = new BMap.Point(116.310791, 40.003419);
var end = new BMap.Point(116.386419, 40.003519);
riding.search(start, end);