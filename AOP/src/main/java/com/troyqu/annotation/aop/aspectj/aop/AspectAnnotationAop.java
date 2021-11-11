package com.troyqu.annotation.aop.aspectj.aop;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 使用Aspect 采用pointcut和@annotation进行AOP展示
 *
 * @Author qujianfei
 * @Date 2021/11/11
 * @Time 下午5:04
 */

@Order(2)
@Aspect
@Component
public class AspectAnnotationAop {

    private Logger logger = LoggerFactory.getLogger(AspectAnnotationAop.class);

    @Pointcut("@annotation(com.troyqu.annotation.aop.aspectj.annotation.Human)")
    public void annoPointCut() {
    }

    @Before("annoPointCut()")
    public void beforePointCut() {
        logger.info("come in annoPointCut before");
    }

    @After("annoPointCut()")
    public void afterPointCut() {
        logger.info("come in annoPointCut after");
    }

    @AfterReturning("annoPointCut()")
    public void afterRetPointCut() {
        logger.info("come in annoPointCut AfterReturning");
    }
}
