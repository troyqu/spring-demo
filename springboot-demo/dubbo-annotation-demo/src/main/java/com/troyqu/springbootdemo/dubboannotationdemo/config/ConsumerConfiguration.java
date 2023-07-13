package com.troyqu.springbootdemo.dubboannotationdemo.config;

import com.troyqu.springbootdemo.dubboannotationdemo.impl.NotifyImpl;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "com.troyqu.springbootdemo.dubboannotationdemo.action")
@PropertySource("classpath:/dubbo/dubbo-consumer.properties")
@ComponentScan(
        value={"com.troyqu.springbootdemo.dubboannotationdemo.action","com.troyqu.springbootdemo.dubboannotationdemo.impl"}
)
public class ConsumerConfiguration {

}
