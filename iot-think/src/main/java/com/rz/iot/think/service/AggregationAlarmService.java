package com.rz.iot.think.service;

import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.param.IotAlarmBoxRecorderSelectParam;
import com.rz.iot.think.model.param.IotAlarmBoxRecorderStatusUpdateParam;

import java.util.Date;
import java.util.List;

/**
 * Created by qinxian on 2019/4/17 0017.
 */
public interface AggregationAlarmService {

    /**
     * 根据报警设备ID获取工作状态
     * @param id
     * @return
     */
    IotAlarmBoxRecorderStatusUpdateParam findAlarmWorkInfo(Integer id);

    /**
     * 根据参数查询指定报警设备的日志信息
     * type为0、则查询全部;
     *       1、根据类型参数wMajorType（主类型）与wMinorType（次类型）查询;
     *       2、根据时间参数struEndTime（开始时间)与struEndTime（结束时间）查询
     *       3、根据类型参数与时间参数查询
     * @param id
     * @param type
     * @param struStartTime
     * @param struEndTime
     * @param wMajorType
     * @param wMinorType
     * @return
     */
    List<IotAlarmBoxRecorderSelectParam> findAlarmLog(Integer id, Integer type, Date struStartTime, Date struEndTime, Integer wMajorType, Integer wMinorType);
}