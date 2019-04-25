package com.rz.iot.think.mapper.screen;

import com.rz.iot.think.model.screen.IotScreenDigitalClockSource;

public interface IotScreenDigitalClockSourceMapper {
    int deleteByPrimaryKey(Integer pkId);

    int insert(IotScreenDigitalClockSource record);

    int insertSelective(IotScreenDigitalClockSource record);

    IotScreenDigitalClockSource selectByPrimaryKey(Integer pkId);

    int updateByPrimaryKeySelective(IotScreenDigitalClockSource record);

    int updateByPrimaryKey(IotScreenDigitalClockSource record);

    /**
     * 根据节目id删除布局
     * @param programId 节目id
     */
    void delByProgramId(Integer programId);
}