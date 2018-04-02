<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<div class="pageContent">

    <div style="height: 100px;margin-top:30px;">
        <div class="searchBar"
             style="border-bottom:1px solid #B5B5B5;padding-bottom:30px;margin-left:4px;margin-right:4px;">
            <table id="jbsxBox_tunnel_aduit${TunnelAduit_archivesNum}" class="a-jd">
                <tr>
                    <td ${(TunnelAduitStatusID==1)?"class='a-jg'":""}}>
                        <a controlTreeID="2803"
                           href="/TunnelAduit/add/${TunnelAduit_archivesNum}?type=1&recordNum=${empty recordNum?'':recordNum}"
                           target="ajax" rel="jbsxBox_tunnel${TunnelAduit_archivesNum}"
                           style="display: ${(TunnelAduitStatusID!=1)?"none":""}">新建计划</a>
                        <a href="javascript:;" style="display: ${(TunnelAduitStatusID==1)?"none":""}">新建计划</a>
                    </td>
                    <td ${(TunnelAduitStatusID==2)?"class='a-jg'":""}>
                        <div></div>
                        <a controlTreeID="2804"
                           href="/TunnelAduit/append/${TunnelAduit_archivesNum}?recordNum=${empty recordNum?'':recordNum}"
                           style="display: ${(TunnelAduitStatusID==2)?"":"none"}" target="ajax"
                           rel="jbsxBox_tunnel${TunnelAduit_archivesNum}">确定任务</a>
                        <a href="javascript:;" style="display: ${(TunnelAduitStatusID==2)?"none":""}">确定计划</a>
                    </td>
                    <td ${(TunnelAduitStatusID==3)?"class='a-jg'":""}>
                        <div></div>
                        <a controlTreeID="2805"
                           href="/TunnelAduit/aduit/${TunnelAduit_archivesNum}?recordNum=${empty recordNum?'':recordNum}"
                           style="display: ${(TunnelAduitStatusID==3)?"":"none"}" target="ajax"
                           rel="jbsxBox_tunnel${TunnelAduit_archivesNum}">完成计划</a>
                        <a href="javascript:;" style="display: ${(TunnelAduitStatusID==3)?"none":""}">完成计划</a>
                    </td>
                    <td ${(TunnelAduitStatusID==4)?"class='a-jg'":""}>
                        <div></div>
                        <a controlTreeID="2806"
                           href="/TunnelAduit/check/${TunnelAduit_archivesNum}?recordNum=${empty recordNum?'':recordNum}"
                           style="display: ${(TunnelAduitStatusID==4)?"":"none"}" target="ajax"
                           rel="jbsxBox_tunnel${TunnelAduit_archivesNum}">审核验收</a>
                        <a href="javascript:;" style="display: ${(TunnelAduitStatusID==4)?"none":""}">审核验收</a>
                    </td>
                    <td ${(TunnelAduitStatusID == 5)?"class='a-jg'":""}>
                        <div style="display: ${(TunnelAduitStatusID < 5)?"none":""}"></div>
                        <a controlTreeID="2807"
                           href="/TunnelAduit/view/${TunnelAduit_archivesNum}?recordNum=${empty recordNum?'':recordNum}"
                           style="display: ${(TunnelAduitStatusID==5)?"":"none"}" target="ajax"
                           rel="jbsxBox_tunnel${TunnelAduit_archivesNum}">完成验收</a>
                        <a href="javascript:;" style="display: ${(TunnelAduitStatusID <= 5)?"none":""}">完成验收</a>

                    </td>
                </tr>
            </table>
        </div>
    </div>
    <div id="jbsxBox_tunnel${TunnelAduit_archivesNum}" defH="90" style="height: 90%; width: 100%">

    </div>
    <c:if test="${TunnelAduitStatusID != 5}">
        <div id="tunnelRecordView${TunnelAduit_archivesNum}" style="height: 120px;">
            <jsp:include page="TunnelAduit_View.jsp"></jsp:include>
        </div>
    </c:if>
    <script>
        $(function () {
            var _a = $('#jbsxBox_tunnel_aduit${TunnelAduit_archivesNum} tr td:eq(${TunnelAduitStatusID-1}) a');
            removeHrefForTree();
            setTimeout(function () {
                _a.click();
            }, 500);
        });
    </script>
</div>
