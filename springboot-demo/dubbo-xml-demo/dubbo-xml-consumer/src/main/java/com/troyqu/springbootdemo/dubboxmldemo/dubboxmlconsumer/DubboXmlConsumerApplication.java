package com.troyqu.springbootdemo.dubboxmldemo.dubboxmlconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.time.OffsetDateTime;
import java.util.Date;

@SpringBootApplication
@ImportResource("classpath:dubbo/dubbo-consumer.xml")
public class DubboXmlConsumerApplication {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = SpringApplication.run(DubboXmlConsumerApplication.class, args);
        ActionComponent actionComponent = (ActionComponent) applicationContext.getBean("actionComponent");
        for(int i = 0; i <= 10; i++){
            String msg = OffsetDateTime.now().toString();
            actionComponent.doSayHello(msg);
            if(i == 10){
                System.out.println("Hi Xml, all msg consumed, program waitting!");
            }
            Thread.sleep(1000);
        }
    }
}