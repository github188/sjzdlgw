<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
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
<style>
    #a_uploadify .combox {
        margin-top:2px;
    }
</style>
<script>
//    $(document).ready(function(){
        function _doExport($this,fileNum) {
            var $p = $this.attr("targetType") == "dialog" ? $.pdialog.getCurrent() : navTab.getCurrentPanel();
            var $form = $("#pagerForm", $p);
            // var url = $this.attr("href");
            //var url = unescape($this.attr("href")).replaceTmById($(event.target).parents(".unitBox:first"));//update by gaoyulong 动态生成url根据路径中{}生成
            var url = "${ctxPath}/FlawProcTask/fileIsExist/"+fileNum;
            if (!url.isFinishedTm()) {
                alertMsg.error($this.attr("warn") || DWZ.msg("alertSelectMsg"));
                return false;
            }
            //var url2 = unescape("${ctxPath}/FlawProcTask/${teamTypeID}/download/{sid_pt}").replaceTmById($(event.target).parents(".unitBox:first"));//update by gaoyulong 动态生成url根据路径中{}生成
            var url2="${ctxPath}/FlawProcTask/${teamTypeID}/download/"+fileNum;
            var title = $this.attr("title");
            if (title) {
                alertMsg.confirm(title, {
                    okCall: function(){ sendAjax();}
                });
            } else {sendAjax();}
            function sendAjax() {
                $.ajax({
                    url: url,
                    success: successfunction,
                });
            }
//            $.ajax({
//                url: url,
//                success: successfunction,
//            });
            function successfunction(response) {
                function strToJson(str){
                    var json = eval('(' + str + ')');
                    return json;
                }
                if(response)
                {
                    var obj = strToJson(response)
                    if(obj.isExist=="true")
                    {
                        //url = "${ctxPath}/FlawProcTask/download/{sid_pt}".replaceTmById($(event.target).parents(".unitBox:first"));
                        window.location = url2+(url2.indexOf('?') == -1 ? "?" : "&")+$form.serialize();
                    }
                    else
                        alertMsg.error("服务器中该文件不存在，请上传后再下载");
                }
            }
        }
        function uploadClick(fileNum) {
            var $this = $(this);
            var title = $this.attr("title");
            if (false) {
                alertMsg.confirm(title, {
                    okCall: function(){_doExport($this,fileNum);}
                });
            } else {_doExport($this,fileNum);}
            event.preventDefault();
        }
//        $("#download").bind("click",function(event){
//            var $this = $(this);
//            var title = $this.attr("title");
//            if (false) {
//                alertMsg.confirm(title, {
//                    okCall: function(){_doExport($this);}
//                });
//            } else {_doExport($this);}
//            event.preventDefault();
//        });
//    });
    function callback(json) {
        DWZ.ajaxDone(json);
        if (json.statusCode == DWZ.statusCode.ok) {
            if (json.navTabId) {
                var dialog = $("body").data(json.navTabId);
                $.pdialog.reload(dialog.data("url"), { data: {}, dialogId: json.navTabId, callback: null })
            }
            if ("closeCurrent" == json.callbackType) {
                $.pdialog.closeCurrent();
            }
        }
    }
    console.log(navTab.getCurrentPanel());
</script>
<div id="a_uploadify">

    <form action="${ctxPath}/FlawProcTask/${teamTypeID}/File" class="pageForm required-validate" enctype="multipart/form-data" method="post" onsubmit="return iframeCallback(this,callback);">
        <input value="${FlawProcTask}" name="flawProcObj" type="hidden">
        <input value="" name="fileMemo" type="hidden">
        <div style="overflow:hidden;">
            <%--<label style="float:left;margin:6px 12px 0px 10px;">文件类型：</label>--%>
            <%--<select name="archivesFileTypeID" style="float:left;margin-top:3px;width:220px;">--%>
                <%--<c:forEach items="${FileTypeList}" var="ob" varStatus="id">--%>
                    <%--<option value="${ob.archivesFileTypeID}"  >${ob.archivesFileTypeName}</option>--%>
                <%--</c:forEach>--%>
            <%--</select>--%>
            <label style="float:left;margin:6px 12px 0px 10px;">文件名称：</label>
            <input style="float:left;width:640px;margin-top:2px;" name="procAdjunctFile" type="text" class="required"/>
        </div>
        <div style="margin-top:5px;height:30px;">
            <label style="float:left;margin:5px 12px 0px 10px;">文件路径：</label> <input id="fileUpload" style="display:none;" name="attachment" type="file" onchange="selectFile();" value="请选择文件">
            <input style="float:left;background:#fff;width: 640px;" id="file_input" type="text" readonly="readonly"/>
            <input type="button" style="margin-left:5px;" onclick="openUpload()" value="选择">
        </div>
        <div style="height:35px;">
            <%--<input style="float:right;margin-right:13px;" type="button"  onclick="download()" value="查看附件">--%>
            <input style="float:right;margin-right:5px;" type="button"  onclick="del()" value="删除附件">
            <input style="float:right;margin-right:5px;"  type="submit"  value="上传附件">
        </div>

        <script>
            function openUpload() {
                $('#fileUpload').click();
                return false;
            }
            function selectFile() {
                $('#file_input').val($('#fileUpload').val());
            }
            $(function() {

            });
            function del(){
                $('#delete').click();
                return false;
            }
            function download() {
                $('#download').click();
                return false;
            }
        </script>
    </form>
    <div><a id="delete" class="delete" href="${ctxPath}/FlawProcTask/${teamTypeID}/File/delete/{sid_pt}" style="display:none;" callback="dialogAjaxDoneFather" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></div>
    <%--<li><a class="delete" href="/CableDeviceLedger/deletCableDeviceLegerAttament/{sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>--%>
    <div><a  id="download" href="${ctxPath}/FlawProcTask/fileIsExist/{sid_pt}"  targetType="dialog" warn="请选择一个文档" title="确认要下载吗？" style="display:none;">
        <span style="background-position:1px 2px;">查看附件</span></a>
    </div>
</div>
<div class="pageContent">
    <table class="table" layoutH="118" targetType="ajaxTodo" width="100%">
        <thead>
        <tr>
            <th>资料名称</th>
            <th>上传人员</th>
            <th>上传时间</th>
            <th>文件路径</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${FileList}" var="li">
            <tr target="sid_pt" rel="${li.fileNum}">
                <td>${li.procAdjunctFile}</td>
                <td>${li.employeeName}</td>
                <td>${li.updateDateStr}</td>
                <td >
                    <a onclick="uploadClick(${li.fileNum})" href="#">
                    <span>
                            ${li.filePath}
                    </span>
                    </a>
                </td>
                <%--<td>${li.filePath}</td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!--
    <div class="panel">
        <form action="${ctxPath}/FlawProcTask/File?num={sid_pt}"  enctype="multipart/form-data" method="post" >
            <input value="${FlawProcTask}" name="flawProcObj" type="hidden">
            <input value="" name="fileMemo" type="hidden">
            <p>
                <label>文件名称：</label>
                <input name="procAdjunctFile"  type="text" size="30" alt="请输入文件名称"  />
            </p>
            <p>
                <label>选择文件：</label>
                <input name="attachment" type="file" value="请选择文件">
            </p>
            <input type="submit" value="上传">
            <input type="reset" value="取消">

        </form>
    </div>
    -->
</div>
