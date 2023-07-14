package com.troyqu.springbootdemo.aopdemo.aspectj.aop;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 使用Aspect 采用pointcut配合execution表达式进行AOP示例
 *
 * @Author qujianfei
 * @Date 2021/11/11
 * @Time 下午4:45
 */

@Aspect
@Component
public class AspectExecutionAop {

    private Logger logger = LoggerFactory.getLogger(AspectExecutionAop.class);

    /**
     * 只声明一个切点，不做任何逻辑处理
     * <p>
     * execution(): 表达式主体。
     * 一个*号：表示返回类型，*号表示所有的类型。
     * 包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。
     * 第二个*号：表示类名，*号表示所有的类。
     * *(…):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数
     */
    @Pointcut("execution(* com.troyqu.annotation.aop.aspectj.execcontroller..*.*(..))")
    public void execPointCut() {
    }

    @Before("execPointCut()")
    public void beforePointCut() {
        logger.info("come in execPointCut before");
    }

    @After("execPointCut()")
    public void afterPointCut() {
        logger.info("come in execPointCut after");
    }

    @AfterReturning("execPointCut()")
    public void afterRetPointCut() {
        logger.info("come in execPointCut AfterReturning");
    }
}
