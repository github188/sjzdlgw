<%--
  Created by IntelliJ IDEA.
  User: GalaIO
  Date: 2016/11/6
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<style>
    .tongdao-table tr {
        height:40px;
    }
    .tongdao-table td input{
        width:201px;
        margin-left:0;
    }
    .tongdao-table td a {
        width:176px;
        margin-left:0;
    }
</style>
<form method="post" action="${ctxPath}/AttachmentOfCable/${pathType}/edit/${editType}/${not empty attachmentOfCablePage.recordNum?attachmentOfCablePage.recordNum:-1}?cableNum=${cableNum}" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
    <div id="a_tdtz" class="pageContent" selector="h1" layoutH="55">
        <div  style="padding:10px;height:220px;">
            <table class="tongdao-table"  style="width:95%;">
                <tbody>
                <tr>
                    <td class="table-label" style="width: 80px">档案编号:</td>
                    <td>
                        <input name="recordNum" type="text" hidden="hidden" value="${attachmentOfCablePage.recordNum}">
                        <select name="cableDeviceLedgerNum" class="required combox" ref="attachment_choice" refUrl="/AttachmentOfCable/${pathType}/assetcode/{value}/${editType}">
                            <option value="-1">请选择</option>
                            <c:forEach var="item" items="${cableDeviceLedgerList}">
                                <option value="${item.num}" ${attachmentOfCablePage.ledgerNum eq item.num ? 'selected="selected"':''} >${item.ledgerCode}</option>
                            </c:forEach>
                        </select>
                    </td>

                    <td class="table-label" style="width: 80px">终端选择:</td>
                    <td>
                        <select name="cab_AttachmentNum" class="required combox" id="attachment_choice">
                            <option value="">请选择</option>
                            <c:if test="${not empty attachmentOfCablePage.cab_AttachmentNum}">
                                <option value="${attachmentOfCablePage.cab_AttachmentNum}" selected="selected">${attachmentOfCablePage.assetCode}</option>
                            </c:if>
                        </select>
                    </td>

                    <%--<td class="table-label" style="width: 80px">投运时间:</td>--%>
                    <%--<td>--%>
                        <%--<input name="installDateStr" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${attachmentOfCablePage.installDate}" type="both"/>" type="required text" class="date" size="30" /><a class="inputDateButton" href="javascript:;" style="margin-top: -21px; margin-left: 151px;">选择</a>--%>
                    <%--</td>--%>
                </tr>
                <tr>
                    <td class="table-label" style="width: 80px">投运时间:</td>
                    <td>
                        <input name="installDateStr" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${attachmentOfCablePage.installDate}" type="both"/>" type="required text" class="date" size="30" /><a class="inputDateButton" href="javascript:;" style="margin-top: -21px; margin-left: 151px;">选择</a>
                    </td>
                </tr>
                <c:if test="${editType eq 'addBenti' or editType eq 'modifyBenti'}">
                    <tr>
                        <td class="table-label" style="width: 80px">首端设备类型:</td>
                        <td>
                            <select name="start_AttachmentName" class="required combox"  ref="start_attachment_choice" refUrl="/AttachmentOfCable/${pathType}/attachment/{value}">
                                <option value="-1">请选择</option>
                                <option value="Jietou" ${attachmentOfCablePage.start_AttachmentTypeID eq 2?'selected="selected"':''}>接头</option>
                                <option value="Zhongduan" ${attachmentOfCablePage.start_AttachmentTypeID eq 3?'selected="selected"':''}>终端</option>
                                <option value="Jiedixiang" ${attachmentOfCablePage.start_AttachmentTypeID eq 4?'selected="selected"':''}>接地箱</option>
                            </select>
                        </td>
                        <td class="table-label" style="width: 80px">首端设备:</td>
                        <td>
                            <select name="start_AttachmentNum" class="required combox" id="start_attachment_choice">
                                <option value="">请选择</option>
                                <c:if test="${not empty attachmentOfCablePage.start_AttachmentNum}">
                                    <option value="${attachmentOfCablePage.start_AttachmentNum}" selected="selected"}>${attachmentOfCablePage.start_AttachmentAssetCode}</option>
                                </c:if>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="table-label" style="width: 80px">末端设备类型:</td>
                        <td>
                            <select name="end_modelTypeName" class="required combox"  ref="end_attachment_choice" refUrl="/AttachmentOfCable/${pathType}/attachment/{value}">
                                <option value="-1">请选择</option>
                                <option value="Jietou" ${attachmentOfCablePage.end_AttachmentTypeID eq 2?'selected="selected"':''}>接头</option>
                                <option value="Zhongduan" ${attachmentOfCablePage.end_AttachmentTypeID eq 3?'selected="selected"':''}>终端</option>
                                <option value="Jiedixiang" ${attachmentOfCablePage.end_AttachmentTypeID eq 4?'selected="selected"':''}>接地箱</option>
                            </select>
                        </td>
                        <td class="table-label" style="width: 80px">末端设备:</td>
                        <td>
                            <select name="end_AttachmentNum" class="required combox" id="end_attachment_choice">
                                <option value="">请选择</option>
                                <c:if test="${not empty attachmentOfCablePage.end_AttachmentNum}">
                                    <option value="${attachmentOfCablePage.end_AttachmentNum}" selected="selected"}>${attachmentOfCablePage.end_AttachmentAssetCode}</option>
                                </c:if>
                            </select>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td class="table-label">安装位置:</td>
                    <td colspan="5">
                        <textarea cols="88" name="place" rows="3"style="width:100%;" class="textInput">${attachmentOfCablePage.place}</textarea>
                    </td>
                </tr>
                </tbody>
            </table>
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