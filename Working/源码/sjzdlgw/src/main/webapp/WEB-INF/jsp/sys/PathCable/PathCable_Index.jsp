<%--
  Created by IntelliJ IDEA.
  User: GalaIO
  Date: 2016/11/11
  Time: 20:39
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
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/PathCable/${pathType}/index?loopNum=${loopNum}&pathType=${pathType}" method="post">
        <input type="hidden" name="idNum" value="${loopNum}" />
        <input type="hidden" name="pathType" value="${pathType}" />
        <%--<ul class="a-searchBar">--%>
            <%--&lt;%&ndash;<li>&ndash;%&gt;--%>
                <%--&lt;%&ndash;运行编号：<input type="text" name="runCode" value="${powerLoopPageSearch.runCode}" minlength="1" maxlength="20" size="30"/>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
            <%--<li>--%>
                <%--电缆名称：<input type="text" name="cableName" value="${powerLoopPageSearch.cableName}" minlength="1" maxlength="15" size="30"/>--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<label>电缆规格：</label>--%>
                <%--<select class="required" name="modelTypeNum" with="100">--%>
                    <%--<option value="">请选择</option>--%>
                    <%--<c:forEach items="${attachmentModelTypeList}" var="item">--%>
                        <%--<option value="${item.modelTypeNum}" ${item.modelTypeNum eq powerLoopPageSearch.modelTypeNum() ? 'selected="selected"' : ''}>${item.modelTypeName}</option>--%>
                    <%--</c:forEach>--%>
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
            <li controlID="${pathType==1?'3032':'4032'}"><a class="edit" href="${ctxPath}/PathCable/${pathType}/edit/{sid_cableNum}?loopNum=${loopNum}&pathType=${pathType}" title="修改电缆" warn="请选择一条记录" target="dialog" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="550" height="300"><span>修改</span></a></li>
            <li controlID="${pathType==1?'3032':'4032'}" class="line">line</li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="87" asc="asc" desc="desc">
        <thead>
        <tr>
            <th style="width: 20px">序号</th>
            <th style="width: 300px;" orderField="cableName" class="asc|desc">电缆名称</th>
            <th style="width: 300px;" orderField="runDate" class="asc|desc">最早投运</th>
            <th style="width: 300px;" orderField="modelTypeNum" class="asc|desc">电缆规格</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="li" varStatus="vs">
            <tr target="sid_cableNum" rel="${li.cableNum}">
                <td>${vs.index+1}</td>
                <%--<td>${li.runCode}</td>--%>
                <td>${li.cableName}</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${li.runDate}" type="both"/></td>
                <td>
                <c:forEach items="${attachmentModelTypeList}" var="item">
                    <c:if test="${item.modelTypeNum eq li.modelTypeNum}">
                        ${item.modelTypeName}
                    </c:if>
                </c:forEach>
                </td>
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

