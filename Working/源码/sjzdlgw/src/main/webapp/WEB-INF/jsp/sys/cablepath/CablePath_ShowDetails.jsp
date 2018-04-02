<%--
  Created by IntelliJ IDEA.
  User: wiipu
  Date: 2016/10/22
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<div class="pageContent">
    <div class="div1">
        <table class="table" targetType="dialog" width="100%">
            <thead>
            <tr>
                <th>序号</th>
                <th >线路段编号</th>
                <th>线路段名称</th>
                <th>起点</th>
                <th>终点</th>
                <th>回数</th>
                <th>条数</th>
                <th>回长</th>
                <th>总回长</th>
                <th>接地方式</th>
                <th>敷设方式</th>
                <th >起点设备</th>
                <th >止点设备</th>
                <th>备注</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pathSectionPages}" var="li" varStatus="vs">
                <tr target="sid_CablePath" rel="${li.cablePathNum}">
                    <td>${vs.index+1}</td>
                    <td>${li.pathSectionNum}</td>
                    <td>${li.pathSectionName}</td>
                    <td>${li.placeInfo}</td>
                    <td>${li.placeInfo2}</td>
                    <td>${li.loopCount}</td>
                    <td>${li.lineCount}</td>
                    <td>${li.loopLenght}</td>
                    <td>${li.loopLenght*3}</td>
                    <td>${li.safeEarthTypeName}</td>
                    <td>${li.installTypeName}</td>
                    <td>${li.begin_AssetNum}</td>
                    <td>${li.end_AssetNum}</td>
                    <td>${li.memo}</td>
                    <td><a target="dialog" rel="CablePath_Index_04" href="${ctxPath}/CablePath/showPowerLoops/${li.pathSectionNum}">查看</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
