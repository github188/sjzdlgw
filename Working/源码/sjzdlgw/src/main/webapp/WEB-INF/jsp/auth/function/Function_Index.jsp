<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>

<script>
    <%--console.log(${pageForm.listDatas});--%>

</script>
<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/Function/index" method="post">
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td>
                        功能名称：<input type="text" name="applicationModuleName" value="${applicationModuleName}" minlength="1" maxlength="5"/>
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
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <%--<li><a class="add" href="${ctxPath}/Function/add/-1" target="dialog" rel="ManholeKindType_Index_01" title="添加菜单" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>添加</span></a></li>--%>
            <%--<li class="line">line</li>--%>
            <%--<li><a class="edit" href="${ctxPath}/Function/add/{sid_function}" target="dialog" rel="ManholeKindType_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>修改</span></a></li>--%>
            <%--<li class="line">line</li>--%>
            <%--<li><a class="delete" href="${ctxPath}/Function/del" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>--%>
            <%--<li class="line">line</li>--%>
        </ul>
    </div>
    <table class="table" width="1200" layoutH="138" asc="asc" desc="desc">
        <thead>
        <tr>
            <th orderField="COMPANYNUM" class="asc" width="40" align="center">序号</th>
            <th >功能名称</th>
            <th >功能编码</th>
            <th >功能级别</th>
            <th >当前状态</th>
            <th >操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
            <tr target="sid_function" rel="${ob.ApplicationModuleID}">
            	<td>${ob.ApplicationModuleID}</td>
                <td>${ob.applicationModuleName}</td>
                <td>${ob.applicationCode}</td>
                <td>${ob.applicationLevel}</td>
                <td>${ob.isDisplay}</td>
                <td>
                    查看
                </td>
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
