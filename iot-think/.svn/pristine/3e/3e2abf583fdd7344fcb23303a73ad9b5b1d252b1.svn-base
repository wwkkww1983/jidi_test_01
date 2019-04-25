package com.rz.iot.think.service;

import com.rz.iot.think.exception.NullParamException;
import com.rz.iot.think.model.IotScreen;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.param.ScreenParam;
import com.rz.iot.think.model.param.ScreenUpdateParam;
import com.rz.iot.think.model.show.ScreenDetail;
import com.rz.iot.think.model.show.ScreenShowList;

import java.util.List;

/**
 * Author by xuxiake, Date on 2019/3/19.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
public interface IotScreenService {

    /**
     * 查找未与路灯绑定的信息屏
     * @return
     */
    Result findNoBinding();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    IotScreen findScreenById(Integer id);

    /**
     * 唯一cardId
     * @param cardId
     * @return
     */
    IotScreen findScreenByCardId(String cardId);



    Result setUp(String[] cardId , Integer volume,Integer brightness );

    Result ScreenOpenOrOff(String[] cardId, Integer res);

    /**
     * 获取屏幕信息列表
     * @param screenParam 屏幕查询参数
     * @return 返回查询结果
     */
    List<ScreenShowList> screenList(ScreenParam screenParam, Integer userId);

    /**
     * 获取详细的显示屏信息
     * @param screenId 显示屏id
     * @return 返回查询结果
     */
    ScreenDetail screenDetail(Integer screenId) throws NullParamException;

    /**
     * 根据screen id 更新显示屏信息
     * @param param 参数
     */
    void updateScreenInfo(ScreenUpdateParam param) throws NullParamException;

    /**
     * 控制屏幕的开关
     * @param screenSn 屏幕sn
     * @param res 开关状态
     */
    boolean switchScreen(String screenSn, Integer res);

    /**
     * 调节音量
     * @param screenSn 显示屏sn
     * @param volume 音量
     * @return 返回调节成功与否
     */
    boolean setVolume(String screenSn, Integer volume);

    /**
     * 调节亮度
     * @param screenSn 显示屏sn
     * @param brightness 亮度
     * @return 返回调节成功与否
     */
    boolean setBrightness(String screenSn, Integer brightness);

    String getShortcut(String screenSn);
}
