package com.keepstudy.springcloud.service.impl;

import com.keepstudy.bean.Dept;
import com.keepstudy.springcloud.mapper.DeptMapper;
import com.keepstudy.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: moshengkang
 * @e-mial: 1634414600@qq.com
 * @Version: 1.0
 * @Description: java类作用描述
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Override
    public Dept findById(Integer deptNo) {
        return deptMapper.findById(deptNo);
    }

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }
}
