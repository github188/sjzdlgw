<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tanrong
  Date: 16/10/3
  Time: 下午2:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<style>
    .guanwang-gjt p input,.guanwang-gjt p select{
        width:202px;
        height:21px;
        box-sizing:border-box;
        margin-left:0;
    }
    .guanwang-gjt .input-icon{
        width:186px;
    }
    .guanwang-gjt a{
        width:174px;
    }
    .guanwang-gjt .inputDateButton{
        width:21px;
    }
</style>
<div class="pageContent">
    <form method="post" action="${ctxPath}/Extinguisher/add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" name="assetNum" value="${Extinguisher.assetNum}"/>
        <div class="pageFormContent guanwang-gjt" layoutH="56">
            <p>
                <label>档案编号：</label>
                <input name="archivesCode" class="required" type="text" size="30" value="${Extinguisher.archivesCode}" />
            </p>
            <p>
                <label>通道编号：</label>
                <input name="tunnel_AssetNum.assetNum" value="${Extinguisher.tunnel_AssetNum}" type="hidden">
                <input class="required" name="tunnel_AssetNum.archivesNum" type="text" value="${Extinguisher.tunnelAssetCode}" suggestFields="assetCode" suggestUrl="/PowerTunnel/suggest_tunnel_AssetNum" lookupGroup="tunnel_AssetNum"/>
                <span class="info"></span>
            </p>
            <p>
                <label>灭火装置编号：</label>
                <input name="assetCode" class="required" type="text" size="30"  value="${Extinguisher.assetCode}" />
            </p>
            <p>
                <label>类型：</label>
                <select name="extinguisherTypeID" class="required combo-box">
                    <c:forEach items="${ExtinguisherTypeList}" var="ob" varStatus="id">
                        <option value="${ob.extinguisherTypeID}" ${Extinguisher.extinguisherTypeID eq ob.extinguisherTypeID ? 'selected="selected"':''} >${ob.extinguisherTypeName}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label>规格：</label>
                <input name="extinguisherInfo"  type="text" size="30" value="${Extinguisher.extinguisherInfo}" />
            </p>
            <p>
                <label>数量：</label>
                <input name="quantity"  type="number" size="30" value="${Extinguisher.quantity}" />
            </p>

            <p>
                <label>安装时间：</label>
                <input name="upGradeTime" type="text" value="${Extinguisher.upGradeTimeStr}" class="date input-icon" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>

            </p>

            <p>
                <label>失效时间：</label>
                <input name="downTime" type="text" value="${Extinguisher.downTimeStr}" class="date input-icon" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>

            </p>

            <p>
                <label>有效期：</label>
                <input name="validityYear"  type="number" size="30" value="${Extinguisher.validityYear}" />

            </p>

            <p>
                <label>经度：</label>
                <input name="longitude"type="number" size="30"  value="${Extinguisher.longitude}" />
            </p>
            <p>
                <label>纬度：</label>
                <input name="latitude"  type="number" size="30"  value="${Extinguisher.latitude}" />
            </p>
            <p>
                <label>所在方位：</label>
                <input name="positionDescription"  type="text" size="30"  value="${Extinguisher.positionDescription}" />
            </p>
            <p>
                <label>备注：</label>
                <input name="memo"  type="text" size="30"  value="${Extinguisher.memo}" />
            </p>
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


