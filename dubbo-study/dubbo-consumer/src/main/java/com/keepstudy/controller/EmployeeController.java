package com.keepstudy.controller;

import com.keepstudy.api.EmployeeRemoteService;
import com.keepstudy.entry.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: moshengkang
 * @e-mial: 1634414600@qq.com
 * @Version: 1.0
 * @Description: 控制器
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRemoteService employeeRemoteService;

    @RequestMapping("/get/emp/list")
    public String getEmpList() {

        Employee employee = new Employee(666, "empName666", 666.66);

        List<Employee> list = employeeRemoteService.getEmployeeByConditionRemote(employee);

        for (Employee employee2 : list) {
            System.out.println(employee2);
        }

        return "target";
    }
}
