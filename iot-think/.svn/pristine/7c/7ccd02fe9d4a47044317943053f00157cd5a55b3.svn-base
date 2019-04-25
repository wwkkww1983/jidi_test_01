package com.rz.iot.think.controller;

import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.param.IotScreenPlayStrategyAddParam;
import com.rz.iot.think.model.param.IotScreenPlayStrategyListQueryParam;
import com.rz.iot.think.model.screen.DownloadProgressModel;
import com.rz.iot.think.service.IotScreenPlayStrategyService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: yyjuan
 * @Date: 2019/3/22 0022 09:52
 * @Description: 播放策略
 */
@RestController
@RequestMapping("/screenPlayStrategy")
public class IotScreenPlayStrategyController {

    @Resource
    private IotScreenPlayStrategyService iotScreenPlayStrategyService;

    /**
     * 屏幕策略列表
     * @param page 分页参数
     * @param param 查询参数
     * @return
     */
    @RequestMapping("/findList")
    public Result findList(Page page, IotScreenPlayStrategyListQueryParam param) {
        return iotScreenPlayStrategyService.findList(page, param);
    }

    /**
     * 信息屏播放详情
     * @param playStrategyId 策略id
     * @return
     */
    @RequestMapping("/detail")
    public Result detail(Integer playStrategyId) {
        return iotScreenPlayStrategyService.detail(playStrategyId);
    }

    /**
     * 下发信息屏播放策略
     * @param strategyId 策略id
     * @return
     */
    @RequestMapping("/sendStrategy")
    public Result sendStrategy(Integer strategyId){

        return iotScreenPlayStrategyService.sendStrategy(strategyId);
    }

    /**
     * 获取xixunplay下载进度
     * @return
     */
    @RequestMapping(value = "/getDownloadProgress")
    public void getDownloadProgress(@RequestBody DownloadProgressModel param) {

        iotScreenPlayStrategyService.getDownloadProgress(param);
    }

    /**
     * 信息屏下载素材的接口
     * @param key
     * @param response
     */
    @RequestMapping("/downloadMaterial")
    public void downloadMaterial(String key, HttpServletResponse response) {
        iotScreenPlayStrategyService.downloadMaterial(key, response);
    }

    /**
     * 删除播放策略
     * @param strategyId 策略id
     * @return
     */
    @RequestMapping("/del")
    public Result del(Integer strategyId) {
        return iotScreenPlayStrategyService.del(strategyId);
    }

    /**
     * 新增策略
     * @param param
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody IotScreenPlayStrategyAddParam param) {
        return iotScreenPlayStrategyService.add(param);
    }

    /**
     * 停止播放
     * @param playStrategyId 策略id
     * @param operation 0：停止；1：播放
     * @return
     */
    @RequestMapping("/stopPlayer")
    public Result stopPlayer(Integer playStrategyId, Integer operation) {

        return iotScreenPlayStrategyService.stopPlayer(playStrategyId, operation);
    }
}
