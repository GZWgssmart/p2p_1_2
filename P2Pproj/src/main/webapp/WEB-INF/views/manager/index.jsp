<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>亿人宝后台管理系统</title>
    <jsp:include page="../common/css.jsp"/>
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element" style="text-align: center">
                        <span>
                              <img alt="image" class="img-circle" src="<%=path%>/static/images/profile_small.jpg"/>
                             </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="javascript:void(0);">
                                <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">小美</strong>
                             </span> <span class="text-muted text-xs block">超级管理员 <b class="caret"></b></span> </span>
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li>
                                <a class="J_menuItem" href="">修改资料</a>
                            </li>
                            <li>
                                <a href="<%=path%>/Huser/logout">安全退出</a>
                            </li>
                        </ul>
                    </div>
                    <div class="logo-element">宝
                    </div>
                </li>
                <li>
                    <a href="javascript:void(0);">
                        <i class="fa fa-th-large"></i>
                        <span class="nav-label">用户管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="<%=path%>/page/users">申请借款列表</a>
                        </li>
                        <li><a class="J_menuItem" href="<%=path%>/recommend/page">推荐管理</a>
                        </li>
                        <li><a class="J_menuItem" href="<%=path%>/logMoney/list">资金流向管理</a>
                        </li>
                        <li><a class="J_menuItem" href="<%=path%>/logTx/init">用户提现记录</a>
                        </li>
                        <li><a class="J_menuItem" href="<%=path%>/luser/loginlog">登录日志</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:void(0);">
                        <i class="fa fa fa-globe"></i>
                        <span class="nav-label">审核管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="<%=path%>/shborrow/page">借款审核</a>
                        </li>
                        <li><a a class="J_menuItem" href="">认证审核</a>
                        </li>
                        <li><a a class="J_menuItem" href="<%=path%>/txCheck/init">提现审核</a>
                        </li>
                        <li><a a class="J_menuItem" href="">论坛</a>
                        </li>
                        <li><a a class="J_menuItem" href="">代码编辑器</a>
                        </li>
                        <li><a a class="J_menuItem" href="">模态窗口</a>
                        </li>
                        <li><a a class="J_menuItem" href="">表单验证</a>
                        </li>
                        <li><a a class="J_menuItem" href="">树形视图</a>
                        </li>
                        <li><a a class="J_menuItem" href="">聊天窗口</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="javascript:void(0);">
                        <i class="fa fa-bar-chart-o"></i>
                        <span class="nav-label">图表</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a a class="J_menuItem" href="">百度ECharts</a>
                        </li>
                        <li><a a class="J_menuItem" href="">Flot</a>
                        </li>
                        <li><a a class="J_menuItem" href="">Morris.js</a>
                        </li>
                        <li><a a class="J_menuItem" href="">Rickshaw</a>
                        </li>
                        <li><a a class="J_menuItem" href="">Peity</a>
                        </li>
                        <li><a a class="J_menuItem" href="">Sparkline</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:void(0);">
                        <i class="fa fa-edit"></i>
                        <span class="nav-label">表单</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a a class="J_menuItem" href="">基本表单</a>
                        </li>
                        <li><a a class="J_menuItem" href="">表单验证</a>
                        </li>
                        <li><a a class="J_menuItem" href="">高级插件</a>
                        </li>
                        <li><a a class="J_menuItem" href="">步骤条</a>
                        </li>
                        <li><a a class="J_menuItem" href="">百度WebUploader</a>
                        </li>
                        <li><a a class="J_menuItem" href="">文件上传</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:void(0);">
                        <i class="fa fa-desktop"></i>
                        <span class="nav-label">页面</span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a a class="J_menuItem" href="">联系人</a>
                        </li>
                        <li><a a class="J_menuItem" href="">个人资料</a>
                        </li>
                        <li><a a class="J_menuItem" href="">项目</a>
                        </li>
                        <li><a a class="J_menuItem" href="">项目详情</a>
                        </li>
                        <li><a a class="J_menuItem" href="">文件管理器</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:void(0);">
                        <i class="fa fa-files-o"></i>
                        <span class="nav-label">其他页面</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a a class="J_menuItem" href="">搜索结果</a>
                        </li>
                        <li><a a class="J_menuItem" href="">登录超时</a>
                        </li>
                        <li><a a class="J_menuItem" href="">404页面</a>
                        </li>
                        <li><a a class="J_menuItem" href="">500页面</a>
                        </li>
                        <li><a a class="J_menuItem" href="">空白页</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="javascript:void(0);">
                        <i class="fa fa-flask"></i>
                        <span class="nav-label">UI元素</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a a class="J_menuItem" href="">排版</a>
                        </li>
                        <li><a a class="J_menuItem" href="">字体图标</a>
                        </li>
                        <li><a a class="J_menuItem" href="">阿里巴巴矢量图标库</a>
                        </li>
                        <li><a a class="J_menuItem" href="">拖动面板</a>
                        </li>
                        <li><a a class="J_menuItem" href="">按钮</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:void(0);">
                        <i class="fa fa-table"></i>
                        <span class="nav-label">表格</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li><a a class="J_menuItem" href="">基本表格</a>
                        </li>
                        <li><a a class="J_menuItem" href="">数据表格(DataTables)</a>
                        </li>
                        <li><a a class="J_menuItem" href="">jqGrid</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i
                        class="fa fa-bars"></i> </a>
                    <form role="search" class="navbar-form-custom" method="post" action="">
                        <div class="form-group">
                            <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search"
                                   id="top-search">
                        </div>
                    </form>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <span class="m-r-sm text-muted welcome-message"><a href="" title="返回首页"><i
                                class="fa fa-home"></i></a>欢迎进入亿人宝管理员中心</span>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="">
                            <i class="fa fa-envelope"></i> <span class="label label-warning">16</span>
                        </a>
                        <ul class="dropdown-menu dropdown-messages">
                            <li>
                                <div class="dropdown-messages-box">
                                    <a href="" class="pull-left">
                                        <img alt="image" class="img-circle"
                                             src="<%=path%>/static/plugin/bootstrap/img/a7.jpg">
                                    </a>
                                    <div class="media-body">
                                        <small class="pull-right">46小时前</small>
                                        <strong>小四</strong> 项目已处理完结
                                        <br>
                                        <small class="text-muted">3天前 2014.11.8</small>
                                    </div>
                                </div>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="dropdown-messages-box">
                                    <a href="" class="pull-left">
                                        <img alt="image" class="img-circle"
                                             src="<%=path%>/static/plugin/bootstrap/img/a4.jpg">
                                    </a>
                                    <div class="media-body ">
                                        <small class="pull-right text-navy">25小时前</small>
                                        <strong>国民岳父</strong> 这是一条测试信息
                                        <br>
                                        <small class="text-muted">昨天</small>
                                    </div>
                                </div>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a href="">
                                        <i class="fa fa-envelope"></i> <strong> 查看所有消息</strong>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="">
                            <i class="fa fa-bell"></i> <span class="label label-primary">8</span>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">
                            <li>
                                <a href="">
                                    <div>
                                        <i class="fa fa-envelope fa-fw"></i> 您有16条未读消息
                                        <span class="pull-right text-muted small">4分钟前</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="">
                                    <div>
                                        <i class="fa fa-qq fa-fw"></i> 3条新回复
                                        <span class="pull-right text-muted small">12分钟钱</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a href="">
                                        <strong>查看所有 </strong>
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="<%=path%>/Huser/logout">
                            <i class="fa fa-sign-out"></i> 退出
                        </a>
                    </li>
                </ul>
            </nav>
        </div>


        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:void(0);" class="active J_menuTab" data-id="">首页</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                    </li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>
            <a href="<%=path%>/Huser/logout" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="<%=path%>/page/managerindex"
                    frameborder="0" data-id=""></iframe>
            <div class="footer">
                <div class="pull-right">&copy; 2017-2018 <a href="" target="_blank">亿人宝理财平台</a>
                </div>
            </div>
        </div>
    </div>

<jsp:include page="../common/js.jsp"/>
</body>
</html>