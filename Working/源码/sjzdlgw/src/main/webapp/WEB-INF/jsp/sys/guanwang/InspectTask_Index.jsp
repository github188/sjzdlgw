<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>
<style>

</style>
<script>

</script>
<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/InspectTask/${teamTypeID}/index" method="post">
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td>
                        任务状态：
                        <select name="taskStatusTypeID" class="required combo-box">
                            <option value="" ${taskStatusTypeID==null? 'selected="selected"':''} ></option>

                            <c:forEach items="${taskStatusTypeList}" var="ob" varStatus="id">
                                <option value="${ob.taskStatusTypeID}" ${taskStatusTypeID eq ob.taskStatusTypeID ? 'selected="selected"':''} >${ob.taskStatusTypeName}</option>
                            </c:forEach>
                        </select>
                      </td>
                    <td>
                        <div class="subBar">
                            <ul>
                                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
                                <li><div class="buttonActive"><div class="buttonContent"><button type="reset">重置</button></div></div></li>
                            </ul>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li controlID="${teamTypeID==1?'2821':teamTypeID==2?'3821':'4821'}"><a class="add" href="${ctxPath}/InspectTask/${teamTypeID}/add/-1" target="dialog" rel="InspectTask_Index_01" title="新建巡视任务" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="300"><span>添加</span></a></li>
            <li controlID="${teamTypeID==1?'2821':teamTypeID==2?'3821':'4821'}" class="line">line</li>
            <li controlID="${teamTypeID==1?'2822':teamTypeID==2?'3822':'4822'}"><a class="delete" href="${ctxPath}/InspectTask/${teamTypeID}/delete/{sid_tst}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li controlID="${teamTypeID==1?'2822':teamTypeID==2?'3822':'4822'}" class="line">line</li>
            <li controlID="${teamTypeID==1?'2827':teamTypeID==2?'3827':'4827'}"><a class="icon" href="${ctxPath}/InspectTask/${teamTypeID}/downloadSafe/{sid_tst}"  onclick="docExport(this);return false" target="dwzExport" targetType="navTab"><span>安全控制卡</span></a></li>
            <li controlID="${teamTypeID==1?'2827':teamTypeID==2?'3827':'4827'}" class="line">line</li>
            <li controlID="${teamTypeID==1?'2828':teamTypeID==2?'3828':'4828'}"><a class="icon" href="${ctxPath}/InspectTask/${teamTypeID}/downloadQuality/{sid_tst}"  onclick="docExport(this);return false" target="dwzExport" targetType="navTab"><span>质量控制卡</span></a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="113" asc="asc" desc="desc">
        <thead>
        <tr>
            <th orderField="taskNum" class="asc" width="40" align="center">序号</th>
            <th width="60">任务状态</th>
            <th width="60">任务名称</th>
            <th width="80">任务详细说明</th>
            <th width="80">任务计划时间</th>
            <th width="70">工作负责人</th>
            <th width="80">巡视人员名称</th>
            <th width="40">二卡票号</th>
            <th width="80">巡视开始时间</th>
            <th width="80">巡视完成时间</th>
            <th width="40">备注</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
            <tr target="sid_tst" rel="${ob.taskNum}">
                <td>${ob.taskNum}</td>
                <td>${ob.taskStatusTypeName}</td>
                <td>${ob.taskName}</td>
                <td>${ob.taskDescription}</td>
                <td>${ob.planDateStr}</td>
                <td>${ob.task_EmployeeID}</td>
                <td>${ob.employeeName}</td>
                <td>${ob.workBillsCode}</td>
                <td>${ob.startDateTimeStr}</td>
                <td>${ob.completeDateTimeStr}</td>
                <td>${ob.memo}</td>
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
