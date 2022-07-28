package com.troyqu.springbootdemo.rabbitmqdemo.provider;

import com.alibaba.fastjson.JSON;
import com.troyqu.springbootdemo.rabbitmqdemo.config.QueueType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.Date;

@RestController
@AllArgsConstructor
@Slf4j
public class ProviderController {

    RabbitTemplate rabbitTemplate;

    @GetMapping("/provider/{message}")
    public String produceMessage(@PathVariable(name = "message") String message) {
        Date now = Date.from(OffsetDateTime.now().toInstant());
        String msg = now.toString() + " " + message;
        rabbitTemplate.convertAndSend(QueueType.CMS_TROYQU_IMAGE_QUEUE, msg);
        log.info("produce message {}", JSON.toJSONString(msg, true));
        return msg;
    }

}
