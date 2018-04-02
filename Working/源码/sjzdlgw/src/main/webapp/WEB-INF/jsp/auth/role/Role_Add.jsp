<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div id="a_tdtz" class="pageContent" selector="h1" layoutH="5">
    <form method="post" action="${ctxPath}/Role/add" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
        <div style="padding-top:10px;height:109px;">
            <input type="hidden" name="roleNum" value="${role.roleNum}"/>
            <table class="tongdao-table" style="width:90%;">
                <tr>
                    <td class="table-label">角色名称：</td>
                    <td colspan="5"><input name="roleName" class="required" type="text" size="30" alt="请输角色名称" value="${role.roleName}" />
                    </td>
                </tr>
                <tr>
                    <td class="table-label">描述：</td>
                    <td colspan="5">
                        <input name="comments" type="text" size="30" value="${role.comments}" alt="请输入功能描述"/>
                    </td>
                </tr>
            </table>
        </div>

        <div class="formBar">
            <ul>
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
                <li>
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div>
    </form>
</div>


<%--<div class="pageContent">--%>
    <%--<form method="post" action="${ctxPath}/Role/add" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">--%>
        <%--<input type="hidden" name="roleNum" value="${role.roleNum}"/>--%>
        <%--<div class="pageFormContent" layoutH="56">--%>
             <%--<p>--%>
                <%--<label>角色名称：</label>--%>
                <%--<input name="roleName" class="required" type="text" size="30" alt="请输角色名称" value="${role.roleName}" />--%>
            <%--</p>--%>
            <%--<p>--%>
                <%--<label>描述：</label>--%>
                <%--<input name="comments" type="text" size="30" value="${role.comments}" alt="请输入功能描述"/>--%>
            <%--</p>--%>
        <%--</div>--%>
        <%--<div class="formBar">--%>
            <%--<ul>--%>
                <%--<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>--%>
                <%--<li>--%>
                    <%--<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>--%>
                <%--</li>--%>
            <%--</ul>--%>
        <%--</div>--%>
    <%--</form>--%>
<%--</div>--%>



