<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>excel上传</title>
    <script src="<%=path%>/static/js/jquery.min.js"></script>
    <script src="<%=path%>/static/js/jQuery.form.js"></script>
</head>
<body>
<form id="upload" action="<%=path %>/uploadExcel/uploadExcel" method="post" enctype="multipart/form-data">
    <input type="file" name="file" />
    <input type="button" onclick="toSave()" value="上传"/>
</form>
<script>
    $(function(){
        var options = {
            type: 'POST',
            url: '<%=path %>/uploadExcel/up_saveDb',
            success:showResponse,
            dataType: 'json',
            clearForm: true,    //成功提交后，清除所有表单元素的值
        };
        $("#upload").submit(function(){
            $(this).ajaxSubmit(options);
            return false;   //防止表单自动提交
        });
    });

    /**
     * 保存操作
     */
    function toSave(){
        $("#upload").submit();
    }

    /**
     * 保存后，执行回调
     * @param responseText
     * @param statusText
     * @param xhr
     * @param $form
     */
    function showResponse(responseText, statusText, xhr, $form){
        if(responseText.code == '98'){  //文件类型错误
            alert(responseText.message);
        } else if(responseText.code == '99'){ //上传成功
            alert(responseText.message);
        } else if(responseText.code == '97') {  //服务器繁忙
            alert(responseText.message);
        }
    }
</script>
</body>
</html>
