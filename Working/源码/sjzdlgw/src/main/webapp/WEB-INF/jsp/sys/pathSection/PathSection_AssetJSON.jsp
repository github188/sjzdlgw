<%--
  Created by IntelliJ IDEA.
  User: GalaIO
  Date: 2016/11/14
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
[
    <c:forEach var="item" items="${manholeList}">
        ["${item.assetNum}", "${item.assetName}"],
    </c:forEach>
]
