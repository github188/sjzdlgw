<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="${ctxPath}/PowerTunnelStatistics/index">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>
<script>

</script>

<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <%-- <li><a class="edit" href="${ctxPath}/PowerTunnelStatistics/add/{sid_pt}" target="dialog" rel="ManholeKindType_Index_01" title="通道台账" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="552"><span>查看通道</span></a></li>
            <li class="line">line</li> --%>
            <li controlID="6120"><a class="icon" href="${ctxPath}/PowerTunnelStatistics/Export/excel" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="78" asc="asc" desc="desc">
        <thead>
        <tr>
            <th width="20" align="center">序号</th>
            <th width="50">档案编号</th>
            <th width="80">通道编号</th>
            <th width="80">运行编号</th>
            <th width="50">所属片区</th>
            <th width="400">所在方位</th>
            <th width="450">起止地点</th>
            <th width="100">运检班组</th>
            <th width="50">类型</th>
            <th width="50">材质</th>
            <th width="50">尺寸</th>
            <th width="50">电压等级</th>
            <th width="50">覆土深度</th>
            <th width="50">长度</th>
            <th width="50">投运日期</th>
    
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
            <tr target="sid_pt" rel="${ob.assetNum}">
                <td>${vs.index+1}</td>
                <td>${ob.archivesCode}</td>
                <td>${ob.assetCode}</td> <%--通道编号---%>
                <td>${ob.operationCode}</td> <%--运行编号---%>
                <td>${ob.areaName}</td><!-- 所属片区 -->
                <td>${ob.positionDescription}</td><!-- 所在方位 -->
                <td>${ob.startStopDescription}</td><!-- 起止地点 -->
                <td>${ob.organizationName}</td><!-- 运检班组 -->
                <td>${ob.tunnelStructureTypeName}</td><!-- 类型 -->
                <td>${ob.tunnelStuffTypeName}</td><!-- 材质 -->
                <td>${ob.tunnelSize}</td><!-- 尺寸 -->
                <td>${ob.voltageLevelName}<!-- </td>电压等级 -->
                <td>${ob.frontTopHeight}</td><!-- 覆土深度 -->
                <td>${ob.tunnelLength}</td><!-- 长度 -->
                <td>${ob.operationDateStr}</td><!-- 投运日期 -->
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
