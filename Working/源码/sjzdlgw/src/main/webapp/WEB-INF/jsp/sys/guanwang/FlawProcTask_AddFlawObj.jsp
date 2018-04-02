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
    <form method="post" action="${ctxPath}/FlawProcTask/${teamTypeID}/appendObj" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" name="objFlawNum" value="${FlawProcTaskObj.objFlawNum}"/>
        <input type="hidden" name="flawProcObj" value="${FlawProcTaskObj.flawProcObj}"/>
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>消缺确认类型：</label>
                <select name="flawProcAcceptTypeID" class="required combo-box">
                    <c:forEach items="${FlawProcAcceptList}" var="ob" varStatus="id">
                        <option value="${ob.flawProcAcceptTypeID}" ${FlawProcTaskObj.flawProcAcceptTypeID eq ob.flawProcAcceptTypeID ? 'selected="selected"':''} >${ob.flawProcAcceptTypeName}</option>
                    </c:forEach>
                </select>
             </p>
            <p></p>
            <div>
                <label>缺陷描述：</label>
                <input name="flawPrcoDescription" type="text" size="30"  value="${FlawProcTaskObj.flawPrcoDescription}"  style="width:578px;height:60px;"/>
            </div>
            <div style="float: left;padding-top: 5px">
                <label>备注：</label>
                <input name="memo"  type="text" size="30"  value="${FlawProcTaskObj.memo}"style="width:578px;height:60px;" />
            </div>
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

