<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>

<div class="pageContent " >

    <div style="height: 100px;margin-top:30px;">
        <div class="searchBar" style="border-bottom:1px solid #B5B5B5;padding-bottom:30px;margin-left:4px;margin-right:4px;">
            <table id="jbsxBox_tunnel_aduit${cableDeviceLedger.num}" class="a-jd">
                <tr>

                    <td ${(status_show==1)?"class='a-jg'":""}>
                        <a  controlTreeID="${pathType eq 1?'3803':'4803'}" href="/CableInspecteManage/${pathType}/add/${cableDeviceLedger.num}?type=1&recordNum=${empty recordNum?'':recordNum}"  target="ajax" rel="jbsxBox_record${cableDeviceLedger.num}" style="display: ${(status_show!=1)?"none":""}">新建计划</a>
                        <a href="javascript:;" style="display: ${(status_show==1)?"none":""}">新建计划</a>
                    </td>
                    <td ${(status_show==2)?"class='a-jg'":""}>
                        <div></div>
                        <a controlTreeID="${pathType==1?'3804':'4804'}" href="/CableInspecteManage/${pathType}/append/${cableDeviceLedger.num}?recordNum=${empty recordNum?'':recordNum}" style="display: ${(status_show==2)?"":"none"}"target="ajax" rel="jbsxBox_record${cableDeviceLedger.num}">确定计划</a>
                        <a href="javascript:;" style="display: ${(status_show==2)?"none":""}">确定计划</a>
                    </td>
                    <td ${(status_show==3)?"class='a-jg'":""}>
                        <div></div>
                        <a controlTreeID="${pathType==1?'3805':'4805'}" href="/CableInspecteManage/${pathType}/aduit/${cableDeviceLedger.num}?recordNum=${empty recordNum?'':recordNum}" style="display: ${(status_show==3)?"":"none"}"target="ajax" rel="jbsxBox_record${cableDeviceLedger.num}">完成计划</a>
                        <a href="javascript:;" style="display: ${(status_show==3)?"none":""}">完成计划</a>
                    </td>
                    <td ${(status_show==4)?"class='a-jg'":""}>
                        <div></div>
                        <a controlTreeID="${pathType==1?'3806':'4806'}" href="/CableInspecteManage/${pathType}/check/${cableDeviceLedger.num}?recordNum=${empty recordNum?'':recordNum}" style="display: ${(status_show==4)?"":"none"}"target="ajax" rel="jbsxBox_record${cableDeviceLedger.num}">审核验收</a>
                        <a href="javascript:;" style="display: ${(status_show==4)?"none":""}">审核验收</a>
                    </td>
                    <td ${(status_show==5)?"class='a-jg'":""}>
                        <div style="display: ${(status_show < 5)?"none":""}"></div>
                        <a controlTreeID="${pathType==1?'3807':'4807'}" href="/CableInspecteManage/${pathType}/view/${cableDeviceLedger.num}?recordNum=${empty recordNum?'':recordNum}" style="display: ${(status_show==5)?"":"none"}" target="ajax" rel="jbsxBox_record${cableDeviceLedger.num}">完成验收</a>
                        <a href="javascript:;" style="display: ${(status_show<=5)?"none":""}">完成验收</a>

                    </td>
                </tr>
            </table>
        </div>
    </div>
    <div id="jbsxBox_record${cableDeviceLedger.num}"   defH="60" style="height: 90%;">

    </div>
    <c:if test="${status_show != 5}">
        <div id="tunnelRecordView${cableDeviceLedger.num}" style="height: 120px;" >
            <jsp:include page="CableInspecteManage_View.jsp"></jsp:include>
        </div>
    </c:if>
    <script>
        $(function() {
            var _a = $('#jbsxBox_tunnel_aduit${cableDeviceLedger.num} tr td:eq(${status_show-1}) a');
            removeHrefForTree();
            setTimeout(function(){
                _a.click();
            },500);
        });
    </script>
</div>
