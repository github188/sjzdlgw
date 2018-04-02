<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="pageContent">
    <form method="post" action="${ctxPath}/PowerTunnel/add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" name="assetNum" value="${PowerTunnel.assetNum}"/>
        <div class="pageFormContent power-width" layoutH="56">
            <p>
                <label>档案编号：</label>
                <input name="archivesNum" value="${PowerTunnel.archivesNum}" type="hidden">
                <input name="archivesCode" type="text" value="${PowerTunnel.archivesCode}" disabled/>
                <span class="info"></span>
            </p>
            <p>
                <label>所属片区：</label>
                <select name="areaNum" class="required combo-box">
                    <c:forEach items="${Areas}" var="ob" varStatus="id">

                        <option value="${ob.areaNum}"  ${PowerTunnel.areaNum eq ob.areaNum ? 'selected="selected"':''} >${ob.areaName}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label>类　　型：</label>
                <select name="tunnelStructureTypeID" class="required combo-box">
                    <c:forEach items="${tunnelStructureType}" var="ob" varStatus="id">

                        <option value="${ob.tunnelStructureTypeID}"  ${PowerTunnel.tunnelStructureTypeID eq ob.tunnelStructureTypeID ? 'selected="selected"':''} >${ob.tunnelStructureTypeName}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label>通道编号：</label>
                <input name="assetCode" type="text" size="30" value="${PowerTunnel.assetCode}" />
            </p>
            <p>
                <label>运行编号：</label>
                <input name="operationCode" type="text" size="30" value="${PowerTunnel.operationCode}" />
            </p>
            <p>
                <label>运检班组：</label>
                <select name="organizationNum" class="required combo-box">
                    <c:forEach items="${organization}" var="ob" varStatus="id">

                        <option value="${ob.organizationNum}"  ${PowerTunnel.organizationNum eq ob.organizationNum ? 'selected="selected"':''} >${ob.organizationName}</option>
                    </c:forEach>
                </select>
            </p>

            <p>
                <label>材　　质：</label>
                <select name="tunnelStuffTypeID" class="required combo-box">
                    <c:forEach items="${TunnelStuffType}" var="ob" varStatus="id">

                        <option value="${ob.tunnelStuffTypeID}"  ${PowerTunnel.tunnelStuffTypeID eq ob.tunnelStuffTypeID ? 'selected="selected"':''} >${ob.tunnelStuffTypeName}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label>尺　　寸：</label>
                <input name="tunnelSize" type="text" size="30" value="${PowerTunnel.tunnelSize}" />
            </p>
            <p>
                <label>长　度(米)：</label>
                <input name="tunnelLength" type="number" size="30" value="${PowerTunnel.tunnelLength}" />
            </p>
            <p>
                <label>覆土深度(米)：</label>
                <input name="frontTopHeight" type="number" size="30" value="${PowerTunnel.frontTopHeight}" />
            </p>
            <p>
                <label>电压等级：</label>
                <select name="voltageLevelID" class="required combo-box">
                    <c:forEach items="${voltageLevel}" var="ob" varStatus="id">

                        <option value="${ob.voltageLevelID}"  ${PowerTunnel.voltageLevelID eq ob.voltageLevelID ? 'selected="selected"':''} >${ob.voltageLevelName}</option>
                    </c:forEach>
                </select>
            </p>

            <p>
                <label>支架规格：</label>
                <input name="trestleTypeDescription" type="text" size="30" value="${PowerTunnel.trestleTypeDescription}" />
            </p>
            <p>
                <label>施工单位：</label>
                <input name="build_company.companyNum" value="${PowerTunnel.buildCompany}" type="hidden">
                <input class="required" name="build_company.companyName" type="text" value="${PowerTunnel.buildCompanyStr}" suggestFields="companyName" suggestUrl="/Company/suggest_company?type=2&" lookupGroup="build_company"/>


            </p>
            <p>
                <label>监理单位：</label>
                <input name="monitor_company.companyNum" value="${PowerTunnel.monitorCompany}" type="hidden">
                <input class="required" name="monitor_company.companyName" type="text" value="${PowerTunnel.monitorCompanyStr}" suggestFields="companyName" suggestUrl="/Company/suggest_company?type=1&companyName=" lookupGroup="monitor_company"/>

            </p>
            <p>
                <label>竣工日期：</label>

                <input name="completedDate" type="text" alt="" value="${PowerTunnel.completedDateStr}" class="date input-icon" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
            </p>
            <p>
                <label>投运日期：</label>
                <input name="operationDate" type="text" alt="" value="${PowerTunnel.operationDateStr}" class="date input-icon" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>

            </p>
            <dl class="nowrap">
                <dt>起止点位置：</dt>
                <dd><textarea name="startStopDescription" cols="80" rows="2">${PowerTunnel.startStopDescription}</textarea></dd>
            </dl>
            <dl class="nowrap">
                <dt>地理方位：</dt>
                <dd><textarea name="positionDescription" cols="80" rows="2">${PowerTunnel.positionDescription}</textarea></dd>
            </dl>
            <dl class="nowrap">
                <dt>备　　注：</dt>
                <dd><textarea name="memo" cols="80" rows="2">${PowerTunnel.memo}</textarea></dd>
            </dl>
        </div>
        <div class="formBar">
            <ul>
                <c:if test="${isDbClick ne 1}">
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
                </c:if>
                <li>     <input type="hidden" id="test" value="${isDbClick}">
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div>
    </form>
</div>
<style>
    .power-width input,.power-width select{
        display:inline-block;
        box-sizing: border-box;
        width:216.6px;
        height:21px;
    }
    .power-width select{
        margin-left:0px;
    }
    .power-width .input-icon{
        width:202px;
    }
    .power-width textarea{
        width:594px;
    }
</style>


