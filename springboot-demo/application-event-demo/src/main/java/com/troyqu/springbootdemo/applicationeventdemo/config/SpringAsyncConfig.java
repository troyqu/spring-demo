package com.troyqu.springbootdemo.applicationeventdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class SpringAsyncConfig {

    @Bean
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程数量
        executor.setCorePoolSize(20);
        //线程池维护的线程的最大数量
        executor.setMaxPoolSize(200);
        //缓冲队列
        executor.setQueueCapacity(25);
        //超出核心线程数外的线程在空闲时候的最大存活时间
        executor.setKeepAliveSeconds(200);
        //线程名前缀
        executor.setThreadNamePrefix("asyncThread-");
        //是否等待所有线程执行完毕才关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);
        //当线程没可用线程时的处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

}
