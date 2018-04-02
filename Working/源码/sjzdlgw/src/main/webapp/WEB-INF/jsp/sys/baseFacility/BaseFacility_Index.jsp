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
        width: 290px;
        height: 30px;
        float: left;
    }
</style>
<script>
    function dbclick() {
        console.log(1);
        $("#pageBase_index").click();
    }
</script>


<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/BaseFacility/index" method="post">
        <ul class="a-searchBar">
            <li>
                变电站名称：<input type="text" name="baseFacilityName" value="${baseFacilityName}" minlength="1"
                             maxlength="10"/>
            </li>
            <li>
                资产编码： <input type="text" name="assetCode" value="${assetCode}" minlength="1" maxlength="10"/>
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
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a id="pageBase_index" class="edit" href="${ctxPath}/BaseFacility/dbadd/{sid_bf}" target="dialog"
                   rel="ManholeKindType_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false"
                   resizable="false" drawable="true" width="600" height="185"><span>查看</span></a></li>

            <li controlID="5002"><a class="add" href="${ctxPath}/BaseFacility/add/-1" target="dialog"
                                    rel="ManholeKindType_Index_01" title="变电站添加" mask="true" minable="false" max="false"
                                    maxable="false" resizable="false" drawable="true" width="600"
                                    height="185"><span>添加</span></a></li>
            <li controlID="5002" class="line">line</li>
            <li controlID="5002"><a class="edit" href="${ctxPath}/BaseFacility/add/{sid_bf}" target="dialog"
                                    rel="ManholeKindType_Index_02" warn="请选择一条记录" mask="true" minable="false"
                                    max="false" maxable="false" resizable="false" drawable="true" width="600"
                                    height="185"><span>修改</span></a></li>
            <li controlID="5002" class="line">line</li>
            <li controlID="5003"><a class="delete" href="${ctxPath}/BaseFacility/delete/{sid_bf}" target="ajaxTodo"
                                    title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li controlID="5003" class="line">line</li>
            <li controlID="5004"><a class="icon" href="${ctxPath}/BaseFacility/Export/excel" target="dwzExport"
                                    targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>

        </ul>
    </div>
    <table class="table" width="100%" layoutH="88" asc="asc" desc="desc">
        <thead>
        <tr>
            <th orderField="baseFacilityNum" class="asc" width="10%" align="center">序号</th>
            <th>变电站名称</th>
            <th orderField="assetCode">资产编码</th>
            <th>位置描述</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
            <tr target="sid_bf" ondblclick="dbclick()" rel="${ob.baseFacilityNum}">
                <td>${vs.index+1}</td>
                <td>${ob.baseFacilityName}</td>
                <td>${ob.assetCode}</td>
                <td>${ob.baseFacilityDescription}</td>
                <td>
                    查看
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

        <div class="pagination" targetType="navTab" totalCount="${pageForm.totalCount}"
             numPerPage="${pageForm.numPerPage}" pageNumShown="10" currentPage="${pageForm.pageNum}"></div>

    </div>
</div>
