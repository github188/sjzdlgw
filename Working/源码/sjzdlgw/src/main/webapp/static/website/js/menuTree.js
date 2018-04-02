
function startAjaxLoading_map() {
    var ajaxbg = $("#background,#progressBar");
    ajaxbg.show();
}

function endAjaxLoading_map() {
    var ajaxbg = $("#background,#progressBar");
    ajaxbg.hide();
}

//动态设定地图高
function mapChangeFrameHeight() {
    var ifm= document.getElementById("wasptmsMapPage");
    ifm.height=document.documentElement.clientHeight;
}

//动态设定地图高
function DDDChangeFrameHeight() {
    var ifm= document.getElementById("xsw3Dpage");
    ifm.height=document.documentElement.clientHeight;
}


function onloadMapPage() {
    startAjaxLoading_map();
    var iframeMap = document.getElementById("wasptmsMapPage");
    iframeMap. onload = iframeMap. onreadystatechange = function () {
        //加载完成后加载树
        if (!iframeMap.readyState || iframeMap.readyState == "complete") {
            endAjaxLoading_map();
            $("#map_index").click();
        }
    };
    iframeMap.src ="/map";
}
//打开地图数据
function mapPageOpenDailog(ctxPath,gemo) {
    var param="id="+gemo.id+"&type="+gemo.type;
    var height=600;
    if (gemo.type=="geometric"){
        height=185;
    }else if (gemo.type=="line"){
        var ids=gemo.id.split('_');
        param="id="+ids[0]+"&tsid="+ids[1]+"&type="+gemo.type;
    }
    $.pdialog.open(ctxPath+"/map/showData?"+param, "/map/showData_999", "编辑信息",{mask:true,minable:false,max:false,maxable:false,resizable:false,drawable:true,width:800,height:height});
}
//退出
function index_logout_a(event) {
    alertMsg.confirm("您确认退出系统吗？",{okCall:function () {
        location.href="/logout";
    }});
    event.preventDefault();
}

//打开3D页面
//全局变量，当前3D页面rel id值
function openNavtabSectionSimulation() {
    var ids=$("#sid_TunnelSection").val();
    if(ids){
        //3D页面已经打开
        if(navTab._indexTabId("openNavtabSectionSimulation")>=0){
           //设置焦点

            //发送重新构造3d模型请求
            $("#openNavtabSectionSimulationHREF").click();
        }else{
            // navTab.openTab("openNavtabSectionSimulation",ctxPath+"/sectionSimulation/index", {title:"截面仿真",fresh:false,data:{"assetNum":ids[0],"tunnelSectionOrder":ids[1]}});
            $("#openNavtabSectionSimulationHREF").click();
        }
    }else{
        alertMsg.warn("请选择一条记录！");
    }
}

///地图页面打开截面仿真页面
function mapOpen3dPage(ids) {
    var href=$("#openNavtabSectionSimulationHREFMap").attr("href")+ids;
    $("#openNavtabSectionSimulationHREFMap").attr("href",href);
    $("#openNavtabSectionSimulationHREFMap").click();
}