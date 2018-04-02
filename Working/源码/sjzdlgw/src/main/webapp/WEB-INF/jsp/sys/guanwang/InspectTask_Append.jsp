<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<div class="pageContent">
    <div class="a-title">
        <div class="a-left"></div>
        <div class="a-right">录入任务</div>
    </div>
    <div class="panelBar">
        <ul class="toolBar" style="display: ${readonly==0?'':"none"}">
            <li><a class="add" href="${ctxPath}/InspectTask/${teamTypeID}/appendObj/{sid_tst}" target="dialog" rel="InspectTask_Append_01" title="录入缺陷" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="300"><span>录入巡视记录</span></a></li>
            <li class="line">line</li>
            <li controlID="${teamTypeID==1?'2829':teamTypeID==2?'3829':'4829'}"><a class="edit" href="${ctxPath}/InspectObjFlaw/${teamTypeID}/FileView/{sid_tst}" target="dialog" rel="InspectObjFlaw_Index_02_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>附件</span></a></li>
            <li class="line">line</li>
            <li><a class="edit" href="${ctxPath}/InspectTask/${teamTypeID}/complete/${InspectTask_taskNum}" target="ajaxTodo" onsubmit="return dwzSearch(this,'dialog');" rel="InspectObjFlaw_Index_02_03"><span>确定完成任务</span></a></li>
            <li class="line">line</li>
        </ul>
    </div>
    <table class="table" width="100%"  asc="asc" desc="desc">
        <thead>
        <tr>
            <th orderField="objFlawNum" class="asc" width="40" align="center">序号</th>
            <th width="60">对象类型</th>
            <th width="60">对象编号</th>
            <th width="60">对象编码</th>
            <th width="50">有缺陷</th>
            <th width="60">缺陷分类</th>
            <th width="60">缺陷等级</th>
            <th width="60">缺陷描述</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageFormParm}" var="ob" varStatus="vs">
            <tr target="sid_tst" rel="${ob.objFlawNum}">
                <td>${vs.index+1}</td>
                <td>${ob.objTypeEnumName}</td>
                <td>${ob.objTableNum}</td>
                <td>${ob.objCode}</td>
                <td>${ob.isFlaw>0?"是":"否"}</td>
                <td>${ob.flawTypeName}</td>
                <td>${ob.flawLevelTypeName}</td>
                <td>${ob.flawDescription}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
