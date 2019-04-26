package com.rz.iot.think.utils;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 读取properties配置文件工具类
 */
@Log4j2
public class PropertiesUtil {

    private static Properties props;

    public static String getProperty(String fileName, String key){

        props = new Properties();
        try {
            //读取propertiesUtil类的配置
            //利用反射加载类信息，获取配置文件的文件流，并指点编码格式
            props.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName),"UTF-8"));
            String value = props.getProperty(key.trim());
            if(StringUtils.isBlank(value)){
                return null;
            }
            return value.trim();
        } catch (IOException e) {
            log.error("Properties配置文件读取异常, fileName={}", fileName);
        }
        return null;
    }
}
