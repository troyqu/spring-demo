package com.troyqu.springbootdemo.dubboannotationdemo.impl;

import com.troyqu.springbootdemo.dubboannotationdemo.DubboAnnotationDemoApplication;
import com.troyqu.springbootdemo.dubboannotationdemo.api.GreetingService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = DubboAnnotationDemoApplication.VERSION)
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String greeting(String name) {
        String msg = "Hi Annotation-dubbo, greeting " + name;
        sleepWhile();
        return msg;
    }

    public String replyGreeting(String name) {
        String msg = "Hi Annotation-dubbo, replyGreeting " + name;
        sleepWhile();
        return msg;
    }

    //2秒睡眠验证消费者处配置的超时
    void sleepWhile()  {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
