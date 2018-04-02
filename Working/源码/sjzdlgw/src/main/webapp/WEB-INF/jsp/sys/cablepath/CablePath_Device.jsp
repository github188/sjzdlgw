<%--
  Created by IntelliJ IDEA.
  User: wiipu
  Date: 2016/10/22
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<div class="pageContent">
    <div>
        <div>
            <table class="table" width="100%">
                <thead>
                <tr>
                    <th>运行编号</th>
                    <th>回路名称</th>
                    <th>投运时间</th>
                    <th>查看</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${powerLoops}" var="loop" varStatus="vs">
                    <tr>
                        <td>${loop.runCode}</td>
                        <td>${loop.loopName}</td>
                        <td><fmt:formatDate value="${loop.runDate}" pattern="yyyy-MM-dd"/></td>
                        <td><a target="dialog" href="${ctxPath}/CablePath/showBaseFacilities/${loop.loopNum}">查看</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
