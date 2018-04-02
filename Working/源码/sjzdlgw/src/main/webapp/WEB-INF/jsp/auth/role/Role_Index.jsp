<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="${ctxPath}/Role/index">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>
<script>
	var setting = {
		view: {
			dblClickExpand: false,
			showLine: true,
			selectedMulti: false
		},
		async: {
			enable: true,
			url:"${ctxPath}/tree/system/UserManager",
			autoParam:["id","level"]
		},
		check: {
			enable: true,
			chkStyle: "checkbox",
			chkboxType: { "Y": "ps", "N": "ps" }
		},
		data: {
			simpleData: {
				enable:true,
				idKey: "id",
				pIdKey: "pId",
				rootPId: ""
			}
		},
		callback: {
			onClick: function (event, treeId, treeNode) {
				var rel=treeNode.rel;
				if (rel!=""){
					rel='${ctxPath}'+rel;
					navTab.openTab(rel,rel, {title:treeNode.name, fresh:true,data:{"idNum":treeNode.id}});
				}
			}
		}
	};
	var zNodes =[	];
	$(document).ready(function(){
		$.fn.zTree.init($("#AuthorityTree_pageId"), setting, zNodes);
	});

</script>
<script>
    <%--console.log(${pageForm.listDatas});--%>

</script>
<div style=" float:left; width:55%;clear:both;" >

	    <div class="panelBar">
	        <ul class="toolBar">
	            <li><a class="add" href="${ctxPath}/Role/add/-1"  target="dialog" rel="ManholeKindType_Index_01" title="添加菜单" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="350" height="200"><span>添加</span></a></li>
	            <li class="line">line</li>
	            <li><a class="edit" href="${ctxPath}/Role/add/{sid_role}" target="dialog" rel="ManholeKindType_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="350" height="200"><span>修改</span></a></li>
	            <li class="line">line</li>
	            <li><a class="delete" href="${ctxPath}/Role/delete/{sid_role}" target="ajaxTodo" title="确定要删除吗?"  warn="请选择一条记录"><span>删除</span></a></li>
	            <li class="line">line</li>
	        </ul>
	    </div>
	    <table class="table" width="600" layoutH="75" asc="asc" desc="desc">
	        <thead>
	        <tr>
	            <th orderField="COMPANYNUM" class="asc" width="40" align="center">序号</th>
	            <th >角色名称</th>
	            <th >角色描述</th>
	            <th>操作</th>
	        </tr>
	        </thead>
	        <tbody>
	        <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
	            <tr target="sid_role" rel="${ob.roleNum}" onclick="pullListClick(${ob.roleNum})">
	                <td>${vs.index+1}</td>
	                <td>${ob.roleName}</td>
	                <td>${ob.comments}</td>
	                <%--<td>--%>
	                    <%--<button >授权菜单</button>--%>
	                <%--</td>--%>
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
<div style=" float:left; width:45%;height: 100%/*clear:both;*/">
	<%--<h1>aaaaa</h1>--%>
	<div style=" float:left; display:block; margin:10px; overflow:auto; width:80%; height: 400px; overflow:auto; border:solid 1px #CCC; line-height:21px; background:#FFF;">
			<ul class="ztree" id="AuthorityTree_pageId"></ul>
		<input type="button"  onclick="pushListClick()" value="提交">
	</div>
	<%--<input type="button" onclick="pullListClick()" value="拉取权限列表">--%>


</div>
<script>
	function tronclick() {
		alert("1");
	}
	var AllNode=null;
	console.log("aaaaa");
	function pushListClick() {
		var sidRole = document.getElementById("sid_role");
		if(sidRole==null){
			alertMsg.error("请选择一个角色名");
			return;
		}
		var treeObj = $.fn.zTree.getZTreeObj("AuthorityTree_pageId");
		var nodes = treeObj.getCheckedNodes(true);
		var i=0;
		var listNode=[];
		for(var i in nodes){
			var tmp={};
			tmp.id = nodes[i].id;
			listNode[i]=tmp
		}
		var setAuthNode = "${ctxPath}/Role/setAuthNode/"+sidRole.value;
		listNode = JSON.stringify(listNode);
		$.ajax({
			url:setAuthNode,
			dataType:"json",
//			contentType: "application/json",
			data:{checkedNode:listNode},
			type:'post',
			success:function (msg) {
				if(msg=='200'){
					alertMsg.correct('添加成功');
				}else{
					alertMsg.error('添加失败')
				}
			}
		})
	}
	function pullListClick(sidRole) {
//		var sidRole = document.getElementById("sid_role");
//		if(sidRole==null){
//			alertMsg.error("请选择一个角色名");
//			return;
//		}
		if(AllNode==null){   //如果全部的菜单没有拉取下来
			$.ajax({  //获取所有的权限节点
				url:"${ctxPath}/tree/Role/getAllAccessFunction",
				async: false,           //用同步的方法，否则可能下一个请求先响应
				success:successFunction,
			});
		}
		var getAuthNode = "${ctxPath}/Role/getAuthNode/"+sidRole;
		$.ajax({           //获取该角色下的所有权限
			url:getAuthNode,
			success:getAuthNodeSuccess,
		});
		function getAuthNodeSuccess(response) {
			var authNodes = strToJson(response);   //
			for(var i=0;i< authNodes.length;i++){
				for(var j=0;j<AllNode.length;j++){
					if(authNodes[i].id==AllNode[j].id){
						AllNode[j].checked="true";
						break;
					}
				}
				console.log(i);
			}
			$.fn.zTree.init($("#AuthorityTree_pageId"), setting, AllNode);
			for(var i=0;i<AllNode.length;i++){
				AllNode[i].checked="false";
			}
		}

	}
	function strToJson(str){
		var json = eval('(' + str + ')');
		return json;
	}
	function successFunction(response) {
		console.log(response);
		AllNode =strToJson(response);

	}

//		var zNodes1 =[
//			{ id:4000, pId:0, name:"输电",rel:"",},
//			{ id:3100, pId:4000, name:"输电线路",   rel:"",},
//			{ id:3200, pId:4000, name:"线路段台账",rel:"",},
//			{ id:3300, pId:4000, name:"设施档案",  rel:"",},
//			{ id:3400, pId:4000, name:"本体台账",  rel:""},
//			{ id:3210, pId:3400, name:"查看",      checked:"true"},
//			{ id:3220, pId:3400, name:"添加",       rel:"",},
//			{ id:3230, pId:3400, name:"编辑",          rel:"",},
//			{ id:3240, pId:3400, name:"删除",       rel:"",},
//			{ id:3250, pId:3400, name:"导出",          rel:"",},
//			{ id:3500, pId:4000, name:"终端台账",       rel:""},
//		]
//		$.fn.zTree.init($("#AuthorityTree_pageId"), setting, zNodes1);
//		var treeObj = $.fn.zTree.getZTreeObj("AuthorityTree_pageId");
//		var nodes = treeObj.getCheckedNodes(true);
//		treeObj.updateNode(zNodes1);
//		console.log(i++);


</script>
