package com.troyqu.javaaop.staticproxy;

import com.troyqu.javaaop.staticproxy.proxy.UserServiceProxy;
import com.troyqu.javaaop.staticproxy.service.UserService;
import com.troyqu.javaaop.staticproxy.service.impl.UserServiceImpl;

//@SpringBootApplication
public class StaticProxyApplication {

    public static void main(String[] args) {
//        SpringApplication.run(StaticProxyApplication.class, args);
        UserService userService = new UserServiceImpl();
        UserService userProxy = new UserServiceProxy(userService);
        userProxy.add("troyqu");
    }

}
