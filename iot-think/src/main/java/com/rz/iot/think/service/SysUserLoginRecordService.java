package com.rz.iot.think.service;

import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.show.SysUserLoginRecordShowList;

public interface SysUserLoginRecordService {
    //插入日志
    void insertSelective(Integer LoginMode,Integer loginType, Object content);
    //查询全部日志
    Result findAll(Page<SysUserLoginRecordShowList> page, SysUserLoginRecordShowList sysUserLoginRecordShowList);
}