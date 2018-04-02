<%--
  Created by IntelliJ IDEA.
  User: GalaIO
  Date: 2016/11/18
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<style>
    .tongdao-table tr {
        height:40px;
    }
</style>
<form method="post" action="${ctxPath}/LoopEarthBox/1/edit/${editType}/${not empty loopEarthBoxPage.loopBoxNum?loopEarthBoxPage.loopBoxNum:-1}?loopNum=${loopNum}&pathType=${pathType}" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
    <div id="a_tdtz" class="pageContent" selector="h1" layoutH="55">
        <div  style="padding-top:10px;height:220px;">
            <table class="tongdao-table"  style="width:95%;">
                <tbody>
                <tr>
                    <td class="table-label" style="width: 80px">档案编号:</td>
                    <td>
                        <input name="loopBoxNum" type="text" hidden="hidden" value="${loopEarthBoxPage.loopBoxNum}">
                        <select name="cableDeviceLedgerNum" class="required combox" ref="attachment_choice" refUrl="/AttachmentOfCable/${pathType}/assetcode/{value}/addJiedixiang">
                            <option value="-1">请选择</option>
                            <c:forEach var="item" items="${cableDeviceLedgerList}">
                                <option value="${item.num}" ${loopEarthBoxPage.ledgerNum eq item.num ? 'selected="selected"':''} >${item.ledgerCode}</option>
                            </c:forEach>
                        </select>
                    </td>

                    <td class="table-label" style="width: 80px">终端选择:</td>
                    <td>
                        <select name="attachmentNum" class="required combox" id="attachment_choice">
                            <option value="">请选择</option>
                            <c:if test="${not empty loopEarthBoxPage.attachmentNum}">
                                <option value="${loopEarthBoxPage.attachmentNum}" selected="selected">${loopEarthBoxPage.assetCode}</option>
                            </c:if>
                        </select>
                    </td>

                    <td class="table-label" style="width: 80px">投运时间:</td>
                    <td>
                        <input name="installDateStr" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${loopEarthBoxPage.installDate}" type="both"/>" type="required text" class="date" size="30" /><a class="inputDateButton" href="javascript:;" style="margin-top: -21px; margin-left: 151px;">选择</a>
                    </td>
                </tr>
                <tr>
                    <td class="table-label">安装位置:</td>
                    <td colspan="5">
                        <textarea cols="88" name="place" rows="3"style="width:100%;" class="textInput">${loopEarthBoxPage.place}</textarea>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <%--</div>--%>
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