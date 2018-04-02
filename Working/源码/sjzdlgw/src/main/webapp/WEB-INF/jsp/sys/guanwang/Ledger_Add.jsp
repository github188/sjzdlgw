<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tanrong
  Date: 16/10/3
  Time: 下午2:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="pageContent input-width">
    <form method="post" action="${ctxPath}/Ledger/add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" name="archivesNum" value="${LedgerList.archivesNum}"/>
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>档案编号：</label>
                <input name="archivesCode" type="text" size="30" value="${LedgerList.archivesCode}" class="required"/>
            </p>
            <p>
                <label>所属变电站：</label>
                <select name="baseFacilityNum" class="required combo-box select-choice">
                    <c:forEach items="${baseFacilityList}" var="ob" varStatus="id">
                        <option value="${ob.baseFacilityNum}" ${LedgerList.baseFacilityNum eq ob.baseFacilityNum ? 'selected="selected"':''} >${ob.baseFacilityName}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label>档案名称：</label>
                <input name="archivesName" class="required" type="text" size="30" value="${LedgerList.archivesName}" />
            </p>

            <p>
                <label>档案类别：</label>
                <select name="archivesType">
                    <option value="1">草稿状态</option>
                    <option value="2">规划状态</option>
                </select>
            </p>
            <p>
                <label>资产分界：</label>
                <select name="assetBorderTypeID" class="required combo-box select-choice">
                    <c:forEach items="${assetBorderTypeList}" var="ob" varStatus="id">

                        <option value="${ob.assetBorderTypeID}"  ${LedgerList.assetBorderTypeID eq ob.assetBorderTypeID ? 'selected="selected"':''} >${ob.assetBorderTypeName}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label>盒内档案号：</label>
                <input name="drawerCode"  class="required" class="digits" type="text" size="30" value="${LedgerList.drawerCode}"/>
            </p>
            <p>
                <label>档案存放位置：</label>
                <input  name="archivesPlace" type="text" size="30" value="${LedgerList.archivesPlace}" />
            </p>
            <p>
                <label>施工单位：</label>
                <input name="buildCompany.companyId"  class="required" value="${LedgerList.buildCompany}" type="hidden">
                <input name="buildCompany.companyName"   class="required search input-icon" value="${LedgerList.buildCompany}" type="text"/>
                <a class="btnLook" href="Ledger/many_choice?type=2&name=buildCompany" lookupGroup="buildCompany">查找带回</a>
            </p>
            <p>
                <label>监理单位：</label>
                <input name="monitorCompany.companyId"  class="required" value="${LedgerList.monitorCompany}" type="hidden">
                <input name="monitorCompany.companyName"  class="required search input-icon" value="${LedgerList.monitorCompany}" type="text"/>
                <a class="btnLook" href="Ledger/many_choice?type=1&name=monitorCompany" lookupGroup="monitorCompany">查找带回</a>
            </p>
            <p>
                <label>竣工日期：</label>
                <input name="completeDate" type="text" value="${LedgerList.completeDateStr}" class="date input-icon" size="28" /><a class="inputDateButton" href="javascript:;">选择</a>
            </p>
            <dl class="nowrap">
                <dt>设备地址：</dt>
                <dd><textarea name="address" cols="80" rows="2">${LedgerList.address}</textarea></dd>
            </dl>
            <dl class="nowrap">
                <dt>设备类型及规格：</dt>
                <dd> <textarea  name="specification" cols="80" rows="2">${LedgerList.specification}</textarea></dd>
            </dl>
            <dl class="nowrap">
                <dt>备　　注：</dt>
                <dd><textarea name="memo" cols="80" rows="2">${LedgerList.memo}</textarea></dd>
            </dl>
        </div>
        <div class="formBar">
            <ul>
                <c:if test="${isdbClick ne 1}">
                    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
                </c:if>
                <li>
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
                <input type="hidden" value="${isdbClick}" id="test">
            </ul>
        </div>
    </form>
</div>
<style>
    .input-width input,.input-width select{
        display:inline-block;
        box-sizing:border-box;
        width:216.6px;
        height:21px;
        margin-left:0;
    }
    .input-width .input-icon{
        width:202px;
    }
    .input-width textarea{
        width:595px;
    }
    p a.btnLook{
        float:none;
        margin-right:0;
    }
</style>
<script>
    (function(){
        var allTag = document.getElementsByTagName('div');
        var reg = /tunnelRecordView/;
        var arr = [];
        for(var i=0; i<allTag.length; i++){
            var el = allTag[i].id;
            if(reg.test(el)){
                arr.push(el);
            }
        }
        console.log(arr)
        arr.forEach(function(item){
            $('#'+item).css({
                'height':'280px'
            })
        })
    })();

    <%--function dbltable(target,rel){--%>
        <%--if( target == 'rid'){--%>
            <%--$.pdialog.open("customers/report.php?action=view&rid="+rel,"pdialogid", "标题", { max:true, mask:false, width: 500, height: 300});--%>
        <%--}--%>
    <%--}--%>
</script>


