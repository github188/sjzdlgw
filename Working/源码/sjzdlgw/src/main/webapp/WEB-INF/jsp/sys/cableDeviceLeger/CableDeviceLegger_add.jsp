<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/12
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
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
        width:100%;
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
</style>
<script>
    $(function() {
        $('#sheb_table>div').click(function() {
            if (!$(this).hasClass('selected')) {
                $('#sheb_table>div').removeClass('selected');
                $(this).addClass('selected');
            }
        });
        setTimeout(function(){
            var _w = $('#a_tdtz .textInput:eq(0)').width();
            $('.tongdao-table .combox').width(_w+6);
            $('.tongdao-table .combox a').width(_w-22);
        },500)

    });
    function isSelectNow(obj) {
        if ( obj.length == 0 ) {
            alert('请先选择一个节点');
            return false;
        }
        else {
            return true;
        }
    }
    /*设备终端移动后的回调函数*/
    function sheb_callback(_d) {
        alert(_d);
    }
    /*电缆管信息移动后的回调函数*/
    function dlg_callback(_d) {
        alert(_d);
    }
    function getSortData(_v) {
        var str = '';
        $('#'+_v).children().each(function(i) {
            str += i + ',' + $(this).attr('id') + ':';
        });
        str = str.substring(0,str.length-1);
        if ( _v == 'sheb_table' ) {
            sheb_callback(str);
        }
        else {
            dlg_callback(str);
        }
    }
    function selectUp(_v) {
        var obj = $('#'+_v).find('.selected');
        if ( isSelectNow(obj) ) {
            obj.prev().before(obj);
            getSortData(_v);
        }
    }
    function selectAllUp(_v) {
        var obj = $('#'+_v).find('.selected');
        if ( isSelectNow(obj) ) {
            obj.parent().prepend(obj);
            getSortData(_v);
        }
    }
    function selectDown(_v) {
        var obj = $('#'+_v).find('.selected');
        if ( isSelectNow(obj) ) {
            obj.next().after(obj);
            getSortData(_v);
        }
    }
    function selectAllDown(_v) {
        var obj = $('#'+_v).find('.selected');
        if ( isSelectNow(obj) ) {
            obj.parent().append(obj);
            getSortData(_v);
        }
    }


</script>
<style>
    .tongdao-table tr {
        height:40px;
    }
</style>
<div id="a_tdtz" class="pageContent" selector="h1" layoutH="5">
    <form method="post" action="${ctxPath}/CableDeviceLedger/${pathType}/add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
    <div style="height:299px;">
        <input type="hidden" name="num" value="${PageModelCableDeviceLegger.num}"/>
        <table class="tongdao-table" style="width:97%;margin-top:20px;">
            <tr>

                <td class="table-label">档案编号:</td>
                <td>
                    <input name="ledgerCode" type="text" size="30" value="${PageModelCableDeviceLegger.ledgerCode}"  class="required"/>
                </td>
                <td class="table-label">电压等级:</td>
                <td>
                    <select class="required combox" name="voltageLevelID">
                        <option value="">请选择</option>
                        <c:forEach var="item" items="${PageModelPowerCableLevelList}">
                            <option value="${item.voltageLevelID}" ${PageModelCableDeviceLegger.voltageLevelID eq item.voltageLevelID ? 'selected="selected"':''} >${item.voltageLevelName}</option>
                        </c:forEach>
                    </select>
                </td>

            </tr>
            <tr>
                <td class="table-label">工程名称:</td>
                <td>
                    <input name="ledgerName" type="text" size="30" value="${PageModelCableDeviceLegger.ledgerName}" class="required" />
                </td>
                <td class="table-label">方案编号:</td>
                <td>
                    <input name="projectCode" type="text" size="30" value="${PageModelCableDeviceLegger.projectCode}" class="required" />
                </td>
            </tr>
            <tr>


                <td class="table-label">工程类型:</td>
                <td>
                    <select class="required combox" name="projectTypeID">
                        <option value="">请选择</option>
                        <c:forEach var="item" items="${ProjectTypeList}">
                            <option value="${item.projectTypeID}" ${PageModelCableDeviceLegger.projectTypeID eq item.projectTypeID ? 'selected="selected"':''} >${item.projectTypeName}</option>
                        </c:forEach>
                    </select>
                </td>


                <td class="table-label">施工时间:</td>
                <td>
                    <a class="inputDateButton" href="javascript:;" style="position: absolute;left:100%;margin-left:-10px;">选择</a>
                    <input type="text" name="buildDate" class="date" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${PageModelCableDeviceLegger.buildDate}" type="both"/>" readonly="true"/>
                </td>
            </tr>
            <tr>
                <td class="table-label">竣工时间:</td>
                <td>
                    <a class="inputDateButton" href="javascript:;" style="position: absolute;left:100%;margin-left:-10px;">选择</a>
                    <input type="text" name="accpetDate" class="date" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${PageModelCableDeviceLegger.accpetDate}" type="both"/>" readonly="true"/>
                </td>

                <td class="table-label">档案类型:</td>
                <td>
                    <select class="required combox" name="archivesType">
                        <option value="1">草稿状态</option>
                            <option value="2">规划状态</option>
                       
                    </select>
                </td>
            </tr>
            <tr>
                <td class="table-label" valign="top">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</td>
                <td colspan="3">
                    <textarea name="memo" cols="80" style="width:100%;height:50px;">${PageModelCableDeviceLegger.memo}</textarea>
                </td>
            </tr>
        </table>
    </div>
        <div class="formBar">
            <ul>
                <c:if test="${isDbClick ne 1}">
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit" >保存</button></div></div></li>
                </c:if>
                <li>
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
            <input type="hidden" id="test" value="${isDbClick}">
        </div>
    </form>
</div>

