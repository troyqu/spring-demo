package com.troyqu;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "messagestarter.public")
public class MessagePublicProperties {

    String events = "defaultEvent";

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }
}
