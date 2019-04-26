package com.rz.iot.think.service;

import com.rz.iot.think.model.param.IotScreenProgramDelParam;
import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.param.IotScreenProgramAddParam;
import com.rz.iot.think.model.param.IotScreenProgramInfoListQueryParam;
import com.rz.iot.think.model.param.IotScreenProgramVerifyParam;

/**
 * Author by xuxiake, Date on 2019/3/29.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
public interface IotScreenProgramService {

    /**
     * 节目详细信息
     * @param programId
     * @return
     */
    Result programDetail(Integer programId);

    /**
     * 信息屏节目列表
     * @param page 分页参数
     * @param param 查询参数
     * @return
     */
    Result findList(Page page, IotScreenProgramInfoListQueryParam param);

    /**
     * 添加节目
     * @param param
     * @return
     */
    Result add(IotScreenProgramAddParam param);

    /**
     * 节目审批
     * @param param
     * @return
     */
    Result verifyProgram(IotScreenProgramVerifyParam param);

    /**
     * 更新节目
     * @param param
     * @return
     */
    Result update(IotScreenProgramAddParam param);

    /**
     * 节目删除
     * @param param
     * @return
     */
    Result del(IotScreenProgramDelParam param);

    /**
     * 节目复制
     * @param programId 节目id
     * @return
     */
    Result copy(Integer programId);
}
