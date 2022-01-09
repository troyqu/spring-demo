package com.troyqu;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MessagePublicProperties.class)
@ConditionalOnProperty(value = "messagepublic.enabled", havingValue = "true")
public class MessageAutoConfiguration {

    @ConditionalOnMissingBean
    @Bean
    MessagePublic messagePublic(MessagePublicProperties properties){
        System.out.println("使用自动装配初始化MessagePublic Bean: message public自动装配中...");
        return new MessagePublic(properties);
    }
}
