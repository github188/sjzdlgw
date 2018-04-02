<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>
<style>
    .a-searchBar {
        width:100%;
        overflow: hidden;
    }
    .a-searchBar li {
        width:290px;
        height:30px;
        float:left;
    }
    .panelBarChange{
        margin-top:-5px !important;
    }
</style>

<script>
    function dbclick() {
        $("#Manhole_index").click();
    }
</script>

<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/Manhole/index" method="post">
        <ul class="a-searchBar">
            <li>
                资产编码：<input type="text" name="assetCode" value="${manholePage.assetCode}" minlength="1" maxlength="20" size="30"/>
            </li>
            <li>
                终端名称：<input type="text" name="assetName" value="${manholePage.assetName}" minlength="1" maxlength="15" size="30"/>
            </li>
            <li>
                终端类型：
                <select class="required" name="manholeKindTypeID">
                    <option value="">请选择终端类型</option>
                    <c:forEach var="item" items="${PageModelManholeKindTypeList}">
                        <option value="${item.manholeKindTypeID}" ${manholePage.manholeKindTypeID eq item.manholeKindTypeID ? 'selected="selected"':''} >${item.manholeKindTypeName}</option>
                    </c:forEach>
                </select>
            </li>
            <li>
                <div class="buttonActive" style="margin-right:5px;">
                    <div class="buttonContent">
                        <button type="submit">查询</button>
                    </div>
                </div>
                <div class="buttonActive"><div class="buttonContent"><button type="reset">重置</button></div></div>
            </li>
        </ul>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li controlID="5102"><a id="Manhole_index" class="edit" href="${ctxPath}/Manhole/dbadd/{sid_Manhole}" target="dialog" rel="Manhole_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="true" drawable="true" width="800" height="280"><span>查看</span></a></li>
            <li controlID="5102"><a class="add" href="${ctxPath}/Manhole/add/-1" target="dialog" rel="Manhole_Index_01" title="终端设施添加" mask="true" minable="false" max="false" maxable="false" resizable="true" drawable="true" width="800" height="280"><span>添加</span></a></li>
            <li controlID="5102" class="line">line</li>
            <li controlID="5102"><a class="edit" href="${ctxPath}/Manhole/add/{sid_Manhole}" target="dialog" rel="Manhole_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="true" drawable="true" width="800" height="280"><span>修改</span></a></li>
            <li controlID="5102" class="line">line</li>
            <li controlID="5103"><a class="delete" href="${ctxPath}/Manhole/delete/{sid_Manhole}" target="ajaxTodo" rel="Manhole_Index_03" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li controlID="5103" class="line">line</li>
            <li controlID="5104"><a class="icon" href="${ctxPath}/Manhole/Export/excel" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="76" asc="asc" desc="desc">
        <thead>
            <tr>
                <th align="center">序号</th>
                <th align="center" orderField="AssetName" class="asc">终端名称</th>
                <th align="center" orderField="AssetCode" class="asc">资产编码</th>
                <th align="center" orderField="manholeKindTypeID" class="asc">终端类型</th>
                <th align="center">经度</th>
                <th align="center">维度</th>
                <th align="center"  width="30%">位置描述</th>
                <th align="center">备注</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="li" varStatus="vs">
            <tr target="sid_Manhole" rel="${li.assetNum}" ondblclick="dbclick()">
                <td width="5%" align="center">${vs.index+1}</td>
                <td>${li.assetName}</td>
                <td>${li.assetCode}</td>
                <td>${li.manholeKindTypeName}</td>
                <td>${li.longitude}</td>
                <td>${li.latitude}</td>
                <td>${li.positionDescription}</td>
                <td>${li.memo}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="panelBar panelBarChange">
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
