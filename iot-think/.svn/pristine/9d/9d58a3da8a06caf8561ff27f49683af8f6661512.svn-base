package com.rz.iot.think.controller;

import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.UserInfo;
import com.rz.iot.think.model.param.IotScreenMaterialDelParam;
import com.rz.iot.think.model.param.IotScreenMaterialKeyRelDelParam;
import com.rz.iot.think.model.param.IotScreenPicInfoSelectParam;
import com.rz.iot.think.model.param.IotScreenVideoInfoSelectParam;
import com.rz.iot.think.model.screen.IotScreenPicInfo;
import com.rz.iot.think.model.screen.IotScreenVideoInfo;
import com.rz.iot.think.service.IotScreenMaterialKeyRelService;
import com.rz.iot.think.service.IotScreenMaterialUploadRecordService;
import com.rz.iot.think.service.IotScreenPicInfoService;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.service.IotScreenVideoInfoService;
import com.rz.iot.think.utils.RzIotDBConstParam;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.security.Security;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @Author:jidi
 * @Date:2019/04/01 16:47
 * @Description:屏幕播放素材管理
 **/

@RestController
@RequestMapping("/material")
public class IotScreenMaterialController {

    @Resource
    private IotScreenPicInfoService iotScreenPicInfoService;
    @Resource
    private IotScreenVideoInfoService iotScreenVideoInfoService;
    @Resource
    private IotScreenMaterialKeyRelService iotScreenMaterialKeyRelService;
    @Resource
    private IotScreenMaterialUploadRecordService iotScreenMaterialUploadRecordService;

    /**
     * @Desc:根据条件分页查询所有未被删除的播放素材
     * @param type 素材类型  1为图片 2为视频
     * @param  materialName 素材名称
     * @param  userName 上传者
     */
    @RequestMapping("/findMaterials")
    public Result findMaterials(Page page, Integer type, String materialName, String userName){
        Result res = new Result();
        //如果传递过来的素材类型为空
        if(type == null ){
            return  Result.paramNull(res);
        }

        //查询图片
        if(type == RzIotDBConstParam.MATERTAL_TYPE_OF_PICTURE){
            IotScreenPicInfoSelectParam iotScreenPicInfoSelectParam = new IotScreenPicInfoSelectParam();
            if((materialName != null) && (materialName.equals("") == false)){
                iotScreenPicInfoSelectParam.setName(materialName);
            }
            if((userName != null) && (userName.equals("") == false)){
                iotScreenPicInfoSelectParam.setUserName(userName);
            }
            //根据条件分页查询未删除图片素材
            res = iotScreenPicInfoService.findAllByCondition(page, iotScreenPicInfoSelectParam);
        }

        //查询视频
        if(type == RzIotDBConstParam.MATERTAL_TYPE_OF_VIDEO){
            IotScreenVideoInfoSelectParam iotScreenVideoInfoSelectParam = new IotScreenVideoInfoSelectParam();
            if((materialName != null) && (materialName.equals("") == false)){
                iotScreenVideoInfoSelectParam.setName(materialName);
            }
            if((userName != null) && (userName.equals("") == false)){
                iotScreenVideoInfoSelectParam.setUserName(userName);
            }
            //根据条件分页查询未删除视频素材
            res = iotScreenVideoInfoService.findAllByCondition(page, iotScreenVideoInfoSelectParam);
        }
        return res;
    }

