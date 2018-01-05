//生成用户数据
$('#mytab').bootstrapTable({
    method: 'post',
    contentType: "application/x-www-form-urlencoded",//必须要有！！！！
    url: "/permission/permissionCriteriaQuery",//要请求数据的文件路径
    toolbar: '#toolbar',//指定工具栏
    striped: true, //是否显示行间隔色
    dataField: "res",
    sortable: true, //是否启用排序 sortOrder: "ID asc",
    sortOrder: "ID asc",
    pagination: true,//是否分页
    //queryParamsType: 'limit',//查询参数组织方式
    queryParams: queryParams,//请求服务器时所传的参数
    sidePagination: 'server',//指定服务器端分页
    pageNumber: 1, //初始化加载第一页，默认第一页
    pageSize: 10,//单页记录数
    pageList: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100],//分页步进值
    showRefresh: true,//刷新按钮
    showColumns: true,
    clickToSelect: true,//是否启用点击选中行
    toolbarAlign: 'right',//工具栏对齐方式
    buttonsAlign: 'right',//按钮对齐方式
    search: true,
    uniqueId: "id", //每一行的唯一标识，一般为主键列
    showExport: true,
    exportDataType: 'all',
    columns: [
        {
            radio: true,
            width: 25,
            align: 'center',
            valign: 'middle'
        },
        {
            title: '权限Id',
            field: 'jid',
            align: 'center',
            sortable: true
        },
        {
            title: '权限url',
            field: 'jurl',
            align: 'center',
            sortable: true
        },
        {
            title: '权限描述',
            field: 'content',
            align: 'center',
            sortable: true
        },
        {
            title: '操作',
            align: 'center',
            field: '',
            formatter: function (value, row, index) {
                var e = '<a title="编辑" href="javascript:void(0);" id="modify"  data-toggle="modal" data-id="\'' + row.jid + '\'" data-target="#myModal" onclick="return edit(\'' + row.jid + '\',\'' + row.jurl + '\',\'' + row.content + '\',)"><i class="glyphicon glyphicon-pencil" alt="修改" style="color:green"></i></a> ';
                return e;
            }
        }
    ],
    locale: 'zh-CN',//中文支持,
    responseHandler: function (res) {
        if (res) {
            return {
                "res": res.rows,
                "total": res.total
            };
        } else {
            return {
                "rows": [],
                "total": 0
            };
        }
    }
});

//请求服务数据时所传参数
function queryParams(params) {
    var content = "";
    $("#content").each(function () {
        content = $(this).val();
    });
    return {
        //每页多少条数据
        pageSize: this.pageSize,
        //请求第几页
        pageIndex: this.pageNumber,
        content: content
    }
}

//刷新表格
function refush() {
    $('#mytab').bootstrapTable('refresh');
}

//按条件查询
function doSearchContent() {
    var content = $("#content").val();
    var options = $("#mytab").bootstrapTable('refresh', {
        url: '/permission/permissionCriteriaQuery',
        query: {content: content}
    });
}

//验证并新增权限
$('#formadd').bootstrapValidator({
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        jurl: {
            message: '权限url验证失败',
            validators: {
                notEmpty: {
                    message: '权限url不能为空'
                },

            }
        },
        content: {
            message: '权限描述验证失败',
            validators: {
                notEmpty: {
                    message: '权限描述不能为空'
                }
            }
        },
    }
}).on('success.form.bv', function(e) {//点击提交之后
    e.preventDefault();
    var $form = $(e.target);
    var bv = $form.data('bootstrapValidator');
    $.post(
        "/permission/addPermission",
        $("#formadd").serialize(),
            function (data) {
            if (data.result == "ok") {
                layer.msg(data.message, {icon: 1, time: 1000});
            } else {
                layer.msg(data.message, {icon: 1, time: 1000});
            }
            $("#webAdd").modal('hide');
            $("#formadd").data('bootstrapValidator').resetForm();
            $("#addJurl").val("");
            $("#addContent").val("");
            refush();
        }, "json"
    );
});


//修改前填充数据到模态框
function edit(jid,jurl,content) {
    $("#jid").val(jid);
    $("#updateJurl").val(jurl);
    $("#updateContent").val(content);
}

//权限修改
$('#updateForm').bootstrapValidator({
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        jurl: {
            message: '权限URL验证失败',
            validators: {
                notEmpty: {
                    message: '权限URL不能为空'
                },

            }
        },
        content: {
            message: '权限描述验证失败',
            validators: {
                notEmpty: {
                    message: '权限描述不能为空'
                }

            }
        },
    }
}).on('success.form.bv', function(e) {//点击提交之后
    e.preventDefault();
    var $form = $(e.target);
    var bv = $form.data('bootstrapValidator');
    $.post(
        "/permission/updatePermission",
        $("#updateForm").serialize(),
        function (data) {
            if (data.message == "ok") {
                layer.msg(data.message, {icon: 1, time: 1000});
            } else {
                layer.msg(data.message, {icon: 1, time: 1000});
            }
            refush();
            $("#myModal").modal('hide');
            $("#updateJurl").val("");
            $("#updateContent").val("");
        }, "json"
    );
});