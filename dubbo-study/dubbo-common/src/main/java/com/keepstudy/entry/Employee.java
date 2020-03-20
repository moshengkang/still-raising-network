package com.keepstudy.entry;

import lombok.Data;

import java.io.Serializable;
/**
 * @Author: moshengkang
 * @e-mial: 1634414600@qq.com
 * @Version: 1.0
 * @Description: 实体类
 */
@Data
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer empId;
    private String empName;
    private Double salary;

    public Employee(Integer empId, String empName, Double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }
}
