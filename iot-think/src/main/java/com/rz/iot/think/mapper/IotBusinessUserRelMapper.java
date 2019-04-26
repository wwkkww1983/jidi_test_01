package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotBusinessUserRel;
import com.rz.iot.think.model.param.PermissionDataEditParam;
import com.rz.iot.think.model.show.PermissionShowDataList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IotBusinessUserRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotBusinessUserRel record);

    int insertSelective(IotBusinessUserRel record);

    IotBusinessUserRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotBusinessUserRel record);

    int updateByPrimaryKey(IotBusinessUserRel record);

    //批量插入
    void insertBatch(List<IotBusinessUserRel> list);

    //批量删除（适用于权限管理）
    void delBatch(@Param("param") PermissionDataEditParam param);

    /**
     * 根据用户id删除用户业务关联关系
     * @param userId
     */
    void delByUserId(Integer userId);

    /**
     * 查询用户拥有的数据权限
     * @param userId
     * @return
     */
    List<PermissionShowDataList> dataOwned(@Param("userId") Integer userId);

    /**
     * 查询用户没有的数据权限
     * @param userId
     * @return
     */
    List<PermissionShowDataList> dataNotOwned(@Param("userId") Integer userId);

    /**
     * 删除用户业务关联关系
     * @param businessId 业务id
     * @param userId 用户id
     * @param businessType 业务类型
     * @return
     */
    Integer delRel(@Param("businessId") Integer businessId, @Param("userId") Integer userId, @Param("businessType") Integer businessType);

    /**
     * 检查用户是否具有权限
     * @param businessId 业务id
     * @param businessType 业务类型
     * @param userId 用户id
     * @return
     */
    IotBusinessUserRel isAuthorized(@Param("businessId") Integer businessId, @Param("businessType") Integer businessType, @Param("userId") Integer userId);

    
    /**
     * 根据集中器删除中间表关系
     * @param iotBusinessUserRel
     */
    void deleteByUserIdConcentratorId(IotBusinessUserRel iotBusinessUserRel);

    /**
     * 根据用户id以及集中器id查询关联关系
     * @param userId
     * @param concentratorId
     * @return
     */
    IotBusinessUserRel findIotBusinessUserRel(@Param("userId") Integer userId, @Param("concentratorId") Integer concentratorId);
}