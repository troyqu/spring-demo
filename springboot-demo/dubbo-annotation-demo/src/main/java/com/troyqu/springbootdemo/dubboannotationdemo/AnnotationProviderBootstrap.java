package com.troyqu.springbootdemo.dubboannotationdemo;

import com.troyqu.springbootdemo.dubboannotationdemo.action.AnnotationAction;
import com.troyqu.springbootdemo.dubboannotationdemo.config.ConsumerConfiguration;
import com.troyqu.springbootdemo.dubboannotationdemo.config.ProviderConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.CountDownLatch;

public class AnnotationProviderBootstrap {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();

        System.out.println("dubbo service started.");
        new CountDownLatch(1).await();
    }

}
