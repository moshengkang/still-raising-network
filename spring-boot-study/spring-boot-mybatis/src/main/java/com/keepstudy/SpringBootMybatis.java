package com.keepstudy;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: moshengkang
 * @e-mial: 1634414600@qq.com
 * @Version: 1.0
 * @Description: java类作用描述
 */
@Slf4j
@SpringBootApplication
@MapperScan(basePackages = "com.keepstudy.mapper")
public class SpringBootMybatis {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatis.class,args);
        log.info("spring-boot-mybatis=========启动成功");
    }
}
