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
    <form method="post" action="${ctxPath}/InspectObjFlaw/${teamTypeID}/choiceObj" class="pageForm required-validate" onsubmit="return dwzSearch(this,'dialog');">
        <div class="pageFormContent" layoutH="56">
            <div class="searchBar">
                <div class="choice_obj">
                    <div class="choice_text">选择缺陷对象：
                        <c:if test="${teamTypeID==1}">
                            <input id="InspectObjFlaw_assetNum" name="archives.assetNum" type="hidden" />
                            <input id="InspectObjFlaw_archivesNum" type="hidden" name="archives.archivesNum" />
                            <input name="archives.archivesCode" style="float:left;" />
                        </c:if>
                        <c:if test="${teamTypeID!=1}">
                            <input id="pathSectionNum" name="pathSectionPage.pathSectionNum" hidden="hidden"/>
                            <input name="pathSectionPage.pathSectionCode" />
                        </c:if>
                    </div>
                    <div class="choice_icon">
                        <c:if test="${teamTypeID==1}"><span><a class="btnLook" href="${ctxPath}/ManyChoice/PowerTunnel" lookupGroup="archives">查找带回</a></span></c:if>
                        <c:if test="${teamTypeID!=1}"><span><a class="btnLook" href="${ctxPath}/ManyChoice/PathSection/1" lookupGroup="pathSectionPage">查找带回</a></span></c:if>
                    </div>
                </div>
                <%--<table class="searchContent">--%>
                    <%--<tr>--%>
                        <%--<td>--%>
                            <%--<label>选择缺陷对象：</label>--%>
                            <%--<c:if test="${teamTypeID==1}">--%>
                                <%--<input id="InspectObjFlaw_assetNum" name="archives.assetNum" type="hidden" />--%>
                                <%--<input id="InspectObjFlaw_archivesNum" type="hidden" name="archives.archivesNum" />--%>
                                <%--<input name="archives.archivesCode" style="float:left;" />--%>
                            <%--</c:if>--%>
                            <%--<c:if test="${teamTypeID!=1}">--%>
                                <%--<input id="pathSectionNum" name="pathSectionPage.pathSectionNum" hidden="hidden"/>--%>
                                <%--<input name="pathSectionPage.pathSectionCode" />--%>
                            <%--</c:if>--%>
                            <%--<c:if test="${teamTypeID==1}"><span><a class="btnLook" href="${ctxPath}/ManyChoice/PowerTunnel" lookupGroup="archives">查找带回</a></span></c:if>--%>
                            <%--<c:if test="${teamTypeID!=1}"><span><a class="btnLook" href="${ctxPath}/ManyChoice/PathSection/1" lookupGroup="pathSectionPage">查找带回</a></span></c:if>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                <%--</table>--%>

                <div class="subBar">
                    <ul>
                        <li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
                        <li><div class="buttonActive"><div class="buttonContent"><button type="reset">重置</button></div></div></li>
                    </ul>
                </div>
                <div class="panelBar">
                    <ul class="toolBar">
                        <li><a class="edit" href="${ctxPath}/InspectObjFlaw/${teamTypeID}/add/-1?object={sid_pt}" target="dialog" rel="InspectObjFlaw_Obj_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>录入缺陷</span></a></li>
                        <li class="line">line</li>
                    </ul>
                </div>
                <table class="table" width="100%">
                    <thead>
                    <tr>
                        <th width="40">序号</th>
                        <th width="60">对象类型</th>
                        <th width="60">对象编码</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${data}" var="ob" varStatus="vs">
                        <tr target="sid_pt" rel="{'assetNum':'${ob.assetNum}','assetCode':'${ob.assetCode}','objTypeEnum':'${ob.objTypeEnum}'}">
                            <%--<c:if test="${teamTypeID==1}"><tr target="sid_pt" rel="{'assetNum':'${ob.assetNum}','assetCode':'${ob.assetCode}','objTypeEnum':'${ob.objTypeEnum}'}"></c:if>--%>
                            <%--<c:if test="${teamTypeID==2 || teamTypeID==3}"><tr target="sid_pt" rel="{'pathSectionNum':'${ob.assetNum}','assetCode':'${ob.assetCode}','objTypeEnum':'${ob.objTypeEnum}'}"></c:if>--%>
                            <td>${vs.index+1}</td>
                            <td>${ob.objTypeEnumName}</td>
                            <td>${ob.assetCode}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>

    </form>
</div>
<style>
    .choice_text{
        float:left;
    }
    .choice_icon{
        overflow:hidden;
        float:left;
    }
</style>



