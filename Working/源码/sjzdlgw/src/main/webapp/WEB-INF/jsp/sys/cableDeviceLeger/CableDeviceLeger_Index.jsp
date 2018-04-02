<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}"/>
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}"/>
    <input type="hidden" name="orderField" value="${pageForm.orderField}"/>
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}"/>
</form>
<style>
    .a-searchBar {
        width: 100%;
        overflow: hidden;
    }

    .a-searchBar li {
        width: 300px;
        height: 30px;
        float: left;
    }

    select {
        width: 213px;
        margin-left: -3px;
        height: 23px;
    }
</style>
<script>
    function dbclick() {
        $("#CableDbclick").click();
    }
</script>
<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/CableDeviceLedger/${pathType}/index"method="post">
        <ul class="a-searchBar">
            <li>
                <label>电压等级：</label>
                <select class="required" name="voltageLevelID">
                    <option value="">请选择</option>
                    <c:forEach var="item" items="${PageModelPowerCableLevelList}">
                        <option value="${item.voltageLevelID}" ${PageModelCableDeviceLegerSearch.voltageLevelID eq item.voltageLevelID ? 'selected="selected"':''} >${item.voltageLevelName}</option>
                    </c:forEach>
                </select>
            </li>
            <li>

                档案编号：<input type="text" name="ledgerCode" value="${PageModelCableDeviceLegerSearch.ledgerCode}"
                            minlength="1" maxlength="20" size="30"/>
            </li>
            <li>
                工程名称：<input type="text" name="ledgerName" value="${PageModelCableDeviceLegerSearch.ledgerName}"
                            minlength="1" maxlength="15" size="30"/>
            </li>
            <li>
                <label>工程类型：</label>
                <select class="required" name="projectTypeID">
                    <option value="">请选择</option>
                    <c:forEach var="item" items="${ProjectTypeList}">
                        <option value="${item.projectTypeID}" ${PageModelCableDeviceLegerSearch.projectTypeID eq item.projectTypeID ? 'selected="selected"':''} >${item.projectTypeName}</option>
                    </c:forEach>
                </select>
            </li>
            <li>
                <div class="buttonActive" style="margin-right:5px;">
                    <div class="buttonContent">
                        <button type="submit">查询</button>
                    </div>
                </div>
                <div class="buttonActive">
                    <div class="buttonContent">
                        <button type="reset">重置</button>
                    </div>
                </div>
            </li>
        </ul>
    </form>
