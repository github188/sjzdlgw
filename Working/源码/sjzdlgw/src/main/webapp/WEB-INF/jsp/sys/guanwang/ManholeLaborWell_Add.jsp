<%--
  Created by IntelliJ IDEA.
  User: tanrong
  Date: 16/10/3
  Time: 下午2:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<style>
    .guanwang-gjt p input,.guanwang-gjt p select{
        width:202px;
        height:21px;
        box-sizing:border-box;
    }
    .guanwang-gjt a{
        width:174px;
    }
    .guanwang-gjt .inputDateButton{
        width:21px;
    }
</style>
<div class="pageContent">
    <form method="post" action="${ctxPath}/ManholeLaborWell/add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" name="assetNum" value="${ManholeLaborWell.assetNum}"/>
        <input type="hidden" name="tunnel_AssetNum" value="${Tunnel_AssetNum}"/>
        <input type="hidden" name="orderAsset" value="${OrderAsset}" />
        <input type="hidden" name="orderType" value="${OrderType}" />
        <div class="pageFormContent guanwang-gjt" layoutH="56">
            <p>
                <label>档案编号：</label>
                <input name="archivesCode"  type="text" size="30" value="${ManholeLaborWell.archivesCode}"class="required"/>
            </p>
            <p>
                <label>通道编号：</label>
                <input name="tunnelAssetCode"  type="text" size="30"  value="${ManholeLaborWell.tunnelAssetCode}"class="required"/>
            </p>
            <p>
                <label>工井编号：</label>
                <input name="assetCode"  type="text" size="30"  value="${ManholeLaborWell.assetCode}" />
            </p>
            <p>
                <label>运行编号：</label>
                <input name="operationCode"  type="text" size="30"  value="${ManholeLaborWell.operationCode}" />
            </p>
            <p>
                <label>设施：</label>
                <select name="manholeCoverTypeID">
                    <c:forEach items="${ManholeCoverTypeList}" var="ob" varStatus="id">
                        <option value="${ob.manholeCoverTypeID}" ${ManholeLaborWell.manholeCoverTypeID eq ob.manholeCoverTypeID ? 'selected="selected"':''} >${ob.manholeCoverTypeName}</option>
                    </c:forEach>
                </select>
           </p>
            <p>
                <label>类型：</label>
                <select name="manholeKindTypeID">
                    <c:forEach items="${ManholeKindTypeList}" var="ob" varStatus="id">
                        <option value="${ob.manholeKindTypeID}" ${ManholeLaborWell.manholeKindTypeID eq ob.manholeKindTypeID ? 'selected="selected"':''} >${ob.manholeKindTypeName}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label>尺寸：</label>
                <input name="lenghtStr"  type="text" size="30"  value="${ManholeLaborWell.length}*${ManholeLaborWell.width}" />
            </p>
            <p>
                <label>地面高程：</label>
                <input name="height" type="text" size="24"  value="${ManholeLaborWell.height}" class="number"/>
                <span class="info">（米）</span>
            </p>
            <p>
                <label>井底高程：</label>
                <input name="bottomHeight" type="text" size="24"  value="${ManholeLaborWell.bottomHeight}" class="number"/>
                <span class="info">（米）</span>
            </p>
            <p>
                <label>平台层数：</label>
                <input name="terraceLayerCount" type="text" size="30"  value="${ManholeLaborWell.terraceLayerCount}" class="number"/>
            </p>
            <p>
                <label>设施材质：</label>
                <select name="coverStuffTypeID">
                    <option value="">--请选择--</option>
                    <c:forEach items="${CoverStuffTypeList}" var="ob" varStatus="id">
                        <option value="${ob.coverStuffTypeID}" ${ManholeLaborWell.coverStuffTypeID eq ob.coverStuffTypeID ? 'selected="selected"':''} >${ob.coverStuffTypeName}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label>设施形状：</label>
                <select name="coverShapeTypeID">
                    <option value="">--请选择--</option>
                    <c:forEach items="${CoverShapeTypeList}" var="ob" varStatus="id">
                        <option value="${ob.coverShapeTypeID}" ${ManholeLaborWell.coverShapeTypeID eq ob.coverShapeTypeID ? 'selected="selected"':''} >${ob.coverShapeTypeName}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label>设施生产厂家：</label>
                <select name="companyNum">
                    <option value="">--请选择--</option>
                    <c:forEach items="${ompanyNumList}" var="ob" varStatus="id">
                        <option value="${ob.companyNum}" ${ManholeLaborWell.companyNum eq ob.companyNum ? 'selected="selected"':''} >${ob.companyName}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label>设施尺寸：</label>
                <input name="manHoleCoverSize" type="text" size="30"  value="${ManholeLaborWell.manHoleCoverSize}" />
            </p>
            <p>
                <label>施工单位：</label>
                <select name="bulid_CompanyNum" class="combox">
                    <option value="">--请选择--</option>
                    <c:forEach items="${bulidCmpanyNumList}" var="ob" varStatus="id">
                    <option value="${ob.companyNum}" ${ManholeLaborWell.bulid_CompanyNum eq ob.companyNum ? 'selected="selected"':''} >${ob.companyName}</option>
                </c:forEach>
                </select>
            </p>
            <%--<p>--%>
                <%--<label>施工单位：</label>--%>
                <%--<input name="buildCompany.companyId"  class="required" value="${bulidCmpanyNumList.buildCompany}" type="hidden">--%>
                <%--<input name="buildCompany.companyName"   class="required search" value="${bulidCmpanyNumList.buildCompany}" type="text"/>--%>
                <%--<a class="btnLook" href="ManholeLaborWell/add/-1" lookupGroup="buildCompany">查找带回</a>--%>
            <%--</p>--%>
            <p>
                <label>监理单位：</label>
                <select name="monitor_CompanyNum" class="combox">
                    <option value="">--请选择--</option>
                    <c:forEach items="${monitorCmpanyNumList}" var="ob" varStatus="id">
                        <option value="${ob.companyNum}" ${ManholeLaborWell.monitor_CompanyNum eq ob.companyNum ? 'selected="selected"':''} >${ob.companyName}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label>竣工日期：</label>
                <input name="completedDate" type="text"  value="${ManholeLaborWell.completedDateStr}" class="date" size="27" readonly="true"/><a class="inputDateButton" href="javascript:;">选择</a>
            </p>
            <p>
                <label>经度：</label>
                <input name="longitude"  type="text" size="30"  value="${ManholeLaborWell.longitude}"/>
            </p>
            <p>
                <label>纬度：</label>
                <input name="latitude" type="text" size="30"  value="${ManholeLaborWell.latitude}"/>
            </p>
            <p></p>
            <dl class="nowrap">
                <dt>位置：</dt>
                <dd><textarea name="positionDescription" cols="92" rows="2">${ManholeLaborWell.positionDescription}</textarea></dd>
            </dl>
            <dl class="nowrap">
                <dt>备注：</dt>
                <dd><textarea name="memo" cols="92" rows="2">${ManholeLaborWell.memo}</textarea></dd>
            </dl>
        </div>
        <div class="formBar">
            <ul>
                <c:if test="${isDbClick ne 1}">
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
                </c:if>
                <li>
                    <input type="hidden" id="test" value="${isDbClick}">
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div>
    </form>
</div>

