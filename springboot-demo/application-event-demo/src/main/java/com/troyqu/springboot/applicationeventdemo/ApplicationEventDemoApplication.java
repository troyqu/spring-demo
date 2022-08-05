package com.troyqu.springboot.applicationeventdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ApplicationEventDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationEventDemoApplication.class, args);
    }

}
