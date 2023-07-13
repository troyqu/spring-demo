package com.troyqu.springbootdemo.dubboannotationdemo.impl;

import com.troyqu.springbootdemo.dubboannotationdemo.DubboAnnotationDemoApplication;
import com.troyqu.springbootdemo.dubboannotationdemo.api.HelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Method;

@DubboService(
        version = DubboAnnotationDemoApplication.VERSION,
        methods = {
                @Method(name = "sayGoodBye", timeout = 250, retries = 0) //超时测试验证，provider实现sleep 300ms，因此这里配置的timeout=250会在consumer触发超时
        }
)
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        System.out.println("provider recieve invoke of sayHello : " + name);
        String msg = "Hello Annotation-dubbo, sayHello " + name;
        sleepWhile();
        return msg;
    }

    @Override
    public String sayGoodBye(String name) {
        System.out.println("provider recieve invoke of sayGoodBye : " + name);
        String msg = "Hello Annotation-dubbo, sayGoodBye " + name;
        sleepWhile();
        return msg;
    }

    void sleepWhile() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
