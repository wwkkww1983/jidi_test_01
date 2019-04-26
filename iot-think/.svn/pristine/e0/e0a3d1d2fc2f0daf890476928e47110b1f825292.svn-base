package com.rz.iot.think.service.impl;

import com.rz.iot.think.mapper.screen.IotScreenMaterialKeyRelMapper;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.UserInfo;
import com.rz.iot.think.model.param.IotScreenMaterialKeyRelDelParam;
import com.rz.iot.think.model.screen.IotScreenMaterialKeyRel;
import com.rz.iot.think.service.IotScreenMaterialKeyRelService;
import com.rz.iot.think.utils.RzIotDBConstParam;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @Author:jidi
 * @Date:2019/04/03 9:43
 * @Description:素材记录操作接口实现类
 **/
@Log4j2
@Service("iotScreenMaterialKeyRelService")
public class IotScreenMaterialKeyRelImpl implements IotScreenMaterialKeyRelService {

    @Resource
    private IotScreenMaterialKeyRelMapper iotScreenMaterialKeyRelMapper;

    /**
     * @Desc:根据素材类型与素材id批量删除素材（隐藏）
     */
    @Override
    public Result delByMaterialIdAndMaterialType(IotScreenMaterialKeyRelDelParam iotScreenMaterialKeyRelDelParam) {
        Result result = new Result();
        //得到要删除素材记录的id集合与素材类型
        List<Integer> iotScreenMaterialKeyRelList = iotScreenMaterialKeyRelDelParam.getIotScreenMaterialKeyRelList();
        Integer type = iotScreenMaterialKeyRelDelParam.getType();

        if(iotScreenMaterialKeyRelList.size() == 0){
           return Result.paramNull(result);
        }

        for (Integer id: iotScreenMaterialKeyRelList){
            iotScreenMaterialKeyRelMapper.delByMaterialIdAndMaterialType(id, type);
        }
        return result;
    }

    /**
     * @Desc:向素材记录表增加一条记录
     * @param  materialType 素材类型
     * @param  materialId 素材id
     */
    @Override
    public Integer addIotScreenMaterialKeyRel(Integer materialType, Integer materialId) {
        IotScreenMaterialKeyRel iotScreenMaterialKeyRel = new IotScreenMaterialKeyRel();
        //素材key
        String key =  UUID.randomUUID().toString();
        iotScreenMaterialKeyRel.setKey(key);
        //设置素材类型
        iotScreenMaterialKeyRel.setMaterialType(materialType);
        //设置素材id
        iotScreenMaterialKeyRel.setMaterialId(materialId);
        return iotScreenMaterialKeyRelMapper.insertSelective(iotScreenMaterialKeyRel);
    }
}
