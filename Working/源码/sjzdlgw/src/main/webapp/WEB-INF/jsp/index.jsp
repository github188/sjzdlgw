<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>国家电网河北石家庄电力公司电缆管网信息管理系统2.0</title>

	<link href="${staticPath}/dwz/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
	<link href="${staticPath}/dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
	<link href="${staticPath}/dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
	<link href="${staticPath}/dwz/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
	<!--[if IE]>
	<link href="${staticPath}/dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
	<![endif]-->
	<style type="text/css">
		#header{height:85px}
		#leftside, #container, #splitBar, #splitBarProxy{top:90px}
		.panelBared{
			margin-top:25px!important;
		}
		.panelBar{
			margin-top:0px;
		}
		
	</style>
	<link href="${staticPath}/website/css/index.css" rel="stylesheet" type="text/css" media="screen"/>
	<link rel="stylesheet" href="${staticPath}/website/css/revise.css" type="text/css">
	<!--[if lt IE 9]>
	<script src="${staticPath}/dwz/js/speedup.js" type="text/javascript"></script>
	<![endif]-->
	<script src="${staticPath}/dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/jquery.cookie.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.core.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.util.date.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.validate.method.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.barDrag.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.drag.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.tree.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.accordion.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.ui.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.theme.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.switchEnv.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.alertMsg.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.contextmenu.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.navTab.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.tab.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.resize.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.dialog.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.dialogDrag.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.sortDrag.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.cssTable.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.stable.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.taskBar.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.ajax.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.pagination.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.database.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.datepicker.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.effects.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.panel.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.checkbox.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.history.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.combox.js" type="text/javascript"></script>
	<script src="${staticPath}/dwz/js/dwz.print.js" type="text/javascript"></script>
	<%--<script src="${staticPath}/dwz/js/dwz.min.js" type="text/javascript"></script>--%>
	<script src="${staticPath}/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
	<script src="${staticPath}/website/js/menuTree.js" type="text/javascript"></script>
	<script src="${staticPath}/js/taskShow.js" type="text/javascript"></script>
	<link href="${staticPath}/website/css/taskShow.css" rel="stylesheet" type="text/css" media="screen"/>

	<script type="text/javascript">

		function strToJson(str){
			var json = eval('(' + str + ')');
			return json;
		}
		var controlIDs=null;
		var getAuthNode = "${ctxPath}/User/getAuthNodeByUser";
		$.ajax({           //获取该用户下的所有权限
			url:getAuthNode,
			async: false,
			success:getAuthNodeSuccess,
		});
		function getAuthNodeSuccess(response) {
			controlIDs = strToJson(response);   //
		}
		$(function(){
			DWZ.init("${staticPath}/dwz/dwz.frag.xml", {
				//loginUrl:"${ctxPath}/login_dialog", loginTitle:"登录",	// 弹出登录对话框
				loginUrl: "${ctxPath}/login",	// 跳到登录页面
				statusCode:{ok:200, error:300, timeout:301}, //【可选】
				pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
				keys: {statusCode:"statusCode", message:"message"}, //【可选】
				ui:{hideMode:'offsets'}, //【可选】hideMode:navTab组件切换的隐藏方式，支持的值有’display’，’offsets’负数偏移位置的值，默认值为’display’
				debug:false,	// 调试模式 【true|false】
				callback:function(){
					initEnv();
					$("#themeList").theme({themeBase:"${staticPath}/dwz/themes"}); // themeBase 相对于index页面的主题base路径zz
				}
			});
			$('.a-nav li').click(function() {
				$('.a-nav li').removeClass('current');
				$(this).addClass('current');
			});
			//iframe窗口动态变化
			window.onresize=function(){
				mapChangeFrameHeight();
			}
		});
		function removeNotHaveAuthNode() {
			$("[controlid]").each(function (elem) {
			var controlId = this.getAttribute("controlid");
			var controlArr=controlId.split(" ");
			var i=0;
			end: for(i=0;i<controlIDs.length;i++){
				for(var j=0;j<controlArr.length;j++){
					if(controlIDs[i].id==controlArr[j]){
						break end;
					}
				}
			}
			if(i>=controlIDs.length){
				var navigatorName = "Netscape";
				var u = navigator.userAgent;
				if(u.indexOf('Trident') > -1){        //为了解决IE不兼容的问题
					this.removeNode(true);
				}else {
					this.remove();
				}
			}
		});
		}
		function zTreeOnAsyncSuccess() {
			removeNotHaveAuthNode();
		}
		function addDiyDom(treeId, treeNode) { //为ztree的节点添加自定义dom的controlID属性
			var aObj = $("#" + treeNode.tId );
			var controlidTmp = treeNode.controlID;
			if(controlidTmp==null) return;
			aObj.attr("controlID",controlidTmp);
		}

		function removeHrefForTree() {
			$("[controltreeid]").each(function (elem) {
				var controlId = this.getAttribute("controlTreeID");
				var controlArr=controlId.split(" ");
				var i=0;
				end: for(i=0;i<controlIDs.length;i++){
					for(var j=0;j<controlArr.length;j++){
						if(controlIDs[i].id==controlArr[j]){
							break end;
						}
					}
				}
				if(i>=controlIDs.length){
					var navigatorName = "Netscape";
					var u = navigator.userAgent;
					if(u.indexOf('Trident') > -1){        //为了解决IE不兼容的问题
						this.setAttribute('href', 'javascript:;');
						this.removeAttribute('target');
					}else {
						this.setAttribute('href', 'javascript:;');
						this.removeAttribute('target');
					}
				}
			});
		}
		/*
		 *edited by GalaIO.
		 */
		var docExport = function(obj){
			var $this = $(obj);
			var url = unescape($this.attr("href")).replaceTmById($(event.target).parents(".unitBox:first"));
			DWZ.debug(url);
			if (!url.isFinishedTm()) {
				alertMsg.error($this.attr("warn") || DWZ.msg("alertSelectMsg"));
				return false;
			}
			var title = $this.attr("title");
			if (title) {
				alertMsg.confirm(title, {
					okCall: function(){
						window.location = url;
					}
				});
			} else {
				window.location = url;
			}
			return false;
		};
	</script>

