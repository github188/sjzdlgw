<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/23
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>

<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/CableDeviceLedger/2/index" method="post">
        <div class="searchBar">
            <table class="searchContent">
                <tr>

                    <td>
                        电压等级
                        <input name="voltageLevelID" value="${PageModelCableDeviceLegerSearch.voltageLevelID}" type="hidden">
                        <input name="voltageLevelName" value="${PageModelCableDeviceLegerSearch.voltageLevelName}" type="text" size="30" readonly="true"/>
                        <a class="btnLook" href="${ctxPath}/CablePath/index/PowerCableLevel" lookupGroup="">查找带回</a>
                    </td>
                    <td>

                        档案编号：<input type="text" name="ledgaerCode" value="${PageModelCableDeviceLegerSearch.ledgerCode}" minlength="1" maxlength="20" size="30"/>
                    </td>
                    <td>
                        工程名称：<input type="text" name="ledgerName" value="${PageModelCableDeviceLegerSearch.ledgerName}" minlength="1" maxlength="15" size="30"/>
                    </td>
                    <td>
                        工程性质：
                        <input name="projectTypeID" value="${PageModelCableDeviceLegerSearch.projectTypeID}" type="hidden">
                        <input name="projectTypeName" value="${PageModelCableDeviceLegerSearch.projectTypeName}" type="text" size="30" readonly="true"/>
                        <a class="btnLook" href="${ctxPath}/CableDeviceLedger/index/projectType" lookupGroup="">查找带回</a>
                    </td>
                </tr>
            </table>

            <div class="subBar">
                <ul>
                    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
                    <li><div class="buttonActive"><div class="buttonContent"><button type="reset">重置</button></div></div></li>
                </ul>
            </div>
        </div>
    </form>
</div>
<%--  编辑操作的导航栏 --%>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="${ctxPath}/CableDeviceLedger/add/-1" target="dialog" rel="CableDeviceLeger_Index_01" title="新建档案" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>添加</span></a></li>
            <li class="line">line</li>
            <li><a class="edit" href="${ctxPath}/CableDeviceLedger/add/{sid_CableDeviceLeger}" target="dialog" rel="CableDeviceLeger_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>编辑档案</span></a></li>
            <li class="line">line</li>
            <li><a class="delete" href="${ctxPath}/CableDeviceLeger/delete/{sid_CableDeviceLeger}" target="ajaxTodo" rel="CableDeviceLeger_Index_03" title="确定要删除吗?" warn="请选择一条记录"><span>删除档案</span></a></li>
            <li class="line">line</li>
            <li><a class="edit" href="${ctxPath}/CableDeviceLedger/uploadCableDeviceLegerAttament/{sid_CableDeviceLeger}" target="dialog" rel="CableDeviceLeger_Index_04" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>添加附件</span></a></li>
            <li class="line">line</li>
            <li><a class="edit" href="${ctxPath}/CableDeviceLedger/add/{sid_CableDeviceLeger}" target="dialog" rel="CableDeviceLeger_Index_04" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>关联查询</span></a></li>
            <li><a class="icon" href="${ctxPath}/CableDeviceLedger/exportExcels" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
        </ul>
    </div>
    <table class="table" width="1200" layoutH="138" asc="asc" desc="desc">
        <thead>
        <tr>
            <th>序号</th>
            <th orderField="voltageLevelName" class="asc|desc">电压等级</th>
            <th orderField="projectTypeName" class="asc|desc">工程性质</th>
            <th orderField="num" class="asc|desc">档案编号</th>
            <th orderField="ledgerName" class="asc|desc">工程名称</th>
            <th orderField="projectCode" class="asc|desc">方案编号</th>
            <th orderField="buildDate" class="asc|desc">施工时间</th>
            <th orderField="accpetDate" class="asc|desc">竣工时间</th>
            <th orderField="userName" class="asc|desc">录入人</th>
            <th>备注</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="li" varStatus="vs">
            <tr target="sid_CableDeviceLeger" rel="${li.num}">
                <td>${vs.index+1}</td>
                <td>${li.voltageLevelName}</td>
                <td>${li.projectTypeName}</td>
                <td>${li.ledgerCode}</td>
                <td>${li.ledgerName}</td>
                <td>${li.projectCode}</td>
                <td>${li.buildDateStr}</td>
                <td>${li.accpetDateStr}</td>
                <td>${li.userName}</td>
                <td>${li.memo}</td>
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
