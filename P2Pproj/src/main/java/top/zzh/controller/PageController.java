package top.zzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping("welcome")
    public String welcome(){
        return "manager/welcome";
    }
    @RequestMapping("admin_add")
    public String adminAdd(){
        return "manager/admin-add";
    }
    @RequestMapping("admin_list")
    public String adminList(){
        return "manager/admin-list";
    }
    @RequestMapping("admin_permission")
    public String adminPermission(){
        return "manager/admin-permission";
    }
    @RequestMapping("admin_role")
    public String adminRole(){
        return "manager/admin-role";
    }
    @RequestMapping("admin_role_add")
    public String adminRoleAdd(){
        return "manager/admin-role-add";
    }
    @RequestMapping("article_add")
    public String articleAdd(){
        return "manager/article-add";
    }
    @RequestMapping("article_list")
    public String articleList(){
        return "manager/article-list";
    }
    @RequestMapping("charts_1")
    public String chart1(){
        return "manager/charts-1";
    }
    @RequestMapping("charts_2")
    public String chart2(){
        return "manager/charts-2";
    }
    @RequestMapping("charts_3")
    public String chart3(){
        return "manager/charts-3";
    }
    @RequestMapping("charts_4")
    public String chart4(){
        return "manager/charts-4";
    }
    @RequestMapping("charts_5")
    public String chart5(){
        return "manager/charts-5";
    }
    @RequestMapping("charts_6")
    public String chart6(){
        return "manager/charts-6";
    }
    @RequestMapping("charts_7")
    public String chart7(){
        return "manager/charts-7";
    }
    @RequestMapping("feedback_list")
    public String feedlist(){
        return "manager/feedback-list";
    }
    @RequestMapping("member_add")
    public String memberAdd(){
        return "manager/member-add";
    }
    @RequestMapping("member_del")
    public String memberDel(){
        return "manager/member-del";
    }
    @RequestMapping("member_list")
    public String memberList(){
        return "manager/member-list";
    }
    @RequestMapping("member_record_browse")
    public String member_record_browse(){
        return "manager/member-record-browse";
    }
    @RequestMapping("member_record_download")
    public String member_record_download(){
        return "manager/member-record-download";
    }
    @RequestMapping("member_record_share")
    public String member_record_share(){
        return "manager/member-record-share";
    }
    @RequestMapping("picture_add")
    public String picture_add(){
        return "manager/picture-add";
    }
    @RequestMapping("picture_list")
    public String picture_list(){
        return "manager/picture-list";
    }
    @RequestMapping("product_add")
    public String product_add(){
        return "manager/product-add";
    }
    @RequestMapping("product_brand")
    public String product_brand(){
        return "manager/product-brand";
    }
    @RequestMapping("product_category")
    public String product_category(){
        return "manager/product-category";
    }
    @RequestMapping("product_list")
    public String product_list(){
        return "manager/product-list";
    }
    @RequestMapping("system_base")
    public String system_base(){
        return "manager/system-base";
    }
    @RequestMapping("system_category")
    public String system_category(){
        return "manager/system-category";
    }
    @RequestMapping("system_category_add")
    public String system_category_add(){
        return "manager/system-category-add";
    }
    @RequestMapping("system_log")
    public String system_log(){
        return "manager/system-log";
    }
    @RequestMapping("user")
    public String user(){
        return "user/userindex";
    }
    @RequestMapping("chongzhi")
    public String chongzhi(){
        return "user/chongzhi";
    }
    @RequestMapping("disanfang")
    public String disanfang(){
        return "user/disanfang";
    }
    @RequestMapping("history")
    public String history(){
        return "user/history";
    }
    @RequestMapping("hongbao")
    public String hongbao(){
        return "user/hongbao";
    }
    @RequestMapping("huikuan")
    public String huikuan(){
        return "user/huikuan";
    }
    @RequestMapping("login")
    public String login(){
        return "user/login";
    }
    @RequestMapping("register")
    public String register(){
        return "user/register";
    }
    @RequestMapping("registerSuccess")
    public String registerSuccess(){
        return "user/registerSuccess";
    }
    @RequestMapping("tixian")
    public String tixian(){
        return "user/tixian";
    }
    @RequestMapping("touzi")
    public String touzi(){
        return "user/touzi";
    }
    @RequestMapping("xitong")
    public String xitong(){
        return "user/xitong";
    }
    @RequestMapping("zhanghu")
    public String zhanghu(){
        return "user/zhanghu";
    }
    @RequestMapping("zijin")
    public String zijin(){
        return "user/zijin";
    }
    @RequestMapping("about")
    public String about(){
        return "index/about";
    }
    @RequestMapping("ad")
    public String ad(){
        return "index/ad";
    }
    @RequestMapping("ad1")
    public String ad1(){
        return "index/ad1";
    }
    @RequestMapping("contract")
    public String contract(){
        return "index/contract";
    }
    @RequestMapping("fl1")
    public String f1(){
        return "index/fl1";
    }
    @RequestMapping("fl2")
    public String f2(){
        return "index/fl2";
    }
    @RequestMapping("help")
    public String help(){
        return "index/help";
    }
    @RequestMapping("hezuo")
    public String hezuo(){
        return "index/hezuo";
    }
    @RequestMapping("info")
    public String info(){
        return "index/info";
    }
    @RequestMapping("list")
    public String list(){
        return "index/list";
    }
    @RequestMapping("managerTuandui")
    public String managerTuandui(){
        return "index/managerTuandui";
    }
    @RequestMapping("notice")
    public String notice(){
        return "index/notice";
    }
    @RequestMapping("report")
    public String report(){
        return "index/report";
    }
    @RequestMapping("tuandui")
    public String tuandui(){
        return "index/tuandui";
    }
    @RequestMapping("zhaopin")
    public String zhaopin(){
        return "index/zhaopin";
    }
    @RequestMapping("zifei")
    public String zifei(){
        return "index/zifei";
    }
}
