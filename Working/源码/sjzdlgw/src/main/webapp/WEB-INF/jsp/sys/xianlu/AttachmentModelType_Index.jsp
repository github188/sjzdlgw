<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>


<div class="pageHeader" style='display:none'>
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/AttachmentModelType/index" method="post">
        <%--
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td>
                        设备规格：<input type="text" name="attachmentModelTypeName" value="${attachmentModelTypeName}" minlength="1" maxlength="5"/>
                    </td>
                </tr>
            </table>

            <div class="subBar">
                <ul>
                    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
                    <li><div class="buttonActive"><div class="buttonContent"><button type="reset">重置</button></div></div></li>
                </ul>
            </div>
        </div>  --%>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li controlID="7342"><a class="add" href="${ctxPath}/AttachmentModelType/add/-1" target="dialog" rel="AttachmentModelType_Index_01" title="设备规格添加" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="280" height="210"><span>添加</span></a></li>
            <li controlID="7342" class="line">line</li>
            <li controlID="7342"><a class="edit" href="${ctxPath}/AttachmentModelType/add/{sid_amt}" target="dialog" rel="AttachmentModelType_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="280" height="210"><span>修改</span></a></li>
            <li controlID="7342" class="line">line</li>
            <li controlID="7343"><a class="delete" href="${ctxPath}/AttachmentModelType/delete/{sid_amt}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li controlID="7343" class="line">line</li>
           <!--  <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
         --></ul>
    </div>
    <table class="table" width="100%" layoutH="76">
        <thead>
        <tr>
            <th width="40">序号</th>
            <th >线路类型</th>
            <th>附属设施类型</th>
            <th>附属设施规格</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}"  var="li" varStatus="vs">
            <tr target="sid_amt" rel="${li.modelTypeNum}">
                <td>${vs.index+1}</td>
                <td>${li.pathTypeName}</td>
                <td>${li.attachmentTypeName}</td>
                <td>${li.modelTypeName}</td>
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

