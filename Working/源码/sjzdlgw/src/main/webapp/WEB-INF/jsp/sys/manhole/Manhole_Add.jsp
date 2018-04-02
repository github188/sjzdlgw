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
<div id="a_tdtz" class="pageContent" selector="h1" layoutH="5">
    <form method="post" action="${ctxPath}/Manhole/add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div style="padding-top:10px;">
            <input type="hidden" name="assetNum" value="${PageModelManhole.assetNum}"/>
            <table class="tongdao-table" style="width:90%;">
                <tr>
                    <td class="table-label">终端名称:</td>
                    <td>
                        <input name="assetName" type="text" size="30" value="${PageModelManhole.assetName}"
                               alt="请输入终端名称" class="required"/>
                    </td>
                    <td class="table-label">资产编码:</td>
                    <td>
                        <input name="assetCode" type="text" size="30" value="${PageModelManhole.assetCode}"
                               alt="请输入资产编码" class="required"/>
                    </td>

                    <td class="table-label">设备类型:</td>
                    <td>
                        <select class="required"
                                name="manholeKindTypeID" ${PageModelManhole.manholeKindTypeID!=null ? 'disabled="true"':''}>
                            <option value="">请选择设备类型</option>
                            <c:forEach var="item" items="${PageModelManholeKindTypeList}">
                                <option value="${item.manholeKindTypeID}" ${PageModelManhole.manholeKindTypeID eq item.manholeKindTypeID ? 'selected="selected"':''} >${item.manholeKindTypeName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="table-label">经度:</td>
                    <td>
                        <input name="longitude" type="text" size="30" value="${PageModelManhole.longitude}" alt="请输入经度"
                               class="required"/>
                    </td>
                    <td class="table-label">维度:</td>
                    <td>
                        <input name="latitude" type="text" size="30" value="${PageModelManhole.latitude}" alt="请输入维度"
                               class="required"/>
                    </td>
                </tr>

                <tr>
                    <td class="table-label">位置描述:</td>
                    <td colspan="5">
                        <textarea name="positionDescription" cols="88"
                                  rows="3">${PageModelManhole.positionDescription}</textarea>
                    </td>
                </tr>
                <tr>
                    <td class="table-label">备注:</td>
                    <td colspan="5">
                        <textarea name="memo" cols="88" rows="3">${PageModelManhole.memo}</textarea>
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
                <li>
                    <input type="hidden" id="test" value="${isDbClick}">
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

