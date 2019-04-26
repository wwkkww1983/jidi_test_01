package com.rz.iot.think.controller;

import com.rz.iot.think.model.*;
import com.rz.iot.think.model.show.IotSwitchBrightnessShowDetail;
import com.rz.iot.think.service.IotConcentratorBrightnessStrategyService;
import com.rz.iot.think.service.IotConcentratorSwitchBrightnessStrategyRelService;
import com.rz.iot.think.service.IotConcentratorSwitchStrategyService;
import com.rz.iot.think.utils.RzIotDBConstParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *  开关策略controller
 *
 *  @author rycony
 *  @created 2019/3/12
 */
@RestController
@RequestMapping("/iotConcentratorSwitchStrategy")
public class IotConcentratorSwitchStrategyController {
    @Resource
    private IotConcentratorSwitchStrategyService iotConcentratorSwitchStrategyService;
    @Resource
    private IotConcentratorBrightnessStrategyService iotConcentratorBrightnessStrategyService;
    @Resource
    private IotConcentratorSwitchBrightnessStrategyRelService iotConcentratorSwitchBrightnessStrategyRelService;

    /**
     * 插入开关策略以及调光策略
     * @param iotSwitchBrightnessShowDetail
     * @return
     */

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Result insertIotConcentratorSwitchStrategy(@RequestBody IotSwitchBrightnessShowDetail iotSwitchBrightnessShowDetail){
        Result result = new Result();
       //插入集中器开关策略
       IotConcentratorSwitchStrategy findLast = iotConcentratorSwitchStrategyService.insertIotConcentratorSwitchStrategy(iotSwitchBrightnessShowDetail.getIotConcentratorSwitchStrategy());
       //插入调光策略,在查询出最新插入的调光策略表的id集合,在新增中间表
        List<IotConcentratorBrightnessStrategy> iotConcentratorBrightnessStrategy = iotSwitchBrightnessShowDetail.getIotConcentratorBrightnessStrategyList();

        if(iotConcentratorBrightnessStrategy != null && iotConcentratorBrightnessStrategy.size() > 0){
            List<Integer> ids = iotConcentratorBrightnessStrategyService.insertIotConcentratorBrightnessStrategys(iotConcentratorBrightnessStrategy);

            //如果新添加的不为null,则添加中间表
            if(findLast != null && ids.size() != 0 && ids != null){
                iotConcentratorSwitchBrightnessStrategyRelService.insertIotConcentratorSwitchBrightnessStrategyRel(findLast.getId(),ids);
            }
        }

       result.setMessage("insert success");

       return result;
    }

    /**
     * 根据id查询开关策略
     * @param id
     * @return
     */
    @RequestMapping("/find")
    public Result findIotConcentratorSwitchStrategy(Integer id){
        Result result =  iotConcentratorSwitchStrategyService.findIotConcentratorSwitchStrategy(id);
        return result;
    }

    /**
     * 根据开关id查询出开关策略以及关联的调光策略
     * 即查看编辑页面
     * @param id
     * @return
     */
    @RequestMapping("/findIotSwitchStrategyShowDetail")
    public Result findIotSwitchStrategyShowDetail(Integer id){
        Result result = iotConcentratorSwitchStrategyService.findIotSwitchStrategyShowDetail(id);
        return result;
    }


    /**
     * 查询所有开关策略列表
     * @param iotConcentratorSwitchStrategy 查询条件
     * @param page
     * @return
     */
    @RequestMapping("/findList")
    public Result findIotConcentratorSwitchStrategyList(IotConcentratorSwitchStrategy iotConcentratorSwitchStrategy, Page<IotConcentratorSwitchStrategy> page){
        Result result = iotConcentratorSwitchStrategyService.findIotConcentratorSwitchStrategyList(iotConcentratorSwitchStrategy,page);
        return result;
    }

    /**
     *
     * @param iotSwitchBrightnessShowDetail 参数为开关策略与调光策略的包装类
     * 编辑页面
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public Result editIotConcentratorSwitchStrategy(@RequestBody IotSwitchBrightnessShowDetail iotSwitchBrightnessShowDetail){
        Result result = iotConcentratorSwitchStrategyService.editIotConcentratorSwitchStrategy(iotSwitchBrightnessShowDetail);
        return result;
    }


    /**
     * 删除开关策略
     * @param id 开关策略id
     * @return
     */
    @RequestMapping("/delete")
    public Result deleteSwitchStrategy(@RequestParam("id") List<Integer> id){
        Result result = iotConcentratorSwitchStrategyService.delete(id);
        return result;
    }

    /**
     * 查询出未绑定的集中器(组)
     * @param concentratorType 集中器的类型
     * @return
     */
    @RequestMapping("/findUnbindConcentrator")
    public Result findUnbindConcentrator(Integer concentratorType){
        Result result = iotConcentratorSwitchStrategyService.findUnbindConcentrator(concentratorType);
        return result;
    }

    /**
     * 与集中器进行绑定
     * @param iotSwitchBindConcentrator
     * @return
     */
    @RequestMapping("/bind")
    public Result bindSwitchConcentrator(IotSwitchBindConcentrator iotSwitchBindConcentrator){
        Result result = iotConcentratorSwitchStrategyService.bindSwitchConcentrator(iotSwitchBindConcentrator);
        return result;
    }

    /**
     * 与集中器取消绑定
     * @param iotSwitchBindConcentrator
     * @return
     */
    @RequestMapping("/unbind")
    public Result unbindSwitchConcentrator(IotSwitchBindConcentrator iotSwitchBindConcentrator){
        Result result = iotConcentratorSwitchStrategyService.unbindSwitchConcentrator(iotSwitchBindConcentrator);
        return result;
    }


    /**
     * 重发送开关策略
     * @param iotSwitchBindConcentrator
     * @return
     */
    @RequestMapping("/resend")
    public Result resendSwitchConcentrator(IotSwitchBindConcentrator iotSwitchBindConcentrator){
        Result result = iotConcentratorSwitchStrategyService.resendSwitchConcentrator(iotSwitchBindConcentrator);
        return result;
    }




    /**
     * 批量开关集中器(组)
     * @param iotSwitchBindConcentrator
     * @return
     */
    @RequestMapping("/openConcentrators")
    public Result openOrCloseConcentrators(IotSwitchBindConcentrator iotSwitchBindConcentrator){
        Result result = iotConcentratorSwitchStrategyService.openOrCloseConcentrators(iotSwitchBindConcentrator);
        return result;
    }

    /**
     * 批量调光集中器(组)
     * @param iotSwitchBindConcentrator
     * @return
     */
    @RequestMapping("/brightConcentrators")
    public Result brightConcentrators(IotSwitchBindConcentrator iotSwitchBindConcentrator){
        Result result = iotConcentratorSwitchStrategyService.brightConcentrators(iotSwitchBindConcentrator);
        return result;
    }
}
