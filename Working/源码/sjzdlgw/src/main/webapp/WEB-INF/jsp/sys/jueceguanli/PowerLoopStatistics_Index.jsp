<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="pageNum" value="${pageForm.pageNum}" />
    <input type="hidden" name="numPerPage" value="${pageForm.numPerPage}" />
    <input type="hidden" name="orderField" value="${pageForm.orderField}" />
    <input type="hidden" name="orderDirection" value="${pageForm.orderDirection}" />
</form>
<style>
    .a-searchBar {
        width:100%;
        overflow: hidden;
    }
    .a-searchBar li {
        width:260px;
        height:30px;
        float:left;
    }
</style>
<script type="text/javascript">
	 $(function() {
          $('#isSwitch').click(function(){ 
        	 if(!($(this).attr('checked'))){
        		 $('#db').attr("disabled",true);
        		 $('#db').attr("placeholder","");
      			$('#db0').attr("disabled",true); 
      			$('#db0').attr("placeholder","");
      			$('#db1').attr("disabled",false); 
      			$('#db2').attr("disabled",false); 
        	}
 		/* 	alert('jj');
             alert($(this).attr('checked')); */
         }); 
      
       $('#isSwitch').click(function(){
             if($(this).attr('checked')){

     		    $('#db1').attr("disabled",true); 
 	 			$('#db2').attr("disabled",true); 
 	 			$('#db').attr("disabled",false); 
 	 			
 	 			$('#db0').attr("disabled",false); 
 	 			$('#db').attr("placeholder","输入年份如2016");
 	 			$('#db0').attr("placeholder","输入月份");
                $(':checkbox:checked').not(this).click(); 
            }
         });
     });
</script>

<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="${ctxPath}/PowerLoopStatistics/index" method="post">
        <div class="searchBar">
          
				 <ul class="a-searchBar">
				  <li>
				  <label>线路类型：</label>
            		<select class="combox" name="pathTypeID">
            			<option value="">请选择线路类型</option>
                        <option value="2" ${pathTypeID eq '2' ? 'selected="selected"':''}>配电</option>
                        <option value="3" ${pathTypeID eq '3' ? 'selected="selected"':''}>输电</option>
           		  </select>
           		  </li>
				  <li>
                     <label>电压等级：</label>
	                 <select name="voltageLevelID" class="combox">
	                 		<option value="">请选择电压等级</option>
	                    	<option value="1" ${voltageLevelID eq '1' ? 'selected="selected"':''} >220kv</option>
	                        <option value="2" ${voltageLevelID eq '2' ? 'selected="selected"':''} >110kv</option>
	                        <option value="3" ${voltageLevelID eq '3' ? 'selected="selected"':''} >35kv</option>
	                        <option value="4" ${voltageLevelID eq '4' ? 'selected="selected"':''} >10kv</option>
	                        <option value="5" ${voltageLevelID eq '5' ? 'selected="selected"':''} >6kv</option>
	                </select>
                 </li>
                 <li>
                        投运时间：
                        <input  id ="db1" name="runDateStartStr" type="text"  value="${runDateStartStr}" class="date" size="15" />
                       <!--  <a class="inputDateButton" href="javascript:;" >选择</a> -->
                 </li>
                 <li>
                        至：
                        <input  id ="db2" name="runDateEndStr" type="text"  value="${runDateEndStr}" class="date" size="15" />
                        <!-- <a class="inputDateButton" href="javascript:;">选择</a> -->
                 </li>
                 <li>
                        <input id="isSwitch" type="checkbox" name="isSwitch" ${isSwitch==1?'checked="true"':''} value="1"  /> 按年月
                </li>
				 <li>
				    <%--   年份：<input type="text" id="db" name="runDateYearStr" value="${runDateYearStr}" disabled="true" minlength="1" maxlength="20" size="12"/>
				      --%>     
	                <label>年份：</label>
	                 <select id="db" name="runDateYearStr"  class="combox"">
	                 <option value=""></option>
	                    <c:forEach items="${dateList}" var="ob" varStatus="id">
	                        <option value="${ob.year}" ${ob.year eq runDateYearStr ? 'selected="selected"':''} >${ob.year}</option>
	                    </c:forEach>
	                </select>
                </li>
                <li>
				    <%-- 月份：<input type="text" id="db0" name="runDateMonthStr" value="${runDateMonthStr}" disabled="true" minlength="1" maxlength="20" size="12"/>
              	--%> 
                
                <label>月份：</label>
	                 <select name="runDateMonthStr" class="combox">
	                 		<option value=""></option>
	                    	<option value="1" ${runDateMonthStr eq '1' ? 'selected="selected"':''} >01</option>
	                        <option value="2" ${runDateMonthStr eq '2' ? 'selected="selected"':''} >02</option>
	                        <option value="3" ${runDateMonthStr eq '3' ? 'selected="selected"':''} >03</option>
	                        <option value="4" ${runDateMonthStr eq '4' ? 'selected="selected"':''} >04</option>
	                        <option value="5" ${runDateMonthStr eq '5' ? 'selected="selected"':''} >05</option>
	                        <option value="6" ${runDateMonthStr eq '6' ? 'selected="selected"':''} >06</option>
	                        <option value="7" ${runDateMonthStr eq '7' ? 'selected="selected"':''} >07</option>
	                        <option value="8" ${runDateMonthStr eq '8' ? 'selected="selected"':''} >08</option>
	                        <option value="9" ${runDateMonthStr eq '9' ? 'selected="selected"':''} >09</option>
	                        <option value="10" ${runDateMonthStr eq '10' ? 'selected="selected"':''} >10</option>
	                        <option value="11" ${runDateMonthStr eq '11' ? 'selected="selected"':''} >11</option>
	                        <option value="12" ${runDateMonthStr eq '12' ? 'selected="selected"':''} >12</option>
	                </select>
                </li>
                <li>
                	<div class="buttonActive"><div class="buttonContent"><button type="submit">生成报表</button></div></div>
                 </li>
               
                </ul>
        </div>
    </form>
</div>
<div class="pageContent">
<c:if test="${ not empty powerLoopStatisticsPageSearch}">
    <div class="panelBar">
        <ul class="toolBar">
          <li controlID="6620"><a class="icon" href="${ctxPath}/PowerLoopStatistics/Export/excel" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>查询导出</span></a></li>
         </ul>
    </div>
     
    <table class="table" width="100%" layoutH="138" asc="asc" desc="desc">
        <thead>
            <tr>
            	<th>电压等级</th>
            	<th>回路数</th>
            	<th>回路长度（千米）</th>
            	<th>总长度（千米）</th>
            	<th>条数</th>
            	
            </tr>
        </thead>
        <tbody>
       <c:forEach items="${powerLoopStatisticsPageSearch}" var="ob" varStatus="vs">
            <tr>
                <%-- <td>${vs.index+1}</td> --%>
                <td>${ob.voltageLevelName}</td>
	        	<td>${ob.loopCount}</td>
	        	<td>${ob.loopLength}</td>
	        	<td>${ob.totalLength}</td>
	        	<td>${ob.lineCount}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </c:if>
</div>
