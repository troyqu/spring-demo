package com.troyqu.springbootdemo.dubboannotationdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DubboAnnotationDemoApplication {

    public static final String VERSION = "1.0.0";

    public static void main(String[] args) {
        SpringApplication.run(DubboAnnotationDemoApplication.class, args);
    }

}
