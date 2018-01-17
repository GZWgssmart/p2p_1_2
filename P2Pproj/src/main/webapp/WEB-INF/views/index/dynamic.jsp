<%@ page import="java.awt.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                    <c:forEach items="${dynamicList}" var="s">
                        <li class="clearfix">
                            <a href="">
                                <img src="<%=path%>/${s.pic}" width="300" height="171">
                            </a>
                            <div class="record">
                                <h5>
                                    <a href="<%=path%>/dynamic/initDynamic/${s.dyid}">${s.title}</a>
                                </h5>
                                <p class="text">
                                    ${s.content}
                                </p>
                                <p class="time">报道时间:${s.date}</p>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
                <%--分页条开始--%>
                <div class="pagination clearfix mrt30">
                <span class="page" style="font-size: 19px;">
                     <font size="4" style="margin-left: 10px">页码${page.pageNo}/${page.pages}</font>
                     <a href="javascript:void(0);" onclick="page(1)">首页</a>
                     <c:choose>
                         <c:when test="${page.pageNo - 1 >0}">
                             <a href="javascript:void(0);" style="margin-left: 10px" onclick="page('${page.pageNo -1}')">上一页</a>&nbsp;
                         </c:when>
                         <c:when test="${page.pageNo -1 <=0}">
                             <a href="javascript:void(0);" style="margin-left: 10px" onclick="page(1)">上一页</a>&nbsp;
                         </c:when>
                     </c:choose>
                     <a class="curr" style="margin-left: 10px" href="javascript:void(0);" onclick="page(1)">1</a>
                     <a href="#"style="margin-left: 10px" onclick="page(2)">2</a>
                     <a href="#" style="margin-left: 10px" onclick="page(3)">3</a>
                     <a href="#" style="margin-left: 10px" onclick="page(4)">4</a>
                     <a href="#" style="margin-left: 10px" onclick="page(5)">5</a>
                     <c:choose>
                         <c:when test="${page.pages == 0}">
                             <a href="javascript:void(0);" style="margin-left: 10px" onclick="page('${page.pageNo}')">下一页</a>
                         </c:when>
                         <c:when test="${page.pageNo + 1 < page.pages}">
                             <a href="javascript:void(0);" style="margin-left: 10px" onclick="page('${page.pageNo + 1}')">下一页</a>
                         </c:when>
                         <c:when test="${page.pageNo + 1 >= page.pages}">
                             <a href="javascript:void(0);" style="margin-left: 10px" onclick="page('${page.pages}')">下一页</a>
                         </c:when>
                     </c:choose>
                     <c:choose>
                         <c:when test="${page.pages == 0}">
                             <a href="javascript:void(0);" style="margin-left: 10px" onclick="page('${page.pageNo}')">尾页</a>&nbsp;
                         </c:when>
                         <c:otherwise>
                             <a href="javascript:void(0);" style="margin-left: 10px" onclick="page('${page.pages}')">尾页</a>&nbsp;
                         </c:otherwise>
                         </c:choose>
                         <em style="margin-left: 10px">共${page.total}页&nbsp;</em></span>
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
<jsp:include page="../common/bootstraptablejs.jsp"/>
<script>
    function page(str){
        if(str==${page.pageNo}&&str==1){
            layer.msg("当前已经是第一页了！", {icon: 2, time: 1000});
            return false;
        }
        if(str==${page.pageNo}&&str==${page.pages}){
            layer.msg("当前已经是最后一页了！", {icon: 2, time: 1000});
            return false;
        }
        $.post("<%=path%>/dynamic/list", {
                pageNo: str},
            function(data){
                window.location.href="<%=path%>/dynamic/list?pageNo="+str;
            });
    }
</script>
</body>
</html>
