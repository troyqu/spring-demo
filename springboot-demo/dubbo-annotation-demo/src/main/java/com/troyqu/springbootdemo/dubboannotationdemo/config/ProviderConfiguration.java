package com.troyqu.springbootdemo.dubboannotationdemo.config;

import org.apache.dubbo.config.ProviderConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "com.troyqu.springbootdemo.dubboannotationdemo.impl")
@PropertySource("classpath:/dubbo/dubbo-provider.properties")
public class ProviderConfiguration {
    @Bean
    public ProviderConfig providerConfig(){
        ProviderConfig config = new ProviderConfig();
        config.setTimeout(1000);
        return config;
    }
}
