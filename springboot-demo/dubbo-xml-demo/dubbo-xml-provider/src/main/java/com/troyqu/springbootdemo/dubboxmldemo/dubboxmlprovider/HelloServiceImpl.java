package com.troyqu.springbootdemo.dubboxmldemo.dubboxmlprovider;

import com.troyqu.springbootdemo.dubboxmldemo.HelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hi Xml，" + name;
    }
}
