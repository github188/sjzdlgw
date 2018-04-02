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
        width:280px;
        height:30px;
        float:left;
    }
</style>

<script>
    function dbclick() {
        $("#EarthBoxjiedi").click();
    }
    window.obload = function(){
        $('#a_tdtz').css({
            'width':  '892px'
        });
        $(".dialog").css({

            'width':'900px'
        });
        $('.tongdao-table').css({
            'width':'100%'
        }) ;
    }
</script>

<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/CableAttachment/EarthBox/index" method="post">
        <div class="searchBar">
                <ul class="a-searchBar">
                    <li>
                        档案编号
                        <input name="Num" value="${CableAttachmentTerminalSearch.num}" minlength="1" maxlength="20" size="30">
                    </li>
                    <li>
                        资产编码：<input type="text" name="AssetCode" value="${CableAttachmentTerminalSearch.assetCode}" minlength="1" maxlength="20" size="30"/>
                     </li>
                    <li>
                    <label>型号：</label>
                    <select class="required" name="modelTypeNum">
	                    <option value="">请选择型号</option>
	                    <c:forEach var="item" items="${PageModelTypeNumList}">
	                        <option value="${item.modelTypeNum}" ${CableAttachmentTerminalSearch.modelTypeNum eq item.modelTypeNum ? 'selected="selected"':''} >${item.modelTypeName}</option>
	                    </c:forEach>
	                </select>
                    </li>
                    <li>
             
                        安装位置：
                        <input name="place" value="${CableAttachmentTerminalSearch.place}" minlength="1" maxlength="20" size="30">
                    </li>
                    <li>
         
                        <label>生产厂家：</label>
                   <select class="required" name="companyNum">
	                    <option value="">请选择生产厂家</option>
	                    <c:forEach var="item" items="${PageCompanyList}">
	                        <option value="${item.companyNum}" ${CableAttachmentTerminalSearch.companyNum eq item.companyNum ? 'selected="selected"':''} >${item.companyName}</option>
	                    </c:forEach>
	                </select>
                    </li>
                    <li style="margin-left:20px">
                        投运时间：
                        <input name="installDateStart" type="text"  value="${CableAttachmentTerminalSearch.installDateStart}" class="date" size="30" />
                    </li>
                    <li>
                        至：
                        <input name="installDateEnd" type="text"  value="${CableAttachmentTerminalSearch.installDateEnd}" class="date" size="30" />
                    </li>
                </ul>
            <!-- </table> -->

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
            <li ><a id="EarthBoxjiedi" class="edit" href="${ctxPath}/CableAttachment/EarthBox/dbadd/{sid_pt}" target="dialog" rel="EarthBox_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="650" height="450"><span>查看</span></a></li>

            <li controlID="3620"><a class="add" href="${ctxPath}/CableAttachment/EarthBox/add/-1" target="dialog" rel="EarthBox_Index_01" title="接地箱添加" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="650" height="450"><span>添加</span></a></li>
            <li controlID="3620" class="line">line</li>
            <li controlID="3620"><a class="edit" href="${ctxPath}/CableAttachment/EarthBox/add/{sid_pt}" target="dialog" rel="EarthBox_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="650" height="450"><span>修改</span></a></li>
            <li controlID="3620" class="line">line</li>
            <li controlID="3630"><a class="delete" href="${ctxPath}/CableAttachment/EarthBox/delete/{sid_pt}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li controlID="3630" class="line">line</li>
             <li controlID="3640"><a class="icon" href="${ctxPath}/CableAttachment/EarthBox/Export/excel" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
       
        </ul>
    </div>
    <table class="table" width="100%" layoutH="114" asc="asc" desc="desc">
        <thead>
        <tr>
            <th>序号</th>
            <th orderField="num" class="asc|desc">档案编号</th>
            <th orderField="assetCode" class="asc|desc">资产编码</th>
            <th orderField="modelTypeName" class="asc|desc">型号</th>
            <th orderField="place" class="asc|desc">安装位置</th>
            <th orderField="companyName" class="asc|desc">生产厂家</th>
            <th orderField="installDate" class="asc|desc">投运时间</th>
            <th>备注</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="li" varStatus="vs">
            <tr target="sid_pt" rel="${li.attachmentNum}" ondblclick="dbclick()">
                <td>${vs.index+1}</td>
                <td>${li.ledgerCode}</td>
                <td>${li.assetCode}</td>
                <td>${li.modelTypeName}</td>
                <td>${li.place}</td>
                <td>${li.companyName}</td>
                <td>${li.installDateStr}</td>
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
