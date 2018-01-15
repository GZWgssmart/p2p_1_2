//生成用户数据
$('#mytab').bootstrapTable({
    method: 'post',
    contentType: "application/x-www-form-urlencoded",//必须要有！！！！
    url: "/hk/pager_criteria",//要请求数据的文件路径
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
    uniqueId: "hkid",                     //每一行的唯一标识，一般为主键列
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
            title: '还款人',
            field: 'rname',
            align: 'center',
            sortable: true
        },

        {
            title: '借款人',
            field: 'name1',
            align: 'center',
            sortable: true
        }
        ,
        {
            title: '负责人',
            field: 'username',
            align: 'center',
            sortable: true
        }
        ,
        {
            title: '产品名称',
            field: 'cpname',
            align: 'center',
            sortable: true
        }
        ,
        {
            title: '已还期数',
            field: 'rnum',
            align: 'center',
            sortable: true
        }
        ,
        {
            title: '总期数',
            field: 'tnum',
            align: 'center',
            sortable: true
        }
        ,
        {
            title: '标种名称',
            field: 'bzname',
            align: 'center',
            sortable: true
        }
        ,
        {
            title: '应还本息',
            field: 'ybx',
            align: 'center',
            sortable: true
        }
        ,
        {
            title: '已还本息',
            field: 'rbx',
            align: 'center',
            sortable: true
        }
        ,
        {
            title: '应还利息',
            field: 'ylx',
            align: 'center',
            sortable: true
        }
        ,
        {
            title: '已还利息',
            field: 'rlx',
            align: 'center',
            sortable: true
        }
        ,
        {
            title: '应还本金',
            field: 'ybj',
            align: 'center',
            sortable: true
        }
        ,
        {
            title: '已还本金',
            field: 'rbj',
            align: 'center',
            sortable: true
        }
        ,
        {
            title: '应还罚息',
            field: 'yfx',
            align: 'center',
            sortable: true
        }
        ,
        {
            title: '应还罚息',
            field: 'yfx',
            align: 'center',
            sortable: true
        }
        ,
        {
            title: '已还罚息',
            field: 'rfx',
            align: 'center',
            sortable: true
        }
        ,
        {
            title: '逾期次数',
            field: 'yucount',
            align: 'center',
            sortable: true
        }
        ,
        {
            title: '第几期',
            field: 'djq',
            align: 'center',
            sortable: true
        }
        ,
        {
            title: '还款状态',
            field: 'state',
            align: 'center',
            formatter: function (value, row, index) {
                if (value === 0) {
                    //表示激活状态
                    return '<span style="color:red" >未还款</span>';
                } else if(value===1){
                    //表示激活状态
                    return '<span style="color:green">已还款</span>';
                }
            }
        }
        ,
        {
            title: '应还时间',
            field: 'ytime',
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
                return y + '-' + m + '-' + d ;
            }
        }
        ,
        {
            title: '实际还款时间',
            field: 'rtime',
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
                return y + '-' + m + '-' + d ;
            }
        }

        // ,
        // {
        //     title: '操作',
        //     align: 'center',
        //     field: '',
        //     formatter: function (value, row, index) {
        //         var g='';
        //         g = '<a title="审核" id="checker" id="cashAccounts"  data-toggle="modal" data-id="\'' + row.baid + '\'" data-target="#shenheModal" onclick="return shenhe('+row.baid+','+row.state+')"><i class="glyphicon glyphicon-import" alt="审核" style="color:green"></i></a>';
        //         return g;
        //     }
        // }
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

//查询按钮事件
$('#search_btn').click(function () {
    $('#mytab').bootstrapTable('refresh', {url: '/hk/pager_criteria'});
})
function refush() {
    $('#mytab').bootstrapTable('refresh', {url: '/hk/pager_criteria'});
}


