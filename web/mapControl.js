 // GL版命名空间为BMapGL
    // 按住鼠标右键，修改倾斜角和角度
	// var map = new BMapGL.Map("allmap");    // 创建Map实例
	// map.centerAndZoom(new BMapGL.Point(116.404, 39.915), 11);  // 初始化地图,设置中心点坐标和地图级别
    map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
    var scaleCtrl = new BMap.ScaleControl();  // 添加比例尺控件
    map.addControl(scaleCtrl);
    // var zoomCtrl = new BMap.ZoomControl();  // 添加比例尺控件
    // map.addControl(zoomCtrl);