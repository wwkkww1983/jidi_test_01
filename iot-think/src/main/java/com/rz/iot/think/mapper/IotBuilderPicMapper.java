package com.rz.iot.think.mapper;

import com.rz.iot.think.model.IotBuilderPic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IotBuilderPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IotBuilderPic record);

    int insertSelective(IotBuilderPic record);

    IotBuilderPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IotBuilderPic record);

    int updateByPrimaryKeyWithBLOBs(IotBuilderPic record);

    int updateByPrimaryKey(IotBuilderPic record);

    /**
     * 根据业务id，业务类型查找所有施工图
     * @param businessId
     * @param businessType
     * @return
     */
    List<String> findByBusinessId(@Param("businessId") Integer businessId, @Param("businessType") Integer businessType);

    /**
     * 批量插入
     * @param list
     */
    void insertBatch(List<IotBuilderPic> list);

    /**
     * 根据业务id、业务类型删除
     * @param businessId 业务id
     * @param businessType 业务类型
     */
    void delByBusinessId(@Param("businessId") Integer businessId, @Param("businessType") Integer businessType);

    /**
     * 批量插入施工图片
     * @param picList 施工图片信息列表
     * @return 返回插入成功条数
     */
    Integer batchInsert(List<IotBuilderPic> picList);
}