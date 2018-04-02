<%--
  Created by IntelliJ IDEA.
  User: GalaIO
  Date: 2016/11/13
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<style>
    .tongdao-table tr {
        height:40px;
    }
    .tongdao-table td input{
        width:157px;
        height:21px;
        box-sizing:border-box;
        border:1px solid #eee;
    }
</style>
<form method="post" action="${ctxPath}/PathCable/${pathType}/edit/${pathCableEdit.cableNum}?loopNum=${loopNum}&pathType=${pathType}" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
    <input name="cableNum" type="text" hidden="hidden" value="${pathCableEdit.cableNum}">
    <div id="a_tdtz" class="pageContent" selector="h1" layoutH="55">
        <div  style="padding:10px;height:190px;box-sizing:border-box;">
            <table class="tongdao-table"  style="width:100%;">
                <tbody>
                <tr>
                    <td class="table-label" style="width: 80px">回路编号:</td>
                    <td>
                        <input  name="runCodePowerLoop" type="text" size="30" value="${pathCableEdit.runCodePowerLoop}" class="textInput" disabled="disabled">
                    </td>
                    <td class="table-label" style="width: 80px">电缆编号:</td>
                    <td>
                        <input  name="runCode" type="text" size="30" value="${pathCableEdit.runCode}"  class="required textInput">
                    </td>
                </tr>
                <tr>
                    <td class="table-label" style="width: 80px">电缆名称:</td>
                    <td>
                        <input  name="cableName" type="text" size="30" value="${pathCableEdit.cableName}"  class="required textInput">
                    </td>
                </tr>
                <tr>
                    <td class="table-label" style="width: 80px">电缆规格:</td>
                    <td>

                        <select name="modelTypeNum" class="required combox">
                            <option value="">请选择</option>
                            <c:forEach var="item" items="${attachmentModelTypeList}">
                                <option value="${item.modelTypeNum}" ${pathCableEdit.modelTypeNum eq item.modelTypeNum ? 'selected="selected"':''} >${item.modelTypeName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td class="table-label" style="width: 80px">投运时间:</td>
                    <td style="width: 100px">
                        <input name="runDate" value="${pathCableEdit.runDate}" type="required text" class="date" size="30" /><a class="inputDateButton" href="javascript:;" style="margin-top: -21px; margin-left: 157px;">选择</a>
                    </td>
                </tr>
                <tr>
                    <td class="table-label" style="width: 80px">相位:</td>
                    <td>

                        <select name="phaseTypeID" class="required combox">
                            <option value="">请选择</option>
                            <c:forEach var="item" items="${phaseTypeList}">
                                <option value="${item.phaseTypeID}" ${pathCableEdit.phaseTypeID eq item.phaseTypeID ? 'selected="selected"':''} >${item.phaseTypeName}</option>
                            </c:forEach>
                        </select>
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