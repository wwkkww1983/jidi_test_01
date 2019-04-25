package com.rz.iot.think.mapper.screen;

import com.rz.iot.think.model.screen.IotScreenMaterialUploadRecord;

public interface IotScreenMaterialUploadRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotScreenMaterialUploadRecord record);

    int insertSelective(IotScreenMaterialUploadRecord record);

    IotScreenMaterialUploadRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotScreenMaterialUploadRecord record);

    int updateByPrimaryKey(IotScreenMaterialUploadRecord record);
}