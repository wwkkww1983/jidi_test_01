package com.rz.iot.think.service.impl;

import com.rz.iot.think.mapper.alarm.IotAlarmBoxRecordLogMapper;
import com.rz.iot.think.model.alarm.IotAlarmBoxRecordLog;
import com.rz.iot.think.service.IotAlarmBoxRecordLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author:jidi
 * @Date:2019/04/22 17:42
 * @Description:报警箱报警日志记录
 **/
@Service("iotAlarmBoxRecordLogService")
public class IotAlarmBoxRecordLogServiceImpl implements IotAlarmBoxRecordLogService {

    @Resource
    private IotAlarmBoxRecordLogMapper iotAlarmBoxRecordLogMapper;

    /***
     * 增加一条记录
     * @param iotAlarmBoxRecordLog
     * @return
     */
    @Override
    public int addIotAlarmBoxRecorderLog(IotAlarmBoxRecordLog iotAlarmBoxRecordLog) {
        return iotAlarmBoxRecordLogMapper.insertSelective(iotAlarmBoxRecordLog);
    }

    /***
     * 查询最近的一条产生报警信息记录
     *  @return
     */
    @Override
    public IotAlarmBoxRecordLog findIotAlarmBoxRecordLogProduce() {
        return iotAlarmBoxRecordLogMapper.findIotAlarmBoxRecordLogProduce();
    }

    /***
     * 查询最近的一条恢复报警信息记录
     * @return
     */
    @Override
    public IotAlarmBoxRecordLog findIotAlarmBoxRecordLogDisappear() {
        return iotAlarmBoxRecordLogMapper.findIotAlarmBoxRecordLogDisappear();
    }
}
