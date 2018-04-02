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
    <form method="post" action="${ctxPath}/BusinessProcessInstantiate/add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" name="instantiateID" value="${BusinessProcessInstantiate.instantiateID}"/>
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>流程模版：</label>
                <select name="templateID" class="required combo-box">
                    <c:forEach items="${BusinessProcessTemplateList}" var="ob" varStatus="id">
                        <option value="${ob.templateID}" ${BusinessProcessInstantiate.templateID eq ob.templateID ? 'selected="selected"':''} >${ob.businessName}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label>流程节点A用户：</label>
                <input name="A.employeeID" value="${BusinessProcessInstantiate.userAID}" type="hidden">
                <input name="A.userName" value="${BusinessProcessInstantiate.userAName}" type="text" size="30" readonly="true"/>
                <span><a class="btnLook" href="${ctxPath}/ManyChoice/Employee?type=1" lookupGroup="A">查找带回</a></span>

            </p>
            <p>
                <label>流程节点B用户：</label>
                <input name="B.employeeID" value="${BusinessProcessInstantiate.userBID}" type="hidden">
                <input name="B.userName" value="${BusinessProcessInstantiate.userBID}" type="text" size="30" readonly="true"/>
                <span><a class="btnLook" href="${ctxPath}/ManyChoice/Employee?type=1" lookupGroup="B">查找带回</a></span>

            </p>
            <p>
                <label>流程节点C用户：</label>
                <input name="C.employeeID" value="${BusinessProcessInstantiate.userCID}" type="hidden">
                <input name="C.userName" value="${BusinessProcessInstantiate.userCName}" type="text" size="30" readonly="true"/>
                <span><a class="btnLook" href="${ctxPath}/ManyChoice/Employee?type=1" lookupGroup="C">查找带回</a></span>

            </p>
            <p>
                <label>流程节点D用户：</label>
                <input name="D.employeeID" value="${BusinessProcessInstantiate.userDID}" type="hidden">
                <input name="D.userName" value="${BusinessProcessInstantiate.userDName}" type="text" size="30" readonly="true"/>
                <span><a class="btnLook" href="${ctxPath}/ManyChoice/Employee?type=1" lookupGroup="D">查找带回</a></span>

            </p>
            <p>
                <label>流程节点E用户：</label>
                <input name="E.employeeID" value="${BusinessProcessInstantiate.userEID}" type="hidden">
                <input name="E.userName" value="${BusinessProcessInstantiate.userEName}" type="text" size="30" readonly="true"/>
                <span><a class="btnLook" href="${ctxPath}/ManyChoice/Employee?type=1" lookupGroup="E">查找带回</a></span>

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

