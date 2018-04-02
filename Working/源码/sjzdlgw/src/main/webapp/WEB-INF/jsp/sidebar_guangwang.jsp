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
<c:set var="staticPath" value="${pageContext.request.contextPath}/static"/>
<div class="accordion" fillSpace="sidebar">
    <div class="accordionHeader">
        <h2><span>Folder</span>管网台账</h2>
    </div>
    <div class="accordionContent">
        <ul class="ztree" id="guanwangTree_pageId"></ul>
    </div>
    <div class="accordionHeader">
        <h2><span>Folder</span>附属设施</h2>
    </div>
    <div class="accordionContent">
        <ul class="ztree" id="guanwangTree_fushusheshi_pageId"></ul>
    </div>
    <div class="accordionHeader">
        <h2><span>Folder</span>业务管理</h2>
    </div>
    <div class="accordionContent">
        <ul class="ztree" id="guanwangTree_yewuguanli_pageId"></ul>
    </div>
</div>
<script type="text/javascript">
    var ztreetool = null;
    var curStatus = "init", curAsyncCount = 0,curNodes;
    var setting = {
        view: {
            dblClickExpand: false,
            showLine: true,
            selectedMulti: false
        },
        async: {
            enable: true,
            url:"${ctxPath}/tree/Ledger",
            autoParam:["id", "type", "level"]
        },
        callback: {
            onClick: function (event, treeId, treeNode) {
                var rel=treeNode.rel;
                if (rel!=""){
                    rel='${ctxPath}'+rel;
                    var data={"idNum":treeNode.id};
                    if (treeNode.level==3){
                        data ={"idNum":treeNode.id,"idName":treeNode.name};
                    }else if (treeNode.level==4){
                        data={"cidnum":treeNode.id};
                    }else if(treeNode.level==5){
                        data={"idNum":treeNode.getParentNode().id,"type":treeNode.getParentNode().type};
                    }
                    navTab.openTab(rel,rel, {title:treeNode.name, fresh:true,data:data});
                }
            },
            beforeAsync: beforeAsync,
            onAsyncSuccess: onAsyncSuccess
        }
    };


    function beforeAsync() {
        curAsyncCount++;
    }
    function onAsyncSuccess(event, treeId, treeNode, msg) {
        if (curStatus == "expand") {
            expandNodes(curNodes,curAsyncCount-1);
        }
        if (curStatus == "init") {
            var zTree = $.fn.zTree.getZTreeObj("guanwangTree_pageId");
            curNodes=zTree.getNodes();
            expandNodes(curNodes,0);
        }
    }
    function expandNodes(nodes,i) {
        if (!nodes) return;
        curStatus = "expand";
        var zTree = $.fn.zTree.getZTreeObj("guanwangTree_pageId");
        zTree.expandNode(nodes[i], true, false, false);
        if (nodes.length==curAsyncCount-1){
            ztreetool = $.fn.zTree.init($("#guanwangTree_yewuguanli_pageId"), settingInspectTask);
        }
    }
    var setting2 = {
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
            }
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
            url:"${ctxPath}/tree/Business/-1",
            autoParam:["id","level", "target"]
        },
        callback: {
            onClick: function (event, treeId, treeNode) {
                var rel=treeNode.rel;
                if (rel!=""){
                    rel='${ctxPath}'+rel;
                    var data={};
                    if (treeNode.id.indexOf(",YEAR")>=0){
                        data.year=treeNode.name;
                    }
                    navTab.openTab(rel.split('?')[0],rel, {title:treeNode.name, fresh:true,data:data});
                }
            },
            beforeExpand : function (treeId, node) {
                ztreetool.reAsyncChildNodes(node, "refresh");
                return true;
            }
        }
    };

    var zNodes2 =[
       { id:100, pId:0, name:"工井台账",rel:"/ManholeLaborWell/index"},
        { id:110, pId:0, name:"防火墙",rel:"/FireWall/index"},
        { id:120, pId:0, name:"灭火装置",rel:"/Extinguisher/index"}
    ];
    $(document).ready(function(){
        $.fn.zTree.init($("#guanwangTree_pageId"), setting);
        $.fn.zTree.init($("#guanwangTree_fushusheshi_pageId"), setting2, zNodes2);
    });
</script>

