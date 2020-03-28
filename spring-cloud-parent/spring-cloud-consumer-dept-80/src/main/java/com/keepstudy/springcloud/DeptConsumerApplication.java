package com.keepstudy.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: moshengkang
 * @e-mial: 1634414600@qq.com
 * @Version: 1.0
 * @Description: java类作用描述
 */
@Slf4j
@SpringBootApplication
@EnableEurekaClient
public class DeptConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerApplication.class,args);
        log.info("spring-cloud-consumer-dept-80=========启动成功！");
    }
}
