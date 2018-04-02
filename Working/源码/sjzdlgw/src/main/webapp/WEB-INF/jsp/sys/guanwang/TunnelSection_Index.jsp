<%--
  Created by IntelliJ IDEA.
  User: zgq
  Date: 2016/12/5
  Time: 2:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <c:if test="${type eq 1}">
                <li controlID="2011"><a class="add" href="${ctxPath}/TunnelSection/addzj/{sid_TunnelSection}" target="dialog" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="400"><span>添加支架</span></a></li>
            </c:if>
            <c:if test="${type eq 2}">
                <li controlID="2011"><a class="add" href="${ctxPath}/TunnelSection/addDLGC/{sid_TunnelSection}" target="dialog" rel="TunnelSection_Index_01" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="400" height="200"><span>添加电缆管层</span></a></li>
            </c:if>
            <li controlID="2032"><a class="edit" href="${ctxPath}/TunnelSection/add/{sid_TunnelSection}" target="dialog" rel="TunnelSection_Index_01" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>修改</span></a></li>
            <li controlID="2032" class="line">line</li>
            <%--<li controlID="2033"><a class="edit" href="javascript:;" target="dialog" rel="TunnelSection_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>定位</span></a></li>--%>
            <li controlID="2034"><a class="icon" onclick="openNavtabSectionSimulation();"><span>断面仿真</span></a></li>
        </ul>
    </div>
    <div id="w_list_print">
        <table class="list" width="98%" targetType="navTab" asc="asc" desc="desc" layoutH="116">
            <thead>
            <tr>
                <th width="5">序号</th>
                <th width="50">长度（米）</th>
                <th width="50">走向</th>
                <th width="50">覆土深度</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${TunnelSectionListIndexPage}" var="li">
                <tr target="sid_TunnelSection" rel="${assetNum},${li.orderNum},${li.sectionNum}">
                    <td>${li.orderNum}</td>
                    <td>${li.length}</td>
                    <td>${li.tunnleTowardTypeStr}</td>
                    <td>${li.frontTopHeight}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <a id="openNavtabSectionSimulationHREF" style="display: none" href="${ctxPath}/sectionSimulation/index/{sid_TunnelSection}" target="navTab" title="断面仿真" external="true"></a>
</div>
<style>
    .xgzj,.xgzj2{
        float:left;
    }
</style>
<script>
$.ajaxSettings.global=false;
<c:if test="${type eq 1}">
    setTimeout(function(){
        $(".list").after(` <div class="xgzj newxs" style='width:100%;'>
        <div class='xgzj' style='width:100%;'>
                <div class='a-title'>
                    <div class='a-left'></div>
                    <div class='a-right'>支架</div>
                </div>
            <div class="panelBar">
                <%--<ul class="toolBar">--%>
                    <%--<li controlID="2011" style="width:72px;"><a class="edit" href="${ctxPath}/TunnelSection/editzj/{zj_TunnelSection}" target="dialog" rel="TunnelSection_Index_03" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="400"><span>修改支架</span></a></li>--%>
                    <%--<li controlID="2032" class="line">line</li>--%>
                    <%--<li controlID="2033" style="width:72px;"><a class="delete" href="${ctxPath}/TunnelSection/deletezj/{zj_TunnelSection}" target="ajaxTodo"title="确定要删除吗？" warn="请选择一条记录" ><span>删除</span></a></li>--%>
                <%--</ul>--%>
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
                <tbody class='xgzj_list'></tbody>
            </table>
        </div>`);
    },0);
    $("[target=sid_TunnelSection]").click(function(){
        var rel = $(this).attr('rel');
        $(".xgzj").loadUrl("${ctxPath}/TrestleLayer/zjindex",{"tddid":rel},function(){
            $(".xgzj_list").refresh();
//            $(".xgzj_list").html(data);
        });
    });
</c:if>
<c:if test="${type eq 2}">
    setTimeout(function(){
    $(".list").after(` <div class='xgzj_box'>
            <div class='xgzj' style='width:50%;'>
                <div class='a-title'>
                    <div class='a-left'></div>
                    <div class='a-right'>电缆管层</div>
                </div>
                <div class='panelBar'>
                    <%--<ul class="toolBar">--%>
                        <%--<li controlID="2011"><a class="add" href="${ctxPath}/TunnelSection/addDLGdlg/{TunnelSection_sid}" target="dialog" rel="TunnelSection_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="300" height="240"><span>添加电缆管</span></a></li>--%>
                        <%--<li><a class="edit" href="${ctxPath}/TunnelSection/editDLGC/{TunnelSection_sid}" target="dialog" rel="TunnelSection_Index_01" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>修改</span></a></li>--%>
                        <%--<li><a class="delete" href="${ctxPath}/TunnelSection/delete/{TunnelSection_sid}" target="ajaxTodo" title="确定要删除吗？" warn="请选择一个用户"><span>删除</span></a></li>--%>
                        <%--<li class="line">line</li>--%>
                    <%--</ul>--%>
                </div>
                <div id="table">
                    <table class="list" width="98%" targetType="navTab" asc="asc" desc="desc" layoutH="116">
                        <thead>
                        <tr>
                            <th width="50">层级</th>
                            <th width="50">高度(米)</th>
                        </tr>
                        </thead>
                        <tbody class="xgzj_list"></tbody>
                    </table>
                </div>
            </div>
            <div class="xgzj2" style='width:50%;'>
                <div class="a-title">
                    <div class="a-left"></div>
                    <div class="a-right">电缆管</div>
                </div>
                <div class="panelBar">
                    <%--<ul class="toolBar">--%>
                        <%--<li><a class="edit" href="${ctxPath}/TunnelSection/editDLG/{dlg_TunnelSection}?leary=${leary}" target="dialog" rel="TunnelSection_Index_01" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="400" height="200"><span>修改</span></a></li>--%>
                        <%--<li><a class="delete" href="${ctxPath}/TunnelSection/deleteDLG/{dlg_TunnelSection}" target="ajaxTodo" title="确定要删除吗？" warn="请选择一个用户"><span>删除</span></a></li>--%>
                        <%--<li class="line">line</li>--%>
                    <%--</ul>--%>
                </div>
                <div id="table">
                    <table class="list" width="98%" targetType="navTab" asc="asc" desc="desc" layoutH="116">
                        <thead>
                        <tr>
                            <th width="50">位置顺序</th>
                            <th width="50">排管规格</th>
                        </tr>
                        </thead>
                        <tbody class="xgzj2_list"></tbody>
                    </table>
           </div>
            </div>
        </div>`);
},0);
    $("[target=sid_TunnelSection]").click(function(){
        var rel = $(this).attr('rel');
        $(".xgzj").loadUrl("${ctxPath}/TrestleLayer/dlgcindex",{"tddid":rel},function(){
            $(".xgzj_list").refresh();
        });
    });
</c:if>
</script>

