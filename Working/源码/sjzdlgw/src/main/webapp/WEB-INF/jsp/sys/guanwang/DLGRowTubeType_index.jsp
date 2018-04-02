<%--
  Created by IntelliJ IDEA.
  User: hy
  Date: 2016/10/9
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>

    <div class="a-title">
        <div class="a-left"></div>
        <div class="a-right">电缆管</div>
    </div>
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="edit" href="${ctxPath}/TunnelSection/editDLG/{dlg_TunnelSection}?leary=${leary}" target="dialog" rel="TunnelSection_Index_01" warn="请选择一条记录" mask="true" minable="false" max="false" maxable="false" resizable="false" drawable="true" width="400" height="200"><span>修改</span></a></li>
            <li><a class="delete" href="${ctxPath}/TunnelSection/deleteDLG/{dlg_TunnelSection}" target="ajaxTodo" title="确定要删除吗？" warn="请选择一个用户"><span>删除</span></a></li>
            <li class="line">line</li>
        </ul>
    </div>
    <div id="table">
        <table class="list" width="98%" targetType="navTab" asc="asc" desc="desc" layoutH="116">
            <thead>
            <tr>
                <th width="50">位置顺序</th>
                <th width="50">排管规格</th>
            </tr>
            </thead>
            <tbody class="xgzj2_list">
                <c:forEach items="${rowTubePageList}" var="li">
                    <tr target="dlg_TunnelSection" rel="${li.rowTubeNum}">
                        <td>${li.rowTubeOrder}</td>
                        <td>${li.rowTubeTypeName}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

