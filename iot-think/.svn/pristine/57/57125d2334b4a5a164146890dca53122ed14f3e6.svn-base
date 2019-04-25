package com.rz.iot.think.service.impl;

import com.rz.iot.think.mapper.screen.IotScreenMaterialUploadRecordMapper;
import com.rz.iot.think.model.UserInfo;
import com.rz.iot.think.model.screen.IotScreenMaterialUploadRecord;
import com.rz.iot.think.service.IotScreenMaterialUploadRecordService;
import com.rz.iot.think.utils.CommonFunctions;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author:jidi
 * @Date:2019/04/04 9:14
 * @Description:素材上传记录表操作接口实现类
 **/
@Log4j2
@Service("iotScreenMaterialUploadRecordService")
public class IotScreenMaterialUploadRecordImpl implements IotScreenMaterialUploadRecordService {

    @Resource
    private IotScreenMaterialUploadRecordMapper iotScreenMaterialUploadRecordMapper;

    /**
     * @Desc:向素材上传记录表中增加一条记录
     * @param  request 请求
     * @param materialType 素材类型
     * @param materialId 素材id
     * @param userId 素材上传者id
     */
    @Override
    public Integer addIotScreenMaterialUploadRecord(HttpServletRequest request,Integer materialType, Integer materialId, Integer userId) {
        IotScreenMaterialUploadRecord iotScreenMaterialUploadRecord = new IotScreenMaterialUploadRecord();
        //得到上传ip地址
        String ipAddress = CommonFunctions.getIpAddress(request);
        //设置上传Ip地址
        iotScreenMaterialUploadRecord.setClientIp(ipAddress);
        //设置素材上传者id
        iotScreenMaterialUploadRecord.setUploadUser(userId);
        //设置素材类型
        iotScreenMaterialUploadRecord.setMaterialType(materialType);
        //设置素材id
        iotScreenMaterialUploadRecord.setMaterialId(materialId);
        return iotScreenMaterialUploadRecordMapper.insertSelective(iotScreenMaterialUploadRecord);
    }
}
