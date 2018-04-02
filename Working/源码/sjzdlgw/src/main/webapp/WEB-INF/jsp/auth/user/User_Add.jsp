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
<style>
    .tongdao-table tr {
        height:40px;
    }
</style>
<div id="a_tdtz" class="pageContent" selector="h1" layoutH="5">
    <form method="post" action="${ctxPath}/User/add" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
        <div style="padding-top:10px;height:208px;">
            <input name="addOrEdit" value="${UserPage.addOrEdit}" type="hidden">
            <table class="tongdao-table" style="width:97%;">
                <tr>
                    <td class="table-label">用户编号：</td>
                    <td >
                    <%--<input name="functionType" class="required" type="text" size="30" value="${function.functionType}" />--%>
                    <input name="employeeID" type="text" size="30" value="${UserPage.employeeID}"  class="required" ${UserPage.addOrEdit eq 1?"readonly='true'":""}/>
                    </td>
                    <td class="table-label">登录账号：</td>
                    <td >
                    <%--<input name="functionType" class="required" type="text" size="30" value="${function.functionType}" />--%>
                    <input name="account" type="text" size="30" value="${UserPage.account}"  class="required"/>
                    </td>
                    <td class="table-label">登录密码：</td>
                    <td >
                    <%--<input name="functionType" class="required" type="text" size="30" value="${function.functionType}" />--%>
                    <input name="password" type="text" size="30" value="${UserPage.password}"  class="required"/>
                    </td>
                </tr>
                <tr>
                    <td class="table-label">角色信息：</td>
                    <td>
                        <select class="required combox" name="roleNum">
                            <option value="">请选择</option>
                            <c:forEach var="item" items="${RolesList}">
                                <option value="${item.roleNum}" ${UserPage.roleName eq item.roleName ? 'selected="selected"':''} >${item.roleName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td class="table-label">用户名称：</td>
                    <td >
                        <%--<input name="functionType" class="required" type="text" size="30" value="${function.functionType}" />--%>
                        <input name="userName" type="text" size="30" value="${UserPage.userName}"  />
                    </td>
                    <td class="table-label">电子邮箱：</td>
                    <td >
                        <%--<input name="functionType" class="required" type="text" size="30" value="${function.functionType}" />--%>
                        <input name="email" type="text" size="30" value="${UserPage.email}"  />
                    </td>
                </tr>
                <tr>
                    <td class="table-label">行政级别：</td>
                    <td>
                        <select class="required combox" name="grade">
                            <option value="">请选择</option>
                            <option value="0" ${UserPage.grade eq 0 ? 'selected="selected"':''} >组员</option>
                            <option value="1" ${UserPage.grade eq 1 ? 'selected="selected"':''} >班长</option>
                            <option value="2" ${UserPage.grade eq 2 ? 'selected="selected"':''} >专责</option>
                            <option value="3" ${UserPage.grade eq 3 ? 'selected="selected"':''} >主任</option>
                            <option value="4" ${UserPage.grade eq 4 ? 'selected="selected"':''} >书记</option>
                            <%--<c:forEach var="item" items="${PageModelPowerCableLevelList}">--%>
                                <%--<option value="${item.voltageLevelID}" ${UserPage.voltageLevelID eq item.voltageLevelID ? 'selected="selected"':''} >${item.voltageLevelName}</option>--%>
                            <%--</c:forEach>--%>
                        </select>
                    </td>
                    <td class="table-label">所属部门：</td>
                    <td>
                        <select class="required combox" name="organizationNum">
                            <option value="">请选择</option>
                            <c:forEach var="item" items="${OrganizationsList}">
                                <option value="${item.organizationNum}" ${UserPage.organizationNum eq item.organizationNum ? 'selected="selected"':''} >${item.organizationName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td class="table-label">电话号码：</td>
                    <td >
                        <%--<input name="functionType" class="required" type="text" size="30" value="${function.functionType}" />--%>
                        <input name="mobilePhone" type="text" size="30" value="${UserPage.mobilePhone}"  />
                    </td>
                <tr>
                    <td class="table-label" valign="top">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</td>
                    <td colspan="5">
                        <textarea name="address" cols="80" style="width:100%;height:50px;">${UserPage.address}</textarea>
                    </td>
                </tr>
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



