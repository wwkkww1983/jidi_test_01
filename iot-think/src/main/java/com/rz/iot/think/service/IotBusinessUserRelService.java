package com.rz.iot.think.service;

import com.rz.iot.think.model.IotBusinessUserRel;

/**
 * Author by xuxiake, Date on 2019/3/14.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
public interface IotBusinessUserRelService {

    /**
     * 检查数据权限
     * @param businessId
     * @param businessType
     * @param userId
     * @return
     */
    boolean isAuthorized(Integer businessId, Integer businessType, Integer userId);

    /**
     * 根据用户id和集中器id删除关系表
     * @param id
     * @param concentratorId
     */
    void deleteByUserIdConcentratorId(Integer id, int concentratorId);


    /**
     * 通过用户id以及集中器id查询关联表
     * @param userId 用户id
     * @param concentratorId 集中器id
     * @return
     */
    IotBusinessUserRel findIotBusinessUserRel(Integer userId,Integer concentratorId);
}
