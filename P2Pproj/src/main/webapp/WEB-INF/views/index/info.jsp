<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>亿人宝-我要投资</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="<%=path%>/static/css/common.css" rel="stylesheet" />
    <link href="<%=path%>/static/css/index.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>/static/css/detail.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<%=path%>/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/static/js/common.js"></script>
    <script type="text/javascript"  src="<%=path%>/static/js/ablumn.js"></script>
    <script type="text/javascript"  src="<%=path%>/static/js/plugins.js"></script>
    <script type="text/javascript"  src="<%=path%>/static/js/detail.js"></script>
</head>
<body>
<!-- 网站头部-->
<%@include file="../common/header.jsp"%>
<!--信息详细-->
<div class="item-detail wrap">
    <div class="breadcrumbs"> <a href="../index.jsp">首页</a>&gt; <a href="#">投资列表</a>&gt; <span class="cur">项目详情</span> </div>
    <div class="item-detail-head clearfix" data-target="sideMenu">
        <div class="hd">
            <h2><a style="color: red">${borrow.bzname}</a>/${borrow.cpname}</h2>
        </div>
        <div class="bd clearfix">
            <div class="data">
                <ul>
                    <li> <span class="f16">募集总金额</span><br>
                        <span class="f30 c-333" id="account">${borrow.zmoney}</span>元 </li>
                    <li class="relative"><span class="f16">年利率</span><br>
                        <span class="f30 c-orange">${borrow.nprofit}%</span> </li>
                    <li><span class="f16">借款期限</span><br>
                        <span class="f30 c-333">${borrow.term}</span>个月 </li>
                    <li><span class="c-888">还款方式：</span>${borrow.way}</li>
                    <li><span class="c-888">最小投标金额：</span> 100.00元 </li>
                    <li><span class="c-888">借款用途：</span>${borrow.mpurpose}</li>
                    <li class="colspan"> <span class="c-888 fl">投标进度：</span>
                        <div class="progress-bar fl"> <span style="width:${(borrow.kymoney/borrow.zmoney)*100}%"></span> </div>
                        <span class="c-green">${(borrow.kymoney/borrow.zmoney)*100}%</span> </li>
                    <li> <span class="c-888">可投标时间：</span> <span id="account_range"> ${borrow.deadline}</span> </li>
                </ul>
            </div>
            <div class="mod-right mod-status">
                <div class="inner">
                    <div class="text"> 可用金额：<span class="f24 c-333">${borrow.kymoney}</span>元<br></div>
                    <div class="input">
                        <input type="text" style="display: none" id="kymoney" value="${borrow.kymoney}">
                        <input type="text" style="display: none" id="nprofit" value="${borrow.nprofit}">
                        <input type="text" style="display: none" id="term" value="${borrow.term}">
                        <input type="text" style="display: none" id="sid" value="${borrow.sid}">
                        <input type="text" placeholder="请输入投资金额"  onkeyup="reckon()" >
                        <button type="button" id="pushAll">全投</button>
                    </div>
                </div>
        </div>
    </div>
    <div class="item-detail-body clearfix mrt30 ui-tab">
        <div class="ui-tab-nav hd"> <i class="icon-cur" style="left: 39px;"></i>
            <ul>
                <li class="nav_li active" id="nav_1"><a href="javascript:;">借款信息</a></li>
                <li class="nav_li" id="nav_2"><a href="javascript:;">投资记录</a> <i class="icon icon-num1" style="margin-left: -15px;"> <span id="tender_times">23</span> <em></em> </i> </li>
                <li class="nav_li" id="nav_3"><a href="javascript:;">还款列表</a></li>
            </ul>
        </div>
        <div class="bd">
            <div class="ui-tab-item active" style="display: block;">
                <div class="borrow-info">
                    <dl class="item">
                        <dt>
                        <h3>投资详情</h3>
                        </dt>
                        <dd>
                            <div class="text">
                                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> 产品名称：${borrow.cpname}</p>
                                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> 募集资金：${borrow.zmoney}</p>
                                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> 预期年化收益：<a style="color: red;size: 4px">${borrow.nprofit}%</a></p>
                                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> 起息时间：满标起息</p>
                                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> 资金用途：${borrow.mpurpose}</p>
                                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> 收益方式：${borrow.way}</p>
                                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> 还款来源：${borrow.hksource}</p>
                                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> 借款人介绍：${borrow.suggest}</p>
                                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> 项目描述：${borrow.xmdescrip}</p>
                                <p class="MsoNormal" style="margin-left:0cm;text-indent:0cm;"> 保障措施：${borrow.guarantee}</p>
                            </div>
                        </dd>
                    </dl>
                    <dl class="item">
                        <dt>
                        <h3>审核信息</h3>
                        </dt>
                        <dd>
                            <div class="verify clearfix">
                                <ul>
                                    <li><i class="icon icon-4"></i><br>
                                        身份证</li>
                                    <li><i class="icon icon-5"></i><br>
                                        户口本</li>
                                    <li><i class="icon icon-6"></i><br>
                                        结婚证</li>
                                    <li><i class="icon icon-7"></i><br>
                                        工作证明</li>
                                    <li><i class="icon icon-8"></i><br>
                                        工资卡流水</li>
                                    <li><i class="icon icon-9"></i><br>
                                        收入证明</li>
                                    <li><i class="icon icon-10"></i><br>
                                        征信报告</li>
                                    <li><i class="icon icon-11"></i><br>
                                        亲属调查</li>
                                </ul>
                            </div>
                        </dd>
                    </dl>
                    <dl class="item">
                        <dt>
                        <h3>风控步骤</h3>
                        </dt>
                        <dd>
                            <div class="step clearfix">
                                <ul>
                                    <li><i class="icon icon-1"></i>资料审核</li>
                                    <li><i class="icon icon-2"></i>实地调查</li>
                                    <li><i class="icon icon-3"></i>资产评估</li>
                                    <li class="no"><i class="icon icon-4"></i>发布借款</li>
                                </ul>
                            </div>
                            <div class="conclusion f16"> 结论：经风控部综合评估， <span class="c-orange">同意放款${borrow.money}元；</span> <i class="icon icon-status icon-status1"></i> </div>
                        </dd>
                    </dl>
                    <dl class="item">
                        <dt>
                        <h3>相关文件</h3>
                        </dt>
                        <dd>
                            <div class="warrant"> <span class="f14 c-888">（注：为保护借款人的个人隐私信息，实物材料对部分信息进行了隐藏处理,下面展示法人身份证，营业执照副本，企业银行账户，其他资料）</span>
                                <div class="album" id="album">
                                    <div class="album-show">
                                        <div class="loading" style="display: none;"></div>
                                        <img src="<%=path%>/static/uploads/${borrow.fpic}"> </div>
                                    <div class="album-thumb"> <a href="javascript:;" class="btn btn-prev"></a> <a href="javascript:;" class="btn btn-next"></a>
                                        <div style="visibility: visible; overflow: hidden; position: relative; z-index: 2; left: 0px; width: 1070px;" class="container" id="albumThumb">
                                            <ul style="margin: 0px; padding: 0px; position: relative; list-style-type: none; z-index: 1; width: 1926px; left: 0px;">
                                                <li style="overflow: hidden; float: left; width: 164px; height: 108px;"><a class="small_img" alt="法人身份证" title="法人身份证" id="<%=path%>/static/uploads/${borrow.fpic}"><img src="<%=path%>/static/uploads/${borrow.fpic}"></a></li>
                                                <li style="overflow: hidden; float: left; width: 164px; height: 108px;"><a class="small_img" alt="营业执照副本" title="营业执照副本" id="<%=path%>/static/uploads/${borrow.ypic}"><img src="<%=path%>/static/uploads/${borrow.ypic}"></a></li>
                                                <li style="overflow: hidden; float: left; width: 164px; height: 108px;"><a class="small_img" alt="企业银行账户" title="企业银行账户" id="<%=path%>/static/uploads/${borrow.qpic}"><img src="<%=path%>/static/uploads/${borrow.qpic}"></a></li>
                                                <li style="overflow: hidden; float: left; width: 164px; height: 108px;"><a class="small_img" alt="其他资料" title="其他资料" id="<%=path%>/static/uploads/${borrow.tpic}"><img src="<%=path%>/static/uploads/${borrow.tpic}"></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </dd>
                    </dl>
                </div>
            </div>
            <div class="ui-tab-item" style="display: none;">
                <div class="repayment-list"> 目前投标总额：<span class="c-orange">40,000.00 元</span>&nbsp;&nbsp;
                    剩余投标金额：<span class="c-orange">0.00 元</span>
                    <table border="0" cellpadding="0" cellspacing="0" width="100%">
                        <tbody>
                        <tr>
                            <th>投标人</th>
                            <th>投标金额</th>
                            <th>投标利率</th>
                            <th>投标时间</th>
                            <th>投标方式</th>
                        </tr>
                        </tbody>
                        <tbody id="repayment_content">
                        <c:forEach items="${tzbVOList}" var="d">
                            <tr>
                                <td>${d.uname}</td>
                                <td><span class="c-orange">￥${d.money}</span></td>
                                <td>${d.nprofit}</td>
                                <td>${d.time}</td>
                                <td>自动</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                        <tfoot>
                        <tr class="page-outer">
                            <td colspan="4" align="center"><div class="pagination clearfix"><span class="page" id="repayment_content_pager"><a class="disabled"> 上一页 </a><a class="curr">1</a><a href="javascript:void(0)">2</a><a href="javascript:void(0)" next="2">下一页</a><em>共2页</em>
                    <dl class="page-select">
                      <dt><span>1</span><i class="icon icon-down"></i></dt>
                      <dd style="display: none;"><a href="javascript:;" total="23" spaninterval="2" content="repayment_content">1</a><a href="javascript:;" total="23" spaninterval="2" content="repayment_content">2</a></dd>
                    </dl>
                    </span></div></td>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
            <div class="ui-tab-item" style="display: none;">
                <div class="repayment-list"> 已还本息：<span class="c-orange">0.00元</span>&nbsp;&nbsp;
                    待还本息：<span class="c-orange">40,400.00元</span>&nbsp;&nbsp;(待还本息因算法不同可能会存误差，实际金额以到账金额为准！)
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                        <tr>
                            <th>合约还款日期</th>
                            <th>期数</th>
                            <th>应还本金</th>
                            <th>应还利息</th>
                            <th>应还本息</th>
                            <th>还款状态</th>
                        </tr>
                        <tr>
                            <td>2015-10-13</td>
                            <td>1</td>
                            <td>40,000.00元</td>
                            <td>400.00元</td>
                            <td>40,400.00元</td>
                            <td>还款中</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 网站底部-->
<%@include file="../common/footer.jsp" %>
</body>
</html>
