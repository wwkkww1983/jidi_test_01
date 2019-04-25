package com.rz.iot.think.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @Auther: yyjuan
 * @Date: 2019/3/20 0020 10:49
 * @Description: 自定义Screen线程池
 */
@Configuration
@EnableAsync
public class ScreenTaskExecutePool {

    private static ThreadPoolTaskExecutor executor = null;

    //创建线程池，这里测试数值较小
    @Bean
    public Executor screenTaskPool() {
        executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(50);
        executor.setQueueCapacity(50);
        executor.setKeepAliveSeconds(5000);
        executor.setThreadNamePrefix("screenTaskPool");

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务，默认拒绝处理，报错。
        // CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行,会阻塞入口程序
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        //当pool已经达到max size的时候，调用自定义方法处理
        executor.setRejectedExecutionHandler(new ScreenOverflowHandling());

        executor.initialize();
        return executor;
    }

    /**
     * 判断线程池队列是否已满
     * @return ture:没满；false:满了
     */
//    public boolean isMyTaskAsyncPool(){
//        return executor.getActiveCount()<3;
//    }

    /**
     * 获取开启的线程数量
     * @return
     */
    public int getScreenTaskPoolSize(){
        return executor.getActiveCount();
    }

}