<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="${ctxPath}/ManyChoice/PathSection/${pathType}">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
</form>

<div class="pageHeader">
    <form rel="pagerForm" action="${ctxPath}/ManyChoice/PathSection/${pathType}" method="post" onsubmit="return dwzSearch(this,'dialog');">
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
                    <li><div class="button"><div class="buttonContent"><button type="button" multLookup="CablePath_Index_Organization" warn="请选择线路段">选择</button></div></div></li>
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
            <th style="width: 300px;" orderField="pathSectionCode" class="asc|desc">线路段编号</th>
            <th style="width: 300px;" orderField="pathSectionName" class="asc|desc">线路段名称</th>
            <th style="width: 300px;">起点位置</th>
            <th style="width: 300px;" >终点止点</th>
            <th style="width: 300px;" orderField="attachmentStatusTypeName" class="asc|desc">状态</th>
            <th style="width: 300px;" orderField="loopCount" class="asc|desc">回数</th>
            <th style="width: 300px;" orderField="lineCount" class="asc|desc">条数</th>
            <th style="width: 300px;" orderField="loopLenght" class="asc|desc">回长(千米)</th>
            <th style="width: 300px;" orderField="totalLength" class="asc|desc">总回长(千米)</th>
            <th style="width: 300px;" orderField="runDate" class="asc|desc">最早投运</th>
            <th style="width: 300px;" orderField="modelTypeName" class="asc|desc">电缆规格</th>
            <th style="width: 300px;" orderField="noumenonCount" class="asc|desc">本体数量</th>
            <th style="width: 300px;" orderField="connectorCount" class="asc|desc">接头数量</th>
            <th style="width: 300px;" orderField="terminationCount" class="asc|desc">终端数量</th>
            <th style="width: 300px;" orderField="earthBoxCount" class="asc|desc">分接箱数量</th>
            <th style="width: 300px;" orderField="safeEarthTypeName" class="asc|desc">接地方式</th>
            <th style="width: 300px;" orderField="installTypeName" class="asc|desc">敷设方式</th>
            <th style="width: 300px;" orderField="assetName" class="asc|desc">起点设备</th>
            <th style="width: 300px;" orderField="end_AssetName" class="asc|desc">止点设备</th>
            <th style="width: 300px;">备注</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="li" varStatus="vs">
            <tr target="sid_PathSection" rel="${li.pathSectionNum}" style="${li.attachmentStatusTypeID eq 3?'background-color: yellow;':li.attachmentStatusTypeID eq 4?'background-color: red;':''}" >

                <td><input type="checkbox"class="checkboxCtrl" name="CablePath_Index_Organization" value="{pathSectionNum:'${li.pathSectionNum}','pathSectionCode':'${li.pathSectionCode}'}"/></td>
                <td>${li.pathSectionCode}</td>
                <td>${li.pathSectionName}</td>
                <td>${li.placeInfo}</td>
                <td>${li.placeInfo2}</td>
                <td>${li.attachmentStatusTypeName}</td>
                <td>${li.loopCount}</td>
                <td>${li.lineCount}</td>
                <td>${li.loopLenght}</td>
                <td>${li.totalLength}</td>
                <td>${li.runDateStr}</td>
                <td>${li.modelTypeName}</td>
                <td>${li.noumenonCount}</td>
                <td>${li.connectorCount}</td>
                <td>${li.terminationCount}</td>
                <td>${li.earthBoxCount}</td>
                <td>${li.safeEarthTypeName}</td>
                <td>${li.installTypeName}</td>
                <td>${li.assetName}</td>
                <td>${li.end_AssetName}</td>
                <td>${li.memo}</td>
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
