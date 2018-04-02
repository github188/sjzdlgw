<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2016/9/29
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<div class="accordion" fillSpace="sidebar">
    <div class="accordionHeader">
        <h2><span>Folder</span>线路台账</h2>
    </div>
    <div class="accordionContent">
        <ul class="ztree" id="shudianxianlutaizhangTree"></ul>
    </div>
    <div class="accordionHeader">
        <h2><span>Folder</span>线路设施</h2>
    </div>
    <div class="accordionContent">
        <ul class="ztree" id="shudianxianlusheshiTree_pageId"></ul>
    </div>
    <div class="accordionHeader">
        <h2><span>Folder</span>业务管理</h2>
    </div>
    <div class="accordionContent">
        <ul class="ztree" id="bussinessManageTree"></ul>
    </div>
</div>
<script>
    var curStatus = "init";
    function sidebarShudianOnSuccess() {
        removeNotHaveAuthNode(); //todo 未测试动态加载的ztree节点是否能够成功删除
        //手动展开
        if (curStatus == "init") {
            curStatus = "expand";
            var zTree = $.fn.zTree.getZTreeObj("shudianxianlutaizhangTree");
            curNodes=zTree.getNodes();
            zTree.expandNode(curNodes[0], true, false, false);
        }
    }
    var ztreetool = null;
    var ztreetoolBusiness = null;
    var setting = {
        view: {
            dblClickExpand: false,
            showLine: true,
            selectedMulti: false,
            addDiyDom: addDiyDom
        },
        async: {
            enable: true,
            url:"${ctxPath}/tree/CablePath/2",
            autoParam:["id","level"]
        },
        callback: {
            onClick: function (event, treeId, treeNode) {
                var rel=treeNode.rel;
                if (rel!=""){
                    rel='${ctxPath}'+rel;
                    navTab.openTab(rel,rel, {title:treeNode.name, fresh:true,data:{"idNum":treeNode.id}});
                }
            },
            beforeExpand : function (treeId, node) {
                ztreetool.reAsyncChildNodes(node, "refresh");
//                ztreetool.updateNode (node);
                return true;
            },
            onAsyncSuccess: sidebarShudianOnSuccess
        }
    };
//    function addDiyDom(treeId, treeNode) { //为ztree的节点添加自定义dom的controlID属性
////        $("#" + treeNode.tId).attr("controlIDs","4000")
//        var aObj = $("#" + treeNode.tId );
//        var controlidTmp = treeNode.controlID;
//        if(controlidTmp==null) return;
////        console.log(controlidTmp);
//        aObj.attr("controlID",controlidTmp);
////        console.log(aObj);
//    }
    var setting2 = {
        view:{
            addDiyDom: addDiyDom
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            onClick: function (event, treeId, treeNode) {
                var rel=treeNode.rel;
                if (rel!=""){
                    rel='${ctxPath}'+rel;
                    navTab.openTab(rel,rel, {title:treeNode.name, fresh:true});
                }
            },
//            onAsyncSuccess: zTreeOnAsyncSuccess
        }
    };
    var settingInspectTask={
        view: {
            dblClickExpand: false,
            showLine: true,
            selectedMulti: false
        },
        async: {
            enable: true,
            url:"${ctxPath}/tree/Business/1",
            autoParam:["id","level", "target"]
        },
        callback: {
            onClick: function (event, treeId, treeNode) {
                var rel=treeNode.rel;
                if (rel!=""){
                    rel='${ctxPath}'+rel;
                    var data={}
                    if(treeNode.id.indexOf(",YEAR")>=0){
                        data.year=treeNode.name;
                    }
                    navTab.openTab(rel.split('?')[0],rel, {title:treeNode.name, fresh:true,data:data});
                }
            },
            beforeExpand : function (treeId, node) {
                ztreetoolBusiness.reAsyncChildNodes(node, "refresh");
//                ztreetool.updateNode (node);
                return true;
            }
        }
    };
    var zNodes2 =[
        { id:100, pId:0, name:"设施档案",rel:"/CableDeviceLedger/transmission/index",controlID:"3300"},
        { id:110, pId:0, name:"本体台账",rel:"/CableAttachment/transmission/section/index/index",controlID:"3400"},
        { id:120, pId:0, name:"终端台账",rel:"/CableAttachment/transmission/terminal/index/index",controlID:"3500"},
        { id:130, pId:0, name:"接头台账",rel:"/CableAttachment/transmission/connector/index/index",controlID:"3600"},
        { id:140, pId:0, name:"接地箱",rel:"/CableAttachment/EarthBox/index",controlID:"3700"}
    ];
    var zNodes3 =[
        { id:100, pId:0, name:"验收管理",rel:"/CableInspecteManage/1/index"}
    ];
    $(document).ready(function(){
        ztreetool = $.fn.zTree.init($("#shudianxianlutaizhangTree"), setting);
        $.fn.zTree.init($("#shudianxianlusheshiTree_pageId"), setting2, zNodes2);
//        $.fn.zTree.init($("#bussinessManageTree"), setting2, zNodes3);
        ztreetoolBusiness = $.fn.zTree.init($("#bussinessManageTree"), settingInspectTask);
    });
//    function zTreeOnAsyncSuccess() {
//        removeNotHaveAuthNode(); //todo 未测试动态加载的ztree节点是否能够成功删除
//    }
</script>