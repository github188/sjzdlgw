<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: hy
  Date: 16/10/27
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<div class="pageContent">
	
    <form method="post" action="${ctxPath}/LedgerStatistics/add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" name="archivesNum" value="${LedgerList.archivesNum}"/>
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>档案编号：</label>
                <input name="archivesCode" type="text" size="30" value="${LedgerList.archivesCode}" readonly="readonly" class="required"/>
            </p>
            <p>

                <label>所属变电站：</label>
                <select name="baseFacilityNum" class="required combo-box">
                    <c:forEach items="${baseFacilityList}" var="ob" varStatus="id">
                        <option value="${ob.baseFacilityNum}" ${LedgerList.baseFacilityNum eq ob.baseFacilityNum ? 'selected="selected"':''} >${ob.baseFacilityName}</option>
                    </c:forEach>
                </select>
            </p>
            </p>
            <p>
                <label>档案名称：</label>
                <input name="archivesName" class="required" type="text" size="30" value="${LedgerList.archivesName}" />
            </p>
            <p>
                <label>资产分界：</label>
                <select name="assetBorderTypeID" class="required combo-box">
                    <c:forEach items="${assetBorderTypeList}" var="ob" varStatus="id">

                        <option value="${ob.assetBorderTypeID}"  ${LedgerList.assetBorderTypeID eq ob.assetBorderTypeID ? 'selected="selected"':''} >${ob.assetBorderTypeName}</option>
                    </c:forEach>
                </select>
            </p>
            <p >
                <label>盒内档案号：</label>
                <input name="drawerCode"  class="required" class="digits" type="text" size="30" value="${LedgerList.drawerCode}" alt="" readonly="readonly"/>
            </p>
            <p>
                <label>档案存放位置：</label>
                <input  name="archivesPlace" type="text" size="30" value="${LedgerList.archivesPlace}" />
            </p>
            <p>
                <label>施工单位：</label>
                <input name="buildCompany.companyId"  class="required" value="${LedgerList.buildCompany}" type="hidden">
                <input name="buildCompany.companyName"   class="required" value="${LedgerList.buildCompany}" type="text"/>
                <a class="btnLook" href="LedgerStatistics/many_choice?type=2&name=buildCompany" lookupGroup="buildCompany">查找带回</a>
            </p>
            <p>
                <label>监理单位：</label>
                <input name="monitorCompany.companyId"  class="required" value="${LedgerList.monitorCompany}" type="hidden">
                <input name="monitorCompany.companyName"  class="required" value="${LedgerList.monitorCompany}" type="text"/>
                <a class="btnLook" href="LedgerStatistics/many_choice?type=1&name=monitorCompany" lookupGroup="monitorCompany">查找带回</a>
            </p>
            <p>
                <label>竣工日期：</label>
                <input name="completeDate" type="text" value="${LedgerList.completeDateStr}" class="date" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
            </p>
          <div style="clear:both;padding-top:5px;">
                <label>设备地址：</label>
                <textarea name="address"  value="${LedgerList.address}"  rows="5" cols="80">
                	${LedgerList.address}
                </textarea>
           </div>
           <div style="clear:both;padding-top:10px;">
                <label>设备类型及规格：</label>
                <textarea  name="specification"  value="${LedgerList.specification}" rows="5" cols="80" >
                	${LedgerList.specification}
                </textarea>
           </div>
            <div style="clear:both;padding-top:10px;">
                <label>备注：</label>
                <textarea name="memo" value="${LedgerList.memo}"  type="text" rows="5" cols="80" >
                	${LedgerList.memo}
                </textarea>
            </div>
        </div>
        
        <div class="panelBar">
        <ul class="toolBar">
            <%-- <li><a class="edit" href="${ctxPath}/PowerTunnel/index?archivesCode=${LedgerList.archivesCode}" target="dialog" rel="LedgerSatistics_Index_02" title="通道台账" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>查看档案</span></a></li>
            <li class="line">line</li> --%>
           <!--  <li><a class="edit" href="javascript:void(0);" target="dialog" rel="LedgerSatistics_Index_03"><span>查看附件</span></a></li> -->
            <li style="float:right"><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
            <li style="float:right">
               <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
            </li>
        </ul>
    </div>
     
    </form>
</div>


