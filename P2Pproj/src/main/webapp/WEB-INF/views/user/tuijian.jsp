<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>推荐中心</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="<%=path%>/static/css/common.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/user.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/jquery.datetimepicker.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/tab.css"/>
    <script type="text/javascript" src="<%=path%>/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/static/js/common.js"></script>
    <script src="<%=path%>/static/js/user.js" type="text/javascript"></script>
</head>
<body>
<!-- 网站头部-->
<%@include file="../common/header.jsp" %>
<!--个人中心-->
<div class="wrapper wbgcolor">
    <div class="w1200 personal">
        <%@include file="../common/leftList.jsp" %>
        <label id="typeValue" style="display:none;"> </label>
        <div class="personal-main">
            <div id="tab_demo" class="HuiTab">
                <div class="tabBar clearfix"><span>推荐好友</span><span>推荐列表</span></div>
                <div class="tabCon">
                    <img src="/static/images/banner_tuijian.png"/>
                    <div style="padding-top: 30px;font-size: 16px;color:#777;">
                        <p style="font-size: 18px;">尊敬的用户，你的推荐码是:
                            <span style="color:orange">${tzm}</span>
                        </p><br/>
                        活动时间：2017年12月1日至2018年12月31日<br/>
                        活动对象：活动期间新注册用户的推荐人<br/>
                        活动说明：<br/>
                        <span style="padding-left: 50px">
                            1、活动期间邀请好友注册并累计投资10000元，得50元现金券奖励</span><br/>
                        <span style="padding-left: 50px">
                        2、活动期间内成功邀请5位以上好友注册投资成功累计投资10000元，可额外获得500元现金券奖励，可在【我的账户-我的赠券】中查看。</span>
                        <br/><span style="padding-left: 50px">（满足活动条件的用户在活动结束后的3个工作日奖励以现金劵形式发放至用户账户）</span>
                        <br/>注：需将自己的邀请链接地址或推荐号发给你的好友，这样你才能成为他们的邀请者。
                        <br/><br/>
                        <input style="float: left;width: 560px;height: 30px;border: 1px solid #d9d9d9;border-right: none;color: #777777;line-height: 30px;text-indent: 10px;"
                               id="text" name="text" readonly
                               value="http://localhost:8080/page/register?userCode=${tzm}"/>
                        <button style="float: left;width: 80px;height: 32px;background-color: #319bff;color: #fff;text-align: center;position: relative;cursor: pointer;"
                                onclick="myCopy()">
                            复制链接
                        </button>
                        <br/><br/>
                        <p id="fuZhi" style="colo:red"></p>
                    </div>
                </div>
                <div class="tabCon">
                    <div class="dataTh"><span>用户名</span><span>用户创建时间</span><span>奖励金额</span><span>操作</span></div>
                    <div class="dataTh"><span>用户名</span><span>用户创建时间</span><span>奖励金额</span><span>操作</span></div>
                </div>
            </div>
        </div>
    </div>
</div>
        <!-- 网站底部-->
        <%@include file="../common/footer.jsp" %>
</body>
</html>

<script src="<%=path%>/static/js/jquery.datetimepicker.js" type="text/javascript"></script>
<script src="<%=path%>/static/js/datepicker.js" type="text/javascript"></script>
<script src="<%=path%>/static/js/pageJs/tab.js" type="text/javascript"></script>
<script>
    function myCopy() {
        var ele = document.getElementById("text");
        ele.select();
        document.execCommand("Copy");
    }
</script>
</body>
</html>

