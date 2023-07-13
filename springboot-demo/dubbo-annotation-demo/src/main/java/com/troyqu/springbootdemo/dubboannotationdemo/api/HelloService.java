package com.troyqu.springbootdemo.dubboannotationdemo.api;

public interface HelloService {
    String sayHello(String name);

    default String sayGoodBye(String name){
        return "Goodbye, "+ name;
    }
}
