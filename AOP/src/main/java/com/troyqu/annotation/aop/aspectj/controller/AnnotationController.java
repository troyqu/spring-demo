package com.troyqu.annotation.aop.aspectj.controller;

import com.troyqu.annotation.aop.aspectj.annotation.Human;
import com.troyqu.annotation.aop.aspectj.annotation.Troy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author qujianfei
 * @Date 2021/11/11
 * @Time 下午12:04
 */
@RestController
public class AnnotationController {

    private Logger logger = LoggerFactory.getLogger(AnnotationController.class);

    @GetMapping("/asp/test")
    @Troy
    public void test() {
        logger.info("asp test");
    }


    @GetMapping("/asp/testHuman")
    @Human("AI")
    public void testHuman() {
        logger.info("asp testHuman");
    }

    @GetMapping("/asp/testHuman/{name}")
    @Human
    public void testHuman(@PathVariable(value = "name") String name) {
        logger.info("asp testHuman {}", name);
    }
}
