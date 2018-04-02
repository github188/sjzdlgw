<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>电缆管网信息管理系统2.0</title>
    <link href="${ctx}/static/website/css/login.css" rel="stylesheet" type="text/css" />
    <script src="${ctx}/static/dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
    <script src="${ctx}/static/website/js/login.js" type="text/javascript" ></script>
    <script src="${ctx}/static/jquery/jquery.cookie.js" type="text/javascript" ></script>
    <script src="${ctx}/static/jquery/jquery1.42.min.js" type="text/javascript" ></script>
    <script src="${ctx}/static/jquery/jquery.SuperSlide.2.1.2.js" type="text/javascript" ></script>
    <style>
        .main{
            background-size:cover;
            height:590px;
            padding:0px;
        }
        body{
            overflow-x:hidden;
            overflow-y:auto;
        }
    </style>
</head>

<body>
<div class="header">
</div>
<div class="main">
    <%--图片轮播开始--%>
    <div class="fullSlide">
        <div class="bd">
            <ul>
                <li><img src="${ctx}/static/website/images/login_img1.jpg"/></li>
                <li><img src="${ctx}/static/website/images/login_img2.jpg"  /></li>
                <li><img src="${ctx}/static/website/images/login_img3.jpg"/></li>
            </ul>
        </div>

        <div class="hd"  style="display: none;"><ul></ul></div>

        <a class="prev" href="javascript:void(0)"  style="display: none;"></a>
        <a class="next" href="javascript:void(0)"  style="display: none;"></a>
    </div>
    <%--图片轮播 结束 --%>
    <div class="login_box">
        <div class="litle">登录</div>
        <div class="user-form">
            <div class="note" id="loginPageErrorMsg"></div>
            <div class="form-group">
                <div class="icon"><img src="${ctx}/static/website/images/user.png" /></div>
                <input name="username" type="text" placeholder="用户名" id="login_username"/>
            </div>
            <div class="form-group">
                <div class="icon"><img src="${ctx}/static/website/images/password.png" /></div>
                <input name="userpswd" type="password" placeholder="密码" id="login_userpswd"/>
            </div>
            <div class="form-btn">
                <input type="submit" value="登 录" class="loginbtn" id="login_loginbtn"/>
                <input type="submit" value="重 置" class="regbtn" id="login_regbtn"/>
            </div>
            <h2 id="lable_logining" style="color: red;display: none" >正在登录...</h2>
        </div>
    </div>
</div>


 <%--图片轮播 的js --%>
 <script type="text/javascript">
    jQuery(".fullSlide").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"leftLoop", vis:"auto", autoPlay:true, autoPage:true, trigger:"click" });
</script>


<div class="footer">Copyright©2016 国网河北省石家庄电力公司 All Rights Reserved</div>
<script>
    //登录
    var cookies = document.cookie.split(";");
    for (var i = 0; cookies.length>i; i++) {
        var cookie = cookies[i];
        var eqPos = cookie.indexOf("=");
        var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
        document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT; path=/";
    }
    if(cookies.length > 0)
    {
        for (var i = 0; cookies.length>i; i++) {
            var cookie = cookies[i];
            var eqPos = cookie.indexOf("=");
            var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
            var domain = location.host.substr(location.host.indexOf('.'));
            document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT; path=/; domain=" + domain;
        }
    }

    var COOKIE_NAME = 'username';
    var COOKIE_NAMETWO = 'password' ;
    if( $.cookie(COOKIE_NAME) ){
        $("#login_username").val( $.cookie(COOKIE_NAME) );
        $("#login_userpswd").val( $.cookie(COOKIE_NAME) );
    };
    $("#login_loginbtn").click(function () {
        var username=$("#login_username").val();
        var pswd=$("#login_userpswd").val();
        $.cookie(COOKIE_NAMETWO)?console.log(1):$.cookie(COOKIE_NAMETWO,  pswd, { path: '/', expires: 10 });
        $.cookie(COOKIE_NAME)?console.log(1):$.cookie(COOKIE_NAME,  username, { path: '/', expires: 10 });
    });
    $("#login_regbtn").click(function(){
        $.cookie(COOKIE_NAMETWO)?null:console.log(1);
        $.cookie(COOKIE_NAME)?null:console.log(1);
    })
</script>
</body>
</html>
