<%--
  Created by IntelliJ IDEA.
  User: hy
  Date: 2016/10/21
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<style>
    .tongdao-table, .sheb-table {
        table-layout: fixed;
        width: 99%;
    }

    .table-label {
        width: 70px;
        padding-right: 10px;
        text-align: right;
    }

    .tongdao-table td {
        padding-bottom: 10px;
        position: relative;
    }

    .tongdao-table td span {
        position: absolute;
        left: 100%;
        margin-left: -18px;
        margin-top: 4px;
    }

    .tongdao-table input {
        width: 100%;
    }

    .fang-table div {
        padding: 5px;
        font-size: 14px;
        cursor: default;
    }

    .fang-table div:hover {
        background: #E4F5FF;
    }

    .fang-table div.selected {
        background-color: #7cc5e5;
    }
</style>
<script>
    $(function () {
        $('#sheb_table>div').click(function () {
            if (!$(this).hasClass('selected')) {
                $('#sheb_table>div').removeClass('selected');
                $(this).addClass('selected');
            }
        });
        setTimeout(function () {
            var _w = $('#a_tdtz .textInput:eq(0)').width();
            $('.tongdao-table .combox').width(_w + 6);
            $('.tongdao-table .combox a').width(_w - 22);
        }, 500)

    });
    function isSelectNow(obj) {
        if (obj.length == 0) {
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
        $('#' + _v).children().each(function (i) {
            str += i + ',' + $(this).attr('id') + ':';
        });
        str = str.substring(0, str.length - 1);
        if (_v == 'sheb_table') {
            sheb_callback(str);
        }
        else {
            dlg_callback(str);
        }
    }
    function selectUp(_v) {
        var obj = $('#' + _v).find('.selected');
        if (isSelectNow(obj)) {
            obj.prev().before(obj);
            getSortData(_v);
        }
    }
    function selectAllUp(_v) {
        var obj = $('#' + _v).find('.selected');
        if (isSelectNow(obj)) {
            obj.parent().prepend(obj);
            getSortData(_v);
        }
    }
    function selectDown(_v) {
        var obj = $('#' + _v).find('.selected');
        if (isSelectNow(obj)) {
            obj.next().after(obj);
            getSortData(_v);
        }
    }
    function selectAllDown(_v) {
        var obj = $('#' + _v).find('.selected');
        if (isSelectNow(obj)) {
            obj.parent().append(obj);
            getSortData(_v);
        }
    }

</script>
<style>
    .tongdao-table tr {
        height:40px;
    }
    .tongdao-table td {
        padding:8px 0;
    }
    .tongdao-table input,.tongdao-table select{
        width:220px;
        height:21px;
        box-sizing:border-box;
    }
    .tongdao-table textarea{
        width:220%;
    }
</style>
<div id="a_tdtz" class="pageContent" selector="h1" layoutH="5">
    <form method="post" action="${ctxPath}/CableAttachment/EarthBox/add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div style="padding-top:10px;height:359px;">
            <input type="hidden" name="attachmentNum" value="${CableAttachmentPage.attachmentNum}"/>
            <table class="tongdao-table">
                <tr>
                    <td class="table-label">档案编号：</td>
                    <td>
                        <select class="required" name="num">
                            <option value="">请选择档案编号</option>
                            <c:forEach var="item" items="${PageModelNumList}">
                                <option value="${item.num}" ${CableAttachmentPage.num eq item.num ? 'selected="selected"':''} >${item.ledgerCode}</option>
                            </c:forEach>
                        </select>
                    </td>

                    <td class="table-label">资产编码：</td>
                    <td>
                        <input name="assetCode" type="text" size="20" value="${CableAttachmentPage.assetCode}"
                               class="required"/>
                    </td>
                </tr>
                <tr>
                    <td class="table-label">型　　号：</td>
                    <td>
                        <select class="required" name="modelTypeNum">
                            <option value="">请选择型号</option>
                            <c:forEach var="item" items="${PageModelTypeNumList}">
                                <option value="${item.modelTypeNum}" ${CableAttachmentPage.modelTypeName eq item.modelTypeName ? 'selected="selected"':''} >${item.modelTypeName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td class="table-label">生产厂家：</td>
                    <td>
                        <select class="required" name="companyNum">
                            <option value="">请选择生产厂家</option>
                            <c:forEach var="item" items="${PageCompanyList}">
                                <option value="${item.companyNum}" ${CableAttachmentPage.companyName eq item.companyName ? 'selected="selected"':''} >${item.companyName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="table-label">投运时间：</td>
                    <td>
                        <input name="installDateString" type="text" alt=""
                               value="${CableAttachmentPage.installDateString}" class="date required input-icon" size="20"/>
                        <a class="inputDateButton" href="javascript:;"
                           style="position: absolute;left:90%;margin-top:-21px;">选择</a>
                    </td>
                    <td class="table-label">经　　度：</td>
                    <td>
                        <input class="required" name="lon" type="text" size="30" value="${CableAttachmentPage.lon}"/>
                    </td>
                </tr>
                <tr>
                    <%--<td class="table-label">经度：</td>--%>
                    <%--<td>--%>
                        <%--<input class="required" name="lon" type="text" size="30" value="${CableAttachmentPage.lon}"/>--%>
                    <%--</td>--%>                         　
                    <td class="table-label">纬　　度：</td>
                    <td>
                        <input class="required" name="lat" type="text" size="30" value="${CableAttachmentPage.lat}"/>
                    </td>
                </tr>
                <tr>
                    <td class="table-label" valign="top">安装位置：</td>
                    <td>
                        <textarea name="place" cols="160"
                                  style="width:222%;height:50px;">${CableAttachmentPage.place}</textarea>
                    </td>
                </tr>
                <tr>
                    <td class="table-label" valign="top">备　　注：</td>
                    <td>
                        <textarea name="memo" cols="160"
                                  style="width:222%;height:50px;">${CableAttachmentPage.memo}</textarea>
                    </td>
                </tr>
            </table>
        </div>
        <div class="formBar">
            <ul>
                <c:if test="${isDbClick ne 1}">
                    <li>
                        <div class="buttonActive">
                            <div class="buttonContent">
                                <button type="submit">保存</button>
                            </div>
                        </div>
                    </li>
                </c:if>
                <li>       <input type="hidden" id="test" value="${isDbClick}">
                    <div class="button">
                        <div class="buttonContent">
                            <button type="button" class="close">取消</button>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </form>
</div>
