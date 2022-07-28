package com.troyqu.springbootdemo.rabbitmqdemo.consume;

import com.troyqu.springbootdemo.rabbitmqdemo.config.QueueType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConsumerQueue {

    /**
     * 普通消费，concurrency控制同一时刻1个消费者最多只能消费2消息（创建多个消费者实例，不会重复消费，每个消息只会被一个消费者消费）
     *
     * @param msg
     */
    @RabbitListener(queues = QueueType.CMS_TROYQU_IMAGE_QUEUE, concurrency = "2")
    public void consumerQueue(String msg) {
        log.info(msg);
        try {//模拟任务处理
            Thread.sleep(30 * 1000);
        } catch (InterruptedException e) {
            log.error("Thread interrupted", e);
        }
        log.info(msg + "处理完成。。。");
    }


    public void consumeTopic() {

    }

}
