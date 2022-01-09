package com.troyqu;


public class MessagePublic {

    MessagePublicProperties properties;

    public MessagePublic(MessagePublicProperties properties) {
        this.properties = properties;
        System.out.println("查看监听器中已配置的事件:" + properties.events);
    }

}
