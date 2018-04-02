<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="${ctxPath}/ProjectType/index">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>

<%--<div class="pageHeader">--%>
<%--<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/ProjectType/index" method="post">--%>
<%--<div class="searchBar">--%>
<%--<table class="searchContent">--%>
<%--<tr>--%>
<%--<td>--%>
<%--设施类型：<input type="text" name="manholeKindTypeName" value="${manholeKindTypeName}" minlength="1" maxlength="5"/>--%>
<%--</td>--%>
<%--</tr>--%>
<%--</table>--%>

<%--<div class="subBar">--%>
<%--<ul>--%>
<%--<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>--%>
<%--<li><div class="buttonActive"><div class="buttonContent"><button type="reset">重置</button></div></div></li>--%>
<%--</ul>--%>
<%--</div>--%>
<%--</div>--%>
<%--</form>--%>
<%--</div>--%>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li controlID="7312"><a class="add" href="${ctxPath}/ProjectType/add/-1" target="dialog" rel="ProjectType_Index_01" title="工程性质添加" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="250" height="150"><span>添加</span></a></li>
            <li controlID="7312" class="line">line</li>
            <li controlID="7312"><a class="edit" href="${ctxPath}/ProjectType/add/{sid_pt}" target="dialog" rel="ProjectType_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="250" height="150"><span>修改</span></a></li>
            <li controlID="7312" class="line">line</li>
            <li controlID="7313"><a class="delete" href="${ctxPath}/ProjectType/delete/{sid_pt}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="50" asc="asc" desc="desc">
        <thead>
        <tr>
            <th width="40" align="center">序号</th>
            <th orderField="projectTypeName" class="asc">工程性质</th>
           <!--  <th align="center">操作</th> -->
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="li" varStatus="vs">
            <tr target="sid_pt" rel="${li.projectTypeID}">
                <td>${vs.index+1}</td>
                <td>${li.projectTypeName}</td>
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
