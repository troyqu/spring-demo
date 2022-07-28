package com.troyqu.springboot.applicationeventdemo.listener;

import com.alibaba.fastjson.JSON;
import com.troyqu.springboot.applicationeventdemo.event.BaseEvent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.ApplicationListener;

/**
 * 非注解实现方法ApplicationListener，listener支持多线程操作，当有多个event时间被触发的时候，如果第一个事件没有完成，不会阻塞后面的事件处理
 */
@Slf4j
//@Component
public class BaseEventListener implements ApplicationListener<BaseEvent> {

    @SneakyThrows
    @Override
    public void onApplicationEvent(BaseEvent event) {
        hanlderEvent(event);
    }

    private void hanlderEvent(BaseEvent event) throws InterruptedException {
        val startTime = System.currentTimeMillis();
        log.info("BaseEventListener started {}", startTime);
        switch (event.getType()) {
            case "troyqu":
                log.info("TroyquApplicationEvent={} onApplicationEvent happened: {}", event.getClass(), JSON.toJSONString(event, true));
                break;
            case "troy":
                log.info("TroyApplicationEvent={} onApplicationEvent happened: {}", event.getClass(), JSON.toJSONString(event, true));
                break;
            default:
                break;

        }
        Thread.sleep(3 * 1000); //mock business operation waiting
        log.info("BaseEventListener finished {}", startTime);
    }
}
