//生成用户数据
var modal;
$('#mytab').bootstrapTable({
    method: 'post',
    contentType: "application/x-www-form-urlencoded",//必须要有！！！！
    url: "/ticket/pager",//要请求数据的文件路径
    toolbar: '#toolbar',//指定工具栏
    striped: true, //是否显示行间隔色
    dataField: "res",
    sortable: true, //是否启用排序 sortOrder: "ID asc",
    sortOrder: "ID asc",
    pagination: true,//是否分页
    queryParamsType: 'limit',//查询参数组织方式
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
    search: false,
    uniqueId: "id",                     //每一行的唯一标识，一般为主键列
    showExport: true,
    exportDataType: 'all',
    columns: [
        {
            title: '全选',
            field: 'select',
            //复选框
            checkbox: true,
            width: 25,
            align: 'center',
            valign: 'middle'
        },

        {
            title: '券的类别',
            field: 'type',
            align: 'center',
            sortable: true,
            formatter: function (value, row, index) {
                if (value == 1) {
                    return '<span style="color:green" >现金券</span>';
                }
                if(value==2){
                    return '<span style="color:green">代金券</span>';
                }
                if(value==3){
                    return '<span style="color:green">体验金</span>';
                }
                if(value==4){
                    return '<span style="color:green">加息券</span>';
                }
            }
        },

        {
            title: '面值',
            field: 'tkmoney',
            align: 'center',
            sortable: true
        },
        {
            title: '有效时间',
            field: 'tktime',
            align: 'center',
            sortable: true,
            formatter: function (value) {
                var date = new Date(value);
                var y = date.getFullYear();
                var m = date.getMonth() + 1;
                var d = date.getDate();
                var h = date.getHours();
                var mi = date.getMinutes();
                var ss = date.getSeconds();
                return y + '-' + m + '-' + d;
            }
        },
        {
            title: '操作',
            align: 'center',
            field: '',
            formatter: function (value, row, index) {
                var e = '<a title="编辑" href="javascript:void(0);" id="leave"  data-toggle="modal" data-id="\'' + row.kid + '\'" data-target="#myModal" onclick="return edit(\'' + row.kid + '\')"><i class="glyphicon glyphicon-pencil" alt="修改" style="color:green"></i></a> ';
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
})

//请求服务数据时所传参数
function queryParams(params) {
    var title = "";
    $(".search input").each(function () {
        title = $(this).val();
    });
    return {
        //每页多少条数据
        pageSize: this.pageSize,
        //请求第几页
        pageIndex: this.pageNumber,
        searchVal: title
    }
}
function del(bzid, state) {
    if (state == 0) {
        layer.msg("删除失败，已经激活的不允许删除!", {icon: 2, time: 1000});
        return;
    }
    layer.confirm('确认要删除吗？', function (index) {
        $.ajax({
            type: 'POST',
            url: '/bz/delete/' + bzid,
            dataType: 'json',
            success: function (data) {
                if (data.message == 'ok') {
                    layer.msg(data.message, {icon: 1, time: 1000});
                } else {
                    layer.msg(data.message, {icon: 1, time: 1000});
                }
                refush();
            },
            error: function (data) {
                console.log(data.msg);
            },
        });
    });
}

function deleteMany() {
    var state = "";
    var row = $.map($("#mytab").bootstrapTable('getSelections'), function (row) {
        if (row.state == 0) {
            state += row.state;
        }
        return row.bzid;
    });
    if (row == "") {
        layer.msg('删除失败，请勾选数据!', {
            icon: 2,
            time: 2000
        });
        return;
    }


    $("#bzid").val(row);
    layer.confirm('确认要删除数据吗？', function (index) {
        $.post(
            "/bz/delete/" +$("#bzid").val(),
            function (data) {
                if (data.message == "ok") {
                    layer.msg(data.message, {icon: 1, time: 1000});
                    refush();
                } else {
                    layer.msg(data.message, {icon: 1, time: 1000});
                }
                refush();
            }, "json"
        );
    });

}

function edit(kid) {
    $.post("/ticket/getById/" + kid,
        function (data) {
            $("#updateForm").autofill(data);
        },
        "json"
    );
}


//查询按钮事件
$('#search_btn').click(function () {
    $('#mytab').bootstrapTable('refresh', {url: '/ticket/pager',
        query:{type:$("#type3").val(),tktime:$("#tktime3").val(),tkmoney:$("#tkmoney3").val()}});
})
function refush() {
    $('#mytab').bootstrapTable('refresh', {url: '/ticket/pager'});
}

$('#updateForm').bootstrapValidator({
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        bzname: {
            message: '验证失败',
            validators: {
                notEmpty: {
                    message: '不能为空'
                },

            }
        },

    }
}).on('success.form.bv', function(e) {//点击提交之后
    e.preventDefault();
    var $form = $(e.target);
    var bv = $form.data('bootstrapValidator');
    $.post(
        "/ticket/update",
        $("#updateForm").serialize(),
        function (data) {
            if (data.message == "ok") {
                layer.msg(data.message, {icon: 1, time: 1000});
            } else {
                layer.msg(data.message, {icon: 1, time: 1000});

            }
            refush();
            $("#myModal").modal('hide');
        }, "json"
    );
});


$('#formadd').bootstrapValidator({
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        way: {
            message: '验证失败',
            validators: {
                notEmpty: {
                    message: '不能为空'
                },

            }
        },
    }
}).on('success.form.bv', function(e) {//点击提交之后
    e.preventDefault();
    var $form = $(e.target);
    var bv = $form.data('bootstrapValidator');
    alert($("#tkmoney").val());
    alert($("#tkmoney4").val());
    alert($(".tkmoney").val());
    $.post(
        "/ticket/save",
        $("#formadd").serialize(),
        function (data) {
            if (data.message == "ok") {
                layer.msg(data.message, {icon: 1, time: 1000});
            } else {
                layer.msg(data.message, {icon: 1, time: 1000});
            }
            $("#webAdd").modal('hide');
            refush();
        }, "json"
    );
});


$("#webAdd").on("hidden.bs.modal", function() {
    $(this).removeData("bs.modal");
});
$("#myModal").on("hidden.bs.modal", function() {
    $(this).removeData("bs.modal");
});
$("#type1").change(function () {
    if($("#type1").val()==4){
        $(".tkmoneychange").hide();
        $(".tkmoneychange2").show();
        alert("aaa");
    }else{
        $(".tkmoneychange").show();
        $(".tkmoneychange2").hide();

        alert("bbbbb")
    }
});

