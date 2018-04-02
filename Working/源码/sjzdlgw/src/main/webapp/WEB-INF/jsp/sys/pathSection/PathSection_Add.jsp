<%--
  Created by IntelliJ IDEA.
  User: GalaIO
  Date: 2016/11/6
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
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
<form method="post" action="${ctxPath}/PathSection/${type}/edit/${editType}/${not empty pathSectionPage.pathSectionNum ? pathSectionPage.pathSectionNum:-1}?cablePathNum=${cablePath.cablePathNum}" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
    <div id="a_tdtz" class="pageContent" selector="h1" layoutH="55">
            <div  style="padding:10px 0 0 10px;height:359px;">
                <table class="tongdao-table"  style="width:97%;">
                    <tbody>
                    <tr>
                        <td class="table-label" style="width: 80px">线路编号:</td>
                        <td>
                            <input  name="cablePathNum" type="text" size="30" value="${cablePath.cablePathNum}" class="textInput" hidden="hidden">
                            <input  name="cablePathCode" type="text" size="30" value="${cablePath.cablePathCode}" class="required textInput" disabled="disabled">
                        </td>

                        <td class="table-label" style="width: 80px">线路段编号:</td>
                        <td>
                            <input  name="pathSectionCode" type="text" size="30" value="${pathSectionPage.pathSectionCode}" class="required textInput">
                            <input  name="pathSectionNum" type="text" size="30" value="${pathSectionPage.pathSectionNum}" class="textInput" hidden="hidden">
                        </td>

                        <td class="table-label" style="width: 80px">线路段名称:</td>
                        <td>
                            <input  name="pathSectionName" type="text" size="30" value="${pathSectionPage.pathSectionName}" class="required textInput">
                        </td>
                    </tr>
                    <tr>
                        <td class="table-label" style="width: 90px">起点设备类型:</td>
                        <td>
                            <select name="begin_AssetType" class="combox" ref="begin_asset" refUrl="/PathSection/asset/{value}">
                                <option value="-1">请选择起点设备类型</option>
                                <c:forEach var="item" items="${manholeKindTypeList}">
                                <option value="${item.manholeKindTypeID}" ${pathSectionPage.manholeKindTypeID eq item.manholeKindTypeID?'selected="selected"':''}>${item.manholeKindTypeName}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td class="table-label">起点设备:</td>
                        <td>
                            <select name="begin_AssetNum" class="combox" id="begin_asset" style="width: 200px;">
                                <option value="">请选择起点设备</option>
                                <c:if test="${not empty pathSectionPage.begin_AssetNum}">
                                    <option value="${pathSectionPage.begin_AssetNum}" selected="selected">${pathSectionPage.assetName}</option>
                                </c:if>
                            </select>
                        </td>
                       
                        <c:if test="${editType eq 'add'}">
                        <td class="table-label">电缆规格:</td>
                        <td>
                            <select name="modelTypeNum" class="combox" >
                                <option value="">请选择电缆规格</option>
                                <c:forEach var="item" items="${attachmentModelTypeList}">
                                <option value="${item.modelTypeNum}">${item.modelTypeName}</option>
                                </c:forEach>
                            </select>
                        </td>
                        </c:if>
                    </tr>
                    <tr>
                        <td class="table-label" style="width: 90px">止点设备类型:</td>
                        <td>
                            <select name="end_AssetType" class="combox" ref="end_asset" refUrl="/PathSection/asset/{value}">
                                <option value="-1">请选择止点设备类型</option>
                                <c:forEach var="item" items="${manholeKindTypeList}">
                                <option value="${item.manholeKindTypeID}" ${pathSectionPage.end_ManholeKindTypeID eq item.manholeKindTypeID?'selected="selected"':''}>${item.manholeKindTypeName}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td class="table-label">止点设备:</td>
                        <td>
                            <select name="end_AssetNum" class="combox" id="end_asset">
                                <option value="">请选择止点设备</option>
                                <c:if test="${not empty pathSectionPage.end_AssetNum}">
                                    <option value="${pathSectionPage.end_AssetNum}">${pathSectionPage.end_AssetName}</option>
                                </c:if>
                            </select>
                        </td>
                        <c:if test="${type == 1}">
                        <td class="table-label">接地方式:</td>
                        <td>
                            <select name="safeEarthTypeID" class="combox">
                                <option value="">请选择接地方式</option>
                                <c:forEach var="item" items="${safeEarthTypeList}">
                                <option value="${item.safeEarthTypeID}" ${pathSectionPage.safeEarthTypeID eq item.safeEarthTypeID ? 'selected="selected"':''} >${item.safeEarthTypeName}</option>
                                </c:forEach>
                            </select>
                        </td>
                        </c:if>
                        <c:if test="${type == 2}">
                            <td class="table-label" style="width: 80px">接地线甩出:</td>
                            <td>
                                <select name="earthConnectorType" class="combox">
                                    <option value="">请选择</option>
                                    <option value="首端">首端</option>
                                    <option value="末端">末端</option>
                                    <option value="两端">两端</option>
                                    <option value="未甩出">未甩出</option>
                                </select>
                            </td>
                        </c:if>
                    </tr>
                    <tr>
                        <c:if test="${type == 1}">
                        <td class="table-label">敷设方式:</td>
                        <td>
                            <select name="installTypeID" class="required combox">
                                <option value="">请选择</option>
                                <c:forEach var="item" items="${installTypeList}">
                                <option value="${item.installTypeID}" ${pathSectionPage.installTypeID eq item.installTypeID ? 'selected="selected"':''} >${item.installTypeName}</option>
                                </c:forEach>
                            </select>
                        </td>
                        </c:if>
                        <c:if test="${type == 2}">
                            <td class="table-label">变电站:</td>
                            <td>
                                <select name="baseFacilityNum" class="required combox">
                                    <option value="">请选择</option>
                                        <c:forEach var="item" items="${baseFacilityList}">
                                        <option value="${item.baseFacilityNum}" ${pathSectionPage.baseFacilityNum eq item.baseFacilityNum ? 'selected="selected"':''} >${item.baseFacilityName}</option>
                                        </c:forEach>
                                </select>
                            </td>
                        </c:if>
                        <td class="table-label">回数:</td>
                        <td>
                            <input  name="loopCount" type="text" size="30" value="${pathSectionPage.loopCount}" class="textInput" ${editType eq "modify"?'disabled="disabled"':''}>
                        </td>
                        <c:if test="${editType eq 'add'}">
                        <c:if test="${type == 1}">
                        <td class="table-label">每回条数:</td>
                        <td>
                            <select name="lineCount" class="required combox">
                                <option value="">请选择</option>
                                <option value="1">1</option>
                                <option value="3">3</option>
                            </select>
                        </td>
                        </c:if>
                        </c:if>
                        <c:if test="${type == 2}">
                            <td class="table-label">
                                是否出口:
                            </td>
                            <td>
                                <select name="isExpEarthLine" class="required combox">
                                    <option value="0" selected="selected"} >否</option>
                                    <option value="1"} >是</option>
                                </select>
                            </td>
                        </c:if>
                    </tr>
                    <tr>
                        <td class="table-label">回长:</td>
                        <td>
                            <input  name="loopLenght" type="text" size="30" value="${pathSectionPage.loopLenght}" class="textInput">
                        </td>
                    </tr>
                    <tr>
                        <td class="table-label">起点位置:</td>
                        <td colspan="5">
                            <textarea cols="88" name="placeInfo" rows="3"style="width:100%;" class="textInput">${pathSectionPage.placeInfo}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td class="table-label">止点位置:</td>
                        <td colspan="5">
                            <textarea cols="88" name="placeInfo2" rows="3"style="width:100%;" class="textInput">${pathSectionPage.placeInfo2}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td class="table-label">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</td>
                        <td colspan="5">
                            <textarea cols="88" name="memo" rows="3"style="width:100%;" class="textInput">${pathSectionPage.memo}</textarea>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
    </div>
    <div class="formBar">
        <ul>
            <c:if test="${isDbClick ne 1}">
            <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li><li>
            </c:if>
                <input type="hidden" id="test" value="${isDbClick}">
                <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
            </li>
        </ul>
    </div>
</form>