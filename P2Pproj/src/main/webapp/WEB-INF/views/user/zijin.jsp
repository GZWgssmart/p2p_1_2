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
</head>
<body>
<!-- 网站头部-->
<%@include file="../common/header.jsp"%>
<!--个人中心-->
<div class="wrapper wbgcolor">
    <div class="w1200 personal">
        <div class="credit-ad"><img src="<%=path%>/static/images/clist1.jpg" width="1200" height="96"></div>
        <div id="personal-left" class="personal-left">
            <ul>
                <li class="pleft-cur"><span><a href="<%=path%>/page/user"><i class="dot dot1"></i>账户总览</a></span></li>
                <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="<%=path%>/page/zijin">资金记录</a></span></li>
                <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="<%=path%>/page/touzi">投资记录</a></span></li>
                <li><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="<%=path%>/page/huikuan">回款计划</a></span></li>
                <li class=""><span><a href="<%=path%>/page/disanfang"><i class="dot dot02"></i>开通第三方</a> </span> </li>
                <li><span><a href="<%=path%>/page/chongzhi"><i class="dot dot03"></i>充值</a></span></li>
                <li class=""><span><a href="<%=path%>/page/tixian"><i class="dot dot04"></i>提现</a></span></li>
                <li style="position:relative;" class=""> <span> <a href="<%=path%>/page/hongbao"> <i class="dot dot06"></i> 我的红包 </a> </span> </li>
                <li class=""><span><a style="font-size:14px;text-align:center;width:115px;padding-right:35px;" href="<%=path%>/page/history">兑换历史</a></span></li>
                <li style="position:relative;"> <span> <a href="<%=path%>/page/xitong"><i class="dot dot08"></i>系统信息 </a> </span> </li>
                <li><span><a href="<%=path%>/page/zhanghu"><i class="dot dot09"></i>账户设置</a></span></li>
                <li><span><a href="<%=path%>/luser/logout"><i class="dot dot10"></i>安全退出</a></span></li>
            </ul>
        </div>
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
          <div class="personal-moneylist">
            <div class="pmain-contitle"> <span class="pmain-title1 fb">交易时间</span> <span class="pmain-title2 fb">交易类型</span> <span class="pmain-title3 fb">交易金额</span> <span class="pmain-title4 fb">余额</span> <span class="pmain-title5 fb">备注</span> </div>
            <ul>
              <li><span class="pmain-title1 pmain-height">2015-10-20</span><span class="pmain-title2 pmain-height">债权转让</span><span class="pmain-title3 pmain-height">10.00</span><span class="pmain-title4 pmain-height">10.00</span><span class="pmain-title5 pmain-height">备注</span></li>
              <li><span class="pmain-title1 pmain-height">2015-10-20</span><span class="pmain-title2 pmain-height">债权转让</span><span class="pmain-title3 pmain-height">10.00</span><span class="pmain-title4 pmain-height">10.00</span><span class="pmain-title5 pmain-height">备注</span></li>
              <li><span class="pmain-title1 pmain-height">2015-10-20</span><span class="pmain-title2 pmain-height">债权转让</span><span class="pmain-title3 pmain-height">10.00</span><span class="pmain-title4 pmain-height">10.00</span><span class="pmain-title5 pmain-height">备注</span></li>
              <li><span class="pmain-title1 pmain-height">2015-10-20</span><span class="pmain-title2 pmain-height">债权转让</span><span class="pmain-title3 pmain-height">10.00</span><span class="pmain-title4 pmain-height">10.00</span><span class="pmain-title5 pmain-height">备注</span></li>
              <li><span class="pmain-title1 pmain-height">2015-10-20</span><span class="pmain-title2 pmain-height">债权转让</span><span class="pmain-title3 pmain-height">10.00</span><span class="pmain-title4 pmain-height">10.00</span><span class="pmain-title5 pmain-height">备注</span></li>
              <li><span class="pmain-title1 pmain-height">2015-10-20</span><span class="pmain-title2 pmain-height">债权转让</span><span class="pmain-title3 pmain-height">10.00</span><span class="pmain-title4 pmain-height">10.00</span><span class="pmain-title5 pmain-height">备注</span></li>
              <li><span class="pmain-title1 pmain-height">2015-10-20</span><span class="pmain-title2 pmain-height">债权转让</span><span class="pmain-title3 pmain-height">10.00</span><span class="pmain-title4 pmain-height">10.00</span><span class="pmain-title5 pmain-height">备注</span></li>
                <!-- <div style=" width:760px;height:200px;padding-top:100px; text-align:center;color:#d4d4d4; font-size:16px;"> <img src="images/nondata.png" width="60" height="60"><br>
                  <br>
                  暂无资金记录</div>-->
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
<%@include file="../common/footer.jsp" %></body>
</html>
