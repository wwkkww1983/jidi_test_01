package com.rz.iot.think.service.impl;

import com.rz.iot.think.mapper.IotSingleLightControllerMapper;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.show.IotSingleLightControllerShowDetail;
import com.rz.iot.think.service.IotSingleLightControllerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 描述:
 * 单灯控制器
 *
 * @author Zhouyz
 * @create 2019-03-18 15:12
 */
@Service
public class IotSingleLightControllerServiceImpl implements IotSingleLightControllerService {

    @Resource
    private IotSingleLightControllerMapper iotSingleLightControllerMapper;

    @Override
    public List<HashMap> getSlcByIds(List<Integer> ids) {
        return iotSingleLightControllerMapper.getInfosBySlcIds(ids);
    }

    /**
     * 单灯控制器详细信息
     * @param slcId 单灯控制器id
     * @return
     */
    @Override
    public Result detail(Integer slcId) {

        Result result = new Result();
        if (slcId == null) {
            return Result.paramNull(result);
        }
        IotSingleLightControllerShowDetail iotSingleLightControllerShowDetail = iotSingleLightControllerMapper.detail(slcId);
        result.setData(iotSingleLightControllerShowDetail);
        return result;
    }
}
