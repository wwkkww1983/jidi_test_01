package com.rz.iot.think.mapper.alarm;

import com.rz.iot.think.model.alarm.IotAlarmBox;
import com.rz.iot.think.model.param.IotAlarmBoxRecorderSelectParam;
import com.rz.iot.think.model.param.IotAlarmBoxSelectDetailParam;
import com.rz.iot.think.model.param.IotAlarmBoxSelectParam;
import com.rz.iot.think.model.show.IotStreetlightInstallDevForNoBinding;
import com.rz.iot.think.model.show.IotStreetlightInstallDevShowDetail;

import java.util.List;

public interface IotAlarmBoxMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotAlarmBox record);

    int insertSelective(IotAlarmBox record);

    IotAlarmBox selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotAlarmBox record);

    int updateByPrimaryKey(IotAlarmBox record);

    //分页+模糊 查询报警箱基本信息，列表显示
    List<IotAlarmBoxSelectParam> findAlarmByCondition(IotAlarmBoxSelectParam iotAlarmBoxSelectParam);

    //查询报警箱详细信息
    IotAlarmBoxSelectDetailParam findAlarmBoxDetail(Integer id);

    //报警历史统计
    List<IotAlarmBoxRecorderSelectParam> alarmBoxMessageStatistica(IotAlarmBoxRecorderSelectParam iotAlarmBoxRecorderSelectParam);

    //查询报警箱id集合
    List<Integer> findBoxIds();

    /**
     * 报警器详情（路灯管理）
     * @param alarmBoxId 报警器id
     * @return
     */
    IotStreetlightInstallDevShowDetail detailForStreetLight(Integer alarmBoxId);

    /**
     * 查找未与路灯绑定的报警器
     * @return
     */
    List<IotStreetlightInstallDevForNoBinding> findNoBinding();
}