<%--
  Created by IntelliJ IDEA.
  User: GalaIO
  Date: 2016/11/13
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: GalaIO
  Date: 2016/11/6
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
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
<form method="post" action="${ctxPath}/PathSection/${pathSection.pathSectionNum}/charge/${chargeType}" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
    <div id="a_tdtz" class="pageContent" selector="h1" layoutH="55">
        <div  style="padding-top:10px;height:180px;">
            <table class="tongdao-table"  style="width:97%;">
                <tbody>
                <tr>
                    <td class="table-label" style="width: 80px">${chargeType eq "outage"?"停运线路段：":chargeType eq "returned"?"退运线路段：":"启用线路段："}</td>
                    <td  style="width: 150px" >
                        <input  name="pathSectionName" type="text" size="50" value="${pathSection.pathSectionName}" class="required textInput" disabled="disabled">
                    </td>
                    <td class="table-label" style="width: 80px">${chargeType eq "outage"?"停运日期：":chargeType eq "returned"?"退运日期：":"启用日期："}</td>
                    <td style="width: 150px">
                        <input name="date" type="required text" class="date" size="30" /><a class="inputDateButton" href="javascript:;" style="margin-top: -21px; margin-left: 156px;">选择</a>
                    </td>
                </tr>
                <tr>
                    <td class="table-label">${chargeType eq "outage"?"停运原因：":chargeType eq "returned"?"退运原因：":"启用原因："}</td>
                    <td colspan="4">
                        <textarea cols="60" name="reason" rows="4" style="width:85%;" class="required textInput"></textarea>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <%--</div>--%>
    </div>
    <div class="formBar">
        <ul>
            <li><div class="buttonActive"><div class="buttonContent"><button type="submit">${chargeType eq "outage"?"停运":chargeType eq "returned"?"退运":"启用"}</button></div></div></li>
            <li>
                <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
            </li>
        </ul>
    </div>
</form>