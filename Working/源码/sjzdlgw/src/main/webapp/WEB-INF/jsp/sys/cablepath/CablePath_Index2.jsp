<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/23
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>
<style>
    .a-searchBar {
        width:100%;
        overflow: hidden;
    }
    .a-searchBar li {
        width:300px;
        height:30px;
        float:left;
    }
    select{width:213px;}
</style>

<script>
    <%--console.log(${pageForm.listDatas});--%>
    function dbclick() {
        console.log(1);
        $("#path_id_index4").click();
    }
</script>

<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/CablePath/2/index" method="post">
        <input type="hidden" name="idNum" value="${BaseFacilityVoltageLevel_CablePath}" />
        <div class="a-searchBar">
            <ul>
                <li>
                    线路编号：<input type="text" name="cablePathCode" value="${PageModelCablePathSearch.cablePathCode}" minlength="1" maxlength="20" size="30"/>
                </li>
                <li>
                    线路名称：<input type="text" name="cablePathName" value="${PageModelCablePathSearch.cablePathName}" minlength="1" maxlength="15" size="30"/>
                </li>
                <%--<li>--%>
                    <%--<a class="btnLook" href="${ctxPath}/CablePath/index/PowerCableLevel" lookupGroup="">查找带回</a>--%>
                    <%--电压等级--%>
                    <%--<input name="voltageLevelID" value="${PageModelCablePathSearch.voltageLevelID}" type="hidden">--%>
                    <%--<input name="voltageLevelName" value="${PageModelCablePathSearch.voltageLevelName}" type="text" size="30" readonly="true"/>--%>
                <%--</li>--%>
                <%--<li>--%>
                    <%--<a class="btnLook" href="${ctxPath}/CablePath/index/Area" lookupGroup="">查找带回</a>--%>
                    <%--线路区域：--%>
                    <%--<input name="areaNum" value="${PageModelCablePathSearch.areaNum}" type="hidden">--%>
                    <%--<input name="areaName" value="${PageModelCablePathSearch.areaName}" type="text" size="30" readonly="true"/>--%>
                <%--</li>--%>
                <%--<li>--%>
                    <%--<a class="btnLook" href="${ctxPath}/CablePath/index/Organization" lookupGroup="">查找带回</a>--%>
                    <%--运检班组：--%>
                    <%--<input name="organizationNum" value="${PageModelCablePathSearch.organizationNum}" type="hidden">--%>
                    <%--<input name="organizationName" value="${PageModelCablePathSearch.organizationName}" type="text" size="30" readonly="true"/>--%>
                <%--</li>--%>
                <li>
                    <label>电压等级：</label>
                    <select class="required" name="voltageLevelID" with="100">
                        <option value="">请选择</option>
                        <c:forEach items="${voltageLevelList}" var="item">
                            <option value="${item.voltageLevelID}" ${item.voltageLevelID eq PageModelCablePathSearch.getVoltageLevelID() ? 'selected="selected"' : ''}>${item.voltageLevelName}</option>
                        </c:forEach>
                    </select>
                </li>
                <li>
                    <label>线路区域：</label>
                    <select class="required" name="areaNum" with="100">
                        <option value="">请选择</option>
                        <c:forEach items="${areaList}" var="item">
                            <option value="${item.areaNum}" ${item.areaNum eq PageModelCablePathSearch.getAreaNum() ? 'selected="selected"' : ''}>${item.areaName}</option>
                        </c:forEach>
                    </select>
                </li>
                <li>
                    <label>变电站：</label>
                    <select class="required" name="baseFacilityNum" with="100">
                        <option value="">请选择</option>
                        <c:forEach items="${baseFacilityList}" var="item">
                            <option value="${item.baseFacilityNum}" ${item.baseFacilityNum eq PageModelCablePathSearch.getBaseFacilityNum() ? 'selected="selected"' : ''}>${item.baseFacilityName}</option>
                        </c:forEach>
                    </select>
                    <%--<a class="btnLook" href="${ctxPath}/CablePath/index/BaseFacilities" lookupGroup="">查找带回</a>--%>
                    <%--变电站：--%>
                    <%--<input name="baseFacilityNum" value="${PageModelCablePathSearch.baseFacilityNum}" type="hidden">--%>
                    <%--<input name="baseFacilityName" value="${PageModelCablePathSearch.baseFacilityName}" type="text" size="30" readonly="true"/>--%>

                </li>
                <li>
                    <label>运检班组：</label>
                    <select class="required" name="organizationNum" with="100">
                        <option value="">请选择</option>
                        <c:forEach items="${organizationList}" var="item">
                            <option value="${item.organizationNum}" ${item.organizationNum eq PageModelCablePathSearch.getOrganizationNum() ? 'selected="selected"' : ''}>${item.organizationName}</option>
                        </c:forEach>
                    </select>
                </li>
                <li>
                    <div class="buttonActive" style="margin-right:5px;  margin-left: 10px;">
                        <div class="buttonContent">
                            <button type="submit">查询</button>
                        </div>
                    </div>
                    <div class="buttonActive"><div class="buttonContent"><button type="reset">重置</button></div></div>
                </li>
            </ul>
            <%--<div class="subBar">--%>
                <%--<ul>--%>
                    <%--<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>--%>
                    <%--<li><div class="buttonActive"><div class="buttonContent"><button type="reset">重置</button></div></div></li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li controlID="3002"><a  id="path_id_index4" class="edit" href="${ctxPath}/CablePath/1/dbadd/{sid_CablePath}" target="dialog" rel="CablePath_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="true" drawable="true" width="800" height="500"><span>查看</span></a></li>

            <li controlID="4002"><a class="add" href="${ctxPath}/CablePath/2/add/-1" target="dialog" rel="CablePath_Index_01" title="线路添加" mask="true" minable="false" max="false" maxable="false" resizable="true" drawable="true" width="800" height="500"><span>添加</span></a></li>
            <li controlID="4002" class="line">line</li>
            <li controlID="4002"><a class="edit" href="${ctxPath}/CablePath/2/add/{sid_CablePath}" target="dialog" rel="CablePath_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="true" drawable="true" width="800" height="500"><span>修改</span></a></li>
            <li controlID="4002" class="line">line</li>
            <li controlID="4003"><a class="delete" href="${ctxPath}/CablePath/2/delete/{sid_CablePath}" target="ajaxTodo" rel="CablePath_Index_03" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li controlID="4003" class="line">line</li>
            <%--<li><a class="edit" href="${ctxPath}/CablePath/2/add/{sid_CablePath}" target="dialog" rel="CablePath_Index_04" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>添加线路段</span></a></li>--%>
            <%--<li class="line">line</li>--%>
            <%--<li><a class="edit" href="${ctxPath}/CablePath/2/add/{sid_CablePath}" target="dialog" rel="CablePath_Index_04" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>关联线路段</span></a></li>--%>
            <li controlID="4004"><a class="icon" href="${ctxPath}/CablePath/2/Export/excel?idNum=${BaseFacilityVoltageLevel_CablePath}" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
        </ul>
    </div>
    <table class="table" width="97%"  layoutH="87" l="desc">
        <thead>
        <tr>
            <th>序号</th>
            <th orderField="cablePathCode" class="asc|desc">线路编号</th>
            <th orderField="cablePathName" class="asc|desc">线路名称</th>
            <th orderField="baseFacilityName">变电站</th>
            <th orderField="voltageLevelName" class="asc|desc">电压等级</th>
            <th orderField="areaName" class="asc|desc">线路区域</th>
            <th orderField="organizationName" class="asc|desc">运检班组</th>
            <th orderField="">线路性质</th>
            <th orderField="layingMethod" class="asc|desc">敷设方式</th>
            <th orderField="lineCounts" class="asc|desc">总条数</th>
            <th orderField="loopCounts" class="asc|desc">总回长(千米)</th>
            <th orderField="loopLenghts" class="asc|desc">总长(千米)</th>
            <%--<th>操作</th>--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="li" varStatus="vs">
            <tr target="sid_CablePath" rel="${li.cablePathNum}" ondblclick="dbclick()">
                <td>${vs.index+1}</td>
                <td>${li.cablePathCode}</td>
                <td>${li.cablePathName}</td>
                <td>${li.baseFacilityName}</td>
                <td>${li.voltageLevelName}</td>
                <td>${li.areaName}</td>
                <td>${li.organizationName}</td>
                <td>配电</td>
                <td>${li.layingMethod}</td>
                <td>${li.lineCounts}</td>
                <td>${li.loopCounts}</td>
                <td>${li.loopLenghts}</td>
                <%--<td><a target="dialog" rel="CablePath_Index_04" href="${ctxPath}/CablePath/showQueryPathSelection/${li.cablePathNum}">查看</a></td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="panelBar">
        <div class="pages">
            <span>显示</span>
            <select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
                <c:forEach begin="20" end="100" step="20" varStatus="s">
                    <option value="${s.index}" ${pageForm.numPerPage eq
                            s.index ? 'selected="selected"' : ''}>
                            ${s.index}
                    </option>
                </c:forEach>
            </select>
            <span>条，共${pageForm.totalCount}条</span>
        </div>
        <div class="pagination" targetType="navTab" totalCount="${pageForm.totalCount}" numPerPage="${pageForm.numPerPage}" pageNumShown="10" currentPage="${pageForm.pageNum}"></div>
    </div>
</div>

