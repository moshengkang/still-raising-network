package com.keepstudy.service.impl;

import com.keepstudy.api.EmployeeRemoteService;
import com.keepstudy.entry.Employee;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: moshengkang
 * @e-mial: 1634414600@qq.com
 * @Version: 1.0
 * @Description: 实现类
 */
@Log4j
public class EmployeeServiceImpl implements EmployeeRemoteService {
    @Override
    public List<Employee> getEmployeeByConditionRemote(Employee employee) {
        log.info("参数{}:"+employee);
        List<Employee> empList = new ArrayList<>();

        empList.add(new Employee(111, "empName111", 111.11));
        empList.add(new Employee(222, "empName222", 222.22));
        empList.add(new Employee(333, "empName333", 333.33));

        return empList;
    }



}
