<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: tanrong
  Date: 16/10/1
  Time: 下午9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<form id="pagerForm" action="demo/database/dwzOrgLookup2.html">--%>
    <form id="pagerForm" action="#rel#">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}"/>
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}"/>
    <input type="hidden" name="orderField" value="${param.orderField}"/>
    <input type="hidden" name="orderDirection" value="${param.orderDirection}"/>

</form>

<div class="pageHeader">
    <form rel="pagerForm"action="${ctxPath}/Ledger/many_choice?type=${type}&name=${name}" onsubmit="return dwzSearch(this,'dialog')" method="post" ;>
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td>
                        公司名称：<input type="text" name="companyName" value="${companyName}" minlength="1" maxlength="5"/>
                 </td>
                </tr>
            </table>
            <div class="subBar">
                <ul>
                    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
                    <li><div class="button"><div class="buttonContent"><button type="button" multLookup="${name}" warn="请选择单位">选择带回</button></div></div></li>
                </ul>
            </div>
        </div>
    </form>
</div>
<div class="pageContent">

    <table class="table" layoutH="118" targetType="dialog" width="100%">
        <thead>
        <tr>
            <th width="30"><input type="checkbox" class="checkboxCtrl" group="${name}" /></th>
            <th orderfield="companyName">单位名称</th>
            <th orderfield="companyId">单位编号</th>
            <th orderfield="contact">联系人</th>
            <th orderfield="contactPhone">联系人电话</th>
            <th orderfield="memo">备注</th>
        </tr>
        </thead>
        <tbody>
        <%--<c:forEach items="${data}" var="ob" varStatus="id" begin="0">--%>
            <c:forEach items="${pageForm.listDatas}" var="ob">
            <tr>
                <td><input type="checkbox" name="${name}" value="{companyName:'${ob.companyName}', companyId:'${ob.companyNum}',contact:'${ob.contact}',contactPhone:'${ob.contactPhone}', memo:'${ob.memo}'}"/></td>
                <td>${ob.companyName}</td>
                <td>${ob.companyNum}</td>
                <td>${ob.contact}</td>
                <td>${ob.contactPhone}</td>
                <td>${ob.memo}</td>
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
</body>
</html>
