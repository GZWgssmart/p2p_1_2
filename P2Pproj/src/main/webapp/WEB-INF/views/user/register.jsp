<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>用户注册</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="<%=path%>/static/css/common.css" rel="stylesheet" />
    <link href="<%=path%>/static/css/register.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<%=path%>/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/static/js/common.js"></script>
    <script src="<%=path%>/static/js/login.js" type="text/javascript"></script>
</head>
<body>
<!-- 网站头部-->
<%@include file="../common/header.jsp"%>
<!--注册-->
<div class="wrap">
    <div class="tdbModule register">
        <div class="registerTitle">注册账户</div>
        <div class="registerLc1">
            <p class="p1">填写账户信息</p>
            <p class="p2">验证手机信息</p>
            <p class="p3">注册成功</p>
        </div>
        <div class="registerCont">
            <ul>
                <li><span class="dis">用户名:</span>
                    <input type="text" name="userName" id="userName" class="input _userName" maxlength="24" tabindex="1">
                    <span id="userNameAlt" data-info="6-24个字符，字母开头，字母、数字下划线组成">6-24个字符，字母开头，字母、数字下划线组成</span></li>
                <li><span class="dis">密码:</span>
                    <input type="password" name="user.password" id="password" class="input _password" maxlength="24" tabindex="1">
                    <span id="passwordAlt" data-info="6-24个字符，英文、数字组成，区分大小写">6-24个字符，英文、数字组成，区分大小写</span></li>
                <li><span class="dis">确认密码:</span>
                    <input type="password" name="repeatPassword" id="repeatPassword" class="input _repeatPassword" maxlength="24" tabindex="1">
                    <span id="repeatPasswordAlt" data-info="请再次输入密码">请再次输入密码</span></li>
                <li> <span class="dis">验证码:</span>
                    <input type="text" id="jpgVerify" class="input input1 _yanzhengma" name="yzm" maxlength="4" tabindex="1">
                    <img src="<%=path%>/static/images/code.jpg" alt="验证码" style="cursor:pointer;" id="yzm" class="valign"> <a class="look blue _changeCapcherButton" id="look" href="javascript:void(0);">看不清？换一张</a> <span class="info" id="jpgVerifys" data-info="请输入手机验证码"></span> </li>
                <li class="telNumber"> <span class="dis">手机号码:</span>
                    <input type="text" class="input _phoneNum" id="phone" name="phone" tabindex="1" maxlength="11">
                    <a href="javascript:void(0);" class="button radius1 _getkey" id="sendPhone">获取验证码</a> <span id="phoneJy" data-info="请输入您的常用电话">请输入您的常用电话</span></li>
                <li class="telNumber"><span class="dis">短信验证码:</span>
                    <input id="phonVerify" type="text" class="input input1  _phonVerify" data-_id="phonVerify" tabindex="1">
                    <span class="info" id="phonVerifys" data-info="请输入手机验证码">请输入手机验证码</span></li>
                <li> <span class="dis">推 荐 码:</span>
                    <input type="text" class="input input1 _invist">
                    <span class="_invist_msg">请填写推荐码，如无推荐码请留空</span> </li>
                <li class="agree">
                    <input name="protocol" id="protocol" type="checkbox" value="" checked="checked">
                    我同意《<a href="#" target="_black">亿人宝注册协议</a>》 <span id="protocolAlt" data-info="请查看协议">请查看协议</span></li>
                <li class="btn"><a href="javascript:void(0);" class="radius1 _ajaxSubmit">下一步</a></li>
            </ul>
        </div>
    </div>
</div>
<!-- 网站底部-->
<%@include file="../common/footer.jsp" %>
</body>
</html>

