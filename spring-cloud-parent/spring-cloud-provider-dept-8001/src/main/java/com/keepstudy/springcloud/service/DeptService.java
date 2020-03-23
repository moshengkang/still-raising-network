package com.keepstudy.springcloud.service;

import com.keepstudy.bean.Dept;

import java.util.List;

/**
 * @Author: moshengkang
 * @e-mial: 1634414600@qq.com
 * @Version: 1.0
 * @Description: java类作用描述
 */
public interface DeptService {
    Dept findById(Integer deptNo);

    List<Dept> findAll();

    boolean addDept(Dept dept);

}
