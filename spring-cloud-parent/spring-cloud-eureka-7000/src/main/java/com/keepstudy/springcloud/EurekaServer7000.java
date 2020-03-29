package com.keepstudy.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: moshengkang
 * @e-mial: 1634414600@qq.com
 * @Version: 1.0
 * @Description: eureka注册中心
 */
@Slf4j
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer7000 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7000.class,args);
        log.info("spring-cloud-eureka-7000=======启动成功！");
    }
}
