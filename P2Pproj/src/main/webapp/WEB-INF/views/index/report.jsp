<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>媒体报道</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="<%=path%>/static/css/common.css" rel="stylesheet" />
    <link href="<%=path%>/static/css/about.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<%=path%>/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/static/js/common.js"></script>
</head>
<body>
<!-- 网站头部-->
<%@include file="../common/header.jsp"%>
<!--关于我们-->
<div class="bg">
    <div class="contain" id="tabs" style="margin:0 auto;">

        <%@include file="../common/aboutLeft.jsp"%>

        <div class="text-box">
            <div class="text-content" id="text-content">
                <ul class="r-list">
                    <li class="clearfix">
                        <a href="">
                            <img src="<%=path%>/static/images/2015062506.jpg" width="300" height="171">
                        </a>
                        <div class="record">
                            <h5>
                                <a href="#">服务民生</a>
                            </h5>
                            <p class="text">
                                设立公益书友会，斥资购买图书并向市民免费开放，这也和2015年政府工作报告提出要“倡导全民阅读 ，建设书香社会”的号召不谋而合。公益书友会将是一个交流互动的乐园，书友会将不定期举办多种活动，发挥石狮首家互联网金融公司的所长，帮助市民了解金融法规、投资理财等相关知识，为发展普惠金融做出自己的贡献。
                            </p>
                            <p class="time">报道时间：2015年6月</p>
                        </div>
                    </li>
                    <li class="clearfix">
                        <a href="">
                            <img src="<%=path%>/static/images/2015062506.jpg" width="300" height="171">
                        </a>
                        <div class="record">
                            <h5>
                                <a href="#">服务民生</a>
                            </h5>
                            <p class="text">
                                设立公益书友会，斥资购买图书并向市民免费开放，这也和2015年政府工作报告提出要“倡导全民阅读 ，建设书香社会”的号召不谋而合。公益书友会将是一个交流互动的乐园，书友会将不定期举办多种活动，发挥石狮首家互联网金融公司的所长，帮助市民了解金融法规、投资理财等相关知识，为发展普惠金融做出自己的贡献。
                            </p>
                            <p class="time">报道时间：2015年6月</p>
                        </div>
                    </li>
                    <li class="clearfix">
                        <a href="">
                            <img src="<%=path%>/static/images/2015062506.jpg" width="300" height="171">
                        </a>
                        <div class="record">
                            <h5>
                                <a href="${pageContext.request.contextPath}/views/media/mediaPage.jsp">服务民生</a>
                            </h5>
                            <p class="text">
                                设立公益书友会，斥资购买图书并向市民免费开放，这也和2015年政府工作报告提出要“倡导全民阅读 ，建设书香社会”的号召不谋而合。公益书友会将是一个交流互动的乐园，书友会将不定期举办多种活动，发挥石狮首家互联网金融公司的所长，帮助市民了解金融法规、投资理财等相关知识，为发展普惠金融做出自己的贡献。
                            </p>
                            <p class="time">报道时间：2015年6月</p>
                        </div>
                    </li>
                </ul>
                <%--分页条开始--%>
                <div class="pagination clearfix mrt30">
                <span class="page" style="font-size: 19px;">
                    <a href="javascript:void(0);" onclick="">首页</a>
                    <a href="javascript:void(0);" style="margin-left: 10px" onclick="">上一页</a>&nbsp;
                    <a class="curr" style="margin-left: 10px" href="javascript:void(0);">1</a>
                    <a href="#"style="margin-left: 10px">2</a>
                    <a href="#" style="margin-left: 10px">3</a>
                    <a href="#" style="margin-left: 10px">4</a>
                    <a href="#" style="margin-left: 10px">5</a>
                    <a href="javascript:void(0);" style="margin-left: 10px">下一页</a>
                    <a href="javascript:void(0);" style="margin-left: 10px">尾页</a>&nbsp;
                    <em style="margin-left: 10px">共2297页&nbsp;</em></span>
                    <dl class="page-select">
                        <dt><span>1</span><i class="icon icon-down"></i></dt>
                        <dd style="display: none;">
                            <ul name="nump" id="jsnump">
                                <li><a href="##" onclick="">1</a></li>
                                <li><a href="##" onclick="">2</a></li>
                                <li><a href="##" onclick="">3</a></li>
                            </ul>
                        </dd>
                    </dl>
                </div>
                <%--分页条结束--%>
            </div>
        </div>
    </div>
</div>
<!-- 网站底部-->
<%@include file="../common/footer.jsp" %>
</body>
</html>
