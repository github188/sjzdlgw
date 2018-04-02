
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<div class="pageContent newxs">
    <div class='xgzj' style='width:100%;'>
        <div class='a-title'>
            <div class='a-left'></div>
            <div class='a-right'>支架</div>
        </div>
    <div class="panelBar">
        <ul class="toolBar">
            <li controlID="2011" style="width:72px;"><a class="edit" href="${ctxPath}/TunnelSection/editzj/{zj_TunnelSection}" target="dialog" rel="TunnelSection_Index_03" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="400"><span>修改支架</span></a></li>
            <li controlID="2032" class="line">line</li>
            <li controlID="2033" style="width:72px;"><a class="delete" href="${ctxPath}/TunnelSection/deletezj/{zj_TunnelSection}" target="ajaxTodo"title="确定要删除吗？" warn="请选择一条记录" ><span>删除</span></a></li>
        </ul>
    </div>
    <table class="list" targetType="navTab"width="100%" layoutH="76" asc="asc" desc="desc">
        <thead>
            <tr>
                <th width="5">层级</th>
                <th width="50">电压等级</th>
                <th width="50">方位</th>
                <th width="50">长度</th>
                <th width="50">高度</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${zjtrestleLayerList}" var="li">
                <tr target="zj_TunnelSection" rel="${li.trestleLayerNum}" id="add_zj">
                    <td>${li.layer}</td>
                    <td>${li.voltageLevelName}</td>
                    <td>${li.trestlePositionTypeName}</td>
                    <td>${li.trestleLength}</td>
                    <td>${li.height}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</div>