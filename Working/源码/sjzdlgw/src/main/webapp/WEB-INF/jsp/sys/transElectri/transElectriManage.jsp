<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE div PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>输电线路</title>
<script type="text/javascript">
       function navTabAjaxDone(json){
       	 //DWZ.ajaxDone(json);
     	 if (json.statusCode == DWZ.statusCode.ok){
            if (false){ //把指定navTab页面标记为需要“重新载入”。注意navTabId不能是当前navTab页面的
                  navTab.reloadFlag("page_list");
            } else { //重新载入当前navTab页面
                  navTabPageBreak();
            }
      }

}
</script>
</head>
<body>
	<div class="pageHeader">
		<form rel="pagerForm" onsubmit="return navTabSearch(this);"
			action="user_list" method="post">
			<table style="margin-left: 30px;">
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>标题:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="title"
						type="text" size="30" maxlength="128" value="${title}" />
					</td>
	
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="submit">搜&nbsp;&nbsp;索</button></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
			</table>
		</form>

	</div>
	<form id="pagerForm" method="post" action="#rel#">
		<input type="hidden" name="pageNum" value="1" /> <input type="hidden"
			name="numPerPage" value="20" /> <input type="hidden"
			name="orderField" value="${orderField}" />
		<!--【可选】查询排序字段-->
		<input type="hidden" name="orderDirection" value="${orderDirection}" />
		<!--【可选】升序|降序-->

	</form>
	<form rel="pagerForm" onsubmit="return navTabSearch(this);"
		action="user_list" method="post">
		<div class="pageContent">
			<div class="panelBar">
				<ul class="toolBar">
					<li><a class="add" href="add_user" target="navTab"><span>添加</span>
					</a></li>
					<!-- <li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids"
						href="/del_data" class="delete" postType="string"
						callback="navTabAjaxDone"><span>批量删除</span> </a></li> -->
				</ul>
			</div>
			<input type="hidden" name="pageNum" value="1" />
			<table class="table" width="98%" layoutH="138" asc="asc" desc="desc">
				<thead>
					<tr>
						<!-- <th width="2%"><input type="checkbox" group="ids"
							class="checkboxCtrl"></th> -->
						<th width="" orderField="userName" class="${orderDirection}">用户名</th>
						<th width="" orderField="name" class="${orderDirection}">姓名</th>
						<th width="">操作</th>
					</tr>
				</thead>

				<tbody id="tbody">
					<c:forEach items="${userList}" var="user">
						<tr target="sid_user" rel="1">
						<!-- 	<td><input name="ids" value="${pro.id}" type="checkbox">
							</td> -->
							<td>${user.userName}</td>
							<td>${user.name}</td>
							<td><a title="删除" target="ajaxTodo"
								href="del_user?id=${user.id}" class="btnDel"
								callback="navTabAjaxDone">删除</a> <a title="编辑" target="navTab"
								href="edit_user?id=${user.id}" class="btnEdit">修改姓名</a>
								<a title="编辑" target="navTab"
								href="edit_password?id=${user.id}" class="btnEdit">修改密码</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="panelBar">
				<div class="pages">
					<span>显示</span>
					<!-- <select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value});">
				<option value="20">20</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="200">200</option>
			</select> -->
					<span>20条，共${totalCount}条</span>
				</div>
				<div class="pagination" targetType="navTab"
					totalCount="${totalCount}" numPerPage="20" pageNumShown="10"
					currentPage="${pageNum}"></div>
			</div>
		</div>
	</form>
</body>
</html>
