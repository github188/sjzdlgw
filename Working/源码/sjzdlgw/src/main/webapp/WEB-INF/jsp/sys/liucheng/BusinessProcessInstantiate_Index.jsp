<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>

<script>
    <%--console.log(${pageForm.listDatas});--%>

</script>
<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/BusinessProcessInstantiate/index" method="post">

    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="${ctxPath}/BusinessProcessInstantiate/add/-1" target="dialog" rel="BusinessProcessInstantiate_Index_01" title="业务流程添加" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>添加</span></a></li>
            <li class="line">line</li>
            <li><a class="edit" href="${ctxPath}/BusinessProcessInstantiate/add/{sid_tst}" target="dialog" rel="BusinessProcessInstantiate_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>修改</span></a></li>
            <li class="line">line</li>
            <li><a class="delete" href="${ctxPath}/BusinessProcessInstantiate/delete/{sid_tst}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li class="line">line</li>
        </ul>
    </div>
    <table class="table" width="1200" layoutH="138" asc="asc" desc="desc">
        <thead>
        <tr>
            <th width="40">序号</th>
            <th width="60">流程模版</th>
            <th  width="60" >节点A用户</th>
            <th  width="60" >节点B用户</th>
            <th  width="60" >节点C用户</th>
            <th  width="60" >节点D用户</th>
            <th  width="60" >节点E用户</th>
            <th  width="60" >创建时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
            <tr target="sid_tst" rel="${ob.templateID}">
                <td>${vs.index+1}</td>
                <td>${ob.templateName}</td>
                <td>${ob.userAName}</td>
                <td>${ob.userBName}</td>
                <td>${ob.userCName}</td>
                <td>${ob.userDName}</td>
                <td>${ob.userEName}</td>
                <td>${ob.ctimeStr}</td>
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
