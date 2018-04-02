<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>
<style>
    .a-searchBar {
        width:100%;
        overflow: hidden;
    }
    .a-searchBar li {
        width:290px;
        height:30px;
        float:left;
    }
</style>

<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/LayingOccupationStatistics/index" method="post">
        <div class="searchBar">
          
				 <ul class="a-searchBar">
				 <li>
                    <label>电压等级：</label>
	                 <select name="voltageLevelID" class="combox"">
	                 <option value="">请选择电压等级</option>
	                    <c:forEach items="${powerCableLevelList}" var="ob" varStatus="id">
	                        <option value="${ob.voltageLevelID}" ${ ob.voltageLevelID eq layingOccupationPage.voltageLevelID ? 'selected="selected"':''} >${ob.voltageLevelName}</option>
	                    </c:forEach>
	                </select>
                 </li>
				 <li>
                    <label>通道类型：</label>
	                 <select name="tunnelStructureTypeID" class="combox"">
	                 <option value="">请选择通道类型</option>
	                    <c:forEach items="${tunnelStructureTypeList}" var="ob" varStatus="id">
	                        <option value="${ob.tunnelStructureTypeID}" ${layingOccupationPage.tunnelStructureTypeID eq ob.tunnelStructureTypeID ? 'selected="selected"':''} >${ob.tunnelStructureTypeName}</option>
	                    </c:forEach>
	                </select>
                 </li>
                 <li >
                 	<div class="buttonActive"><div class="buttonContent"><button type="submit">生成报表</button></div></div>
                 </li>
				
                </ul>
        </div>
    </form>
</div>
<div class="pageContent">
<%-- <c:if test="${ not empty PageModelBranchBoxStatisticsSearch.runDateStr}"> --%>
    <div class="panelBar">
        <ul class="toolBar">
          <li controlID="6710"><a class="icon" href="${ctxPath}/LayingOccupationStatistics/Export/excel" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
           <li controlID="6710" class="line">line</li>
            <li controlID="6720"><a class="edit" href="javaScript:"   warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>显示到地图</span></a></li>
            
         </ul>
    </div>
     
    <table class="table" width="100%" layoutH="88" asc="asc" desc="desc">
        <thead>
        <tr>
            <th class="asc" width="40" align="center">序号</th>
            <th width="60">通道编号</th>
            <th width="60">运行编号</th>
            <th width="60">所属片区</th>
            <th width="60">电压等级</th>
            <th width="60">通道类型</th>
            <th width="60">状态</th>
            <th width="60">允许敷设数量</th>
            <th width="60">已敷设数量</th>
            <th width="60">预占位数量</th>
            <th width="60">剩余数量</th>
            <th width="60">所在方位</th>
            <th width="60">起止地点</th>
            <th width="60">通道材质</th>
            <th width="60">尺寸（米）</th>
            <th width="60">长度（米）</th>
            <th width="60">投运日期</th>
            <th width="60">操作</th>
          
            
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
        <c:if test="${ob.laystatus eq '已满'}">
            <tr style="background-color:red";}>
        </c:if>
        <c:if test="${ob.laystatus eq '未满'}">
            <tr style="background-color:green";}>
        </c:if>
        <c:if test="${ob.laystatus eq '预警'}">
            <tr style="background-color:yellow";}>
        </c:if>
                <td>${vs.index+1}</td>
                <td>${ob.assetCode}</td>
                <td>${ob.operationCode}</td>
                <td>${ob.areaName}</td>
                <td>${ob.voltageLevelName}</td>
                <td>${ob.tunnelStructureTypeName}</td>
                <td>${ob.laystatus}</td>
                <td>${ob.laycount}</td>
                <td>${ob.totalcount}</td>
                <td>${ob.prelaycount}</td>
                <td>${ob.restcount}</td>
                <td>${ob.positionDescription}</td>
                <td>${ob.startStopDescription}</td>
                <td>${ob.tunnelStuffTypeName}</td>
                <td>${ob.tunnelSize}</td>
                <td>${ob.tunnelLength}</td>
                <td>${ob.operationDate}</td>
                <td align="center"><a class="edit" href="${ctxPath}/LayingOccupationStatistics/sub/index?ID=${ob.assetCode}&state=${ob.laystatus}" target="dialog" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="450">详细信息</a></td>
              
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
  <%--   </c:if> --%>
</div>
