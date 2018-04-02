<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%--<script src="${staticPath}/js/InspectTask.js"  type="text/javascript"></script>--%>
<script type="application/javascript">
    function InspectTask_onArchiesDataInput(value) {

    <c:if test="${teamTypeID==1}">
        var input=document.getElementById('InspectTask_archivesNum');
        var assetNums=document.getElementById('InspectTask_assetNum');
        var taskNum=document.getElementById('InspectTask_taskNum');
        if(input.value!=null&&input.value!=undefined&&assetNums.value!=null&&assetNums.value!=undefined
                &&taskNum.value!=null||taskNum.value!=""){

            console.log(input.value);
            console.log(assetNums.value);
            console.log(taskNum.value)
            $.get("InspectTask/${teamTypeID}/getArchivesObject?assetNum="+assetNums.value+"&archivesNum="+input.value+"&taskNum="+taskNum.value, function(result){
                console.log(result);
                var resultJson = eval("(" + result + ")");
                var ddd=document.getElementById("InspeactTask_SelectResultDiv");
                if (ddd!=null){

                    ddd.innerHTML=resultJson.html;
                }
                var inp=document.getElementById("InspectTask_assetValues");
                if (inp!=null){
                    inp.value=resultJson.value;
                }
            });
        }
        </c:if>


    <c:if test="${teamTypeID!=1}">
        var input=document.getElementById('pathSectionNum');
        var taskNum=document.getElementById('InspectTask_taskNum');
        if(input.value!=null&&input.value!=undefined){

            console.log(input.value);
            $.get("InspectTask/${teamTypeID}/getArchivesObject?pathSectionNum="+input.value+"&taskNum="+taskNum.value, function(result){
                console.log(result);
                var resultJson = eval("(" + result + ")");
                var ddd=document.getElementById("InspeactTask_SelectResultDiv");
                if (ddd!=null){

                    ddd.innerHTML=resultJson.html;
                }
                var inp=document.getElementById("InspectTask_assetValues");
                if (inp!=null){
                    inp.value=resultJson.value;
                }
            });
        }
    </c:if>

    }
</script>
<div class="pageContent" style="height: 100%;">
    <form method="post" action="${ctxPath}/InspectTask/${teamTypeID}/assign" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
        <input id="InspectTask_taskNum" type="hidden" name="taskNum" value="${InspectTask.taskNum}"/>
        <input id="InspectTask_assetValues" type="hidden" name="assetValues" />
        <div class="pageFormContent">
            <div class="a-title">
                <div class="a-left"></div>
                <div class="a-right">确定任务</div>
            </div>
            <div>
                <p>
                    <label>两卡票号：</label>
                    <input name="workBillsCode" ${readonly==0?'':'readonly="readonly"'} value="${InspectTask.workBillsCode}" required="required" type="text" size="30" />

                </p>
                <p>
                    <label>班组成员：</label>
                    <input name="workers.employeeID" value="" type="hidden">
                    <input name="workers.userName" class="task" value="" type="text" size="30" readonly="true" required="required"/>
                    <span><a class="btnLook" href="${ctxPath}/ManyChoice/Employee?type=2&employeeID=${InspectTask.task_EmployeeID}" lookupGroup="workers">查找带回</a></span>
                </p>
                <p>
                    <c:if test="${teamTypeID==1}"><label>选择档案：</label></c:if>
                    <c:if test="${teamTypeID!=1}"><label>选择线路段：</label></c:if>
                    <c:if test="${teamTypeID==1}">
                        <input id="InspectTask_assetNum" name="archives.assetNum" type="hidden" />
                        <input id="InspectTask_archivesNum" type="hidden" name="archives.archivesNum" />
                        <input name="archives.archivesCode"  class="task"/>
                    </c:if>
                    <c:if test="${teamTypeID!=1}">
                        <input id="pathSectionNum" name="pathSectionPage.pathSectionNum" hidden="hidden"/>
                        <input name="pathSectionPage.pathSectionCode" />
                    </c:if>
                    <c:if test="${teamTypeID==1}"><span><a class="btnLook" href="${ctxPath}/ManyChoice/PowerTunnel" lookupGroup="archives">查找带回</a></span></c:if>
                    <c:if test="${teamTypeID!=1}"><span><a class="btnLook" href="${ctxPath}/ManyChoice/PathSection/${teamTypeID==2?'1':teamTypeID==3?'2':'1'}" lookupGroup="pathSectionPage">查找带回</a></span></c:if>

                </p>
                <div class="buttonActive">
                    <div class="buttonContent">
                        <button type="button" ${readonly==0?'':'disabled="disabled"'}  class="close" onclick="InspectTask_onArchiesDataInput()">查找下属设备</button>
                    </div></div>

            </div>
        </div>
        <div class="pageFormContent">
            <table class="table" width="100%" >
                <thead>
                <tr>
                    <th width="60">对象类型</th>
                    <th width="60">对象编码</th>
                </tr>
                </thead>
                <tbody id="InspeactTask_SelectResultDiv">
                ${InspectTask_HTML}
                </tbody>
            </table>
        </div>
        <div style="text-align:center;margin-top:30px;display:${readonly==0?'':'none'}">
            <button type="submit" class="a-submit">保存</button>
            <button type="button" class="a-close">取消</button>
        </div>
        <%-- <div class="formBar">
            <ul>
                <li><div  class="${readonly==0?'buttonActive':'buttonDisabled'}" ><div class="buttonContent"><button type="${readonly==0?'submit':'button'}">保存</button></div></div></li>
                <li>
                    <div  class="${readonly==0?'buttonActive':'buttonDisabled'}" ><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div> --%>
    </form>
</div>
