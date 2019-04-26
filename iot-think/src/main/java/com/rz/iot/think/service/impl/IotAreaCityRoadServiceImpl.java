package com.rz.iot.think.service.impl;

import com.rz.iot.think.mapper.IotAreaCityRoadMapper;
import com.rz.iot.think.model.IotAreaCityRoad;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.service.IotAreaCityRoadService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author by xuxiake, Date on 2019/3/22.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
@Service("iotAreaCityRoadService")
public class IotAreaCityRoadServiceImpl implements IotAreaCityRoadService {

    @Resource
    private IotAreaCityRoadMapper iotAreaCityRoadMapper;

    /**
     * 根据区id查找路
     * @param districtId 区id
     * @return
     */
    @Override
    public Result findByDistrictId(Integer districtId) {

        Result result = new Result();
        if (districtId == null) {
            return Result.paramNull(result);
        }
        List<IotAreaCityRoad> roads = iotAreaCityRoadMapper.findByDistrictId(districtId);
        result.setData(roads);
        return result;
    }
}
