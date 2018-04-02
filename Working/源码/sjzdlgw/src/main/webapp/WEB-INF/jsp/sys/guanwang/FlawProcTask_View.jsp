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
    <form method="post" action="" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">

        <div class="pageFormContent">
            <div style="border:1px solid #959595;margin-top: 9px;padding-top: 4px;padding-bottom:40px;width: 619px;margin-left:auto;margin-right:auto;height: 224px;">
                <table class="a-success-table" style="margin-left:auto;margin-right:auto;">
                    <tr>
                        <td colspan="4" style="height:90px;">
                            <div class="a-success-icon"></div>
                        </td>
                    </tr>
                    <tr>
                        <td class="w-label">任务名称：</td>
                        <td>${FlawProcTask.flawProcTaskName}</td>
                        <td class="w-label" class="w-label" class="w-label">两卡票号：</td>
                        <td>${FlawProcTask.workBillsCode}</td>
                    </tr>
                    <tr>
                        <td class="w-label" class="w-label">工作负责人：</td>
                        <td>${FlawProcTask.taskEmployeeName}</td>
                        <td class="w-label">开始时间：</td>
                        <td style="color:#FF0000;">${FlawProcTask.startDateTimeStr}</td>
                    </tr>
                    <tr>
                        <td class="w-label" class="w-label">工作班组：</td>
                        <td>${FlawProcTask.workUserList}</td>
                        <td class="w-label">完成时间：</td>
                        <td style="color:#FF0000;">${FlawProcTask.completeDateTimeStr}</td>
                    </tr>
                    <tr>
                        <td class="w-label">计划时间：</td>
                        <td style="color:#FF0000;">${FlawProcTask.planDateStr}</td>
                    </tr>
                </table>
            </div>
        </div>
    </form>
</div>
