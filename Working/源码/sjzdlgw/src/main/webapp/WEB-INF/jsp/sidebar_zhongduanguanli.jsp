<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2016/9/29
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
            <%--<li><a href="${ctxPath}/BaseFacility/index" target="navTab" rel="sidebar_zhongduanguanli_01">变电站</a></li>--%>
            <%--<li><a href="${ctxPath}/Manhole/index" target="navTab" rel="sidebar_zhongduanguanli_02">终端设施</a></li>--%>
            <%--<li><a href="${ctxPath}/BranchBox/index" target="navTab" rel="sidebar_zhongduanguanli_03">分接箱</a></li>--%>
        <%--</ul>--%>
    <%--</div>--%>
<%--</div>--%>
<div class="accordion" fillSpace="sidebar">
    <div class="accordionContent">
        <ul class="ztree" id="zhongduanguanliTree_pageId"></ul>
    </div>
</div>
<script>
    var setting = {
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
            onAsyncSuccess: zTreeOnAsyncSuccess
        }
    };
//    function zTreeOnAsyncSuccess() {
//        console.info("onasyncsusseeeee...............")
//        removeNotHaveAuthNode(); //todo 未测试动态加载的ztree节点是否能够成功删除
//    }
//
//    function addDiyDom(treeId, treeNode) { //为ztree的节点添加自定义dom的controlID属性
////        $("#" + treeNode.tId).attr("controlIDs","4000")
//        var aObj = $("#" + treeNode.tId );
//        var controlidTmp = treeNode.controlID;
//        if(controlidTmp==null) return;
//        console.log(controlidTmp);
//        aObj.attr("controlID",controlidTmp);
//        console.log(aObj);
//    }
    var zNodes =[
        { id:200, pId:0, name:"变电站",rel:"/BaseFacility/index",controlID:"5100"},
        { id:201, pId:0, name:"终端设施",rel:"/Manhole/index",controlID:"5200"},
        { id:202, pId:0, name:"分接箱",rel:"/BranchBox/index",controlID:"5300"}
    ];
    $(document).ready(function(){
        $.fn.zTree.init($("#zhongduanguanliTree_pageId"), setting, zNodes);
        removeNotHaveAuthNode();
    });

</script>