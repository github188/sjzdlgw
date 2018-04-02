<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>

<%--<form id="pagerForm" method="post" action="demo_page1.html">--%>
    <%--<input type="hidden" name="status" value="${param.status}">--%>
    <%--<input type="hidden" name="keywords" value="${param.keywords}" />--%>
    <%--<input type="hidden" name="pageNum" value="1" />--%>
    <%--<input type="hidden" name="numPerPage" value="${model.numPerPage}" />--%>
    <%--<input type="hidden" name="orderField" value="${param.orderField}" />--%>
<%--</form>--%>

<%--<div class="pageHeader">--%>
    <%--<form onsubmit="return navTabSearch(this);" action="demo_page1.html" method="post">--%>
        <%--<div class="searchBar">--%>
            <%--<table class="searchContent">--%>
                <%--<tr>--%>
                    <%--<td>--%>
                        <%--我的客户：<input type="text" name="keyword" />--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--<select class="combox" name="province">--%>
                            <%--<option value="">所有省市</option>--%>
                            <%--<option value="北京">北京</option>--%>
                            <%--<option value="上海">上海</option>--%>
                            <%--<option value="天津">天津</option>--%>
                            <%--<option value="重庆">重庆</option>--%>
                            <%--<option value="广东">广东</option>--%>
                        <%--</select>--%>
                    <%--</td>--%>
                    <%--<td>--%>
                        <%--建档日期：<input type="text" class="date" readonly="true" />--%>
                    <%--</td>--%>
                <%--</tr>--%>
            <%--</table>--%>
            <%--<div class="subBar">--%>
                <%--<ul>--%>
                    <%--<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>--%>
                    <%--<li><a class="button" href="demo_page6.html" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</form>--%>
<%--</div>--%>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" postType="string" href="demo/common/ajaxDone.html" class="delete" style="float:left"><span>批量删除逗号分隔</span></a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="100">
        <thead>
            <tr>
                <th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
                <th width="100">文件类型</th>
                <th width="200">文件名称</th>
                <th width="300">文件路径</th>
                <th width="80">上传人员</th>
                <th width="80">上传时间</th>
            </tr>
        </thead>
        <tbody>
            <tr target="sid_user" rel="1">
                <td><input name="ids" value="xxx" type="checkbox"></td>
                <td>天津农信社</td>
                <td>A120113196309052434</td>
                <td>天津市华建装饰工程有限公司</td>
                <td>政府机构</td>
                <td>2009-05-21</td>
            </tr>
        </tbody>
    </table>
    <div class="panelBar">
        <form method="post" action="demo/common/ajaxDone.html" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this);">
            <div class="pageFormContent" layoutH="56">
                <p>
                    <label>文件类型：</label>
                    <input name="taskName" class="required" type="text" size="30"/>
                </p>
                <p>
                    <label>文件名称：</label>
                    <input name="taskName" class="required" type="text" size="50"/>
                </p>
                <p>
                    <label>文件路径：</label>
                    <input name="taskName" class="required" type="text" size="50"/>
                    <input type="file" name="file">
                </p>
            </div>
            <div class="formBar">
                <ul>
                    <li><div class="button"><div class="buttonContent"><button type="button" class="checkboxCtrl" group="c1" selectType="invert">反选</button></div></div></li>
                    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
                </ul>
            </div>
        </form>
    </div>
</div>


