<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<%--
  Created by IntelliJ IDEA.
  User: tanrong
  Date: 16/10/3
  Time: 下午2:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="pageContent">
    <form method="post" action="${ctxPath}/LedgerStatistics/addCompany" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" name="companyNum" value="${CompanyList.companyNum}"/>
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>单位名称：</label>
                <input name="companyName" class="required" type="text" size="30"  value="${CompanyList.companyName}" />

            </p>
            <input type="hidden" name="companyTypeID" value="${CompanyList.companyTypeID}"/>

            <p>
                <label>单位地址：</label>
                <input name="companyAddr" type="text" size="30" value="${CompanyList.companyAddr}" />
            </p>
            <p>
                <label>单位电话：</label>
                <input name="companyTelephone" type="number" size="30" value="${CompanyList.companyTelephone}" alt="请输入单位电话"/>
            </p>
            <p>
                <label>联系人：</label>
                <input name="contact"  type="text" size="30" value="${CompanyList.contact}" alt="请输入单位联系人名称"/>
            </p>
            <p>
                <label>联系人电话：</label>
                <input name="contactPhone"  type="number" size="30" value="${CompanyList.contactPhone}" alt="请输入单位联系人电话"/>
            </p>
            <p>
                <label>备注：</label>
                <textarea name="memo" type="text" size="30" value="${CompanyList.memo}" ></textarea>
            </p>
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


