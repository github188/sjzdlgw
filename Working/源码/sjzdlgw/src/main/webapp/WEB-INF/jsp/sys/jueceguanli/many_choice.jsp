<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tanrong
  Date: 16/10/1
  Time: 下午9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="pagerForm" action="demo/database/dwzOrgLookup2.html">
    <input type="hidden" name="pageNum" value="1" />
    <input type="hidden" name="numPerPage" value="${model.numPerPage}" />
    <input type="hidden" name="orderField" value="${param.orderField}" />
    <input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>

<div class="pageHeader">
    <form rel="pagerForm" method="post" action="demo/database/dwzOrgLookup2.html" onsubmit="return dwzSearch(this, 'dialog');">
        <div class="searchBar">
            <div class="subBar">
                <ul>
                	<li><div class="button"><div class="buttonContent"><button type="button" multLookup="${name}" warn="请选择单位">选择带回</button></div></div></li>
                </ul>
            </div>
        </div>
    </form>
</div>
<div class="pageContent">
	 <div class="panelBar">
        <ul class="toolBar">
			<li><a class="add" href="${ctxPath}/LedgerStatistics/addCompany/-1?type=${companyType}" target="dialog" rel="Company_Index_01" title="单位添加" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>添加</span></a></li>
        </ul>
        </div>    		
    <table class="table" layoutH="118" targetType="dialog" width="100%">
        <thead>
        <tr>
            <th width="30"><input type="checkbox" class="checkboxCtrl" group="${name}" /></th>
            <th>单位名称</th>
            <th>单位地址</th>
            <th>单位电话</th>
            <th>联系人</th>
            <th>联系方式</th>
            <th>备注</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${data}" var="ob" varStatus="id" begin="0">
            <tr>
                <td><input type="checkbox" name="${name}" value="{companyName:'${ob.companyName}', companyId:'${ob.companyNum}', memo:'${ob.memo}'}"/></td>
                <td>${ob.companyName}</td>
                <td>${ob.companyAddr}</td>
                <td>${ob.companyPhone}</td>
                <td>${ob.contact}</td>
                <td>${ob.contactPhone}</td>
                <td>${ob.memo}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