</div>
<%--  编辑操作的导航栏 --%>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a id="CableDbclick" class="edit" style="display:none" id="${pathType}Leger"
                   href="${ctxPath}/CableDeviceLedger/${pathType}/dbadd/{sid_CableDeviceLeger}" target="dialog"
                   rel="CableDeviceLeger_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false"
                   maxable="false" resizable="false" drawable="true" width="600" height="400"><span>详情</span></a></li>

            <c:if test="${pathType eq 'transmission'}">
                <li controlID="3220"><a class="add" href="${ctxPath}/CableDeviceLedger/${pathType}/add/-1"
                                        target="dialog" rel="CableDeviceLeger_Index_01" title="新建档案" mask="true"
                                        minable="false" max="false" maxable="false" resizable="false" drawable="true"
                                        width="600" height="400"><span>添加</span></a></li>
                <li><a class="edit" href="${ctxPath}/CableDeviceLedger/${pathType}/add/{sid_CableDeviceLeger}"
                       target="dialog" rel="CableDeviceLeger_Index_02" warn="请选择一条记录" mask="true" minable="false"
                       max="false" maxable="false" resizable="false" drawable="true" width="600"
                       height="400"><span>查看</span></a></li>

                <li controlID="3220"><a class="edit"
                                        href="${ctxPath}/CableDeviceLedger/${pathType}/add/{sid_CableDeviceLeger}"
                                        target="dialog" rel="CableDeviceLeger_Index_02" warn="请选择一条记录" mask="true"
                                        minable="false" max="false" maxable="false" resizable="false" drawable="true"
                                        width="600" height="400"><span>编辑档案</span></a></li>
                <li controlID="3230"><a class="delete"
                                        href="${ctxPath}/CableDeviceLeger/${pathType}/delete/{sid_CableDeviceLeger}"
                                        target="ajaxTodo" rel="CableDeviceLeger_Index_03" title="确定要删除吗?"
                                        warn="请选择一条记录"><span>删除档案</span></a></li>
                <li controlID="3240"><a class="edit"
                                        href="${ctxPath}/CableDeviceLedger/${pathType}/uploadCableDeviceLegerAttament/{sid_CableDeviceLeger}"
                                        target="dialog" rel="CableDeviceLeger_Index_04" warn="请选择一条记录" mask="true"
                                        minable="false" max="false" maxable="false" resizable="false" drawable="true"
                                        width="800" height="600"><span>文档附件</span></a></li>
                <li controlID="3250"><a class="icon" href="${ctxPath}/CableDeviceLedger/${pathType}/exportExcels"
                                        target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a>
                </li>
                <li controlID="3260"><a class="edit" href="${ctxPath}/CableDeviceLeger/${pathType}/pullToAduit/{sid_CableDeviceLeger}" target="ajaxTodo" rel="CableDeviceLeger_Index_03" title="确定要下发?"><span>下发档案</span></a></li>
            </c:if>
            <c:if test="${pathType eq 'distribution'}">
                <li controlID="4220"><a class="add" href="${ctxPath}/CableDeviceLedger/${pathType}/add/-1"
                                        target="dialog" rel="CableDeviceLeger_Index_01" title="新建档案" mask="true"
                                        minable="false" max="false" maxable="false" resizable="false" drawable="true"
                                        width="600" height="400"><span>添加</span></a></li>
                <li controlID="4220"><a class="edit"
                                        href="${ctxPath}/CableDeviceLedger/${pathType}/add/{sid_CableDeviceLeger}"
                                        target="dialog" rel="CableDeviceLeger_Index_02" warn="请选择一条记录" mask="true"
                                        minable="false" max="false" maxable="false" resizable="false" drawable="true"
                                        width="600" height="400"><span>编辑档案</span></a></li>
                <li controlID="4230"><a class="delete"
                                        href="${ctxPath}/CableDeviceLeger/${pathType}/delete/{sid_CableDeviceLeger}"
                                        target="ajaxTodo" rel="CableDeviceLeger_Index_03" title="确定要删除吗?"
                                        warn="请选择一条记录"><span>删除档案</span></a></li>
                <li controlID="4240"><a class="edit"
                                        href="${ctxPath}/CableDeviceLedger/${pathType}/uploadCableDeviceLegerAttament/{sid_CableDeviceLeger}"
                                        target="dialog" rel="CableDeviceLeger_Index_04" warn="请选择一条记录" mask="true"
                                        minable="false" max="false" maxable="false" resizable="false" drawable="true"
                                        width="800" height="600"><span>文档附件</span></a></li>
                <li controlID="4250"><a class="icon" href="${ctxPath}/CableDeviceLedger/${pathType}/exportExcels"
                                        target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a>
                </li>
                <li controlID="4260"><a class="edit" href="${ctxPath}/CableDeviceLeger/${pathType}/pullToAduit/{sid_CableDeviceLeger}" target="ajaxTodo" rel="CableDeviceLeger_Index_03" title="确定要下发?"><span>下发档案</span></a></li>
            </c:if>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="88" asc="asc" desc="desc">
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
            <tr ondblclick="dbclick()" target="sid_CableDeviceLeger" rel="${li.num}"
                ondblclick="${pathType}LegerClick()">
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

        <div class="pagination" targetType="navTab" totalCount="${pageForm.totalCount}"
             numPerPage="${pageForm.numPerPage}" pageNumShown="10" currentPage="${pageForm.pageNum}"></div>

    </div>
</div>
<script>
    function ${pathType}LegerClick() {
        $("#${pathType}Leger").click();
    }
</script>
