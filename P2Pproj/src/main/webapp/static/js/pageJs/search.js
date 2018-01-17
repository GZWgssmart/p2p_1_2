/**
 *
 */
var localObj = window.location;
var contextPath = localObj.protocol + "//" + localObj.host;
var listNum = 1,tt = '',xx = '',yy = '',
    rates = '',timeers = '',deadlines = '',flages = '',oData = [],oPage,oParam,serchText='';
$(function(){
    //页面初始化
    //initPage();
    hashChange();


    $("#claimm-can-Search").click(function () {
        hashChange();
    });

});
function hashChange(){
    var hash = location.hash.replace('#','');
    $('a[href="#'+hash+'"]').parent('li').addClass('active');
    $('a[href="#'+hash+'"]').parent('li').siblings('li').removeClass('active');
    if(hash.length == 1){
        tt = hash;
    }
    if(hash.length == 2){
        yy = parseFloat(hash).toString();
    }
    if(hash.length == 3){
        xx = parseFloat(hash).toString();
    }
    serchText = $("#claimm-can-title").val();
    $('.listData').empty();
    $('.paging').empty();
    loadData();
}
function loadData(){
    //页面首次加载
    oParam={
        pageNo:listNum,
        tt:tt,
        yy:yy,
        xx:xx,
        rates:rates,
        timeers:timeers,
        deadlines:deadlines,
        flages:flages,
        titles:serchText
    };
    oPage = new Page('/page/list?pageNo=1',oParam,$('.listData'),$('.paging'),oData,function(){

    });
}
