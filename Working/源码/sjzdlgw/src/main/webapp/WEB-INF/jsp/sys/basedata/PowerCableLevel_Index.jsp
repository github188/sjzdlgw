<%--
  Created by IntelliJ IDEA.
  User: pak2c
  Date: 16/10/9
  Time: 下午7:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="${ctxPath}/PowerCableLevel/index">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>


<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">

            <%--<li><a class="edit" href="${ctxPath}/PowerCableLevel/add/{sid_pcl}" target="dialog" rel="FlawAduitStatus_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>修改</span></a></li>--%>
            <%--<li class="line">line</li>--%>
            <%--<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>--%>

            <li controlID="7002"><a class="add" href="${ctxPath}/PowerCableLevel/add/-1" target="dialog" rel="ManholeKindType_Index_01" title="电压等级添加" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="200" height="220"><span>添加</span></a></li>
            <li controlID="7002" class="line">line</li>
            <li controlID="7002" ><a class="edit" href="${ctxPath}/PowerCableLevel/add/{sid_pcl}" target="dialog" rel="ManholeKindType_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="200" height="220"><span>修改</span></a></li>
            <li controlID="7002" class="line">line</li>
            <li controlID="7003"><a class="delete" href="${ctxPath}/PowerCableLevel/delete/{sid_pcl}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li controlID="7003" class="line">line</li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="50" asc="asc" desc="desc">
        <thead>
        <tr>
            <th orderField="voltageLevelID" class="asc" width="40" align="center">序号</th>
            <th>电压等级</th>
            <th>电压值(千伏)</th>
            <th>颜色</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
            <tr target="sid_pcl" rel="${ob.voltageLevelID}">
                <td>${ob.voltageLevelID}</td>
                <td>${ob.voltageLevelName}</td>
                <td>${ob.voltageValue}</td>
                <td><input type="text" disabled="disabled" style='border-left:0px;border-top:0px;border-right:0px;border-bottom:0px; background-color:${ob.showColor}'/></td>
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


