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

                    <c:if test="${requestScope.noticeList!=null}">
                        <c:forEach var="a" items="${noticeList}" >
                            <li class="clearfix list-item"><a href="<%=path%>/notice/initNotice/${a.nid}" title="${a.title}">${a.title}</a><span class="date">${a.dateString}</span></li>
                        </c:forEach>
                    </c:if>
                  	</ul>
                <div class="page">
                    <span class="all">共有${noticeList.size()}条信息</span><span class="count"></span><div class="fr pages"><span data-page="1" class="currents">1</span><a data-page="2" class="next" href="<%=path%>/notice/initPager/5/5">下一页</a><a data-page="3" class="last" href="<%=path%>/notice/initPager/10/5">尾页</a></div>
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
