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
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/BranchBoxStatistics/index" method="post">
        <div class="searchBar">
          
				 <ul class="a-searchBar">
				  <li>
				                    <%--   变电站
                        <input name="baseFacilityNum" value="${PageModelBranchBoxStatisticsSearch.baseFacilityNum}" type="hidden">
                        <input name="baseFacilityName" value="${PageModelBranchBoxStatisticsSearch.baseFacilityName}" type="text" size="8" readonly="true"/>
                        <a class="btnLook" href="${ctxPath}/BranchBoxStatistics/index/BaseFacility" lookupGroup="">查找带回</a> --%>
                         <label>所属变电站：</label>
	                 <!-- <select name="baseFacilityNum" class="required combo-box"> -->
	                  <select name="baseFacilityNum" class="combox">
	                 <option value="">请选择所属变电站</option>
	                 <c:forEach items="${baseFacilityList}" var="ob" varStatus="id">
	                        <option value="${ob.baseFacilityNum}" ${PageModelBranchBoxStatisticsSearch.baseFacilityNum eq ob.baseFacilityNum ? 'selected="selected"':''} >${ob.baseFacilityName}</option>
	                    </c:forEach>
	                </select>
                  </li>
				  <li>
                          <label>电压等级：</label>
	                 <select name="voltageLevelID" class="combox"">
	                 <option value="">请选择电压等级</option>
	                    <c:forEach items="${powerCableLevelList}" var="ob" varStatus="id">
	                        <option value="${ob.voltageLevelID}" ${PageModelBranchBoxStatisticsSearch.voltageLevelID eq ob.voltageLevelID ? 'selected="selected"':''} >${ob.voltageLevelName}</option>
	                    </c:forEach>
	                </select>
                 </li>
				 <li>
				                      <%--     年份：<input id="db" name="runDateStr" class="required"  type="text"  value="${PageModelBranchBoxStatisticsSearch.runDateStr}" placeholder="输入年份如2016"/> --%>
				      <label>年份：</label>
	                 <select name="runDateStr" class="combox"">
	                 <option value="">1990</option>
	                    <c:forEach items="${dateList}" var="ob" varStatus="id">
	                        <option value="${ob.year}" ${ob.year eq PageModelBranchBoxStatisticsSearch.runDateStr ? 'selected="selected"':''} >${ob.year}</option>
	                    </c:forEach>
	                </select>
                </li>
                 <li>
                        <input type="checkbox" name="isLoadSwitch" ${PageModelBranchBoxStatisticsSearch.isLoadSwitch==1?'checked="true"':''} value="1" /> 负荷开关
                </li>
                <li>
                    <input type="checkbox" name="isLockDevice" ${PageModelBranchBoxStatisticsSearch.isLockDevice==1?'checked="true"':''} value="1" /> 闭锁装置
                </li>
                <li>
       				<input type="checkbox" name="isOnMonitor" ${PageModelBranchBoxStatisticsSearch.isOnMonitor==1?'checked="true"':''} value="1" /> T型接头
                </li>
                <li>
             		<input type="checkbox" name="isDrop" ${PageModelBranchBoxStatisticsSearch.isDrop==1?'checked="true"':''} value="1" /> 肘型接头
                </li>
                <li>
                	<div class="buttonActive"><div class="buttonContent"><button type="submit">生成报表</button></div></div>
                 </li>
               
                </ul>
        </div>
    </form>
</div>
<div class="pageContent">
<c:if test="${ not empty PageModelBranchBoxStatisticsSearch.runDateStr}">
    <div class="panelBar">
        <ul class="toolBar">
          <li controlID="6520"><a class="icon" href="${ctxPath}/BranchBoxStatistics/Export/excel" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
         </ul>
    </div>
     
    <table class="table" width="100%" layoutH="138" asc="asc" desc="desc">
        <thead>
            <tr>
            	<th>年份</th>
            	<th>1月</th>
            	<th>2月</th>
            	<th>3月</th>
            	<th>4月</th>
            	<th>5月</th>
            	<th>6月</th>
            	<th>7月</th>
            	<th>8月</th>
            	<th>9月</th>
            	<th>10月</th>
            	<th>11月</th>
            	<th>12月</th>
            </tr>
        </thead>
        <tbody>
	        <tr>
	        	<td>${yearAndMonthPage.year==null?'':yearAndMonthPage.year}</td>
	        	<td>${yearAndMonthPage.jan}</td>
	        	<td>${yearAndMonthPage.feb}</td>
	        	<td>${yearAndMonthPage.mar}</td>
	        	<td>${yearAndMonthPage.apr}</td>
	        	<td>${yearAndMonthPage.may}</td>
	        	<td>${yearAndMonthPage.jun}</td>
	        	<td>${yearAndMonthPage.jul}</td>
	        	<td>${yearAndMonthPage.aug}</td>
	        	<td>${yearAndMonthPage.sep}</td>
	        	<td>${yearAndMonthPage.oct}</td>
	        	<td>${yearAndMonthPage.nov}</td>
	        	<td>${yearAndMonthPage.dec}</td>
	        </tr>
       
        </tbody>
    </table>
    </c:if>
</div>
