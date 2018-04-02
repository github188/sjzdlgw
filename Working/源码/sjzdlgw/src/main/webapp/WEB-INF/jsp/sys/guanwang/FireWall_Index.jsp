<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>

<script>
    <%--console.log(${pageForm.listDatas});--%>
    function dbclick() {
        $("#fireWallView").click();
    }
</script>
<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/FireWall/index" method="post">
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td>
                        通道编号:<input type="text" name="tunnelAssetCode" value="${fireWallPage.tunnelAssetCode}" minlength="1" maxlength="5"/>
                        防火墙编号:<input type="text" name="assetCode" value="${fireWallPage.assetCode}" minlength="1" maxlength="5"/>
                        防火墙类型:<select name="fireWallTypeID" class="required combo-box">
                        <option value="">请选择</option>
                        <c:forEach items="${FireWallTypeList}" var="ob" varStatus="id">
                            <option value="${ob.fireWallTypeID}" ${fireWallPage.fireWallTypeID eq ob.fireWallTypeID ? 'selected="selected"':''} >${ob.fireWallTypeName}</option>
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
            <li ><a id="fireWallView" style="display:none" class="edit" href="${ctxPath}/FireWall/index/{sid_abt}" target="dialog" rel="FireWall_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>详情</span></a></li>

            <li controlID="2102"><a class="add" href="${ctxPath}/FireWall/add/-1" target="dialog" rel="FireWall_Index_01" title="添加防火墙" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>添加</span></a></li>
            <li controlID="2102" class="line">line</li>
            <li controlID="2102"><a class="edit" href="${ctxPath}/FireWall/add/{sid_abt}" target="dialog" rel="FireWall_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>修改</span></a></li>
            <li controlID="2102" class="line">line</li>
            <li controlID="2103"><a class="delete" href="${ctxPath}/FireWall/delete/{sid_abt}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li controlID="2103" class="line">line</li>
            <li controlID="2104"><a class="icon" href="${ctxPath}/FireWall/Export/excel" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
       
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138" asc="asc" desc="desc">
        <thead>
        <tr>
            <th orderField="assetNum" class="asc" width="40" align="center">序号</th>
            <th width="60">档案编号</th>
            <th width="60">通道编号</th>
            <th width="60">防火墙编号</th>
            <th orderField="fireWallTypeID" width="40">类型</th>
            <th width="40">材质</th>
            <th width="40">尺寸</th>
            <th width="40">经度</th>
            <th width="40">纬度</th>
            <th width="70">防火门材质</th>
            <th width="70">防火门尺寸</th>
            <th width="60">安装时间</th>
            <th width="50">录入人</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
            <tr target="sid_abt" rel="${ob.assetNum}" ondblclick="dbclick()">
                <td>${vs.index+1}</td>
                <td>${ob.archivesCode}</td><%--档案编号--%>
                <td>${ob.tunnelAssetCode}</td><%--通道编号--%>
                <td>${ob.assetCode}</td><%--防火墙编号--%>
                <td>${ob.fireWallTypeName}</td>
                <td>${ob.fireWallStuffTypeName}</td>
                <td>${ob.wallSize}</td>
                <td>${ob.longitude}</td>
                <td>${ob.latitude}</td>
                <td>${ob.doorStuffTypeName}</td>
                <td>${ob.doorSize}</td>
                <td>${ob.operationDate}</td>
                <td>${ob.employeeName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="panelBar panelBared">
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
