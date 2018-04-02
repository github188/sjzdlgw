/**
 * Created by tanrong on 16/10/17.
 */
function InspectTask_onArchiesDataInput(value) {
    var input=document.getElementById('InspectTask_archivesNum');
    var assetNums=document.getElementById('InspectTask_assetNum');
    var taskNum=document.getElementById('InspectTask_taskNum');
    if(input.value!=null&&input.value!=undefined&&assetNums.value!=null&&assetNums.value!=undefined
    &&taskNum.value!=null||taskNum.value!=""){

        console.log(input.value);
        console.log(assetNums.value);
        console.log(taskNum.value)
        $.get("InspectTask/getArchivesObject?assetNum="+assetNums.value+"&archivesNum="+input.value+"&taskNum="+taskNum.value, function(result){
            console.log(result);
            var resultJson = eval("(" + result + ")");
            var ddd=document.getElementById("InspeactTask_SelectResultDiv");
            if (ddd!=null){

                ddd.innerHTML=resultJson.html;
            }
            var inp=document.getElementById("InspectTask_assetValues");
            if (inp!=null){
                inp.value=resultJson.value;
            }
        });
    }

}
