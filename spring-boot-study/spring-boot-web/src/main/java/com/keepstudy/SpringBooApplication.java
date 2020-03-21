package com.keepstudy;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: moshengkang
 * @e-mial: 1634414600@qq.com
 * @Version: 1.0
 * @Description: springboot启动器
 */
@SpringBootApplication
@Log
public class SpringBooApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBooApplication.class,args);
        log.info("spring-boot-web================启动成功");
    }
}
