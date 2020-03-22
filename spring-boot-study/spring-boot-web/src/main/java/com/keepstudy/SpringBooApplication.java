package com.keepstudy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Author: moshengkang
 * @e-mial: 1634414600@qq.com
 * @Version: 1.0
 * @Description: springboot启动器
 */
//解决controller和主启动器不在一个包路径下的问题
@ComponentScan("com.*")
@SpringBootApplication
@Slf4j
public class SpringBooApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBooApplication.class,args);
        log.info("spring-boot-web================启动成功");
    }
}
