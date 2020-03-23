package com.keepstudy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: moshengkang
 * @e-mial: 1634414600@qq.com
 * @Version: 1.0
 * @Description: 实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    private Integer deptNo;
    private String deptName;
    private String dbSource;
}
