/**
 * Created by tanrong on 16/10/17.
 */
function FlawProcTask_onArchiesDataInput() {
    var objFlawNums=document.getElementById('FlawProcTask_assetNum');
    if(objFlawNums.value!=null&&objFlawNums.value!=undefined){

        console.log(objFlawNums.value);
        $.get("FlawProcTask/${teamTypeID}/getInspectObj?objFlawNum="+objFlawNums.value, function(result){
            console.log(result);
            var resultJson = eval("(" + result + ")");
            var ddd=document.getElementById("FlawProcTask_SelectResultDiv");
            var idInput=document.getElementById("FlawProcTask_objFlawNumList");
            if (ddd!=null){
                var htmlStr="";
                var objIdStr="";
                for( var o in resultJson){
                    var obj=resultJson[o];
                    htmlStr=htmlStr+"<tr>";
                    var isFlawStr="否";
                    if (obj.isFlaw>0){
                        isFlawStr="是";
                    }
                    objIdStr=objIdStr+obj.objFlawNum+",";
                    htmlStr=htmlStr+"<td>"+obj.flawAduitStatusName+"</td>";
                    htmlStr=htmlStr+"<td>"+obj.objTypeEnumName+"</td>";
                    htmlStr=htmlStr+"<td>"+obj.objTableNum+"</td>";
                    htmlStr=htmlStr+"<td>"+obj.objCode+"</td>";
                    htmlStr=htmlStr+"<td>"+isFlawStr+"</td>";
                    htmlStr=htmlStr+"<td>"+obj.flawSourceName+"</td>";
                    htmlStr=htmlStr+"<td>"+obj.flawTypeName+"</td>";
                    htmlStr=htmlStr+"<td>"+obj.flawLevelTypeName+"</td>";
                    htmlStr=htmlStr+"<td>"+obj.flawDescription+"</td>";
                    htmlStr=htmlStr+"<td>"+obj.flawDateStr+"</td>";
                    htmlStr=htmlStr+"</tr>"
                }
                console.log(htmlStr);;
                console.log(ddd);
                if (idInput!=null) {

                    idInput.value=objIdStr;
                }
                ddd.innerHTML=htmlStr;
            }
        });
    }

}
