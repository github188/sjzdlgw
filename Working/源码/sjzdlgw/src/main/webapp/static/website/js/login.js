$(function () {
    //登录
    // 获取用户名和密码输入框
    var user = $("[name=username],[name=userpswd]");

    function validate(){
        var username=$("#login_username").val();
        var pswd=$("#login_userpswd").val();

        var error1=0;
        var error2=0;

        if(username.length<1){
            error1=1;
        }
        if (pswd.length<1){
            error2=1;
        }
        if(error1==1 && error2==1){
            $("#loginPageErrorMsg").html("用户名/密码，不能为空！");
            return false;
        }else if (error1==1 && error2==0){
            $("#loginPageErrorMsg").html("用户名不能为空！");
            return false;
        }else if (error2==1 && error1==0){
            $("#loginPageErrorMsg").html("密码不能为空！");
            return false;
        }else if(error1==0 && error2==0){
            $("#loginPageErrorMsg").html("");
            return false;
        }

        return false;
    }

    user.each(function(){
        $(this).change(function () {
            validate();
        })
    });

    $("#login_loginbtn").click(function () {
        var username=$("#login_username").val();
        var pswd=$("#login_userpswd").val();

        var error1=0;
        var error2=0;

        if(username.length<1){
            error1=1;
        }
        if (pswd.length<1){
            error2=1;
        }
        if (error1==0 && error2==0){
            $.post("/login",{uname:$.trim(username),upswd:$.trim(pswd)},function (msg) {
                if (msg.statusCode=="200"){//正常
                    // $("#login_username").val("");
                    // $("#login_userpswd").val("");
                    setTimeout(function(){
                        $('#lable_logining').hide();
                    },50);
                    location.href ="/index";
                }else if (msg.statusCode=="300"){
                    setTimeout(function(){
                        $('#lable_logining').hide();
                    },0);
                    alert(msg.message);
                }
            },"json");
            $('#lable_logining').show();
        }
    });

    
    //重置
    $("#login_regbtn").click(function () {
        $("#login_username").val("");
        $("#login_userpswd").val("");
        return true;
    });
    $(document).keyup(function (e) {//捕获文档对象的按键弹起事件
        if (e.keyCode == 13) {//按键信息对象以参数的形式传递进来了
            //此处编写用户敲回车后的代码
            $("#login_loginbtn").click();
            // alert("回车");
        }
    });
});