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
//            var url = unescape($this.attr("href")).replaceTmById($(event.target).parents(".unitBox:first"));//update by gaoyulong 动态生成url根据路径中{}生成
            var url = "${ctxPath}/Ledger/fileIsExist/"+ fileNum;
            if (!url.isFinishedTm()) {
                alertMsg.error($this.attr("warn") || DWZ.msg("alertSelectMsg"));
                return false;
            }
//            var url2 = unescape("${ctxPath}/Ledger/download/{s_id}").replaceTmById($(event.target).parents(".unitBox:first"));//update by gaoyulong 动态生成url根据路径中{}生成
            var url2="${ctxPath}/Ledger/download/"+fileNum;
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
                        //url = "${ctxPath}/Ledger/download/{s_id}".replaceTmById($(event.target).parents(".unitBox:first"));
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

    <form action="${ctxPath}/Ledger/uploadTunnelArchivesFile" class="pageForm required-validate" enctype="multipart/form-data" method="post" onsubmit="return iframeCallback(this,callback);">
        <%--<input value="${ledger1.archivesNum}" name="legerCode" type="">--%>
        <input value="${ledger1.archivesNum}" name="legerNum" type="hidden">
        <input value="${ledger1.employeeID}" name="employeeID" type="hidden">

        <div style="overflow:hidden;">
            <label style="float:left;margin:6px 12px 0px 10px;">文件类型：</label>
            <%--<select id="fileType" class="combox" name="archivesFileTypeName">--%>
                <%--<c:forEach items="${typeList1}" var="ob" varStatus="id">--%>
                    <%--<option value="${ob.archivesFileTypeID}" ${ledger1.archivesFileTypeID eq ob.archivesFileTypeID ? 'selected="selected"':''} >${ob.archivesFileTypeName}</option>--%>
                <%--</c:forEach>--%>
            <%--</select>--%>
            <select name="archivesFileTypeName" style="float:left;margin-top:3px;width:220px;">
                <c:forEach items="${typeList1}" var="ob" varStatus="id">
                    <option value="${ob.archivesFileTypeID}" ${ledger1.archivesFileTypeID eq ob.archivesFileTypeID ? 'selected="selected"':''} >${ob.archivesFileTypeName}</option>
                </c:forEach>
            </select>
            <label style="float:left;margin:6px 12px 0px 10px;">文件名称：</label>
            <input style="float:left;width:385px;margin-top:2px;" name="archivesFileName" type="text" class="required"/>
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
    <div><a id="delete" class="delete" href="${ctxPath}/Ledger/deleteTunnelArchivesFile/{s_id}" style="display:none;" callback="dialogAjaxDoneFather" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></div>
    <%--<li><a class="delete" href="/CableDeviceLedger/deletCableDeviceLegerAttament/{sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>--%>
    <%--<div><a  id="download" href="${ctxPath}/Ledger/fileIsExist/"  targetType="dialog" warn="请选择一个文档" title="确定要下载吗？" style="display:none;">--%>
        <%--<span style="background-position:1px 2px;">查看附件</span></a>--%>
    <%--</div>--%>
</div>
<div class="pageContent">
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
        <c:forEach items="${tunnelArchivesFilePages}" var="li">
             <tr target="s_id" rel="${li.archivesFileNum}">
                <td>${li.archivesFileTypeName}</td>
                <td>${li.archivesFileName}</td>
                 <td >
                     <a onclick="uploadClick(${li.archivesFileNum})" href="#">
                    <span>
                            ${li.archivesFilePath}
                    </span>
                     </a>
                 </td>
                <%--<td>${li.archivesFilePath}</td>--%>
                <td>${li.userName}</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${li.archivesFileUpDate}" type="both"/> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>






<!--

<div id="a_uploadify" class="pageHeader">
    <form action="${ctxPath}/Ledger/uploadTunnelArchivesFile" enctype="multipart/form-data" method="post">
    <div class="searchBar">

        <table class="searchContent">
            <tr>
                <td>
                    <input value="${ledger1.archivesCode}" name="legerCode" type="hidden">
                    <input value="${ledger1.archivesNum}" name="legerNum" type="hidden">
                    <input value="${ledger1.employeeID}" name="employeeID" type="hidden">

                    <label style="width:56px;margin-top:2px;">文件类型：</label>
                    <select id="fileType" class="combox" name="archivesFileTypeName">
                        <c:forEach items="${typeList1}" var="ob" varStatus="id">
                            <option value="${ob.archivesFileTypeID}" ${ledger1.archivesFileTypeID eq ob.archivesFileTypeID ? 'selected="selected"':''} >${ob.archivesFileTypeName}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    文件名称：<input id="fileName" type="text" style="width:200px;" name="archivesFileName" value="${ledger1.ArchivesFileName}"/>
                </td>
            </tr>
        </table>

    </div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li>
             <input type="file" name="file_upload" id="file_upload" />
                <div id="fileQueue" style="display:none;"></div>
         <%--       <input name="attachment" type="file" value="添加附件">  --%>
            </li>
            <li><a class="delete" href="demo/common/ajaxDone.html?uid={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
            <li><a href="demo/common/ajaxDone.html?uid={sid_user}">
                <span style="background-image:url('images/preview.png');background-position:1px 2px;">查看附件</span></a>
            </li>
        </ul>
    </div>
</form>



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

        <c:forEach items="${tunnelArchivesPages}" var="li">
            <td><input type="checkbox"class="checkboxCtrl" name="" value=""/></td>
            <td>${li.archivesFileTypeName}</td>
            <td>${li.archivesFileName}</td>
            <td>${li.archivesFilePath}</td>
            <td>${li.userName}</td>
            <td>${li.archivesFileDateStr}</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>


-->