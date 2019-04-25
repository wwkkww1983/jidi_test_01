package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotSingleLightController;
import com.rz.iot.think.model.param.SlcInsertParam;
import com.rz.iot.think.model.show.IotSingleLightControllerShowDetail;
import com.rz.iot.think.model.show.IotSingleLightControllerShowForStreetLightDetail;

import java.util.HashMap;
import java.util.List;

public interface IotSingleLightControllerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotSingleLightController record);

    int insertSelective(IotSingleLightController record);

    IotSingleLightController selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotSingleLightController record);

    int updateByPrimaryKey(IotSingleLightController record);

    /**
     * 根据路灯ID查询所有的单灯控制器
     * @param streetlightId
     * @return
     */
    List<IotSingleLightControllerShowForStreetLightDetail> findByStreetlightId(Integer streetlightId);

    /**
     * 根据单灯控制器的id列表查询单灯控制器信息
     * @param ids slc的id字符串
     * @return 返回查询结果
     */
    List<HashMap> getInfosBySlcIds(List<Integer> ids);

    /**
     * 根据集中器id查询单灯控制器
     * @param concentratorId 集中器id
     * @return
     */
    List<IotSingleLightController> findByConcentratorId(Integer concentratorId);

    /**
     * 批量插入单灯控制器
     * @param list 单灯控制器列表
     */
    void batchInsert(List<SlcInsertParam> list);

    /**
     * 批量插入单灯控制器和路灯关联信息
     * @param list 单灯控制器信息列表
     */
    void batchInsertSlcRel(List<SlcInsertParam> list);

    /**
     * 根据集中器id对单灯控制器信息进行假删除
     * @param concentratorId 集中器id
     */
    void fakeDelete(Integer concentratorId);

    /**
     * 查找未与路灯绑定的单灯控制器
     * @param concentratorId 集中器id
     * @return 返回slc id列表
     */
    List<Integer> getSlcIdsByConcentratorId(Integer concentratorId);

    /**
     * 批量删除slc和路灯之间的联系
     * @param list 单灯控制器id列表
     */
    void fakeDeleteRel(List<Integer> list);

    /**
     * 查找未与路灯绑定的单灯控制器
     * @return
     */
    List<IotSingleLightController> findNoBindingWithStreetLight();

    /**
     * 单灯控制器详细信息
     * @param slcId 单灯控制器id
     * @return
     */
    IotSingleLightControllerShowDetail detail(Integer slcId);

    /**
     * 根据序列号查找
     * @param sn 单灯控制器sn
     * @return
     */
    IotSingleLightController findBySn(String sn);
}