<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">
        <title>媒体报道</title>
        <link href="<%=path%>/static/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
        <link href="<%=path%>/static/css/font-awesome.css?v=4.3.0" rel="stylesheet">
        <link href="<%=path%>/static/css/animate.css" rel="stylesheet">
        <link href="<%=path%>/static/css/style.css?v=2.2.0" rel="stylesheet">
        <!--simditor css-->
        <link href="<%=path%>/static/plugin/bootstrap/css/plugins/simditor/simditor.css" rel="stylesheet" type="text/css"/>
        <!--上传文件及图片-->
        <link href="<%=path%>/static/plugin/bootstrap/css/plugins/webuploader/webuploader.css" rel="stylesheet" type="text/css">
        <link href="<%=path%>/static/plugin/bootstrap/css/demo/webuploader-demo.min.css"rel="stylesheet" type="text/css">
    </head>
<body>
<div id="wrapper">
      <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>新增媒体报道</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="index.html">新增</a>
                    </li>
                    <li>
                        <a>修改</a>
                    </li>
                    <li>
                        <strong>媒体报道列表</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">

            </div>
        </div>
        <div class="wrapper wrapper-content">

            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>新增媒体报道</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="form_editors.html#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="">选项1</a>
                                    </li>
                                    <li><a href="">选项2</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>

                        <div class="ibox-content">
                                <form method="post" action="<%=path%>/media/save" class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">标题</label>
                                        <div class="col-sm-10">
                                            <input type="text" id = "title" name ="title" placeholder="请输入标题" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">内容</label>
                                        <div class="col-sm-10">
                                              <textarea id="content"  name="content" style="height:250px;width:1053px" autofocus></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">封面图片</label>
                                        <div class=" col-sm-10" style="margin-left: 198px">
                                            <div class="page-container" style ="">
                                                  <div id="uploader" class="wu-example">
                                                    <div class="queueList">
                                                        <div id="dndArea" class="placeholder">
                                                            <div id="filePicker"></div>
                                                            <p>您可以尝试文件拖拽，使用QQ截屏工具，然后激活窗口后粘贴，或者点击添加图片按钮，或将照片拖到这里，单次最多可选300张</p>
                                                        </div>
                                                    </div>
                                                    <div class="statusBar" style="display:none;">
                                                        <div class="progress">
                                                            <span class="text">0%</span>
                                                            <span class="percentage"></span>
                                                        </div>
                                                        <div class="info"></div>
                                                        <div class="btns">
                                                            <div id="filePicker2"></div>
                                                            <div class="uploadBtn">开始上传</div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">报道日期</label>
                                        <div class="col-sm-10">
                                            <input type="date" placeholder="请选择报道日期" class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">报道地址</label>
                                        <div class="col-sm-10">
                                            <input type="text" id = "url" name ="url" placeholder="请输入报道地址" class="form-control">
                                        </div>
                                    </div>
                                </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<!-- Mainly scripts -->
<script src="<%=path%>/static/js/jquery.min.js"></script>
<script src="<%=path%>/static/js/bootstrap.min.js?v=3.4.0"></script>
<script src="<%=path%>/static/js/jquery.metisMenu.js"></script>
<script src="<%=path%>/static/js/jquery.slimscroll.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="<%=path%>/static/js/hplus.js?v=2.2.0"></script>
<script src="<%=path%>/static/js/pace.min.js"></script>
<!--UEditor js-->
<script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
    var ue = UE.getEditor('content');
</script>
<%--<!-- simditor -->--%>
<%--<script type="text/javascript" src="<%=path%>/static/plugin/bootstrap/js/plugins/simditor/module.js"></script>--%>
<%--<script type="text/javascript" src="<%=path%>/static/plugin/bootstrap/js/plugins/simditor/uploader.js"></script>--%>
<%--<script type="text/javascript" src="<%=path%>/static/plugin/bootstrap/js/plugins/simditor/hotkeys.js"></script>--%>
<%--<script type="text/javascript" src="<%=path%>/static/plugin/bootstrap/js/plugins/simditor/simditor.js"></script>--%>
<%--<script type="text/javascript" src="http://www.zi-han.net/theme/hplus/js/plugins/simditor/page-demo.js"></script>--%>
<%--<script>--%>
    <%--$(document).ready(function () {--%>
        <%--var content = new Simditor({--%>
            <%--textarea: $('#content')--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>
<!-- Web Uploader -->
<script type="text/javascript">
    // 添加全局站点信息
    var BASE_URL = 'js/plugins/webuploader';
</script>
<script src="<%=path%>/static/plugin/bootstrap/js/plugins/webuploader/webuploader.min.js"></script>
<script src="<%=path%>/static/plugin/bootstrap/js/demo/webuploader-demo.min.js"></script>
<!-- layerDate plugin javascript -->
<%--<script src="<%=path%>/static/plugin/bootstrap/js/plugins/layer/laydate/laydate.js"></script>--%>
<%--<script>--%>
    <%--//外部js调用--%>
    <%--laydate({--%>
        <%--elem: '#hello', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'--%>
        <%--event: 'focus' //响应事件。如果没有传入event，则按照默认的click--%>
    <%--});--%>

    <%--//日期范围限制--%>
    <%--var start = {--%>
        <%--elem: '#start',--%>
        <%--format: 'YYYY/MM/DD',--%>
        <%--min: laydate.now(), //设定最小日期为当前日期--%>
        <%--max: '2099-06-16', //最大日期--%>
        <%--istime: true,--%>
        <%--istoday: false,--%>
        <%--choose: function (datas) {--%>
            <%--end.min = datas; //开始日选好后，重置结束日的最小日期--%>
            <%--end.start = datas //将结束日的初始值设定为开始日--%>
        <%--}--%>
    <%--};--%>
    <%--var end = {--%>
        <%--elem: '#end',--%>
        <%--format: 'YYYY/MM/DD',--%>
        <%--min: laydate.now(),--%>
        <%--max: '2099-06-16',--%>
        <%--istime: true,--%>
        <%--istoday: false,--%>
        <%--choose: function (datas) {--%>
            <%--start.max = datas; //结束日选好后，重置开始日的最大日期--%>
        <%--}--%>
    <%--};--%>
    <%--laydate(start);--%>
    <%--laydate(end);--%>
<%--</script>--%>


</body>

</html>
