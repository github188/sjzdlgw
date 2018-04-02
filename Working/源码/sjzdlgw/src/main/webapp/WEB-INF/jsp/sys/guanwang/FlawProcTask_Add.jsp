<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    .guanwang-gjt .inputDateButton,.guanwang-gjt .btnLook{
        width:21px;
    }
    .pageFormContentaaa{
        height: 355px !important;
    }

</style>
<%--<script src="${staticPath}/js/FlawProcTask.js" type="text/javascript"></script>--%>
<script type="application/javascript">
    function FlawProcTask_onArchiesDataInput() {
        var objFlawNums=document.getElementById('FlawProcTask_assetNum');
        if(objFlawNums.value!=null&&objFlawNums.value!=undefined){

            console.log(objFlawNums.value);
            $.get("FlawProcTask/${teamTypeID}/getInspectObj?objFlawNum="+objFlawNums.value, function(result){
                console.log(result);
                var resultJson = eval("(" + result + ")");
                var ddd=document.getElementById("FlawProcTask_SelectResultDiv");
                var idInput=document.getElementById("FlawProcTask_objFlawNumList");
                if (ddd!=null){
                    var htmlStr="";
                    var objIdStr="";
                    for( var o in resultJson){
                        var obj=resultJson[o];
                        htmlStr=htmlStr+"<tr>";
                        var isFlawStr="否";
                        if (obj.isFlaw>0){
                            isFlawStr="是";
                        }
                        objIdStr=objIdStr+obj.objFlawNum+",";
                        htmlStr=htmlStr+"<td>"+obj.flawAduitStatusName+"</td>";
                        htmlStr=htmlStr+"<td>"+obj.objTypeEnumName+"</td>";
                        htmlStr=htmlStr+"<td>"+obj.objTableNum+"</td>";
                        htmlStr=htmlStr+"<td>"+obj.objCode+"</td>";
                        htmlStr=htmlStr+"<td>"+isFlawStr+"</td>";
                        htmlStr=htmlStr+"<td>"+obj.flawSourceName+"</td>";
                        htmlStr=htmlStr+"<td>"+obj.flawTypeName+"</td>";
                        htmlStr=htmlStr+"<td>"+obj.flawLevelTypeName+"</td>";
                        htmlStr=htmlStr+"<td>"+obj.flawDescription+"</td>";
                        htmlStr=htmlStr+"<td>"+obj.flawDateStr+"</td>";
                        htmlStr=htmlStr+"</tr>"
                    }
                    console.log(htmlStr);;
                    console.log(ddd);
                    if (idInput!=null) {

                        idInput.value=objIdStr;
                    }
                    ddd.innerHTML=htmlStr;
                }
            });
        }

    }
</script>
<div class="pageContent"  style="${type==1?'height: 357px;':''}">
    <form method="post" action="${ctxPath}/FlawProcTask/${teamTypeID}/add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" name="flawProcTaskNum" value="${FlawProcTask.flawProcTaskNum}"/>
        <input type="hidden" name="IsNew" value="${IsNew}">
        <div class="pageFormContent guanwang-gjt">
            <div class="a-title" style="display:${type==1?"":"none"}">
                <div class="a-left"></div>
                <div class="a-right">发起任务</div>
            </div>
            <p>
                <label>任务名称：</label>
                <input name="flawProcTaskName"  ${IsNew==1?"":"readonly=\"readonly\""} class="required" type="text" size="30"  value="${FlawProcTask.flawProcTaskName}" />
            </p>
            <p>
                <label>详细说明：</label>
                <input name="flawProcTaskDescption"   ${IsNew==1?"":"readonly=\"readonly\""} value="${FlawProcTask.flawProcTaskDescption}" type="text" size="30" />
            </p>

            <p>
                <label>作业单位：</label>
                <select name="workUnit" class="combox" ref="workTeam" refUrl="/Organization/api/findObj?parentID={value}">
                    <option value="-1">请选择作业单位</option>
                    <c:forEach var="item" items="${organizationPageList}">
                        <option value="${item.organizationNum}">${item.organizationName}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label>作业班组：</label>
                <select name="workTeam" class="combox" id="workTeam" style="width: 200px;" ref="workManage" refUrl="/Employee/api/findObj?organizationNum={value}">
                    <option value="-1">请选择作业班组</option>
                </select>
            </p>
            <p>
                <label>工作负责人：</label>
                <select name="user.employeeID" class="combox" id="workManage" style="width: 200px;">
                    <option value="">请选择工作负责人</option>
                </select>
            </p>
            <p>
                <label>计划时间：</label>
                <input name="planDate"   ${IsNew==1?"":"readonly=\"readonly\""} type="text"  value="${FlawProcTask.planDateStr}" class="date input-icon" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
            </p>
            <p>
                <label>备注：</label>
                <input name="memo"   ${IsNew==1?"":"readonly=\"readonly\""}  type="text" size="30"  value="${FlawProcTask.memo}" />
            </p>
            <p>
                <label>消缺本体：</label>
                <input id="FlawProcTask_assetNum"  ${IsNew==1?"":"readonly=\"readonly\""}  name="obj.objFlawNum" style="width: 182px" />
                <span><a class="btnLook"  ${IsNew==1?"":"readonly=\"readonly\""} href="${ctxPath}/ManyChoice/${teamTypeID}/InspectObjFlaw?type=1" lookupGroup="obj">查找带回</a></span>
                <input id="FlawProcTask_objFlawNumList"  ${IsNew==1?"":"readonly=\"readonly\""} name="objFlawNumList" type="hidden"  value="${FlawProcTask.flawProcTaskNum}"/>

            </p>

            <div class="buttonActive">
                <div class="buttonContent">
                    <button type="button"  onclick="FlawProcTask_onArchiesDataInput()">查找下属设备</button>
                </div>
            </div>
        </div>
        <div class="pageFormContent pageFormContentaaa" ${type==1?"":"layoutH='200'"}>
            <table class="table" width="100%" >
                <thead>
                <tr>
                    <th width="60">缺陷状态</th>
                    <th width="60">对象类型</th>
                    <th width="60">对象编号</th>
                    <th width="60">对象编码</th>
                    <th width="50">有缺陷</th>
                    <th width="60">来源类型</th>
                    <th width="60">缺陷分类</th>
                    <th width="60">缺陷等级</th>
                    <th width="60">缺陷描述</th>
                    <th width="60">录入时间</th>
                </tr>
                </thead>
                <tbody id="FlawProcTask_SelectResultDiv">
                <c:forEach items="${FlawProcTaskObjList}" var="ob" varStatus="vs">
                    <tr >
                        <td>${ob.flawAduitStatusName}</td>
                        <td>${ob.objTypeEnumName}</td> <%--通道编号---%>
                        <td>${ob.objTableNum}</td> <%--运行编号---%>
                        <td>${ob.objCode}</td>  <%--所属变电站---%>
                        <td>${ob.isFlaw>0?"是":"否"}</td>
                        <td>${ob.flawSourceName}</td>
                        <td>${ob.flawTypeName}</td>
                        <td>${ob.flawLevelTypeName}</td>
                        <td>${ob.flawDescription}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div style="text-align:center;margin-top:30px;display:${type==1&&IsNew==1?"":"none"}">
            <button type="submit" class="a-submit">保存</button>
            <button type="button" class="a-close">取消</button>
        </div>

        <div class="formBar" style="display:${type==1?"none":""}">
            <ul>
                <c:if test="${isDbClick ne 1}">
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
                </c:if><li>
                <input type="hidden" id="test" value="${isDbClick}">
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div>
    </form>
</div>