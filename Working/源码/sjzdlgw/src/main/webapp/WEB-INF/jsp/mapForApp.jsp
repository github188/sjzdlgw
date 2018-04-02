<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2016/10/21
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>国网地图</title>
    <!-- 使用ArcGIS在线API，内网使用需要本地化部署 -->
    <link rel="stylesheet" href="http://115.159.104.25:8080/apis/arcgis_js_api/esri/css/esri.css">
    <style type="text/css">
        html, body {
            width: 100%;
            height: 100%;
            margin: 0;
            padding: 0;
        }

        #map {
            height: 100%;
        }
        #toobar {
            position: absolute;
            top: 10px;
            right: 10px;
            float: right;
        }
        #icon_toolbar {
            position:absolute;top:0px;right:0px;z-index:6000;
            overflow:hidden;
            list-style: none;
            display: none;
            padding-left:10px;
            padding-right:10px;
            height:100%;
            background:#b8d0d6;

        }
        #icon_toolbar li {
            width:100%;text-align:center;
            margin-top:10px;
        }
        #icon_toolbar li img {
            width:24px;
            height:24px;
            cursor: pointer;
        }
        #mouse_toolbar {
            position: absolute;
            width: 150px;
            height: 150px;
            z-index: 5900;
            display: none;
            /***********还图前*************/
            border-radius: 50%;
            border: 1px solid #000;
            /***********还图后***********
                    bacground:url();**/
        }

        #mouse_toolbar img {
            width: 30px;
            height: 30px;
            position: absolute;
            cursor: pointer;
        }

        #mouse_toolbar .img_1 {
            margin-left: -11px;
            margin-top: 27px;
        }

        #mouse_toolbar .img_2 {
            margin-left: 61px;
            margin-top: -14px;
        }

        #mouse_toolbar .img_3 {
            margin-left: 129px;
            margin-top: 27px;
        }

        #mouse_toolbar .img_4 {
            margin-left: 113px;
            margin-top: 106px;
        }

        #mouse_toolbar .img_5 {
            margin-left: 2px;
            margin-top: 105px;
        }
    </style>
    <script src="http://115.159.104.25:8080/apis/arcgis_js_api/init.js" type="text/javascript"></script>
    <script src="${staticPath}/dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
    <script src="${staticPath}/jquery/jquery.zclip.js" type="text/javascript"></script>
    <script src="${staticPath}/website/js/WKTUtil.js" type="text/javascript"></script>
    <script type="text/javascript">
        // 开放接口,加载外部数据
        var loadMap, locate,parentClaenMapData,staticTypes;

        require([ "esri/map", "esri/toolbars/edit", "esri/graphic",
                    "esri/SpatialReference",
                    "esri/layers/ArcGISTiledMapServiceLayer",
                    "esri/layers/WebTiledLayer", "esri/layers/GraphicsLayer",
                    "esri/renderers/ClassBreaksRenderer",
                    "esri/geometry/Extent", "extras/ClusterLayer",
                    "esri/geometry/webMercatorUtils", "esri/geometry/Point",
                    "esri/geometry/Polyline", "esri/geometry/Polygon",
                    "esri/symbols/SimpleMarkerSymbol",
                    "esri/symbols/SimpleLineSymbol",
                    "esri/symbols/SimpleFillSymbol",
                    "esri/symbols/PictureMarkerSymbol", "esri/Color",
                    "esri/geometry/screenUtils",
                    "esri/symbols/TextSymbol", "esri/InfoTemplate", "dojo/on","dojo/_base/event",
                    "dojo/domReady!" ],
                function(Map, Edit, Graphic, SpatialReference,
                         ArcGISTiledMapServiceLayer, WebTiledLayer, GraphicsLayer,
                         ClassBreaksRenderer, Extent, ClusterLayer,
                         webMercatorUtils, Point, Polyline, Polygon,
                         SimpleMarkerSymbol, SimpleLineSymbol, SimpleFillSymbol,
                         PictureMarkerSymbol, Color,screenUtils,TextSymbol, InfoTemplate, on, event) {

                    // DEFAULTS
                    var PBS_BASE_MAP = "http://59.108.82.133:7080/PBS/rest/services/MapsRoad/MapServer";
                    var DEFAULT_SRID = 4326; //系统默认坐标系
                    var SRID_4326 = new SpatialReference(DEFAULT_SRID);

                    ///////////////////////////////////////////////
                    // 记录和初始化当前地图级别
                    var _curLevel = 16;
                    // 保存已添加图层的ID列表
                    var gLayers = [];
                    var tLayers = [];
                    // 地图级别对应缩放比例
                    var lods;
                    // 标注绘制临时集合
                    var __larray = [];

                    // 编辑工具
                    var editToolbar;
                    // 判断当前视图是否为编辑模式
                    var __editModel = false;

                    // 接受编辑的对象
                    var _editGraphic;
                    //////////////////////////////////////////////

                    // 事件管理
                    var MAP_ON_EXTENT_CHANGE;
                    var MAP_ON_ZOOM_END;
                    var MAP_ON_CLICK;

                    // 事件集合
                    var G_DBL_CLICK_LIST = [];
                    var G_MOUSE_OVER_LIST = [];
                    var G_MOUSE_OUT_LIST = [];

                    //////////////////////////////////////////////

                    // 初始化地图对象
                    var map = new Map("map", {
                        center : [ 114.529615764554, 38.0238827890626 ],
                        zoom : _curLevel,
                        logo : false
                    });


                    // 注册Map对象加载完毕后初始化方法
                    map.on("load", function() {
                        map.disableDoubleClickZoom();//禁止双击缩放
                        lods = _generateLods(map);
                        $(document).ready(jQueryReady);

                        editToolbar = new Edit(map); //初始化编辑工具

                        // 触发编辑提交
                        editToolbar.on("deactivate",function(e){
//                            console.log("attr",e.graphic.attributes);
                            var _wkt = getWKT(e.graphic.geometry);
                            // $$$$$$$$$$$$$$$$$编辑结束触发保存请求$$$$$$$$$$$$$$$$$
//                            console.log(e.graphic.attributes.id,_wkt);

                            // 应该写入到回调函数中
                            // 重新绑定地图事件
                            bindMapEvent();
                            // 保存后需要重新请求，重新绑定所有地图事件
//                            loadMap([ "测试" ]);
                        });
                        var _lg,lgy;
                        editToolbar.on("graphic-first-move",function(e){
                            var _g = e.graphic;
                            var _lableLayer = lgy = map.getLayer(_g.getLayer().id+"_label");
                            var name = _g.attributes.name;
                            for(var lg in _lableLayer.graphics){
                                if(_lableLayer.graphics[lg].symbol.text == name) {
                                    _lg = _lableLayer.graphics[lg];
                                }
                            }
                        })
                        editToolbar.on("graphic-move-stop",function(e){
                            var _g = e.graphic;
                            _lg.setGeometry(_g.geometry);
                        });
                        // 点击保存按钮
                        $('#save').on('click',function(e){
                            //隐藏编辑工具条
                            hideBar();
                            if(__editModel) {
                                editToolbar.deactivate();
                                __editModel = false;
                            }
                        });

                        bindMapEvent();
                    });

                    // 添加底图图层
                    var basemap = new ArcGISTiledMapServiceLayer(PBS_BASE_MAP);
                    map.addLayer(basemap);

                    // jQuery 启动入口
                    function jQueryReady() {

                        //加载地图数据，参数表示需要加载的图层类型列表
                        function _loadMapData(types) {
                            window.parent.startAjaxLoading_map();
                            staticTypes=types;
                            _clearMap();
                            $.get('${ctxPath}/mapPowerData/'+types,
                                    {
                                        "extent" : JSON.stringify(map.extent),
                                        "zoom" : _curLevel
                                    }, _getAllFeature,"json");
                        }

                        loadMap = _loadMapData;
                        locate = _locate;

                        // 绑定一些操作按钮的事件
                        // 移出鼠标工具栏后，隐藏
                        $('#mouse_toolbar').mouseleave(hideMouseBar);
                        $('#mouse_toolbar img').on('click',function(e){
//                            console.log("活跃的要素",_editGraphic.attributes);
                            var key = $(e.target).attr("key"); //点击的按键标识
                            switch(key) {
                                case "3": //三维仿真
//                                    console.log("3333333333");
                                    break;
                                case "4": //编辑位置
//                                        console.log("44444444444444");
                                    __editModel = true; //设置为编辑状态
                                    hideMouseBar(); // 隐藏信息框
                                    showBar();//显示编辑工具条
                                    var tool = 0;
                                    tool = tool | Edit.MOVE;
                                    tool = tool | Edit.EDIT_VERTICES;
                                    editToolbar.activate(tool, _editGraphic);
                                    // 关闭图层上其他的绑定事件
                                    unBindMapEvent();
                                    break;
                                case "5": //编辑信息
                                    //调用打开窗口
                                    window.parent.mapPageOpenDailog('${ctxPath}',_editGraphic.attributes);
                                    break;
                            }
                        });
                    }
                    // 绑定编辑对象的要素同步属性
                    function bindTextLable(graphic){

                    }
                    //////////////////////////////////////////////////////////
                    function _getAllFeature(featureSets) {
                        _clearMap();
                        for ( var i in featureSets) {
                            var featureSet = featureSets[i];
                            _drawFeature(featureSet);
                        }
                        window.parent.endAjaxLoading_map();
                    }

                    function _drawFeature(featureSet) {

                        var _type = featureSet.type;

                        // 矢量图层生成
                        var _layerId = featureSet.name;

                        var _layer = map.getLayer(_layerId);

                        if(!_layer) {
                            _layer = new GraphicsLayer({
                                "id" : _layerId,
                                "minScale" : lods[featureSet.image_level],
                                "dataAttributes" : featureSet
                            });

                            map.addLayer(_layer,0);
                            gLayers.push(_layerId);

                        } else {
                            _layer.clear();
                        }

                        // 要素双击
                        var DBL_CLICK = _layer.on("dbl-click",function(e) {
                            event.stop(e);
                            var feature = e.graphic;
//                            console.log(feature.attributes);

                            // $此处绑定外部方法

                        });

                        // 鼠标浮动进入
                        var MOUSE_OVER = _layer.on("mouse-over",function(e){

                            // 高亮
                            _highLight(e);

                            // 设置为当前活跃要素
                            _editGraphic = e.graphic;

                            // 显示工具栏
                            _showToolbar(e);

                        });

                        // 鼠标浮动退出
                        var MOUSE_OUT = _layer.on("mouse-out",function(e){
                            // 退出高亮
                            _unhighLight(e);
                        });

                        G_DBL_CLICK_LIST.push(DBL_CLICK);
                        G_MOUSE_OVER_LIST.push(MOUSE_OVER);
                        G_MOUSE_OUT_LIST.push(MOUSE_OUT);


                        // 注记图层生成
                        var _textLayerId = featureSet.name+"_label";

                        var _textLayer = map.getLayer(_textLayerId);

                        if(!_textLayer) {
                            _textLayer = new GraphicsLayer({
                                "id" : _textLayerId,
                                "minScale" : lods[featureSet.name_level]
                            });
                            map.addLayer(_textLayer,100);
                            tLayers.push(_textLayerId);

                            // 标注层添加数据并去重
                            _textLayer.on("graphic-draw", _graphicDraw);
                        } else {
                            _textLayer.clear();
                        }

                        if(_type == "point") {
                            __drawPoint(_layer,_textLayer,featureSet);
                        } else if(_type == "line") {
                            __drawLine(_layer,null,featureSet); //使用null表示不添加注记
                        } else if(_type == "geometric") {
                            __drawPolygon(_layer,_textLayer,featureSet);
                        }
                    }

                    // 生成样式标签
                    function __getLableSymbol(type,text) {
                        if(!type) return;
                        switch(type) {
                            case "point" :
                                return textSymbol = new TextSymbol({
                                    "type" : "esriTS",
                                    "color" : [78, 78, 78, 255],
                                    "verticalAlignment" : "middle",
                                    "horizontalAlignment" : "center",
                                    "rightToLeft" : false,
                                    "angle" : 0,
                                    "xoffset" : 0,
                                    "yoffset" : 10,
                                    "font" : {
                                        "family" : "微软雅黑",
                                        "size" : 8,
                                        "style" : "normal"
                                    },
                                    "text" : text
                                });
                            case "polygon" :
                                return textSymbol = new TextSymbol({
                                    "type" : "esriTS",
                                    "color" : [78, 78, 78, 255],
                                    "verticalAlignment" : "middle",
                                    "horizontalAlignment" : "center",
                                    "rightToLeft" : false,
                                    "angle" : 0,
                                    "xoffset" : 0,
                                    "yoffset" : 0,
                                    "font" : {
                                        "family" : "微软雅黑",
                                        "size" : 8,
                                        "style" : "normal"
                                    },
                                    "text" : text
                                });
                        }
                    }

                    // 绘制点图层
                    function __drawPoint(_layer,_textLayer,featureSet){
                        var _image = featureSet.image;
                        var geomList = featureSet.geomMapList;

                        // 替换文件路径 _images
                        var _symbol = new PictureMarkerSymbol(_image, 12, 12);

                        for(var i in geomList) {
                            var feature = geomList[i];
                            var geometry = wkt2Point(feature.geomStr);
                            var g = new Graphic(geometry, _symbol, feature);
                            _layer.add(g);

                            if(_textLayer) {
                                var label = new Graphic(geometry,__getLableSymbol("point",feature.name));
                                _textLayer.add(label)
                            }
                        }

                    }

                    // 绘制线图层
                    function __drawLine(_layer,_textLayer,featureSet){
                        var geomList = featureSet.geomMapList;

                        var _color = featureSet.image;
                        var styles = _color.split("_", 2);
                        var _symbol = new SimpleLineSymbol(SimpleLineSymbol.STYLE_SOLID, Color.fromHex(styles[0]), styles[1]);

                        for(var i in geomList) {
                            var feature = geomList[i];
                            var geometry = wkt2Line(feature.geomStr);
                            var g = new Graphic(geometry, _symbol, feature);
                            _layer.add(g);

                            if(_textLayer) {
                                var center = geometry.getExtent().getCenter();
                                var label = new Graphic(center,__getLableSymbol(feature.name));
                                _textLayer.add(label)
                            }
                        }
                    }

                    // 绘制面图层
                    function __drawPolygon(_layer,_textLayer,featureSet){
                        var geomList = featureSet.geomMapList;

                        var _color = featureSet.image;
                        var _symbol = new SimpleFillSymbol(
                                SimpleFillSymbol.STYLE_SOLID,
                                new SimpleLineSymbol(SimpleLineSymbol.STYLE_SOLID, Color.fromHex("#0099CC"), 1),
                                Color.fromHex("#00CCFF"));

                        for(var i in geomList) {
                            var feature = geomList[i];
                            var geometry = wkt2Polygon(feature.geomStr);
                            var g = new Graphic(geometry, _symbol, feature);
                            _layer.add(g);

                            if(_textLayer) {
                                var center = geometry.getExtent().getCenter();
                                var label = new Graphic(center,__getLableSymbol("polygon",feature.name));
                                _textLayer.add(label)
                            }
                        }
                    }

                    function _highLight(e){
                        if(!e) return;
                        map.graphics.clear();
                        // 得到数据对应的图层信息
                        var _layer = e.graphic.getLayer();
                        var _attributes = e.graphic.attributes;
                        var _geom = e.graphic.geometry;
                        var _type = _geom.type;
                        var _hlsymbol;
                        switch(_type) {
                            case "point" :
                                var _image = _layer.dataAttributes.image; //图层默认的图
                                _hlsymbol = new PictureMarkerSymbol(_image, 18, 18);// 18，18 放大
                                break;
                            case "polyline" :
                                _hlsymbol = new SimpleLineSymbol({
                                    "type": "esriSLS",
                                    "style": "esriSLSSolid",
                                    "color": [255,0,0,255],
                                    "width": 2
                                });
                                break;
                            case "polygon" :
                                _hlsymbol = new SimpleFillSymbol(
                                        SimpleFillSymbol.STYLE_SOLID,
                                        new SimpleLineSymbol(SimpleLineSymbol.STYLE_SOLID, Color.fromHex("#FF0000"), 2),
                                        Color.fromHex("#00CCFF"));
                                break;
                        }
                        e.graphic.setSymbol(_hlsymbol);
                    }

                    // 取消要素的高亮显示-还原到默认的样式
                    function _unhighLight(e){
                        if(!e) return;
                        // 得到数据对应的图层信息
                        var _layer = e.graphic.getLayer();
                        var _attributes = e.graphic.attributes;
                        var _geom = e.graphic.geometry;
                        var _type = _geom.type;
                        var _unhlsymbol;

                        switch(_type) {
                            case "point" :
                                var _image = _layer.dataAttributes.image; //图层默认的图片
                                _unhlsymbol = new PictureMarkerSymbol(_image, 12, 12);
                                break;
                            case "polyline" :
                                var _color = _layer.dataAttributes.image;
                                var styles = _color.split("_", 2);
                                _unhlsymbol = new SimpleLineSymbol(SimpleLineSymbol.STYLE_SOLID, Color.fromHex(styles[0]), styles[1]);
                                break;
                            case "polygon" :
                                _unhlsymbol = new SimpleFillSymbol(
                                        SimpleFillSymbol.STYLE_SOLID,
                                        new SimpleLineSymbol(SimpleLineSymbol.STYLE_SOLID, Color.fromHex("#0099CC"), 1),
                                        Color.fromHex("#00CCFF"));
                                break;
                        }
                        e.graphic.setSymbol(_unhlsymbol);
                    }

                    // 绑定地图事件
                    function bindMapEvent() {
                        // 当地图拖动时触发此方法
                        MAP_ON_EXTENT_CHANGE = map.on("extent-change",function(e){
                            // 用于测试
                            if (typeof(staticTypes) != "undefined" && staticTypes!=''){
                                loadMap(staticTypes);
                            }
                        });

                        // 地图缩放时触发
                        MAP_ON_ZOOM_END = map.on("zoom-end", function(zobj) {
                            _curLevel = zobj.level;
//                            console.log("zoomLevel",_curLevel);
                        });

                        // 点击地图事件
                        MAP_ON_CLICK = map.on('click',function(e){
//                            console.log("click",e);
                        });
                    }

                    // 解除地图上的事件绑定
                    function unBindMapEvent() {
                        // 事件管理
                        if(MAP_ON_EXTENT_CHANGE)
                            MAP_ON_EXTENT_CHANGE.remove();
                        if(MAP_ON_ZOOM_END)
                            MAP_ON_ZOOM_END.remove();
                        if(MAP_ON_CLICK)
                            MAP_ON_CLICK.remove();

                        // 事件集合
                        if(G_DBL_CLICK_LIST) {
                            for(var e in G_DBL_CLICK_LIST){
                                G_DBL_CLICK_LIST[e].remove();
                            }
                        }

                        if(G_MOUSE_OVER_LIST) {
                            for(var e in G_MOUSE_OVER_LIST){
                                G_MOUSE_OVER_LIST[e].remove();
                            }
                        }

                        if(G_MOUSE_OUT_LIST) {
                            for(var e in G_MOUSE_OUT_LIST){
                                G_MOUSE_OUT_LIST[e].remove();
                            }
                        }
                    }

                    // 计算当前地图级别对应的所有比例尺
                    function _generateLods(map) {
                        var _lods = {};
                        var _maxLevel = map.getMaxZoom();
                        var _maxScale = map.getMaxScale();

                        while(_maxLevel > 0){
                            _lods[_maxLevel] = _maxScale;
                            _maxLevel--;
                            _maxScale=_maxScale*2;
                            if(_maxLevel == 0) {
                                break;
                            }
                        }
                        return _lods;
                    }

                    // 显示信息框
                    function _showToolbar(e) {
                        var type = e.graphic.geometry.type;
                        var screenp;
                        if(type == "polygon" || type == "polyline") {
                            var center = e.graphic.geometry.getExtent().getCenter();
                            screenp = screenUtils.toScreenPoint(map.extent,map.width,map.height,center);
                        } else {
                            screenp = screenUtils.toScreenPoint(map.extent,map.width,map.height,e.graphic.geometry);
                        }
                        showMouseBar(screenp.x - 75,screenp.y - 75);
                    }
                    //左侧树形页面调用
                    parentClaenMapData=function () {
                        _clearMap();
                        staticTypes='';
                    }
                    // 清空地图
                    function _clearMap() {
                        // 清空地图上的graphic
                        map.graphics.clear();

                        // 清空要素和标注
                        if(gLayers) {
                            for(var gl in gLayers) {
                                var _layer = map.getLayer(gLayers[gl]);
                                if(_layer) {
                                    _layer.clear();
                                }
                            }
                        }
                        if(tLayers) {
                            for(var tl in tLayers) {
                                var _layer = map.getLayer(tLayers[tl]);
                                if(_layer) {
                                    _layer.clear();
                                }
                            }
                        }
                        // 关闭信息框
                        hideMouseBar();

                        // 清空临时标注记录
                        __larray=[];
                    }

                    // 绘制并回避注记的叠加显示
                    var first = true;
                    function _graphicDraw(e){
                        for(var l in __larray) {
                            var isIntersect = false;
                            if(__larray[l].graphic.symbol.text == e.graphic.symbol.text) {
                                // 同名对象不回避
                                return;
                            }
                            var screenp = screenUtils.toScreenPoint(map.extent,map.width,map.height,__larray[l].graphic.geometry);
                            var target_screenp = screenUtils.toScreenPoint(map.extent,map.width,map.height,e.graphic.geometry);

                            var _x = screenp.x - target_screenp.x;
                            var _y = screenp.y - target_screenp.y;

                            if((-30 < _x && _x < 30) && (-30 < _y && _y < 30)){
                                isIntersect = true;
                            }
                            if(isIntersect) {
                                // 相交的隐藏
                                e.graphic.hide();
                                return;
                            }
                        }
                        // 否则，推送进标签库，用于继续比对
                        __larray.push(e);
                    }

                    // 转为wkt
                    function getWKT(geom)  {
                        var _wkt;
                        if(geom.type == "point") {
                            _wkt = PointToWKT(geom);
                        } else if(geom.type == "polyline") {
                            _wkt = LineToWKT(geom);
                        } else if(geom.type == "polygon") {
                            _wkt = PolygonToWKT(geom);
                        }
                        return _wkt;
                    }

                    /*
                     * 定位并缩放
                     */
                    function _locate(geom, zoom) {
                        var graphic, center;
                        if (geom.search("POINT") != -1) {
                            center = wkt2Point(geom);
                            graphic = new Graphic(center, new SimpleMarkerSymbol());
                        } else if (geom.search("LINESTRING") != -1) {
                            var line = wkt2Line(geom);
                            center = line.getExtent().getCenter();
                            graphic = new Graphic(line, new SimpleLineSymbol());
                        } else if (geom.search("POLYGON") != -1) {
                            var polygon = wkt2Polygon(geom);
                            center = polygon.getExtent().getCenter();
                            graphic = new Graphic(polygon, new SimpleFillSymbol());
                        }
                        map.graphics.clear();
                        map.graphics.add(graphic);
                        map.centerAt(center);
                        map.setZoom(zoom);
                    }

                    function showBar() {
                        $('#icon_toolbar').show();
                    }
                    function hideBar() {
                        $('#icon_toolbar').hide();
                    }
                    function hideMouseBar() {
                        $('#mouse_toolbar').hide();
                    }
                    function showMouseBar(_l,_t) {
                        hideMouseBar();
                        $('#mouse_toolbar').css({
                            left : _l + 'px',
                            top : _t + 'px'
                        }).animate({
                            opacity : 'show'
                        }, 300);
                        $("#map_copy32_but").zclip({
                            path:'${staticPath}/jquery/ZeroClipboard.swf',
                            copy:function () {
                                return _editGraphic.attributes.name;
                            }
                        });
                        $("#map_Document32_but").zclip({
                            path:'${staticPath}/jquery/ZeroClipboard.swf',
                            copy:function () {
                                return _editGraphic.attributes.name;
                            }
                        });
                    }
                });
    </script>
</head>
<body>
<div id="map"></div>
<input id="map_copy32_but_ct" type="hidden" value="222222222222">
<div id="mouse_toolbar">
    <img key="1" class="img_1" src="${staticPath}/website/images/Copy_32px.png" title="复制编号" id="map_copy32_but"/>
    <img key="2" class="img_2" src="${staticPath}/website/images/Document_32px.png" title="复制名称" id="map_Document32_but"/>
    <img key="3" class="img_3" src="${staticPath}/website/images/Cube_32px.png" title="三维仿真"/>
    <img key="4" class="img_4" src="${staticPath}/website/images/Go_In_32px.png" title="编辑位置"/>
    <img key="5" class="img_5" src="${staticPath}/website/images/Write_32px.png" title="编辑信息"/>
</div>

<ul id="icon_toolbar">
    <li>
        <img id="save" src="${staticPath}/website/images/go_24px.png" title="确定"/>
    </li>
    <li>
        <img id="close" src="${staticPath}/website/images/power_24px.png" title="取消"/>
    </li>
</ul>

<%--<div id="toobar">--%>
<%--<input id="save1" type="button" value="保存"/>--%>
<%--<input id="close2" type="button" value="关闭"/>--%>
<%--</div>--%>
</body>
</html>