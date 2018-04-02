<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/22
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<div class="pageContent">
    <div>
        <div>
            <table class="table" width="100%">
                <thead>
                <tr>
                    <th>设备名称</th>
                    <th>相位名称</th>
                    <th>规格编号</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pathCableWrappers}" var="loop" varStatus="vs">
                    <tr>
                        <td>${loop.cableName}</td>
                        <td>${loop.phaseTypeName}</td>
                        <td>${loop.modelTypeName}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
