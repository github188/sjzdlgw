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
    <form method="post" action="${ctxPath}/InspectObjFlaw/${teamTypeID}/Aduit" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
        <input type="hidden" name="objFlawNum" value="${objFlawNum}"/>
        <div class="pageFormContent" layoutH="56">
            <div class="searchBar">
                <table class="table" style="width:100%;">
                    <thead>
                    <tr>
                        <th width="40">序号</th>
                        <th width="60">处理方式</th>
                        <th width="60">审核意见</th>
                        <th width="60">审核人</th>
                        <th width="60">审核时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${AduitHistoryList}" var="ob" varStatus="vs">
                        <tr >
                            <td>${vs.index+1}</td>
                            <td>${ob.flawAduitWayName}</td>
                            <td>${ob.aduitOpinion}</td>
                            <td>${ob.employeeName}</td>
                            <td>${ob.aduitDateStr}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <div style="overflow:hidden;width:100%;margin-top:10px;">
                <div style="float:left;display:inline;margin-right:30px;">
                    <label style="width:62px;">处理方式：</label>
                    <select name="flawAduitWayID" class="required combo-box">
                        <c:forEach items="${AduitWayList}" var="ob" varStatus="id">
                            <option value="${ob.flawAduitWayID}" >${ob.flawAduitWayName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div style="float:left;display:inline;">
                    <label style="width:62px;">处理意见：</label>
                    <input name="aduitOpinion"  type="text" size="30"  />
                </div>
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
