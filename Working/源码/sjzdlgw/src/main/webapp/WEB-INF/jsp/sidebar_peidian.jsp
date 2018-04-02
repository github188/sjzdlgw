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
        <ul class="ztree" id="peidianxianlutaizhangTree"></ul>
    </div>
    <div class="accordionHeader">
        <h2><span>Folder</span>线路设施</h2>
    </div>
    <div class="accordionContent">
        <ul class="ztree" id="peidianxianlusheshiTree_pageId"></ul>
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
            var zTree = $.fn.zTree.getZTreeObj("peidianxianlutaizhangTree");
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
            url:"${ctxPath}/tree/CablePath/3",
            autoParam:["id","level", "target"]
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
    var zNodes2 =[
        { id:100, pId:0, name:"设施档案",rel:"/CableDeviceLedger/distribution/index",controlID:"4300"},
        { id:110, pId:0, name:"本体台账",rel:"/CableAttachment/distribution/section/index/index",controlID:"4400"},
        { id:120, pId:0, name:"终端台账",rel:"/CableAttachment/distribution/terminal/index/index",controlID:"4500"},
        { id:130, pId:0, name:"接头台账",rel:"/CableAttachment/distribution/connector/index/index",controlID:"4600"}
    ];
    var zNodes3 =[
        { id:100, pId:0, name:"电缆敷设",rel:""},
        { id:110, pId:0, name:"验收管理",rel:"/CableInspecteManage/2/index"}
    ];
    var setting2 = {
        view: {
            dblClickExpand: false,
            showLine: true,
            selectedMulti: false,
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
                console.log(treeId+"=="+rel);
                if (rel!=""){
                    rel='${ctxPath}'+rel;
                    console.log(treeId+"=="+rel);
                    navTab.openTab(rel,rel, {title:treeNode.name, fresh:true});
                }
            },
            beforeExpand : function (treeId, node) {
                ztreetoolBusiness.reAsyncChildNodes(node, "refresh");
//                ztreetool.updateNode (node);
                return true;
            }
        }
    };
    var settingInspectTask={
        view: {
            dblClickExpand: false,
            showLine: true,
            selectedMulti: false,
            addDiyDom: addDiyDom
        },
        async: {
            enable: true,
            url:"${ctxPath}/tree/Business/2",
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
                    console.log(treeId+"=="+rel);
                    navTab.openTab(rel.split('?')[0],rel, {title:treeNode.name, fresh:true,data:data});
                }
            },
            foreExpand : function (treeId, node) {
                ztreetoolBusiness.reAsyncChildNodes(node, "refresh");
//                ztreetool.updateNode (node);
                return true;
            }
        }
    };
    $(document).ready(function(){
        ztreetool = $.fn.zTree.init($("#peidianxianlutaizhangTree"), setting);
        $.fn.zTree.init($("#peidianxianlusheshiTree_pageId"), setting2, zNodes2);
//        $.fn.zTree.init($("#bussinessManageTree"), setting2, zNodes3);
        ztreetoolBusiness = $.fn.zTree.init($("#bussinessManageTree"), settingInspectTask);
        removeNotHaveAuthNode();
    });
</script>
