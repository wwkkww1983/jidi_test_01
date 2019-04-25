package com.rz.iot.think.service.impl;

import com.rz.iot.think.mapper.IotStreetlightSlcRelMapper;
import com.rz.iot.think.service.IotStreetlightSlcRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 * 单灯控制器与路灯关系
 *
 * @author Zhouyz
 * @create 2019-03-18 14:24
 */
@Service
public class IotStreetlightSlcRelServiceImpl implements IotStreetlightSlcRelService {

    @Resource
    private IotStreetlightSlcRelMapper iotStreetlightSlcRelMapper;


    @Override
    public List<Integer> getSlcIds(Integer streetlightId) {
        return iotStreetlightSlcRelMapper.findSlcIdsByStreetlightId(streetlightId);
    }
}
