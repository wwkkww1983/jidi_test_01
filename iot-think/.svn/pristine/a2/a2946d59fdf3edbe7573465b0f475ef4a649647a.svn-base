package com.rz.iot.think.mapper.screen;

import com.rz.iot.think.model.screen.IotScreenProgramSourceRel;
import com.rz.iot.think.model.show.IotScreenProgramImageLayer;
import com.rz.iot.think.model.show.IotScreenProgramLayer;
import com.rz.iot.think.model.show.IotScreenProgramVideoLayer;

import java.util.List;

public interface IotScreenProgramSourceRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotScreenProgramSourceRel record);

    int insertSelective(IotScreenProgramSourceRel record);

    IotScreenProgramSourceRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotScreenProgramSourceRel record);

    int updateByPrimaryKey(IotScreenProgramSourceRel record);

    /**
     * 信息屏节目视频布局详细信息（包含层级信息）
     * @param programId
     * @return
     */
    List<IotScreenProgramLayer> findProgramVideoLayer(Integer programId);

    /**
     * 信息屏节目图片布局详细信息（包含层级信息）
     * @param programId
     * @return
     */
    List<IotScreenProgramLayer> findProgramImageLayer(Integer programId);

    /**
     * 信息屏节目单行文本布局详细信息（包含层级信息）
     * @param programId
     * @return
     */
    List<IotScreenProgramLayer> findProgramLineTextLayer(Integer programId);

    /**
     * 信息屏节目数字时钟布局详细信息（包含层级信息）
     * @param programId
     * @return
     */
    List<IotScreenProgramLayer> findProgramDigitalClockLayer(Integer programId);

    /**
     * 信息屏节目天气布局详细信息（包含层级信息）
     * @param programId
     * @return
     */
    List<IotScreenProgramLayer> findProgramWeatherLayer(Integer programId);

    /**
     * 批量插入
     * @param list
     */
    void insertBatch(List<IotScreenProgramSourceRel> list);

    /**
     * 根据节目id删除节目布局关系
     * @param programId 节目id
     */
    void delByProgramId(Integer programId);
}