package com.troyqu.annotation.aop.aspectj.aop;

import com.troyqu.annotation.aop.aspectj.annotation.Human;
import com.troyqu.annotation.aop.aspectj.annotation.Troy;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 使用Aspect @annotation的方式进行AOP处理
 *
 * @Author qujianfei
 * @Date 2021/11/11
 * @Time 上午11:58
 */
@Aspect
@Component
public class TroyAnnotationAop {

    private Logger logger = LoggerFactory.getLogger(TroyAnnotationAop.class);

    @Before(value = "@annotation(troy)")
    public void aspBeforeTroy(JoinPoint joinPoint, Troy troy) {
        logger.info("come in aspBefore {}", joinPoint.getSignature().getName());
        logger.info("come in aspBefore");
    }

    @After(value = "@annotation(troy)")
    public void aspAfterTroy(JoinPoint joinPoint, Troy troy) {
        logger.info("come in aspAfter {}", joinPoint.getSignature());
        logger.info("come in aspAfter");
    }
}
