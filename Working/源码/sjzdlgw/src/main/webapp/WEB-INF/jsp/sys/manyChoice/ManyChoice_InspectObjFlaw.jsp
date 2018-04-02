<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="${ctxPath}/ManyChoice/${teamTypeID}/InspectObjFlaw">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
</form>

<div class="pageHeader">
    <form rel="pagerForm" action="${ctxPath}/ManyChoice/${teamTypeID}/InspectObjFlaw" method="post" onsubmit="return dwzSearch(this,'dialog');">
        <div class="searchBar">
            <div class="subBar">
                <ul>
                    <li><div class="button"><div class="buttonContent"><button type="button" multLookup="CablePath_Index_Area" warn="请选择缺陷">选择</button></div></div></li>
                </ul>
            </div>
        </div>
    </form>
</div>
<div class="pageContent">
    <table class="table" layoutH="118" targetType="dialog" width="100%">
        <thead>
        <tr>
            <th width="30"><input type="checkbox" class="checkboxCtrl" group="CablePath_Index_Area" /></th>
            <th width="60">缺陷状态</th>
            <th width="60">对象类型</th>
            <th width="60">对象编号</th>
            <th width="60">对象编码</th>
            <th width=50">有缺陷</th>
            <th width="60">来源类型</th>
            <th width="60">缺陷分类</th>
            <th width="60">缺陷等级</th>
            <th width="60">缺陷描述</th>
            <th width="60">录入时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="li">
            <tr>
            <td><input type="checkbox"class="checkboxCtrl" name="CablePath_Index_Area" value="{objFlawNum:${li.objFlawNum}}"/></td>
            <td>${li.flawAduitStatusName}</td>
            <td>${li.objTypeEnumName}</td> <%--通道编号---%>
            <td>${li.objTableNum}</td> <%--运行编号---%>
            <td>${li.objCode}</td>  <%--所属变电站---%>
            <td>${li.isFlaw>0?"是":"否"}</td>
            <td>${li.flawSourceName}</td>
            <td>${li.flawTypeName}</td>
            <td>${li.flawLevelTypeName}</td>
            <td>${li.flawDescription}</td>
            <td>${li.flawDateStr}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="panelBar">
        <div class="pages">
            <span>每页</span>
            <select class="combox" name="numPerPage" onchange="dwzPageBreak({targetType:'dialog',data:{numPerPage:this.value}})">
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
