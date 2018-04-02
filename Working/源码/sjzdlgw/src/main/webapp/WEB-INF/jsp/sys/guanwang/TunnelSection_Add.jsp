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
    <form method="get" action="${ctxPath}/TunnelSection/add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" name="sectionNum" value="${TunnelSectionList.sectionNum}"/>
        <input type="hidden" name="readonly" value="${readonly}">
        <div class="pageFormContent" ${type==1?"":"layoutH='50'"}>

            <div>
                <p>
                    <label>沟道区段编号：</label>
                    <input name="sectionNum" readonly="readonly" disabled class="required" type="text" size="30"  value="${TunnelSectionList.sectionNum}" />
                </p>

                <p>
                    <label>总长度：</label>
                    <input name="sumLength" readonly="readonly" disabled class="required" type="text" size="30"  value="${TunnelSectionList.sumLength}" />
                </p>
                <p>
                    <label>走    向：</label>
                    <select name="tunnleTowardTypeID" disabled="disabled" style="width:216px;">
                        <option value="1" ${TunnelSectionList.tunnleTowardTypeID==1? 'selected="selected"' : ''}>东</option>
                        <option value="2" ${TunnelSectionList.tunnleTowardTypeID==2? 'selected="selected"' : ''}>南</option>
                        <option value="3" ${TunnelSectionList.tunnleTowardTypeID==3? 'selected="selected"' : ''}>西</option>
                        <option value="4" ${TunnelSectionList.tunnleTowardTypeID==4? 'selected="selected"' : ''}>北</option>
                    </select>
                </p>

                <p>
                    <label>覆土深度 ：</label>
                    <input   name="frontTopHeight" type="text"  value="${TunnelSectionList.frontTopHeight}"  size="30" /></a>
                </p>
                <p>
                    <label>区段长度 ：</label>
                    <input   name="length" type="text"  value="${TunnelSectionList.length}"  size="30" /></a>
                </p>
            </div>
        </div>
        <div style="text-align:center;margin-top:30px;display:${type==1&&readonly!=1?'':'none'}">
            <button type="submit" class="a-submit">保存</button>
            <button type="button" class="a-close">取消</button>
        </div>

        <div class="formBar" style="display:${type==1?"none":"block"}">
            <ul>
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
                <li>
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div>
    </form>
</div>