package top.zzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制器
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("")
    public String index() {
        return "index";
    }

}
