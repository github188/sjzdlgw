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
    select{
        width:213px;
        margin-left: -3px;
        height: 23px;
    }
</style>
<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/User/index" method="post">
            <input  name="organizationNum" value="${UserPageSearch.organizationNum}" type="hidden">
            <ul class="a-searchBar">
                <li>
                    员工编号：<input type="text" name="employeeID" value="${UserPageSearch.employeeID}" minlength="1" maxlength="20" size="30"/>
                </li>
                <li>
                    用户名称：<input type="text" name="userName" value="${UserPageSearch.userName}" minlength="1" maxlength="20" size="30"/>
                </li>
                <li>
                    电话号码：<input type="text" name="mobilePhone" value="${UserPageSearch.mobilePhone}" minlength="1" maxlength="20" size="30"/>
                </li>
                <li>
                    <label>角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色：</label>
                    <select class="required" name="roleNum">
                        <option value="">请选择</option>
                        <c:forEach var="item" items="${RolesList}">
                            <option value="${item.roleNum}" ${UserPageSearch.roleNum eq item.roleNum ? 'selected="selected"':''} >${item.roleName}</option>
                        </c:forEach>
                    </select>
                </li>
                <%--<li>--%>
                    <%--<label>所属部门：</label>--%>
                    <%--<select class="required" name="organizationNum">--%>
                        <%--<option value="">请选择</option>--%>
                        <%--<c:forEach var="item" items="${OrganizationsList}">--%>
                            <%--<option value="${item.organizationNum}" ${UserPageSearch.organizationNum eq item.organizationNum ? 'selected="selected"':''} >${item.organizationName}</option>--%>
                        <%--</c:forEach>--%>
                    <%--</select>--%>
                <%--</li>--%>
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
            <li><a class="add" href="${ctxPath}/User/add/-1" target="dialog" rel="ManholeKindType_Index_01" title="添加用户" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="700" height="300"><span>添加</span></a></li>
            <li class="line">line</li>
            <li><a class="edit" href="${ctxPath}/User/add/{sid_user}" target="dialog" title="修改用户信息" rel="ManholeKindType_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="700" height="300"><span>修改</span></a></li>
            <li class="line">line</li>
            <li><a class="delete" href="${ctxPath}/User/del/{sid_user}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li class="line">line</li>
        </ul>
    </div>
    <table class="table" width="99%" layoutH="88" asc="asc" desc="desc">
        <thead>
        <tr>
            <th  width="40" align="center">序号</th>
            <th >员工编号</th>
            <th >登录账号</th>
            <th >用户名称</th>
            <th >角色</th>
            <th >电子邮箱</th>
            <th >电话号码</th>
            <th >备注</th>
            <%--<td>操作</td>--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
            <tr target="sid_user" rel="${ob.employeeID}">
                <td>${vs.index+1}</td>
                <td>${ob.employeeID}</td>
                <td>${ob.account}</td>
                <td>${ob.userName}</td>
                <td>${ob.roleName}</td>
                <td>${ob.email}</td>
                <td>${ob.mobilePhone}</td>
                <td>${ob.address}</td>
                <%--td>查看</td><--%>
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
