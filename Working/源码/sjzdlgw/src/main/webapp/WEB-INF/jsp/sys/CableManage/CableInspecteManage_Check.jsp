<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<script type="application/javascript">
    var finish = function(){
        $('#checkType').val = 1;
        var form = $('#checkType');
        form.submit();
    };
    var finish2 = function(){
        $('#checkType').val = 2;
        var form = $('#checkType');
        form.submit();
    };
</script>
<div class="pageContent">
    <form method="post" id="checkForm" action="${ctxPath}/CableInspecteManage/${pathType}/check/${num}" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
        <input type="hidden" name="acceptRecordNum" value="${cableInspecteManagePage.acceptRecordNum}"/>
        <%--<input type="hidden" name="archivesNum" value="${archivesNum}">--%>
        <input type="hidden" name="readonly" value="${readonly}">
        <input type="hidden" id="checkType" name="checkType" value="2">
        <div class="pageFormContent">
            <div class="a-title">
                <div class="a-left"></div>
                <div class="a-right">审核验收</div>
            </div>
            <div>
                <p>
                    <label>审核意见：</label>
                    <input name="auditResult" ${readonly==1?'readonly="readonly"':''} class="required" type="text" size="30"  value="${cableInspecteManagePage.auditResult}" />
                </p>

                <p>
                    <label>状态：</label>
                    <select name="status" class="required combo-box">
                        <option value="1"  selected="selected">审核通过</option>
                        <option value="2"  >审核通过(资料不全)</option>
                        <option value="3"  >审核不通过</option>
                    </select>
                </p>
            </div>
        </div>
        <div style="text-align:center;margin-top:30px; display:${readonly==1?'none':''}">
            <%--<button type="submit" class="a-submit">保存</button>--%>
            <%--<button type="button" class="a-submit" onclick="finish();">完成验收</button>--%>
            <%--<button type="button" class="a-submit" onclick="finish2();">完成并提交审核</button>--%>
                <button type="submit" class="a-submit">保存</button>
            <button type="button" class="a-close">取消</button>
        </div>
        <!--<div class="formBar">
            <ul>
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
                <li>
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div>-->
    </form>
</div>
