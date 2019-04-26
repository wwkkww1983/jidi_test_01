package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotStreetlightSlcRel;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface IotStreetlightSlcRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotStreetlightSlcRel record);

    int insertSelective(IotStreetlightSlcRel record);

    IotStreetlightSlcRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotStreetlightSlcRel record);

    int updateByPrimaryKey(IotStreetlightSlcRel record);

    /**
     * 查询所有相关联的路灯id和单灯控制器id
     * @return List<HashMap> 返回查询结果
     */
    @Select("select streetlight_id, slc_id from iot_streetlight_slc_rel where status = 1 ")
    List<HashMap> selectStreetlightIdAndSlcId();

    /**
     * 批量插入
     * @param list
     */
    void insertBatch(List<IotStreetlightSlcRel> list);

    /**
     * 根据路灯ID删除
     * @param streetlightId
     */
    void delByStreetlightId(Integer streetlightId);

    /**
     * 通过路灯id查询单灯控制器id
     * @param streetlightId 路灯id
     * @return 返回查询结果
     */
    List<Integer> findSlcIdsByStreetlightId(Integer streetlightId);
}