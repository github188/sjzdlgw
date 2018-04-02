<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tanrong
  Date: 16/10/3
  Time: 下午2:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="pageContent">
    <form method="post" action="${ctxPath}/ManholeLaborWell/add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" name="assetNum" value="${ManholeLaborWell.assetNum}"/>
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>档案编号：</label>
                <input name="assetName"  type="text" size="30" value="${ManholeLaborWell.assetName}" />
            </p>
            <p>
                <label>通道编号：</label>
                <input name="tunnel_AssetNum"  type="text" size="30"  value="${ManholeLaborWell.tunnel_AssetNum}" />
            </p>
            <p>
                <label>工井编号：</label>
                <input name="assetCode"  type="text" size="30"  value="${ManholeLaborWell.assetCode}" />
            </p>
            <p>
                <label>设施：</label>
                <select name="manholeCoverTypeID" class=" combo-box">
                    <c:forEach items="${ManholeCoverTypeList}" var="ob" varStatus="id">
                        <option value="${ob.manholeCoverTypeID}" ${ManholeLaborWell.manholeCoverTypeID eq ob.manholeCoverTypeID ? 'selected="selected"':''} >${ob.manholeCoverTypeName}</option>
                    </c:forEach>
                </select>
           </p>
            <p>
                <label>类型：</label>
                <select name="manholeKindTypeID" class=" combo-box">
                    <c:forEach items="${ManholeKindTypeList}" var="ob" varStatus="id">
                        <option value="${ob.manholeKindTypeID}" ${ManholeLaborWell.manholeKindTypeID eq ob.manholeKindTypeID ? 'selected="selected"':''} >${ob.manholeKindTypeName}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label>尺寸：</label>
                <input name="manHoleCoverSize"  type="text" size="30"  value="${ManholeLaborWell.manholeCoverSize}" />
            </p>
            <p>
                <label>地面高程：</label>
                <input name="height" type="number" size="30"  value="${ManholeLaborWell.height}" />
            </p>
            <p>
                <label>井底高程：</label>
                <input name="bottomHeight" type="number" size="30"  value="${ManholeLaborWell.bottomHeight}" />
            </p>
            <p>
                <label>平台层数：</label>
                <input name="terraceLayerCount" type="number" size="30"  value="${ManholeLaborWell.terraceLayerCount}" />
            </p>
            <p>
                <label>设施材质：</label>
                <select name="coverStuffTypeID" class=" combo-box">
                    <c:forEach items="${CoverStuffTypeList}" var="ob" varStatus="id">
                        <option value="${ob.coverStuffTypeID}" ${ManholeLaborWell.coverStuffTypeID eq ob.coverStuffTypeID ? 'selected="selected"':''} >${ob.coverStuffTypeName}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label>设施形状：</label>
                <select name="coverShapeTypeID" class=" combo-box">
                    <c:forEach items="${CoverShapeTypeList}" var="ob" varStatus="id">
                        <option value="${ob.coverShapeTypeID}" ${ManholeLaborWell.coverShapeTypeID eq ob.coverShapeTypeID ? 'selected="selected"':''} >${ob.coverShapeTypeName}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label>设施生产厂家：</label>
                <input name="company.companyNum" value="${ManholeLaborWell.companyNum}" type="hidden">
                <input  name="company.companyName" type="text" value="${ManholeLaborWell.companyName}" suggestFields="companyName" suggestUrl="/Company/suggest_company?type=3&" lookupGroup="company"/>

            </p>
            <p>
                <label>设施尺寸：</label>
                <input name="manholeCoverSize" type="text" size="30"  value="${ManholeLaborWell.manholeCoverSize}" />
            </p>
            <p>
                <label>施工单位：</label>
                <input name="build_company.companyNum" value="${ManholeLaborWell.buildCompanyNum}" type="hidden">
                <input name="build_company.companyName" type="text" value="${ManholeLaborWell.buildCompanyName}" suggestFields="companyName" suggestUrl="/Company/suggest_company?type=2&" lookupGroup="build_company"/>
            </p>
            <p>
                <label>监理单位：</label>
                <input name="monitor_company.companyNum" value="${ManholeLaborWell.monitorCompanyNum}" type="hidden">
                <input  name="monitor_company.companyName" type="text" value="${ManholeLaborWell.monitorCompanyName}" suggestFields="companyName" suggestUrl="/Company/suggest_company?type=1&companyName=" lookupGroup="monitor_company"/>
            </p>
            <p>
                <label>竣工日期：</label>

                <input name="completedDate" type="text"  value="${ManholeLaborWell.completedDateStr}" class="date" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
            </p>
            <p>
                <label>经度：</label>
                <input name="longitude"  type="number" size="30"  value="${ManholeLaborWell.longitude}" />
            </p>
            <p>
                <label>纬度：</label>
                <input name="latitude" type="number" size="30"  value="${ManholeLaborWell.latitude}" />
            </p>
            <p>
                <label>位置：</label>
               <%--  <input name="positionDescription"  type="text" size="30" value="${ManholeLaborWell.positionDescription}" /> --%>
                <textarea rows="" cols="" name="positionDescription" >"${ManholeLaborWell.positionDescription}"</textarea>
            </p>
            <p>
                <label>备注：</label>
               <%--  <input name="memo"  type="text" size="30"  value="${ManholeLaborWell.memo}" /> --%>
                <textarea rows="" cols="" name="memo" >${ManholeLaborWell.memo}</textarea>
            </p>

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


