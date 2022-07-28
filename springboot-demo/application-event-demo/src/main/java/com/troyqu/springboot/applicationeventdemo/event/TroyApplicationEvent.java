package com.troyqu.springboot.applicationeventdemo.event;

import com.troyqu.springboot.applicationeventdemo.dto.Message;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TroyApplicationEvent extends BaseEvent {

    Message message;

    public TroyApplicationEvent(Object source, String type, Message message) {
        super(source, type);
        this.message = message;
    }
}
