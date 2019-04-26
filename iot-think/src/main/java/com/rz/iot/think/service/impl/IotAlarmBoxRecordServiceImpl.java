package com.rz.iot.think.service.impl;

import com.rz.iot.think.mapper.alarm.IotAlarmBoxRecordMapper;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.alarm.IotAlarmBoxRecord;
import com.rz.iot.think.model.param.IotAlarmBoxRecorderStatusUpdateParam;
import com.rz.iot.think.service.IotAlarmBoxRecordService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author:jidi
 * @Date:2019/04/11 15:53
 * @Description:报警信息记录操作实现类
 **/
@Service("iotAlarmBoxRecordService")
@Log4j2
public class IotAlarmBoxRecordServiceImpl implements IotAlarmBoxRecordService {

    @Resource
    private IotAlarmBoxRecordMapper iotAlarmBoxRecordMapper;

    /***
     * 根据主键修改报警信息记录状态
     * @param iotAlarmBoxRecorderStatusUpdateParam
     * @return
     */
    @Override
    public Result updateStatusById(IotAlarmBoxRecorderStatusUpdateParam iotAlarmBoxRecorderStatusUpdateParam) {
        Result res = new Result();
        Integer i = iotAlarmBoxRecordMapper.updateStatusById(iotAlarmBoxRecorderStatusUpdateParam);
        if(i == 1){
            res.setMessage("修改成功！");
        }else{
            res.setMessage("修改失败！");
        }
        return res;
    }

    /***
     * 根据报警箱id查询报警箱实时报警记录
     * @param boxId
     * @return
     */
    @Override
    public IotAlarmBoxRecord findIotAlarmBoxRecord(int boxId) {
        return  iotAlarmBoxRecordMapper.findIotAlarmBoxRecordByBoxId(boxId);
    }

    /***
     * 增加一条记录
     * @param iotAlarmBoxRecord
     * @return
     */
    @Override
    public int addIotAlarmBoxRecord(IotAlarmBoxRecord iotAlarmBoxRecord) {
        return iotAlarmBoxRecordMapper.insertSelective(iotAlarmBoxRecord);
    }

    /***
     * 修改报警箱实时报警信息记录表记录
     * @param iotAlarmBoxRecord
     * @return
     */
    @Override
    public int updateIotAlarmBoxRecord(IotAlarmBoxRecord iotAlarmBoxRecord) {
        return iotAlarmBoxRecordMapper.updateByPrimaryKeySelective(iotAlarmBoxRecord);
    }
}
