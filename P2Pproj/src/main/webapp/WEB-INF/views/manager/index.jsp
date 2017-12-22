<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <title>后台管理员</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="<%=path%>/static/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="<%=path%>/static/css/font-awesome.css?v=4.3.0" rel="stylesheet">
    <link href="<%=path%>/static/css/morris-0.4.3.min.css" rel="stylesheet">
    <link href="<%=path%>/static/css/jquery.gritter.css" rel="stylesheet">
    <link href="<%=path%>/static/css/animate.css" rel="stylesheet">
    <link href="<%=path%>/static/css/style.css?v=2.2.0" rel="stylesheet">
</head>
<body>
<div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="<%=path%>/static/images/profile_small.jpg" />
                             </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.jsp#">
                                <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">小美</strong>
                             </span> <span class="text-muted text-xs block">超级管理员 <b class="caret"></b></span> </span>
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a href="">修改头像</a>
                            </li>
                            <li><a href="">个人资料</a>
                            </li>
                            <li><a href="">联系我们</a>
                            </li>
                            <li><a href="">信箱</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="<%=path%>/Huser/logout">安全退出</a>
                            </li>
                        </ul>
                    </div>
                    <div class="logo-element">
                        HT
                    </div>
                </li>
                <li class="active">
                    <a href="index.jsp"><i class="fa fa-th-large"></i> <span class="nav-label">用户</span> <span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="<%=path%>/page/users">前台用户列表</a>
                        </li>
                        <li><a class="J_menuItem" href="">主页示例二</a>
                        </li>
                        <li><a class="J_menuItem" href="">主页示例三</a>
                        </li>
                        <li><a class="J_menuItem" href="">主页示例四</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="index.jsp#"><i class="fa fa fa-globe"></i> <span class="nav-label">v2.0新增</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="">Toastr通知</a>
                        </li>
                        <li><a href="">嵌套列表</a>
                        </li>
                        <li><a href="">时间轴</a>
                        </li>
                        <li><a href="">论坛</a>
                        </li>
                        <li><a href="">代码编辑器</a>
                        </li>
                        <li><a href="">模态窗口</a>
                        </li>
                        <li><a href="">表单验证</a>
                        </li>
                        <li><a href="">树形视图</a>
                        </li>
                        <li><a href="">聊天窗口</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="index.jsp#"><i class="fa fa-bar-chart-o"></i> <span class="nav-label">图表</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="">百度ECharts</a>
                        </li>
                        <li><a href="">Flot</a>
                        </li>
                        <li><a href="">Morris.js</a>
                        </li>
                        <li><a href="">Rickshaw</a>
                        </li>
                        <li><a href="">Peity</a>
                        </li>
                        <li><a href="">Sparkline</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="index.jsp#"><i class="fa fa-edit"></i> <span class="nav-label">表单</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="">基本表单</a>
                        </li>
                        <li><a href="">表单验证</a>
                        </li>
                        <li><a href="">高级插件</a>
                        </li>
                        <li><a href="">步骤条</a>
                        </li>
                        <li><a href="">百度WebUploader</a>
                        </li>
                        <li><a href="">文件上传</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="index.jsp#"><i class="fa fa-desktop"></i> <span class="nav-label">页面</span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="">联系人</a>
                        </li>
                        <li><a href="">个人资料</a>
                        </li>
                        <li><a href="">项目</a>
                        </li>
                        <li><a href="">项目详情</a>
                        </li>
                        <li><a href="">文件管理器</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="index.jsp#"><i class="fa fa-files-o"></i> <span class="nav-label">其他页面</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="">搜索结果</a>
                        </li>
                        <li><a href="">登录超时</a>
                        </li>
                        <li><a href="">404页面</a>
                        </li>
                        <li><a href="">500页面</a>
                        </li>
                        <li><a href="">空白页</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="index.jsp#"><i class="fa fa-flask"></i> <span class="nav-label">UI元素</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="">排版</a>
                        </li>
                        <li><a href="">字体图标</a>
                        </li>
                        <li><a href="">阿里巴巴矢量图标库</a>
                        </li>
                        <li><a href="">拖动面板</a>
                        </li>
                        <li><a href="">按钮</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="index.jsp#"><i class="fa fa-table"></i> <span class="nav-label">表格</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="">基本表格</a>
                        </li>
                        <li><a href="">数据表格(DataTables)</a>
                        </li>
                        <li><a href="">jqGrid</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>

    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="index.html#"><i class="fa fa-bars"></i> </a>
                    <form role="search" class="navbar-form-custom" method="post" action="search_results.html">
                        <div class="form-group">
                            <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
                        </div>
                    </form>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <span class="m-r-sm text-muted welcome-message"><a href="index.html" title="返回首页"><i class="fa fa-home"></i></a>欢迎进入亿人宝后台</span>
                    </li>
                    <li>
                        <a href="<%=path%>/Huser/logout">
                            <i class="fa fa-sign-out"></i> 退出
                        </a>
                    </li>
                </ul>
            </nav>
        </div>

        <div class="wrapper wrapper-content">
            <div class="row">
                <div class="col-lg-3">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-success pull-right">月</span>
                            <h5>收入</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins">40 886,200</h1>
                            <div class="stat-percent font-bold text-success">98% <i class="fa fa-bolt"></i>
                            </div>
                            <small>总收入</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-info pull-right">全年</span>
                            <h5>订单</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins">275,800</h1>
                            <div class="stat-percent font-bold text-info">20% <i class="fa fa-level-up"></i>
                            </div>
                            <small>新订单</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-primary pull-right">今天</span>
                            <h5>访客</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins">106,120</h1>
                            <div class="stat-percent font-bold text-navy">44% <i class="fa fa-level-up"></i>
                            </div>
                            <small>新访客</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-danger pull-right">最近一个月</span>
                            <h5>活跃用户</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins">80,600</h1>
                            <div class="stat-percent font-bold text-danger">38% <i class="fa fa-level-down"></i>
                            </div>
                            <small>12月</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>订单</h5>
                            <div class="pull-right">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-xs btn-white active">天</button>
                                    <button type="button" class="btn btn-xs btn-white">月</button>
                                    <button type="button" class="btn btn-xs btn-white">年</button>
                                </div>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="row">
                                <div class="col-lg-9">
                                    <div class="flot-chart">
                                        <div class="flot-chart-content" id="flot-dashboard-chart"></div>
                                    </div>
                                </div>
                                <div class="col-lg-3">
                                    <ul class="stat-list">
                                        <li>
                                            <h2 class="no-margins">2,346</h2>
                                            <small>订单总数</small>
                                            <div class="stat-percent">48% <i class="fa fa-level-up text-navy"></i>
                                            </div>
                                            <div class="progress progress-mini">
                                                <div style="width: 48%;" class="progress-bar"></div>
                                            </div>
                                        </li>
                                        <li>
                                            <h2 class="no-margins ">4,422</h2>
                                            <small>最近一个月订单</small>
                                            <div class="stat-percent">60% <i class="fa fa-level-down text-navy"></i>
                                            </div>
                                            <div class="progress progress-mini">
                                                <div style="width: 60%;" class="progress-bar"></div>
                                            </div>
                                        </li>
                                        <li>
                                            <h2 class="no-margins ">9,180</h2>
                                            <small>最近一个月销售额</small>
                                            <div class="stat-percent">22% <i class="fa fa-bolt text-navy"></i>
                                            </div>
                                            <div class="progress progress-mini">
                                                <div style="width: 22%;" class="progress-bar"></div>
                                            </div>
                                        </li>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>


            <div class="row">
                <div class="col-lg-4">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>消息</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content ibox-heading">
                            <h3><i class="fa fa-envelope-o"></i> 新消息</h3>
                            <small><i class="fa fa-tim"></i> 您有22条未读消息</small>
                        </div>
                        <div class="ibox-content">
                            <div class="feed-activity-list">

                                <div class="feed-element">
                                    <div>
                                        <small class="pull-right text-navy">1月前</small>
                                        <strong>井幽幽</strong>
                                        <div>有人说：“一辈子很长，要跟一个有趣的人在一起”。我想关注我的人，应该是那种喜欢找乐子也乐意分享乐趣的人，你们一定挺优秀的。所以单身的应该在这条留言，互相勾搭一下。特别有钱人又帅可以直接私信我！</div>
                                        <small class="text-muted">4月11日 00:00</small>
                                    </div>
                                </div>

                                <div class="feed-element">
                                    <div>
                                        <small class="pull-right">2月前</small>
                                        <strong>马伯庸 </strong>
                                        <div>又方便，又防水，手感又好，还可以用手机遥控。简直是拍戏利器，由其是跟老师们搭戏的时候…想想还有点小激动啊，嘿嘿。</div>
                                        <small class="text-muted">11月8日 20:08 </small>
                                    </div>
                                </div>

                                <div class="feed-element">
                                    <div>
                                        <small class="pull-right">5月前</small>
                                        <strong>芒果宓 </strong>
                                        <div>一个完整的梦。</div>
                                        <small class="text-muted">11月8日 20:08 </small>
                                    </div>
                                </div>

                                <div class="feed-element">
                                    <div>
                                        <small class="pull-right">5月前</small>
                                        <strong>刺猬尼克索</strong>
                                        <div>哈哈哈哈 你卖什么萌啊! 蠢死了</div>
                                        <small class="text-muted">11月8日 20:08 </small>
                                    </div>
                                </div>


                                <div class="feed-element">
                                    <div>
                                        <small class="pull-right">5月前</small>
                                        <strong>老刀99</strong>
                                        <div>昨天评论里你见过最“温暖和感人”的诗句，整理其中经典100首，值得你收下学习。</div>
                                        <small class="text-muted">11月8日 20:08 </small>
                                    </div>
                                </div>
                                <div class="feed-element">
                                    <div>
                                        <small class="pull-right">5月前</small>
                                        <strong>娱乐小主 </strong>
                                        <div>你是否想过记录自己的梦？你是否想过有自己的一个记梦本？小时候写日记，没得写了就写昨晚的梦，后来变成了习惯………翻了一晚上自己做过的梦，想哭，想笑…</div>
                                        <small class="text-muted">11月8日 20:08 </small>
                                    </div>
                                </div>
                                <div class="feed-element">
                                    <div>
                                        <small class="pull-right">5月前</small>
                                        <strong>DMG电影 </strong>
                                        <div>《和外国男票乘地铁，被中国大妈骂不要脸》妹子实在委屈到不行，中国妹子找外国男友很令人不能接受吗？大家都来说说自己的看法</div>
                                        <small class="text-muted">11月8日 20:08 </small>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-lg-8">

                    <div class="row">
                        <div class="col-lg-6">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h5>用户项目列表</h5>
                                    <div class="ibox-tools">
                                        <a class="collapse-link">
                                            <i class="fa fa-chevron-up"></i>
                                        </a>
                                        <a class="close-link">
                                            <i class="fa fa-times"></i>
                                        </a>
                                    </div>
                                </div>
                                <div class="ibox-content">
                                    <table class="table table-hover no-margins">
                                        <thead>
                                        <tr>
                                            <th>状态</th>
                                            <th>日期</th>
                                            <th>用户</th>
                                            <th>值</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td><small>进行中...</small>
                                            </td>
                                            <td><i class="fa fa-clock-o"></i> 11:20</td>
                                            <td>青衣5858</td>
                                            <td class="text-navy"> <i class="fa fa-level-up"></i> 24%</td>
                                        </tr>
                                        <tr>
                                            <td><span class="label label-warning">已取消</span>
                                            </td>
                                            <td><i class="fa fa-clock-o"></i> 10:40</td>
                                            <td>徐子崴</td>
                                            <td class="text-navy"> <i class="fa fa-level-up"></i> 66%</td>
                                        </tr>
                                        <tr>
                                            <td><small>进行中...</small>
                                            </td>
                                            <td><i class="fa fa-clock-o"></i> 01:30</td>
                                            <td>姜岚昕</td>
                                            <td class="text-navy"> <i class="fa fa-level-up"></i> 54%</td>
                                        </tr>
                                        <tr>
                                            <td><small>进行中...</small>
                                            </td>
                                            <td><i class="fa fa-clock-o"></i> 02:20</td>
                                            <td>武汉大兵哥</td>
                                            <td class="text-navy"> <i class="fa fa-level-up"></i> 12%</td>
                                        </tr>
                                        <tr>
                                            <td><small>进行中...</small>
                                            </td>
                                            <td><i class="fa fa-clock-o"></i> 09:40</td>
                                            <td>荆莹儿</td>
                                            <td class="text-navy"> <i class="fa fa-level-up"></i> 22%</td>
                                        </tr>
                                        <tr>
                                            <td><span class="label label-primary">已完成</span>
                                            </td>
                                            <td><i class="fa fa-clock-o"></i> 04:10</td>
                                            <td>栾某某</td>
                                            <td class="text-navy"> <i class="fa fa-level-up"></i> 66%</td>
                                        </tr>
                                        <tr>
                                            <td><small>进行中...</small>
                                            </td>
                                            <td><i class="fa fa-clock-o"></i> 12:08</td>
                                            <td>范范范二妮</td>
                                            <td class="text-navy"> <i class="fa fa-level-up"></i> 23%</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h5>任务列表</h5>
                                    <div class="ibox-tools">
                                        <a class="collapse-link">
                                            <i class="fa fa-chevron-up"></i>
                                        </a>
                                        <a class="close-link">
                                            <i class="fa fa-times"></i>
                                        </a>
                                    </div>
                                </div>
                                <div class="ibox-content">
                                    <ul class="todo-list m-t small-list ui-sortable">
                                        <li>
                                            <a href="widgets.html#" class="check-link"><i class="fa fa-check-square"></i> </a>
                                            <span class="m-l-xs todo-completed">开会</span>

                                        </li>
                                        <li>
                                            <a href="widgets.html#" class="check-link"><i class="fa fa-check-square"></i> </a>
                                            <span class="m-l-xs  todo-completed">项目开发</span>

                                        </li>
                                        <li>
                                            <a href="widgets.html#" class="check-link"><i class="fa fa-square-o"></i> </a>
                                            <span class="m-l-xs">修改bug</span>
                                            <small class="label label-primary"><i class="fa fa-clock-o"></i> 1小时</small>
                                        </li>
                                        <li>
                                            <a href="widgets.html#" class="check-link"><i class="fa fa-square-o"></i> </a>
                                            <span class="m-l-xs">修改bug</span>
                                            <small class="label label-primary"><i class="fa fa-clock-o"></i> 1小时</small>
                                        </li>
                                        <li>
                                            <a href="widgets.html#" class="check-link"><i class="fa fa-square-o"></i> </a>
                                            <span class="m-l-xs">修改bug</span>
                                            <small class="label label-primary"><i class="fa fa-clock-o"></i> 1小时</small>
                                        </li>
                                        <li>
                                            <a href="widgets.html#" class="check-link"><i class="fa fa-square-o"></i> </a>
                                            <span class="m-l-xs">修改bug</span>
                                            <small class="label label-primary"><i class="fa fa-clock-o"></i> 1小时</small>
                                        </li>
                                        <li>
                                            <a href="widgets.html#" class="check-link"><i class="fa fa-square-o"></i> </a>
                                            <span class="m-l-xs">修改bug</span>
                                            <small class="label label-primary"><i class="fa fa-clock-o"></i> 1小时</small>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="ibox float-e-margins">
                                <div class="ibox-title">
                                    <h5>交易地区</h5>
                                    <div class="ibox-tools">
                                        <a class="collapse-link">
                                            <i class="fa fa-chevron-up"></i>
                                        </a>
                                        <a class="close-link">
                                            <i class="fa fa-times"></i>
                                        </a>
                                    </div>
                                </div>
                                <div class="ibox-content">

                                    <div class="row">
                                        <div class="col-lg-6">
                                            <table class="table table-hover margin bottom">
                                                <thead>
                                                <tr>
                                                    <th style="width: 1%" class="text-center">序号</th>
                                                    <th>交易</th>
                                                    <th class="text-center">日期</th>
                                                    <th class="text-center">销售额</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <tr>
                                                    <td class="text-center">1</td>
                                                    <td>防盗门
                                                        </small>
                                                    </td>
                                                    <td class="text-center small">2014.9.15</td>
                                                    <td class="text-center"><span class="label label-primary">&yen;483.00</span>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td class="text-center">2</td>
                                                    <td>衣柜
                                                    </td>
                                                    <td class="text-center small">2014.9.15</td>
                                                    <td class="text-center"><span class="label label-primary">&yen;327.00</span>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td class="text-center">3</td>
                                                    <td>防盗门
                                                    </td>
                                                    <td class="text-center small">2014.9.15</td>
                                                    <td class="text-center"><span class="label label-warning">&yen;125.00</span>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td class="text-center">4</td>
                                                    <td>橱柜</td>
                                                    <td class="text-center small">2014.9.15</td>
                                                    <td class="text-center"><span class="label label-primary">&yen;344.00</span>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="text-center">5</td>
                                                    <td>手机</td>
                                                    <td class="text-center small">2014.9.15</td>
                                                    <td class="text-center"><span class="label label-primary">&yen;235.00</span>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="text-center">6</td>
                                                    <td>显示器</td>
                                                    <td class="text-center small">2014.9.15</td>
                                                    <td class="text-center"><span class="label label-primary">&yen;100.00</span>
                                                    </td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <div class="col-lg-6">
                                            <div id="world-map" style="height: 300px;"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="footer">
            <div class="pull-right">
                By：<a href="http://localhost:8080" target="_blank">亿人宝</a>
            </div>
            <div>
                <strong>Copyright</strong> 亿人宝 &copy; 2017
            </div>
        </div>
    </div>
</div>
</div>

<script src="<%=path%>/static/js/jquery-2.1.1.min.js"></script>
<script src="<%=path%>/static/js/bootstrap.min.js?v=3.4.0"></script>
<script src="<%=path%>/static/js/jquery.metisMenu.js"></script>
<script src="<%=path%>/static/js/jquery.slimscroll.min.js"></script>
<script src="<%=path%>/static/js/hplus.js?v=2.2.0"></script>
<script src="<%=path%>/static/js/pace.min.js"></script>
</body>
</html>