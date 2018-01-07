<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>分配权限</title>
    <link rel="stylesheet" href="<%=path %>/static/plugin/iChcek/skins/all.css"/>
    <link href="<%=path %>/static/plugin/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="<%=path %>/static/plugin/select2/select2.min.css" rel="stylesheet"/>
    <link href="<%=path %>/static/plugin/select2/select2-bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="gray-bg">
<div class="container">
    <h3>角色添加权限</h3>
    <hr/>
    <div class="row">
        <div class="h4 col-md-4 col-md-offset-4">
            <select id="role" name="role" class="form-control select2"></select>
        </div>
    </div>
    <hr/>
    <div class="row">
        <c:forEach items="${permissionList}" var="d">
            <div class="col-md-offset-1 col-md-2 ">
                <input type="checkbox"  name="id" value="${d.id} " >
                <label name="check">${d.desZh}</label>
            </div>
        </c:forEach>
    </div>
    <hr/>
    <div class="row">
        <div class="col-md-offset-5 col-md-4">
            <button type="button" class="btn btn-primary btn-lg save">保  存</button>
        </div>
    </div>
</div>
</div>
<%--网站信息的修改--%>
<script src="<%=path %>/static/js/jquery.min.js"></script>
<script src="<%=path %>/static/plugin/iChcek/icheck.min.js"></script>
<script src="<%=path %>/static/plugin/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=path %>/static/plugin/select2/i18n/zh-CN.js"></script>
<script src="<%=path %>/static/plugin/select2/select2.min.js"></script>

<script src="<%=path%>/static/js/xsl/rolePermission.js"></script>
<script>
    $(function () {
        $.post(
            "/rolePermission/role",
            function (data){
                $("#role").select2(
                    {
                        data: data,
                        placeholder: '请选择角色',
                        allowClear: true
                    })
            },
            'json'
        );


        //iCheck
        $('input').iCheck({
            labelHover : false,
            cursor : true,
            checkboxClass : 'icheckbox_square-blue',
            radioClass : 'iradio_square-blue',
            increaseArea : '20%'
        });



        $(".save").click(function () {
            var permissionIds = '';
            var role = '';
            role = $("#role").select2("data")[0];
            $("input[name='id']:checkbox").each(function(){
                if($(this).is(':checked') == true){
                    permissionIds += $(this).val()+",";
                }
            });

            if(role == undefined){
                alert("请选择角色");
            }else {
                var roleId = role.id;
                $.post(
                    "../rolePermission/saveOrUpdateRP",
                    {roleId:roleId,permissionIds:permissionIds},
                    function (data) {
                        if(data.result == "ok"){
                            alert(data.message);
                        }else{
                            alert(data.message);
                        }
                    },
                    "json"
                );
            }
        });

        //改变下拉框后,跳转页面
        $('#role').change(function(){
            var roleId = $(this).select2("data")[0].id;
            window.location.href="../rolePermission/rolePermissionPage?roleId="+roleId;    //页面跳转并传参
        })

    })
</script>
</body>
</html>
