<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>投资理财</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="<%=path%>/static/css/common.css" rel="stylesheet" />
    <link href="<%=path%>/static/css/index.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>/static/css/detail.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<%=path%>/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/static/js/common.js"></script>
</head>
<body>
<!-- 网站头部-->
<%@include file="../common/header.jsp"%>
<!--列表-->
<div class="page-filter wrap">
    <div class="breadcrumbs"><a href="../index.jsp">首页</a>&gt;<span class="cur">散标投资列表</span></div>
    <div class="invest-filter" data-target="sideMenu">
        <div class="filter-inner clearfix">
            <div class="filter-item">
                <div class="hd">
                    <h3>筛选投资项目</h3>
                    <label>
                        <input id="filterMulti" name="multiple_choice" type="checkbox">
                        多选</label>
                </div>
                <div class="bd">
                    <dl>
                        <dt>项目类型</dt>
                        <dd>
                            <ul>
                                <li class="n1"><a href="javascript:url('post_type','');" id="post_type_" class="active">不限</a></li>
                                <li class="n2"><a href="javascript:url('post_type','car');" id="post_type_car">1-3个月</a></li>
                                <li class="n3"><a href="javascript:url('post_type','house');" id="post_type_house">3-6个月</a></li>
                                <li class="n4"><a href="javascript:url('post_type','bridge');" id="post_type_bridge">6-9个月</a></li>
                                <li class="n5"><a href="javascript:url('post_type','worth');" id="post_type_worth">大于9个月</a> </li>
                            </ul>
                        </dd>
                    </dl>
                    <dl>
                        <dt>年化收益</dt>
                        <dd>
                            <ul>
                                <li class="n1"><a href="" id="borrow_interestrate_" class="active">不限</a></li>
                                <li class="n2"><a id="borrow_interestrate_1" href=""><=10%</a> </li>
                                <li class="n3"><a id="borrow_interestrate_2" href="">10%-15%</a> </li>
                                <li class="n4"><a id="borrow_interestrate_3" href="">15%-25%</a> </li>
                                <li class="n5"><a id="borrow_interestrate_4" href="">25%及以上</a> </li>
                            </ul>
                        </dd>
                    </dl>
                    <dl>
                        <dt>项目类型</dt>
                        <dd>
                            <%--<c:forEach items="${bzList}" var="d">--%>
                                <ul >
                                    <li class="n1"><a href=""  class="active">不限</a> </li>
                                    <li class="n2"><a id="spread_month_2" href="javascript:url('spread_month','2');">普金宝</a> </li>
                                    <li class="n3"><a id="spread_month_3" href="javascript:url('spread_month','3');">多金宝</a> </li>
                                    <li class="n4"><a id="spread_month_4" href="javascript:url('spread_month','4');">恒金宝</a> </li>
                                    <li class="n5"><a id="spread_month_5" href="javascript:url('spread_month','5');">余额宝</a> </li>
                                </ul>
                            <%--</c:forEach>--%>
                        </dd>
                    </dl>
                </div>
            </div>
            <div class="common-problem">
                <h3>常见问题</h3>
                <ul>
                    <li><a href="#">什么是债权贷？</a></li>
                    <li><a href="#">关于"债权贷"产品的说明</a></li>
                    <li><a href="#">易贷网P2P理财收费标准</a></li>
                    <li><a href="#">债权贷和房易贷、车易贷有什么区别？</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="invest-list mrt30 clearfix">
        <div class="hd">
            <h3>投资列表</h3>
        </div>
        <div class="bd">
            <div class="invest-table clearfix">
                <div class="title clearfix">
                    <ul>
                        <li class="col-150">投资标种</li>
                        <li class="col-150">产品名称</li>
                        <li class="col-150">可投金额/募集总额(元)</li>
                        <li class="col-150">年化收益 </li>
                        <li class="col-150">借款期限 </li>
                        <li class="col-150">还款方式</li>
                        <li class="col-120">借款进度</li>
                        <li class="col-120-t">操作</li>
                    </ul>
                </div>
                <!------------投资列表-------------->

                <c:forEach items="${borrowDetailVO}" var="d">
                    <div class="item">
                        <ul>
                            <li class="col-150"><a style="color: red">${d.bzname}</a></li>
                            <li class="col-150"><a href="<%=path%>/page/info/${d.baid}" style="size: 3px;color: #00a0e9">${d.cpname}</a></li>
                            <li class="col-150">${d.money-d.tzmoney}/${d.money}</li>
                            <li class="col-150"><span class="f20 c-orange">${d.nprofit}% </span></li>
                            &nbsp;&nbsp;&nbsp;
                            <li class="col-150"> <span class="f20 c-333">${d.term}</span>个月 </li>
                            <li class="col-170">${d.way}</li>
                            <li class="col-120">
                                <div class="circle">
                                    <div class="left progress-bar">
                                        <div class="progress-bgPic progress-bfb10">
                                            <div class="show-bar">${(d.tzmoney/d.money)*100}% </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <c:if test="${d.tzmoney<d.money}">
                                <li class="col-120-2">
                                    <a class="ui-btn btn-gray" href="<%=path%>/page/info/${d.baid}">立即投标</a>
                                </li>
                            </c:if>
                            <c:if test="${d.tzmoney==d.money}">
                                <li class="col-120-2">
                                    <a class="ui-btn btn-gray" href="<%=path%>/page/info/${d.baid}">还款中</a>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </c:forEach>
            <!------------投资列表-------------->
            </div>
            <div class="pagination clearfix mrt30">
                <span class="page">
                    <a href="javascript:void(0);" onclick="">首页</a>
                    <a href="javascript:void(0);" onclick="">上一页</a>&nbsp;
                    <a class="curr" href="javascript:void(0);">1</a>
                    <a href="#">2</a> <a href="#">3</a> <a href="#">4</a>
                    <a href="#">5</a> <a href="javascript:void(0);" >下一页</a>
                    <a href="javascript:void(0);" >尾页</a>&nbsp;
                    <em>共2297页&nbsp;</em></span>
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
        </div>
    </div>
</div>
<!-- 网站底部-->
<%@include file="../common/footer.jsp" %>
</body>
</html>
