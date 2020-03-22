package com.keepstudy.controller;

import com.keepstudy.bean.Emp;
import com.keepstudy.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: moshengkang
 * @e-mial: 1634414600@qq.com
 * @Version: 1.0
 * @Description: java类作用描述
 */
@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String getEmp() {
        List<Emp> emps = empService.selectAll();
        emps.stream().forEach(e -> {
            System.out.println(e);
        });
        return "<h1>hello</h1>";
    }
}
