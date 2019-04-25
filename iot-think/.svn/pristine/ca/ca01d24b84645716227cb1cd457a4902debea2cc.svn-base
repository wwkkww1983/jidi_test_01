package com.rz.iot.think.mapper.screen;

import com.rz.iot.think.model.screen.IotScreenMaterialKeyRel;

public interface IotScreenMaterialKeyRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotScreenMaterialKeyRel record);

    int insertSelective(IotScreenMaterialKeyRel record);

    IotScreenMaterialKeyRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotScreenMaterialKeyRel record);

    int updateByPrimaryKey(IotScreenMaterialKeyRel record);

    /**
     * 根据key查找
     * @param key
     * @return
     */
    IotScreenMaterialKeyRel selectByKey(String key);

    /**
     * 根据素材id、类型查找
     * @param materialId 素材id
     * @param materialType 素材类型
     * @return
     */
    IotScreenMaterialKeyRel selectByMaterialId(Integer materialId, Integer materialType);

    /**
     * @Desc:根据素材id，素材类型删除（隐藏）
     * @param materialId 素材id
     * @param materialType 素材类型
     */
    int delByMaterialIdAndMaterialType (Integer materialId, Integer materialType);
}