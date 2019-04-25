package com.rz.iot.think.controller;

import com.rz.iot.think.exception.NullParamException;
import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.UserInfo;
import com.rz.iot.think.model.param.AddConcentratorParam;
import com.rz.iot.think.model.param.IotConcentratorListQueryParam;
import com.rz.iot.think.model.show.ConcentratorDetail;
import com.rz.iot.think.model.show.IotConcentratorShowList;
import com.rz.iot.think.service.IotBuilderPicService;
import com.rz.iot.think.service.IotBusinessUserRelService;
import com.rz.iot.think.service.IotConcentratorService;
import com.rz.iot.think.utils.RzIotDBConstParam;
import com.rz.iot.think.utils.RzIotErrMessage;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * 描述:
 * 集中器
 *
 * @author Zhouyz
 * @create 2019-03-21 8:51
 */
@RestController
@RequestMapping("/concentrator")
public class IotConcentratorController {

    @Autowired
    private IotConcentratorService iotConcentratorService;
    @Autowired
    private IotBusinessUserRelService iotBusinessUserRelService;
    @Autowired
    private IotBuilderPicService iotBuilderPicService;

    /**
     * 查询集中器详细信息
     *
     * @see IotConcentratorService#concentratorDetail(Integer)
     * @see IotConcentratorService#getSlcForConcentrator(Integer)
     * @see IotConcentratorService#getLineInAndOut(Integer)
     *
     * @param concentratorId 集中器id
     * @return 返回查询结果，包括集中器信息，集中器下辖单灯控制器信息，进出线信息，建造厂商信息
     */
    @RequestMapping("/getDetailById")
    public Result getDetailById(Integer concentratorId){
        Result res = new Result();
        //判断传入参数是否为空
        if(concentratorId == null){
            res.setCode(RzIotErrMessage.PARAM_IS_NULL);
            return res;
        }
        //获取集中器信息
        ConcentratorDetail con = iotConcentratorService.concentratorDetail(concentratorId);

        if(con == null) {
            res.setCode(RzIotErrMessage.RESOURCES_NOT_FOUND);
            res.setMessage("查询结果为空");
            return res;
        }
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        boolean authorized = iotBusinessUserRelService.isAuthorized(concentratorId, RzIotDBConstParam.BUSSINESS_TYPE_OF_CONCENTRATOR, userInfo.getId());
        // 鉴权
        if (!authorized) {
            return Result.unAuthorized(res);
        }


        //获取集中器关联单灯控制器信息
        List<HashMap> slcList = iotConcentratorService.getSlcForConcentrator(concentratorId);
        //获取进出线信息
        HashMap lineInAnOut = iotConcentratorService.getLineInAndOut(concentratorId);
        //查询施工单位信息
        HashMap builder = iotConcentratorService.builderInfos(concentratorId);
        // 查询施工图
        List<String> builderPics = iotBuilderPicService.getBuilderPics(concentratorId, RzIotDBConstParam.BUSSINESS_TYPE_OF_CONCENTRATOR);
        //将施工图信息加入施工单位信息中
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("detail", con);
        resMap.put("slcList", slcList);
        resMap.put("lineInAndOut", lineInAnOut);
        resMap.put("builder", builder);
        resMap.put("builderPics", builderPics);
        res.setData(resMap);
        return res;
    }

    /**
     * 根据集中器的序列号查询单灯控制器
     * @param sn 集中器序列号
     * @return 单灯控制器信息
     *
     */
    @RequestMapping("/findSingleLightsByCSN")
    public Result findSingleLightsByCSN(String sn){
        return iotConcentratorService.findSingleLightsByCSN(sn);
    }
    /**
     * 查询集中器列表
     * @param page 分页参数
     * @param param 查询参数
     * @return
     */
    @RequestMapping("/findAll")
    public Result findAll(Page<IotConcentratorShowList> page, IotConcentratorListQueryParam param) {
        return iotConcentratorService.findAll(page, param);
    }

    /**
     * 新增一条集中器信息
     * @param addConcentratorParam 参数实体类
     * @see AddConcentratorParam
     *
     * @return 插入成功情况
     * @throws NullParamException 空参数异常
     */
    @RequestMapping("/add")
    public Result add(@RequestBody AddConcentratorParam addConcentratorParam) throws NullParamException {
        iotConcentratorService.addConcentratorInfos(addConcentratorParam);
        Result result = new Result();
        result.setMessage("新增成功！");
        return result;
    }

    /**
     * 更新集中器信息
     * @param addConcentratorParam 参数实体类
     * @see AddConcentratorParam
     * @return 更新情况
     */
    @RequestMapping("/update")
    public Result updateInfos(@RequestBody AddConcentratorParam addConcentratorParam) throws NullParamException {
        Result res = new Result();
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        boolean authorized = iotBusinessUserRelService.isAuthorized(addConcentratorParam.getConcentrator().getId(), RzIotDBConstParam.BUSSINESS_TYPE_OF_CONCENTRATOR, userInfo.getId());
        // 鉴权
        if (!authorized) {
            return Result.unAuthorized(res);
        }
        iotConcentratorService.updateConcentratorInfos(addConcentratorParam);

        res.setMessage("更新成功！");
        return res;
    }

    /**
     * 删除集中器及集中器相关联信息
     * @param concentratorId 集中器id
     * @return 返回删除是否成功的信息
     * @throws NullParamException 空参数指针
     */
    @RequestMapping("/deleteConcentrator")
    public Result deleteConcentrator(Integer concentratorId) throws NullParamException {
        Result res = new Result();
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        boolean authorized = iotBusinessUserRelService.isAuthorized(concentratorId, RzIotDBConstParam.BUSSINESS_TYPE_OF_CONCENTRATOR, userInfo.getId());
        // 鉴权
        if (!authorized) {
            return Result.unAuthorized(res);
        }
        iotConcentratorService.deleteConcentrator(concentratorId);
        res.setMessage("删除成功！");
        return res;
    }
    /**
     * 根据Excel表导入数据
     * @return 返回单灯控制器信息
     */
    @RequestMapping("/importExcel")
    public Result importExcel(MultipartFile file){
        List<HashMap<String, Object>> slcInfos = iotConcentratorService.importExcel(file);
        Result result= new Result();
        result.setData(slcInfos);
        return result;
    }

    /**
     * 到处excel模板
     * @param response http响应
     */
    @RequestMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response){
        iotConcentratorService.templateDownload(response);
    }
    /**
     * 查询未分组的集中器
     * @return
     */
    @RequestMapping("/findNoGroup")
    public Result findNoGroup() {
        return iotConcentratorService.findNoGroup();
    }

    /**
     * 查询所有与开关策略绑定的集中器(组).也是解绑页面入口
     * @Param conentratorType 集中器的类型
     * @return
     */
    @RequestMapping("/findBindConStrategy")
    public Result findBindConStrategy(Integer concentratorType){
        return iotConcentratorService.findBindConStrategy(concentratorType);
    }
}
