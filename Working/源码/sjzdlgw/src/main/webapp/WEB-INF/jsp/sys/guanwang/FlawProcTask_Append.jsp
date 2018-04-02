<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>

<div class="pageContent">
    <div class="a-title">
        <div class="a-left"></div>
        <div class="a-right">录入任务</div>
    </div>
    <div class="panelBar">

        <ul class="toolBar" style="display: ${IsNew==1?"none":""}">
            <li><a class="add" href="${ctxPath}/FlawProcTask/${teamTypeID}/appendObj/{sid_tst}" target="dialog" rel="InspectTask_Append_01" title="录入消缺记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="300"><span>录入消缺记录</span></a></li>
            <li class="line">line</li>
            <li controlID="${teamTypeID==1?'2849':teamTypeID==2?'3849':'4849'}"><a class="edit" href="${ctxPath}/FlawProcTask/${teamTypeID}/FileView/{sid_tst}" target="dialog" rel="InspectTask_Append_02" title="上传附件" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>附件</span></a></li>
            <li class="line">line</li>
            <li><a class="edit" href="${ctxPath}/FlawProcTask/${teamTypeID}/append/${FlawProcTask}" target="ajaxTodo" onsubmit="return dwzSearch(this,'dialog');" rel="InspectTask_Append_03"><span>确定完成任务</span></a></li>
            <li class="line">line</li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138" asc="asc" desc="desc">
        <thead>
        <tr>
            <th orderField="objFlawNum" class="asc" width="40" align="center">序号</th>
            <th width="60">缺陷状态</th>
            <th width="60">对象类型</th>
            <th width="60">对象编号</th>
            <th width="60">对象编码</th>
            <th width="50">有缺陷</th>
            <th width="60">来源类型</th>
            <th width="60">缺陷分类</th>
            <th width="60">缺陷等级</th>
            <th width="60">缺陷描述</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${FlawProcTaskObjList}" var="ob" varStatus="vs">
            <tr target="sid_tst" rel="${ob.flawProcObj}">
                <td>${vs.index+1}</td>
                <td>${ob.flawAduitStatusName}</td>
                <td>${ob.objTypeEnumName}</td> <%--通道编号---%>
                <td>${ob.objTableNum}</td> <%--运行编号---%>
                <td>${ob.objCode}</td>  <%--所属变电站---%>
                <td>${ob.isFlaw>0?"是":"否"}</td>
                <td>${ob.flawSourceName}</td>
                <td>${ob.flawTypeName}</td>
                <td>${ob.flawLevelTypeName}</td>
                <td>${ob.flawDescription}</td>
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
<script>
   $(".buttonActive .buttonContent button").click(function(){
       $('.dialog').hide();
       $('#alertBackground').hide();
       $("#dialogBackground").hide();
       $("#background").hide();
       $('.shadow').css("opacity",0).hide();
   });
</script>