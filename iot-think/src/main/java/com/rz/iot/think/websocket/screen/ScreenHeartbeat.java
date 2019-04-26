package com.rz.iot.think.websocket.screen;

import com.rz.iot.think.mapper.IotScreenMapper;
import com.rz.iot.think.mapper.IotScreenRecordMapper;
import com.rz.iot.think.model.IotScreen;
import com.rz.iot.think.model.SysDeviceConnRecord;
import com.rz.iot.think.model.screen.IotScreenRecord;
import com.rz.iot.think.service.SysDeviceConnRecordService;
import com.rz.iot.think.utils.RzIotDBConstParam;
import com.rz.iot.think.websocket.screen.model.FpgaInfomation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by yyjuan on 2019/03/19.
 * 信息屏心跳
 * 状态更新
 * */
@Component("screenHeartbeat")
@Slf4j
public class ScreenHeartbeat {

    @Resource
    private IotScreenMapper iotScreenMapper;

    @Resource
    private IotScreenRecordMapper iotScreenRecordMapper;

    @Autowired
    private ScreenSendHandler screenSendHandler;

    @Autowired
    private SysDeviceConnRecordService sysDeviceConnRecordService;

    /**
     * 异步更新
     * 获取状态信息只能一条一条发（接口缺陷）
     * @param key
     */
    @Async("screenTaskPool")
    public void heartbeatSend(String key){

        //硬件状态
        FpgaInfomation fpgaInfomation = screenSendHandler.getFpgaInfomation(key);

        //屏幕是否打开
        Boolean screenOpen = screenSendHandler.isScreenOpen(key);

        if(fpgaInfomation == null && screenOpen == null){
//            log.error("信息屏离线，cardId：{}",key);
//            ScreenWebSocketServer.connMap.remove(key);
            IotScreen iotScreen = new IotScreen();
            iotScreen.setSn(key);
            iotScreen.setStatus(RzIotDBConstParam.DEVICE_STATUS_OF_OFFLINE);
            iotScreenMapper.updateScreenBySn(iotScreen);

            //日志
            IotScreen screen = iotScreenMapper.findScreenByCardId(key);
            SysDeviceConnRecord sysDeviceConnRecord = new SysDeviceConnRecord(screen.getId(),
                    RzIotDBConstParam.DEVICE_CONN_RECORD_DEVICE_TYPE_OF_SCREEN,
                    RzIotDBConstParam.DEVICE_CONN_RECORD_CONN_TYPE_OF_DISCONNECT,
                    "心跳中断");
            sysDeviceConnRecordService.insertConn(sysDeviceConnRecord);

            //TODO 重启
            screenSendHandler.reboot(key);
            return;
        }

        //屏幕亮度
        Integer brightness = screenSendHandler.getBrightness(key);

        //获取音量
        Integer volume = screenSendHandler.getVolume(key);

        //获取屏宽
        Integer screenWidth = screenSendHandler.getScreenWidth(key);

        //获取屏高
        Integer screenHeight = screenSendHandler.getScreenHeight(key);

        //获取网络类型
        String networkType = screenSendHandler.getNetworkType(key);

        //获取apk信息
        String packageVersion = screenSendHandler.getPackageVersion(key);


        IotScreen screenByCardId = iotScreenMapper.findScreenByCardId(key);
        IotScreenRecord iotScreenRecord = iotScreenRecordMapper.selectByScreenId(screenByCardId.getId());

        //更新状态表
        iotScreenRecord.setScreenStatus(screenOpen == true ? RzIotDBConstParam.DEVICE_SWITCH_STATUS_OF_ON : RzIotDBConstParam.DEVICE_SWITCH_STATUS_OF_OFF);
        iotScreenRecord.setBrightness(brightness);
        iotScreenRecord.setVolume(volume);
        iotScreenRecord.setNetworkStatus(RzIotDBConstParam.DEVICE_NETWORK_STATUS_OF_ONLINE);

        //解析硬件属性
        //温度：55.0℃
        String temperature = fpgaInfomation.getTemperature();
        //箱门:open
        String doorOpened = fpgaInfomation.getDoorOpened();
        //湿度：20%
        String humidity = fpgaInfomation.getHumidity();
        //电压
        String cardVoltage = fpgaInfomation.getCardVoltage();

        iotScreenRecord.setTemperature(Float.valueOf(temperature.substring(0, temperature.indexOf("℃"))));
        iotScreenRecord.setHumidity(Float.valueOf(humidity.substring(0,humidity.indexOf("%"))));
        iotScreenRecord.setDooropened(doorOpened == "Open" ? RzIotDBConstParam.SCREEN_DOOR_OPEND_STATUS_OF_OPEN : RzIotDBConstParam.SCREEN_DOOR_OPEND_STATUS_OF_CLOSE);

        //更新状态
        iotScreenRecordMapper.updateByPrimaryKeySelective(iotScreenRecord);
    }
}
