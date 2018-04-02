<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tanrong
  Date: 16/10/3
  Time: 下午2:50
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
 
</head>

<body>
<div id="a_tdtz" class="pageContent" selector="h1" layoutH="5">
  <form method="post" action="${ctxPath}/TrestleStuffType/add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div style="padding-top:10px;height:58px;">
        <input type="hidden" name="trestleStuffTypeID" value="${TrestleStuffType.trestleStuffTypeID}"/>
        <table class="tongdao-table" style="width:90%;">
         <tr>
                <td class="table-label">支架材质：</td>
                <td colspan="5">
                 <input name="trestleStuffTypeName" class="required" type="text" size="30"  value="${TrestleStuffType.trestleStuffTypeName}" />
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




