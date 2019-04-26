package com.rz.iot.think.mapper;

import com.rz.iot.think.model.SysUserLoginRecord;
import com.rz.iot.think.model.show.SysUserLoginRecordShowList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserLoginRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserLoginRecord record);

    int insertSelective(SysUserLoginRecord record);

    SysUserLoginRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserLoginRecord record);

    int updateByPrimaryKey(SysUserLoginRecord record);

    List<SysUserLoginRecordShowList> findAll(SysUserLoginRecordShowList sysUserLoginRecordShowList);
}