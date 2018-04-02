<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<div class="">
    <div class="a-title">
        <div class="a-left"></div>
        <div class="a-right">电缆管层</div>
    </div>
    <div class="panelBar">
        <ul class="toolBar">
            <li controlID="2011"><a class="add" href="${ctxPath}/TunnelSection/addDLGdlg/{TunnelSection_sid}" target="dialog" rel="TunnelSection_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="300" height="240"><span>添加电缆管</span></a></li>
            <li><a class="edit" href="${ctxPath}/TunnelSection/editDLGC/{TunnelSection_sid}" target="dialog" rel="TunnelSection_Index_01" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="400" height="200"><span>修改</span></a></li>
            <li><a class="delete" href="${ctxPath}/TunnelSection/delete/{TunnelSection_sid}" target="ajaxTodo" title="确定要删除吗？" warn="请选择一个用户"><span>删除</span></a></li>
            <li class="line">line</li>
        </ul>
    </div>

    <div id="table">
        <table class="list" width="98%" targetType="navTab" asc="asc" desc="desc" layoutH="116">
            <thead>
            <tr>
                <th width="50">层级</th>
                <th width="50">高度(米)</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${trestleLayerList}" var="li">
                <tr target="TunnelSection_sid" rel="${li.trestleLayerNum}_${li.layer}">
                    <td>${li.layer}</td>
                    <td>${li.height}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script>
    <%--$("[target=TunnelSection_sid]").click(function(){--%>
        <%--var rel = $(this).attr('rel');--%>
        <%--setTimeout(function(){--%>
            <%--$(".xgzj2").loadUrl("${ctxPath}/RowTubeTypeDLG/index",{"tddid":rel},function(){--%>
                <%--$(".xgzj2").refresh();--%>
            <%--});--%>
        <%--},0);--%>

//    });
    $("[target=TunnelSection_sid]").click(function(){
        var rel = $(this).attr('rel');
        $(".xgzj2").loadUrl("${ctxPath}/DLG/index",{"tddid":rel},function(){
            $(".xgzj2_list").refresh();
        });
    });
</script>