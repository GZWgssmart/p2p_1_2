<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/29
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String path=request.getContextPath();%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>关于我们-普金资本-为用户提供详尽安全可靠的投资理财信息，网络贷款、融资服务</title>
    <link rel="stylesheet" href="<%=path%>/static/css/infoshow/about.css">

    <link href="<%=path%>/static/css/common.css" rel="stylesheet" />
    <link href="<%=path%>/static/css/about.css" rel="stylesheet" type="text/css">
<body onhashchange="hashChange()">
<%@include file="../common/header.jsp"%>
<!--关于我们-->
<div class="bg">
    <div class="contain" id="tabs" style="margin:0 auto;">
        <%@include file="../common/aboutLeft.jsp"%>
        <!-- begin -->
        <div class="about-right">
            <div class="about-right-nav">
                <div class="sub-a-nav">
                    <a href="javascript:void(0);" class="active" id="sssj">实时数据</a>
                    <a href="javascript:void(0);" id="yybg" class="">运营报告</a>
                </div>
                <em class="em-line" style="left: 0px;"></em>
            </div>
            <div class="about-content" id="sssjDiv" style="display: block;">
                <div class="btnDiv">
                    撮合交易总额（元）
                </div>
                <div class="moneyDiv"><div class="item_Div">3</div><div class="marginLeft"></div><div class="item_Div">3</div><div class="marginLeft">,</div><div class="item_Div">3</div><div class="marginLeft"></div><div class="item_Div">3</div><div class="marginLeft"></div><div class="item_Div">3</div><div class="marginLeft">,</div><div class="item_Div">6</div><div class="marginLeft"></div><div class="item_Div">4</div><div class="marginLeft"></div><div class="item_Div">6</div><div class="marginLeft">.</div><div class="item_Div">0</div><div class="marginLeft"></div><div class="item_Div">0</div><div class="marginLeft"></div></div>
                <div class="btnDiv">平台数据总览</div>
                <div class="sjList sjList-1">
                    <div class="item">
                        <div class="item-icon icon-dealNumber"></div>
                        <div class="itemText">交易笔数（笔）</div>
                        <div class="itemSJ" id="dealNumber">1,885</div>
                    </div>
                    <div class="item">
                        <div class="item-icon icon-repayAmount"></div>
                        <div class="itemText">已还本金（元）</div>
                        <div class="itemSJ" id="repayAmount">22,301,677.26</div>
                    </div>
                    <div class="item">
                        <div class="item-icon icon-unRepayAmount"></div>
                        <div class="itemText">待还本金（元）</div>
                        <div class="itemSJ" id="unRepayAmount">10,770,632.00</div>
                    </div>
                    <div class="item">
                        <div class="item-icon icon-unRepayNumber"></div>
                        <div class="itemText">待还笔数（笔）</div>
                        <div class="itemSJ" id="unRepayNumber">26</div>
                    </div>
                    <div class="item">
                        <div class="item-icon icon-hasInteres"></div>
                        <div class="itemText">为用户创造的收益（元）</div>
                        <div class="itemSJ" id="hasInterest">607,363.00</div>
                    </div>
                    <div class="item">
                        <div class="item-icon icon-compensatoryMoney"></div>
                        <div class="itemText">累计代偿金额（元）</div>
                        <div class="itemSJ" id="compensatoryMoney">0.00</div>
                    </div>
                    <div class="item">
                        <div class="item-icon icon-compensatoryNumber"></div>
                        <div class="itemText">累计代偿笔数（笔）</div>
                        <div class="itemSJ" id="compensatoryNumber">0</div>
                    </div>
                    <div class="item">
                        <div class="item-icon icon-overdueMoney"></div>
                        <div class="itemText">逾期金额（元）</div>
                        <div class="itemSJ" id="overdueMoney">12.26</div>
                    </div>
                    <div class="item">
                        <div class="item-icon icon-overdueNumber"></div>
                        <div class="itemText">逾期笔数（笔）</div>
                        <div class="itemSJ" id="overdueNumber">3</div>
                    </div>
                    <div class="item">
                        <div class="item-icon icon-overtimeNumber"></div>
                        <div class="itemText">逾期90天以上笔数（笔）</div>
                        <div class="itemSJ" id="overtimeNumber">0</div>
                    </div>
                    <div class="item">
                        <div class="item-icon icon-overtimeMoney"></div>
                        <div class="itemText">逾期90天以上金额（元）</div>
                        <div class="itemSJ" id="overtimeMoney">0.00</div>
                    </div>
                </div>
                <div class="btnDiv btnDiv-P">平台用户数据</div>
                <div class="sjList sjList-2">
                    <div class="item-yh">
                        <i class="icon-userTotal"></i>
                        <div class="itemText">注册用户数（人）</div>
                        <div class="itemSJ color-b" id="userTotal">11,213</div>
                    </div>
                    <div class="item-yh">
                        <i class="icon-investorCount"></i>
                        <div class="itemText">累计出借人数量（人）</div>
                        <div class="itemSJ color-g" id="investorCount">437</div>
                    </div>
                    <div class="item-yh">
                        <i class="icon-borrowerCount"></i>
                        <div class="itemText">累计借款人数量（人）</div>
                        <div class="itemSJ color-y" id="borrowerCount">35</div>
                    </div>
                    <div class="item-yh">
                        <i class="icon-avgUserInvest"></i>
                        <div class="itemText">人均累计投资金额（元）</div>
                        <div class="itemSJ color-b" id="avgUserInvest">76,278.37</div>
                    </div>
                    <div class="item-yh">
                        <i class="icon-avgInvest"></i>
                        <div class="itemText">笔均投资额（元）</div>
                        <div class="itemSJ color-g" id="avgInvest">17,683.63</div>
                    </div>
                    <div class="item-yh">
                        <i class="icon-investorNew"></i>
                        <div class="itemText">当期出借人数量（人）</div>
                        <div class="itemSJ color-y" id="investorNew">146</div>
                    </div>
                    <div class="item-yh">
                        <i class="icon-borrowerNew"></i>
                        <div class="itemText">当期借款人数量（人）</div>
                        <div class="itemSJ color-b" id="borrowerNew">18</div>
                    </div>
                    <div class="item-yh">
                        <i class="icon-AssociationNumber"></i>
                        <div class="itemText">关联关系借款笔数（笔）</div>
                        <div class="itemSJ color-g" id="AssociationNumber">0</div>
                    </div>
                    <div class="item-yh">
                        <i class="icon-AssociationSum"></i>
                        <div class="itemText">关联关系借款余额（元）</div>
                        <div class="itemSJ color-y" id="AssociationSum">0.00</div>
                    </div>
                    <div class="item-yh">
                        <i class="icon-borrowerPer"></i>
                        <div class="itemText">前十大借款代还金额占比（%）</div>
                        <div class="itemSJ color-b" id="borrowerPer">45.22</div>
                    </div>
                    <div class="item-yh">
                        <i class="icon-bigBorrowerPer"></i>
                        <div class="itemText">最大借款代还金额占比（%）</div>
                        <div class="itemSJ color-g" id="bigBorrowerPer">8.32</div>
                    </div>
                </div>
            </div>


            <div class="about-content" id="yybgDiv" style="display: none;">
                <div class="tableDiv">
                    <a href="https://www.pujinziben.com/upload/operatereport/front/2017/12/20171206145349608.pdf" download=""><img class="yybgImg" alt="" src="<%=path%>/static/images/infoshow/20171206145342235.jpg"></a><a href="http://pujinziben.com/upload/operatereport/front/2017/11/20171103084426675.pdf" download=""><img class="yybgImg" alt="" src="<%=path%>/static/images/infoshow/20171103084409964.jpg"></a><a href="http://www.pujinziben.com/upload/operatereport/front/2017/10/20171010103911597.pdf" download=""><img class="yybgImg" alt="" src="<%=path%>/static/images/infoshow/20171010103706853.jpg"></a><a href="http://www.pujinziben.com/upload/operatereport/front/2017/9/20170902163654022.pdf" download=""><img class="yybgImg" alt="" src="<%=path%>/static/images/infoshow/20170902163618853.jpg"></a>
                    <a href="http://pujinziben.com/upload/operatereport/front/2017/8/20170802115615736.pdf" download=""><img class="yybgImg" alt="" src="<%=path%>/static/images/infoshow/20170802115538445.jpg"></a><a href="https://pujinziben.com/upload/yybg/201707041659007394.pdf" download=""><img class="yybgImg" alt="" src="<%=path%>/static/images/infoshow/201707041658181221.png"></a><a href="https://www.pujinziben.com/upload/yybg/201706021854322124.pdf" download=""><img class="yybgImg" alt="" src="<%=path%>/static/images/infoshow/201706021848519136.jpg"></a><a href="https://www.pujinziben.com:8443/upload/yybg/201705050916342143.pdf" download=""><img class="yybgImg" alt="" src="<%=path%>/static/images/infoshow/201705050915048087.jpg"></a>
                    <a href="https://www.pujinziben.com/upload/yybg/201704101141308789.pdf" download=""><img class="yybgImg" alt="" src="<%=path%>/static/images/infoshow/201704101141172039.png"></a><a href="http://www.pujinziben.com/upload/yybg/201704061519519851.pdf" download=""><img class="yybgImg" alt="" src="<%=path%>/static/images/infoshow/20170406151936564.jpg"></a><a href="http://www.pujinziben.com/upload/yybg/201704101103162901.pdf" download=""><img class="yybgImg" alt="" src="<%=path%>/static/images/infoshow/201702201718479704.jpg"></a>
                </div>
            </div>
            <!-- end -->
        </div>
    </div>
</div>
</div>
<!-- 网站底部-->
<%@include file="../common/footer.jsp" %>


<script type="text/javascript" src="<%=path%>/static/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/infoshow/countUp.min.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/infoshow/about.js"></script>
<script type="text/javascript" src="<%=path%>/static/js/common.js"></script>

</body></html>
