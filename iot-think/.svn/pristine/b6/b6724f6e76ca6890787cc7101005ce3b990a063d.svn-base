package com.rz.iot.think.mapper;

import com.rz.iot.think.model.screen.IotScreenRecord;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface IotScreenRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotScreenRecord record);

    int insertSelective(IotScreenRecord record);

    IotScreenRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotScreenRecord record);

    int updateByPrimaryKey(IotScreenRecord record);

    IotScreenRecord selectByScreenId(Integer id);

    int updateByCardId(Map map);
}