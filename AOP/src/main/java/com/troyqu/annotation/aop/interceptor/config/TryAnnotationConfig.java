package com.troyqu.annotation.aop.interceptor.config;

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
        registry.addInterceptor(new WebRequestHandlerInterceptorAdapter(new LoggerInterceptor())).addPathPatterns("/test", "/login");
    }
}
