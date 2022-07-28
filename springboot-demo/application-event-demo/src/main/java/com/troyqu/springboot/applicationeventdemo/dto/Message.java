package com.troyqu.springboot.applicationeventdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Message {
    String id;
    String type;
    String content;
    String charset;
}
