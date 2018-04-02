<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 2016/10/20
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%--<style type="text/css">--%>
    <%--select{width:213px;}--%>
<%--</style>--%>
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
    <form method="post" action="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">

            <div style="padding-top:10px;height:359px;">
                <input type="hidden" name="attachmentNum" value="${CableAttachmentPage.attachmentNum}"/>
                <table class="tongdao-table" style="width:97%;">

                    <tr>
                        <td class="table-label" style="width:80px;">档案编号:</td>
                        <td>
                            <select class="required combox" name="num">
                                <option value="">请选择</option>
                                <c:forEach var="item" items="${PageModelNumList}">
                                    <option value="${item.num}" ${CableAttachmentPage.num eq item.num ? 'selected="selected"':''} >${item.ledgerCode}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td class="table-label" style="width:80px;">资产编码:</td>
                        <td>
                            <input name="assetCode" type="text" size="30" value="${CableAttachmentPage.assetCode}"  class="required" />
                        </td>
                        <td class="table-label">型号:</td>
                        <td>
                            <select class="required combox" name="modelTypeNum">
                                <option value="">请选择</option>
                                <c:forEach var="item" items="${PageModelTypeNumList}">
                                    <option value="${item.modelTypeNum}" ${CableAttachmentPage.modelTypeName eq item.modelTypeName ? 'selected="selected"':''} >${item.modelTypeName}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <c:if test="${attachmentTypeName eq 'section'}">
                            <td class="table-label">导体材质:</td>
                        </c:if>
                        <c:if test="${attachmentTypeName ne 'section'}">
                            <td class="table-label">类型:</td>
                        </c:if>
                        <td>
                            <select class="required combox" name="cableDeviceStyleID">
                                <option value="">请选择</option>
                                <c:forEach var="item" items="${PageCableDeviceStyleIDList}">
                                    <option value="${item.cableDeviceStyleID}" ${CableAttachmentPage.cableDeviceStyleName eq item.cableDeviceStyleName ? 'selected="selected"':''} >${item.cableDeviceStyleName}</option>
                                </c:forEach>
                            </select>
                        </td>

                        <td class="table-label">生产厂家:</td>
                        <td>
                            <select class="required combox" name="companyNum" >
                                <option value="">请选择</option>
                                <c:forEach var="item" items="${PageCompanyList}">
                                    <option value="${item.companyNum}" ${CableAttachmentPage.companyName eq item.companyName ? 'selected="selected"':''} >${item.companyName}</option>
                                </c:forEach>
                            </select>
                        </td>


                        <td class="table-label">投运时间:</td>
                        <td>
                            <a class="inputDateButton" href="javascript:;" style="position: absolute;left:100%;margin-left:-10px;">选择</a>
                            <input type="text" name="installDateString" class="date" value="${CableAttachmentPage.installDateString}" readonly="true"/>
                        </td>
                    </tr>
                    <c:if test="${attachmentTypeName ne 'section'}">
                        <tr>
                            <td class="table-label">是否在线监测:</td>
                            <td>
                                <select class="required combox" name="isMonitor">
                                    <option value="">请选择</option>
                                    <option value=0 ${CableAttachmentPage.isMonitor eq 0 ?'selected="selected"':''} >否</option>
                                    <option value=1 ${CableAttachmentPage.isMonitor eq 1 ? 'selected="selected"':''} >是</option>
                                </select>
                            </td>

                            <td class="table-label">经度:</td>
                            <td>
                                <input class="required number" name="lon" type="text" size="30" value="${CableAttachmentPage.lon}"  />
                            </td>
                            <td class="table-label">纬度:</td>
                            <td>
                                <input class="required number" name="lat" type="text" size="30" value="${CableAttachmentPage.lat}" />
                            </td>
                        </tr>
                    </c:if>
                    <c:if test="${attachmentTypeName eq 'section'}">
                        <tr>
                            <td class="table-label">绝缘种类:</td>
                            <td>
                                <select class="required combox" name="cableDeviceTypeID">
                                    <option value="">请选择-</option>
                                    <c:forEach var="item" items="${PageCableDeviceTypeList}">
                                        <option value="${item.cableDeviceTypeID}" ${CableAttachmentPage.cableDeviceTypeName eq item.cableDeviceTypeName ? 'selected="selected"':''} >${item.cableDeviceTypeName}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td class="table-label">长度:</td>
                            <td>
                                <input name="length" type="text" size="30" value="${CableAttachmentPage.lengthDouble}"  class="number required" />
                            </td>
                            <td class="table-label">载流量:</td>
                            <td>
                                <input name="currentCapacity" type="text" size="30" value="${CableAttachmentPage.currentCapacityDouble}" class="number required" />
                            </td>
                        </tr>
                    </c:if>

                    <c:if test="${attachmentTypeName ne 'section'}">
                        <tr>
                            <td class="table-label">安装位置:</td>
                            <%--<textarea name="place" cols="88" rows="1">${CableAttachmentPage.place}</textarea>--%>
                            <td colspan="5">
                                <input name="place" class="textInput" type="text" value="${CableAttachmentPage.place}">
                            </td>
                        </tr>
                    </c:if>

                        <c:if test="${attachmentTypeName eq 'terminal'}" >
                            <tr>
                            <c:if test="${pathType eq 'distribution'}">
                                <td class="table-label">连接方式:</td>
                                <td>
                                    <select class="required combox" name="cableDeviceTypeID">
                                        <option value="">请选择</option>
                                        <c:forEach var="item" items="${PageCableDeviceTypeList}">
                                            <option value="${item.cableDeviceTypeID}" ${CableAttachmentPage.cableDeviceTypeName eq item.cableDeviceTypeName ? 'selected="selected"':''} >${item.cableDeviceTypeName}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </c:if>
                            <td class="table-label">故障指示器:</td>
                            <td>
                                <select class="required combox" name="faultIndicatorTypeID">
                                    <option value="">请选择</option>
                                    <c:forEach var="item" items="${PageFaultIndicatorTypeIDList}">
                                        <option value="${item.faultIndicatorTypeID}" ${CableAttachmentPage.faultIndicatorTypeName eq item.faultIndicatorTypeName ? 'selected="selected"':''} >${item.faultIndicatorTypeName}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            </tr>
                        </c:if>

                        <c:if test="${attachmentTypeName eq 'connector'}">
                            <tr>
                            <c:if test="${pathType eq 'transmission'}">
                                <td class="table-label">接头类型:</td>
                                <td>
                                    <select class="required combox" name="cableDeviceTypeID">
                                        <option value="">请选择</option>
                                        <c:forEach var="item" items="${PageCableDeviceTypeList}">
                                            <option value="${item.cableDeviceTypeID}" ${CableAttachmentPage.cableDeviceTypeName eq item.cableDeviceTypeName ? 'selected="selected"':''} >${item.cableDeviceTypeName}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </c:if>
                            <td class="table-label">防爆盒类型:</td>
                            <td>
                                <select class="required combox" name="safeBoxTypeID">
                                    <option value="">请选择</option>
                                    <c:forEach var="item" items="${PageSafeBoxTypeList}">
                                        <option value="${item.safeBoxTypeID}" ${CableAttachmentPage.safeBoxTypeName eq item.safeBoxTypeName ? 'selected="selected"':''} >${item.safeBoxTypeName}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            </tr>
                        </c:if>


                    <c:if test="${attachmentTypeName eq 'section'}">
                        <tr>
                        <td class="table-label" valign="top">起&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点:</td>
                        <td colspan="5">
                            <textarea name="beginPlace" cols="80" style="width:100%;height:50px;">${CableAttachmentPage.beginPlace}</textarea>
                        </td>
                        </tr>
                        <tr>
                            <td class="table-label" valign="top">终&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点:</td>
                            <td colspan="5">
                                <textarea name="endPlace" cols="80" style="width:100%;height:50px;">${CableAttachmentPage.endPlace}</textarea>
                            </td>
                        </tr>
                    </c:if>
                    <tr>
                        <td class="table-label" valign="top">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</td>
                        <td colspan="5">
                            <textarea name="memo" cols="80" style="width:100%;height:50px;">${CableAttachmentPage.memo}</textarea>
                        </td>
                    </tr>
                </table>
        </div>
        <div class="formBar">
            <ul>
                <c:if test="${isDbClick ne 1}">
                    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
                </c:if>
                <li>
                    <input type="hidden" id="test" value="${isDbClick}">
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div>
    </form>
</div>