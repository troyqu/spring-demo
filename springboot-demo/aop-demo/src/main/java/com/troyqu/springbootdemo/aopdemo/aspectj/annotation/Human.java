package com.troyqu.springbootdemo.aopdemo.aspectj.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author qujianfei
 * @Date 2021/11/11
 * @Time 下午5:01
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Human {
    String value() default "NO-Name";
}
