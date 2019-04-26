package com.rz.iot.think.service;

import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.param.IotConcentratorGroupAddParam;
import com.rz.iot.think.model.param.IotConcentratorListQueryParam;

import java.util.List;

/**
 * Author by xuxiake, Date on 2019/3/22.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
public interface IotConcentratorGroupService {

    /**
     * 查询集中器组列表
     * @param page 分页参数
     * @param param 查询参数
     * @return
     */
    Result findAll(Page page, IotConcentratorListQueryParam param);

    /**
     * 集中器详情
     * @param groupId 集中器组id
     * @return
     */
    Result detail(Integer groupId);

    /**
     * 增加集中器组
     * @param param
     * @return
     */
    Result add(IotConcentratorGroupAddParam param);

    /**
     * 更新集中器组
     * @param param
     * @return
     */
    Result update(IotConcentratorGroupAddParam param);

    /**
     * 删除集中器组
     * @param groupIds 集中器组ids
     * @return
     */
    Result del(List<Integer> groupIds);
}
