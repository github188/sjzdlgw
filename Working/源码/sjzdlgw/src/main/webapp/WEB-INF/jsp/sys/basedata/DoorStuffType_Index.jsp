<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="${ctxPath}/DoorStuffType/index">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>


<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li controlID="7257"><a class="add" href="${ctxPath}/DoorStuffType/add/-1" target="dialog" rel="DoorStuffType_Index_01" title="防火门材质录入" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="300" height="150"><span>添加</span></a></li>
            <li controlID="7257" class="line">line</li>
            <li controlID="7257"><a class="edit" href="${ctxPath}/DoorStuffType/add/{sid_dst}" target="dialog" rel="DoorStuffType_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="300" height="150"><span>修改</span></a></li>
            <li controlID="7257" class="line">line</li>
            <li controlID="7258"><a class="delete" href="${ctxPath}/DoorStuffType/delete/{sid_dst}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li controlID="7258" class="line">line</li>
           <!--  <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
         --></ul>
    </div>
    <table class="table" width="100%" layoutH="50" asc="asc" desc="desc">
        <thead>
            <tr>
                <th width="80" align="center" class="asc">序号</th>
                <th align="center">防火门材质</th>   
            </tr>
        </thead>
        <tbody>
          <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
            <tr target="sid_dst" rel="${ob.doorStuffTypeID}">
                <td>${vs.index+1}</td>
                <td>${ob.doorStuffTypeName}</td>
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
