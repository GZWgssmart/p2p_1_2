<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>红包兑换历史</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="<%=path%>/static/css/common.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/user.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/jquery.datetimepicker.css"/>
    <script type="text/javascript" src="<%=path%>/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/static/js/common.js"></script>
    <script src="<%=path%>/static/js/user.js" type="text/javascript"></script>
</head>
<body>
<!-- 网站头部-->
<%@include file="../common/header.jsp"%>
<!--个人中心-->
<div class="wrapper wbgcolor">
    <div class="w1200 personal">
        <div class="credit-ad"><img src="<%=path%>/static/images/clist1.jpg" width="1200" height="96"></div>
        <div id="personal-left" class="personal-left">
            <ul>
                <li class="pleft-cur"><span><a href="<%=path%>/page/user"><i class="dot dot1"></i>账户总览</a></span></li>
                <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="<%=path%>/page/zijin">资金记录</a></span></li>
                <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="<%=path%>/page/touzi">投资记录</a></span></li>
                <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="<%=path%>/page/huikuan">回款计划</a></span></li>
                <li class=""><span><a href="<%=path%>/page/disanfang"><i class="dot dot02"></i>开通第三方</a> </span> </li>
                <li><span><a href="<%=path%>/page/chongzhi"><i class="dot dot03"></i>充值</a></span></li>
                <li class=""><span><a href="<%=path%>/page/tixian"><i class="dot dot04"></i>提现</a></span></li>
                <li style="position:relative;" class=""> <span> <a href="<%=path%>/page/hongbao"> <i class="dot dot06"></i> 我的红包 </a> </span> </li>
                <li class=""><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="<%=path%>/page/history">兑换历史</a></span></li>
                <li style="position:relative;"> <span> <a href="<%=path%>/page/xitong"><i class="dot dot08"></i>系统信息 </a> </span> </li>
                <li><span><a href="<%=path%>/page/zhanghu"><i class="dot dot09"></i>账户设置</a></span></li>
                <li><span><a href="<%=path%>/luser/logout"><i class="dot dot10"></i>安全退出</a></span></li>
            </ul>
        </div>
        <label id="typeValue" style="display:none;"> </label>
        <div class="personal-main">
            <div class="personal-zqzr personal-xtxx" style="min-height: 500px;">
                <h3> <i>兑换历史</i> </h3>
                <div class="wdhb-title wdhb-dhls"> <span class="wdhb-yzm">验证码</span><span class="wdhb-con">兑换红包名称</span><span class="wdhb-deadline">兑换日期</span> </div>
                <form id="form" name="form" method="post" action="">
                    <div class="zqzr-list">
                        <ul>
                            <li><span class="wdhb-yzm">12345678</span><span class="wdhb-con">现金红包50元</span><span class="wdhb-deadline">2015-10-1</span></li>
                            <li><span class="wdhb-yzm">12345678</span><span class="wdhb-con">现金红包50元</span><span class="wdhb-deadline">2015-10-1</span></li>
                            <li><span class="wdhb-yzm">12345678</span><span class="wdhb-con">现金红包50元</span><span class="wdhb-deadline">2015-10-1</span></li>
                            <li><span class="wdhb-yzm">12345678</span><span class="wdhb-con">现金红包50元</span><span class="wdhb-deadline">2015-10-1</span></li>
                        </ul>
                    </div>
            <!--<div style="float:left; width:760px;height:200px;padding-top:100px; text-align:center;color:#d4d4d4; font-size:16px;">
                       <img src="/site/themes/default/style/../images/nondata.png" width="60" height="60"><br><br>
                         暂无兑换记录</div>-->
                </form>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<!-- 网站底部-->
<%@include file="../common/footer.jsp" %>
</body>
</html>
<script src="<%=path%>/static/js/jquery.datetimepicker.js" type="text/javascript"></script>
<script src="<%=path%>/static/js/datepicker.js" type="text/javascript"></script>
</body>
</html>
