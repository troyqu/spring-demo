package com.troyqu.springbootdemo.dubbospringbootdemo.dubbospringbootconsumer;

import com.troyqu.springbootdemo.dubboxmldemo.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class ActionComponent implements CommandLineRunner {

    @DubboReference
    HelloService helloService;


    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i <=10; i++) {
            String time = OffsetDateTime.now().toString();
            String msg = helloService.sayHello(time);
            System.out.println(msg);
            if(i ==10){
                System.out.println("Hi springboot-dubbo msg consumed, will waiting");
                break;
            }
        }
    }
}
