package com.keepstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: moshengkang
 * @e-mial: 1634414600@qq.com
 * @Version: 1.0
 * @Description: java类作用描述
 */
@Controller
public class ViewController {

    @RequestMapping("/hello")
    public String toJspPage() {
        System.out.println("进入controller");
        return "target";
    }
}
