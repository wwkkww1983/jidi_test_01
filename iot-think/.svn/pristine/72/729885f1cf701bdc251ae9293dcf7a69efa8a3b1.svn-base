package com.rz.iot.think.service;

import com.rz.iot.think.model.param.MonitorSearchParam;
import com.rz.iot.think.model.show.MonitorDetail;
import com.rz.iot.think.model.show.MonitorList;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.List;

/**
 * Author by xuxiake, Date on 2019/3/19.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
public interface IotMonitorService {

    /**
     * 获取摄像头列表
     * @return 返回摄像头信息列表
     */
    List<MonitorList> getMonitorList(MonitorSearchParam param);

    /**
     * 根据摄像头sn获取摄像头详细信息
     * @param monitorSn 摄像头sn
     * @return 返回摄像头详细信息
     */
    MonitorDetail getMonitorDetail(String monitorSn);

    /**
     *
     * 根据摄像头sn更新摄像头名称
     * @param param 更新参数，内包含摄像头sn和摄像头名称
     */
    void updateMonitorInfo(HashMap param);
}
