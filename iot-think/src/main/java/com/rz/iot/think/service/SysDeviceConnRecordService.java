package com.rz.iot.think.service;

import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.SysDeviceConnRecord;
import org.springframework.stereotype.Service;

/**
 * @Auther: yyjuan
 * @Date: 2019/3/23 0023 12:43
 * @Description:
 */

public interface SysDeviceConnRecordService {

    Integer insertConn(SysDeviceConnRecord sysDeviceConnRecord);

    Result findAll(Page<SysDeviceConnRecord>page, SysDeviceConnRecord sysDeviceConnRecord);
}
