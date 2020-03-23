package com.keepstudy.springcloud.controller;

import com.keepstudy.bean.Dept;
import com.keepstudy.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: moshengkang
 * @e-mial: 1634414600@qq.com
 * @Version: 1.0
 * @Description: java类作用描述
 */
@RestController //相当于@Controller+@ResponseBody
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value="/dept/add", method= RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    @RequestMapping(value="/dept/get/{deptNo}", method=RequestMethod.GET)
    public Dept get(@PathVariable("deptNo") Integer deptNo) {
        return deptService.findById(deptNo);
    }

    @RequestMapping(value="/dept/get/all", method=RequestMethod.GET)
    public List<Dept> getAll() {
        return deptService.findAll();
    }

}
