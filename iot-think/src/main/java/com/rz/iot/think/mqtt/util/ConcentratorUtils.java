package com.rz.iot.think.mqtt.util;

import com.rz.iot.think.model.IotConcentrator;
import lombok.extern.log4j.Log4j2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author by xuxiake, Date on 2019/4/16.
 * PS: Not easy to write code, please indicate.
 * Description：集中器内存库
 */
@Log4j2
public class ConcentratorUtils {

    // 集中器内存库（ConcurrentHashMap线程安全）
    public static Map<String, IotConcentrator> concentratorMap = new ConcurrentHashMap<>();

    /**
     * 添加集中器到内存库
     * @param concentrator
     */
    public static void add(IotConcentrator concentrator) {
        String sn = concentrator.getSn();
        concentratorMap.put(sn, concentrator);
        log.debug("内存库添加集中器sn={}", sn);
    }

    /**
     * 获取集中器
     * @param sn 集中器sn
     * @return
     */
    public static IotConcentrator get(String sn) {
        IotConcentrator concentrator = concentratorMap.get(sn);
        if (concentrator != null) {
            log.debug("内存库找到集中器sn={}", sn);
        }
        return concentrator;
    }

    /**
     * 更新内存库
     * @param concentrator
     */
    public static void update(IotConcentrator concentrator) {
        String sn = concentrator.getSn();
        concentratorMap.put(sn, concentrator);
        log.debug("内存库更新集中器sn={}", sn);
    }

    /**
     * 从内存库移除集中器
     * @param sn
     */
    public static void remove(String sn) {
        concentratorMap.remove(sn);
        log.debug("内存库移除集中器sn={}", sn);
    }
}
