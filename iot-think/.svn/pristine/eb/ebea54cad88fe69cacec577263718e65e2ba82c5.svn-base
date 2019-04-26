package com.rz.iot.think.service;

import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.SysOptRecord;
import com.rz.iot.think.model.show.SysOptRecordShowList;

import java.util.List;

/**
 * Author by zhangxd, Date on 2019/3/26.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
public interface SysOptRecordService {
    void insertSelective(Integer optMode, Integer module, Integer optType, Object content);

    //查询全部操作日志
    Result findAll(Page<SysOptRecordShowList> page, SysOptRecordShowList sysOptRecordShowList);
}