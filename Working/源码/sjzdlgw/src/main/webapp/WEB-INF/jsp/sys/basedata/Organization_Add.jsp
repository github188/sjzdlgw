<%--
  Created by IntelliJ IDEA.
  User: hy
  Date: 2016/10/12
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%-- <%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="${ctx}/static/website/css/addpage.css" rel="stylesheet" type="text/css" />
    <script src="${ctx}/static/website/js/addpage.js" type="text/javascript" ></script>
 <style>
    .tongdao-table tr {
        height:40px;
    }
</style>
</head>

<body>
<div id="a_tdtz" class="pageContent" selector="h1" layoutH="5">
 <form method="post" action="${ctxPath}/Organization/add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
       <div style="padding-top:10px;height:108px;">
        <input type="hidden" name="organizationNum" value="${Organization.organizationNum}"/>
        <table class="tongdao-table" style="width:90%;">
         <tr>
                <td class="table-label">部门名称：</td>
                <td colspan="5">
                <input name="organizationName" type="text" size="20" value="${Organization.organizationName}"  class="required" maxlength="8"/>
          
                </td>
				  <td class="table-label">上级部门：</td>
                <td colspan="5">
                <select class="required" name="parentID">
                    <c:forEach var="item" items="${OrganizationList}">
                        <option value="${item.organizationNum}" ${Organization.parentID eq item.organizationNum ? 'selected="selected"':''} >${item.organizationName}</option>
                    </c:forEach>
                </select>
                </td>
            </tr>
			<tr>
				  <td class="table-label">相关专业：</td>
                <td colspan="5">
                <select class="required" name="teamTypeID">
                    <c:forEach var="item" items="${teamTypeList}">
                        <option value="${item.teamTypeID}" ${Organization.teamTypeID eq item.teamTypeID ? 'selected="selected"':''} >${item.teamTypeName}</option>
                    </c:forEach>
                </select>
                </td>
			<td class="table-label">描述：</td>
                <td colspan="5">
                <%-- <input name="description" type="text" size="20" value="${Organization.description}" alt="部门描述" maxlength="99"/> --%>
            <textarea name="description"  cols="160" style="width:120%;height:50px;">${Organization.description}</textarea>
                </td>
			</tr>

            </table>
        </div>
        <div class="formBar">
            <ul>
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
                <li>
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div>
    </form>
</div>
</body>
</html>



