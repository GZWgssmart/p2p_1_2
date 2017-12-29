<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>资金记录</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="<%=path%>/static/css/common.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/user.css" />
    <script type="text/javascript" src="<%=path%>/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/static/js/common.js"></script>
    <script src="<%=path%>/static/js/user.js" type="text/javascript"></script>
    <jsp:include page="../common/bootstraptablecss.jsp"/>
</head>
<body>
<!-- 网站头部-->
<%@include file="../common/header.jsp"%>
<!--个人中心-->
<div class="wrapper wbgcolor">
    <div class="w1200 personal">
        <%@include file="../common/leftList.jsp"%>
        <div class="personal-main">
            <div class="personal-money">
                <h3><i>资金记录</i></h3>
                <form id="form" name="form" method="post" action="">
                    <div class="money-choose"> <span class="money-date1">操作类型</span>
                        <div id="typeboxstyle" class="select-date"> <span class="select-title" style="display:inline-block;height:25px;line-height:20px;">全部</span>
                            <ul>
                                <li>全部</li>
                                <li value="ti_balance">转入到余额</li>
                                <li value="to_balance">从余额转出</li>
                                <li value="to_frozen">从冻结金额中转出</li>
                                <li value="freeze">冻结</li>
                                <li value="unfreeze">解冻</li>
                            </ul>
                        </div>
                        <span class="money-date2">查询时间</span>
                        <div id="select-date" class="select-date"> <span class="select-title" style="display:inline-block;height:25px;line-height:20px;">全部</span>
                            <ul>
                                <li value="0d">今天</li>
                                <li value="1w">最近一周</li>
                                <li value="1m">一个月</li>
                                <li value="6m">六个月</li>
                                <li>全部</li>
                            </ul>
                        </div>
                        <button class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only btn-sx"><span class="ui-button-text ui-c">筛选</span></button>
                        <button class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only btn-dc"><span class="ui-button-text ui-c">导出</span></button>
                    </div>
                    <span id="form:dataTable">
          <div >
                 <table id="mytab" name="mytab" class="table table-hover"></table>
            <div id="toolbar" class="btn-group pull-right" style="margin-right: 20px;">
          </div>
          </span>
                </form>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<!-- 网站底部-->
<%@include file="../common/footer.jsp" %></body>
<jsp:include page="../common/bootstraptablejs.jsp"/>
<script src="<%=path%>/static/js/pageJs/zijin.js"></script>
</html>
