<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<style>
    .tongdao-table,.sheb-table {
        table-layout: fixed;
        width:99%;
    }
    .table-label {
        width:70px;
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
<div class="pageContent">

            <div class="panel">
                <div class="panelHeader">
                    <div class="panelHeaderContent">
                        <h1 style="cursor: move;">输配电档案基本信息</h1>
                    </div>
                </div>
                <div class="panelContent">
                    <table class="tongdao-table" style="width:97%;margin-top:20px;">
                        <tr>

                            <td class="table-label">档案编号:</td>
                            <td>
                                <input name="ledgerCode" type="text" size="18" value="${cableDeviceLedgerPage.ledgerCode}"  class="required"/>
                            </td>
                            <td class="table-label">电压等级:</td>
                            <td>
                                <input name="ledgerCode" type="text" size="18" value="${cableDeviceLedgerPage.ledgerCode}"  class="required"/>
                            </td>

                        </tr>
                        <tr>
                            <td class="table-label">工程名称:</td>
                            <td>
                                <input name="ledgerName" type="text" size="18" value="${cableDeviceLedgerPage.ledgerName}" class="required" />
                            </td>
                            <td class="table-label">方案编号:</td>
                            <td>
                                <input name="projectCode" type="text" size="18" value="${cableDeviceLedgerPage.projectCode}" class="required" />
                            </td>
                        </tr>
                        <tr>
                            <td class="table-label">工程类型:</td>
                            <td>
                                <input name="ledgerCode" type="text" size="18" value="${cableDeviceLedgerPage.ledgerCode}"  class="required"/>
                            </td>

                            <td class="table-label">施工时间:</td>
                            <td>
                                <input type="text" size="18" name="buildDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${cableDeviceLedgerPage.buildDate}" type="both"/>" class="required"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="table-label">竣工时间:</td>
                            <td>
                                <input type="text" size="18" name="accpetDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${cableDeviceLedgerPage.accpetDate}" type="both"/>" class="required"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="table-label" valign="top">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</td>
                            <td colspan="3">
                                <textarea name="memo" cols="80" style="width:80%;height:50px;">${cableDeviceLedgerPage.memo}</textarea>
                            </td>
                        </tr>

                        <c:if test="${cableInspecteManagePage.acceptStatusTypeID eq 7}">
                            <tr>
                                <td class="table-label">
                                    再次审核：
                                </td>
                                <td colspan="1">
                                    <a href="${ctxPath}/CableInspecteManage/${pathType}/check/${num}?acceptRecordNum=${cableInspecteManagePage.acceptRecordNum}&status=1&checkType=2&readonly=2" target="ajaxTodo" title="确定审核通过?" warn="请选择一条记录"><span>审核通过</span></a>
                                </td>
                            </tr>
                        </c:if>
                    </table>
                    </div>
        </div>

            <div class="panel">
                <div class="panelContent">
                    <table class="table" layoutH="260" targetType="ajaxTodo" width="100%">
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
                                <td>${li.arichveFileName}</td>
                                <td>${li.arichiveFileTypeName}</td>
                                <td>${li.userName}</td>
                                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${li.arichiveFileDate}" type="both"/></td>
                                <td>${li.archileFilePath}</td>
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
