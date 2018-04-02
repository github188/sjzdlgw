<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<!DocType html>
<html lang="en-us">
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style>
        /* a style sheet needs to be present for cursor hiding and custom cursors to work. */
        /*这里可以定义Unity的CSS样式，跟普通的前端开发是一样的*/
        .container{
            margin:0 auto;
            width:1280px;
        }
        #canvas{
            border:1px solid black;
        }
    </style>
</head>
<body>

<div class="container">
    <!-- 这里是Unity的Canvas绘图 -->
    <canvas class="emscripten" id="canvas" oncontextmenu="event.preventDefault()" height="720px" width="1280px"></canvas>
</div>
<script type='text/javascript'>
    var Module = {
        TOTAL_MEMORY: 268435456,
        errorhandler: null,			// arguments: err, url, line. This function must return 'true' if the error is handled, otherwise 'false'
        compatibilitycheck: null,
        backgroundColor: "#FFFFFF",
        splashStyle: "Dark",
        dataUrl: "${staticPath}/website/Release/Tunnel.data",
        codeUrl: "${staticPath}/website/Release/Tunnel.js",
        asmUrl: "${staticPath}/website/Release/Tunnel.asm.js",
        memUrl: "${staticPath}/website/Release/Tunnel.mem"
    };
</script>
<script src="${staticPath}/website/Release/UnityLoader.js"></script>
<script type="text/javascript">
    //3D加载完成状态
//    var SectionSimulation3DOK=0;
    //3D程序初始化完成
    <%--function CallWebGL_InitWebGL() {--%>
        <%--SendMessage ('[WebGLUnityBridge]','CallUnity_InitHost','http://localhost:8080'); //传入初始化主机接口，就是接口服务器的IP地址，用于调试，--%>
        <%--SendMessage ('[WebGLUnityBridge]','CallUnity_RenderTunnel','{"assetNum":${assetNum},"tunnelSectionOrder":${tunnelSectionOrder}}');--%>
        <%--SendMessage ('[WebGLUnityBridge]','CallUnity_InitAuthority','{"horizontal":true,"vertical":true,"heap":true,"removeLay":true}'); //传入权限接口--%>
<%--//        SectionSimulation3DOK=1;--%>
    <%--}--%>
    //3D初始化完成，重新渲染模型
//    function setSectionSimulationData(assetNum,tunnelSectionOrder) {
//        if (SectionSimulation3DOK){
//            SendMessage ('[WebGLUnityBridge]','CallUnity_RenderTunnel','{"assetNum":'+assetNum+',"tunnelSectionOrder":'+tunnelSectionOrder+'}');
//        return true;
//        }
//        return false;
//    }
    function CallUnity_ReRenderTunnel() {
        SendMessage ('[WebGLUnityBridge]','CallUnity_ReRenderTunnel','{"assetNum":${assetNum},"tunnelSectionOrder":${tunnelSectionOrder}}'); //重新渲染模型
        SendMessage ('[WebGLUnityBridge]','CallUnity_InitAuthority','{\"horizontal\":true,\"vertical\":false,\"heap\":false,\"removeLay\":true}'); //传入权限
    }
    //Unity 初始化调用-------------------
    function CallWebGL_InitWebGL()
    {
        SendMessage ('[WebGLUnityBridge]','CallUnity_InitHost','http://localhost:8080'); //传入初始化主机接口，就是接口服务器的IP地址，用于调试，
        CallUnity_ReRenderTunnel(); //Unity 启动后自动调用这里
    }
    //End--------------------------------
</script>
</body>
</html>
