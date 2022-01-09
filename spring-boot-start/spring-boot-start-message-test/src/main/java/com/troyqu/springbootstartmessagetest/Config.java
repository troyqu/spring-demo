package com.troyqu.springbootstartmessagetest;

import com.troyqu.MessagePublic;
import com.troyqu.MessagePublicProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

//    /**
//     * 测试@ConditionalOnMissingBean条件
//     * 如果
//     * @return
//     */
//    @Bean
//    MessagePublic messagePublic(){
//        System.out.println("手动初始化MessagePublic Bean: message public创建中...");
//        MessagePublicProperties prop = new MessagePublicProperties();
//        String events = "不使用ConditionalOnMissingBean初始化-events";
//        prop.setEvents(events);
//        return new MessagePublic(prop);
//    }
}
