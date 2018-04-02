<%--
  Created by IntelliJ IDEA.
  User: tanrong
  Date: 16/10/3
  Time: 下午2:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<div class="pageContent">
    <form method="post" action="${ctxPath}/Manhole/add" class="pageForm required-validate" onsubmit="return validateCallback(this);">
        <input type="hidden" name="assetNum" value="${PageModelManhole.assetNum}"/>
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>终端名称：</label>
                <input name="assetName"  type="text" size="30" value="${PageModelManhole.assetName}"/>
            </p>
            <p></p>
            <p>
                <label>资产编码：</label>
                <input name="assetCode"  type="text" size="30"  value="${PageModelManhole.assetCode}"/>
            </p>
            <p></p>
            <p>
                <label>设备类型：</label>
                <select name="manholeKindTypeID" disabled="disabled">
                    <option value="">--请选择--</option>
                    <c:forEach items="${PageModelManholeKindTypeList}" var="ob">
                        <option value="${ob.manholeKindTypeID}" ${PageModelManhole.manholeKindTypeID eq ob.manholeKindTypeID ? 'selected="selected"':''} >${ob.manholeKindTypeName}</option>
                    </c:forEach>
                </select>
            </p>
            <p></p>
            <p>
                <label>经度：</label>
                <input name="longitude"  type="text" size="30"  value="${PageModelManhole.longitude}" readonly="true"/>
            </p>
            <p></p>
            <p>
                <label>纬度：</label>
                <input name="latitude" type="text" size="30"  value="${PageModelManhole.latitude}" readonly="true"/>
            </p>
            <p></p>
            <dl class="nowrap">
                <dt>位置描述：</dt>
                <dd><textarea name="positionDescription" cols="92" rows="2">${PageModelManhole.positionDescription}</textarea></dd>
            </dl>
            <dl class="nowrap">
                <dt>备注：</dt>
                <dd><textarea name="memo" cols="92" rows="2">${PageModelManhole.memo}</textarea></dd>
            </dl>
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















<%--<div class="pageContent">--%>
    <%--<form method="post" action="${ctxPath}/Manhole/add" class="pageForm required-validate" onsubmit="return validateCallback(this);">--%>
        <%--<input type="hidden" name="assetNum" value="${PageModelManhole.assetNum}"/>--%>
        <%--<div>--%>
            <%--<table class="tongdao-table">--%>
                <%--<tr>--%>
                    <%--<td class="table-label">终端名称:</td>--%>
                    <%--<td>--%>
                        <%--<input name="assetName" type="text" size="30" value="${PageModelManhole.assetName}" alt="请输入终端名称" class="required"/>--%>
                    <%--</td>--%>
                    <%--<td class="table-label">资产编码:</td>--%>
                    <%--<td>--%>
                        <%--<input name="assetCode" type="text" size="30" value="${PageModelManhole.assetCode}" alt="请输入资产编码" class="required" />--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td class="table-label">设备类型:</td>--%>
                    <%--<td>--%>
                        <%--<select class="required" name="manholeKindTypeID" ${PageModelManhole.manholeKindTypeID!=null ? 'disabled="true"':''}>--%>
                            <%--<option value="">请选择设备类型</option>--%>
                            <%--<c:forEach var="item" items="${PageModelManholeKindTypeList}">--%>
                                <%--<option value="${item.manholeKindTypeID}" ${PageModelManhole.manholeKindTypeID eq item.manholeKindTypeID ? 'selected="selected"':''} >${item.manholeKindTypeName}</option>--%>
                            <%--</c:forEach>--%>
                        <%--</select>--%>
                    <%--</td>--%>

                    <%--<td class="table-label">经度:</td>--%>
                    <%--<td>--%>
                        <%--<input name="latitude" type="text" size="30" value="${PageModelManhole.latitude}" alt="请输入经度" class="required"/>--%>
                    <%--</td>--%>
                    <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td class="table-label">维度:</td>--%>
                    <%--<td>--%>
                        <%--<input name="latitude" type="text" size="30" value="${PageModelManhole.latitude}" alt="请输入维度" class="required"/>--%>
                    <%--</td>--%>
                <%--</tr>--%>

                <%--<tr>--%>
                    <%--<td class="table-label">位置描述:</td>--%>
                    <%--<td colspan="5">--%>
                        <%--<textarea name="positionDescription" cols="88" rows="3">${PageModelManhole.positionDescription}</textarea>--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td class="table-label">备注:</td>--%>
                    <%--<td colspan="5">--%>
                        <%--<textarea name="memo" cols="88" rows="3">${PageModelManhole.memo}</textarea>--%>
                    <%--</td>--%>
                <%--</tr>--%>

            <%--</table>--%>

        <%--</div>--%>
    <%--<div class="formBar">--%>
        <%--<ul>--%>
            <%--<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>--%>
            <%--<li>--%>
                <%--<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>--%>
            <%--</li>--%>
        <%--</ul>--%>
    <%--</div>--%>
    <%--</form>--%>
<%--</div>--%>



