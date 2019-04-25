package com.rz.iot.think.mapper.screen;

import com.rz.iot.think.model.screen.IotScreenLineTextSource;

public interface IotScreenLineTextSourceMapper {
    int deleteByPrimaryKey(Integer pkId);

    int insert(IotScreenLineTextSource record);

    int insertSelective(IotScreenLineTextSource record);

    IotScreenLineTextSource selectByPrimaryKey(Integer pkId);

    int updateByPrimaryKeySelective(IotScreenLineTextSource record);

    int updateByPrimaryKey(IotScreenLineTextSource record);

    /**
     * 根据节目id删除布局
     * @param programId 节目id
     */
    void delByProgramId(Integer programId);
}