<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>
<style type="text/css">

    tr[colored].selected {
        border-color:#000000;
        background:#ffffff;
    }
    .tr_color_1 {
        background-color:#E6E8D2;
    }
    .tr_color_2 {
        background-color:#D6B4B3;
    }
    .tr_color_3 {
        background-color:#65A31E;
    }
    .tr_color_4 {
        background-color:#1CAEAA;
    }
    .tr_color_5 {
        background-color:#006400;
    }

</style>
<script>
    function dbclick(e) {

        var href="${ctxPath}/Ledger/index/"+e;
        $("#tunnelAduitView").attr("href",href);
        console.log(href) ;
        $("#tunnelAduitView").click();
    }
</script>
<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/TunnelAduit${formUrl}" method="get">
        <div class="searchBar">
        </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <a id="tunnelAduitView" style="display:none" class="hidden" href="${ctxPath}/Ledger/index/{sid_ledger}" target="dialog" rel="Ledger_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"></a>
            <li><a style="display:none" class="edit" href="${ctxPath}/Ledger/index/{sid_ledger}" target="dialog" rel="Ledger_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>详情</span></a></li>
                <c:if test="${acceptStatusTypeID eq 2}">
            <li controlID="2809"><a class="add" href="${ctxPath}/TunnelAduit/add/{sid_ledger}" target="dialog" rel="TunnelAduit_Index_01" warn="请选择一条记录"title="新增验收计划" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="300"><span>验收计划</span></a></li>
            <li controlID="2809" class="line">line</li>
            </c:if>
            <%--<li controlID="2802"><a class="delete" href="${ctxPath}/TunnelAduit/delete/{sid_ledger}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除验收记录</span></a></li>--%>
            <%--<li controlID="2802" class="line">line</li>--%>

            <li controlID="2810"><a class="edit" href="${ctxPath}/TunnelAduit/downloadCover/{sid_ledger}" onclick="docExport(this);return false" target="dwzExport" warn="请选择一条记录"><span>打印封面</span></a></li>
            <li controlID="2810" class="line">line</li>

            <li controlID="2811"><a class="edit" href="${ctxPath}/Ledger/add/{sid_ledger}" target="dialog" rel="Ledger_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>档案修改</span></a></li>
            <li controlID="2811" class="line">line</li>
            <li controlID="2812"><a class="edit" href="${ctxPath}/Ledger/uploadTunnelArchivesFile/{sid_ledger}" target="dialog" rel="CableDeviceLeger_Index_04" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>档案附件</span></a></li>
            <li controlID="2812" class="line">line</li>
            <c:if test="${acceptStatusTypeID eq 1}">
            <li controlID="2813"><a class="delete" href="${ctxPath}/Ledger/pullToAduit/{sid_ledger}" target="ajaxTodo" title="确定要下发档案,启动验收流程?" warn="请选择一条记录"><span>下发档案</span></a></li>
            <li controlID="2813" class="line">line</li>
            </c:if>
            <c:if test="${acceptStatusTypeID eq 8}">
            <li controlID="2813"><a class="delete" href="${ctxPath}/Ledger/pullToAduit/{sid_ledger}" target="ajaxTodo" title="确定要下发档案,启动验收流程?" warn="请选择一条记录"><span>下发档案</span></a></li>
            <li controlID="2813" class="line">line</li>
            <li controlID="2814"><a class="delete" href="${ctxPath}/Ledger/pullToDraft/{sid_ledger}" target="ajaxTodo" title="确定要建立草稿?" warn="请选择一条记录"><span>建立草稿</span></a></li>
            <li controlID="2814" class="line">line</li>
            </c:if>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="113" asc="asc" desc="desc">
        <thead>
        <tr>
            <th orderField="ARCHIVESCODE" class="asc" width="40" align="center">序号</th>
            <th orderField="ACCEPTSTATUSTYPEID" class="asc" width="60">档案状态</th>
            <th width="70">所属变电站</th>
            <th width="70">档案编号</th>
            <th width="70">档案名称</th>
            <th width="70">盒内档案号</th>
            <th width="60">资产分界</th>
            <th width="60">设备地址</th>
            <th width="80">设备类型及规格</th>
            <th width="60">施工单位</th>
            <th width="60">监理单位</th>
            <th orderField="COMPLETEDATE" class="asc" width="60"> 竣工日期</th>
            <th width="60">录入人</th>
            <th orderField="ARCHIVESTIME" class="asc" width="60"> 录入时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
            <tr target="sid_ledger" rel="${ob.archivesNum}" ondblclick="dbclick(${ob.archivesNum})" class="${ob.acceptStatusTypeID==1?'tr_color_1':ob.acceptStatusTypeID==2?'tr_color_2':ob.acceptStatusTypeID==3?'tr_color_3':ob.acceptStatusTypeID==4?'tr_color_4':'tr_color_5'}">
                <td >${vs.index+1}</td>
                <td >${ob.acceptStatusTypeName}</td>
                <td>${ob.baseFacilityName}</td>
                <td>${ob.archivesCode}</td>
                <td>${ob.archivesName}</td>
                <td>${ob.drawerCode}</td>
                <td>${ob.assetBorderTypeName}</td>
                <td>${ob.address}</td>
                <td>${ob.specification}</td>
                <td>${ob.buildCompany}</td>
                <td>${ob.monitorCompany}</td>
                <td>${ob.completeDateStr}</td>
                <td>${ob.recordUserName}</td>
                <td>${ob.archivesTimeStr}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="panelBar panelBared">
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
