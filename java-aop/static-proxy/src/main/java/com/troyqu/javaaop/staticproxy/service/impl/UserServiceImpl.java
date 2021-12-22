package com.troyqu.javaaop.staticproxy.service.impl;

import com.troyqu.javaaop.staticproxy.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public void add(String name) {
        System.out.println("添加用户" + name);
    }
}
