
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
        width:134px;
        height:21px;
        box-sizing:border-box;
    }
</style>
<form method="post" action="${ctxPath}/PowerLoop/${pathType}/edit/${editType}/${empty powerLoop.loopNum?-1:powerLoop.loopNum}?pathSectionNum=${pathSection.pathSectionNum}" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
    <input  name="loopNum" type="text" size="30" value="${powerLoop.loopNum}" class="textInput" hidden="hidden">
    <div id="a_tdtz" class="pageContent" selector="h1" layoutH="55">
        <div  style="padding:10px;height:150px;box-sizing:border-box;">
            <table class="tongdao-table"  style="width:90%;">
                <tbody>
                <tr>
                    <td class="table-label" style="width: 80px">线路段编号:</td>
                    <td>
                        <input  name="pathSectionCode" type="text" size="30" value="${pathSection.pathSectionCode}"  class="required textInput" disabled="disabled"}>
                    </td>
                    <td class="table-label" style="width: 80px">回路编号:</td>
                    <td>
                        <input  name="runCode" type="text" size="30" value="${powerLoop.runCode}" class="required textInput">
                    </td>
                </tr>
                <tr>
                    <td class="table-label" style="width: 80px">回路名称:</td>
                    <td>
                        <input  name="loopName" type="text" size="30" value="${powerLoop.loopName}" class="required textInput">
                    </td>
                </tr>
                <tr>
                    <td class="table-label" style="width: 80px">投运时间:</td>
                    <td style="width: 100px">
                        <input name="runDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${powerLoop.runDate}" type="both"/>" type="required text" class="date" size="30" /><a class="inputDateButton" href="javascript:;" style="margin-top: -21px; margin-left: 134px;">选择</a>
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