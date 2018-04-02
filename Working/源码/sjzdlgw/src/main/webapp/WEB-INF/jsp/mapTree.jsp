<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2016/10/21
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<c:set var="staticPath" value="${pageContext.request.contextPath}/static"/>
<div class="accordion" fillSpace="sidebar">
    <div class="accordionContent">
        <ul class="ztree" id="mapTree_pageId"></ul>
    </div>
</div>

<script>

    function showIconForTree(treeId, treeNode) {
        var name=treeNode.name;
        if (name.indexOf("<span")>-1){
            return false;
        }
        return true;
    };
    var setting = {
        view: {
            dblClickExpand: false,
            showLine: true,
            selectedMulti: false,
            nameIsHTML: true,
            showIcon: showIconForTree
        },
        check: {
            enable: true
        },
        data: {
            simpleData: {
                enable:true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: ""
            }
        },
        callback: {
            onClick: function (event, treeId, treeNode) {
                //设置checkbox checked
                var mapTree = $.fn.zTree.getZTreeObj(treeId);
                mapTree.checkNode(treeNode,!treeNode.checked,true);
                changeCheckGetMap();
            },
            onCheck:function (event, treeId, treeNode) {
                changeCheckGetMap();
            }
        }
    };
    $(document).ready(function(){
        $.fn.zTree.init($("#mapTree_pageId"), setting, ${TreeMapPageData});
    });

    function changeCheckGetMap() {
        var zTree = $.fn.zTree.getZTreeObj("mapTree_pageId");
        var nodes=zTree.getCheckedNodes(true);
        var checkCount = nodes.length;
        var types="";
        if (checkCount>0){
            $.each(nodes,function (key,item) {
                types=types+item.type+",";
            });
            document.getElementById('wasptmsMapPage').contentWindow.loadMap(types);
        }else{
            document.getElementById('wasptmsMapPage').contentWindow.parentClaenMapData();
        }
    }
</script>