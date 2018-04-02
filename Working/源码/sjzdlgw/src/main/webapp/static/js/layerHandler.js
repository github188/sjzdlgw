var layerHandler = {

	alert : function(){
		layer.alert('有了回调', function(index){
		  //do something
		  layer.close(index);
		});  
	},
	confirm : function(content, yesHandler) {
		// 询问框
		layer.confirm(content, {
			offset : '200px',
			btn : [ '确认', '取消' ]
		// 按钮
		}, function(index) {
			if (yesHandler) {
				yesHandler(index);
			}
			layer.close(index);
		}, function(index) {
			layer.close(index);
		});
	},
	
	openWindow : function(field, title, okHandler, autoClose) {
		
		layer.open({
			title : title,
			skin : 'layer-ext-myskin',
			//skin : 'demo-class',
			closeBtn : 1,
			type : 1,
			area : [ '700px', '400px' ],
			offset : '50px',
			scrollbar : false,
			shade : [ 0.4, '#393D49' ],
			content : $(field),
			btn : [ '确认', '取消' ], // 可以无限个按钮
			yes : function(index, layero) {
				// 按钮【按钮一】的回调
				if (okHandler) {
					okHandler(index);
				}
				if(!autoClose){
					layer.close(index);
				}
			}
		});
	},
	
	prompt : function(title, success){
		layer.prompt({
			title : title,
			offset : '50px',
		}, success);
	},
	alertSuccess : function(msg, title) {
		layer.alert(msg, {
			title : title ? title : "提示", 
			icon : 1,
			offset : '50px',
			skin : 'layer-ext-moon'
		})
	},
	
	alertWarm : function(msg, title){
		layer.alert(msg, {
			title : title ? title : "提示",
			icon : 0,
			offset : '50px',
			skin : 'layer-ext-moon'
		})		
	},
	
	open : function(options) {
		var opt = {
			title : "title",
			skin : 'layer-ext-myskin',
			//skin : 'demo-class',
			closeBtn : 1,
			type : 1,
			area : [ '700px', '400px' ],
			offset : '50px',
			scrollbar : false,
			shade : [ 0.4, '#393D49' ],
			btn : [ '确认', '取消' ] // 可以无限个按钮
			
		};
		$.extend(true, opt, options);
		
		layer.open(opt);
	},
	

	
	
	showMessage : function(msg, title, msgType){
		title = title ? title : "操作信息提示";
		
		var type = msgType == "success" ? "alert-success " : (msgType == "warn" ? "alert-warning " : (msgType == "info" ? "alert-info  " : "alert-danger"));
		
		var str = '';
		str += '<div class="alert '+type+' fade in">';
		str += '	<button data-dismiss="alert" class="close" type="button">×</button>';
		str += '	<strong>'+title+'</strong> <br>' + msg;
		str += '</div>';

		$("#messageDiv").append(str);
		
		setTimeout(function(){
			$("#messageDiv").empty();
		}, 2000)
		
		/*
		 <div class="alert alert-warning fade in" id="messageDiv" style="display: none;">
						<button data-dismiss="alert" class="close" type="button">×</button>
						<strong>操作信息提示</strong> <br> 显示屏修改（新增、删除）成功！
					</div>
		 */
	}

};