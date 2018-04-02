<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>

<script>
    <%--console.log(${pageForm.listDatas});--%>
    function dbclick() {
        $("#ledgerView").click();
    }
</script>
<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/Ledger/index" method="post">
        <input type="hidden" name="idNum" value="${BaseFacilityNum_Ledger}" />
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td>
                        档案名称: <input type="text" name="archivesName" value="${archivesName}"/>
                    </td>
                    <td>
                        档案编号: <input type="text" name="archivesCode" value="${archivesCode}"/>
                    </td>
                    <%--<td>竣工日期: <input type="text" name="completeDateMin" value="${completeDateMinStr}" class="date" readonly="true"/>&nbsp;&nbsp;&nbsp;到&nbsp;&nbsp;&nbsp;<input type="text" name="completeDateMax" value="${completeDateMaxStr}" class="date" readonly="true"/></td>--%>
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
            <li><a id="ledgerView" class="edit" style="display: none;" href="${ctxPath}/Ledger/index/{sid_ledger}" target="dialog" rel="Ledger_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"></a></li>
            <li controlID="2001"><a class="add" href="${ctxPath}/Ledger/add/-1?idNum=${BaseFacilityNum_Ledger}" target="dialog" rel="Ledger_Index_01" title="添加档案台帐" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>添加</span></a></li>
            <li controlID="2001" class="line">line</li>
            <li controlID="2001"><a class="edit" href="${ctxPath}/Ledger/add/{sid_ledger}" target="dialog" rel="Ledger_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>修改</span></a></li>
            <li controlID="2001" class="line">line</li>
            <li controlID="2002"><a class="delete" href="${ctxPath}/Ledger/delete/{sid_ledger}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li controlID="2002" class="line">line</li>
            <li controlID="2003"><a class="edit" href="${ctxPath}/Ledger/uploadTunnelArchivesFile/{sid_ledger}" target="dialog" rel="CableDeviceLeger_Index_04" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>文档附件</span></a></li>
            <li controlID="2004"><a class="delete" href="${ctxPath}/Ledger/pullToAduit/{sid_ledger}" target="ajaxTodo" title="确定要下发档案,启动验收流程?" warn="请选择一条记录"><span>下发档案</span></a></li>
            <li controlID="2004" class="line">line</li>
            <li controlID="2005"><a class="icon" href="${ctxPath}/Ledger/downloadCover/{sid_ledger}" onclick="docExport(this);return false" target="dwzExport" warn="请选择一条记录"><span>打印封面</span></a></li>
            <li controlID="2005" class="line">line</li>
            <li controlID="2006"><a class="icon" href="${ctxPath}/Ledger/Export/excel/${BaseFacilityNum_Ledger}" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
        </ul>
    </div>
    <table class="table" width="3000" layoutH="138" asc="asc" desc="desc">
        <thead>
        <tr>
            <th width="20" align="center">序号</th>
            <th width="100">档案状态</th>
            <th width="50">所属变电站</th>
            <th width="50">档案编号</th>
            <th width="400">档案名称</th>
            <th width="70">盒内档案号</th>
            <th width="400">设备地址</th>
            <th width="600">设备类型及规格</th>
            <th width="200">施工单位</th>
            <th width="200">监理单位</th>
            <th width="200">资产分界</th>
            <th width="60">竣工日期</th>
            <th width="60">录入人</th>
            <th width="60">录入时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
            <tr target="sid_ledger" rel="${ob.archivesNum}" ondblclick="dbclick()">
                <td>${vs.index+1}</td>
                <td>${ob.acceptStatusTypeName}</td>
                <td>${ob.baseFacilityName}</td>
                <td>${ob.archivesCode}</td>
                <td>${ob.archivesName}</td>
                <td>${ob.drawerCode}</td>
                <td>${ob.address}</td>
                <td>${ob.specification}</td>
                <td>${ob.buildCompany}</td>
                <td>${ob.monitorCompany}</td>
                <td>${ob.assetBorderTypeName}</td>
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
