
	$(function() {
		$('#sheb_table>div').click(function() {
			if (!$(this).hasClass('selected')) {
				$('#sheb_table>div').removeClass('selected');
				$(this).addClass('selected');
			}
		});
		setTimeout(function(){
			var _w = $('#a_tdtz .textInput:eq(0)').width();
			$('.tongdao-table .combox').width(_w+6);
			$('.tongdao-table .combox a').width(_w-22);
		},500)
		
	});
	function isSelectNow(obj) {
		if ( obj.length == 0 ) {
			alert('����ѡ��һ���ڵ�');
			return false;
		}
		else {
			return true;
		}
	}
	/*�豸�ն��ƶ���Ļص�����*/
	function sheb_callback(_d) {
		alert(_d);
	}
	/*���¹���Ϣ�ƶ���Ļص�����*/
	function dlg_callback(_d) {
		alert(_d);
	}
	function getSortData(_v) {
		var str = '';
		$('#'+_v).children().each(function(i) {
			str += i + ',' + $(this).attr('id') + ':';
		});
		str = str.substring(0,str.length-1);
		if ( _v == 'sheb_table' ) {
			sheb_callback(str);
		}
		else {
			dlg_callback(str);
		}
	}
	function selectUp(_v) {
		var obj = $('#'+_v).find('.selected');
		if ( isSelectNow(obj) ) {
			obj.prev().before(obj);
			getSortData(_v);
		}
	}
	function selectAllUp(_v) {
		var obj = $('#'+_v).find('.selected');
		if ( isSelectNow(obj) ) {
			obj.parent().prepend(obj);
			getSortData(_v);
		}
	}
	function selectDown(_v) {
		var obj = $('#'+_v).find('.selected');
		if ( isSelectNow(obj) ) {
			obj.next().after(obj);
			getSortData(_v);
		}
	}
	function selectAllDown(_v) {
		var obj = $('#'+_v).find('.selected');
		if ( isSelectNow(obj) ) {
			obj.parent().append(obj);
			getSortData(_v);
		}
	}