    /**
     * @Desc:删除素材
     * @param  param:封装素材id集合与素材类型
     */
    @RequestMapping("/delMaterials")
    public Result delMaterialList(@RequestBody IotScreenMaterialDelParam param){
        Result res = new Result();
        //如果传递过来的素材类型为空
        if(param.getType() == null ){
            return  Result.paramNull(res);
        }
        //传递过来的id集合为空
        if(param.getIotScreenMaterialIds().size() == 0){
            return  Result.paramNull(res);
        }

        //删除图片
        if(param.getType() == RzIotDBConstParam.MATERTAL_TYPE_OF_PICTURE){
            //查询在图片资源表中是否存在要删除的图片素材
            res = iotScreenPicInfoService.findById(param.getIotScreenMaterialIds());
            if(res.getData() == null){
                //不存在，删除记录
                res = iotScreenPicInfoService.delByIds(param.getIotScreenMaterialIds());
                //删除素材记录表中相关的数据
                IotScreenMaterialKeyRelDelParam iotScreenMaterialKeyRelDelParam = new IotScreenMaterialKeyRelDelParam();
                iotScreenMaterialKeyRelDelParam.setType(RzIotDBConstParam.MATERTAL_TYPE_OF_PICTURE);
                iotScreenMaterialKeyRelDelParam.setIotScreenMaterialKeyRelList(param.getIotScreenMaterialIds());
                iotScreenMaterialKeyRelService.delByMaterialIdAndMaterialType(iotScreenMaterialKeyRelDelParam);
            }
        }
        //删除视频
        if(param.getType() == RzIotDBConstParam.MATERTAL_TYPE_OF_VIDEO){
            //查询在视频资源表中是否存在要删除的素材
            res = iotScreenVideoInfoService.findById(param.getIotScreenMaterialIds());
            if(res.getData() == null){
                //不存在，删除记录
               res = iotScreenVideoInfoService.delByIds(param.getIotScreenMaterialIds());
               //删除素材类型记录表中相关的数据
               IotScreenMaterialKeyRelDelParam iotScreenMaterialKeyRelDelParam = new IotScreenMaterialKeyRelDelParam();
               iotScreenMaterialKeyRelDelParam.setType(RzIotDBConstParam.MATERTAL_TYPE_OF_VIDEO);
               iotScreenMaterialKeyRelDelParam.setIotScreenMaterialKeyRelList(param.getIotScreenMaterialIds());
               iotScreenMaterialKeyRelService.delByMaterialIdAndMaterialType(iotScreenMaterialKeyRelDelParam);
            }
        }
        return res;
    }

    /**
     * @Desc:增加素材
     * @param materialType：素材类型 1为图片 2为视频
     * @param file:上传素材文件
     * @param request：客户端请求
     */
    @RequestMapping("/addMaterials")
    public Result addMaterials(HttpServletRequest request,Integer materialType, MultipartFile file) {
        Result res = new Result();

        //上传素材id
        Integer materialId = null;
        //传递过来的素材类型为空
        if(materialType == null ){
            return  Result.paramNull(res);
        }
        //传递过来的文件为空
        if(file == null || file.isEmpty()){
            return  Result.paramNull(res);
        }

       //得到上传者ID
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        Integer userId = userInfo.getId();

        //上传图片素材
        if(materialType == RzIotDBConstParam.MATERTAL_TYPE_OF_PICTURE){
            //增加图片素材
            res = iotScreenPicInfoService.addIotScreenPicInfo(userId, file);
            IotScreenPicInfo iotScreenPicInfo = (IotScreenPicInfo)res.getData();
            //查询新增图片素材记录的ID
            materialId = iotScreenPicInfoService.selectIdByCondition(iotScreenPicInfo);
        }

        //上传视频素材
        if(materialType == RzIotDBConstParam.MATERTAL_TYPE_OF_VIDEO){
            //增加视频素材
            res = iotScreenVideoInfoService.addIotScreenVideoInfo(request, userId, file);
            IotScreenVideoInfo iotScreenVideoInfo = (IotScreenVideoInfo)res.getData();
            //查询新增视频素材记录的ID
            materialId = iotScreenVideoInfoService.selectIdByCondition(iotScreenVideoInfo);
        }

        //增加记录到素材记录表
        iotScreenMaterialKeyRelService.addIotScreenMaterialKeyRel(materialType, materialId);

        //增加记录到素材上传记录表
        iotScreenMaterialUploadRecordService.addIotScreenMaterialUploadRecord(request, materialType, materialId, userId);
        return res;
    }
}
