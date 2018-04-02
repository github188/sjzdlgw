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
    <form method="post" action="${ctxPath}/FlawProcTask/${teamTypeID}/assign" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
        <input type="hidden" name="flawProcTaskNum" value="${FlawProcTask.flawProcTaskNum}"/>
        <input type="hidden" name="IsNew" value="${IsNew}">
        <div class="pageFormContent" >
            <div class="a-title">
                <div class="a-left"></div>
                <div class="a-right">确定任务</div>
            </div>
            <p >
                <label>两卡票号：</label>
                <input name="workBillsCode" ${IsNew==1?"readonly='readonly'":""} value="${FlawProcTask.workBillsCode}" type="text" size="30" />

            </p>
            <p>
                <label>班组成员：</label>
                <input name="workers.employeeID" value="" type="hidden">
                <input name="workers.userName" value="" class="task" type="text" size="30" readonly="true" required="required"/>
                <span><a class="btnLook" href="${ctxPath}/ManyChoice/Employee?type=2&employeeID=${FlawProcTask.taskEmployeeID}" lookupGroup="workers">查找带回</a></span>
            </p>
        </div>
        <div style="text-align:center;margin-top:30px;display:${IsNew==1?'none':''}">
            <button type="submit" class="a-submit">保存</button>
            <button type="button" class="a-close">取消</button>
        </div>

    </form>
    <script>
        alertMsg.close();
    </script>
</div>
