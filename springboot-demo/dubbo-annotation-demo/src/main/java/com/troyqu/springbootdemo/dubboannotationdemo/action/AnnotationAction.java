package com.troyqu.springbootdemo.dubboannotationdemo.action;

import com.troyqu.springbootdemo.dubboannotationdemo.DubboAnnotationDemoApplication;
import com.troyqu.springbootdemo.dubboannotationdemo.api.GreetingService;
import com.troyqu.springbootdemo.dubboannotationdemo.api.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.springframework.stereotype.Component;

@Component("annotationAction")
public class AnnotationAction {


    @DubboReference(
            interfaceClass = HelloService.class, version = DubboAnnotationDemoApplication.VERSION
//            ,methods = {
//                @Method(name = "sayHello", oninvoke="notify.oninvoke") //配置sayHello服务的oninvoke事件, 目前注解配置调用事件存在bug，可以在xml中配置reference
//            }
    )
    HelloService helloService;
    public String doSayHello(String name) {
        try {
            return helloService.sayHello(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }
    }

    public String doSayGoodbye(String name) {
        try {
            return helloService.sayGoodBye(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }

    }



    /**
     * 按照默认配置由于服务端调用方法会sleep 2seconds，因只给greeting设置了3seconds超时，所以只有greeting服务会返回结果，replyGreeting服务会遇到超时异常
     * 如果想要replyGreeting方法调用成功
     * 1. 调整DubboReference timeout全局timeout时间大于服务端sleep时间
     * 2. 给replyGreeting服务设置独立的超时时间
     */
    @DubboReference(interfaceClass = GreetingService.class,
            version = DubboAnnotationDemoApplication.VERSION,
            timeout = 1000, //设置服务调用的超时时间是1秒
            methods = {
                @Method(name = "greeting", timeout =3000, retries = 1) //单独设置greeting服务的超时时间是3000
//                    ,@Method(name = "replyGreeting", timeout =3000, retries = 1)
            }
    ) //单独给greeting设置超时时间是3000
    GreetingService greetingService;

    public String doGreeting(String greeting){
        return greetingService.greeting(greeting);
    }

    public String doReplyGreeting(String greeting){
        return greetingService.replyGreeting(greeting);
    }

}
