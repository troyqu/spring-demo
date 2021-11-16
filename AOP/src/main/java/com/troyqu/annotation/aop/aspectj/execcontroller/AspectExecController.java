package com.troyqu.annotation.aop.aspectj.execcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author qujianfei
 * @Date 2021/11/11
 * @Time 下午4:48
 */
@RestController
public class AspectExecController {

    private Logger logger = LoggerFactory.getLogger(AspectExecController.class);

    @GetMapping("/asp/exec/test")
    public void test() {
        logger.info("asp exec test");
    }

    @GetMapping("/asp/exec/login")
    public void login() {
        logger.info("asp exec login");
    }
}
