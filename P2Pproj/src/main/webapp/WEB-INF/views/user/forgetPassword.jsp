<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>用户登录</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="<%=path%>/static/css/common.css" rel="stylesheet" />
    <link href="<%=path%>/static/css/register.css" rel="stylesheet" type="text/css">

    <script type="text/javascript" src="<%=path%>/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/static/js/common.js"></script>
    <script src="<%=path%>/static/js/login.js" type="text/javascript"></script>

    <!--弹出框样式-->
    <link rel="stylesheet" href="<%=path%>/static/css/lyj/sweetalert.css"/>
    <script type="text/javascript" src="<%=path%>/static/js/lyj/sweetalert-dev.js"></script>

    <!--验证码框-->
    <link rel="stylesheet" href="<%=path%>/static/css/lyj/zzsc.css"/>

</head>
<body>
<%@include file="../common/header.jsp"%>
<!--注册-->
<div class="wrap">
    <form id="loginForm" name="loginForm" action="" method="post">
        <div class="tdbModule loginPage">
            <div class="registerTitle">用手机验证码登录</div>
            <div class="registerCont">
                <ul>
                    <li class="error">
                        <span id="prrintInfo" data-info=""><span>请输入正确手机号</span></span>
                    </li>
                    <li>
                        <span class="dis">手机号码：</span><input class="input" type="text" name="phone" id="phone" onblur="checkPhone();" maxlength="11" tabindex="1" autocomplete="off">
                        <a id="sssdfasdfas" href="<%=path%>/page/register" class="blue">注册用户</a>
                    </li>

                    <li>
                        <span class="dis">验证码：</span><input type="text" onblur="checkyzm()" onkeyup="verify(this)" id="code" style="width:166px;" class="input" name="code" data-msg="验证码" maxlength="6" tabindex="1" autocomplete="off"/>

                        <input type="button" value="获取手机验证码" id="vcode" onclick="getPhoneCode()"  style="width: 120px;height: 28px; color:black" >

                    </li>
                    <li class="btn">
                        <input type="button" class="radius1" value="立即登录" id="submitBtn" onclick="login()">
                    </li>
                </ul>
            </div>
        </div>
    </form>
</div>
<!--网站底部-->
<div id="footer" class="ft">
    <div class="ft-inner clearfix">
        <div class="ft-helper clearfix">
            <dl>
                <dt>关于我们</dt>
                <dd><a href="../index/about.jsp">公司简介</a><a href="../index/managerTuandui.jsp">管理团队</a><a href="网站公告.html">网站公告</a></dd>
            </dl>
            <dl>
                <dt>相关业务</dt>
                <dd><a href="../index/list.jsp">我要投资</a><a href="../index.jsp">我要借款</a></dd>
            </dl>
            <dl>
                <dt>帮助中心</dt>
                <dd><a href="../index/help.jsp">新手入门</a><a href="userindex.jsp">我的账户</a><a href="list.html">债权转让</a></dd>
            </dl>
            <dl>
                <dt>联系我们</dt>
                <dd><a href="../index/contract.jsp">联系我们</a></dd>
            </dl>
        </div>
        <div class="ft-service">
            <dl>
                <dd>
                    <p><strong>400-660-1268</strong><br>
                        工作日 9:00-22:00<br>
                        官方交流群:<em>12345678</em><br>
                        工作日 9:00-22:00 / 周六 9:00-18:00<br>
                    </p>
                    <div class="ft-serv-handle clearfix"><a class="icon-hdSprite icon-ft-sina a-move a-moveHover" title="亿人宝新浪微博" target="_blank" href="#"></a><a class="icon-hdSprite icon-ft-qqweibo a-move a-moveHover" title="亿人宝腾讯微博" target="_blank" href="#"></a><a class="icon-ft-qun a-move a-moveHover" title="亿人宝QQ群" target="_blank" href="#"></a><a class="icon-hdSprite icon-ft-email a-move a-moveHover mrn" title="阳光易贷email" target="_blank" href="mailto:xz@yirenbao.com"></a></div>
                </dd>
            </dl>
        </div>
        <div class="ft-wap clearfix">
            <dl>
                <dt>官方二维码</dt>
                <dd><span class="icon-ft-erweima"><img src="<%=path%>/static/images/code.png" style="display: inline;"></span></dd>
            </dl>
        </div>
    </div>
    <div class="ft-record">
        <div class="ft-approve clearfix"><a class="icon-approve approve-0 fadeIn-2s" target="_blank" href="#"></a><a class="icon-approve approve-1 fadeIn-2s" target="_blank" href="#"></a><a class="icon-approve approve-2 fadeIn-2s" target="_blank" href="#"></a><a class="icon-approve approve-3 fadeIn-2s" target="_blank" href="#"></a></div>
        <div class="ft-identity">©2017 亿人宝 All rights reserved&nbsp;&nbsp;&nbsp;<span class="color-e6">|</span>&nbsp;&nbsp;&nbsp;安徽省亿人宝投资管理有限公司&nbsp;&nbsp;&nbsp;<span class="color-e6">|</span>&nbsp;&nbsp;&nbsp;<a target="_blank" href="http://www.miitbeian.gov.cn/">皖ICP备12345678号-1</a></div>
    </div>
</div>
</body>

<!--引用登录js-->
<%--<script type="text/javascript" src="<%=path%>/static/js/lyj/userlogin.js"></script>--%>

<!--手机验证码-->
<script type="text/javascript" src="<%=path%>/static/js/lyj/sms.js"></script>

</html>
