package com.troyqu.springbootdemo.rabbitmqdemo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue queueImage() {
        return new Queue(QueueType.CMS_TROYQU_IMAGE_QUEUE);
    }

}
