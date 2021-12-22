package com.troyqu.javaaop.staticproxy.proxy;

import com.troyqu.javaaop.staticproxy.service.UserService;

public class UserServiceProxy implements UserService {

    private UserService target;

    public UserServiceProxy(UserService target) {
        this.target = target;
    }

    @Override
    public void add(String name) {
        System.out.println("准备添加用户");
        target.add(name);
        System.out.println("添加用户完成");
    }
}
