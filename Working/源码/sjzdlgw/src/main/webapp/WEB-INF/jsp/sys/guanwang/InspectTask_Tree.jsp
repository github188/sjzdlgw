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
        <div class="searchBar" style="border-bottom:1px solid #B5B5B5;padding-bottom:30px;margin-left:4px;margin-right:4px; height:71px;">
            <table id="jbsx_table1${InspectTask_taskNum}" class="a-jd">
                <tr>
                    <td ${(InspectTask==null)?"class='a-jg'":""}>
                        <a controlTreeID="${teamTypeID==1?'2823':teamTypeID==2?'3828':'4823'}" href="/InspectTask/${teamTypeID}/add/${InspectTask_taskNum}?type=1" style="display: ${(InspectTask==null)?"":"none"}" target="ajax" rel="jbsxBox1${InspectTask_taskNum}">1.发起任务</a>
                        <a href="javascript:;" style="display: ${(InspectTask==null)?"none":""}">1.发起任务</a>
                    </td>
                    <td ${(InspectTask==1)?"class='a-jg'":""}>
                        <div></div>
                        <a controlTreeID="${teamTypeID==1?'2824':teamTypeID==2?'3824':'4824'}" href="/InspectTask/${teamTypeID}/assign/${InspectTask_taskNum}" style="display: ${(InspectTask==1)?"":"none"}"target="ajax" rel="jbsxBox1${InspectTask_taskNum}">2.确定任务</a>
                        <a href="javascript:;" style="display: ${(InspectTask==1)?"none":""}">2.确定任务</a>
                    </td>
                    <td ${(InspectTask==2)?"class='a-jg'":""}>
                        <div></div>
                        <a controlTreeID="${teamTypeID==1?'2825':teamTypeID==2?'3825':'4825'}" href="/InspectTask/${teamTypeID}/append/${InspectTask_taskNum}" style="display: ${(InspectTask==2)?"":"none"}"target="ajax" rel="jbsxBox1${InspectTask_taskNum}">3.录入任务</a>
                        <a href="javascript:;" style="display: ${(InspectTask==2)?"none":""}">3.录入任务</a>
                    </td>
                    <td ${(InspectTask==3)?"class='a-jg'":""}>
                        <div></div>
                        <a controlTreeID="${teamTypeID==1?'2826':teamTypeID==2?'3826':'4826'}" href="/InspectTask/${teamTypeID}/view/${InspectTask_taskNum}" style="display: ${(InspectTask==3)?"":"none"}"target="ajax" rel="jbsxBox1${InspectTask_taskNum}">4.完成任务</a>
                        <a href="javascript:;" style="display: ${(InspectTask==3)?"none":""}">4.完成任务</a>

                    </td>
                </tr>
                <%--<tr>--%>
                    <%--<td ${(InspectTask==null||InspectTask==1||InspectTask==2||InspectTask==3)?"class='a-jg'":""}>--%>
                        <%--<a href="/InspectTask/${teamTypeID}/add/${InspectTask_taskNum}?type=1" style="display: ${(InspectTask==null||InspectTask==1||InspectTask==2||InspectTask==3)?"":"none"}" target="ajax" rel="jbsxBox1">1.发起任务</a>--%>
                        <%--<a href="javascript:;" style="display: ${(InspectTask==null||InspectTask==1||InspectTask==2||InspectTask==3)?"none":""}">1.发起任务</a>--%>
                    <%--</td>--%>
                    <%--<td ${(InspectTask==1||InspectTask==2||InspectTask==3)?"class='a-jg'":""}>--%>
                        <%--<div></div>--%>
                        <%--<a href="/InspectTask/${teamTypeID}/assign/${InspectTask_taskNum}" style="display: ${(InspectTask==1||InspectTask==2||InspectTask==3)?"":"none"}"target="ajax" rel="jbsxBox1">2.确定任务</a>--%>
                        <%--<a href="javascript:;" style="display: ${(InspectTask==1||InspectTask==2||InspectTask==3)?"none":""}">2.确定任务</a>--%>
                    <%--</td>--%>
                    <%--<td ${(InspectTask==2||InspectTask==3)?"class='a-jg'":""}>--%>
                        <%--<div></div>--%>
                        <%--<a href="/InspectTask/${teamTypeID}/append/${InspectTask_taskNum}" style="display: ${(InspectTask==2||InspectTask==3)?"":"none"}"target="ajax" rel="jbsxBox1">3.录入任务</a>--%>
                        <%--<a href="javascript:;" style="display: ${(InspectTask==2||InspectTask==3)?"none":""}">3.录入任务</a>--%>
                    <%--</td>--%>
                    <%--<td ${(InspectTask==3)?"class='a-jg'":""}>--%>
                        <%--<div></div>--%>
                        <%--<a href="/InspectTask/${teamTypeID}/view/${InspectTask_taskNum}" style="display: ${(InspectTask==3)?"":"none"}"target="ajax" rel="jbsxBox1">4.完成任务</a>--%>
                        <%--<a href="javascript:;" style="display: ${(InspectTask==3)?"none":""}">4.完成任务</a>--%>

                    <%--</td>--%>
                <%--</tr>--%>
            </table>
        </div>
    </div>
    <div id="jbsxBox1${InspectTask_taskNum}"   defH="90" style="height: 90%;">

    </div>
    <script>
        $(function() {
            var _a = $('#jbsx_table1${InspectTask_taskNum} tr td:eq(${InspectTask}) a');
            removeHrefForTree();
            setTimeout(function(){
                _a.click();
            },500);
            /*var _url = _a.attr('href')
             $('#jbsxBox').load(_url);*/
        });
    </script>
</div>
