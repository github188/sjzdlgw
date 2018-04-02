<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<div class="pageContent">
    <form method="post" action="${ctxPath}/CableInspecteManage/${pathType}/add/${num}" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" name="acceptRecordNum" value="${cableInspecteManagePage.acceptRecordNum}"/>
        <%--<input type="hidden" name="archivesNum" value="${archivesNum}">--%>
        <input type="hidden" name="readonly" value="${readonly}">
        <div class="pageFormContent" ${type==1?"":"layoutH='50'"}>
            <div class="a-title" style="display:${type==1?"":"none"}">
                <div class="a-left"></div>
                <div class="a-right">新建任务</div>
            </div>
            <div>
                <p>
                    <label>作业名称：</label>
                    <input name="planName" ${readonly==1?'readonly="readonly"':''}class="required" type="text" size="30"
                           value="${cableInspecteManagePage.planName}"/>
                </p>
                <p>
                    <label>验收时间：</label>
                    <input  ${readonly==1?'readonly="readonly"':''} name="planDate" type="text"
                                                                    value="<fmt:formatDate pattern="yyyy-MM-dd" value="${cableInspecteManagePage.planDate}" type="both"/>"
                                                                    class="date" size="30" required="required"/><a
                        class="inputDateButton" href="javascript:;">选择</a>
                </p>

                <p>
                    <label>作业单位：</label>
                    <select name="workUnit" class="combox" ref="workTeam"
                            refUrl="/Organization/api/findObj?parentID={value}">
                        <option value="-1">请选择作业单位</option>
                        <c:forEach var="item" items="${organizationPageList}">
                            <option value="${item.organizationNum}">${item.organizationName}</option>
                        </c:forEach>
                    </select>
                </p>
                <p>
                    <label>作业班组：</label>
                    <select name="workTeam" class="combox" id="workTeam" style="width: 200px;" ref="workManage"
                            refUrl="/Employee/api/findObj?organizationNum={value}">
                        <option value="-1">请选择作业班组</option>
                    </select>
                </p>
                <p>
                    <label>工作负责人：</label>
                    <select name="user.employeeID" class="combox" id="workManage" style="width: 200px;">
                        <option value="">请选择工作负责人</option>
                    </select>
                </p>
            </div>
        </div>
        <div style="text-align:center;margin-top:30px;display:${type==1&&readonly!=1?'':'none'}">
            <button type="submit" class="a-submit">保存</button>
            <button type="button" class="a-close">取消</button>
        </div>

        <div class="formBar" style="display:${type==1?"none":"block"}">
            <ul><c:if test="${isDbClick ne 1}">
                <li>
                    <div class="buttonActive">
                        <div class="buttonContent">
                            <button type="submit">保存</button>
                        </div>
                    </div>
                </li>
            </c:if>
                <li>
                    <input type="hidden" id="test" value="${isDbClick}">
                    <div class="button">
                        <div class="buttonContent">
                            <button type="button" class="close">取消</button>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </form>
</div>