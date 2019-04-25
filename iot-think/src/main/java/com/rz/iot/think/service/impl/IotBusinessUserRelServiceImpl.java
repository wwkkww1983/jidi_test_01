package com.rz.iot.think.service.impl;

import com.rz.iot.think.mapper.IotBusinessUserRelMapper;
import com.rz.iot.think.model.IotBusinessUserRel;
import com.rz.iot.think.service.IotBusinessUserRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author by xuxiake, Date on 2019/3/14.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
@Service("iotBusinessUserRelService")
public class IotBusinessUserRelServiceImpl implements IotBusinessUserRelService {

    @Resource
    private IotBusinessUserRelMapper iotBusinessUserRelMapper;

    /**
     * 检查数据权限
     * @param businessId
     * @param businessType
     * @param userId
     * @return
     */
    @Override
    public boolean isAuthorized(Integer businessId, Integer businessType, Integer userId) {
        IotBusinessUserRel iotBusinessUserRel = iotBusinessUserRelMapper.isAuthorized(businessId, businessType, userId);
        if (iotBusinessUserRel != null){
            return true;
        }
        return false;
    }

    @Override
    public void deleteByUserIdConcentratorId(Integer userId, int concentratorId) {
        IotBusinessUserRel iotBusinessUserRel = new IotBusinessUserRel();
        iotBusinessUserRel.setUserId(userId);
        iotBusinessUserRel.setBusinessId(concentratorId);
        //集中器
        iotBusinessUserRel.setBusinessType(1);
        iotBusinessUserRelMapper.deleteByUserIdConcentratorId(iotBusinessUserRel);
    }

    @Override
    public IotBusinessUserRel findIotBusinessUserRel(Integer userId, Integer concentratorId) {
        return iotBusinessUserRelMapper.findIotBusinessUserRel(userId,concentratorId);
    }
}
