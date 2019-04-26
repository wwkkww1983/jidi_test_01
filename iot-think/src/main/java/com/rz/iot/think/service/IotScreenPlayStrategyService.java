package com.rz.iot.think.service;

import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.param.IotScreenPlayStrategyAddParam;
import com.rz.iot.think.model.param.IotScreenPlayStrategyListQueryParam;
import com.rz.iot.think.model.screen.DownloadProgressModel;

import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: yyjuan
 * @Date: 2019/3/22 0022 11:08
 * @Description:
 */
public interface IotScreenPlayStrategyService {

    /**
     * 信息屏播放详情
     * @param playStrategyId 策略id
     * @return
     */
    Result detail(Integer playStrategyId);

    /**
     * 下发信息屏播放策略
     * @param strategyId 策略id
     * @return
     */
    Result sendStrategy(Integer strategyId);

    /**
     * 信息屏下载素材的接口
     * @param key
     * @param response
     */
    void downloadMaterial(String key, HttpServletResponse response);

    /**
     * 屏幕策略列表
     * @param page 分页参数
     * @param param 查询参数
     * @return
     */
    Result findList(Page page, IotScreenPlayStrategyListQueryParam param);

    /**
     * 获取xixunplay下载进度
     * @param param
     */
    void getDownloadProgress(DownloadProgressModel param);

    /**
     * 删除播放策略
     * @param strategyId 策略id
     * @return
     */
    Result del(Integer strategyId);

    /**
     * 停止播放
     * @param playStrategyId 策略id
     * @param operation 0：停止；1：播放
     * @return
     */
    Result stopPlayer(Integer playStrategyId, Integer operation);

    /**
     * 新增策略
     * @param param
     * @return
     */
    Result add(IotScreenPlayStrategyAddParam param);
}
