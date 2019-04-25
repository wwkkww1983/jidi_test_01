package com.rz.iot.think.service.impl;

import com.rz.iot.think.exception.NullParamException;
import com.rz.iot.think.mapper.IotScreenMapper;
import com.rz.iot.think.mapper.IotScreenRecordMapper;
import com.rz.iot.think.model.IotScreen;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.UserInfo;
import com.rz.iot.think.model.param.ScreenParam;
import com.rz.iot.think.model.param.ScreenUpdateParam;
import com.rz.iot.think.model.screen.IotScreenRecord;
import com.rz.iot.think.model.show.ScreenDetail;
import com.rz.iot.think.model.show.ScreenShowList;
import com.rz.iot.think.service.IotScreenService;
import com.rz.iot.think.utils.RzIotDBConstParam;
import com.rz.iot.think.utils.RzIotErrMessage;
import com.rz.iot.think.websocket.screen.ScreenSendHandler;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author by xuxiake, Date on 2019/3/19.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
@Service("iotScreenService")
public class IotScreenServiceImpl implements IotScreenService {

    @Resource
    private IotScreenMapper iotScreenMapper;

    @Resource
    private IotScreenRecordMapper iotScreenRecordMapper;

    @Autowired
    private ScreenSendHandler screenSendHandler;

    @Resource
    private IotBusinessUserRelServiceImpl iotBusinessUserRelService;

    @Override
    public Result findNoBinding() {
        return null;
    }

    @Override
    public IotScreen findScreenById(Integer id) {
        return iotScreenMapper.selectByPrimaryKey(id);
    }

    @Override
    public IotScreen findScreenByCardId(String cardId) {
        return null;
    }

    /**
     * 信息屏批量设置
     * @param cardIds
     * @param volume
     * @param brightness
     * @return
     */
    @Override
    public Result setUp(String[] cardIds, Integer volume, Integer brightness) {

       for(String cardId : cardIds){
           Boolean v = screenSendHandler.setVolume(cardId, volume);
           if(v){
               Boolean b = screenSendHandler.setBrightness(cardId, brightness);
               if(b){

                   IotScreenRecord iotScreenRecord = new IotScreenRecord();
                   iotScreenRecord.setVolume(volume);
                   iotScreenRecord.setBrightness(brightness);
                   Map map = new HashMap();
                   map.put("cardId",cardId);
                   map.put("record",iotScreenRecord);

                   iotScreenRecordMapper.updateByCardId(map);
               }
           }
       }

        return null;
    }

    /**
     * 信息屏批量开关
     * @param cardIds 操作数组
     * @param res 1:开；0：关
     * @return
     */
    @Override
    public Result ScreenOpenOrOff(String[] cardIds, Integer res) {

        Result result = new Result();
        result.setCode(RzIotErrMessage.EXCEPTION);

        for(String cardId : cardIds ){
            Boolean isopen = screenSendHandler.setScreenOpenOrOff(cardId, res == 1);
            if(isopen){
                IotScreenRecord iotScreenRecord = new IotScreenRecord();
                iotScreenRecord.setScreenStatus(res);
                Map map = new HashMap();
                map.put("cardId",cardId);
                map.put("record",iotScreenRecord);
                iotScreenRecordMapper.updateByCardId(map);
                result.setCode(RzIotErrMessage.REQUEST_SUCCESS);
            }
        }

        return result;
    }

    /**
     * 获取屏幕信息列表
     * @param screenParam 屏幕查询参数
     * @return 返回查询结果
     */
    @Override
    public List<ScreenShowList> screenList(ScreenParam screenParam, Integer userId) {
        return iotScreenMapper.getScreenList(screenParam, userId);
    }

    /**
     * 获取详细的显示屏信息
     * @param screenId 显示屏id
     * @return 返回查询结果
     */
    @Override
    public ScreenDetail screenDetail(Integer screenId) throws NullParamException {
        if(screenId == null){
            throw new NullParamException("输入的屏幕id为空");
        }
        //获取用户信息
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        return iotScreenMapper.getDetail(screenId, userInfo.getId());
    }

