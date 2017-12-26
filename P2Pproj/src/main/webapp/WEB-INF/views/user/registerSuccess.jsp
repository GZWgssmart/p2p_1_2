<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String name= (String) session.getAttribute("uname");
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>用户注册成功</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="<%=path%>/static/css/common.css" rel="stylesheet" />
    <link href="<%=path%>/static/css/register.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<%=path%>/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/static/js/common.js"></script>
</head>
<body>
<!-- 网站头部-->
<%@include file="../common/header.jsp"%>
<!--注册-->
<div class="wrap">
    <div class="tdbModule register">
        <div class="registerTitle">注册账户</div>
        <div class="registerLc3">
            <p class="p1">填写账户信息</p>
            <p class="p2">验证手机信息</p>
            <p class="p3">注册成功</p>
        </div>
        <div class="registerCont">
            <ul>
                <li class="scses"><%=name%>，恭喜您注册成功！<a class="blue" href="#" target="_blank">请立即开通--双乾支付账户,即可投资！</a></li>
                <li class="rz"><a href="#" class="btn">立即开通</a><a href="#" class="blue">进入我的账户</a></li>
            </ul>
        </div>
    </div>
</div>
<!-- 网站底部-->
<%@include file="../common/footer.jsp" %>
</body>
</html>
