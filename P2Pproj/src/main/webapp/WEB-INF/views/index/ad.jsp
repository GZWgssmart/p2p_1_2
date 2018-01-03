<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>网站公告</title>
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
                <h1 class="title">网站公告</h1>
                <ul class="clearfix mt20 new-list">
                    <li class="clearfix list-item">
                        <a href="ad1.jsp">9月14日最新理财产品预告</a>
                        <span>2015-09-12</span>
                    </li><li class="clearfix list-item">
                    <a href="ad1.jsp">豆兑换规则</a>
                    <span>2015-09-12</span>
                </li><li class="clearfix list-item">
                    <a href="ad1.jsp">9月12日最新理财产品介绍</a>
                    <span>2015-09-12</span>
                </li><li class="clearfix list-item">
                    <a href="ad1.jsp">9月11日最新理财产品介绍</a>
                    <span>2015-09-11</span>
                </li><li class="clearfix list-item">
                    <a href="ad1.jsp">9月10日最新理财产品预告</a>
                    <span>2015-09-09</span>
                </li><li class="clearfix list-item">
                    <a href="ad1.jsp">9月9日最新理财产品介绍</a>
                    <span>2015-09-09</span>
                </li><li class="clearfix list-item">
                    <a href="ad1.jsp">9月8日最新理财产品预告</a>
                    <span>2015-09-07</span>
                </li><li class="clearfix list-item">
                    <a href="ad1.jsp">9月7日最新理财产品预告</a>
                    <span>2015-09-06</span>
                </li><li class="clearfix list-item">
                    <a href="ad1.jsp">9月6日最新理财产品预告</a>
                    <span>2015-09-05</span>
                </li>				</ul>
                <div class="page">
                    <span class="all">共有163条信息</span><span class="count"></span><div class="fr pages"><span data-page="1" class="currents">1</span><a data-page="2" href="#">2</a><a data-page="3" href="#">3</a><a data-page="4" href="#">4</a><a data-page="5" href="#">5</a><a data-page="6" href="#">6</a><span>...</span><a data-page="16" href="#">16 </a><a data-page="17" href="#">17 </a><a data-page="2" class="next" href="#">下一页</a><a data-page="17" class="last" href="#">尾页</a></div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 网站底部-->
<%@include file="../common/footer.jsp" %>
</div>
</body>
</html>
