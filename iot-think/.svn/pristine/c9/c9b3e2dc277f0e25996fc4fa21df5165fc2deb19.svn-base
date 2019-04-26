package com.rz.iot.think.mapper;

import com.rz.iot.think.model.SysOptRecord;
import com.rz.iot.think.model.show.SysOptRecordShowList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysOptRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysOptRecord record);

    int insertSelective(SysOptRecord record);

    SysOptRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysOptRecord record);

    int updateByPrimaryKey(SysOptRecord record);

    //查询所有操作日志
    List<SysOptRecordShowList> findAll(SysOptRecordShowList sysOptRecordShowList);
}