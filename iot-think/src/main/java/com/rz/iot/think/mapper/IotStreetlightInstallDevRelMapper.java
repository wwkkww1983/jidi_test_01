package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotStreetlightInstallDevRel;
import com.rz.iot.think.model.show.IotStreetlightInstallDevShowList;

import java.util.HashMap;
import java.util.List;

public interface IotStreetlightInstallDevRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotStreetlightInstallDevRel record);

    int insertSelective(IotStreetlightInstallDevRel record);

    IotStreetlightInstallDevRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotStreetlightInstallDevRel record);

    int updateByPrimaryKey(IotStreetlightInstallDevRel record);

    /**
     * 根据路灯id查询所有的挂载设备
     * @param streetlightId
     * @return
     */
    List<IotStreetlightInstallDevShowList> findByStreetlightId(Integer streetlightId);

    /**
     * 批量插入
     * @param list
     */
    void insertBatch(List<IotStreetlightInstallDevRel> list);

    /**
     * 根据路灯id删除关联关系
     * @param streetlightId 路灯id
     */
    void delByStreetlightId(Integer streetlightId);

    /**
     * 根据路灯id获取挂载设备信息，包括设备的故障信息
     * @param streetlightId 路灯id
     * @return 查询结果
     */
    List<HashMap> devInfosByStreetlightId(Integer streetlightId);
}