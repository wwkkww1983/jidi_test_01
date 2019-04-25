package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotStreetlight;
import com.rz.iot.think.model.StreetlightSwitch;
import com.rz.iot.think.model.param.IotStreetlightListQueryParam;
import com.rz.iot.think.model.show.GISConcentratorList;
import com.rz.iot.think.model.show.GISStreetlightShowList;
import com.rz.iot.think.model.show.IotStreetlightShowDetail;
import com.rz.iot.think.model.show.IotStreetlightShowList;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface IotStreetlightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotStreetlight record);

    int insertSelective(IotStreetlight record);

    IotStreetlight selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotStreetlight record);

    int updateByPrimaryKey(IotStreetlight record);

    /**
     * 获取单灯调光页面所必须的信息列表
     * @param param 查询参数
     * @return 返回查询结果
     */
    List<StreetlightSwitch> getInfoList(@Param("userId") Integer userId, @Param("param")HashMap param);

    /**
     * 查询所有路灯
     * @param userId
     * @return
     */
    List<IotStreetlightShowList> findAll(@Param("userId") Integer userId, @Param("param") IotStreetlightListQueryParam param);

    IotStreetlightShowDetail findById(Integer streetlightId);

    /**
     * 查询GIS地图中的路灯信息
     * @param param 查询参数
     * @return 查询结果
     */
    List<GISStreetlightShowList> getStreetlightInGis(@Param("param") HashMap param, @Param("userId") Integer userId);

    /**
     * 批量插入
     * @param list
     */
    void insertBatch(List<IotStreetlight> list);

    /**
     * 查询GIS地图中的打开了的路灯信息
     * @param param 查询参数
     * @return 查询结果
     */
    List<GISStreetlightShowList> getStreetlightInGisOpen(@Param("param") HashMap param, @Param("userId") Integer userId);

    /**
     * 查询GIS地图中的关闭了的路灯信息
     * @param param 查询参数
     * @return 查询结果
     */
    List<GISStreetlightShowList> getStreetlightInGisOff(@Param("param") HashMap param, @Param("userId") Integer userId);

    /**
     * 查询某片区域的集中器信息，查询参数与
     * @see IotStreetlightMapper#getStreetlightInGis( HashMap param,Integer userId) 一致
     * @param param 查询参数
     * @param userId 当前用户id
     * @return 返回查询结果
     */
    List<GISConcentratorList> getConcentratorListInGis(@Param("param") HashMap param, @Param("userId") Integer userId);

    /**
     * 获取道路id与名称
     * @return 返回查询结果
     */
    List<HashMap> getRoadIds();

    /**
     * 获取区id和名称
     * @return 返回查询结果
     */
    List<HashMap> getDistrictIds();

    /**
     * 获取故障设备列表
     * @return 返回查询结果
     */
    List<HashMap> getStreetlightFaults();


}