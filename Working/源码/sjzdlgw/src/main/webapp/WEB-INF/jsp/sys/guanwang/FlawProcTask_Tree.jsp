<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tanrong
  Date: 16/10/3
  Time: 下午2:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<div class="pageContent " >

    <div style="height: 100px;margin-top:30px;">
        <div class="searchBar" style="border-bottom:1px solid #B5B5B5;padding-bottom:30px;margin-left:4px;margin-right:4px; height: 69px;">
            <table id="jbsxBox2${FlawProcTask_flawProcTaskNum}" class="a-jd">
                <tr>
                    <td ${(FlawProcTask==null)?"class='a-jg'":""}>
                        <a controlTreeID="${teamTypeID==1?'2843':teamTypeID==2?'3843':'4843'}" href="/FlawProcTask/${teamTypeID}/add/${FlawProcTask_flawProcTaskNum}?type=1" style="display: ${(FlawProcTask==null)?"":"none"}" target="ajax" rel="jbsxBox${FlawProcTask_flawProcTaskNum}">1.发起任务</a>
                        <a href="javascript:;" style="display: ${(FlawProcTask==null)?"none":""}">1.发起任务</a>
                    </td>
                    <td ${(FlawProcTask==1)?"class='a-jg'":""}>
                        <div></div>
                        <a controlTreeID="${teamTypeID==1?'2844':teamTypeID==2?'3844':'4844'}" href="/FlawProcTask/${teamTypeID}/assign/${FlawProcTask_flawProcTaskNum}" style="display: ${(FlawProcTask==1)?"":"none"}"target="ajax" rel="jbsxBox${FlawProcTask_flawProcTaskNum}">2.确定任务</a>
                        <a href="javascript:;" style="display: ${(FlawProcTask==1)?"none":""}">2.确定任务</a>
                    </td>
                    <td ${(FlawProcTask==2)?"class='a-jg'":""}>
                        <div></div>
                        <a controlTreeID="${teamTypeID==1?'2845':teamTypeID==2?'3845':'4845'}" href="/FlawProcTask/${teamTypeID}/append/${FlawProcTask_flawProcTaskNum}" style="display: ${(FlawProcTask==2)?"":"none"}"target="ajax" rel="jbsxBox${FlawProcTask_flawProcTaskNum}">3.录入任务</a>
                        <a href="javascript:;" style="display: ${(FlawProcTask==2)?"none":""}">3.录入任务</a>
                    </td>
                    <td ${(FlawProcTask==3)?"class='a-jg'":""}>
                        <div></div>
                        <a controlTreeID="${teamTypeID==1?'2846':teamTypeID==2?'3846':'4846'}" href="/FlawProcTask/${teamTypeID}/view/${FlawProcTask_flawProcTaskNum}" style="display: ${(FlawProcTask==3)?"":"none"}"target="ajax" rel="jbsxBox${FlawProcTask_flawProcTaskNum}">4.完成任务</a>
                        <a href="javascript:;" style="display: ${(FlawProcTask==3)?"none":""}">4.完成任务</a>

                    </td>
                </tr>
            </table>
        </div>
    </div>
    <div id="jbsxBox${FlawProcTask_flawProcTaskNum}"   defH="90" style="height: 90%;">

    </div>

    <script>
        $(function() {
            var _a = $('#jbsxBox2${FlawProcTask_flawProcTaskNum} tr td:eq(${FlawProcTask}) a');
            removeHrefForTree();
            setTimeout(function(){
                _a.click();
            },500);
            /*var _url = _a.attr('href')
             $('#jbsxBox').load(_url);*/
        });
    </script>
</div>
