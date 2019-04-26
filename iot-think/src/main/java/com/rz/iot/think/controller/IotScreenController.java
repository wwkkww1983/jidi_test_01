package com.rz.iot.think.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rz.iot.think.exception.NullParamException;
import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.UserInfo;
import com.rz.iot.think.model.param.ScreenParam;
import com.rz.iot.think.model.param.ScreenUpdateParam;
import com.rz.iot.think.model.show.ScreenDetail;
import com.rz.iot.think.model.show.ScreenShowList;
import com.rz.iot.think.service.IotScreenService;
import com.rz.iot.think.utils.RzIotErrMessage;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author by xuxiake, Date on 2019/3/19.
 * PS: Not easy to write code, please indicate.
 * Description：信息屏controller
 */
@RestController
@RequestMapping("/screen")
public class IotScreenController {

    @Resource
    private IotScreenService iotScreenService;


    /**
     * 设置
     * @param cardId SN
     * @param volume 音量
     * @param brightness 亮度
     * @return
     */
    @RequestMapping("/setUp")
    public Result setUp(String[] cardId,Integer volume , Integer brightness){
//        return iotScreenService.setUp("y16-b18-20965",61,62);
        return iotScreenService.setUp(cardId,volume,brightness);
    }

    /**
     * 立即开关
     * @param res
     * @param cardId
     * @return
     */
    @RequestMapping("/openOrOff")
    public Result ScreenOpenOrOff(Integer res , String[] cardId){
        return iotScreenService.ScreenOpenOrOff(cardId,res);
    }

    /**
     * 获取或查询屏幕信息
     * @param screenParam 查询参数
     * @return 返回查询结果
     */
    @RequestMapping("/searchScreen")
    public Result getScreens(ScreenParam screenParam, Page page) throws NullParamException {

        if(page == null){
            throw new NullParamException("分页参数为空！");
        }
        Result res = new Result();
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        if(userInfo == null){
            res.setCode(5000);
            res.setMessage("登录状态失效");
            return res;
        }
        Integer userId = userInfo.getId();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        //分页查询结果
        PageInfo<ScreenShowList> pageInfo = new PageInfo<>(iotScreenService.screenList(screenParam, userId));
        res.setData(pageInfo);
        return res;
    }

    /**
     * 根据显示屏id获取详细的显示屏信息
     * @param screenId 显示屏id
     * @return 返回查询结果
     * @throws NullParamException 空参数异常
     */
    @RequestMapping("/screenDetail")
    public Result screenDetail(Integer screenId) throws NullParamException {
        Result res = new Result();
        ScreenDetail sd = iotScreenService.screenDetail(screenId);
        if(sd == null){
            res.setMessage("查询结果为空！");
        }
        res.setData(sd);
        return res;
    }

    /**
     * 更新显示屏信息
     * @param param 参数
     * @return 返回更新结果
     * @throws NullParamException 空参数异常
     */
    @RequestMapping("/updateInfos")
    public Result updateInfos(@RequestBody ScreenUpdateParam param) throws NullParamException {
        iotScreenService.updateScreenInfo(param);
        return new Result();
    }

    /**
     * 开关显示屏
     * @param screenSn 显示屏sn
     * @param res 开关状态  1:开；0：关
     * @return 返回成功或失败信息
     */
    @RequestMapping("/switchScreen")
    public Result switchScreen(String screenSn, Integer res){

        Result result = new Result();
        if(iotScreenService.switchScreen(screenSn, res)){
            result.setMessage("更新成功！");
        }
        else {
            result.setCode(RzIotErrMessage.EXCEPTION);
            result.setMessage("更新失败！");

        }
        return result;
    }

    /**
     * 设置显示屏亮度
     * @param screenSn 显示屏sn
     * @param brightness 亮度
     * @return 返回结果
     */
    @RequestMapping("/setBrightness")
    public Result setBrightness(String screenSn, Integer brightness){
        Result result = new Result();
        if(iotScreenService.setBrightness(screenSn, brightness)){
            result.setMessage("更新成功！");
        }
        else {
            result.setCode(RzIotErrMessage.EXCEPTION);
            result.setMessage("更新失败！");

        }
        return result;
    }

    /**
     * 设置显示屏音量
     * @param screenSn 显示屏sn
     * @param volume 显示屏音量
     * @return 返回结果
     */
    @RequestMapping("/setVolume")
    public Result setVolume(String screenSn, Integer volume){
        Result result = new Result();
        if(iotScreenService.setVolume(screenSn, volume)){
            result.setMessage("更新成功！");
        }
        else {
            result.setCode(RzIotErrMessage.EXCEPTION);
            result.setMessage("更新失败！");

        }
        return result;
    }

    /**
     * 获取屏幕截屏
     * @param screenSn 显示屏sn
     * @return 返回base64编码的图片
     */
    @RequestMapping("/getShortcut")
    public Result getShortcut(String screenSn){
        Result result = new Result();
        result.setData(iotScreenService.getShortcut(screenSn));
        return result;
    }
}
