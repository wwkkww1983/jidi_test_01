package com.rz.iot.think.service.impl;

import com.rz.iot.think.mapper.IotAreaInfoMapper;
import com.rz.iot.think.model.IotAreaInfo;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.service.IotAreaInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author by xuxiake, Date on 2019/4/3.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
@Service("iotAreaInfoService")
public class IotAreaInfoServiceImpl implements IotAreaInfoService {

    @Resource
    private IotAreaInfoMapper iotAreaInfoMapper;

    /**
     * 查询所有的省
     * @return
     */
    @Override
    public Result findAllProvince() {

        Result result = new Result();
        List<IotAreaInfo> provinces = iotAreaInfoMapper.findAllProvince();
        result.setData(provinces);
        return result;
    }

    /**
     * 根据省查询所有的市
     * @param provinceId 省id
     * @return
     */
    @Override
    public Result findCityByProvinceId(Integer provinceId) {

        Result result = new Result();
        if (provinceId == null) {
            return Result.paramNull(result);
        }
        List<IotAreaInfo> citys = iotAreaInfoMapper.findCityByProvinceId(provinceId);
        result.setData(citys);
        return result;
    }

    /**
     * 根据市查询所有的区
     * @param cityId 市id
     * @return
     */
    @Override
    public Result findDistrictByCityId(Integer cityId) {

        Result result = new Result();
        if (cityId == null) {
            return Result.paramNull(result);
        }

        List<IotAreaInfo> districts = iotAreaInfoMapper.findDistrictByCityId(cityId);
        result.setData(districts);
        return result;
    }
}