</head>
<style>
	.a-user-info>span{
		display: block;
		margin-top:7px;
		float:left;
		margin-right:3px;
	}
</style>
<body scroll="no" onload="onloadMapPage()">
<div id="layout">
	<div id="a_header">
		<div class="a-logo">
			电缆管网信息管理系统2.0
		</div>
		<div class="a-user-info">
			<span style="margin-top:0px;"><img src="${staticPath}/website/images/9.png" style="vertical-align: middle"></span>
			<span>${Employee.userName}</span>
			<span>, 您好</span>
			<span style="margin-left:3px;margin-right:8px;color:#74E4DF;">|</span>
			<span style="margin-top:2.5px;"><a href="javascript:;" onclick="index_logout_a(event);"><img src="${staticPath}/website/images/exit_24.png" style="vertical-align:middle;margin-right:3px;height:20px;"/>退出</a></span>
		</div>
		<div class="a-hr"></div>
		<div id="a_navMenu">
			<ul class="a-nav">
				<li class="selected" controlID="2000">
					<a href="${ctxPath}/tree/map" id="map_index">地图</a>
				</li>
				<li class="" controlID="3000" aaabbb="100 200">
					<a href="${ctxPath}/sidebar_guangwang">管网</a>
				</li>
				<li class="" controlID="9000 4000">
					<a href="${ctxPath}/sidebar_shudian" >输电</a>
				</li>
				<li class="" controlID="5000">
					<a href="${ctxPath}/sidebar_peidian" >配电</a>
				</li>
				<li class="" controlID="6000">
					<a href="${ctxPath}/sidebar_zhongduanguanli" >终端管理</a>
				</li>
				<li class="" controlID="7000">
					<a href="${ctxPath}/sidebar_jueceguanli">决策分析</a>
				</li>
				<li class="" controlID="8000" >
					<a href="${ctxPath}/sidebar_xitong">系统</a>
				</li>
			</ul>
		</div>
	</div>

	<div id="leftside">
		<div id="sidebar_s">
			<div class="collapse">
				<div class="toggleCollapse"><div></div></div>
			</div>
		</div>
		<div id="sidebar">
			<div class="toggleCollapse"><h2>功能列表</h2><div>收缩</div></div>
			<div class="accordion" fillSpace="sidebar">
			</div>
		</div>
	</div>
	<div id="container">
		<div id="navTab" class="tabsPage">
			<div class="tabsPageHeader">
				<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
					<ul class="navTab-tab">
						<li tabid="main" class="main"><a href="javascript:void(0);"><span><span class="home_icon">电网地图</span></span></a></li>
					</ul>
				</div>
				<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
				<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
				<div class="tabsMore">more</div>
			</div>
			<div class="navTab-panel tabsPageContent layoutBox">
				<div class="page unitBox">
					<iframe style="width:100%;" frameborder="no" scrolling="no" border="0" marginwidth="0" marginheight="0" id="wasptmsMapPage" onload="mapChangeFrameHeight()"></iframe>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="footer">Copyright &copy; 2016 电缆管网信息管理系统2.0</div>
</div>
<a id="openNavtabSectionSimulationHREFMap" style="display: none" href="${ctxPath}/sectionSimulation/map/" target="navTab" title="断面仿真" external="true"></a>
</body>
</html>