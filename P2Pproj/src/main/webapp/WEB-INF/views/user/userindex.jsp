<%@ page import="top.zzh.common.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String name= (String) session.getAttribute(Constants.USER_IN_SESSION);
    String time=(String)request.getAttribute("time");
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>用户中心</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="<%=path%>/static/css/common.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/user.css" />
    <script type="text/javascript" src="<%=path%>/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/static/js/common.js"></script>
    <script src="<%=path%>/static/js/user.js" type="text/javascript"></script>
    <!--弹出框样式-->
    <link rel="stylesheet" href="<%=path%>/static/css/lyj/sweetalert.css"/>
    <script type="text/javascript" src="<%=path%>/static/js/lyj/sweetalert-dev.js"></script>



</head>
<body>
<%@include file="../common/header.jsp"%>
<!--个人中心-->
<div class="wrapper wbgcolor">
    <div class="w1200 personal">
        <%@include file="../common/leftList.jsp"%>
        <div class="personal-main">
            <link rel="stylesheet" type="text/css" href="<%=path%>/static/css/fileupload.less.css">
            <style type="text/css">
                .ui-fileupload-choose{
                    background:none;
                    width: 90px; height: 90px;
                    border:0px none;
                }
                .ui-fileupload-choose input{
                    width:100%;height:100%;
                }
                .ui-icon{
                    background:none;
                    width:0px;height:0px;
                }
            </style>
            <div class="pmain-profile">
                <div class="pmain-welcome"> <span class="fl"><span id="outLogin">晚上好，</span><%=name%>喝一杯下午茶，让心情放松一下~</span> <span class="fr">上次登录时间：<%=time%>
          </span> </div>
                <div class="pmain-user">
                    <div class="user-head"> <span id="clickHeadImage" class="head-img" title="点击更换头像">

                  <form  method="post" id="longinForm" name="longinForm" action="" enctype="multipart/form-data">
                  <input type="hidden" name="userPhotoUploadForm" value="userPhotoUploadForm">
                  <span id="userPhotoUploadForm:photo">

                      <c:if test="${face==null}">
                          <img id="userPhotoUploadForm:photoImage" src="<%=path%>/static/images/touxiang.png" alt="" style="width:88px;height:88px;z-index:0;">
                      </c:if>
                       <c:if test="${face!=null}">
                           <img id="userPhotoUploadForm:photoImage" src="<%=path%>/${face}" alt="" style="width:88px;height:88px;z-index:0;">
                       </c:if>

                      <i class="headframe" style="z-index:0;"></i>-
                  <div id="userPhotoUploadForm:shangchuan-btn" class="ui-fileupload ui-widget" style="z-index:0;">
                    <div class="ui-fileupload-buttonbar ui-corner-top"><span class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left ui-fileupload-choose" role="button"><span class="ui-button-icon-left ui-icon ui-c ui-icon-plusthick"></span><span class="ui-button-text ui-c"></span>
                      <input type="file" id="header" name="header" onmouseleave="check();" style="z-index:0;">
                      </span></div>
                    <div class="ui-fileupload-content ui-widget-content ui-corner-bottom">
                      <table class="ui-fileupload-files">
                        <tbody>
                        </tbody>
                      </table>
                    </div>
                  </div>
                  </span>
                  <input type="hidden" name="javax.faces.ViewState" id="javax.faces.ViewState" value="2696547217205030168:-301641994240890871" autocomplete="off">
                </form>


            </span> <span class="head-icon"> <a href="#"><i title="第三方资金账户未认证" class="headiconbg headicon01"></i></a> <a href="#"><i class="headiconbg headicon2"></i></a> <a href="#"><i class="headiconbg headicon03"></i></a> </span> </div>
                    <div class="user-info user-info1">
                        <ul>
                            <li>用户名<span onclick="exportExcel('/luser/uploadHeader','longinForm')"><%=name%></span></li>
                            <li>安全级别<span><i class="safe-level"><i class="onlevel" style="width:40%;"></i></i></span> <a href="#">[低]</a></li>
                            <li>您还未开通第三方支付账户，请 <a class="pmain-log" href="#">立即开通</a>以确保您的正常使用和资金安全。 </li>
                        </ul>
                    </div>
                </div>

                <div class="pmain-money">
                    <ul>
                        <li class="none"><span><em>账户总额</em><i id="zhze" class="markicon"></i><span class="arrow-show1" style="display:none;">可用余额+待收本息</span><span class="icon-show1" style="display:none;"></span></span> <span class="truemoney"><i class="f26 fb">0.00 </i> 元</span> </li>
                        <li><span><em>待收本息</em><i id="dsbx" class="markicon"></i><span class="arrow-show2" style="display:none;">未到账的投资项目的本金、利息总额</span><span class="icon-show2" style="display:none;"></span></span> <span class="truemoney"><i class="f26 fb">0.00 </i>元</span> </li>
                        <li><span><em>累计收益</em><i id="ljsy" class="markicon"></i><span class="arrow-show3" style="display: none;">已到账的投资收益+未到账的投资收益</span><span class="icon-show3" style="display: none;"></span></span> <span class="truemoney"><i class="f26 fb c-pink">0.00 </i> 元</span> </li>
                    </ul>
                </div>
            </div>
            <script type="text/javascript">
                //<![CDATA[
                $(function(){
                    $("#clickHeadImage").click(function(){
                        $(this).find('span').removeClass('ui-state-hover');
//                        document.getElementById("userPhotoUploadForm:shangchuan-btn_input").click();
                    });
                    var safeLevel = "低";
                    if(safeLevel=="高"){
                        $(".pmain-user .user-info li .safe-level .onlevel").css("background-color","#f1483c");
                    }

                    $("#clickHeadImage span").hover(function(){
                        $(this).removeClass('ui-state-hover');
                    });

                    var myDate = new Date();
                    var h = myDate.getHours();
                    if(h>11 && h<19){
                        $("#outLogin").html("下午好，");
                    }else if(h>18){
                        $("#outLogin").html("晚上好，");
                    }else{
                        $("#outLogin").html("上午好，");
                    }
                });
                //]]>
            </script>
            <div class="pmain-connent">
                <div id="pmain-contab" class="pmain-contab">
                    <ul>
                        <li id="pmain-contab1" class="on">回款计划</li>
                        <li id="pmain-contab2">资金记录</li>
                        <li id="pmain-contab3">投资记录</li>
                        <li class="li-other"></li>
                    </ul>
                </div>
                <div class="pmain-conmain" id="pmain-conmain">
                    <div class="pmain-conmain1">
                        <div class="pmain-contitle"> <span class="pmain-titledate">计划回款时间</span><span class="pmain-titleproject">项目</span><span class="pmain-titletype">类型</span><span class="pmain-titlemoney">回款金额</span> </div>
                        <ul style="float:left;">
                            <li><span class="pmain-titledate">2015-10-20</span><span class="pmain-titleproject">宝马汽车借贷业务</span><span class="pmain-titletype">债权转让</span><span class="pmain-titlemoney">10.00</span></li>
                            <li><span class="pmain-titledate">2015-10-20</span><span class="pmain-titleproject">宝马汽车借贷业务</span><span class="pmain-titletype">债权转让</span><span class="pmain-titlemoney">10.00</span></li>
                            <li><span class="pmain-titledate">2015-10-20</span><span class="pmain-titleproject">宝马汽车借贷业务</span><span class="pmain-titletype">债权转让</span><span class="pmain-titlemoney">10.00</span></li>
                            <li><span class="pmain-titledate">2015-10-20</span><span class="pmain-titleproject">宝马汽车借贷业务</span><span class="pmain-titletype">债权转让</span><span class="pmain-titlemoney">10.00</span></li>
                            <li><span class="pmain-titledate">2015-10-20</span><span class="pmain-titleproject">宝马汽车借贷业务</span><span class="pmain-titletype">债权转让</span><span class="pmain-titlemoney">10.00</span></li>
                            <li><span class="pmain-titledate">2015-10-20</span><span class="pmain-titleproject">宝马汽车借贷业务</span><span class="pmain-titletype">债权转让</span><span class="pmain-titlemoney">10.00</span></li>
                            <!--<div style=" width:
                                                      760px;height:200px;padding-top:100px; text-align:center;color:#d4d4d4; font-size:16px;">
                                                       <img src="images/nondata.png" width="60" height="60"><br><br>
                                                         暂无回款计划</div>-->
                        </ul>
                        <div class="pmain-morebtn" style="border-top:0;margin-top:0"></div>
                    </div>
                    <div class="pmain-conmain2" style=" display:none;">
                        <div class="pmain-contitle"> <span class="pmain-titledate">交易时间</span><span class="pmain-w100">交易类型</span><span class="pmain-w120">交易金额</span><span class="pmain-w120">余额</span><span class="pmain-w200">备注</span> </div>
                        <ul style="float:left;">
                            <li><span class="pmain-titledate">2015-10-20</span><span class="pmain-w100">债权转让</span><span class="pmain-w120 pmain-money">10.00</span><span class="pmain-w120 pmain-money">10.00</span><span class="pmain-w200">备注</span></li>
                            <!--<div style=" width:760px;height:200px;padding-top:100px; text-align:center;color:#d4d4d4; font-size:16px;">
                                                       <img src="images/nondata.png" width="60" height="60"><br><br>
                                                         暂无资金记录</div>-->
                        </ul>
                        <div class="pmain-morebtn" style="border-top:0;margin-top:0"></div>
                    </div>
                    <div class="pmain-conmain3" style=" display:none;">
                        <div class="pmain-contitle"> <span class="pmain-titledate">交易时间</span><span class="pmain-w210">项目</span><span class="pmain-w80">状态</span><span class="pmain-whb200">我的投资</span><span class="pmain-whb110">我的收益</span> </div>
                        <ul style="float:left;">
                            <li><span class="pmain-titledate">2015-10-20</span><span class="pmain-w210">债权转让</span><span class="pmain-w80 pmain-money">10.00</span><span class="pmain-whb200 pmain-money">10.00</span><span class="pmain-whb110">备注</span></li>
                            <!--	<div style=" width:760px;height:200px;padding-top:100px; text-align:center;color:#d4d4d4; font-size:16px;">
                                                          <img src="images/nondata.png" width="60" height="60"><br><br>
                                                         暂无投资记录</div>-->
                        </ul>
                        <div class="pmain-morebtn" style="border-top:0;margin-top:0"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>




<!-- 网站底部-->
<%@include file="../common/footer.jsp" %>
</body>


<script type="text/javascript">

    function check(){
        var file=document.getElementById("header").value;

        if(file!=null && file!=""){
            var form=$("#longinForm");
            form.attr('action',''+'/luser/uploadHeader');
            form.submit();
        }
    }

</script>

</html>

