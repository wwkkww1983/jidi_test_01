package com.rz.iot.think.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rz.iot.think.mapper.SysDeviceConnRecordMapper;
import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.SysDeviceConnRecord;
import com.rz.iot.think.service.SysDeviceConnRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yyjuan
 * @Date: 2019/3/23 0023 12:45
 * @Description: 连接日志处理
 */
@Service
public class SysDeviceConnRecordServiceImpl implements SysDeviceConnRecordService {

    @Autowired
    private SysDeviceConnRecordMapper sysDeviceConnRecordMapper;


    @Override
    public Integer insertConn(SysDeviceConnRecord sysDeviceConnRecord) {

        return sysDeviceConnRecordMapper.insertSelective(sysDeviceConnRecord);

    }

    @Override
    public Result findAll(Page<SysDeviceConnRecord> page, SysDeviceConnRecord sysDeviceConnRecord) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<SysDeviceConnRecord> list = sysDeviceConnRecordMapper.findAll(sysDeviceConnRecord);
        PageInfo<SysDeviceConnRecord> pageInfo = new PageInfo<>(list);
        page.setOtherParam(pageInfo);
        Result result = new Result();
        result.setData(page);
        return result;
     }
}
