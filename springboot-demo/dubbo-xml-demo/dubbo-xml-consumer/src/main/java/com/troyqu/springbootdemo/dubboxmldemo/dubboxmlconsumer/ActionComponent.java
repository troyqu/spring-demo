package com.troyqu.springbootdemo.dubboxmldemo.dubboxmlconsumer;

import com.troyqu.springbootdemo.dubboxmldemo.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActionComponent {

    @Autowired
    HelloService helloService;

    public void doSayHello(String msg){
        System.out.println(helloService.sayHello(msg));
    }

}
