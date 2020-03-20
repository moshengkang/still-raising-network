package com.keepstudy.api;

import com.keepstudy.entry.Employee;

import java.util.List;

/**
 * @Author: moshengkang
 * @e-mial: 1634414600@qq.com
 * @Version: 1.0
 * @Description: api服务
 */
public interface EmployeeRemoteService {
    List<Employee> getEmployeeByConditionRemote(Employee employee);
}
