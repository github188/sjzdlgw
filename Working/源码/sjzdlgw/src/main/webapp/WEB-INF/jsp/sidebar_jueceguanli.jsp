<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2016/9/17
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<c:set var="staticPath" value="${pageContext.request.contextPath}/static"/>
<%--<div class="accordion" fillSpace="sidebar">--%>
    <%--<div class="accordionContent">--%>
        <%--<ul class="tree treeFolder collapse">--%>
            <%--<li><a href="${ctxPath}/LedgerStatistics/index" target="navTab" rel="sidebar_jueceguanli_01">档案分析</a></li>--%>
            <%--<li><a href="javascript:void(0);" target="navTab" rel="sidebar_jueceguanli_02">通道分析</a></li>--%>
            <%--<li><a href="javascript:void(0);" target="navTab" rel="sidebar_jueceguanli_03">工井/终端分析</a></li>--%>
            <%--<li><a href="javascript:void(0);" target="navTab" rel="sidebar_jueceguanli_04">通道长度统计</a></li>--%>
            <%--<li><a href="javascript:void(0);" target="navTab" rel="sidebar_jueceguanli_05">工井/终端统计</a></li>--%>
            <%--<li><a href="${ctxPath}/BranchBoxStatistics/index" target="navTab" rel="sidebar_jueceguanli_06">分接箱统计</a></li>--%>
            <%--<li><a href="javascript:void(0);" target="navTab" rel="sidebar_jueceguanli_07">回路统计</a></li>--%>
            <%--<li><a href="javascript:void(0);" target="navTab" rel="sidebar_jueceguanli_08">敷设占用分析</a></li>--%>
        <%--</ul>--%>
    <%--</div>--%>
<%--</div>--%>

<div class="accordion" fillSpace="sidebar">
    <div class="accordionHeader">
        <h2><span>Folder</span>决策管理</h2>
    </div>
    <div class="accordionContent">
        <ul class="ztree" id="jueceguanliTree_pageId"></ul>
    </div>
    <div class="accordionHeader">
        <h2><span>Folder</span>健康管理</h2>
    </div>
    <div class="accordionContent">
        <%--<ul class="ztree" id="guanwangTree_fushusheshi_pageId"></ul>--%>
    </div>
</div>
<script>
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
            }
        }
    };
    var zNodes2 =[
        { id:100, pId:0, name:"档案分析",rel:"/LedgerStatistics/index",controlID:"6100"},
        { id:110, pId:0, name:"通道分析",rel:"/PowerTunnelStatistics/index",controlID:"6200"},
        { id:120, pId:0, name:"工井/终端分析",rel:"/ManholeLaborWellAnalysis/index",controlID:"6300"},
        { id:130, pId:0, name:"通道长度统计",rel:"/LedgerLengthStatistics/index",controlID:"6400"},
        { id:140, pId:0, name:"工井/终端统计",rel:"/ManholeAndTerminalStatistics/index",controlID:"6500"},
        { id:150, pId:0, name:"分接箱统计",rel:"/BranchBoxStatistics/index",controlID:"6600"},
        { id:160, pId:0, name:"回路统计",rel:"/PowerLoopStatistics/index",controlID:"6700"},
        { id:170, pId:0, name:"敷设占用分析",rel:"/LayingOccupationStatistics/index",controlID:"6800"}
    ];
//    var zNodes3 =[
//        { id:100, pId:0, name:"验收管理",rel:""}
//    ];
    $(document).ready(function(){
        $.fn.zTree.init($("#jueceguanliTree_pageId"), setting2, zNodes2);
        removeNotHaveAuthNode();
//        $.fn.zTree.init($("#guanwangTree_yewuguanli_pageId"), setting2, zNodes3);
    });

</script>