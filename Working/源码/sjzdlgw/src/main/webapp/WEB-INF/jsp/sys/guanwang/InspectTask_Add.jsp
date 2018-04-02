<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tanrong
  Date: 16/10/3
  Time: 下午2:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="pageContent newxs" >
    <form method="post" action="${ctxPath}/InspectTask/${teamTypeID}/add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" name="taskNum" value="${InspectTask.taskNum}"/>
        <div class="pageFormContent" ${type==1?"":"layoutH='50'"}>
            <div class="a-title" style="display:${type==1?"":"none"}">
                <div class="a-left"></div>
                <div class="a-right">发起任务</div>
            </div>
            <div>
                <p>
                    <label>任务名称：</label>
                    <input name="taskName" ${readonly==0?'':'readonly="readonly"'} class="required" type="text" size="30"  value="${InspectTask.taskName}" />

                </p>
                <p>
                    <label>详细说明：</label>
                    <input name="taskDescription" ${readonly==0?'':'readonly="readonly"'}  value="${InspectTask.taskDescription}" type="text" size="30" />
                </p>

                <p>
                    <label>作业单位：</label>
                    <select name="workUnit" class="combox" ref="workTeam" refUrl="/Organization/api/findObj?parentID={value}">
                        <option value="-1">请选择作业单位</option>
                        <c:forEach var="item" items="${organizationPageList}">
                            <option value="${item.organizationNum}">${item.organizationName}</option>
                        </c:forEach>
                    </select>
                </p>
                <p>
                    <label>作业班组：</label>
                    <select name="workTeam" class="combox" id="workTeam" style="width: 200px;" ref="workManage" refUrl="/Employee/api/findObj?organizationNum={value}">
                        <option value="-1">请选择作业班组</option>
                    </select>
                </p>
                <p>
                    <label>工作负责人：</label>
                    <select name="user.employeeID" class="combox" id="workManage" style="width: 200px;">
                        <option value="">请选择工作负责人</option>
                    </select>
                </p>
                <p>
                    <label>计划时间：</label>
                    <input name="planDate" ${readonly==0?'':'readonly="readonly"'}  type="text" value="${InspectTask.planDateStr}" class="date input-icon" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
                </p>
                <p>
                    <label>备注：</label>
                    <input name="memo"  ${readonly==0?'':'readonly="readonly"'}  type="text" size="30"  value="${InspectTask.memo}" />
                </p>
                <p>
                </p>
            </div>
        </div>
        <div style="text-align:center;margin-top:30px;display:${type==1&&readonly==0?"":"none"}">
            <button type="submit" class="a-submit">保存</button>
            <button type="button" class="a-close">取消</button>
        </div>
        <div class="formBar" style="display:${type==1?"none":""}">
            <ul>
                <li>
                    <div  class="${readonly==0?'buttonActive':'buttonDisabled'}" ><div class="buttonContent"><button type="${readonly==0?'submit':'button'}">保存</button></div></div>
                </li>
                <li>
                    <div  class="${readonly==0?'buttonActive':'buttonDisabled'}" ><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div>
    </form>
</div>