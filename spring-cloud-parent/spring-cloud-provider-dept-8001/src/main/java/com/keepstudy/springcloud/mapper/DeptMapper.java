package com.keepstudy.springcloud.mapper;

import com.keepstudy.bean.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: moshengkang
 * @e-mial: 1634414600@qq.com
 * @Version: 1.0
 * @Description: mapper接口
 */
@Mapper
public interface DeptMapper {
    Dept findById(Integer deptNo);

    List<Dept> findAll();

    boolean addDept(Dept dept);

}
