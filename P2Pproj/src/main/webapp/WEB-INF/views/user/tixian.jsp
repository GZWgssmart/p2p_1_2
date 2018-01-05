<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>提现</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="<%=path%>/static/css/common.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/user.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/jquery.datetimepicker.css"/>
    <script type="text/javascript" src="<%=path%>/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/static/js/common.js"></script>
    <script src="<%=path%>/static/js/user.js" type="text/javascript"></script>
    <jsp:include page="../common/bootstraptablecss.jsp"/>
</head>
<body>
<!-- 网站头部-->
<%@include file="../common/header.jsp" %>
<!--个人中心-->
<div class="wrapper wbgcolor">
    <div class="w1200 personal">
        <%@include file="../common/leftList.jsp" %>
        <label id="typeValue" style="display:none;"> </label>
        <script>
            //<![CDATA[
            function showSpan(op) {
                $("body").append("<div id='mask'></div>");
                $("#mask").addClass("mask").css("display", "block");

                $("#" + op).css("display", "block");
            }

            function displaySpan(op) {
                $("#mask").css("display", "none");
                $("#" + op).css("display", "none");
            }

            //]]>
        </script>
        <script type="text/javascript">
            function tixian() {
                $.post(
                    "/logTx/tixian",
                    $("#form").serialize(),
                    function (data) {
                        if (data.result == "ok") {

                            layer.msg(data.message, {icon: 1, time: 1000});
                            refush();
                        } else {
                            layer.msg(data.message, {icon: 2, time: 1000});
                            refush();
                        }
                    }, "json"
                );
            }
        </script>
        <div class="personal-main">
            <div class="personal-deposit">
                <h3><i>提现</i></h3>
                <form id="form" name="form" method="post" action=""
                      enctype="application/x-www-form-urlencoded" target="_blank">
                    <input type="hidden" name="form" value="form">
                    <div class="deposit-form" style="margin-top:0px;border-top:0px none;">
                        <h6>填写提现金额</h6>
                        <ul>
                            <li><span class="deposit-formleft">可用金额</span> <span class="deposit-formright"> <i>
                <label id="form:blance">${kymoney}</label>
                </i>元 </span></li>
                            <li><span class="deposit-formleft">提现金额</span> <span class="deposit-formright">
                <input id="form:actualMoney" type="text" name="actualMoney" class="deposite-txt" maxlength="10">
                元 </span> <span id="actualMoneyErrorDiv"><span id="actualMoney_message" style="display:none"
                                                               class="error"></span></span></li>

                            <li>
                                <input type="button" name="form:j_idt78" value="提现" class="btn-depositok"
                                       onclick="tixian()">
                            </li>
                        </ul>
                    </div>
                </form>
                <div class="deposit-tip"> 温馨提示：<br>
                    1、用户需在完成身份认证、开通丰付托管账户并绑定银行卡后，方可申请提现；<br>
                    2、请务必在提现时使用持卡人与身份认证一致的银行卡号，且确保填写信息准确无误；<br>
                    3、工作日当天16:00前提交的提现申请将在当天处理，默认为T+1到账；<br>
                    4、提现金额单笔上限为50万元，单日累计总额不可超过100万元；<br>
                    5、提现手续费为提现金额的0.1%，最低每笔2元，100元封顶，手续费由第三方托管账户收取，用户自行承担。<br>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $("#form\\:actualMoney").focus(
                function () {
                    $(this).css({
                        "font-size": "24px",
                        "font-weight": "bold",
                        "font-family": "Arial",
                        "border": "1px solid #0caffe"
                    });
                    if ($("#form\\:actualMoney").val() == value) {
                        $("#form\\:actualMoney").val("")
                        $(this).css({"font-size": "24px", "font-weight": "bold", "font-family": "Arial"});
                    }
                }).blur(
                function () {
                    $(this).css("border", "1px solid #D0D0D0");
                    if ($("#form\\:actualMoney").val() == "") {
                        $(this).css({"color": "#D0D0D0", "font-size": "14px", "font-weight": "normal"});
                    }
                })

            function keyUpcheck() {
                $(this).css({"font-size": "24px", "font-weight": "bold", "font-family": "Arial"});
            }
        </script>
        <div class="clear"></div>
    </div>
</div>
<!-- 网站底部-->
<%@include file="../common/footer.jsp" %>
</body>
<script src="<%=path%>/static/js/jquery.datetimepicker.js" type="text/javascript"></script>
<script src="<%=path%>/static/js/datepicker.js" type="text/javascript"></script>
<jsp:include page="../common/bootstraptablejs.jsp"/>
</html>

