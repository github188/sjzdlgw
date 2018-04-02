<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="${ctxPath}/TunnelStructureType/index">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>

<script>
    <%--console.log(${pageForm.listDatas});--%>

</script>
<%-- <div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/TunnelStructureType/index" method="post">

    </form>
</div> --%>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <%--<li><a class="add" href="${ctxPath}/TunnelStructureType/add/-1" target="dialog" rel="ManholeKindType_Index_01" title="终端设施类型添加" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>添加</span></a></li>--%>
            <%--<li class="line">line</li>--%>
            <li controlID="7210"><a class="edit" href="${ctxPath}/TunnelStructureType/add/{sid_tst}" target="dialog" rel="ManholeKindType_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="300" height="170"><span>修改</span></a></li>
            <li controlID="7210" class="line">line</li>
            <li controlID="7211"><a class="delete" href="${ctxPath}/TunnelStructureType/delete/{sid_tst}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li controlID="7211" class="line">line</li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="50" asc="asc" desc="desc">
        <thead>
        <tr>
            <th orderField="tunnelStructureTypeID" class="asc" width="40" align="center">序号</th>
            <th >通道结构</th>
            <th orderField="prefix">编码前缀</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
            <tr target="sid_tst" rel="${ob.tunnelStructureTypeID}">
                <td>${ob.tunnelStructureTypeID}</td>
                <td>${ob.tunnelStructureTypeName}</td>
                <td>${ob.prefix}</td>
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
