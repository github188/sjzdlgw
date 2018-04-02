<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="${ctxPath}/LedgerStatistics/index">
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
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/LedgerLengthStatistics/index" method="post">
        <div class="searchBar">
          
				 <ul class="a-searchBar">
				  <li style="width:150px;padding-top:5px;margin-left:10px;">
            		<select name="serchValue" class="required combo-box">
            			<option value="-1">报表类型</option>
                        <option value="1" ${serchValue eq '1' ? 'selected="selected"':''}>按区域统计-井盖风楼</option>
                        <option value="2" ${serchValue eq '2' ? 'selected="selected"':''}>按区域统计-终端类型</option>
                        <option value="3" ${serchValue eq '3' ? 'selected="selected"':''}>按终端性质统计</option>
                        <option value="4" ${serchValue eq '4' ? 'selected="selected"':''}>按终端类型统计</option>
           		  </select>
            	</li>
            	  <li style="padding-top:3px;"><div class="buttonActive"><div class="buttonContent"><button type="submit">生成报表</button></div></div></li>
				</ul>

        </div>
    </form>
</div>
<div class="pageContent">
 	<c:if test="${not empty serchValue}">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="icon" href="${ctxPath}/LedgerLengthStatistics/Export/excel" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
            <li class="line">line</li>
            <li><a class="edit" href="javaScript:"  title="通道档案台账" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>地图框选</span></a></li>
            
        </ul>
    </div>
    </c:if>
      <c:if test="${serchValue eq '1'}">
    <table class="table" width="100%" layoutH="77" asc="asc" desc="desc">
        <thead>
        <tr>
            <th class="asc" width="40" align="center">序号</th>
            <th width="60">电压等级</th>
            <th width="60">长度（千米）</th>
            <th class="asc" width="60">实际长度（千米）</th>
            
          
            
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${LedgerByVoltageLevelPage}" var="ob" varStatus="vs">
            <tr>
                <td>${vs.index+1}</td>
                <td>${ob.voltageLevelName}</td>
                <td>${ob.length}</td>
                <td>${ob.realLength}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </c:if>
    <c:if test="${serchValue eq '2'}">
    <table class="table" width="100%" layoutH="77" asc="asc" desc="desc">
        <thead>
        <tr>
            <th class="asc" width="40" align="center">序号</th>
            <th width="60">通道类型</th>
            <th width="60">长度（千米）</th>
            <th class="asc" width="60">实际长度（千米）</th>
            
          
            
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${LedgerByLegerTypePage}" var="ob" varStatus="vs">
            <tr>
                <td>${vs.index+1}</td>
                <td>${ob.tunnelStructureTypeName}</td>
                <td>${ob.length}</td>
                <td>${ob.realLength}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </c:if>
     <c:if test="${serchValue eq '3'}">
    <table class="table" width="100%" layoutH="77" asc="asc" desc="desc">
        <thead>
        <tr>
            <th class="asc" width="40" align="center">序号</th>
            <th width="60">变电站</th>
            <th width="60">长度（千米）</th>
            <th class="asc" width="60">实际长度（千米）</th>
 
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${LedgerByLegerTypePage}" var="ob" varStatus="vs">
            <tr>
                <td>${vs.index+1}</td>
                <td>${ob.baseFacilityName}</td>
                <td>${ob.length}</td>
                <td>${ob.realLength}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </c:if>
     <c:if test="${serchValue eq '4'}">
    <table class="table" width="100%" layoutH="77" asc="asc" desc="desc">
        <thead>
        <tr>
            <th class="asc" width="40" align="center">序号</th>
            <th width="60">区域</th>
            <th width="60">长度（千米）</th>
            <th class="asc" width="60">实际长度（千米）</th>
 
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${LedgerByLegerTypePage}" var="ob" varStatus="vs">
            <tr>
                <td>${vs.index+1}</td>
                <td>${ob.area}</td>
                <td>${ob.length}</td>
                <td>${ob.realLength}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </c:if>
   
    <%-- <div class="panelBar">
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

    </div> --%>
</div>
