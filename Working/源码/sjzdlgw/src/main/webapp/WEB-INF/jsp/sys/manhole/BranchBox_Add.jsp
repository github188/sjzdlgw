<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 2016/10/20
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
        padding-right: 10px;
        text-align: right;
    }

    .tongdao-table td {
        width:100px;
        padding:5px 10px;
        position: relative;
    }

    .tongdao-table .fjx{
        width:212px;
    }

    .tongdao-table .fjx-checkbox input{
        width:15px;
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
    .fengjx input,.fengjx select{
        width:206px;
        height:21px;
        box-sizing:border-box;
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
<div id="a_tdtz" class="pageContent" selector="h1" layoutH="55">
    <form method="post" action="${ctxPath}/BranchBox/add" class="pageForm required-validate fengjx" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" name="assetNum" value="${PageModelBranchBox.assetNum}"/>
        <div style="padding-top:30px;">
            <input type="hidden" name="branchBoxNum" value="${PageModelBranchBox.branchBoxNum}"/>
            <table class="tongdao-table">
                <tr>
                    <td class="table-label">分接箱名称:</td>
                    <td class="fjx">
                        <input name="assetName" type="text" size="30" value="${PageModelBranchBox.assetName}"
                               alt="请输入分接箱名称" class="required"/>
                    </td>
                    <td class="table-label">分接箱编号:</td>
                    <td class="fjx">
                        <input name="operationCode" type="text" size="30" value="${PageModelBranchBox.operationCode}"
                               alt="请输入分接箱编号" class="required"/>
                    </td>
                </tr>
                <tr>
                    <td class="table-label">变电站:</td>
                    <td class="fjx">
                        <select class="required" name="baseFacilityNum">
                            <option value="">请选择变电站</option>
                            <c:forEach var="item" items="${PageModelBaseFacilityList}">
                                <option value="${item.baseFacilityNum}" ${PageModelBranchBox.baseFacilityNum eq item.baseFacilityNum ? 'selected="selected"':''} >${item.baseFacilityName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td class="table-label">资产编码:</td>
                    <td class="fjx">
                        <input name="assetCode" type="text" size="30" value="${PageModelBranchBox.assetCode}"
                               alt="请输入资产编码" class="required"/>
                    </td>
                </tr>
                <tr>
                    <td class="table-label">分接箱规格:</td>
                    <td class="fjx">
                        <select class="required" name="modelNum">
                            <option value="">请选择分接箱规格</option>
                            <c:forEach var="item" items="${PageModelBranchBoxModelList}">
                                <option value="${item.modelNum}" ${PageModelBranchBox.modelNum eq item.modelNum ? 'selected="selected"':''} >${item.modelName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td class="table-label">电压等级:</td>
                    <td class="fjx">
                        <select class="required" name="voltageLevelID">
                            <option value="">请选择电压等级</option>
                            <c:forEach var="item" items="${PageModelPowerCableLevelList}">
                                <option value="${item.voltageLevelID}" ${PageModelBranchBox.voltageLevelID eq item.voltageLevelID ? 'selected="selected"':''} >${item.voltageLevelName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="table-label">投运日期:</td>
                    <td class="fjx">
                        <input type="text" name="runDate" class="date" readonly="true"
                               value="${PageModelBranchBox.runDateStr}"/>
                        <a class="inputDateButton" href="javascript:;"
                           style="position: absolute;left:91%;margin-left:-10px;margin-top:-21px;">选择</a>
                    </td>
                    <td class="table-label">生产厂家:</td>
                    <td class="fjx">
                        <select class="required" name="bulidCompanyNum">
                            <option value="">请选择生产厂家</option>
                            <c:forEach var="item" items="${PageModelCompanyList}">
                                <option value="${item.companyNum}" ${PageModelBranchBox.bulidCompanyNum eq item.companyNum ? 'selected="selected"':''} >${item.companyName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="table-label">负荷开关:</td>
                    <td class="fjx-checkbox">
                        <input type="checkbox" name="isLoadSwitch"
                               value="1" ${PageModelBranchBox.isLoadSwitch==1?'checked="true"':''}/>
                    </td>
                    <td class="table-label">闭锁装置:</td>
                    <td class="fjx-checkbox">
                        <input type="checkbox" name="isLockDevice"
                               value="1" ${PageModelBranchBox.isLockDevice==1?'checked="true"':''}/>
                    </td>
                </tr>
                <tr>
                    <td class="table-label">T型接头:</td>
                    <td class="fjx-checkbox">
                        <input type="checkbox" name="isOnMonitor"
                               value="1" ${PageModelBranchBox.isOnMonitor==1?'checked="true"':''}/>
                    </td>
                    <td class="table-label">肘型接头:</td>
                    <td class="fjx-checkbox">
                        <input type="checkbox" name="isDrop"
                               value="1" ${PageModelBranchBox.isDrop==1?'checked="true"':''}/>
                    </td>
                </tr>
                <tr>
                    <td class="table-label">经　　度:</td>
                    <td class="fjx">
                        <input name="longitude" type="text" size="30" value="${PageModelBranchBox.longitude}"
                               alt="请输入经度" class="required"/>
                    </td>
                    <td class="table-label">维度:</td>
                    <td class="fjx">
                        <input name="latitude" type="text" size="30" value="${PageModelBranchBox.latitude}" alt="请输入维度"
                               class="required"/>

                    </td>
                </tr>

                <tr>
                    <td class="table-label">位置描述:</td>
                    <td colspan="5">
                        <textarea name="positionDescription" cols="88"
                                  rows="3">${PageModelBranchBox.positionDescription}</textarea>
                    </td>
                </tr>
                <tr>
                    <td class="table-label">备注:</td>
                    <td colspan="5">
                        <textarea name="memo" cols="88" rows="3">${PageModelBranchBox.memo}</textarea>
                    </td>
                </tr>

            </table>
        </div>
        <div class="formBar" style="margin-top: 56px;">
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
                <input type="hidden" id="test" value="${isDbClick}">
                <li>
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