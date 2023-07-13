package com.troyqu.springbootdemo.dubbospringbootdemo.dubbospringbootprovider;


import com.troyqu.springbootdemo.dubboxmldemo.HelloService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String s) {
        return "Hi springboot-dubbo, " + s;
    }
}
