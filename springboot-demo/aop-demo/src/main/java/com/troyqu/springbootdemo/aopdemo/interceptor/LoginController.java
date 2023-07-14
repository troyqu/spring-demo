package com.troyqu.springbootdemo.aopdemo.interceptor;

import com.troyqu.annotation.aop.interceptor.annotation.LoggerAnnotation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author qujianfei
 * @Date 2021/9/6
 * @Time 下午6:02
 */
@RestController
public class LoginController {
    @RequestMapping("/login")
    @LoggerAnnotation
    public void login() {
        try {
            System.out.println("login this time");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/test")
    public void test() {
        try {
            System.out.println("test this time");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
