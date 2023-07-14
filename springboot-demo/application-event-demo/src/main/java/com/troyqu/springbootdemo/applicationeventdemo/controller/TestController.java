package com.troyqu.springbootdemo.applicationeventdemo.controller;

import com.alibaba.fastjson.JSON;
import com.troyqu.springbootdemo.applicationeventdemo.dto.Message;
import com.troyqu.springbootdemo.applicationeventdemo.event.BaseEvent;
import com.troyqu.springbootdemo.applicationeventdemo.event.TroyApplicationEvent;
import com.troyqu.springbootdemo.applicationeventdemo.event.TroyquApplicationEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/events")
public class TestController {

    ApplicationContext applicationContext;

    @GetMapping("/msg/troy")
    public String sendMessageTroy(Message message) {
        //todo 模拟其他业务操作，关键操作完成后发布event
        applicationContext.publishEvent(buildEvent("troy", message));
        return JSON.toJSONString(message, true);
    }

    @GetMapping("/msg/troyqu")
    public String sendMessageTroyqu(Message message) {
        //todo 模拟其他业务操作，关键操作完成后发布event
        applicationContext.publishEvent(buildEvent("troyqu", message));
        return JSON.toJSONString(message, true);
    }

    private BaseEvent buildEvent(String type, Message message) {
        BaseEvent event = null;
        if (type.equals("troyqu")) {
            event = new TroyquApplicationEvent(this, type, message);
        } else if (type.equals("troy")) {
            event = new TroyApplicationEvent(this, type, message);
        }
        return event;
    }
}
