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
    .tongdao-table,.sheb-table {
        table-layout: fixed;
        width:99%;
    }
    .table-label {
        width:100px;
        padding-right:10px;
        text-align: right;
    }
    .tongdao-table td {
        padding-bottom:10px;
        position: relative;
    }
    .tongdao-table td span {
        position:absolute;
        left:100%;
        margin-left: -18px;
        margin-top: 4px;
    }
    .tongdao-table input {
        width: auto;
    }
    .fang-table div{
        padding:5px;
        font-size:14px;
        cursor: default;
    }
    .fang-table div:hover{
        background:#E4F5FF;
    }
    .fang-table div.selected{
        background-color: #7cc5e5;
    }
    .tabsPage .tabsPageContent{
        overflow-y: auto;
    }
</style>


<div class="pageContent" defh="100">
            <div class="panel">
                <div class="panelHeader">
                    <div class="panelHeaderContent">
                        <h1 style="cursor: move;">通道档案基本信息</h1>
                    </div>
                </div>
                <div class="panelContent">
                    <table  class="tongdao-table" style="width:97%;margin-top:20px;">
                        <tr>
                            <td class="table-label">档案编号：</td>
                            <td>
                                <input name="archivesCode" type="text" size="18" value="${ledgerPage.archivesCode}" readonly="readonly" class="required"/>
                            </td>
                            <td class="table-label">所属变电站：</td>
                            <td>
                                <input name="archivesName" class="required" type="text" size="18" value="${ledgerPage.baseFacilityName}" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-label">档案名称：</td>
                            <td>
                                <input name="archivesName" class="required" type="text" size="18" value="${ledgerPage.archivesName}" />
                            </td>
                            <td class="table-label">资产分界：</td>
                            <td>
                                <input name="archivesName" class="required" type="text" size="18" value="${ledgerPage.assetBorderTypeName}" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-label">盒内档案号：</td>
                            <td>
                                <input name="drawerCode"  class="required" class="digits" type="text" size="18" value="${ledgerPage.drawerCode}"/>
                            </td>
                            <td class="table-label">档案存放位置：</td>
                            <td>
                                <input  name="archivesPlace" type="text" size="18" value="${ledgerPage.archivesPlace}" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-label">施工单位：</td>
                            <td>
                                <input  name="archivesPlace" type="text" size="18" value="${ledgerPage.buildCompany}" />
                            </td>
                            <td class="table-label">监理单位：</td>
                            <td>
                                <input  name="archivesPlace" type="text" size="18" value="${ledgerPage.monitorCompany}" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-label">竣工日期：</td>
                            <td>
                                <input name="completeDate" type="text" value="${ledgerPage.completeDateStr}" size="18" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-label">设备地址：</td>
                            <td colspan="3"><textarea name="address" cols="80" style="width: 85%; height:50px;">${ledgerPage.address}</textarea></td>
                        </tr>
                        <tr>
                            <td class="table-label">设备类型及规格：</td>
                            <td colspan="3"> <textarea  name="specification" cols="80" style="width: 85%; height:50px;">${ledgerPage.specification}</textarea></td>
                        </tr>
                        <tr>
                            <td class="table-label">备注：</td>
                            <td colspan="3"><textarea name="memo" cols="80" style="width: 85%; height:50px;">${ledgerPage.memo}</textarea></td>
                        </tr>

                        <c:if test="${TunnelAduit.acceptStatusTypeID eq 7}">
                            <tr>
                                <td class="table-label">
                                    再次审核：
                                </td>
                                <td colspan="1">
                                    <a href="${ctxPath}/TunnelAduit/check?status=1&acceptRecordNum=${TunnelAduit.acceptRecordNum}&archivesNum=${TunnelAduit.archivesNum}&checkType=2&readonly=2" target="ajaxTodo" title="确定审核通过?" warn="请选择一条记录">审核通过</a>
                                </td>
                            </tr>
                        </c:if>
                    </table>
                </div>
                <%--<table class="a-success-table" style="margin-left:auto;margin-right:auto;">--%>
                    <%--<tr>--%>
                        <%--<td class="w-label">任务名称：</td>--%>
                        <%--<td>${TunnelAduit.planName}</td>--%>
                        <%--<td class="w-label" class="w-label" class="w-label">两卡票号：</td>--%>
                        <%--<td>${TunnelAduit.workBillsCode}</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td class="w-label" class="w-label">工作负责人：</td>--%>
                        <%--<td>${TunnelAduit.task_EmployeeName}</td>--%>
                        <%--<td class="w-label">计划时间：</td>--%>
                        <%--<td style="color:#FF0000;">${TunnelAduit.planDateStr}</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td class="w-label" class="w-label">工作班组：</td>--%>
                        <%--<td>${TunnelAduit.acceptUserList}</td>--%>
                        <%--<td class="w-label">验收时间：</td>--%>
                        <%--<td style="color:#FF0000;">${TunnelAduit.acceptDateStr}</td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td class="w-label">审核时间：</td>--%>
                        <%--<td style="color:#FF0000;">${TunnelAduit.auditDateStr}</td>--%>
                        <%--<td class="w-label">附件：</td>--%>
                        <%--<td style="color:#FF0000;"><a  href="${ctxPath}/TunnelAduit/FileView/${TunnelAduit.acceptRecordNum}" target="dialog" rel="TunnelAduit_Index_01"title="附件"  resizable="false" drawable="true" width="800" height="600"><span>点击查看</span></a></td>--%>
                    <%--</tr>--%>
                    <%--<c:if test="${TunnelAduit.acceptStatusTypeID eq 7}">--%>
                    <%--<tr>--%>
                        <%--<td class="w-label">提交审核：</td>--%>
                        <%--&lt;%&ndash;<td style="color:#FF0000;"><a href="${ctxPath}/TunnelAduit/aduit?status=1&acceptRecordNum=${TunnelAduit.acceptRecordNum}&archivesNum=${TunnelAduit.archivesNum}" target="ajaxTodo" title="确定再次提交审核?" warn="请选择一条记录"><span>提交审核</span></a></td>&ndash;%&gt;--%>
                        <%--<td style="color:#FF0000;"><a href="${ctxPath}/TunnelAduit/check?status=1&acceptRecordNum=${TunnelAduit.acceptRecordNum}&archivesNum=${TunnelAduit.archivesNum}&checkType=2&readonly=2" target="ajaxTodo" title="确定审核通过?" warn="请选择一条记录"><span>审核通过</span></a></td>--%>
                    <%--</tr>--%>
                    <%--</c:if>--%>
                <%--</table>--%>
        </div>
            <div class="panel">
                <div class="panelContent">
                    <table class="table" layoutH="98" targetType="ajaxTodo" width="100%">
                        <thead>
                        <tr>
                            <th>资料名称</th>
                            <th>资料类型</th>
                            <th>上传人员</th>
                            <th>上传时间</th>
                            <th>文件路径</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${FileList}" var="li">
                            <tr target="sid_pt" rel="${li.archivesFileNum}">
                                <td>${li.archivesFileTypeName}</td>
                                <td>${li.archivesFileName}</td>
                                <td>${li.userName}</td>
                                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${li.archivesFileUpDate}" type="both"/></td>
                                <td>${li.archivesFilePath}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    </div>
                </div>
        </div>
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
    })()
</script>