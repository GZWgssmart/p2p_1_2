<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>我的红包</title>
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
        <div class="credit-ad"><img src="<%=path%>/static/images/clist1.jpg" width="1000" height="80"></div>
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
            </ul>
        </div>
        <label id="typeValue" style="display:none;"> </label>
        <style type="text/css">
            .wdhb-tab .on  a{color:#fff;}
        </style>
        <div class="personal-main">
            <div class="personal-zqzr personal-xtxx" style="min-height: 500px;">
                <h3><i>我的红包</i></h3>
                <div class="lx-wdhb"> <span class="pay-title">兑换红包</span> <span class="pay-number">
          <form id="codeForm" name="codeForm" method="post" action="">
            <input id="codeForm:code" type="text" name="codeForm:code" class="pay-money-txt">
            <input type="submit" name="codeForm:j_idt73" value="兑换" class="btn-dh">
            <span class="cz-error" style="display:none;"> <span class="error">红包兑换码不能为空！</span> </span>
          </form>
          <script>
	        //<![CDATA[
            $(function(){
                if(true){
                    $("#codeForm\\:code").val("输入验证码，兑换相应面值的红包");
                }
                $("#codeForm\\:code").blur(function(){
                    var code = $(this).val();
                    if(undefined == code || null == code || "" == code || "输入验证码，兑换相应面值的红包" == code){
                        $(this).val("输入验证码，兑换相应面值的红包");
                        $(".cz-error").css({"display": "block"});
                    }
                });
                $("#codeForm\\:code").focus(function(){
                    $(".cz-error").css({"display": "none"});
                    var code = $(this).val();
                    if(undefined != code && null != code && "输入验证码，兑换相应面值的红包" == code){
                        $(this).val("");
                    }
                });
            })

            function checkExchangeCode(){
                var code = $("#codeForm\\:code").val();
                if(undefined == code || null == code || "" == code || "输入验证码，兑换相应面值的红包" == code){
                    $(this).val("输入验证码，兑换相应面值的红包");
                    $(".cz-error").css({"display": "block"});
                    return false;
                }
                return true;
            }
            //]]>
	          </script>
          </span> </div>
                <form id="form" name="form" method="post" action="">
                    <script type="text/javascript">clearPage = function() {PrimeFaces.ab({source:'form:j_idt76',formId:'form',process:'form:j_idt76',params:arguments[0]});}</script>
                    <span id="form:dataTable">
          <div id="wdhb-tab" class="wdhb-tab">
            <ul>
              <li class="on"><a href="#" title="未使用">未使用 </a> </li>
              <li><a href="#" title="已使用" >已使用 </a> </li>
              <li><a href="#" title="已过期">已过期 </a> </li>
            </ul>
          </div>
          <div class="wdhb-title"><span class="wdhb-name">红包名称</span><span class="wdhb-con">红包简介</span><span class="wdhb-deadline">截止日期</span> <span class="wdhb-status">状态</span> </div>
          <div class="zqzr-list">
            <ul>
              <li><span class="wdhb-name">现金50元</span><span class="wdhb-con">可以作为投资使用</span><span class="wdhb-deadline">2015-10-1</span> <span class="wdhb-status"><a href="#">未使用</a></span></li>
              <li><span class="wdhb-name">现金50元</span><span class="wdhb-con">可以作为投资使用</span><span class="wdhb-deadline">2015-10-1</span> <span class="wdhb-status"><a href="#">未使用</a></span></li>
              <li><span class="wdhb-name">现金50元</span><span class="wdhb-con">可以作为投资使用</span><span class="wdhb-deadline">2015-10-1</span> <span class="wdhb-status"><a href="#">未使用</a></span></li>
            </ul>
          </div>
        <!--<div style="float:left; width:760px;height:200px;padding-top:100px; text-align:center;color:#d4d4d4; font-size:16px;">
                   <img src="images/nondata.png" width="60" height="60"><br><br>
                     暂无红包记录</div>-->
          </span>
                </form>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<!-- 网站底部-->
<%@include file="../common/footer.jsp" %>
<script src="<%=path%>/static/js/jquery.datetimepicker.js" type="text/javascript"></script>
<script src="<%=path%>/static/js/datepicker.js" type="text/javascript"></script>
</body>
</html>
