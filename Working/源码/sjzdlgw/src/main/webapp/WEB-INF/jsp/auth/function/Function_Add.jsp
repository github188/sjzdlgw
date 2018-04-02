<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="pageContent">
    <form method="post" action="${ctxPath}/Function/add" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
        <input type="hidden" name="applicationModuleID" value="${function.applicationModuleID}"/>
        <div class="pageFormContent" layoutH="56">
             <p>
                <label>功能类型：</label>
                <input name="functionType" class="required" type="text" size="30" alt="请输选择功能类型" value="${function.functionType}" />
            </p>
            <p>
                <label>功能名称：</label>
                <input name="applicationModuleName" class="required" type="text" size="30" alt="请输入功能名称" value="${function.applicationModuleName}" />
            </p>
            <p>
                <label>功能代码：</label>
                <input name="applicationCode" class="required" type="text" size="30" alt="请输入功能代码" value="${function.applicationCode}" />
            </p>
			<p>
                <label>上级功能：</label>
                <input name="parentModuleID" class="required" type="text" size="30" alt="请输入上级功能ID" value="${function.parentModuleID}" />
            </p>
            <p>
                <label>功能级别：</label>
                <input name="applicationLevel" class="required" type="text" size="30" alt="请输入功能级别" value="${function.applicationLevel}" />
            </p>
             <p>
                <label>url：</label>
                <input name="functionPath" class="required" type="text" size="30" alt="请输入访问地址" value="${function.functionPath}" />
            </p>
            <p>
                <label>是否显示：</label>
                <input name="isDisplay" type="text" size="30" value="${function.isDisplay}" alt="请输入功能描述"/>
            </p>
            <p>
                <label>描述：</label>
                <input name="context" type="text" size="30" value="${function.context}" alt="请输入功能描述"/>
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



