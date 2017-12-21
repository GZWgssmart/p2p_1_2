<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>平台详细公告</title>
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
        <div class="text-nav">
            <ul class="clearfix">
                <li> <a class="text-link" href="<%=path%>/page/ad">网站公告</a> </li>
                <li> <a class="text-link" href="<%=path%>/page/report">媒体报道</a> </li>
                <li> <a class="text-link" href="<%=path%>/page/about">公司简介</a> </li>
                <li> <a class="text-link" href="<%=path%>/page/managerTuandui">管理团队</a> </li>
                <li> <a class="text-link" href="<%=path%>/page/hezuo">合作伙伴</a> </li>
                <li> <a class="text-link" href="<%=path%>/page/tuandui">团队风采</a> </li>
                <li> <a class="text-link" href="<%=path%>/page/fl1">法律政策</a> </li>
                <li> <a class="text-link" href="<%=path%>/page/fl2">法律声明</a> </li>
                <li> <a class="text-link" href="<%=path%>/page/zifei">资费说明</a> </li>
                <li> <a class="text-link" href="<%=path%>/page/zhaopin">招贤纳士</a> </li>
                <li class="selected"> <a class="text-link" href="<%=path%>/page/contract">联系我们</a> </li>
            </ul>
        </div>
        <div class="text-box">
            <div class="text-content" id="text-content">
                <header class="article-header">
                    <div class="article-title"><a href="#">关爱社区环卫工在行动</a></div>
                    <div class="article-meta">
                        <span class="item">2015-09-01</span>
                        <span class="item">分类：<a rel="category tag" href="../index.jsp">媒体报道</a></span>
                        <span class="item post-views">阅读(89)</span>
                    </div>
                </header>
                <article class="article-content">
                    <p style="text-align: center;"><br></p><p style="text-align: center;"><img src="<%=path%>/static/images/news.jpg"></p><p style="padding-top: 10px; list-style-type: none; margin-top: 0px; margin-bottom: 0px; outline: invert none medium; list-style-image: none; text-indent: 2em; color: rgb(51, 51, 51); font-family: ''; font-size: 14px; font-style: normal; font-variant: normal; line-height: 25.2000007629395px; white-space: normal;">8月29日下午，由携手石狮华南社区举行的“微公益· 关爱环卫工”捐赠活动在华南社区活动中心举行，来自一线的环卫工人、爱心人士、乐投贷志愿服务队参加了捐赠仪式。本次活动共为环卫工人发放了价值千余元的慰问品，内含纸巾、牙刷、牙膏、洗洁精、凉茶、风油精、正气水等日常用品和药品，希望能用实际行动向劳动者致敬，通过这一份份爱心大礼包传递社会对他们的关怀。</p><p></p>				</article>

            </div>
        </div>
    </div>
</div>
<!-- 网站底部-->
<%@include file="../common/footer.jsp" %>
</body>
</html>