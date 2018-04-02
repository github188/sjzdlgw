<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<style>
    .pageContent{
        padding: 4px;
        height:100%;
        box-sizing:border-box;
        position:relative;
    }
    .pageContent p{
        width:50%;
        height:21px;
        float:left;
        margin:4px 0;
    }
    .pageContent p:before{
        content:"";
        display:block;
        clear:both;
    }
    .pageContent p select ,.pageContent p input{
        width:70%;
        height:21px;
        margin-left:0;
        box-sizing:border-box;
    }
    .pageContent p label{
        width:30%;
        height:100%;
        text-align: center;
        line-height:21px;
        float:left;
    }
</style>
<div class="pageContent newxs" >
    <form method="post" action="${ctxPath}/TunnelSection/addzj" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <c:if test="${sid_TunnelSection != null}">
            <input type="hidden" name="sectionNum" value="${sid_TunnelSection}"/>
        </c:if>
        <c:if test="${TrestleLayerList != null}">
            <input type="hidden" name="trestleLayerNum" value="${TrestleLayerList.trestleLayerNum}"/>
        </c:if>
        <div>
                <p>
                    <label>电压等级：</label>
                    <select name="voltageLevelName" class="required combo-box">
                        <c:forEach items="${voltageLevel}" var="ob" varStatus="id">
                            <option value="${ob.voltageLevelID}"  ${TrestleLayerList.voltageLevelID eq ob.voltageLevelID ? 'selected="selected"':''} >${ob.voltageLevelName}</option>
                        </c:forEach>
                    </select>
                </p>
                <p>
                    <label>材质：</label>
                    <select name="trestleStuffTypeName">
                    <c:forEach items="${trestleStuffTypeList}" var="ob" varStatus="id">
                        <option value="${ob.trestleStuffTypeID}"  ${TrestleLayerList.trestleStuffTypeID eq ob.trestleStuffTypeID ? 'selected="selected"':''} >${ob.trestleStuffTypeName}</option>
                    </c:forEach>
                    </select>
                </p>
                <p>
                    <label>支架方位：</label>
                    <select name="trestlePositionTypeName">
                        <c:forEach items="${trestleDirectionTypeList}" var="ob" varStatus="id">
                            <option value="${ob.trestlePositionTypeID}"  ${TrestleLayerList.trestlePositionTypeID eq ob.trestlePositionTypeID ? 'selected="selected"':''} >${ob.trestlePositionTypeName}</option>
                        </c:forEach>
                    </select>
                </p>
                <p>
                    <label>支架长度(米)：</label>
                    <input name="trestleLength" type="text" size="30" value="${TrestleLayerList.trestleLength}" />
                </p>
                <p>
                    <label>支架层级：</label>
                    <input name="layer" type="number" size="30" value="${TrestleLayerList.layer}" />
                </p>
                <p>
                    <label>支架高度(米)：</label>
                    <input name="height" type="text" size="30" value="${TrestleLayerList.height}" />
                </p>
                <p>
                </p>
            </div>
        <div style="text-align:center;margin-top:30px; position:absolute;right:10px;bottom:10px;">
            <button type="submit" class="a-submit">保存</button>
            <button type="button" class="a-close">取消</button>
        </div>
    </form>
</div>