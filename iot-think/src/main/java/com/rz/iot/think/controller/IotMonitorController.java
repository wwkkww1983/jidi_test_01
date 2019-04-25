package com.rz.iot.think.controller;

import com.rz.iot.think.exception.NullParamException;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.param.MonitorSearchParam;
import com.rz.iot.think.service.IotMonitorService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Author by xuxiake, Date on 2019/3/19.
 * PS: Not easy to write code, please indicate.
 * Description：监控摄像头controller
 */
@RestController
@RequestMapping("/monitor")
public class IotMonitorController {

    @Resource
    private IotMonitorService iotMonitorService;

    /**
     * 获取摄像头列表
     * @return 返回摄像头信息列表
     */
    @RequestMapping("/monitorList")
    public Result getMonitorList(MonitorSearchParam param){
        Result result = new Result();
        result.setData(iotMonitorService.getMonitorList(param));
        return result;
    }

    /**
     * 根据摄像头sn获取摄像头详细信息
     * @param monitorSn 摄像头详细信息
     * @return 返回摄像头详细信息
     */
    @RequestMapping("/monitorDetail")
    public Result getMonitorDetail(String monitorSn) throws NullParamException {
        Result result = new Result();
        if(monitorSn == null || monitorSn.equals("")){
            throw new NullParamException("摄像头sn不能为空！");
        }
        result.setData(iotMonitorService.getMonitorDetail(monitorSn));
        return result;
    }

    /**
     * 根据摄像头sn更新摄像头名称或安装高度
     */
    @RequestMapping("/updateInfo")
    public Result updateMonitorName(String monitorSn, String monitorName, Float installPlace) throws NullParamException {
        HashMap<String, Object> param = new HashMap<>();
        param.put("monitorSn", monitorSn);
        param.put("monitorName", monitorName);
        param.put("installPlace", installPlace);
        //判断所需参数是否传递
        if (param.get("monitorSn") == null || param.get("monitorSn").equals("")) {
            throw new NullParamException("摄像头sn不能为空！");
        }
        //修改参数不能同时为空
        if ((param.get("installPlace") == null || param.get("installPlace").equals("")) && (param.get("monitorName") == null || param.get("monitorName").equals(""))) {
            throw new NullParamException("摄像头名称不能为空！");
        }

        //修改摄像头名称
        iotMonitorService.updateMonitorInfo(param);
        Result res = new Result();
        res.setMessage("修改成功！");
        return res;
    }
}
