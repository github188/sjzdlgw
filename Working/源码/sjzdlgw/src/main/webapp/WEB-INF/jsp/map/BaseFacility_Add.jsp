<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tanrong
  Date: 16/10/3
  Time: 下午2:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<div id="a_tdtz" class="pageContent" selector="h1" layoutH="20">
    <form method="post" action="${ctxPath}/BaseFacility/add" class="pageForm required-validate" onsubmit="return validateCallback(this);">
        <div style="padding-top:10px;height:78px;">
        <input type="hidden" name="baseFacilityNum" value="${BaseFacility.baseFacilityNum}"/>
            <table class="tongdao-table" style="width:90%;">
            <tr>
                <td class="table-label">变电站名称:</td>
               <td colspan="5">
                   <input name="baseFacilityName" class="required" type="text" size="30" alt="请输入变电站名称" value="${BaseFacility.baseFacilityName}" />
               </td>
                <td class="table-label">资产编码：</td>
                <td colspan="5">
                    <input name="assetCode" type="text" size="30" value="${BaseFacility.assetCode}" />
                </td>
            </tr>
            <tr>
                <td class="table-label">位置描述:</td>
                <td colspan="5">
                    <input name="baseFacilityDescription" type="text" size="30" alt="请输入位置描述" value="${BaseFacility.baseFacilityDescription}" />
                </td>
                <td class="table-label">区域：</td>
               <td colspan="5">
                   <select class="required" name="areaNum">
                    <option value="">请选择区域</option>
                    <c:forEach var="item" items="${AreaList}">
                        <option value="${item.areaNum}" ${BaseFacility.areaNum eq item.areaNum ? 'selected="selected"':''} >${item.areaName}</option>
                    </c:forEach>
                </select>
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



