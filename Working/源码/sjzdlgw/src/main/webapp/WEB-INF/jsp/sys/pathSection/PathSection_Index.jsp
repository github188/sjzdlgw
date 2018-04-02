<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="idNum" value="${cablePathNum}" />
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
        width:300px;
        height:30px;
        float:left;
    }
    select{width:213px;}

    .tr_color_3 {
        background-color:yellow;
    }
    .tr_color_4 {
        background-color:red;
    }
</style>

<script>
    function dbclick() {
        $("#path_id_index").click();
        $('input').setAttribute("readOnly",true);
    }
</script>

<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/PathSection/1/index" method="post">
        <input type="hidden" name="idNum" value="${cablePathNum}" />
        <ul class="a-searchBar">
            <li>
                线路段编号：<input type="text" name="pathSectionCode" value="${PageModelPathSectionSearch.pathSectionCode}" minlength="1" maxlength="20" size="30"/>
            </li>
            <li>
                 线路段名称：<input type="text" name="pathSectionName" value="${PageModelPathSectionSearch.pathSectionName}" minlength="1" maxlength="15" size="30"/>
            </li>
            <li>
                    <label>状&nbsp;&nbsp;态：</label>
                    <select class="required" name="attachmentStatusTypeID" with="100">
                        <option value="">请选择</option>
                        <c:forEach items="${attachmentStatusTypeList}" var="item">
                            <option value="${item.attachmentStatusTypeID}" ${item.attachmentStatusTypeID eq PageModelPathSectionSearch.getAttachmentStatusTypeID() ? 'selected="selected"' : ''}>${item.attachmentStatusTypeName}</option>
                        </c:forEach>
                    </select>
            </li>
            <li>
                <label>接地方式：</label>
                <select class="required" name="safeEarthTypeID" with="100">
                    <option value="">请选择</option>
                    <c:forEach items="${safeEarthTypeList}" var="item">
                        <option value="${item.safeEarthTypeID}" ${item.safeEarthTypeID eq PageModelPathSectionSearch.getSafeEarthTypeID() ? 'selected="selected"' : ''}>${item.safeEarthTypeName}</option>
                    </c:forEach>
                </select>
            </li>
            <li>
                <label>敷设方式：</label>
                <select class="required" name="installTypeID" with="100">
                    <option value="">请选择</option>
                    <c:forEach items="${installTypeList}" var="item">
                        <option value="${item.installTypeID}" ${item.installTypeID eq PageModelPathSectionSearch.getInstallTypeID() ? 'selected="selected"' : ''}>${item.installTypeName}</option>
                    </c:forEach>
                </select>
            </li>
            <li>
                <div class="buttonActive" style="margin-right:5px; margin-left: 10px">
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
                <c:if test="${cablePathNum ne -1}">
                <li controlID="3012"><a class="add" href="${ctxPath}/PathSection/1/edit/add/-1?cablePathNum=${cablePathNum}" title="线路段添加" target="dialog" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="750" height="500"><span>添加</span></a></li>
                <li controlID="3012" class="line">line</li>
                </c:if>
                <li><a id="path_id_index" style="display: none;" class="edit" href="${ctxPath}/PathSection/1/editview/modify/{sid_PathSection}?cablePathNum=${cablePathNum}" target="dialog" rel="ManholeKindType_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"></a></li>

                <li controlID="3012"><a class="edit" href="${ctxPath}/PathSection/1/edit/modify/{sid_PathSection}?cablePathNum=${cablePathNum}" target="dialog" rel="PathSection_Index_01" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="750" height="500"><span>修改</span></a></li>
            <li controlID="3012" class="line">line</li>
            <li controlID="3013"><a class="delete" href="${ctxPath}/PathSection/1/delete/{sid_PathSection}" target="ajaxTodo" rel="PathSection_Index_03" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li controlID="3013" class="line">line</li>

            <li controlID="3015"><a class="edit" href="${ctxPath}/PathSection/1/charge/outage/{sid_PathSection}" target="dialog" rel="PathSection_Index_04" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="300"><span>停运</span></a></li>
            <li controlID="3015" class="line">line</li>
                <li controlID="3016"><a class="edit" href="${ctxPath}/PathSection/1/charge/recover/{sid_PathSection}" target="dialog" rel="PathSection_Index_04" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="300"><span>启用</span></a></li>
                <li controlID="3016" class="line">line</li>
            <li controlID="3017"><a class="edit" href="${ctxPath}/PathSection/1/charge/returned/{sid_PathSection}" target="dialog" rel="PathSection_Index_05" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="300"><span>退运</span></a></li>
            <li controlID="3017" class="line">line</li>

            <li controlID="3014"><a class="icon" href="${ctxPath}/CablePathSecetions/1/export/excel?idNum=${cablePathNum}" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
        </ul>
    </div>
    <table class="table" width="120%" layoutH="87" asc="asc" desc="desc">
        <thead>
        <tr>
            <th style="width: 5px">序号</th>
            <th style="width: 300px;" orderField="pathSectionCode" class="asc|desc">线路段编号</th>
            <th style="width: 300px;" orderField="pathSectionName" class="asc|desc">线路段名称</th>
            <th style="width: 300px;">起点位置</th>
            <th style="width: 300px;" >终点止点</th>
            <th style="width: 300px;" orderField="attachmentStatusTypeName" class="asc|desc">状态</th>
            <th style="width: 300px;" orderField="loopCount" class="asc|desc">回数</th>
            <th style="width: 300px;" orderField="lineCount" class="asc|desc">条数</th>
            <th style="width: 300px;" orderField="loopLenght" class="asc|desc">回长(千米)</th>
            <th style="width: 300px;" orderField="totalLength" class="asc|desc">总回长(千米)</th>
            <th style="width: 300px;" orderField="runDate" class="asc|desc">最早投运</th>
            <th style="width: 300px;" orderField="modelTypeName" class="asc|desc">电缆规格</th>
            <th style="width: 300px;" orderField="noumenonCount" class="asc|desc">本体数量</th>
            <th style="width: 300px;" orderField="connectorCount" class="asc|desc">接头数量</th>
            <th style="width: 300px;" orderField="terminationCount" class="asc|desc">终端数量</th>
            <th style="width: 300px;" orderField="earthBoxCount" class="asc|desc">分接箱数量</th>
            <th style="width: 300px;" orderField="safeEarthTypeName" class="asc|desc">接地方式</th>
            <th style="width: 300px;" orderField="installTypeName" class="asc|desc">敷设方式</th>
            <th style="width: 300px;" orderField="assetName" class="asc|desc">起点设备</th>
            <th style="width: 300px;" orderField="end_AssetName" class="asc|desc">止点设备</th>
            <th style="width: 300px;">备注</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="li" varStatus="vs">

            <tr  target="sid_PathSection" ondblclick="dbclick()" rel="${li.pathSectionNum}" class="${li.attachmentStatusTypeID eq 3?'tr_color_3':li.attachmentStatusTypeID eq 4?'tr_color_4':''}" >
                <td>${vs.index+1}</td>
                <td>${li.pathSectionCode}</td>
                <td>${li.pathSectionName}</td>
                <td>${li.placeInfo}</td>
                <td>${li.placeInfo2}</td>
                <td>${li.attachmentStatusTypeName}</td>
                <td>${li.loopCount}</td>
                <td>${li.lineCount}</td>
                <td>${li.loopLenght}</td>
                <td>${li.totalLength}</td>
                <td>${li.runDateStr}</td>
                <td>${li.modelTypeName}</td>
                <td>${li.noumenonCount}</td>
                <td>${li.connectorCount}</td>
                <td>${li.terminationCount}</td>
                <td>${li.earthBoxCount}</td>
                <td>${li.safeEarthTypeName}</td>
                <td>${li.installTypeName}</td>
                <td>${li.assetName}</td>
                <td>${li.end_AssetName}</td>
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
