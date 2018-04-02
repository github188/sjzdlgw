<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="${ctxPath}/ManholeKindType/index">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>


<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li controlID="7402"><a class="add" href="${ctxPath}/ManholeKindType/add/-1" target="dialog" rel="ManholeKindType_Index_01" title="终端设施类型添加" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="300" height="210"><span>添加</span></a></li>
            <li controlID="7402" class="line">line</li>
            <li controlID="7402"><a class="edit" href="${ctxPath}/ManholeKindType/add/{sid_mhkt}" target="dialog" rel="ManholeKindType_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="300" height="210"><span>修改</span></a></li>
            <li controlID="7402" class="line">line</li>
            <li controlID="7403"><a class="delete" href="${ctxPath}/ManholeKindType/delete/{sid_mhkt}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li controlID="7403" class="line">line</li>
            <!-- <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
         --></ul>
    </div>
    <table class="table" width="100%" layoutH="50" asc="asc" desc="desc">
        <thead>
            <tr>
                <th width="40" align="center">序号</th>
                <th orderField="ManholeKindTypeName" class="asc">设施类型</th>
                <th orderField="Prefix" class="asc">编码前缀</th>
                <th align="center">操作</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="li" varStatus="vs">
            <tr target="sid_mhkt" rel="${li.manholeKindTypeID}">
                <td>${vs.index+1}</td>
                <td>${li.manholeKindTypeName}</td>
                <td>${li.prefix}</td>
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
