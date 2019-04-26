package com.rz.iot.think.configuration;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Auther: yyjuan
 * @Date: 2019/3/20 0020 10:49
 * @Description: 自定义Screen线程池溢出规则
 */
@Slf4j
public class ScreenOverflowHandling  implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        log.error("信息屏线程队列满了。。。");
    }
}
