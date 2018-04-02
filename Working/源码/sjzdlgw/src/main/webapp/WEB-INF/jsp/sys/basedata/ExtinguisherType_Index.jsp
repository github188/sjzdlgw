<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="${ctxPath}/ExtinguisherType/index">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>


<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li controlID="7272"><a class="add" href="${ctxPath}/ExtinguisherType/add/-1" target="dialog" rel="ExtinguisherType_Index_01" title="灭火装置类型录入" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="250" height="150"><span>添加</span></a></li>
            <li controlID="7272" class="line">line</li>
            <li controlID="7272"><a class="edit" href="${ctxPath}/ExtinguisherType/add/{sid_et}" target="dialog" rel="ExtinguisherType_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="250" height="150"><span>修改</span></a></li>
            <li controlID="7272"class="line">line</li>
            <li controlID="7273"><a class="delete" href="${ctxPath}/ExtinguisherType/delete/{sid_et}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li controlID="7273"class="line">line</li>
           <!--  <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
        --> </ul>
    </div>
    <table class="table" width="100%" layoutH="50" asc="asc" desc="desc">
        <thead>
            <tr>
                <th width="80" align="center" class="asc">序号</th>
                <th align="center">灭火装置类型</th>   
            </tr>
        </thead>
        <tbody>
          <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
            <tr target="sid_et" rel="${ob.extinguisherTypeID}">
                <td>${vs.index+1}</td>
                <td>${ob.extinguisherTypeName}</td>
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