    /**
     * 根据screen id 更新显示屏信息
     * @param param 参数
     */
    @Transactional
    @Override
    public void updateScreenInfo(ScreenUpdateParam param) throws NullParamException {
        if(param.getScreen() == null){

            throw new NullParamException("显示屏信息不能为空！");
        }
        if(param.getScreen().getId() == null){
            throw new NullParamException("显示屏id不能为空！");
        }
        //获取路灯id
        Integer streetlightId = iotScreenMapper.getStreetlightId(param.getScreen().getId());

        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        boolean authorized = iotBusinessUserRelService.isAuthorized(streetlightId, RzIotDBConstParam.BUSSINESS_TYPE_OF_STREETLIGHT, userInfo.getId());
        if(!authorized){
            throw new AuthorizationException("权限不足！");
        }
        //更新显示屏信息
        if(param.getScreen().getManufacturer() != null || param.getScreen().getName() != null || param.getScreen().getVersion() != null){
            iotScreenMapper.updateScreen(param.getScreen());
        }
        //更新亮度和音量
        if(param.getBrightness() !=null || param.getVolume() != null){
            HashMap<String, Integer> map;
            map = new HashMap<>();
            map.put("brightness", param.getBrightness());
            map.put("volume", param.getVolume());
            map.put("id", param.getScreen().getId());
            //设置显示屏音量
            if(param.getVolume() != null){
                screenSendHandler.setVolume(param.getScreen().getSn(), param.getVolume());
            }
            //设置显示屏亮度
            if(param.getBrightness() != null){
                screenSendHandler.setBrightness(param.getScreen().getSn(), param.getBrightness());
            }
            iotScreenMapper.updateScreenRecord(map);
        }

    }

    /**
     * 控制屏幕的开关
     * @param screenSn 屏幕sn
     * @param res 开关状态  1:开；0：关
     * @return 成功true，失败false
     */
    @Override
    public boolean switchScreen(String screenSn, Integer res) {
        //向屏幕传递开关信号
        Boolean isOpen = screenSendHandler.setScreenOpenOrOff(screenSn, res == 1);
        //若成功，更新数据库信息
        if(isOpen){
            IotScreenRecord screenRecord = new IotScreenRecord();
            screenRecord.setScreenStatus(res);
            HashMap<String, Object> map = new HashMap<>();
            map.put("cardId",screenSn);
            map.put("record",screenRecord);
            iotScreenRecordMapper.updateByCardId(map);
        }
        return isOpen;
    }

    /**
     * 调节音量
     * @param screenSn 显示屏sn
     * @param volume 音量
     * @return 返回调节成功与否
     */
    @Override
    public boolean setVolume(String screenSn, Integer volume) {
        //设置显示屏音量
        Boolean success = screenSendHandler.setVolume(screenSn, volume);
        //若成功，更新数据库
        if(success){
            IotScreenRecord screenRecord = new IotScreenRecord();
            screenRecord.setVolume(volume);
            HashMap<String, Object> map = new HashMap<>();
            map.put("cardId",screenSn);
            map.put("record",screenRecord);
            iotScreenRecordMapper.updateByCardId(map);
        }
        return success;
    }

    /**
     * 调节亮度
     * @param screenSn 显示屏sn
     * @param brightness 亮度
     * @return 返回调节成功与否
     */
    @Override
    public boolean setBrightness(String screenSn, Integer brightness) {
        //设置显示屏亮度
        Boolean success = screenSendHandler.setBrightness(screenSn, brightness);
        //若成功，更新数据库
        if(success){
            IotScreenRecord screenRecord = new IotScreenRecord();
            screenRecord.setBrightness(brightness);
            HashMap<String, Object> map = new HashMap<>();
            map.put("cardId",screenSn);
            map.put("record",screenRecord);
            iotScreenRecordMapper.updateByCardId(map);
        }
        return success;
    }

    @Override
    public String getShortcut(String screenSn) {
        return screenSendHandler.screenshot(screenSn);
    }

}
