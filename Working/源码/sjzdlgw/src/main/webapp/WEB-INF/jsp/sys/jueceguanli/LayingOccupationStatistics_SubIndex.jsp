<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>

<div class="pageContent">
   
 
    <table class="table" width="106%" layoutH="15" asc="asc" desc="desc">
        <thead>
        <tr>
        	<!-- <th>序号</th> -->
            <th>区段序号</th>
            <th>区段长度（米）</th>
            <th>状态</th>
             <th>允许敷设数量</th>
            <th>已敷设数量</th>
            <th>预占位数量</th>
             <th>剩余数量</th>
            <th>区段走向</th>
         </tr>
        </thead>
        <tbody>
  			<c:forEach items="${LayingOccupationSubPages}" var="ob" varStatus="vs">
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
                  <%--   <td align="center">${ob.sectionNum}</td> --%>
                    <td align="center">${ob.length}</td>
                    <td align="center">${ob.laystatus}</td>
                    <td align="center">${ob.laycount}</td>
                    <td align="center">${ob.totalcount}</td>
                    <td align="center">${ob.prelaycount}</td>
                    <td align="center">${ob.restcount}</td>
                    <td align="center">${ob.tunnleTowardTypeName}</td>
                </tr>
                </c:forEach>
        </tbody>

    </table>
</div>