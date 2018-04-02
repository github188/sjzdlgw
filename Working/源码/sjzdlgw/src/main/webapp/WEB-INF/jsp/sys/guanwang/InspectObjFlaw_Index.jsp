<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>

<script>
    <%--console.log(${pageForm.listDatas});--%>
    function dbclick() {
        $("#InSOFDb").click();
    }

</script>
<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/InspectObjFlaw/${teamTypeID}/index" method="post">
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td>
                        缺陷状态：
                        <select name="flawAduitStatusID" class="required combo-box">
                            <option value="" ${flawAduitStatusID==null? 'selected="selected"':''} ></option>

                            <c:forEach items="${flawAduitStatusList}" var="ob" varStatus="id">
                                <option value="${ob.flawAduitStatusID}" ${flawAduitStatusID eq ob.flawAduitStatusID ? 'selected="selected"':''} >${ob.flawAduitStatusName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <div class="subBar">
                            <ul>
                                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
                                <li><div class="buttonActive"><div class="buttonContent"><button type="reset">重置</button></div></div></li>
                            </ul>
                        </div>
                    </td>
                </tr>
            </table>


        </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li controlID="${teamTypeID==1?'2862':teamTypeID==2?'3862':'4862'}"><a id="InSOFDb" class="edit" href="${ctxPath}/InspectObjFlaw/${teamTypeID}/dbadd/{sid_pt}" target="dialog" rel="InspectObjFlaw_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="300"></a></li>

            <li controlID="${teamTypeID==1?'2862':teamTypeID==2?'3862':'4862'}"><a class="add" href="${ctxPath}/InspectObjFlaw/${teamTypeID}/choiceObj/-1" target="dialog" rel="InspectObjFlaw_Index_01" title="缺陷添加" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>添加</span></a></li>
            <li controlID="${teamTypeID==1?'2862':teamTypeID==2?'3862':'4862'}" class="line">line</li>
            <li controlID="${teamTypeID==1?'2862':teamTypeID==2?'3862':'4862'}"><a class="edit" href="${ctxPath}/InspectObjFlaw/${teamTypeID}/add/{sid_pt}" target="dialog" rel="InspectObjFlaw_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="300"><span>修改</span></a></li>
            <li controlID="${teamTypeID==1?'2862':teamTypeID==2?'3862':'4862'}" class="line">line</li>
            <li controlID="${teamTypeID==1?'2864':teamTypeID==2?'3864':'4864'}"><a class="edit" href="${ctxPath}/InspectObjFlaw/${teamTypeID}/Aduit/{sid_pt}" target="dialog" rel="InspectObjFlaw_Index_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="300"><span>缺陷审核</span></a></li>
            <li controlID="${teamTypeID==1?'2864':teamTypeID==2?'3864':'4864'}" class="line">line</li>
            <li controlID="${teamTypeID==1?'2865':teamTypeID==2?'3865':'4865'}"><a class="edit" href="${ctxPath}/InspectObjFlaw/${teamTypeID}/FileView/{sid_pt}" target="dialog" rel="InspectObjFlaw_Index_02_02" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>附件</span></a></li>
            <li controlID="${teamTypeID==1?'2865':teamTypeID==2?'3865':'4865'}" class="line">line</li>
            <li controlID="${teamTypeID==1?'2863':teamTypeID==2?'3863':'4863'}"><a class="delete" href="${ctxPath}/InspectObjFlaw/${teamTypeID}/delete/{sid_pt}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li controlID="${teamTypeID==1?'2863':teamTypeID==2?'3863':'4863'}" class="line">line</li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="113" asc="asc" desc="desc">
        <thead>
        <tr>
            <th orderField="objFlawNum" class="asc" width="40" align="center">序号</th>
            <th width="60">缺陷状态</th>
            <th width="60">对象类型</th>
            <th width="60">对象编号</th>
            <th width="60">对象编码</th>
            <th width=50">有缺陷</th>
            <th width="60">来源类型</th>
            <th width="60">缺陷分类</th>
            <th width="60">缺陷等级</th>
            <th width="60">缺陷描述</th>
            <th width="60">录入时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
            <tr target="sid_pt" rel="${ob.objFlawNum}" ondblclick="dbclick()">
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
                <td>${ob.flawDateStr}</td>
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
