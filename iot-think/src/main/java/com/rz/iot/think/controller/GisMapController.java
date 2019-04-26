package com.rz.iot.think.controller;

import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.show.GISConcentratorList;
import com.rz.iot.think.model.show.GISStreetlightShowList;
import com.rz.iot.think.model.show.IotStreetlightInstallDevShowList;
import com.rz.iot.think.model.show.IotStreetlightShowDetail;
import com.rz.iot.think.service.*;
import com.rz.iot.think.service.impl.IotConcentratorServiceImpl;
import com.rz.iot.think.service.impl.IotStreetlightServiceImpl;
import com.rz.iot.think.utils.CommonFunctions;
import com.rz.iot.think.utils.RzIotErrMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


/**
 * 描述:
 * Gis地图信息接口
 *
 * @author ZhouYz
 * * @create 2019-03-16 17:23
 */


@RestController
@RequestMapping("/gismap")
public class GisMapController {

    @Autowired
    private IotStreetlightService iss;
    @Autowired
    private IotStreetlightSlcRelService iotStreetlightSlcRelService;
    @Autowired
    private IotSingleLightControllerService iotSingleLightControllerService;
    @Autowired
    private IotStreetlightInstallDevRelService iotStreetlightInstallDevRelService;
    @Autowired
    private IotConcentratorService iotConcentratorService;

    /**
     * gis地图页面查询路灯信息
     *
     * @see IotStreetlightServiceImpl#getStreetlightInGis(HashMap)
     *
     * @param param 查询参数
     * @return json
     */
    @RequestMapping("/getStreetlights")
    public Result getStreetlightInfos(@RequestBody HashMap<String, Object> param){

        CommonFunctions.removeMapnull(param);
        //获取查询结果
        List<GISStreetlightShowList> streetlightShowList = iss.getStreetlightInGis(param);
        List<GISConcentratorList> concentratorList = iss.getConcentratorListInGIS(param);
        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("streetlightShowList", streetlightShowList);
        resMap.put("concentratorList", concentratorList);
        Result res = new Result();
        res.setData(resMap);
        res.setMessage("查询成功");
        return res;
    }

    /**
     * 获取路灯详细信息
     *
     * @see IotStreetlightInstallDevRelService#getDevByStreetlightId(Integer)
     *
     * @param StreetlightId 路灯id
     * @return 返回查询结果
     */
    @RequestMapping("/getStreetlightDetail")
    public Result getStreetlightDetail(Integer StreetlightId){
        Result result = new Result();
        IotStreetlightShowDetail streetlightInfos = iss.findById(StreetlightId);
        List<Integer> listIds = iotStreetlightSlcRelService.getSlcIds(StreetlightId);
        List<HashMap> slcList = iotSingleLightControllerService.getSlcByIds(listIds);
        List<HashMap> devs = iotStreetlightInstallDevRelService.getDevByStreetlightId(StreetlightId);

        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("streetlightInfos", streetlightInfos);
        resMap.put("slcList", slcList);
        resMap.put("devInfos", devs);
        result.setData(resMap);
        return result;
    }

    /**
     * 获取区域id和名称列表以及道路id和名称列表
     * @return 返回一个包含二者信息的map
     */
    @RequestMapping("/getDistrictAndRoad")
    public Result getDistrictAndRoad(){
        Result result = new Result();
        HashMap resMap = iss.getDistrictIdAndRoadId();
        result.setData(resMap);
        return result;
    }


    /**
     * 打开路灯
     * @return 开闭成功与否
     */
    @RequestMapping("/openStreetlight")
    public Integer openStreetlight(){
        //todo  开路灯

        return 0;
    }

    /**
     * 关闭路灯
     * @return 开闭成功与否
     */
    @RequestMapping("/offStreetlight")
    public Integer offStreetlight(){
        //todo  关路灯

        return 0;
    }

    /**
     * 批量打开路灯
     * @return 开闭成功与否
     */
    @RequestMapping("/batchOpenStreetlight")
    public Integer batchOpenStreetlight(){
        //todo  开路灯

        return 0;
    }

    /**
     * 批量关闭路灯
     * @return 开闭成功与否
     */
    @RequestMapping("/batchOffStreetlight")
    public Integer batchOffStreetlight(){
        //todo  关路灯

        return 0;
    }

    /**
     * 给路灯调光
     * @return 成功与否
     */
    @RequestMapping("turnBrightness")
    public Integer turnBrightness(){
        //todo 调光

        return 0;
    }

    /**
     * 给路灯批量调光
     * @return 成功与否
     */
    @RequestMapping("batchTurnBrightness")
    public Integer batchTurnBrightness(){
        //todo 批量调光

        return 0;
    }

    /**
     * 获取集中器信息，包括集中器下辖的单灯控制器列表
     *
     * @see IotConcentratorServiceImpl#getDetailById
     * @see IotConcentratorServiceImpl#getSlcInfosByConcentratorId
     *
     * @param concentratorId 集中器id
     * @return res
     */
    @RequestMapping("concentratorById")
    public Result concentratorById(Integer concentratorId){
        Result res = new Result();
        if(concentratorId == null){
            res.setCode(RzIotErrMessage.PARAM_IS_NULL);
            res.setMessage("参数错误！");
        }
        HashMap concentrator = iotConcentratorService.getDetailById(concentratorId);
        List<HashMap> slcInfos = iotConcentratorService.getSlcInfosByConcentratorId(concentratorId);

        HashMap<String, Object> resMap = new HashMap<>();
        resMap.put("concentrator", concentrator);
        resMap.put("slcInfos", slcInfos);
        res.setData(resMap);
        return res;
    }

    @RequestMapping("devFaults")
    public Result devFaults(){
        Result result = new Result();
        List<HashMap> faultsList = iss.getStreetlightFaults();
        result.setData(faultsList);
        return result;
    }

}