package com.rz.iot.think.service;

import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.alarm.IotAlarmBox;
import com.rz.iot.think.model.param.IotAlarmBoxRecorderSelectParam;
import com.rz.iot.think.model.param.IotAlarmBoxSelectParam;

import java.util.List;

/**
 * @Author:jidi
 * @Date:2019/04/10 10:59
 * @Description:报警箱操作接口
 **/
public interface IotAlarmBoxService {


    /***
     * 分页+模糊查询报警箱基本信息
     * @param page
     * @param iotAlarmBoxSelectParam
     * @return
     */
    Result findAlarmByCondition(Page<IotAlarmBoxSelectParam> page, IotAlarmBoxSelectParam iotAlarmBoxSelectParam);

    /***
     * 查询报警箱详细信息
     * @param id
     * @return
     */
    Result findAlarmBoxDetail(Integer id);

    /***\
     * 修改报警箱信息时，查询报警箱本身信息
     * @param id
     * @return
     */
    Result updateAlarmboxDetail(Integer id);

    /***
     * 修改报警箱信息
     * @param iotAlarmBox
     * @return
     */
    Result updateAlarmbox(IotAlarmBox iotAlarmBox);


    /***
     * 查询报警箱id集合
     * @return
     */
    List<Integer> findBoxIds();


    /***
     * 报警信息统计
     * @param page
     * @param iotAlarmBoxRecorderSelectParam
     * @return
     */
    Result alarmBoxMessageStatistical(Page<IotAlarmBoxRecorderSelectParam> page, IotAlarmBoxRecorderSelectParam iotAlarmBoxRecorderSelectParam);
}
