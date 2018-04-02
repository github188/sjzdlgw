<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 2016/10/17
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/CableDeviceStyle">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
</form>
<div class="pageHeader">
    <form rel="pagerForm" action="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/CableDeviceStyle" method="post" onsubmit="return dwzSearch(this,'dialog');">
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td>
                        类型：<input type="text" name="cableDeviceStyleName" value="${cableDeviceStyleName}" minlength="1" maxlength="20" size="30"/>
                    </td>
                </tr>
            </table>

            <div class="subBar">
                <ul>
                    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
                    <li><div class="button"><div class="buttonContent"><button type="button" multLookup="Terminal_Index_cableDeviceStyle" warn="请选电缆型号">选择</button></div></div></li>
                </ul>
            </div>
        </div>
    </form>
</div>


<div class="pageContent">
    <table class="table" layoutH="118" targetType="dialog" width="100%">
        <thead>
        <tr>
            <th width="30"><input type="checkbox" class="checkboxCtrl" group="Terminal_Index_cableDeviceStyle" /></th>
            <th>类型</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="li">
            <td><input type="checkbox"class="checkboxCtrl" name="Terminal_Index_cableDeviceStyle" value="${li.cableDeviceStyleIDs}"/></td>
            <td>${li.cableDeviceStyleName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="panelBar">
        <div class="pages">
            <span>每页</span>
            <select class="combox" name="numPerPage" onchange="dwzPageBreak({targetType:'dialog',numPerPage:this.value})">
                <c:forEach begin="20" end="100" step="20" varStatus="s">
                    <option value="${s.index}" ${pageForm.numPerPage eq
                            s.index ? 'selected="selected"' : ''}>
                            ${s.index}
                    </option>
                </c:forEach>
            </select>
            <span>条，共${pageForm.totalCount}条</span>
        </div>

        <div class="pagination" targetType="dialog" totalCount="${pageForm.totalCount}" numPerPage="${pageForm.numPerPage}" pageNumShown="10" currentPage="${pageForm.pageNum}"></div>

    </div>
</div>