package com.rz.iot.think.service.impl;

import com.rz.iot.think.mapper.IotMonitorMapper;
import com.rz.iot.think.model.UserInfo;
import com.rz.iot.think.model.param.MonitorSearchParam;
import com.rz.iot.think.model.show.MonitorDetail;
import com.rz.iot.think.model.show.MonitorList;
import com.rz.iot.think.service.IotMonitorService;
import com.rz.iot.think.utils.RzIotDBConstParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Author by xuxiake, Date on 2019/3/19.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
@Service("iotMonitorService")
public class IotMonitorServiceImpl implements IotMonitorService {

    @Resource
    private IotMonitorMapper iotMonitorMapper;

    /**
     * 获取摄像头列表
     * @return 返回摄像头信息列表
     */
    @Override
    public List<MonitorList> getMonitorList(MonitorSearchParam param) {
        //获取用户信息
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        return iotMonitorMapper.getMonitorList(userInfo.getId(), param);
    }

    /**
     * 根据摄像头sn获取摄像头详细信息
     * @param monitorSn 摄像头sn
     * @return 返回摄像头详细信息
     */
    @Override
    public MonitorDetail getMonitorDetail(String monitorSn) {
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        return iotMonitorMapper.getDetailBySn(monitorSn, userInfo.getId());
    }

    /**
     *
     * 根据摄像头sn更新摄像头名称
     * @param param 更新参数，内包含摄像头sn和摄像头名称
     */
    @Override
    public void updateMonitorInfo(HashMap param) {
        iotMonitorMapper.updateMonitorInfo(param);
    }


}
