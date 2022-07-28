package com.troyqu.springboot.applicationeventdemo.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class BaseEvent extends ApplicationEvent {

    String type;

    public BaseEvent(Object source, String type) {
        super(source);
        this.type = type;
    }
}