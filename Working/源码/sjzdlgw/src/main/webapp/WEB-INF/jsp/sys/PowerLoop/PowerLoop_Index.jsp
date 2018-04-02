<%--
  Created by IntelliJ IDEA.
  User: GalaIO
  Date: 2016/11/11
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="idNum" value="${pathSectionNum}" />
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
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/PowerLoop/${pathType}/index" method="post">
        <%--<input type="hidden" name="idNum" value="${pathSectionNum}" />--%>
        <%--<ul class="a-searchBar">--%>
            <%--<li>--%>
                <%--运行编号：<input type="text" name="runCode" value="${powerLoopPageSearch.runCode}" minlength="1" maxlength="20" size="30"/>--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--回路名称：<input type="text" name="loopName" value="${powerLoopPageSearch.loopName}" minlength="1" maxlength="15" size="30"/>--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<label>状&nbsp;&nbsp;态：</label>--%>
                <%--<select class="required" name="attachmentStatusTypeID" with="100">--%>
                    <%--<option value="">请选择</option>--%>
                    <%--<c:forEach items="${attachmentStatusTypeList}" var="item">--%>
                        <%--<option value="${item.attachmentStatusTypeID}" ${item.attachmentStatusTypeID eq powerLoopPageSearch.getAttachmentStatusTypeID() ? 'selected="selected"' : ''}>${item.attachmentStatusTypeName}</option>--%>
                    <%--</c:forEach>--%>
                <%--</select>--%>
                <%--&lt;%&ndash;<a class="btnLook" href="${ctxPath}/PathSection/index/AttachmentStatusType" lookupGroup="">查找带回</a>&ndash;%&gt;--%>
                <%--&lt;%&ndash;状&nbsp;&nbsp;态：&ndash;%&gt;--%>
                <%--&lt;%&ndash;<input name="attachmentStatusTypeID" value="${PageModelPathSectionSearch.attachmentStatusTypeID}" type="hidden">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<input name="attachmentStatusTypeName" value="${PageModelPathSectionSearch.attachmentStatusTypeName}" type="text" size="30" readonly="true"/>&ndash;%&gt;--%>

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
            <%--<li><a class="add" href="${ctxPath}/PathSection/add/-1" target="dialog" rel="PathSection_Index_01" title="终端设施添加" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>添加</span></a></li>--%>
            <%--<li class="line">line</li>--%>
            <li controlID="${pathType==1?'3022':'4022'}"><a class="add" href="${ctxPath}/PowerLoop/${pathType}/edit/add/-1?pathSectionNum=${pathSectionNum}" title="回路添加" target="dialog" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="500" height="260"><span>添加</span></a></li>
            <li controlID="${pathType==1?'3022':'4022'}" class="line">line</li>
            <li controlID="${pathType==1?'3022':'4022'}"><a class="edit" href="${ctxPath}/PowerLoop/${pathType}/edit/modify/{sid_PowerLoop}?pathSectionNum=${pathSectionNum}" target="dialog" rel="PowerLoop_Index_01" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="500" height="260"><span>修改</span></a></li>
            <li controlID="${pathType==1?'3022':'4022'}" class="line">line</li>
            <li controlID="${pathType==1?'3023':'4023'}"><a class="delete" href="${ctxPath}/PowerLoop/${pathType}/delete/{sid_PowerLoop}" target="ajaxTodo" rel="PowerLoop_Index_03" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li controlID="${pathType==1?'3023':'4023'}" class="line">line</li>
                <%--<li><a class="add" href="${ctxPath}/PowerLoop/{sid_PowerLoop}/delete" target="ajaxTodo" rel="PowerLoop_Index_03" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>--%>
                <%--<li class="line">line</li>--%>
                <%--<li><a class="edit" href="${ctxPath}/PowerLoop/{sid_PowerLoop}/addLoopBox?pathSectionNum=${pathSectionNum}" target="dialog" rel="PowerLoop_Index_01" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>接地箱</span></a></li>--%>
                <%--<li class="line">line</li>--%>
            <%--<li><a class="icon" href="${ctxPath}/PowerLoop/export/excel" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>--%>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="87" asc="asc" desc="desc">
        <thead>
        <tr>
            <th style="width: 20px">序号</th>
            <th style="width: 300px;" orderField="runCode" class="asc|desc">运行编号</th>
            <th style="width: 300px;" orderField="loopName" class="asc|desc">回路名称</th>
            <th style="width: 300px;" orderField="attachmentStatusTypeID" class="asc|desc">状态</th>
            <th style="width: 300px;" orderField="runDate" class="asc|desc">最早投运</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="li" varStatus="vs">
            <tr target="sid_PowerLoop" rel="${li.loopNum}">
                <td>${vs.index+1}</td>
                <td>${li.runCode}</td>
                <td>${li.loopName}</td>
                <td>
                <c:forEach items="${attachmentStatusTypeList}" var="item">
                    <c:if test="${item.attachmentStatusTypeID eq li.attachmentStatusTypeID}">
                        ${item.attachmentStatusTypeName}
                    </c:if>
                </c:forEach>
                </td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${li.runDate}" type="both"/></td>
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

