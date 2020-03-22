package com.boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: moshengkang
 * @e-mial: 1634414600@qq.com
 * @Version: 1.0
 * @Description: java类作用描述
 */
@Controller
public class AppleController {

    @ResponseBody
    @RequestMapping("/apple")
    public String apple() {
        return "apple";
    }
}
