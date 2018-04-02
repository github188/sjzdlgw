<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tanrong
  Date: 16/10/3
  Time: 下午2:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<style>
    .guanwang-gjt p input,.guanwang-gjt p select{
        width:202px;
        height:21px;
        box-sizing:border-box;
        margin-left:0;
    }
    .guanwang-gjt .input-icon{
        width:186px;
    }
    .guanwang-gjt a{
        width:174px;
    }
    .guanwang-gjt .inputDateButton{
        width:21px;
    }
</style>
<div class="pageContent">
    <form method="post" action="${ctxPath}/FireWall/add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" name="assetNum" value="${FireWall.assetNum}"/>
        <div class="pageFormContent guanwang-gjt" layoutH="56">
            <p>
                <label>档案编号：</label>
                <input name="archivesCode" class="required" type="text" size="30" value="${FireWall.archivesCode}" />
            </p>
            <p>
                <label>通道编号：</label>
                <input name="tunnel_AssetNum.assetNum" value="${PowerTunnel.tunnel_AssetNum}" type="hidden">
                <input class="required" name="tunnel_AssetNum.archivesNum" type="text" value="${FireWall.tunnelAssetCode}" suggestFields="archivesNum" suggestUrl="/PowerTunnel/suggest_tunnel_AssetNum" lookupGroup="tunnel_AssetNum"/>
                <span class="info"></span>
            </p>
            <p>
                <label>防火墙编号：</label>
                <input name="assetCode" class="required" type="text" size="30"  value="${FireWall.assetCode}" />
            </p>
            <p>
                <label>类型：</label>
                <select name="fireWallTypeID" class="required combo-box">
                    <c:forEach items="${FireWallTypeList}" var="ob" varStatus="id">
                        <option value="${ob.fireWallTypeID}" ${FireWall.fireWallTypeID eq ob.fireWallTypeID ? 'selected="selected"':''} >${ob.fireWallTypeName}</option>
                    </c:forEach>
                </select>
           </p>
            <p>
                <label>材质：</label>
                <select name="fireWallStuffTypeID" class="required combo-box">
                    <c:forEach items="${FireWallStuffTypeList}" var="ob" varStatus="id">
                        <option value="${ob.fireWallStuffTypeID}" ${FireWall.fireWallStuffTypeID eq ob.fireWallStuffTypeID ? 'selected="selected"':''} >${ob.fireWallStuffTypeName}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label>尺寸：</label>
                <input name="wallSize"  type="text" size="30"  value="${FireWall.wallSize}" />
            </p>
            <p>
                <label>施工单位：</label>
                <input name="build_company.companyNum" value="${FireWall.buildCompany}" type="hidden">
                <input  name="build_company.companyName" type="text" value="${FireWall.buildCompanyStr}" suggestFields="companyName" suggestUrl="/Company/suggest_company?type=2&" lookupGroup="build_company"/>

            </p>
            <p>
                <label>监理单位：</label>
                <input name="monitor_company.companyNum" value="${FireWall.monitorCompany}" type="hidden">
                <input  name="monitor_company.companyName" type="text" value="${FireWall.monitorCompanyStr}" suggestFields="companyName" suggestUrl="/Company/suggest_company?type=1&companyName=" lookupGroup="monitor_company"/>

            </p>
            <p>
                <label>竣工日期：</label>

                <input name="completedDate" type="text" value="${FireWall.completeDateStr}" class="date input-icon" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>

            </p>
            <p>
                <label>安装时间：</label>
                <input name="buildDate" type="text"  value="${FireWall.buildDateStr}" class="date input-icon" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>

            </p>
            <p>
                <label>防火门材质：</label>
                <select name="doorStuffTypeID" class="required combo-box">
                    <c:forEach items="${DoorStuffTypeList}" var="ob" varStatus="id">
                        <option value="${ob.doorStuffTypeID}" ${FireWall.doorStuffTypeID eq ob.doorStuffTypeID ? 'selected="selected"':''} >${ob.doorStuffTypeName}</option>
                    </c:forEach>
                </select>
             </p>
            <p>
                <label>防火门尺寸：</label>
                <input name="doorSize"  type="text" size="30"  value="${FireWall.doorSize}" />
            </p>
            <p>
                <label>防火墙厂家：</label>
                <input name="firewall_company.companyNum" value="${FireWall.company}" type="hidden">
                <input  name="firewall_company.companyName" type="text" value="${FireWall.companyStr}" suggestFields="companyName" suggestUrl="/Company/suggest_company?type=2&companyName=" lookupGroup="firewall_company"/>

            </p>
            <p>
                <label>防火门出厂日期：</label>
                <input name="doorBuildDate" type="text"  value="${FireWall.doorBuildDateStr}" class="date input-icon" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>

            </p>
            <p>
                <label>经度：</label>
                <input name="longitude"type="number" size="30"  value="${FireWall.longitude}" />
            </p>
            <p>
                <label>纬度：</label>
                <input name="latitude"  type="number" size="30" value="${FireWall.latitude}" />
            </p>
            <p>
                <label>所在方位：</label>
                <input name="positionDescription"  type="text" size="30"  value="${FireWall.positionDescription}" />
            </p>
            <p>
                <label>备注：</label>
                <input name="memo"  type="text" size="30"  value="${FireWall.memo}" />
            </p>
        </div>
        <div class="formBar">
            <ul>
                <c:if test="${isDbClick ne 1}">
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
                </c:if>
                <li>
                    <input type="hidden" id="test" value="${isDbClick}">
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div>
    </form>
</div>

