<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tanrong
  Date: 16/10/3
  Time: 下午2:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<style>
    .guanwang-gjt p input,.guanwang-gjt p select{
        width:202px;
        height:21px;
        box-sizing:border-box;
        margin-left:0;
    }
    .guanwang-gjt a{
        width:174px;
    }
    .guanwang-gjt .inputDateButton{
        width:21px;
    }
</style>
<div class="pageContent">
    <form method="post" action="${ctxPath}/InspectObjFlaw/${teamTypeID}/add" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
        <input type="hidden" name="objFlawNum" value="${InspectObjFlaw.objFlawNum}"/>
        <input type="hidden" name="flawObject" value="${FlawObject}"/>
        <div class="pageFormContent guanwang-gjt" layoutH="56">
            <p>
                <label>缺陷来源：</label>
                <select name="flawSourceTypeID" class="required combo-box">
                    <c:forEach items="${FlawSourceTypeList}" var="ob" varStatus="id">
                        <option value="${ob.flawSourceTypeID}" ${InspectObjFlaw.flawSourceTypeID eq ob.flawSourceTypeID ? 'selected="selected"':''} >${ob.flawSourceName}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label>缺陷分类：</label>
                <select name="flawTypeID" class="required combo-box">
                    <c:forEach items="${FlawTypeList}" var="ob" varStatus="id">
                        <option value="${ob.flawTypeID}" ${InspectObjFlaw.flawTypeID eq ob.flawTypeID ? 'selected="selected"':''} >${ob.flawTypeName}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label>缺陷等级：</label>
                <select name="flawLevelTypeID" class="required combo-box">
                    <c:forEach items="${FlawLevelTypeList}" var="ob" varStatus="id">
                        <option value="${ob.flawLevelTypeID}" ${InspectObjFlaw.flawLevelTypeID eq ob.flawLevelTypeID ? 'selected="selected"':''} >${ob.flawLevelTypeName}</option>
                    </c:forEach>
                </select>
            </p>
            <p></p>
            <div>
                <label>缺陷描述：</label>
                <textarea name="flawDescription"  type="text"  value="${InspectObjFlaw.flawDescription}" style="width:578px;height:60px;"></textarea>
            </div>

        </div>

        <div class="formBar">
            <ul>
            <c:if test="${isDbClick ne 1}">

            <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
            </c:if>
                <li>
                <input type="hidden" id="test" value="${isDbClick}">
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div>
    </form>
</div>

