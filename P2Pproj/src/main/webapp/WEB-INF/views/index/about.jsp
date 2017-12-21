<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>关于我们平台</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="<%=path%>/static/css/common.css" rel="stylesheet" />
    <link href="<%=path%>/static/css/about.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<%=path%>/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/static/js/common.js"></script>
</head>
<body>
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
                <h1 class="title">公司简介</h1>
                <p class="mt20 cn_line"> 亿人宝（www.yirenbao.com）为安徽省亿人宝投资管理有限公司旗下的互联网金融服务平台，创办于2015年。安徽省亿人宝投资管理有限公司是经工商行政管理局批准，专业从事“金融服务”业务的公司。<br>
                </p>
                <p class="cn_line mt20"> 亿人宝（www.yirenbao.com）作为安徽省内实行真正资金第三方托管的互联网金融平台，旨在利用互联网技术，创新金融产品与服务，为大众投资者提供安全、稳健、平民化的理财途径，为中小微企业及创业个人提供快速、便捷、低成本的融资渠道。通过互联网与传统金融相结合，扶持中小微企业成长，助力地方实体经济，推动金融创新。<br>
                </p>
                <p class="cn_line mt20"> 在互联网金融发展迅猛的今天，亿人宝经营团队凭借在银行业多年的从业经验，坚持走差异化路线，立足本土市场，突出行业特色，坚持信贷投向与当地最具潜力的产业和最有发展前景的实业挂钩。通过完善的信用评估及风控体系，亿人宝真正做到安全、透明、专业，在使信贷业务长期、稳健、可持续发展的同时，让“大众金融快捷定制”的目标得以实现。 </p>
            </div>
        </div>
    </div>
</div>
<!-- 网站底部-->
<%@include file="../common/footer.jsp" %>
    <div class="ft-record">
        <div class="ft-approve clearfix"><a class="icon-approve approve-0 fadeIn-2s" target="_blank" href="#"></a><a class="icon-approve approve-1 fadeIn-2s" target="_blank" href="#"></a><a class="icon-approve approve-2 fadeIn-2s" target="_blank" href="#"></a><a class="icon-approve approve-3 fadeIn-2s" target="_blank" href="#"></a></div>
        <div class="ft-identity">©2017 亿人宝 All rights reserved&nbsp;&nbsp;&nbsp;<span class="color-e6">|</span>&nbsp;&nbsp;&nbsp;安徽省亿人宝投资管理有限公司&nbsp;&nbsp;&nbsp;<span class="color-e6">|</span>&nbsp;&nbsp;&nbsp;<a target="_blank" href="http://www.miitbeian.gov.cn/">皖ICP备12345678号-1</a></div>
    </div>
</div>
</body>
</html>
