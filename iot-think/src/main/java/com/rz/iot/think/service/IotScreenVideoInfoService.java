package com.rz.iot.think.service;

import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.param.IotScreenVideoInfoSelectParam;
import com.rz.iot.think.model.screen.IotScreenVideoInfo;
import it.sauronsoftware.jave.EncoderException;
import org.csource.common.MyException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @Author:jidi
 * @Date:2019/04/01 17:22
 * @Description:屏幕播放素材（视频）操作 接口
 **/
public interface IotScreenVideoInfoService {

    /**
     * @Desc:分页查询所有的未被删除的屏幕播放素材（视频）
     */
    Result findAll(Page<IotScreenVideoInfo> page);

    /**
     * @Desc:根据素材名和上传者分页查询所有的未被删除的屏幕播放素材（视频）
     */
    Result findAllByCondition(Page<IotScreenVideoInfoSelectParam> page, IotScreenVideoInfoSelectParam iotScreenVideoInfoSelectParam);

    /**
     * @Desc:查询在视频来源表（iot_screen_video_source）中的视频素材
     */
    Result findById(List<Integer> iotScreenMaterialIds);

    /**
     * @Desc:批量删除记录
     */
    Result delByIds(List<Integer> iotScreenMaterialIds);

    /**
     * @Desc:增加视频素材
     * @param request 客户端请求
     * @param userId 上传者id
     * @param file 上传的视频素材文件
     */
    Result addIotScreenVideoInfo(HttpServletRequest request,Integer userId, MultipartFile file);

    /**
     * @Desc:根据name，hash_key，creatAdmin查询id
     */
    Integer selectIdByCondition(IotScreenVideoInfo iotScreenVideoInfo);
}
