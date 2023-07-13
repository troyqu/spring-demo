package com.troyqu.springbootdemo.dubboannotationdemo.api;

public interface GreetingService {

    String greeting(String name);

    default String replyGreeting(String name){
        return "Fine, " + name;
    }
}
