package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotMonitor;
import com.rz.iot.think.model.param.MonitorSearchParam;
import com.rz.iot.think.model.show.IotStreetlightInstallDevForNoBinding;
import com.rz.iot.think.model.show.IotStreetlightInstallDevShowDetail;
import com.rz.iot.think.model.show.MonitorDetail;
import com.rz.iot.think.model.show.MonitorList;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface IotMonitorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotMonitor record);

    int insertSelective(IotMonitor record);

    IotMonitor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotMonitor record);

    int updateByPrimaryKey(IotMonitor record);

    /**
     * 查找未与路灯绑定的摄像头
     * @return
     */
    List<IotStreetlightInstallDevForNoBinding> findNoBinding();

    /**
     * 获取摄像头信息列表
     * @return 返回摄像头信息列表
     */
    List<MonitorList> getMonitorList(@Param("userId") Integer userId, @Param("param")MonitorSearchParam param);

    /**
     * 根据摄像头sn获取摄像头详细信息
     * @param monitorSn 摄像头详细信息
     * @return 返回摄像头详细信息
     */
    MonitorDetail getDetailBySn(String monitorSn, Integer userId);

    /**
     * 根据摄像头sn更新摄像头名称
     * @param param 更新参数，内包含摄像头sn和摄像头名称
     */
    void updateMonitorInfo(@Param("param")HashMap param);

    /**
     * 摄像头详情（路灯管理）
     * @param monitorId 摄像头id
     * @return
     */
    IotStreetlightInstallDevShowDetail detailForStreetLight(Integer monitorId);
}