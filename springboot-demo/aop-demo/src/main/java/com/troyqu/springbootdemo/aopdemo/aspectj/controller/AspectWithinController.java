package com.troyqu.springbootdemo.aopdemo.aspectj.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author qujianfei
 * @Date 2021/11/11
 * @Time 下午5:06
 */
@RestController
public class AspectWithinController {

    private Logger logger = LoggerFactory.getLogger(AspectWithinController.class);

    @GetMapping("/asp/within/test")
    public void test() {
        logger.info("asp within test");
    }

    @GetMapping("/asp/within/login")
    public void login() {
        logger.info("asp within login");
    }

}
