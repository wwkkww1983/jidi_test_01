package com.rz.iot.think.mapper.screen;

import com.rz.iot.think.model.param.IotScreenPlayStrategyListQueryParam;
import com.rz.iot.think.model.screen.IotScreenPlayStrategy;
import com.rz.iot.think.model.show.IotScreenPlayStrategyShowDetail;
import com.rz.iot.think.model.show.IotScreenPlayStrategyShowList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IotScreenPlayStrategyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotScreenPlayStrategy record);

    int insertSelective(IotScreenPlayStrategy record);

    IotScreenPlayStrategy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotScreenPlayStrategy record);

    int updateByPrimaryKey(IotScreenPlayStrategy record);

    /**
     * 根据节目id查找策略
     * @param programId 节目id
     * @return
     */
    List<IotScreenPlayStrategy> findByProgramId(Integer programId);

    /**
     * 查询策略列表
     * @param userId 用户id
     * @param param 查询参数
     * @return
     */
    List<IotScreenPlayStrategyShowList> findList(@Param("userId") Integer userId, @Param("param") IotScreenPlayStrategyListQueryParam param);

    /**
     * 策略详情
     * @param strategyId 策略id
     * @return
     */
    IotScreenPlayStrategyShowDetail detail(Integer strategyId);
}