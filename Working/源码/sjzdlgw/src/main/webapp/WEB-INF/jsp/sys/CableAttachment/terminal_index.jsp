<%--
  Created by IntelliJ IDEA.
  User: long
  Date: 2016/10/15
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
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
    #installDateEnd{
        margin-left: 16px;
        height: 16px;
        width: 207px;
    }
    #installDateStart{
        width: 187px;
    }
    select{
        width:212px;
        margin-left: -3px;
        height: 23px;
    }
</style>
<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/index" method="post">
            <ul class="a-searchBar">
                <li>
                    档案编号：<input type="text" name="Num" value="${CableAttachmentTerminalSearch.num}" minlength="1" maxlength="20" size="30"/>
                </li>
                <li>
                    资产编码：<input type="text" name="AssetCode" value="${CableAttachmentTerminalSearch.assetCode}" minlength="1" maxlength="20" size="30"/>
                </li>
                <li>
                    <label>型&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
                    <select class="required" name="modelTypeNum">
                        <option value="">请选择</option>
                        <c:forEach var="item" items="${PageModelTypeNumList}">
                        <option value="${item.modelTypeNum}" ${CableAttachmentTerminalSearch.modelTypeNum eq item.modelTypeNum ? 'selected="selected"':''} >${item.modelTypeName}</option>
                    </c:forEach>
                    </select>
                </li>
                <li>
                    <c:if test="${attachmentTypeName eq 'section'}">
                        <label>导体材质：</label>
                    </c:if>
                    <c:if test="${attachmentTypeName ne 'section'}">
                        <label>类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;型：</label>
                    </c:if>
                    <select class="required" name="cableDeviceStyleID">
                        <option value="">请选择</option>
                        <c:forEach var="item" items="${PageCableDeviceStyleIDList}">
                            <option value="${item.cableDeviceStyleID}" ${CableAttachmentTerminalSearch.cableDeviceStyleID eq item.cableDeviceStyleID ? 'selected="selected"':''} >${item.cableDeviceStyleName}</option>
                        </c:forEach>
                    </select>
                </li>
                <c:if test="${attachmentTypeName eq 'section'}" >
                    <li>
                        <label>绝缘种类：</label>
                        <select class="required" name="cableDeviceTypeID">
                            <option value="">请选择</option>
                            <c:forEach var="item" items="${PageCableDeviceTypeList}">
                                <option value="${item.cableDeviceTypeID}" ${CableAttachmentTerminalSearch.cableDeviceTypeID eq item.cableDeviceTypeID ? 'selected="selected"':''} >${item.cableDeviceTypeName}</option>
                            </c:forEach>
                        </select>
                    </li>
                </c:if>
                <c:if test="${attachmentTypeName ne 'section'}" >
                    <li>
                        安装位置：
                        <input type="text" name="place" value="${CableAttachmentTerminalSearch.place}" minlength="1" maxlength="20" size="30" />
                    </li>
                </c:if>
                <li>
                    <label>生产厂家：</label>
                    <select class="required " name="companyNum" with="100">
                        <option value="">请选择</option>
                        <c:forEach var="item" items="${PageCompanyList}">
                            <option value="${item.companyNum}" ${CableAttachmentTerminalSearch.companyNum eq item.companyNum ? 'selected="selected"':''} >${item.companyName}</option>
                        </c:forEach>
                    </select>
                </li>
                <li>
                    投运时间：
                    <input id="installDateStart" name="installDateStart" type="text"  value="${CableAttachmentTerminalSearch.installDateStart}" class="date" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
                </li>
                <li>
                    至：
                    <input id="installDateEnd" name="installDateEnd" type="text"  value="${CableAttachmentTerminalSearch.installDateEnd}" class="date" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
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
<%--  编辑操作的导航栏 --%>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="edit" id="${attachmentTypeName}${pathType}" style="display:none" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/index/{sid_pt}" target="dialog" rel="CableAttachment_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="450"><span>详情</span></a></li>

            <c:if test="${attachmentTypeName eq 'terminal'}" >
                <c:if test="${pathType eq 'transmission'}">
                    <%--<li><a class="edit" id="attachmentView" style="display:none" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/index/{sid_pt}" target="dialog" rel="CableAttachment_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="450"><span>详情</span></a></li>--%>

                    <li controlID="3420"><a class="add" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/add/-1" target="dialog" rel="CableAttachment_Index_01" title="终端设施添加" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="650" height="450"><span>添加</span></a></li>
                    <%--<li class="line" controlID="3220">line</li>--%>
                    <li controlID="3420"><a class="edit" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/add/{sid_pt}" target="dialog" rel="CableAttachment_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="450"><span>修改</span></a></li>
                    <%--<li class="line" >line</li>--%>
                    <li controlID="3430"><a class="delete" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/delete/{sid_pt}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
                    <%--<li class="line">line</li>--%>
                    <li controlID="3440"><a class="icon" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/Export/excel" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
                </c:if>
                <c:if test="${pathType eq 'distribution'}">

                    <li controlID="4420"><a class="add" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/add/-1" target="dialog" rel="CableAttachment_Index_01" title="终端设施添加" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="650" height="450"><span>添加</span></a></li>
                    <%--<li class="line">line</li>--%>
                    <li controlID="4420"><a class="edit" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/add/{sid_pt}" target="dialog" rel="CableAttachment_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="450"><span>修改</span></a></li>
                    <%--<li class="line">line</li>--%>
                    <li controlID="4430"><a class="delete" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/delete/{sid_pt}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
                    <%--<li class="line">line</li>--%>
                    <li controlID="4440"><a class="icon" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/Export/excel" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
                </c:if>
            </c:if>
            <c:if test="${attachmentTypeName eq 'connector'}" >
                <c:if test="${pathType eq 'transmission'}">
                    <li controlID="3520"><a class="add" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/add/-1" target="dialog" rel="CableAttachment_Index_01" title="接头添加" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="650" height="450"><span>添加</span></a></li>
                    <%--<li class="line">line</li>--%>
                    <li controlID="3520"><a class="edit" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/add/{sid_pt}" target="dialog" rel="CableAttachment_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="450"><span>修改</span></a></li>
                    <%--<li class="line">line</li>--%>
                    <li controlID="3530"><a class="delete" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/delete/{sid_pt}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
                    <%--<li class="line">line</li>--%>
                    <li controlID="3540"><a class="icon" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/Export/excel" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
                </c:if>
                <c:if test="${pathType eq 'distribution'}">
                    <li controlID="4520"><a class="add" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/add/-1" target="dialog" rel="CableAttachment_Index_01" title="接头添加" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="650" height="450"><span>添加</span></a></li>
                    <%--<li class="line">line</li>--%>
                    <li controlID="4520"><a class="edit" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/add/{sid_pt}" target="dialog" rel="CableAttachment_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="450"><span>修改</span></a></li>
                    <%--<li class="line">line</li>--%>
                    <li controlID="4530"><a class="delete" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/delete/{sid_pt}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
                    <%--<li class="line">line</li>--%>
                    <li controlID="4540"><a class="icon" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/Export/excel" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
                </c:if>
                <%--<li><a class="add" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/add/-1" target="dialog" rel="CableAttachment_Index_01" title="接头添加" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="650" height="450"><span>添加</span></a></li>--%>
            </c:if>
            <c:if test="${attachmentTypeName eq 'section'}" >
                <c:if test="${pathType eq 'transmission'}">
                    <li controlID="3320"><a class="add" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/add/-1" target="dialog" rel="CableAttachment_Index_01" title="本体添加" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="450"><span>添加</span></a></li>
                    <%--<li class="line">line</li>--%>
                    <li controlID="3320"><a class="edit" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/add/{sid_pt}" target="dialog" rel="CableAttachment_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="450"><span>修改</span></a></li>
                    <%--<li class="line">line</li>--%>
                    <li  controlID="3330"><a class="delete" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/delete/{sid_pt}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
                    <%--<li class="line">line</li>--%>
                    <li controlID="3340"><a class="icon" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/Export/excel" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
                </c:if>
                <c:if test="${pathType eq 'distribution'}">
                    <li controlID="4320"><a class="add" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/add/-1" target="dialog" rel="CableAttachment_Index_01" title="本体添加" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="450"><span>添加</span></a></li>
                    <%--<li class="line">line</li>--%>
                    <li controlID="4320"><a class="edit" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/add/{sid_pt}" target="dialog" rel="CableAttachment_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="450"><span>修改</span></a></li>
                    <%--<li class="line">line</li>--%>
                    <li controlID="4330"><a class="delete" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/delete/{sid_pt}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
                    <%--<li class="line">line</li>--%>
                    <li controlID="4340"><a class="icon" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/Export/excel" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
                </c:if>
                <%--<li><a class="add" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/add/-1" target="dialog" rel="CableAttachment_Index_01" title="本体添加" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="450"><span>添加</span></a></li>--%>
            </c:if>
            <%--<li class="line">line</li>--%>
            <%--<li><a class="edit" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/add/{sid_pt}" target="dialog" rel="CableAttachment_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="600" height="450"><span>修改</span></a></li>--%>
            <%--<li class="line">line</li>--%>
            <%--<li ><a class="delete" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/delete/{sid_pt}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>--%>
            <%--<li class="line">line</li>--%>
             <%--<li><a class="icon" href="${ctxPath}/CableAttachment/${pathType}/${attachmentTypeName}/index/Export/excel" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>--%>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="87" asc="asc" desc="desc">
        <thead>
        <tr>
            <th>序号</th>
            <th orderField="num" class="asc|desc">档案编号</th>
            <th orderField="assetCode" class="asc|desc">资产编码</th>
            <th orderField="modelTypeName" class="asc|desc">型号</th>
            <c:if test="${attachmentTypeName eq 'section'}" >
                <th orderField="cableDeviceStyleName" class="asc|desc">导体材质</th>
            </c:if>
            <c:if test="${attachmentTypeName ne 'section'}" >
                <th orderField="cableDeviceStyleName" class="asc|desc">类型</th>
            </c:if>
            <%--<th orderField="cableDeviceStyleName" class="asc|desc">类型</th>--%>
            <c:if test="${attachmentTypeName ne 'section'}" >
                <th orderField="place" class="asc|desc">安装位置</th>
            </c:if>
            <c:if test="${attachmentTypeName eq 'terminal'}" >
                <c:if test="${pathType eq 'distribution'}">
                    <th orderField="cableDeviceTypeName" class="asc|desc">连接方式</th>  <!--配电的终端有连接方式 -->
                </c:if>
                <th orderField="faultIndicatorTypeName" class="asc|desc">故障指示器类型</th>  <!--终端输配电显示的项目相同 -->
            </c:if>
            <c:if test="${attachmentTypeName eq 'connector'}">
                <c:if test="${pathType eq 'transmission'}">
                    <th orderField="cableDeviceTypeName" class="asc|desc">接头类型</th>       <!--输电下的接头多出了接头类型 -->
                </c:if>
                <th orderField="safeBoxTypeName" class="asc|desc">防爆盒类型</th>             <!--接头下的输配电都有这项 -->
            </c:if>
            <c:if test="${attachmentTypeName eq 'section'}">
                <th orderField="cableDeviceTypeName" class="asc|desc">绝缘种类</th>
                <c:if test="${attachmentTypeName eq 'terminal'}" >
                    <th orderField="currentCapacity" class="asc|desc">载流量</th>
                </c:if>
                <th orderField="beginPlace" class="asc|desc">起点</th>
                <th orderField="endPlace" class="asc|desc">止点</th>
                <th orderField="length" class="asc|desc">长度</th>

            </c:if>
            <c:if test="${attachmentTypeName ne 'section'}" >
                <th orderField="isMonitor" class="asc|desc">是否在线监测</th>
            </c:if>
            <th orderField="companyName" class="asc|desc">生产厂家</th>
            <th orderField="installDate" class="asc|desc">投运时间</th>
            <th>备注</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="li" varStatus="vs">
            <tr target="sid_pt" rel="${li.attachmentNum}" ondblclick="${attachmentTypeName}${pathType}Click()">
                <td>${vs.index+1}</td>
                <td>${li.ledgerCode}</td>
                <td>${li.assetCode}</td>
                <td>${li.modelTypeName}</td>
                <td>${li.cableDeviceStyleName}</td>
                <c:if test="${attachmentTypeName ne 'section'}" >
                    <td>${li.place}</td>
                </c:if>
                <c:if test="${attachmentTypeName eq 'terminal'}" >               <!--终端-->
                    <c:if test="${pathType eq 'distribution'}">
                        <td>${li.cableDeviceTypeName}    <!--配电终端的接头连接方式-->
                    </c:if>
                    <td>${li.faultIndicatorTypeName}</td>  <!--终端输配电显示的项目相同 -->
                </c:if>
                <c:if test="${attachmentTypeName eq 'connector'}">              <!--接头-->
                    <c:if test="${pathType eq 'transmission'}">
                        <td>${li.cableDeviceTypeName}       <!--输电下的接头多出了接头类型 -->
                    </c:if>
                    <td>${li.safeBoxTypeName}             <!--接头下的输配电都有这项 -->
                </c:if>
                <c:if test="${attachmentTypeName eq 'section'}">              <!--本体-->
                    <c:if test="${pathType eq 'transmission'}">

                    </c:if>
                <c:if test="${attachmentTypeName eq 'section'}">
                    <td>${li.cableDeviceTypeName}</td>
                <c:if test="${attachmentTypeName eq 'terminal'}" >
                    <td>${li.currentCapacityDouble}</td>
                </c:if>
                    <td>${li.beginPlace}</td>
                    <td>${li.endPlace}</td>
                    <td>${li.lengthDouble}</td>
                </c:if>
                </c:if>
                <%--<td>${li.faultIndicatorTypeName}</td>--%>
                <c:if test="${attachmentTypeName ne 'section'}" >
                    <c:if test="${li.isMonitor eq '1'}">
                        <td>是</td>
                    </c:if>
                    <c:if test="${li.isMonitor eq '0'}">
                        <td>否</td>
                    </c:if>
                    <%--<td>${li.isMonitor}</td>--%>
                </c:if>
                <td>${li.companyName}</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${li.installDate}" type="both"/></td>
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
<script>
    function ${attachmentTypeName}${pathType}Click() {
        $("#${attachmentTypeName}${pathType}").click();
    }
</script>
