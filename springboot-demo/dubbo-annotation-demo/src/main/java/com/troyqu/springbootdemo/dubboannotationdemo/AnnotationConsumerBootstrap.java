package com.troyqu.springbootdemo.dubboannotationdemo;

import com.troyqu.springbootdemo.dubboannotationdemo.action.AnnotationAction;
import com.troyqu.springbootdemo.dubboannotationdemo.api.Notify;
import com.troyqu.springbootdemo.dubboannotationdemo.config.ConsumerConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConsumerBootstrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        System.out.println("dubbo consumer service started.");
        final AnnotationAction annotationAction = (AnnotationAction) context.getBean("annotationAction");

        System.out.println("hello : " + annotationAction.doSayHello("world"));
//        System.out.println("goodbye : " + annotationAction.doSayGoodbye("world"));
//        System.out.println("greeting : " + annotationAction.doGreeting("world"));
//        System.out.println("reply : " + annotationAction.doReplyGreeting("world"));
    }

}
