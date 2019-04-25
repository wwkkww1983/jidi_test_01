package com.rz.iot.think.mapper.screen;

import com.rz.iot.think.model.param.IotScreenProgramInfoListQueryParam;
import com.rz.iot.think.model.param.IotScreenProgramVerifyParam;
import com.rz.iot.think.model.screen.IotScreenProgramInfo;
import com.rz.iot.think.model.show.IotScreenProgramInfoShowList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IotScreenProgramInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotScreenProgramInfo record);

    int insertSelective(IotScreenProgramInfo record);

    IotScreenProgramInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotScreenProgramInfo record);

    int updateByPrimaryKey(IotScreenProgramInfo record);

    /**
     * 信息屏节目列表
     * @param param 查询参数
     * @return
     */
    List<IotScreenProgramInfoShowList> findList(@Param("param") IotScreenProgramInfoListQueryParam param, @Param("userId") Integer userId);

    /**
     * 审核节目通过或不通过
     * @param param
     */
    void verifyProgram(IotScreenProgramVerifyParam param);

    /**
     * 根据策略id查询关联节目
     * @param strategyId 策略id
     * @return
     */
    IotScreenProgramInfo findByStrategyId(Integer strategyId);
}