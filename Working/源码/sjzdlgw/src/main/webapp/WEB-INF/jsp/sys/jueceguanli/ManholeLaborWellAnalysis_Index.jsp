<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="${ctxPath}/ManholeLaborWellAnalysis/index">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>

<script>
    <%--console.log(${pageForm.listDatas});--%>

</script>

<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
          <%--   <li><a class="add" href="${ctxPath}/ManholeLaborWellAnalysis/add/{sid_tst}" target="dialog"  title="工井查看" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>查看工井</span></a></li>
            <li class="line">line</li>
            <li><a class="edit" href="${ctxPath}/ManholeLaborWell/add/{sid_tst}" target="dialog" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>修改</span></a></li>
            <li class="line">line</li>
            <li><a class="delete" href="${ctxPath}/ManholeLaborWell/delete/{sid_tst}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li class="line">line</li> --%>
            <li controlID="6220"><a class="icon" href="${ctxPath}/ManholeLaborWellAnalysis/Export/excel" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
       
        </ul>
    </div>
    <table class="table" width="100%" layoutH="76" asc="asc" desc="desc">
        <thead>
        <tr>
            <th width="40">序号</th>
            <!-- <th width="60">档案编号</th>
            <th width="60">通道编号</th>
            <th width="60">工井编号</th> -->
            <th width="60">运行编号</th>
            <th width="60">所属片区</th>
            <th width="60">所属变电站</th>
            <th width="60">运检班组</th>
            <th width="40">设施</th>
            <th  width="40">类型</th>
            <th width="120">位置</th>
            <th width="40">尺寸</th>
            <th width="60">平台层数</th>
            <th width="60">地面高程</th>
            <th width="60">井底高程</th>
            <th width="40">材质</th>
            <th width="40">经度</th>
            <th width="40">纬度</th>
            <th width="60">设施材质</th>
            <th width="60">设施形状</th>
            <th width="50">录入人</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
            <tr target="sid_tst" rel="${ob.assetNum}">
                <td>${vs.index+1}</td>
               <%--  <td>${ob.archivesCode}</td>  <!---档案编号--->
                <td>${ob.tunnelAssetCode}</td>  <!---通道编号--->
                <td>${ob.assetCode}</td>  <!----工井编号----> --%>
                <td>${ob.operationCode}</td> <!--运行编号-->
                <td>${ob.tunnelAreaName}</td>
                <td>${ob.baseFacilityName}</td>
                <td>${ob.organizationName}</td> <!--1111--运检班组-->
                <td>${ob.manholeCoverTypeName}</td>
                <td>${ob.manholeKindTypeName}</td>
                <td>${ob.positionDescription}</td>
                <td>${ob.size1}</td>  <!---尺寸--->
                <td>${ob.terraceLayerCount}</td>  <!---平台层数-->
                <td>${ob.height}</td>
                <td>${ob.bottomHeight}</td>
                <td>${ob.manholeStuffTypeName}</td>
                <td>${ob.longitude}</td>
                <td>${ob.latitude}</td>
                <td>${ob.coverStuffTypeName}</td>
                <td>${ob.coverShapeTypeName}</td>
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
