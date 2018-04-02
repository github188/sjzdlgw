<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
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
    function Dbclick(e) {

        var href="${ctxPath}/CableDeviceLedger/${pathType}/dbadd/"+e;
        $("#cableSpen_index").attr("href",href);
        console.log(href) ;
        $("#cableSpen_index").click();
    }

</script>

<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/CableInspecteManage/${pathType}/index/acceptType/${acceptStatusTypeID}" method="post">
        <div class="searchBar">

        </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <c:if test="${acceptStatusTypeID eq 2}">
            <li controlID="${pathType==1?'3809':'4809'}"><a class="add" href="${ctxPath}/CableInspecteManage/${pathType}/add/{sid_num}?type=2" target="dialog" rel="TunnelAduit_Index_01" warn="请选择一条记录"title="新增验收计划" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="300"><span>验收计划</span></a></li>
            <li controlID="${pathType==1?'3809':'4809'}" class="line">line</li>
            </c:if>
        <%--<c:if test="${acceptStatusTypeID eq 1}">--%>
            <%--<li controlID="${pathType==1?'3802':'4802'}"><a class="delete" href="${ctxPath}/CableInspecteManage/${pathType}/delete/{sid_num}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除验收记录</span></a></li>--%>
            <%--<li controlID="${pathType==1?'3802':'4802'}" class="line">line</li>--%>
            <%--</c:if>--%>
            <a class="hidden" id="cableSpen_index" href="${ctxPath}/CableDeviceLedger/${pathType}/dbadd/" target="dialog" rel="CableDeviceLeger_Index_055" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="400"></a>
            <li controlID="${pathType==1?'3810':'4810'}"><a class="edit" href="${ctxPath}/CableDeviceLedger/${pathType}/dbadd/{sid_num}" target="dialog" rel="CableDeviceLeger_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="400"><span>查看详情</span></a></li>
            <li controlID="${pathType==1?'3810':'4810'}" class="line">line</li>

            <li controlID="${pathType==1?'3810':'4810'}"><a class="edit" href="${ctxPath}/CableDeviceLedger/${pathType}/add/{sid_num}" target="dialog" rel="CableDeviceLeger_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="400"><span>编辑档案</span></a></li>
            <li controlID="${pathType==1?'3810':'4810'}" class="line">line</li>
            <li controlID="${pathType==1?'3811':'4811'}"><a class="edit" href="${ctxPath}/CableDeviceLedger/${pathType}/uploadCableDeviceLegerAttament/{sid_num}" target="dialog" rel="CableDeviceLeger_Index_04" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>文档附件</span></a></li>
            <li controlID="${pathType==1?'3811':'4811'}" class="line">line</li>

            <c:if test="${acceptStatusTypeID eq 1}">
            <li controlID="${pathType==1?'3812':'4812'}"><a class="edit" href="${ctxPath}/CableDeviceLeger/${pathType}/pullToAduit/{sid_num}" target="ajaxTodo" rel="CableDeviceLeger_Index_03" title="确定要下发?"><span>下发档案</span></a></li>
            <li controlID="${pathType==1?'3812':'4812'}" class="line">line</li>
            </c:if>
            <c:if test="${acceptStatusTypeID eq 8}">
                <li controlID="${pathType==1?'3812':'4812'}"><a class="edit" href="${ctxPath}/CableDeviceLeger/${pathType}/pullToAduit/{sid_num}" target="ajaxTodo" rel="CableDeviceLeger_Index_03" title="确定要下发?"><span>下发档案</span></a></li>
                <li controlID="${pathType==1?'3812':'4812'}" class="line">line</li>
            </c:if>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="110" asc="asc" desc="desc">
        <thead>
        <tr>
            <th orderField="ARCHIVESCODE" class="asc" width="40" align="center">序号</th>
            <th orderField="ACCEPTSTATUSTYPEID" class="asc" width="60">档案状态</th>
            <th width="70">电压等级</th>
            <th width="70">档案编号</th>
            <th width="70">档案名称</th>
            <th width="60">工程类型</th>
            <th width="60">方案编号</th>
            <th orderField="ARCHIVESTIME" class="asc" width="60"> 录入时间</th>
            <th width="60"> 录入人</th>
            <th width="60">验收时间</th>
            <th width="60">备注</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
            <tr colored="true" ondblclick="Dbclick(${ob.num})" target="sid_num" rel="${ob.num}" class="${ob.acceptStatusTypeID==1?'tr_color_1':ob.acceptStatusTypeID==2?'tr_color_2':ob.acceptStatusTypeID==3?'tr_color_3':ob.acceptStatusTypeID==4?'tr_color_4':'tr_color_5'}">
                <td>${vs.index+1}</td>
                <td>${ob.acceptStatusTypeName}</td>
                <td>${ob.voltageLevelName}</td>
                <td>${ob.ledgerCode}</td>
                <td>${ob.ledgerName}</td>
                <td>${ob.projectTypeName}</td>
                <td>${ob.projectCode}</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${ob.archivesTime}" type="both"/></td>
                <td>${ob.userName}</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${ob.accpetDate}" type="both"/></td>
                <td>${ob.memo}</td>
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

