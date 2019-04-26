package com.rz.iot.think.mapper.screen;

import com.rz.iot.think.model.screen.IotScreenVideoSource;

public interface IotScreenVideoSourceMapper {
    int deleteByPrimaryKey(Integer pkId);

    int insert(IotScreenVideoSource record);

    int insertSelective(IotScreenVideoSource record);

    IotScreenVideoSource selectByPrimaryKey(Integer pkId);

    int updateByPrimaryKeySelective(IotScreenVideoSource record);

    int updateByPrimaryKey(IotScreenVideoSource record);

    /**
     * 根据节目id删除布局
     * @param programId 节目id
     */
    void delByProgramId(Integer programId);
}