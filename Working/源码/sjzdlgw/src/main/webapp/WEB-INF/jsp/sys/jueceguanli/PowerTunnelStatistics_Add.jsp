<%--
  Created by IntelliJ IDEA.
  User: hy
  Date: 2016/10/24
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
   <form method="post" action="${ctxPath}/PowerTunnel/add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div style="padding-top:10px;height:460px;">
        <input type="hidden" name="assetNum" value="${PowerTunnel.assetNum}"/>
		<!-- <div class="panel collapse" defH="370" style="margin: 10px;">
        <h1>添加/编辑</h1>
        <div> -->
        <table class="tongdao-table" style="width:90%;">
         <tr>
                <td class="table-label">档案编号：</td>
                <td colspan="5">
                 <input name="org2.archivesNum" value="${PowerTunnel.archivesNum}" type="hidden">
                <input class="required" name="org2.archivesCode" type="text" value="${PowerTunnel.archivesCode}" suggestFields="archivesCode" suggestUrl="/Ledger/suggest_archivesNum" lookupGroup="org2"/>
                <span class="info"></span>
                
                </td>
				<td class="table-label">所属变电站：</td>
                <td colspan="5">
                  <select name="baseFacilityNum" class=" combo-box">
                    <c:forEach items="${BaseFacility}" var="ob" varStatus="id">

                        <option value="${ob.baseFacilityNum}"  ${PowerTunnel.baseFacilityNum eq ob.baseFacilityNum ? 'selected="selected"':''} >${ob.baseFacilityName}</option>
                    </c:forEach>
                </select>
                
                </td>
				<td class="table-label">所属片区：</td>
                <td colspan="5">
                  <select name="areaNum" class="required combo-box">
                    <c:forEach items="${Areas}" var="ob" varStatus="id">

                        <option value="${ob.areaNum}"  ${PowerTunnel.areaNum eq ob.areaNum ? 'selected="selected"':''} >${ob.areaName}</option>
                    </c:forEach>
                </select>
                
                </td>
				
			</tr>
			<tr>
				<td class="table-label">类型：</td>
                <td colspan="5">
                  <select name="tunnelStructureTypeID" class="required combo-box">
                    <c:forEach items="${tunnelStructureType}" var="ob" varStatus="id">

                        <option value="${ob.tunnelStructureTypeID}"  ${PowerTunnel.tunnelStructureTypeID eq ob.tunnelStructureTypeID ? 'selected="selected"':''} >${ob.tunnelStructureTypeName}</option>
                    </c:forEach>
                </select>
                
                </td>
				<td class="table-label">通道编号：</td>
                <td colspan="5">
                  <input name="assetCode" type="text" size="30" alt="通道编号" value="${PowerTunnel.assetCode}" />
                
                </td>
				<td class="table-label">运行编号：</td>
                <td colspan="5">
                  <input name="operationCode" type="text" size="30" alt="运行编号" value="${PowerTunnel.operationCode}" />
                
                </td>
			</tr>
			<tr>
				<td class="table-label">运检班组：</td>
                <td colspan="5">
                   <select name="organizationNum" class="required combo-box">
                    <c:forEach items="${organization}" var="ob" varStatus="id">

                        <option value="${ob.organizationNum}"  ${PowerTunnel.organizationNum eq ob.organizationNum ? 'selected="selected"':''} >${ob.organizationName}</option>
                    </c:forEach>
                </select>
                
                </td>
				<td class="table-label">材质：</td>
                <td colspan="5">
                  <select name="tunnelStuffTypeID" class="required combo-box">
                    <c:forEach items="${TunnelStuffType}" var="ob" varStatus="id">

                        <option value="${ob.tunnelStuffTypeID}"  ${PowerTunnel.tunnelStuffTypeID eq ob.tunnelStuffTypeID ? 'selected="selected"':''} >${ob.tunnelStuffTypeName}</option>
                    </c:forEach>
                </select>
                
                </td>
				<td class="table-label">尺寸：</td>
                <td colspan="5">
                  <input name="tunnelSize" type="text" size="30" alt="尺寸" value="${PowerTunnel.tunnelSize}" />
                
                </td>
			</tr>
			<tr>
                <td class="table-label">长度：</td>
                <td colspan="5">
                <input name="tunnelLength" type="number" size="30" alt="长度,单位(米)" value="${PowerTunnel.tunnelLength}" />
                </td>
           
            
                <td class="table-label">覆土深度：</td>
                <td colspan="5">
                <input name="frontTopHeight" type="number" size="30" alt="覆土深度,单位(米)" value="${PowerTunnel.frontTopHeight}" />
                </td>
           
                <td class="table-label">电压等级：</td>
                <td colspan="5">
                <select name="voltageLevelID" class="required combo-box">
                    <c:forEach items="${voltageLevel}" var="ob" varStatus="id">

                        <option value="${ob.voltageLevelID}"  ${PowerTunnel.voltageLevelID eq ob.voltageLevelID ? 'selected="selected"':''} >${ob.voltageLevelName}</option>
                    </c:forEach>
                </select>
                </td>
            </tr>

            <tr>
                <td class="table-label">支架规格：</td>
                <td colspan="5">
                <input name="trestleTypeDescription" type="text" size="30" alt="支架规格" value="${PowerTunnel.trestleTypeDescription}" />
 				</td>
 				<td class="table-label">施工单位：</td>
                <td colspan="5">
                <input name="build_company.companyNum" value="${PowerTunnel.buildCompany}" type="hidden">
                <input class="required" name="build_company.companyName" type="text" value="${PowerTunnel.buildCompanyStr}" suggestFields="companyName" suggestUrl="/Company/suggest_company?type=2&" lookupGroup="build_company"/>
                </td>

                <td class="table-label">监理单位：</td>
               <td colspan="5">
                <input name="monitor_company.companyNum" value="${PowerTunnel.monitorCompany}" type="hidden">
                <input class="required" name="monitor_company.companyName" type="text" value="${PowerTunnel.monitorCompanyStr}" suggestFields="companyName" suggestUrl="/Company/suggest_company?type=1&companyName=" lookupGroup="monitor_company"/>
                </td>

            </tr>
            <tr>
                <td class="table-label">竣工日期：</td>

                <td colspan="5">
                <input name="completedDate" type="text" alt="" value="${PowerTunnel.completedDateStr}" class="date" size="30" />
                <a class="inputDateButton" href="javascript:;" style="position:relative;left:152px;top:-20px">选择</a>
                </td>
          
               <%--  <td class="table-label">投运日期：</td>
                <td colspan="5">
                <input name="operationDate" type="text" alt="" value="${PowerTunnel.operationDateStr}" class="date" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
                </td> --%>

            </tr>
            <tr>
                <td class="table-label">起止点位置：</td>
                <td colspan="5">
                <textarea rows="3" cols="80" name="startStopDescription">${PowerTunnel.startStopDescription}</textarea>
               <%--  <input name="startStopDescription" type="text" size="30" alt="起止点位置" value="${PowerTunnel.startStopDescription}" /> --%>
                </td>
            </tr>
            <tr>
                <td class="table-label">地理方位：</td>
                <td colspan="5">
                <textarea rows="3" cols="80" name="positionDescription">${PowerTunnel.positionDescription}</textarea>
                <%-- <input name="positionDescription" type="text" size="30" alt="地理方位" value="${PowerTunnel.positionDescription}" /> --%>
                </td>
            </tr>
            <tr>
                <td class="table-label">备注：</td>
                <td colspan="5">
                <textarea rows="3" cols="80" name="memo">${PowerTunnel.memo}</textarea>
                <%-- <input name="memo" type="text" size="30" alt="备注" value="${PowerTunnel.memo}" /> --%>
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



