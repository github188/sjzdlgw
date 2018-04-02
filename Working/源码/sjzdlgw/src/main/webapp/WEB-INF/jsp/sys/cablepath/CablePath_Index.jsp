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
        width:300px;
        height:30px;
        float:left;
    }
    select{width:213px;}
</style>

<script>
    function ${pathType} dbclick() {
        $("#${pathType}path_id_index3").click();
        $(".check input").attr({"readonly":"true"});
        $(".check select").attr({"disabled":'disabled'});
        $(".check textarea").attr({"readonly":'readonly'});
    }

   
</script>

<div class="pageHeader check">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/CablePath/1/index" method="post">
        <input type="hidden" name="idNum" value="${BaseFacilityVoltageLevel_CablePath}" />
        <ul class="a-searchBar">
            <li>
                线路编号：<input type="text" name="cablePathCode" value="${PageModelCablePathSearch.cablePathCode}" minlength="1" maxlength="20" size="30"/>
            </li>
            <li>
                线路名称：<input type="text" name="cablePathName" value="${PageModelCablePathSearch.cablePathName}" minlength="1" maxlength="15" size="30"/>
            </li>
            <li>
                <label>电压等级：</label>
                <select class="required" name="voltageLevelID" with="100">
                    <option value="">请选择</option>
                    <c:forEach items="${voltageLevelList}" var="item">
                        <option value="${item.voltageLevelID}" ${item.voltageLevelID eq PageModelCablePathSearch.getVoltageLevelID() ? 'selected="selected"' : ''}>${item.voltageLevelName}</option>
                    </c:forEach>
                </select>
            </li>
            <li>
                <label>线路区域：</label>
                <select class="required" name="areaNum" with="100">
                    <option value="">请选择</option>
                    <c:forEach items="${areaList}" var="item">
                        <option value="${item.areaNum}" ${item.areaNum eq PageModelCablePathSearch.getAreaNum() ? 'selected="selected"' : ''}>${item.areaName}</option>
                    </c:forEach>
                </select>
            </li>
            <li>
                <label>运检班组：</label>
                <select class="required" name="organizationNum" with="100">
                    <option value="">请选择</option>
                    <c:forEach items="${organizationList}" var="item">
                        <option value="${item.organizationNum}" ${item.organizationNum eq PageModelCablePathSearch.getOrganizationNum() ? 'selected="selected"' : ''}>${item.organizationName}</option>
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
            <li controlID="3002"><a  id="${pathType}path_id_index3" class="edit" href="${ctxPath}/CablePath/1/dbadd/{sid_CablePath}" target="dialog" rel="CablePath_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="true" drawable="true" width="800" height="500"><span>查看</span></a></li>

            <li controlID="3002"><a class="add" href="${ctxPath}/CablePath/1/add/-1" target="dialog" rel="CablePath_Index_01" title="线路添加" mask="true" minable="false" max="false" maxable="false" resizable="true" drawable="true" width="800" height="500"><span>添加</span></a></li>
            <li controlID="3002" class="line">line</li>
            <li controlID="3002"><a class="edit" href="${ctxPath}/CablePath/1/add/{sid_CablePath}" target="dialog" rel="CablePath_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="true" drawable="true" width="800" height="500"><span>修改</span></a></li>
            <li controlID="3002" class="line">line</li>
            <li controlID="3003"><a class="delete" href="${ctxPath}/CablePath/1/delete/{sid_CablePath}" target="ajaxTodo" rel="CablePath_Index_03" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li controlID="3003" class="line">line</li>
            <li controlID="3004"><a class="icon" href="${ctxPath}/CablePath/1/Export/excel?idNum=${BaseFacilityVoltageLevel_CablePath}" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
        </ul>
    </div>
    <table class="table" width="160%"  layoutH="87" l="desc">
        <thead>
        <tr>
            <th width="40">序号</th>
            <th orderField="cablePathCode" class="asc|desc">线路编号</th>
            <th orderField="cablePathName" class="asc|desc">线路名称</th>
            <th orderField="beginPlace" class="asc|desc">起点</th>
            <th orderField="endPlace" class="asc|desc">终点</th>
            <th orderField="areaName" class="asc|desc">线路区域</th>
            <th orderField="voltageLevelName" class="asc|desc">电压等级</th>
            <th orderField="layingMethod" class="asc|desc">敷设方式</th>
            <th orderField="organizationName" class="asc|desc">运检班组</th>
            <th orderField="pathSectionNums" class="asc|desc">总段数</th>
            <th orderField="loopCounts" class="asc|desc">总条数</th>
            <th orderField="lineCounts" class="asc|desc">总回长(千米)</th>
            <th orderField="loopLenghts" class="asc|desc">总长(千米)</th>
            <th>备注</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="li" varStatus="vs">
            <tr target="sid_CablePath" rel="${li.cablePathNum}" ondblclick="${pathType}dbclick()">
                <td>${vs.index+1}</td>
                <td>${li.cablePathCode}</td>
                <td>${li.cablePathName}</td>
                <td>${li.beginPlace}</td>
                <td>${li.endPlace}</td>
                <td>${li.areaName}</td>
                <td>${li.voltageLevelName}</td>
                <td>${li.layingMethod}</td>
                <td>${li.organizationName}</td>
                <td>${li.pathSectionNums}</td>
                <td>${li.loopCounts}</td>
                <td>${li.lineCounts}</td>
                <td>${li.loopLenghts}</td>
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
