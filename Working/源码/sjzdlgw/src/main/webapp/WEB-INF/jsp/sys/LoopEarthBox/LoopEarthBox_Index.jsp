<%--
  Created by IntelliJ IDEA.
  User: GalaIO
  Date: 2016/11/18
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="idNum" value="${loopNum}" />
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>
<style>
    .a-searchBar {
        width:100%;
        overflow: hidden;
    }
    .a-searchBar li {
        width:300px;
        height:30px;
        float:left;
    }
    select{width:213px;}
</style>
<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/LoopEarthBox/1/index" method="post">
    <input type="hidden" name="idNum" value="${loopNum}" />
    <input type="hidden" name="pathType" value="${pathType}" />
    <%--<ul class="a-searchBar">--%>
    <%--&lt;%&ndash;<li style="width: 320px;">&ndash;%&gt;--%>
    <%--&lt;%&ndash;档案编号：<input type="text" name="assetCode" value="" minlength="1" maxlength="15" size="30"/>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
    <%--<li>--%>
    <%--<label>设备类型：</label>--%>
    <%--<select class="required" name="attachmentTypeID" with="100">--%>
    <%--<option value="">请选择</option>--%>
    <%--<option value="2">接头</option>--%>
    <%--<option value="3">终端</option>--%>
    <%--<option value="1">本体</option>--%>
    <%--</select>--%>

    <%--</li>--%>
    <%--<li>--%>
    <%--<div class="buttonActive" style="margin-right:5px; margin-left: 10px">--%>
    <%--<div class="buttonContent">--%>
    <%--<button type="submit">查询</button>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<div class="buttonActive"><div class="buttonContent"><button type="reset">重置</button></div></div>--%>
    <%--</li>--%>
    <%--</ul>--%>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <c:if test="${pageForm.totalCount <= 0}">
            <li controlID="${pathType==1?'3042':'4042'}"><a class="add" href="${ctxPath}/LoopEarthBox/1/edit/add/-1?loopNum=${loopNum}&pathType=${pathType}" title="添加接地箱" target="dialog" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="760" height="350"><span>添加</span></a></li>
            <li controlID="${pathType==1?'3042':'4042'}" class="line">line</li>
            </c:if>
            <li controlID="${pathType==1?'3042':'4042'}"><a class="edit" href="${ctxPath}/LoopEarthBox/1/edit/modify/{sid_loopBoxNum}?loopNum=${loopNum}&pathType=${pathType}" target="dialog" rel="AttachmentOfCable_Index_01" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="760" height="350"><span>修改</span></a></li>
            <li controlID="${pathType==1?'3042':'4042'}" class="line">line</li>
            <li controlID="${pathType==1?'3043':'4043'}"><a class="delete" href="${ctxPath}/LoopEarthBox/1/delete/{sid_loopBoxNum}" target="ajaxTodo" rel="AttachmentOfCable_Index_03" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <%--<li class="line">line</li>--%>
            <%--<li><a class="icon" href="${ctxPath}/AttachmentOfCable/export/excel" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>--%>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="87" asc="asc" desc="desc">
        <thead>
        <tr>
            <th style="width: 20px">序号</th>
            <%--<th style="width: 300px;" orderField="assetCode" class="asc|desc">回路运行编号</th>--%>
            <%--<th style="width: 300px;" orderField="assetCode" class="asc|desc">回路名称</th>--%>
            <th style="width: 300px;" orderField="" class="asc|desc">接地箱名称</th>
            <th style="width: 300px;" orderField="assetCode" class="asc|desc">资产编号</th>
            <%--<th style="width: 300px;" orderField="assetCode" class="asc|desc">型号</th>--%>
            <th style="width: 300px;" orderField="place" class="asc|desc">安装位置</th>
            <th style="width: 300px;" orderField="distance" class="asc|desc">投运时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="li" varStatus="vs">
            <tr target="sid_loopBoxNum" rel="${li.loopBoxNum}">
                <td>${vs.index+1}</td>
                <%--<td></td>--%>
                <%--<td></td>--%>
                <td></td>
                <%--<td></td>--%>
                <td>${li.assetCode}</td>
                <td>${li.place}</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${li.installDate}" type="both"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="panelBar">
        <div class="pages">
            <span>显示</span>
            <select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
                <c:forEach begin="20" end="100" step="20" varStatus="s">
                    <option value="${s.index}" ${pageForm.numPerPage eq
                            s.index ? 'selected="selected"' : ''}>
                            ${s.index}
                    </option>
                </c:forEach>
            </select>
            <span>条，共${pageForm.totalCount}条</span>
        </div>

        <div class="pagination" targetType="navTab" totalCount="${pageForm.totalCount}" numPerPage="${pageForm.numPerPage}" pageNumShown="10" currentPage="${pageForm.pageNum}"></div>

    </div>
</div>


