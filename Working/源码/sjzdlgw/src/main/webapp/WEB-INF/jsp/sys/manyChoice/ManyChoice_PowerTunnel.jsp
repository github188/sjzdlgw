<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="${ctxPath}/ManyChoice/PowerTunnel">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
</form>

<div class="pageHeader">
    <form rel="pagerForm" action="${ctxPath}/ManyChoice/PowerTunnel" method="post" onsubmit="return dwzSearch(this,'dialog');">
        <div class="searchBar">
            <%--<table class="searchContent">--%>
                <%--<tr>--%>
                    <%--<td>--%>
                        <%--运检班组名称：<input type="text" name="organizationName" value="${organizationName}" minlength="1" maxlength="20" size="30"/>--%>
                    <%--</td>--%>
                <%--</tr>--%>
            <%--</table>--%>

            <div class="subBar">
                <ul>
                    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
                    <li><div class="button"><div class="buttonContent"><button type="button" multLookup="CablePath_Index_Organization" warn="请选择通道台账">选择</button></div></div></li>
                </ul>
            </div>
        </div>
    </form>
</div>
<div class="pageContent">
    <table class="table" layoutH="118" targetType="dialog" width="100%">
        <thead>
        <tr>
            <th width="30"><input type="checkbox" class="checkboxCtrl" group="CablePath_Index_Organization" /></th>
            <th width="60">档案编号</th>
            <th orderField="assetCode" width="60">通道编号</th>
            <th width="60">运行编号</th>
            <th width="60">所属变电站</th>
            <th width="60">所属片区</th>
            <th width="40">类型</th>
            <th width="60">电压等级</th>
            <th width="60">起止地点</th>
            <th width="60">所在方位</th>
            <th width="60">投运日期</th>
            <th width="40">材质</th>
            <th width="60">运检班组</th>
            <th width="40">尺寸</th>
            <th width="60">覆土深度</th>
            <th width="40">长度</th>
            <th width="50">录入人</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="ob">
            <tr >
                <td><input type="checkbox"class="checkboxCtrl" name="CablePath_Index_Organization" value="{assetNum:'${ob.assetNum}','archivesNum':'${ob.archivesNum}','archivesCode':'${ob.archivesCode}'}"/></td>
                <td>${ob.archivesCode}</td>
                <td>${ob.assetCode}</td> <%--通道编号---%>
                <td>${ob.operationCode}</td> <%--运行编号---%>
                <td>${ob.baseFacilityName}</td>  <%--所属变电站---%>
                <td>${ob.areaName}</td>
                <td>${ob.tunnelStructureTypeName}</td>
                <td>${ob.voltageLevelName}</td>
                <td>${ob.startStopDescription}</td>
                <td>${ob.positionDescription}</td>
                <td>${ob.operationDateStr}</td>
                <td>${ob.tunnelStuffTypeName}</td>
                <td>${ob.organizationName}</td>
                <td>${ob.tunnelSize}</td>
                <td>${ob.frontTopHeight}</td>
                <td>${ob.tunnelLength}</td>
                <td>${ob.employeeName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="panelBar">
        <div class="pages">
            <span>每页</span>
            <select class="combox" name="numPerPage" onchange="dwzPageBreak({targetType:'dialog',data:{numPerPage:this.value}})">
                <c:forEach begin="20" end="100" step="20" varStatus="s">
                    <option value="${s.index}" ${pageForm.numPerPage eq
                            s.index ? 'selected="selected"' : ''}>
                            ${s.index}
                    </option>
                </c:forEach>
            </select>
            <span>条，共${pageForm.totalCount}条</span>
        </div>

        <div class="pagination" targetType="dialog" totalCount="${pageForm.totalCount}" numPerPage="${pageForm.numPerPage}" pageNumShown="10" currentPage="${pageForm.pageNum}"></div>

    </div>
</div>
