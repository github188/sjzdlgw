<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
</form>
<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/ManholeLaborWell/index" method="post">
        <input type="hidden" name="idNum" value="${Tunnel_AssetNum_ManholeLaborWell}" />
        <div class="searchBar">
            <table class="searchContent">
                <tr>
                    <td>
                        工井编号:<input type="text" name="assetCode" value="${manholeOfTunnelPage.assetCode}" maxlength="15"/>
                    </td>
                    <td>
                        运行编号:<input type="text" name="operationCode" value="${manholeOfTunnelPage.operationCode}" maxlength="15"/>
                    </td>
                </tr>
            </table>

            <div class="subBar">
                <ul>
                    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
                    <li><div class="buttonActive"><div class="buttonContent"><button type="reset">重置</button></div></div></li>
                </ul>
            </div>
        </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <c:if test="${Tunnel_AssetNum_ManholeLaborWell != null}">
            <li><a id="manholeLaborWellView" style="display: none;" class="edit" href="${ctxPath}/ManholeLaborWell/index/{sid_tst}?tunnel_AssetNum=${Tunnel_AssetNum_ManholeLaborWell}&archivesCode=${ARCHIVESCODE}&assetCode=${ASSETCODE}" target="dialog" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>修改</span></a></li>

            <li controlID="2021"><a id="addManhole" class="add" ><span>添加</span></a></li>
            <li controlID="2021" style="display: none"><a class="add" id="addManholeLaborWell" href="${ctxPath}/ManholeLaborWell/add/-1?orderAsset={sid_tst}&tunnel_AssetNum=${Tunnel_AssetNum_ManholeLaborWell}&archivesCode=${ARCHIVESCODE}&assetCode=${ASSETCODE}" warn="请选择要插入旁边的工井" target="dialog"  title="添加工井台账" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>添加</span></a></li>
            <li controlID="2021" class="line">line</li>
            <li controlID="2021"><a class="edit" href="${ctxPath}/ManholeLaborWell/add/{sid_tst}?tunnel_AssetNum=${Tunnel_AssetNum_ManholeLaborWell}&archivesCode=${ARCHIVESCODE}&assetCode=${ASSETCODE}" target="dialog" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="800" height="600"><span>修改</span></a></li>
            <li controlID="2021" class="line">line</li>
            <li controlID="2022"><a class="delete" href="${ctxPath}/ManholeLaborWell/delete/{sid_tst}/${Tunnel_AssetNum_ManholeLaborWell}" target="ajaxTodo" title="确定要删除吗?" warn="请选择一条记录"><span>删除</span></a></li>
            <li controlID="2022" class="line">line</li>
            </c:if>
            <li controlID="2023"><a class="icon" href="${ctxPath}/ManholeLaborWell/Export/excel" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
        </ul>
    </div>
    <table class="table sortDrag" width="2000" layoutH="138">
        <thead>
        <tr>
            <th width="10">序号</th>
            <th width="40">档案编号</th>
            <th width="50">通道编号</th>
            <th width="50">工井编号</th>
            <th width="80">运行编号</th>
            <%--<th width="60">所属片区</th>--%>
            <%--<th width="60">所属变电站</th>--%>
            <th width="60">运检班组</th>
            <th width="40">设施</th>
            <th width="40">类型</th>
            <th width="500">位置</th>
            <th width="40">尺寸</th>
            <th width="40">平台层数</th>
            <th width="40">地面高程</th>
            <th width="40">井底高程</th>
            <th width="40">材质</th>
            <th width="40">经度</th>
            <th width="40">纬度</th>
            <th width="40">设施材质</th>
            <th width="40">设施形状</th>
            <th width="40">录入人</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageForm.listDatas}" var="ob" varStatus="vs">
            <tr target="sid_tst" rel="${ob.assetNum}" ondblclick="dbclick()">
                <td>${vs.index+1}</td>
                <td>${ob.archivesCode}</td>
                <td>${ob.tunnelAssetCode}</td>
                <td>${ob.assetCode}</td>
                <td>${ob.operationCode}</td>
                <%--<td>${ob.tunnelAreaName}</td>--%>
                <%--<td>${ob.baseFacilityName}</td>--%>
                <td>${ob.organizationName}</td>
                <td>${ob.manholeCoverTypeName}</td>
                <td>${ob.manholeKindTypeName}</td>
                <td>${ob.positionDescription}</td>
                <td>${ob.length}*${ob.width}</td>
                <td>${ob.terraceLayerCount}</td>
                <td>${ob.height}</td>
                <td>${ob.bottomHeight}</td>
                <td>${ob.manholeStuffTypeName}</td>
                <td>${ob.longitude}</td>
                <td>${ob.latitude}</td>
                <td>${ob.coverStuffTypeName}</td>
                <td>${ob.coverShapeTypeName}</td>
                <td>${ob.employeeName}</td>
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
<script type="text/javascript">
    function dbclick() {
        $("#manholeLaborWellView").click();
    }
    $(function() {
        var options = {
            cursor: 'move', // selector 的鼠标手势
            sortBoxs: 'tbody.sortDrag', //拖动排序项父容器
            replace: true, //2个sortBox之间拖动替换
            items: '> tr', //拖动排序项选择器
            selector: 'td:first', //拖动排序项用于拖动的子元素的选择器，为空时等于item
            zIndex: 1000
        };
        $('tbody', navTab.getCurrentPanel()).sortDrag(options);
    });
    $("#addManhole").bind("click",function(event){
        console.info("addManhole...............1");
        $this=document.getElementById("addManholeLaborWell");
        console.info("addManhole...............2");
//        var a=1;
//        while(a==1);
        var url = unescape($this.getAttribute("href")).replaceTmById($(event.target).parents(".unitBox:first"));
//        DWZ.debug(url);
        console.info("addManhole...............3");
        if (!url.isFinishedTm()) {
            alertMsg.error($this.getAttribute("warn") || DWZ.msg("alertSelectMsg"));
            return false;
        }
        alertMsg.confirm("您想插入该工井的前面还是后面？",{
            okName:"前面",
            cancelName:"后面",
            okCall:function () {
//                alertMsg.correct("成功插前面！！");
                var url="${ctxPath}/ManholeLaborWell/add/-1?orderType=ahead&orderAsset={sid_tst}&tunnel_AssetNum=${Tunnel_AssetNum_ManholeLaborWell}&archivesCode=${ARCHIVESCODE}&assetCode=${ASSETCODE}";
                $this.setAttribute("href",url);
                document.getElementById("addManholeLaborWell").click();
            },
            cancelCall:function () {
//                alertMsg.correct("成功插后面！！");
                var url="${ctxPath}/ManholeLaborWell/add/-1?orderType=behind&orderAsset={sid_tst}&tunnel_AssetNum=${Tunnel_AssetNum_ManholeLaborWell}&archivesCode=${ARCHIVESCODE}&assetCode=${ASSETCODE}";
                $this.setAttribute("href",url);
                document.getElementById("addManholeLaborWell").click();
            }
        });
    });
    <%--function addManhole(event) {--%>
        <%--console.info("addManhole...............1");--%>
        <%--$this=document.getElementById("addManholeLaborWell");--%>
        <%--console.info("addManhole...............2");--%>
<%--//        var a=1;--%>
<%--//        while(a==1);--%>
        <%--var url = unescape($this.getAttribute("href")).replaceTmById($(event.target).parents(".unitBox:first"));--%>
<%--//        DWZ.debug(url);--%>
        <%--console.info("addManhole...............3");--%>
        <%--if (!url.isFinishedTm()) {--%>
            <%--alertMsg.error($this.getAttribute("warn") || DWZ.msg("alertSelectMsg"));--%>
            <%--return false;--%>
        <%--}--%>
        <%--alertMsg.confirm("您想插入该工井的前面还是后面？",{--%>
            <%--okName:"前面",--%>
            <%--cancelName:"后面",--%>
            <%--okCall:function () {--%>
<%--//                alertMsg.correct("成功插前面！！");--%>
                <%--var url="${ctxPath}/ManholeLaborWell/add/-1?orderType=ahead&orderAsset={sid_tst}&tunnel_AssetNum=${Tunnel_AssetNum_ManholeLaborWell}&archivesCode=${ARCHIVESCODE}&assetCode=${ASSETCODE}";--%>
                <%--$this.setAttribute("href",url);--%>
                <%--document.getElementById("addManholeLaborWell").click();--%>
            <%--},--%>
            <%--cancelCall:function () {--%>
<%--//                alertMsg.correct("成功插后面！！");--%>
                <%--var url="${ctxPath}/ManholeLaborWell/add/-1?orderType=behind&orderAsset={sid_tst}&tunnel_AssetNum=${Tunnel_AssetNum_ManholeLaborWell}&archivesCode=${ARCHIVESCODE}&assetCode=${ASSETCODE}";--%>
                <%--$this.setAttribute("href",url);--%>
                <%--document.getElementById("addManholeLaborWell").click();--%>
            <%--}--%>
        <%--});--%>
<%--//        document.getElementById("addManholeLaborWell").click();--%>
    <%--}--%>
</script>