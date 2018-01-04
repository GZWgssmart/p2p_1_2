<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>媒体报道列表</title>
    <%--layui上传图片--%>
    <link rel="stylesheet" href="<%=path%>/static/layui/css/layui.css"  media="all">
    <jsp:include page="../common/bootstraptablecss.jsp"/>
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
                <button id="btn_deleteMany" onclick="deleteMany();" type="button" class="btn btn-default" style="display: block;">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true" ></span>批量删除
                </button>
            </div>
        </div>
    </div>
</div>
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
                    <input type="hidden" name="mid" id="mid"/>
                    <input type="hidden" name="state" id="state"/>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">标题</label>
                        <div class="col-sm-10">
                            <input type="text" id="title" name ="title"  value="${media.title}" placeholder="" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">内容</label>
                        <div class="col-sm-10">
                            <textarea id="content" name="content" style="height: 250px;width: 700px"autofocus>${media.content}</textarea>
                        </div>
                    </div>
                    <input type="hidden" id="pic" name="pic"/>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">封面图片</label>
                        <div class="col-sm-10">
                            <div class="layui-upload">
                                <button type="button" class="layui-btn" id="picx">上传图片</button>
                                <div class="layui-upload-list">
                                    <img class="layui-upload-img" id="demo1">
                                    <p id="demoText"value="${media.pic}"></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">报道日期</label>
                        <div class="col-sm-10">
                            <input id="date" name="date" type="date" placeholder="" class="form-control">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">报道地址</label>
                        <div class="col-sm-10">
                            <input type="text" id="url" name="url" value="${media.date}" placeholder="" class="form-control">
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button class="btn btn-lg btn-primary" type="submit"><i class="fa fa-check"></i>&nbsp;&nbsp;<span class="bold">提交</span></button>
                        <button class="btn btn-lg btn-default" data-dismiss="modal" type="button"><i class="fa fa-times"></i>&nbsp;&nbsp;<span class="bold">取消</span></button>

                    </div>
                </form>
            </div>
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
<%--layui上传图片--%>
<script src="<%=path%>/static/layui/layui.js" charset="utf-8"></script>

<script>
    layui.use('upload', function(){
        var $ = layui.jquery
            ,upload = layui.upload;

        //普通图片上传
        var uploadInst = upload.render({
            elem: '#picx'
            ,url: '<%=path%>/media/upload'
            ,exts: 'png|PNG|JPEG|jpeg|gif|GIF|jpg|JPG' //只允许上传压缩文件
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.code > 0){
                    return layer.msg('上传失败');
                }
                if(res.code==0) {
                    $('#pic').val(res.filePath);
                    return layer.msg(res.msg);
                }
                /* $('#pic').val("res.msg");*/

                //上传成功
            }
            ,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });
    });
</script>
<script src="<%=path%>/static/js/pageJs/media.js"></script>

</body>
</html>
