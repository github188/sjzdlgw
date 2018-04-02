<%--
  Created by IntelliJ IDEA.
  User: pak2c
  Date: 16/10/10
  Time: 下午3:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="${ctxPath}/Area/index?type=${areaType}">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>

<script>
    <%--console.log(${pageForm.listDatas});--%>

</script>
<%-- <div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/Area/index?type=${areaType}" method="post">
        <div class="searchBar" style="display: none">
            <table class="searchContent">
                <tr>
                    <td>
                        名称：<input type="text" name="areaName" value="${areaName}" minlength="1" maxlength="5"/>
                    </td>
                </tr>
            </table>

            <div class="subBar">
                <ul>
                    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
                    <li><div class="buttonActive"><div class="buttonContent"><button type="reset">重置</button></div></div></li>
                </ul>
            </div>
        </div>
    </form>
</div> --%>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li controlID="7012"><a class="add" href="${ctxPath}/Area/add/-1?type=${areaType}" target="dialog" rel="ManholeKindType_Index_01" title="区域信息添加" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="400" height="200"><span>添加</span></a></li>
            <li controlID="7012" class="line">line</li>
            <li controlID="7012"><a class="edit" href="${ctxPath}/Area/add/{sid_area}?type=${Type}" target="dialog" rel="ManholeKindType_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="400" height="200"><span>修改</span></a></li>
            <li controlID="7012" class="line">line</li>
            <li controlID="7013"><a class="delete" href="${ctxPath}/Area/delete/{sid_area}?type=${areaType}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li controlID="7013" class="line">line</li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="50" asc="asc" desc="desc">
        <thead>
        <tr>
            <th orderField="AREANUM" class="asc" width="40" align="center">序号</th>
            <th >名称</th>
            <th >描述</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
            <tr target="sid_area" rel="${ob.areaNum}">
                <td>${ob.areaNum}</td>
                <td>${ob.areaName}</td>
                <td>${ob.areaDescription}</td>

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

