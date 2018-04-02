<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hy
  Date: 2016/10/9
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<div id="a_tdtz" class="pageContent" selector="h1" layoutH="5" style="box-sizing:border-box;padding-top:16px;">
        <form method="post" action="${ctxPath}/TunnelSection/RowTube/addDLGdlg" class="pageForm required-validate" novalidate="novalidate" onsubmit="return validateCallback(this, dialogAjaxDone);">
            <input type="hidden" name="rowTubeNum" value="${RowTubeList.rowTubeNum}"/>
            <c:if test="${TunnelSection_sid != null}">
             <input type="hidden" name="trestleLayerNum" value="${TunnelSection_sid}"/>
            </c:if>
            <c:if test="${dlg_TunnelSection != null}">
                <input type="hidden" name="trestleLayerNum" value="${RowTubeList.trestleLayerNum}"/>
            </c:if>
            <div class="add_dlg" style="width:90%;margin:0 auto;">
                <p>
                    <label class="table-label">管层层级：</label>
                    <c:if test="${layerList != null}">
                        <input name="layer" type="number" size="30" value="${layerList.layer}" readonly />
                    </c:if>
                    <c:if test="${leary!=null}">
                         <input name="layer" type="number" size="30" value="${leary}" readonly/>
                    </c:if>
                </p>
                <p>
                    <label class="table-label">位置顺序号：</label>
                    <input name="rowTubeOrder" type="text" size="30" value="${RowTubeList.rowTubeOrder}"  class="required" maxlength="8"/>
                </p>
                <p>
                    <label>规格：</label>
                    <select name="rowTubeTypeID">
                        <c:forEach items="${rowTubeTypeList}" var="ob" varStatus="id">
                            <option value="${ob.rowTubeTypeID}"  ${RowTubeList.rowTubeTypeID eq ob.rowTubeTypeID ? 'selected="selected"':''} >${ob.rowTubeTypeName}</option>
                        </c:forEach>
                    </select>
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
<style>
    .add_dlg{
        height:auto;
    }
    .add_dlg p{
        margin:0 auto;
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


