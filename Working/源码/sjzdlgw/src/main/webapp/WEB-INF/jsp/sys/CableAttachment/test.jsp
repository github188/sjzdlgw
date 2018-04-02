<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<%--<link rel="stylesheet" type="text/css" href="uploadify.css" />--%>
<%--<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script>--%>
<%--<script type="text/javascript" src="/jquery.uploadify-3.1.min.js"></script>--%>
<style>
	.my-uploadify-button {
		background:none;
		border: none;
		text-shadow: none;
		border-radius:0;
		font-weight: normal;
	}
	.uploadify:hover .my-uploadify-button {
		background:none;
		border: none;
	}
</style>
<script>
	$(function() {
		$("#file_upload").uploadify({
	        //是否自动上传
			'method'   : 'get',
	        'auto':false,
	        'buttonText': '<a class="add" onclick="addFile();"><span>添加文件</span></a>',
	        //flash
	        'swf': "static/dwz/uploadify/scripts/uploadify.swf",
	        //服务器端脚本使用的文件对象的名称 $_FILES个['upload']
	        'fileObjName':'upload',
	        //上传处理程序
	        'uploader':'/CableDeviceLedger/uploadCableDeviceLegerAttament',
	        'buttonClass':'my-uploadify-button',
	        'queueID':'fileQueue',
	        //上传数量
	        'queueSizeLimit' : 1,
	        'width':73,
	        'multi':false,
	        //每次更新上载的文件的进展
	        'onUploadProgress' : function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {
	             //有时候上传进度什么想自己个性化控制，可以利用这个方法
	             //使用方法见官方说明
	        },
	        'onUploadStart':function() {
	        	var element = {};
				element.name = $('#fileName').val();
				element.type = $('#fileType :selected').val();
				element.legerCode="a";
				element.legernum=1;
				element.employEid="1";
				element.attachemtType="a";
	        	$('#file_upload').uploadify('settings','formData',element);
	        },
	        //返回一个错误，选择文件的时候触发
	        'onSelectError':function(file, errorCode, errorMsg){
	            switch(errorCode) {
	                case -100:
	                    alert("上传的文件数量已经超出系统限制的"+$('#file_upload').uploadify('settings','queueSizeLimit')+"个文件！");
	                    break;
	                case -110:
	                    alert("文件 ["+file.name+"] 大小超出系统限制的"+$('#file_upload').uploadify('settings','fileSizeLimit')+"大小！");
	                    break;
	                case -120:
	                    alert("文件 ["+file.name+"] 大小异常！");
	                    break;
	                case -130:
	                    alert("文件 ["+file.name+"] 类型不正确！");
	                    break;
	            }
	        },
	        'onInit':function() {
	        	$('.uploadify-button-text').css({
	        		'padding':'0px',
	        		'font-weight':''
	        	});
	        },
	        'onSelect':function(){
	        	var name = $('#fileName').val(),
					type = $('#fileType :selected').val();

				if ( name == '' ) {
					alert('请输入文件名！');
					$('#file_upload').uploadify('cancel', '*');
				}
				else if ( type == '' ) {
					alert('请选择文件类型！');
					$('#file_upload').uploadify('cancel', '*');
				}
				else {
					$('#file_upload').uploadify('upload', '*');
				}
	        },
	        //检测FLASH失败调用
	        'onFallback':function(){
	            alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
	        },
	        //上传到服务器，服务器返回相应信息到data里
	        'onUploadSuccess':function(file, data, response){
	            alert(data);
	        }
	    });
	});
	function addFile() {
		var name = $('#fileName').val(),
			type = $('#fileType :selected').val();
	}
	function upload(id) {
		$("#" + id).uploadify("settings", "formData",{'form_inputfile1':'中文','form_inputfile2':'english','form_inputfile3':'123'});
		$("#" + id).uploadify("upload", "*");
	}
</script>
<style>
	#a_uploadify .combox {
		margin-top:2px;
	}
</style>
<div id="a_uploadify" class="pageHeader">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					<label style="width:56px;margin-top:2px;">文件类型：</label>
					<select id="fileType" class="combox" name="province">
						<option value="" selected="selected">-请选择-</option>
						<option value="北京">北京</option>
						<option value="上海">上海</option>
						<option value="天津">天津</option>
						<option value="重庆">重庆</option>
						<option value="广东">广东</option>
					</select>
				</td>
				<td>
					文件名称：<input id="fileName" type="text" style="width:200px;"/>
				</td>
			</tr>
		</table>
	</div>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li>
				<input type="file" name="file_upload" id="file_upload" />
				<div id="fileQueue" style="display:none;"></div>
			</li>
			<li><a class="delete" href="demo/common/ajaxDone.html?uid={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a href="demo/common/ajaxDone.html?uid={sid_user}">
				<span style="background-image:url('images/preview.png');background-position:1px 2px;">查看附件</span></a>
			</li>
			<li>
				<a  href="javascript:upload('file_upload')">上传</a>
				<%--<a  href="javascript:clear('learn_uploadify')">取消上传</a>--%>
			</li>

		</ul>
	</div>
	<table class="table" width="100%" layoutH="90">
		<thead>
			<tr>
				<th width="100">文件类型</th>
				<th width="100">文件名称</th>
				<th>文件路径</th>
				<th width="80">上传人员</th>
				<th width="80">上传时间</th>
			</tr>
		</thead>
		<tbody>
			<tr target="sid_user" rel="1">
				<td>doc</td>
				<td>xxx</td>
				<td>/aa/aaa/aa/aa</td>
				<td>xxx</td>
				<td>2016-11-11</td>
			</tr>
			<tr target="sid_user" rel="1">
				<td>doc</td>
				<td>xxx</td>
				<td>/aa/aaa/aa/aa</td>
				<td>xxx</td>
				<td>2016-11-11</td>
			</tr>
			<tr target="sid_user" rel="1">
				<td>doc</td>
				<td>xxx</td>
				<td>/aa/aaa/aa/aa</td>
				<td>xxx</td>
				<td>2016-11-11</td>
			</tr>
			<tr target="sid_user" rel="1">
				<td>doc</td>
				<td>xxx</td>
				<td>/aa/aaa/aa/aa</td>
				<td>xxx</td>
				<td>2016-11-11</td>
			</tr>
			<tr target="sid_user" rel="1">
				<td>doc</td>
				<td>xxx</td>
				<td>/aa/aaa/aa/aa</td>
				<td>xxx</td>
				<td>2016-11-11</td>
			</tr>
			<tr target="sid_user" rel="1">
				<td>doc</td>
				<td>xxx</td>
				<td>/aa/aaa/aa/aa</td>
				<td>xxx</td>
				<td>2016-11-11</td>
			</tr>
			<tr target="sid_user" rel="1">
				<td>doc</td>
				<td>xxx</td>
				<td>/aa/aaa/aa/aa</td>
				<td>xxx</td>
				<td>2016-11-11</td>
			</tr>
			<tr target="sid_user" rel="1">
				<td>doc</td>
				<td>xxx</td>
				<td>/aa/aaa/aa/aa</td>
				<td>xxx</td>
				<td>2016-11-11</td>
			</tr>
			<tr target="sid_user" rel="1">
				<td>doc</td>
				<td>xxx</td>
				<td>/aa/aaa/aa/aa</td>
				<td>xxx1</td>
				<td>2016-11-11</td>
			</tr>
		</tbody>
	</table>
</div>
