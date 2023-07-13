package com.troyqu.springbootdemo.dubbospringbootdemo.dubbospringbootprovider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class DubboSpringbootProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboSpringbootProviderApplication.class, args);
    }

}
