package com.txb.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @Description:线程池配置
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {

    @Bean("threadPoolExecutor")
    public Executor threadPoolExecutor(){
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        threadPoolExecutor.setCorePoolSize(5);
        // 设置最大线程数
        threadPoolExecutor.setMaxPoolSize(10);
        // 设置队列容量
        threadPoolExecutor.setQueueCapacity(20);
        // 设置线程活跃时间（秒）
        threadPoolExecutor.setKeepAliveSeconds(60);
        // 设置默认线程名称
        threadPoolExecutor.setThreadNamePrefix("threadPoolExecutor--");
        // 等待所有任务结束后再关闭线程池
        threadPoolExecutor.setWaitForTasksToCompleteOnShutdown(true);
        threadPoolExecutor.setAwaitTerminationSeconds(60);
        return threadPoolExecutor;
    }

}
