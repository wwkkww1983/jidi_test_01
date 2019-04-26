package com.rz.iot.think.mapper.screen;

import com.rz.iot.think.model.param.IotScreenVideoInfoSelectParam;
import com.rz.iot.think.model.screen.IotScreenVideoInfo;

import java.util.List;

public interface IotScreenVideoInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotScreenVideoInfo record);

    int insertSelective(IotScreenVideoInfo record);

    IotScreenVideoInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotScreenVideoInfo record);

    int updateByPrimaryKey(IotScreenVideoInfo record);

    //分页查询所有的未被删除的播放素材（视频）
    List<IotScreenVideoInfo> findAll();

    //根据素材名与上传者分页查询所有的未被删除的播放素材（视频）
    List<IotScreenVideoInfoSelectParam> findAllByCondition(IotScreenVideoInfoSelectParam iotScreenVideoInfoSelectParam);

    //查询在视频来源表（iot_screen_video_source）中的视频素材
    List<IotScreenVideoInfo> findById();

    //删除视频素材（隐藏）
    void delById(Integer iotScreenMaterialId);

    //根据name，hashKey，createAdmin查询id
    Integer selectIdByCondition(IotScreenVideoInfo iotScreenVideoInfo);

    //视频素材修改转码视频地址
    Integer updateConvertUrl(IotScreenVideoInfo iotScreenVideoInfo);
}