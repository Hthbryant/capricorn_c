package com.lingyi.biz.config.configuration;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.lingyi.biz.config.thread.MyThreadPoolExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @author 咕噜科
 * ClassName: ThreadPoolConfig
 * date: 2022-06-11 15:09
 * Description:
 * version 1.0
 */
@Configuration
public class ThreadPoolConfig {

    @Bean("threadPoolInstance")
    public ExecutorService threadPoolExecutor() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build();
        ExecutorService executorService = new MyThreadPoolExecutor(10, 20, 5L
                , TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        return executorService;
    }

}
