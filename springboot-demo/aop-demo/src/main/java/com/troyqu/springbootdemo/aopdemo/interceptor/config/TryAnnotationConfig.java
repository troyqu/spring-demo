package com.troyqu.springbootdemo.aopdemo.interceptor.config;

import com.troyqu.annotation.aop.interceptor.interceptor.LoggerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

/**
 * @Author qujianfei
 * @Date 2021/9/6
 * @Time 下午5:59
 */
@Configuration
public class TryAnnotationConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //通过PathPatterns配置interceptor的生效范围，如果不添加默认会拦截所有请求，所以最好结合实际使用情况配置相应的path
        registry.addInterceptor(new WebRequestHandlerInterceptorAdapter(new LoggerInterceptor())).addPathPatterns("/test", "/login");
//        registry.addInterceptor(new WebRequestHandlerInterceptorAdapter(new LoggerInterceptor())).addPathPatterns("/**", "/test/**");
    }
}
