<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>

<div class="pageContent " >

    <div style="height: 100px;margin-top:30px;">
        <div class="searchBar" style="border-bottom:1px solid #B5B5B5;padding-bottom:30px;margin-left:4px;margin-right:4px;">
            <table id="jbsxBox_tunnel_aduit" class="a-jd">
                <tr>
                    <td class='a-jg'}>
                        <a href="/CableInspecteManage/${pathType}/add/${CableInspecteManage_archivesNum}?type=1"  target="ajax" rel="jbsxBox_tunnel">新建任务</a>
                    </td>
                    <td ${(CableInspecteManage==3||CableInspecteManage==4||CableInspecteManage==5||CableInspecteManage==2)?"class='a-jg'":""}>
                        <div></div>
                        <a href="/CableInspecteManage/${pathType}/append/${CableInspecteManage_archivesNum}" style="display: ${(CableInspecteManage==3||CableInspecteManage==4||CableInspecteManage==5||CableInspecteManage==2)?"":"none"}"target="ajax" rel="jbsxBox_tunnel">确定任务</a>
                        <a href="javascript:;" style="display: ${(CableInspecteManage==3||CableInspecteManage==4||CableInspecteManage==5||CableInspecteManage==2)?"none":""}">确定任务</a>
                    </td>
                    <td ${(CableInspecteManage==4||CableInspecteManage==5||CableInspecteManage==3)?"class='a-jg'":""}>
                        <div></div>
                        <a href="/CableInspecteManage/${pathType}/aduit/${CableInspecteManage_archivesNum}" style="display: ${(CableInspecteManage==4||CableInspecteManage==5||CableInspecteManage==3)?"":"none"}"target="ajax" rel="jbsxBox_tunnel">完成计划</a>
                        <a href="javascript:;" style="display: ${(CableInspecteManage==4||CableInspecteManage==5||CableInspecteManage==3)?"none":""}">完成计划</a>
                    </td>
                    <td ${(CableInspecteManage==4||CableInspecteManage==5)?"class='a-jg'":""}>
                        <div></div>
                        <a href="/CableInspecteManage/${pathType}/check/${CableInspecteManage_archivesNum}" style="display: ${(CableInspecteManage==4||CableInspecteManage==5)?"":"none"}"target="ajax" rel="jbsxBox_tunnel">审核验收</a>
                        <a href="javascript:;" style="display: ${(CableInspecteManage==4||CableInspecteManage==5)?"none":""}">审核验收</a>
                    </td>
                    <td ${(CableInspecteManage==5)?"class='a-jg'":""}>
                        <div></div>
                        <a href="/CableInspecteManage/${pathType}/view/${CableInspecteManage_archivesNum}" style="display: ${(CableInspecteManage==5)?"":"none"}" target="ajax" rel="jbsxBox_tunnel">完成验收</a>
                        <a href="javascript:;" style="display: ${(CableInspecteManage==5)?"none":""}">完成验收</a>

                    </td>
                </tr>
            </table>
        </div>
    </div>
    <div id="jbsxBox_tunnel"   defH="90" style="height: 90%;">

    </div>
    <script>
        $(function() {
            var _a = $('#jbsxBox_tunnel_aduit tr td:eq(${CableInspecteManage-1}) a');
            setTimeout(function(){
                _a.click();
            },500);
            /*var _url = _a.attr('href')
             $('#jbsxBox').load(_url);*/
        });
    </script>
</div>

