<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 2016/11/8
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>

<style>
    .a-searchBar {
        width:100%;
        overflow: hidden;
    }
    .a-searchBar li {
        width:300px;
        height:30px;
        float:left;
    }
    select{width:213px;}
</style>
<div class="pageHeader">
    <form  onsubmit="return navTabSearch(this);" action="${ctxPath}/ManholeAndTerminalStatistics/index" method="post">
        <div class="searchBar">
            <ul class="a-searchBar">
                <li>
                    <label>报表类型：</label>
                    <select class="combox" name="serchValue">
            			<option value="-1">报表类型</option>
                        <option value="1" ${serchValue eq '1' ? 'selected="selected"':''}>按区域统计-井盖风楼</option>
                        <option value="2" ${serchValue eq '2' ? 'selected="selected"':''}>按区域统计-终端类型</option>
                        <option value="3" ${serchValue eq '3' ? 'selected="selected"':''}>按终端性质统计</option>
                        <option value="4" ${serchValue eq '4' ? 'selected="selected"':''}>按终端类型统计</option>
           		  </select>
                </li>
                <li>
                    <div class="buttonActive" style="margin-right:5px;">
                        <div class="buttonContent">
                            <button type="submit">生成报表</button>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </form>
</div>
<div class="pageContent">
    <c:if test="${not empty serchValue}">
    <div class="panelBar">
        <ul class="toolBar">
            <li controlID="6420"><a class="icon" href="${ctxPath}/ManholeAndTerminalStatistics/Export/excel/${serchValue}" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
           
        </ul>
    </div>
    </c:if>
     <c:if test="${serchValue eq '1'}">
    <table class="table" width="100%" layoutH="78" asc="asc" desc="desc">
        <thead>
        	<th>序号</th>
        	<th>区域</th>
            <th>类型</th>
            <th>数量</th>
        </thead>
        <tbody>
            <c:forEach items="${ManholeSatisticsByKindPage}" var="ob" varStatus="vs">
                <tr>
                 	<td>${vs.index+1}</td>
                 	<td>${ob.area}</td>
                    <td>${ob.type}</td>
                    <td>${ob.count}</td>
                </tr>
            </c:forEach>
        </tbody>

    </table>
    </c:if>
     <c:if test="${serchValue eq '2'}">
    <table class="table" width="100%" layoutH="78" asc="asc" desc="desc">
        <thead>
        	<th>序号</th>
        	<th>区域</th>
            <th>类型</th>
            <th>数量</th>
        </thead>
        <tbody>
            <c:forEach items="${ManholeSatisticsByKindPage}" var="ob" varStatus="vs">
                <tr>
                 	<td>${vs.index+1}</td>
                 	<td>${ob.area}</td>
                    <td>${ob.type}</td>
                    <td>${ob.count}</td>
                </tr>
            </c:forEach>
        </tbody>

    </table>
    </c:if>
     <c:if test="${serchValue eq '3'}">
    <table id="table1" class="table" width="100%" layoutH="78" asc="asc" desc="desc">
        <thead>
        	<th>序号</th>
            <th>终端性质</th>
            <th>数量</th>
            <th>操作</th>
        </thead>
        <tbody>
            <c:forEach items="${ManholeSatisticsByKindPage}" var="ob" varStatus="vs">
                <tr target="rid" rel="2">
                 	<td>${vs.index+1}</td>
                    <td>${ob.manholeKindTypeName}</td>
                    <td>${ob.count}</td>
                    <td><a class="edit" href="${ctxPath}/ManholeAndTerminalStatistics/sub/index/?manholeTypeID=${ob.manholeTypeID}" target="dialog" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="450">详细信息</a></td>
                </tr>
            </c:forEach>
        </tbody>

    </table>
    </c:if>
    <c:if test="${serchValue eq '4'}">
    <table class="table" width="100%" layoutH="78" asc="asc" desc="desc">
        <thead>
        	<th>序号</th>
            <th>终端类型</th>
            <th>数量</th>
        </thead>
        <tbody>
            <c:forEach items="${ManholeSatisticsByKindPage}" var="ob" varStatus="vs">
                <tr>
                 	<td>${vs.index+1}</td>
                    <td>${ob.manholeKindTypeName}</td>
                    <td>${ob.count}</td>
                </tr>
            </c:forEach>
        </tbody>

    </table>
    </c:if>
</div>