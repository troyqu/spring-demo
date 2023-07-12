package com.troyqu.springbootdemo.dubboxmldemo.dubboxmlprovider;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dubbo/dubbo-provider.xml")
public class DubboXmlProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboXmlProviderApplication.class, args);
    }
}
