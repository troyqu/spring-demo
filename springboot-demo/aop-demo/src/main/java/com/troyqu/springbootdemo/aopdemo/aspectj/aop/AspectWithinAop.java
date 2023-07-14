package com.troyqu.springbootdemo.aopdemo.aspectj.aop;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 使用Aspect 采用pointcut配合within的方式处理AOP
 *
 * @Author qujianfei
 * @Date 2021/11/11
 * @Time 下午4:46
 */

@Aspect
@Component
public class AspectWithinAop {

    private Logger logger = LoggerFactory.getLogger(AspectWithinAop.class);

    /**
     * within 处理某一个具体类或者包下的所有方法
     */
    @Pointcut("within(com.troyqu.annotation.aop.aspectj.controller.AspectWithinController)")
    public void withInPointCut() {
    }

    @Before("withInPointCut()")
    public void beforePointCut() {
        logger.info("come in withInPointCut before");
    }

    @After("withInPointCut()")
    public void afterPointCut() {
        logger.info("come in withInPointCut after");
    }

    @AfterReturning("withInPointCut()")
    public void afterRetPointCut() {
        logger.info("come in withInPointCut AfterReturning");
    }

}
