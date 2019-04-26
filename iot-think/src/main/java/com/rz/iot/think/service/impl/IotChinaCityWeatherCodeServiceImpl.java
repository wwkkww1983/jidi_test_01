package com.rz.iot.think.service.impl;

import com.rz.iot.think.mapper.IotChinaCityWeatherCodeMapper;
import com.rz.iot.think.model.IotChinaCityWeatherCode;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.service.IotChinaCityWeatherCodeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author by xuxiake, Date on 2019/4/10.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
@Service("iotChinaCityWeatherCodeService")
public class IotChinaCityWeatherCodeServiceImpl implements IotChinaCityWeatherCodeService {

    @Resource
    private IotChinaCityWeatherCodeMapper iotChinaCityWeatherCodeMapper;

    /**
     * 城市天气代码模糊查询
     * @param key 关键字
     * @return
     */
    @Override
    public Result search(String key) {

        Result result = new Result();
        if (!StringUtils.isEmpty(key)) {
            List<IotChinaCityWeatherCode> list = iotChinaCityWeatherCodeMapper.search(key);
            result.setData(list);
            return result;
        }

        return result;
    }
}
