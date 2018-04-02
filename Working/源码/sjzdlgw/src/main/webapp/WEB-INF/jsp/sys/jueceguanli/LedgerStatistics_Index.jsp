<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="${ctxPath}/LedgerStatistics/index">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>

<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
           <%--  <li><a class="add" href="${ctxPath}/Ledger/add/-1" target="dialog" rel="Ledger_Index_01" title="终端设施类型添加" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>添加</span></a></li>
            <li class="line">line</li> --%>
           <%--  <li><a class="edit" href="${ctxPath}/LedgerStatistics/add/{sid_ledger}" target="dialog" rel="LedgerSatistics_Index_01" title="通道档案台账" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>查看档案</span></a></li>
            <li class="line">line</li> --%>
            <li controlID="6020"><a class="icon" href="${ctxPath}/LedgerStatistics/Export/excel" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="77" asc="asc" desc="desc">
        <thead>
        <tr>
            <th class="asc" width="40" align="center">序号</th>
            <th class="asc" width="60">验收状态</th>
            <th width="60">档案编号</th>
            <th width="60">档案名称</th>
            
            <th width="60">设备地址</th>
            <th width="60">监理单位</th>
            <th width="60">施工单位</th>
            <th width="80">设备类型</th>
            <th class="asc" width="60"> >竣工日期</th>
            <th width="60">录入人</th>
            <th class="asc" width="60"> >录入时间</th>
          
            
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
            <tr target="sid_ledger" rel="${ob.archivesNum}">
                <td>${vs.index+1}</td>
                <td>${ob.acceptStatusTypeName}</td>
                <td>${ob.archivesCode}</td>
                <td>${ob.archivesName}</td>
                
                <td>${ob.address}</td>
                <td>${ob.monitorCompany}</td>
                <td>${ob.buildCompany}</td>
                <td>${ob.specification}</td>
                <td>${ob.completeDateStr}</td>
                <td>${ob.recordUserName}</td>
                <td>${ob.archivesTimeStr}</td>
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
