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
        width: 320px;
        height: 30px;
        float: left;
    }
</style>

<script>
    function dbclick() {
        $("#Branch_index").click();
    }
</script>

<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/BranchBox/index" method="post">
        <ul class="a-searchBar">
            <li>
                资产编码：<input type="text" name="assetCode" value="${PageModelBranchBoxSearch.assetCode}" minlength="1"
                            maxlength="20" size="30"/>
            </li>
            <li>
                分接箱名称：<input type="text" name="assetName" value="${PageModelBranchBoxSearch.assetName}" minlength="1"
                             maxlength="15" size="30"/>
            </li>
            <li>
                <label>所属变电站：</label>
                <select name="baseFacilityNum" class="required combo-box">
                    <option value="">请选择变电站</option>
                    <c:forEach items="${baseFacilityList}" var="ob" varStatus="id">
                        <option value="${ob.baseFacilityNum}" ${PageModelBranchBoxSearch.baseFacilityNum eq ob.baseFacilityNum ? 'selected="selected"':''} >${ob.baseFacilityName}</option>
                    </c:forEach>
                </select>
            </li>
            <li>
                <label>分接箱规格：</label>
                <select name="modelNum" class="required combo-box">
                    <option value="">请选择分接箱规格</option>
                    <c:forEach items="${branchBoxModelList}" var="ob" varStatus="id">
                        <option value="${ob.modelNum}" ${PageModelBranchBoxSearch.modelNum eq ob.modelNum ? 'selected="selected"':''} >${ob.modelName}</option>
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
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li controlID="5202"><a id="Branch_index" class="edit" href="${ctxPath}/BranchBox/dbadd/{sid_BranchBox}"
                                    target="dialog" rel="BranchBox_Index_02" warn="请选择一条记录" mask="true" minable="false"
                                    max="false" maxable="false" resizable="true" drawable="true" width="800"
                                    height="600"><span>查看</span></a></li>

            <li controlID="5202"><a class="add" href="${ctxPath}/BranchBox/add/-1" target="dialog"
                                    rel="BranchBox_Index_01" title="终端设施添加" mask="true" minable="false" max="false"
                                    maxable="false" resizable="true" drawable="true" width="800"
                                    height="600"><span>添加</span></a></li>
            <li controlID="5202" class="line">line</li>
            <li controlID="5202"><a class="edit" href="${ctxPath}/BranchBox/add/{sid_BranchBox}" target="dialog"
                                    rel="BranchBox_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false"
                                    maxable="false" resizable="true" drawable="true" width="800"
                                    height="600"><span>修改</span></a></li>
            <li controlID="5202" class="line">line</li>
            <li controlID="5203"><a class="delete" href="${ctxPath}/BranchBox/delete/{sid_BranchBox}" target="ajaxTodo"
                                    rel="BranchBox_Index_03" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li controlID="5203" class="line">line</li>
            <li controlID="5204"><a class="icon" href="${ctxPath}/BranchBox/Export/excel" target="dwzExport"
                                    targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="87" asc="asc" desc="desc">
        <thead>
        <tr>
            <th>序号</th>
            <th orderField="AssetName" class="asc|desc">分接箱名称</th>
            <th orderField="BaseFacilityName" class="asc|desc">所属变电站</th>
            <th orderField="OperationCode" class="asc|desc">分接箱编号</th>
            <th orderField="AssetCode" class="asc|desc">资产编号</th>
            <th>位置描述</th>
            <th orderField="ModelName" class="asc|desc">规格</th>
            <th orderField="VoltageLevelName" class="asc|desc">电压等级</th>
            <th orderField="Bulid_CompanyNumName" class="asc|desc">生产厂家</th>
            <th>负荷开关</th>
            <th>闲锁装置</th>
            <th>T型接头</th>
            <th>肘型接头</th>
            <th>投运日期</th>
            <th>备注</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="li" varStatus="vs">
            <tr target="sid_BranchBox" ondblclick="dbclick()" rel="${li.assetNum}">
                <td>${vs.index+1}</td>
                <td>${li.assetName}</td>
                <td>${li.baseFacilityName}</td>
                <td>${li.operationCode}</td>
                <td>${li.assetCode}</td>
                <td>${li.positionDescription}</td>
                <td>${li.modelName}</td>
                <td>${li.voltageLevelName}</td>
                <td>${li.bulidCompanyNumName}</td>
                <td><input type="checkbox" disabled="true" ${li.isLoadSwitch==1?'checked="true"':''}/></td>
                <td><input type="checkbox" disabled="true" ${li.isLockDevice==1?'checked="true"':''}/></td>
                <td><input type="checkbox" disabled="true" ${li.isOnMonitor==1?'checked="true"':''}/></td>
                <td><input type="checkbox" disabled="true" ${li.isDrop==1?'checked="true"':''}/></td>
                <td>${li.runDateStr}</td>
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
