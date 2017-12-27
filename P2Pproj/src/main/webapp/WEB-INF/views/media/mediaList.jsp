<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>媒体报道列表</title>
    <jsp:include page="../common/bootstraptablecss.jsp"/>
    <!--上传文件及图片-->
    <link href="<%=path%>/static/plugin/bootstrap/css/plugins/webuploader/webuploader.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>/static/plugin/bootstrap/css/demo/webuploader-demo.min.css"rel="stylesheet" type="text/css">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>媒体报道列表</h5>
            <div class="ibox-tools">
                <a class="collapse-link">
                    <i class="fa fa-chevron-up"></i>
                </a>
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-wrench"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#">选项1</a>
                    </li>
                    <li><a href="#">选项2</a>
                    </li>
                </ul>
                <a class="close-link">
                    <i class="fa fa-times"></i>
                </a>
            </div>
        </div>
        <div class="ibox-content">
            <div class="panel panel-default">
                <div class="panel-heading">
                    查询条件
                </div>
                <div class="panel-body form-group" style="margin-bottom:0px;">
                    <label class="col-sm-1 control-label" style="text-align: right; margin-top:5px">媒体报道标题：</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" name="title" class="title"/>
                    </div>
                    <label class="col-sm-1 control-label" style="text-align: right; margin-top:5px">报道时间：</label>
                    <div class="col-sm-2">
                        <input type="date" class="form-control" name="date" class="date"/>
                    </div>
                    <label class="col-sm-1 control-label" style="text-align: right; margin-top:5px">报道地址：</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" name="url" class="url"/>
                    </div>

                    <div class="col-sm-1 col-sm-offset-1">
                        <button class="btn btn-primary" id="search_btn">查询</button>
                    </div>
                </div>
            </div>
            <table id="mytab" name="mytab" class="table table-hover"></table>
            <div id="toolbar" class="btn-group pull-right" style="margin-right: 20px;">
                <button id="btn_add" type="button" class="btn btn-default" data-toggle="modal" data-target="#mediaAdd">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true" ></span>新增报道
                </button>
                <button id="btn_shenhe" type="button" onclick="return getAccounts();" class="btn btn-default" style="display: block; border-radius: 0" data-toggle="modal" data-target="#mediaUpdate">
                    <span class="glyphicon glyphicon-edit" aria-hidden="true" ></span>更改报道
                </button>
                <button id="btn_delete" onclick="" type="button" class="btn btn-default" style="display: block;">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true" ></span>单个删除
                </button>
                <button id="btn_deleteMany" onclick="deleteMany();" type="button" class="btn btn-default" style="display: block;">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true" ></span>批量删除
                </button>
            </div>
        </div>
    </div>
</div>
<%--网站数据的新增--%>
<!-- 模态框（Modal） -->
<div class="modal inmodal fade" id="mediaAdd" tabindex="-1" role="dialog" aria-labelledby="webAddLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="webAddTitle">
                    新增报道
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" method="post" id="formadd">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">标题</label>
                        <div class="col-sm-10">
                            <input type="text" id = "title" name ="title" placeholder="请输入标题" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">内容</label>
                        <div class="col-sm-10">
                            <textarea id="content"  name="content" style="..."autofocus></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">封面图片</label>
                        <div class=" col-sm-10" style="...">
                            <div  id="pic" name="pic" class="page-container">
                                <div id="uploader" class="wu-example">
                                    <div class="queueList">
                                        <div id="dndArea" class="placeholder">
                                            <div id="filePicker"></div>
                                            <p>您可以尝试文件拖拽，使用QQ截屏工具，然后激活窗口后粘贴，或者点击添加图片按钮，或将照片拖到这里，单次最多可选300张</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">报道日期</label>
                        <div class="col-sm-10">
                            <input id="date" name="date" type="date" placeholder="请选择报道日期" class="form-control">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">报道地址</label>
                        <div class="col-sm-10">
                            <input type="text" id="url" name="url" placeholder="请输入报道地址" class="form-control">
                        </div>
                    </div>


                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>
                        <button type="submit" id="add" class="btn btn-primary">提交
                        </button>
                    </div>
                </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<input type="hidden" value=""  id="deleteId"/>
<%--网站新增结束--%>
<%--网站信息的修改--%>
<div class="modal inmodal fade" id="mediaUpdate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    报道的更改
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal"  id="updateForm">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">标题</label>
                        <div class="col-sm-10">
                            <input type="text" class ="title" name="title" value="${media.title}" placeholder="" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">内容</label>
                        <div class="col-sm-10">
                            <textarea class="content"  name="content" style="..."autofocus>${media.content}</textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">封面图片</label>
                        <div class=" col-sm-10" style="...">
                            <div class="pic" name="pic" value="${media.pic}" class="page-container">

                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">报道日期</label>
                        <div class="col-sm-10">
                            <input class="date" name="date" value="${media.date}" type="date" placeholder="" class="form-control">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">报道地址</label>
                        <div class="col-sm-10">
                            <input type="text" class ="url" name="url" value="${media.url}" placeholder="" class="form-control">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-success" data-dismiss="modal">关闭
                        </button>
                        <button type="button" id="update" class="btn btn-success">
                            确认修改
                        </button>
                    </div>
                </form>
            </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
    <!-- 请假员工的审核-->
    <div class="modal fade" id="shenheModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="shenheModalLabel">
                        请假员工的审核
                    </h4>
                </div>
                <form class="form-horizontal" id="shenheform" >
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">审核操作：</label>
                            <div class="col-sm-8">
                                <select class="form-control" required name="isCheck">
                                    <option value="0">审核不通过</option>
                                    <option value="1">审核通过</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">审核备注：</label>
                            <div class="col-sm-8">
                                <textarea  name="remark" id="remark" class="form-control" required="" aria-required="true"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>
                        <button type="button" id="shenhe" class="btn btn-primary" data-dismiss="modal">
                            确认审核
                        </button>
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
    <!-- 请假员工的批量审核-->
    <div class="modal fade" id="manyShenhe" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="manyShenheModalLabel">
                        请假员工的批量审核
                    </h4>
                </div>
                <form class="form-horizontal" id="manyshenheform" >
                    <input  id="manyId" type="hidden" name="manyId" />
                    <div class="modal-body">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">审核操作：</label>
                            <div class="col-sm-8">
                                <select class="form-control" required name="isCheck">
                                    <option value="0">审核不通过</option>
                                    <option value="1">审核通过</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">审核备注：</label>
                            <div class="col-sm-8">
                                <textarea  name="remark" class="form-control" id="remarks" required="" aria-required="true"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>
                        <button type="button" id="accountsshenhe" class="btn btn-primary" data-dismiss="modal">
                            确认批量审核
                        </button>
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</div>
<%--网站信息的修改--%>
<jsp:include page="../common/bootstraptablejs.jsp"/>
<!--UEditor js-->
<script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
    var ue = UE.getEditor('content');
</script>
<!-- Web Uploader -->
<script type="text/javascript">
    // 添加全局站点信息
    var BASE_URL = 'js/plugins/webuploader';
</script>
<script src="<%=path%>/static/plugin/bootstrap/js/plugins/webuploader/webuploader.min.js"></script>
<script src="<%=path%>/static/plugin/bootstrap/js/demo/webuploader-demo.min.js"></script>
<script src="<%=path%>/static/js/pageJs/media.js"></script>

</body>
</html>
