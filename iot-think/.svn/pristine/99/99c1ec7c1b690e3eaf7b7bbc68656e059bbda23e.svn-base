package com.rz.iot.think.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.StreetlightSwitch;
import com.rz.iot.think.service.IotSingleLightControllerService;
import com.rz.iot.think.service.IotStreetlightService;
import com.rz.iot.think.service.impl.IotStreetlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * Author by ZhouYz, Date on 2019/3/14.
 *
 * 单灯调光控制器
 */

@RestController
@RequestMapping("/slc")
public class SingleSwitchController {


    @Autowired
    private IotStreetlightService iss;
    @Resource
    private IotSingleLightControllerService iotSingleLightControllerService;

    @RequestMapping("/test2")
    public String test(@RequestBody HashMap<String, Object> map) {
        System.out.println(map);
        return "test";
    }

    /**
     * 获取单灯调光页面的信息列表
     *
     * @see IotStreetlightServiceImpl#getSlcSwitchLightInfoList(HashMap map)
     *
     * @return Json
     */
    @RequestMapping(value = "/getInfoList")
    public Result getInfoList(@RequestBody HashMap<String, Object> param){

        //设置起始页和页面大小
        PageHelper.startPage((int)param.get("pageNum"), (int)param.get("pageSize"));
        param.remove("pageNum");
        param.remove("pageSize");

        //找出参数空值
        List<String> list = new ArrayList<>();
        for (String key : param.keySet()){
            if(param.get(key) == null || "".equals(param.get(key))){
                list.add(key);
            }
        }
        //去除参数空值
        for(String key : list){
            param.remove(key);
        }

        //获取查询结果
        List<StreetlightSwitch> infoList = iss.getSlcSwitchLightInfoList(param);
        PageInfo<StreetlightSwitch> pageInfo = new PageInfo<>(infoList);

        Result res = new Result();
        res.setMessage("查询成功！");
        res.setData(pageInfo);
        return res;
    }

    /**
     *
     * @param ledId led灯id
     * @param signal 开闭信号
     * @return 返回结果
     */
    @RequestMapping(value = "/switchLight")
    public Result switchLight(String ledId, String signal){
        //todo

        Result res = new Result();
        res.setMessage("操作成功！");
        return res;
    }

    /**
     *
     * @param ledId led灯id
     * @param brightness 亮度
     * @return 返回结果
     */
    @RequestMapping(value = "/turnBrightness")
    public Result turnBrightness(String ledId, String brightness){
        //todo

        Result res = new Result();
        res.setMessage("操作成功！");
        return res;
    }

    /**
     * 查找未与路灯绑定的单灯控制器
     * @return
     */
    @RequestMapping("/findNoBindingWithStreetLight")
    public Result findNoBindingWithStreetLight() {
        return iss.findNoBindingWithStreetLight();
    }

    /**
     * 单灯控制器详细信息
     * @param slcId 单灯控制器id
     * @return
     */
    @RequestMapping("/detail")
    public Result detail(Integer slcId) {
        return iotSingleLightControllerService.detail(slcId);
    }

}
