package com.rz.iot.think.mqtt.util;

import com.rz.iot.think.mqtt.model.ConcentratorMessageBase;
import com.rz.iot.think.mqtt.model.report.ConcentratorAppointParamReport;
import com.rz.iot.utils.RzIotDatetime;
import com.rz.iot.utils.RzIotDigit;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:jidi
 * @Date:2019/04/17 15:01
 * @Description:
 **/
public class MqttDateTimeUtils {

    public static Map<String, Integer> DateToEach(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Map<String, Integer> values = new HashMap();
        values.put("year", calendar.get(1) - 2000);
        values.put("month", calendar.get(2) + 1);
        values.put("day", calendar.get(5));
        values.put("week", calendar.get(7) - 1);
        values.put("hour", calendar.get(11));
        values.put("minute", calendar.get(12));
        values.put("second", calendar.get(13));
        return values;
    }
}
