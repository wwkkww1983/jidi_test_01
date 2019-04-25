package com.rz.iot.think.service;

import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.param.IotScreenMaterialKeyRelDelParam;
import com.rz.iot.think.model.screen.IotScreenMaterialKeyRel;

/**
 * @Author:jidi
 * @Date:2019/04/03 9:40
 * @Description:素材记录操作接口
 **/
public interface IotScreenMaterialKeyRelService {

    /**
     * @Desc:根据素材类型与素材id批量删除素材（隐藏）
     */
    Result delByMaterialIdAndMaterialType(IotScreenMaterialKeyRelDelParam iotScreenMaterialKeyRelDelParam);

    /**
     * @Desc:向素材记录表增加一条记录
     * @param  materialType 素材类型
     * @param  materialId 素材id
     */
    Integer addIotScreenMaterialKeyRel(Integer materialType, Integer materialId);


}
