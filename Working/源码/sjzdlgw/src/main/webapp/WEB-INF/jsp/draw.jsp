<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2016/11/28
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>ArcGIS 地图调用</title>
    <!-- 使用ArcGIS在线API，内网使用需要本地化部署 -->
    <link rel="stylesheet" href="http://115.159.104.25:8080/apis/arcgis_js_api/esri/css/esri.css">
    <script src="http://115.159.104.25:8080/apis/arcgis_js_api/init.js"></script>
    <script src="${staticPath}/dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
    <script type="text/javascript" src="${staticPath}/website/js/WKTUtil.js"></script>

    <script type="text/javascript">
        require(
                [ "esri/map", "esri/toolbars/draw", "esri/toolbars/edit",
                    "esri/graphic", "esri/SpatialReference",
                    "esri/layers/ArcGISTiledMapServiceLayer",
                    "esri/layers/WebTiledLayer", "esri/layers/GraphicsLayer",
                    "esri/geometry/webMercatorUtils", "esri/geometry/Point",
                    "esri/geometry/Polyline", "esri/geometry/Polygon",
                    "esri/symbols/SimpleMarkerSymbol",
                    "esri/symbols/SimpleLineSymbol",
                    "esri/symbols/SimpleFillSymbol",
                    "esri/symbols/PictureMarkerSymbol", "esri/Color",
                    "esri/dijit/editing/Editor", "esri/symbols/TextSymbol",
                    "esri/InfoTemplate", "dojo/on", "dojo/domReady!" ],
                function(Map, Draw, Edit, Graphic, SpatialReference,
                         ArcGISTiledMapServiceLayer, WebTiledLayer, GraphicsLayer,
                         webMercatorUtils, Point, Polyline, Polygon,
                         SimpleMarkerSymbol, SimpleLineSymbol, SimpleFillSymbol,
                         PictureMarkerSymbol, Color, Editor, TextSymbol,
                         InfoTemplate, on) {

                    var server = "http://localhost:8080/";
                    var PBS_BASE_MAP = "http://49.4.174.35:7080/PBS/rest/services/MapsRoad/MapServer";
                    var DEFAULT_SRID = 4326; //系统默认坐标系

                    var drawToolBar, editToolbar;

                    var __geom;

                    // 数据坐标系统
                    var SRID_4326 = new SpatialReference(DEFAULT_SRID);

                    // 初始化地图对象
                    var map = new Map("map", {
                        center : [ 114.529615764554, 38.0238827890626 ],
                        zoom : 16,
                        logo : false
                    });

                    map.on("load", function() {
                        $(document).ready(jQueryReady);
                        map.disableDoubleClickZoom();//禁止双击缩放

                        drawToolBar = new Draw(map); //初始化绘制工具
                        drawToolBar.on("draw-end", addToMap);

                        editToolbar = new Edit(map);
                    });

                    // 添加底图图层
                    var basemap = new ArcGISTiledMapServiceLayer(PBS_BASE_MAP);
                    map.addLayer(basemap);

                    // 开始绘制
                    function activateTool(type) {
                        map.graphics.clear();
                        drawToolBar.activate(type);
                        map.hideZoomSlider();
                    }

                    // 绘制到地图
                    function addToMap(evt) {
                        var symbol;
                        switch (evt.geometry.type) {
                            case "point":
                            case "multipoint":
                                symbol = new SimpleMarkerSymbol();
                                break;
                            case "polyline":
                                symbol = new SimpleLineSymbol();
                                break;
                            default:
                                symbol = new SimpleFillSymbol();
                                break;
                        }
                        __geom = evt.geometry;
                        var graphic = new Graphic(evt.geometry, symbol);
                        map.graphics.add(graphic);
                        drawToolBar.deactivate();
                        activateToolbar(graphic);
                    }

                    function activateToolbar(graphic) {
                        var tool = 0;
                        tool = tool | Edit.MOVE;
                        tool = tool | Edit.EDIT_VERTICES;
                        tool = tool | Edit.SCALE;
                        tool = tool | Edit.ROTATE;
                        editToolbar.activate(tool, graphic);
                    }

                    function _clear(e) {
                        drawToolBar.deactivate();
                        editToolbar.deactivate();
                        map.graphics.clear();
                        map.showZoomSlider();
                    }

                    function jQueryReady() {
                        $('.draw').on('click', function(e) {
                            activateTool(e.target.id);
                        });

                        $('#clear').on('click', _clear);

                        $('#submit').on('click', function(e) {
                            // 添加父窗口回调方法 回传结果
                            var wkt;
                            if(__geom.type == "point") {
                                wkt = PointToWKT(__geom);
                            } else if(__geom.type == "polyline") {
                                wkt = LineToWKT(__geom);
                            } else if(__geom.type == "polygon") {
                                wkt = PolygonToWKT(__geom);
                            }
                            console.log(wkt);
                        });
                    }

                });
    </script>
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

        #buttons {
            position: absolute;
            right: 10px;
            top: 10px;
        }
    </style>
</head>
<body>
<div id="map"></div>
<div id="buttons">
    <button id="point" class="draw">画点</button>
    <button id="polyline" class="draw">画线</button>
    <button id="polygon" class="draw">画面</button>
    <button id="clear">重置</button>
    <button id="submit">确定</button>
</div>
</body>
</html>
