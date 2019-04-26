package com.rz.iot.think.mqtt.util;

/**
 * Author by xuxiake, Date on 2019/4/13.
 * PS: Not easy to write code, please indicate.
 * Description：产生唯一的msgId工具类
 */
public class MsgIdUtils {

    public static Integer msgId = 0;

    public static Integer getMsgId() {

        synchronized (MsgIdUtils.class) {
            msgId = MsgIdUtils.msgId % '\uffff' + 1;
            return msgId;
        }
    }
}
