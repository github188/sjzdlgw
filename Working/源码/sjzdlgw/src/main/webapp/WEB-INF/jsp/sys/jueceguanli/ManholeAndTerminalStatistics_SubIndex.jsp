<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 2016/11/8
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>

<div class="pageContent">
   
 
    <table class="table" width="106%" layoutH="15" asc="asc" desc="desc">
        <thead>
        	<!-- <th>序号</th> -->
            <th>终端类型</th>
            <th>数量</th>
        </thead>
        <tbody>
            <c:forEach items="${ManholeSatisticsByKindSubPages}" var="ob" varStatus="vs">
            <c:if test="${manholeTypeID eq ob.manholeTypeID}">
                <tr>
                 	<%-- <td align="center">${vs.index+1}</td> --%>
                    <td align="center">${ob.manholeKindTypeName}</td>
                    <td align="center">${ob.count}</td>
                </tr>
            </c:if>
            </c:forEach>
        </tbody>

    </table>
</div>