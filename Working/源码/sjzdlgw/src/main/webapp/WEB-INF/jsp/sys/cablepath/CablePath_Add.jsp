<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<style>
    .tongdao-table tr {
        height:40px;
    }
    .tongdao-table td {
        padding:8px 0;
    }
    .tongdao-table input,.tongdao-table select{
        width:148px;
    }
    .tongdao-table a {
        width:125px;
    }
</style>
<form method="post" action="${ctxPath}/CablePath/${cablePathType}/add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
    <input type="hidden" name="cablePathNum" value="${PageModelCablePath.cablePathNum}"/>
    <div id="a_tdtz" class="pageContent" selector="h1" layoutH="55">
        <div style="padding:10px 0 0 10px;">
            <table class="tongdao-table">
                <tbody>
                <tr>
                    <td class="table-label">线路名称:</td>
                    <td>
                        <input name="cablePathName" type="text" size="30" value="${PageModelCablePath.cablePathName}"
                               class="required textInput">
                    </td>

                    <td class="table-label">线路编号:</td>
                    <td>
                        <input name="cablePathCode" type="text" size="30" value="${PageModelCablePath.cablePathCode}"
                               class="required textInput">
                    </td>

                    <td class="table-label">线路区域:</td>
                    <td>
                        <select name="areaNum" class="required combox">
                            <option value="">请选择线路区域</option>
                            <c:forEach var="item" items="${PageModelAreaList}">
                                <option value="${item.areaNum}" ${PageModelCablePath.areaNum eq item.areaNum ? 'selected="selected"':''} >${item.areaName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="table-label">运检班组:</td>
                    <td>
                        <select name="organizationNum" class="required combox">
                            <option value="">请选择分接箱规格</option>
                            <c:forEach var="item" items="${PageModelOrganizationList}">
                                <option value="${item.organizationNum}" ${PageModelCablePath.organizationNum eq item.organizationNum ? 'selected="selected"':''} >${item.organizationName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td class="table-label">电压等级:</td>
                    <td>
                        <select name="voltageLevelID" class="required combox">
                            <option value="">请选择电压等级</option>
                            <c:forEach var="item" items="${PageModelPowerCableLevelList}">
                                <option value="${item.voltageLevelID}" ${PageModelCablePath.voltageLevelID eq item.voltageLevelID ? 'selected="selected"':''} >${item.voltageLevelName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    </td>
                    <c:if test="${type == 2}">
                        <td class="table-label">变电站:</td>
                        <td>
                            <select name="baseFacilityNum" class="required combox">
                                <option value="">请选择变电站</option>
                                <c:forEach var="item" items="${baseFacilityList}">
                                    <option value="${item.baseFacilityNum}" ${PageModelCablePath.voltageLevelID eq item.baseFacilityNum ? 'selected="selected"':''} >${item.baseFacilityName}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </c:if>
                </tr>
                <c:if test="${type == 1}">
                    <tr class="textbox">
                        <td class="table-label">起点位置:</td>
                        <td colspan="5">
                            <textarea cols="88" name="beginPlace" rows="3" style="width:100%;"
                                      class="textInput">${PageModelCablePath.beginPlace}</textarea>
                        </td>
                    </tr>
                    <tr class="textbox">
                        <td class="table-label">止点位置:</td>
                        <td colspan="5">
                            <textarea cols="88" name="endPlace" rows="3" style="width:100%;"
                                      class="textInput">${PageModelCablePath.endPlace}</textarea>
                        </td>
                    </tr>
                </c:if>
                <tr class="textbox">
                    <td class="table-label">敷设方式:</td>
                    <td colspan="5">
                        <textarea cols="88" name="layingMethod" rows="3" style="width:100%;"
                                  class="textInput">${PageModelCablePath.layingMethod}</textarea>
                    </td>
                </tr>
                <c:if test="${type == 1}">
                    <tr class="textbox">
                        <td class="table-label">敷设备注:</td>
                        <td colspan="5">
                            <textarea cols="88" name="layingMemo" rows="3" style="width:100%;"
                                      class="textInput">${PageModelCablePath.layingMemo}</textarea>
                        </td>
                    </tr>
                </c:if>
                <tr class="textbox">
                    <td class="table-label">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</td>
                    <td colspan="5">
                        <textarea cols="88" name="memo" rows="3" style="width:100%;"
                                  class="textInput">${PageModelCablePath.memo}</textarea>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="formBar">
        <ul>
            <c:if test="${isDbClick ne 1}">
                <li>
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <button type="submit">保存</button>
                        </div>
                    </div>
                </li>
            </c:if>
            <li>
                <input type="hidden" id="test" value="${isDbClick}">
                <div class="button">
                    <div class="buttonContent">
                        <button type="button" class="close">取消</button>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</form>
<style>
    <%-- 添加文本输入框间距 --%>
    .textbox textarea{
        margin:4px 0;
    }
</style>