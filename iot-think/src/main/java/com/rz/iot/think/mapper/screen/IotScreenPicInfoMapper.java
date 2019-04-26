package com.rz.iot.think.mapper.screen;

import com.rz.iot.think.model.param.IotScreenPicInfoSelectParam;
import com.rz.iot.think.model.screen.IotScreenPicInfo;

import java.util.List;

public interface IotScreenPicInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotScreenPicInfo record);

    int insertSelective(IotScreenPicInfo record);

    IotScreenPicInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotScreenPicInfo record);

    int updateByPrimaryKey(IotScreenPicInfo record);

    //分页查询所有的未被删除的屏幕播放素材（图片）
    List<IotScreenPicInfo> findAll();

    //根据名字与创建者分页查询播放素材（图片）
    List<IotScreenPicInfoSelectParam> findAllByCondition(IotScreenPicInfoSelectParam record);

    //查询在图片来源表(iot_screen_image_source)中的素材
    List<IotScreenPicInfo> findById();

    //删除图片素材(隐藏)
    void delById(Integer iotScreenMaterialId);

    //根据name，hashKey，createAdmin查询图片素材ID
    Integer selectIdByCondition(IotScreenPicInfo iotScreenPicInfo);
}