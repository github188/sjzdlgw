<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>
<script>
    function dbclick${isRootNode}() {
        $("#powerTunnelView${isRootNode}").click();
    }
</script>
<style>
    select{
        width:200px;
        margin-left: -3px;
        height: 23px;
    }
</style>
<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/PowerTunnel/index" method="post">
        <input type="hidden" name="idNum" value="${ArchivesNum_PowerTunnel}" />
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td>
                        通道编号：<input type="text" name="assetCode" value="${assetCode}" minlength="1" maxlength="15"/>
                        运行编号：<input type="text" name="operationCode" value="${operationCode}" minlength="1" maxlength="15"/>
                        档案状态：
                        <select class="required" name="acceptStatusTypeID">
                            <option value="">请选择</option>
                            <c:forEach var="item" items="${AcceptStatusTypeList}">
                                <option value="${item.acceptStatusTypeID}" ${item.acceptStatusTypeID eq acceptStatusTypeID?"selected":""}>${item.acceptStatusTypeName}</option>
                            </c:forEach>
                        </select>
                        <%--所属区域：--%>
                        <%--<select class="required" name="acceptStatusTypeID">--%>
                            <%--<option value="">请选择</option>--%>
                            <%--<c:forEach var="item" items="${AcceptStatusTypeList}">--%>
                                <%--<option value="${item.acceptStatusTypeID}" ${item.acceptStatusTypeID eq acceptStatusTypeID?"selected":""}>${item.acceptStatusTypeName}</option>--%>
                            <%--</c:forEach>--%>
                        <%--</select>--%>
                        起止地点：<input type="text" name="startStopDescription" value="${startStopDescription}">

                        所属区域：<input type="text" name="areaName" value="${areaName}">
                        类型：<input type="text" name="tunnelStructureTypeName" value="${tunnelStructureTypeName}">
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
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a id="powerTunnelView${isRootNode}" style="display: none;" class="edit" href="${ctxPath}/PowerTunnel/index/{sid_pt}" target="dialog" rel="ManholeKindType_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"></a></li>

            <c:if test="${isRootNode ne 1}">
            <li controlID="2011"><a class="add" href="${ctxPath}/PowerTunnel/add/-1?idNum=${ArchivesNum_PowerTunnel}&idName=${ArchivesCode_PowerTunnel}" target="dialog" rel="ManholeKindType_Index_01" title="通道台账添加" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>添加</span></a></li>
            <li controlID="2011" class="line">line</li>
            </c:if>
            <li controlID="2011"><a class="edit" href="${ctxPath}/PowerTunnel/add/{sid_pt}" target="dialog" rel="ManholeKindType_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>修改</span></a></li>
            <li controlID="2011" class="line">line</li>
            <li controlID="2012"><a class="delete" href="${ctxPath}/PowerTunnel/delete/{sid_pt}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li controlID="2012" class="line">line</li>
            <li controlID="2013"><a class="icon" href="${ctxPath}/PowerTunnel/Export/excel" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>

        </ul>
    </div>
    <table class="table" width="2000" layoutH="138">
        <thead>
        <tr>
            <th width="20" align="center">序号</th>
            <th width="50">档案编号</th>
            <th width="50">通道编号</th>
            <th width="50">运行编号</th>
            <th width="50">所属变电站</th>
            <th width="50">所属片区</th>
            <th width="50">类型</th>
            <th width="50">材质</th>
            <th width="50">电压等级</th>
            <th width="300">起止地点</th>
            <th width="300">所在方位</th>
            <th width="50">投运日期</th>

            <th width="100">运检班组</th>
            <th width="20">尺寸</th>
            <th width="20">覆土深度</th>
            <th width="20">长度</th>
            <th width="50">录入人</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
            <tr target="sid_pt" rel="${ob.assetNum}" ondblclick="dbclick${isRootNode}();">
                <td>${vs.index+1}</td>
                <td>${ob.archivesCode}</td>
                <td>${ob.assetCode}</td> <%--通道编号---%>
                <td>${ob.operationCode}</td> <%--运行编号---%>
                <td>${ob.baseFacilityName}</td>  <%--所属变电站---%>
                <td>${ob.areaName}</td>
                <td>${ob.tunnelStructureTypeName}</td>
                <td>${ob.tunnelStuffTypeName}</td>
                <td>${ob.voltageLevelName}</td>
                <td>${ob.startStopDescription}</td>
                <td>${ob.positionDescription}</td>
                <td>${ob.operationDateStr}</td>
                <td>${ob.organizationName}</td>
                <td>${ob.tunnelSize}</td>
                <td>${ob.frontTopHeight}</td>
                <td>${ob.tunnelLength}</td>
                <td>${ob.employeeName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="panelBar" style="margin-top: -8px">
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
