<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<div class="pageContent">
    <form method="post" action="${ctxPath}/CableInspecteManage/${pathType}/aduit/${num}" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
        <input type="hidden" name="acceptRecordNum" value="${cableInspecteManagePage.acceptRecordNum}"/>
        <%--<input type="hidden" name="archivesNum" value="${archivesNum}">--%>
        <input type="hidden" name="readonly" value="${readonly}">
        <div class="pageFormContent">
            <div class="a-title">
                <div class="a-left"></div>
                <div class="a-right">完成任务</div>
            </div>
            <div>
                <p>
                    <label>验收意见：</label>
                    <input name="acceptOpinion" ${readonly==1?'readonly="readonly"':''} class="required" type="text" size="30"  value="${cableInspecteManagePage.acceptOpinion}" />
                </p>

                <p>
                    <label>状态：</label>
                    <select name="status" class="required combo-box">
                        <option value="2"  >验收不通过</option>
                        <option value="3"  >验收通过</option>
                        <option value="1" selected="selected" >验收通过并提交审核</option>
                    </select>
                </p>
                <p>


                <center>
                <div class="buttonActive">
                        <a controlID="${pathType==1?'3808':'4808'}"  href="${ctxPath}/CableInspecteManage/${pathType}/FileView/${cableInspecteManagePage.acceptRecordNum}" target="dialog" rel="TunnelAduit_Index_01"title="附件"  resizable="false" drawable="true" width="800" height="600"><span>添加附件</span></a></li>
                </div>
                <div class="buttonActive">
                        <a class="icon" href="${ctxPath}/CableInspecteManage/${pathType}/downloadSafety/${cableInspecteManagePage.acceptRecordNum}"><span>安全控制卡</span></a>
                </div>
                <div class="buttonActive">
                        <a class="icon" href="${ctxPath}/CableInspecteManage/${pathType}/downloadQuality/${cableInspecteManagePage.acceptRecordNum}"><span>质量控制卡</span></a>
                </div>
                </center>
            </div>

        </div>
        <div style="text-align:center;margin-top:30px; display:${readonly==1?'none':''}">
            <button type="submit" class="a-submit">保存</button>
            <button type="button" class="a-close">取消</button>
        </div>

        <%--<div class="formBar">--%>
            <%--<ul>--%>
                <%--<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>--%>
                <%--<li>--%>
                    <%--<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>--%>
                <%--</li>--%>
            <%--</ul>--%>
        <%--</div>--%>
    </form>
</div>
