package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotConcentratorGroup;
import com.rz.iot.think.model.param.IotConcentratorListQueryParam;
import com.rz.iot.think.model.show.IotConcentratorGroupShowList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IotConcentratorGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotConcentratorGroup record);

    int insertSelective(IotConcentratorGroup record);

    IotConcentratorGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotConcentratorGroup record);

    int updateByPrimaryKey(IotConcentratorGroup record);

    /**
     * 查询集中器列表
     * @param userId 用户id
     * @param param 查询参数
     * @return
     */
    List<IotConcentratorGroupShowList> findAll(@Param("userId") Integer userId, @Param("param") IotConcentratorListQueryParam param);
}