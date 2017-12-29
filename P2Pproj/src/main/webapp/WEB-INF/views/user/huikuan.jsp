<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>回款计划</title>
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
        <%@include file="../common/leftList.jsp"%>
        <div class="personal-main">
            <div class="personal-back">
                <h3><i>回款计划</i></h3>
                <form id="form" name="form" method="post" action="">
                    <input type="hidden" name="form" value="form">
                    <div class="back-money"> <span class="back-own"><b class="fb">待收本金</b><br>
            <i>0.00</i> 元</span> <span class="back-profit"><b class="fb">待收收益</b><br>
            <i>0.00</i> 元</span> </div>
                    <div class="back-choosedate"> <span class="choosedate">筛选时间</span>
                        <div id="datebox" class="select-date"> <span class="select-title" style="display:inline-block;height:25px;line-height:20px;"></span>
                            <ul>
                                <li>全部</li>
                            </ul>
                        </div>
                        <span id="form:datapicker1" class="datepicker">
            <input type="text" class="ui-inputfield ui-widget ui-state-default ui-corner-all hasDatepicker" id="">
            </span> - <span id="form:datapicker2" class="datepicker">
            <input type="text" class="ui-inputfield ui-widget ui-state-default ui-corner-all hasDatepicker" id="datetimepicker20">
            </span>
            <input id="id" type="hidden" name="">
            <button id="id1" name="" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only btn-ok btn-235 txt-right"  type="submit"><span class="ui-button-text ui-c">查询</span></button>
                    </div>
                    <span id="form:dataTable">
          <div class="personal-backlist">
            <div class="pmain-contitle"> <span class="pmain-titledate fb">计划回款时间</span> <span class="pmain-titleproject fb">项目</span> <span class="pmain-titletype fb">类型</span> <span class="pmain-titlemoney fb">回款金额</span> </div>
            <ul style="float:left;">
              <li> <span class="pmain-titledate">2015-10-1</span> <span class="pmain-titleproject">债权转让</span> <span class="pmain-titletype">房易贷</span> <span class="pmain-titlemoney">100000.00</span> </li>
              <li> <span class="pmain-titledate">2015-10-1</span> <span class="pmain-titleproject">债权转让</span> <span class="pmain-titletype">房易贷</span> <span class="pmain-titlemoney">100000.00</span> </li>
              <li> <span class="pmain-titledate">2015-10-1</span> <span class="pmain-titleproject">债权转让</span> <span class="pmain-titletype">房易贷</span> <span class="pmain-titlemoney">100000.00</span> </li>
              <li> <span class="pmain-titledate">2015-10-1</span> <span class="pmain-titleproject">债权转让</span> <span class="pmain-titletype">房易贷</span> <span class="pmain-titlemoney">100000.00</span> </li>
              <li> <span class="pmain-titledate">2015-10-1</span> <span class="pmain-titleproject">债权转让</span> <span class="pmain-titletype">房易贷</span> <span class="pmain-titlemoney">100000.00</span> </li>
                <!--<div style=" width:760px;height:200px;padding-top:100px; text-align:center;color:#d4d4d4; font-size:16px;">
                                              <img src="images/nondata.png" width="60" height="60"><br><br>
                                             暂无回款计划</div>-->
            </ul>
          </div>
          </span>
                </form>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<!-- 网站底部-->
<%@include file="../common/footer.jsp" %>
</body>
</html>

