<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="${ctxPath}/Extinguisher/index">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>

<script>
    <%--console.log(${pageForm.listDatas});--%>
    function dbclick() {
        $("#extinguisherView").click();
    }
</script>
<%-- <div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/Extinguisher/index" method="post">

    </form>
</div> --%>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a id="extinguisherView" style="display:none" class="edit" href="${ctxPath}/Extinguisher/index/{sid_abt}" target="dialog" rel="ManholeKindType_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>详情</span></a></li>

            <li controlID="2112"><a class="add" href="${ctxPath}/Extinguisher/add/-1" target="dialog" rel="ManholeKindType_Index_01" title="添加灭火装置" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>添加</span></a></li>
            <li controlID="2112" class="line">line</li>
            <li controlID="2112"><a class="edit" href="${ctxPath}/Extinguisher/add/{sid_abt}" target="dialog" rel="ManholeKindType_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>修改</span></a></li>
            <li controlID="2112" class="line">line</li>
            <li controlID="2113"><a class="delete" href="${ctxPath}/Extinguisher/delete/{sid_abt}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li controlID="2113" class="line">line</li>
            <li controlID="2114"><a class="icon" href="${ctxPath}/Extinguisher/Export/excel" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
       
        </ul>
    </div>
    <table class="table" width="100%"  layoutH="75" asc="asc" desc="desc">
        <thead>
        <tr>
            <th orderField="assetNum" class="asc" width="40" align="center">序号</th>
            <th >档案编号</th>
            <th  orderField="tunnel_AssetNum">通道编号</th>
            <th orderFileld="assetCode">灭火装置编号</th>
            <th orderFileld="extinguisherTypeID">类型</th>
            <th orderFileld="number">数量</th>
            <th orderFileld="upGradeTime">安装时间</th>
            <th orderFileld="validityYear">有效期</th>
            <th orderFileld="downTime">过期时间</th>
            <th orderFileld="extinguisherInfo">规格</th>
            <th>经度</th>
            <th>纬度</th>
            <th>录入人</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
            <tr target="sid_abt" rel="${ob.assetNum}" ondblclick="dbclick()">
                <td>${vs.index+1}</td>
                <td>${ob.archivesCode}</td><!--档案编号-->
                <td>${ob.tunnelAssetCode}</td>
                <td>${ob.assetCode}</td>
                <td>${ob.extinguisherTypeName}</td>
                <td>${ob.quantity}</td>
                <td>${ob.upGradeTimeStr}</td>
                <td>${ob.validityYear}</td>
                <td>${ob.downTimeStr}</td>
                <td>${ob.extinguisherInfo}</td>
                <td>${ob.longitude}</td>
                <td>${ob.latitude}</td>
                <td>${ob.employeeName}</td>
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
