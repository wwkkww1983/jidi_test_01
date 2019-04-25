package com.rz.iot.think.service.impl;

import com.rz.iot.think.mapper.IotStreetlightLedLightsMapper;
import com.rz.iot.think.mapper.IotStreetlightMapper;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.show.IotStreetlightLedLightsShowDetail;
import com.rz.iot.think.service.IotStreetlightLedLightsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("iotStreetlightLedLightsService")
public class IotStreetlightLedLightsServiceImpl implements IotStreetlightLedLightsService {

    @Resource
    private IotStreetlightLedLightsMapper iotStreetlightLedLightsMapper;

    /**
     * led详情
     * @param ledId led id
     * @return
     */
    @Override
    public Result detail(Integer ledId) {

        Result result = new Result();
        if (ledId == null) {
            return Result.paramNull(result);
        }
        IotStreetlightLedLightsShowDetail iotStreetlightLedLightsShowDetail = iotStreetlightLedLightsMapper.detail(ledId);
        result.setData(iotStreetlightLedLightsShowDetail);
        return result;
    }
}
