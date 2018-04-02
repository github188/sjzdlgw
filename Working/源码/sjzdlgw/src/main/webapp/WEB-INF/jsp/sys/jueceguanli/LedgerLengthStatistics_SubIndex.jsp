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
            <th>通道类型</th>
            <th>长度（千米）</th>
            <th>实际长度（千米）</th>
        </thead>
        <tbody>
        <c:if test="${serchValue eq '1'}">
            <c:forEach items="${subPages}" var="ob" varStatus="vs">
            <c:if test="${ID eq ob.voltageLevelID}">
                <tr>
                 	<%-- <td>${vs.index+1}</td> --%>
                    <td align="center">${ob.tunnelStructureTypeName}</td>
                    <td align="center">${ob.length}</td>
                    <td align="center">${ob.realLength}</td>
                </tr>
            </c:if>
            </c:forEach>
         </c:if>
         <c:if test="${serchValue eq '3'}">
            <c:forEach items="${subPages}" var="ob" varStatus="vs">
            <c:if test="${ID eq ob.baseFacilityNum}">
                <tr>
                 	<%-- <td>${vs.index+1}</td> --%>
                    <td align="center">${ob.tunnelStructureTypeName}</td>
                    <td align="center">${ob.length}</td>
                    <td align="center">${ob.realLength}</td>
                </tr>
            </c:if>
            </c:forEach>
         </c:if>
         <c:if test="${serchValue eq '4'}">
            <c:forEach items="${subPages}" var="ob" varStatus="vs">
            <c:if test="${ID eq ob.typeId}">
                <tr>
                 	<%-- <td>${vs.index+1}</td> --%>
                    <td align="center">${ob.tunnelStructureTypeName}</td>
                    <td align="center">${ob.length}</td>
                    <td align="center">${ob.realLength}</td>
                </tr>
            </c:if>
            </c:forEach>
         </c:if>
        </tbody>

    </table>
</div>