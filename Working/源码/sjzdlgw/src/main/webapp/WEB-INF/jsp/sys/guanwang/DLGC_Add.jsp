<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<style>
    .add_dlg{
        height:160px;
        box-sizing:border-box;
        padding:18px;
        overflow:hidden;
    }
    .add_dlg p{
        line-height:21px;
        margin:6px auto;
        margin-bottom:6px;
        overflow:hidden;
    }
    .add_dlg p label{
        display:block;
        float:left;
        width:86px;
    }
    .add_dlg p input,#a_tdtz p select{
        width:206px;
        margin-left:0;
        box-sizing:border-box;
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
            <div class="add_dlg">
                <p>
                    <label>管层层级：</label>
                    <input name="layer" type="number" size="30" value="${TrestleLayerList.layer}" readonly />
                </p>
                <p>
                    <label>管层高度(米)：</label>
                    <input name="height" type="text" size="30" value="${TrestleLayerList.height}" />
                </p>
            </div>
        <div class="formBar" style="position:absolute;right:0;bottom:0;width:100%;">
            <ul>
                <div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div>
                <li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
            </ul>
        </div>
    </form>
</div>