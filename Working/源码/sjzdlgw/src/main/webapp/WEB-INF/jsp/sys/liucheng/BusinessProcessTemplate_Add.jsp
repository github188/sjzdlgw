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
    <form method="post" action="${ctxPath}/BusinessProcessTemplate/add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" name="templateID" value="${BusinessProcessTemplate.templateID}"/>
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>流程名称：</label>
                <input name="businessName" class="required" type="text" size="30" alt="流程名称" value="${BusinessProcessTemplate.businessName}" />

            </p>
            <p>
                <label>流程业务编码：</label>
                <input name="businessCode" class="required" type="text" size="30" alt="流程业务编码" value="${BusinessProcessTemplate.businessCode}" />
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


