package top.zzh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.zzh.service.HkbService;

/**
 * Created by 曾志湖 on 2018/1/3.
 * 还款表
 */
@Controller
@RequestMapping("/hk")
public class HkbController {

    private Logger logger = LoggerFactory.getLogger(HkbController.class);

    @Autowired
    private HkbService hkbService;
}
