package com.rz.iot.think.mqtt.handler.publish;

import com.rz.iot.think.model.Result;
import com.rz.iot.think.mqtt.handler.MqttGateway;
import com.rz.iot.think.mqtt.model.ConcentratorMessageBase;
import com.rz.iot.think.mqtt.model.publish.*;
import com.rz.iot.think.mqtt.util.RzIotConcentratorConstParam;
import com.rz.iot.think.utils.FastDFSUtils;
import com.rz.iot.think.utils.PropertiesUtil;
import com.rz.iot.think.utils.RzIotErrMessage;
import com.rz.iot.utils.CRC;
import com.rz.iot.utils.MD5;
import com.rz.iot.utils.RzIotDigit;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.csource.common.MyException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Author by xuxiake, Date on 2019/4/13.
 * PS: Not easy to write code, please indicate.
 * Description：集中器消息下发入口接口实现类
 */
@Component("concentratorPublishService")
@Log4j2
public class ConcentratorPublishServiceImpl implements IConcentratorPublishService {

    @Resource
    private MqttGateway mqttGateway;

    /*用于集中器升级*/

    // 计数器map
    public static volatile Map<String, CountDownLatch> cdlMap = new ConcurrentHashMap();
    //计数器超时设置
    public static Integer CDLTIME = 8000;
    // 存放正在升级的集中器sn（防止重复操作）
    public static volatile List<String> upgradeTag = new ArrayList<>();

    /**
     * 向集中器发送消息
     * @param data 发送的数据
     * @param concentratorSn 集中器sn
     */
    public void sendMessage(String data, String concentratorSn) {

        log.debug("平台下发编码后报文：{}", data);
        mqttGateway.sendToMqtt(data, RzIotConcentratorConstParam.MQTT_PUBLISH_TOPIC + MD5.encryptionUpper(concentratorSn));
    }

    /**
     * 服务端输出控制命令下发
     * @param ctrlCmdPublishes
     * @param concentratorSn
     */
    @Override
    public void publishCtrlCmd(List<ConcentratorCtrlCmdPublish> ctrlCmdPublishes, String concentratorSn) {

        ConcentratorMessageBase concentratorMessageBase = new ConcentratorMessageBase();
        concentratorMessageBase.setOperateCode(RzIotConcentratorConstParam.PUBLISH_CTRL_CMD);
        concentratorMessageBase.setSerialNo(concentratorSn);
        concentratorMessageBase.setObject(ctrlCmdPublishes);

        log.debug("服务端输出控制命令下发");
        log.debug("平台下发原始报文：{}", concentratorMessageBase);
        String data = concentratorMessageBase.encode();
        this.sendMessage(data, concentratorSn);
    }

    /**
     * 服务端告警参数下发
     * @param warnConfigPublishes
     * @param concentratorSn
     */
    @Override
    public void warnConfigPublish(List<ConcentratorWarnConfigPublish> warnConfigPublishes, String concentratorSn) {

        ConcentratorMessageBase concentratorMessageBase = new ConcentratorMessageBase();
        concentratorMessageBase.setOperateCode(RzIotConcentratorConstParam.PUBLISH_WARN_CONFIG);
        concentratorMessageBase.setSerialNo(concentratorSn);
        concentratorMessageBase.setObject(warnConfigPublishes);

        log.debug("服务端告警参数下发");
        log.debug("平台下发原始报文：{}", concentratorMessageBase);
        String data = concentratorMessageBase.encode();
        this.sendMessage(data, concentratorSn);
    }

    /**
     * 校时命令下发
     * @param concentratorSn
     */
    @Override
    public void timingPublish(String concentratorSn) {

        ConcentratorMessageBase concentratorMessageBase = new ConcentratorMessageBase();
        concentratorMessageBase.setOperateCode(RzIotConcentratorConstParam.PUBLISH_TIMING);
        concentratorMessageBase.setSerialNo(concentratorSn);

        log.debug("校时命令下发");
        log.debug("平台下发原始报文：{}", concentratorMessageBase);
        String data = concentratorMessageBase.encode();
        this.sendMessage(data, concentratorSn);
    }

    /**
     * 服务端预约参数下发
     * @param switchStrategyPublish
     */
    @Override
    public void publishSwitchStrategy(ConcentratorSwitchStrategyPublish switchStrategyPublish, String concentratorSn) {

        ConcentratorMessageBase concentratorMessageBase = new ConcentratorMessageBase();
        concentratorMessageBase.setOperateCode(RzIotConcentratorConstParam.PUBLISH_SWITCH_STRATEGY);
        concentratorMessageBase.setSerialNo(concentratorSn);
        concentratorMessageBase.setObject(switchStrategyPublish);

        log.debug("服务端预约参数下发");
        log.debug("平台下发原始报文：{}", concentratorMessageBase);
        String data = concentratorMessageBase.encode();
        this.sendMessage(data, concentratorSn);
    }

    /***
     * 电量定时上报时间下发
     * @param concentratorElectricTimingReportTimePublish
     * @param concentratorSn
     */
    @Override
    public void publishElectricTimingReportTime(ConcentratorElectricTimingReportTimePublish concentratorElectricTimingReportTimePublish, String concentratorSn) {
        ConcentratorMessageBase concentratorMessageBase = new ConcentratorMessageBase();
        concentratorMessageBase.setOperateCode(RzIotConcentratorConstParam.PUBLISH_ENERGY_REPORT_TIME);
        concentratorMessageBase.setSerialNo(concentratorSn);
        concentratorMessageBase.setObject(concentratorElectricTimingReportTimePublish);

        log.debug("电量定时上报时间下发");
        log.debug("平台下发原始报文：{}", concentratorMessageBase);
        String data = concentratorMessageBase.encode();
        this.sendMessage(data, concentratorSn);
    }

    /***
     * 服务端控制命令下发
     * @param concentratorCmdPublish
     * @param concentratorSn
     */
    @Override
    public void publishCmd(ConcentratorCmdPublish concentratorCmdPublish, String concentratorSn) {
        ConcentratorMessageBase concentratorMessageBase = new ConcentratorMessageBase();
        concentratorMessageBase.setOperateCode(RzIotConcentratorConstParam.PUBLISH_COMMON);
        concentratorMessageBase.setSerialNo(concentratorSn);
        concentratorMessageBase.setObject(concentratorCmdPublish);

        log.debug("服务端控制命令下发");
        log.debug("平台下发原始报文：{}", concentratorMessageBase);
        String data = concentratorMessageBase.encode();
        this.sendMessage(data, concentratorSn);
    }

    /**
     * 服务端升级指令下发
     * @param remoteUpgradePublish
     * @param concentratorSn
     */
    @Override
    public Result publishRemoteUpgrade(ConcentratorRemoteUpgradePublish remoteUpgradePublish, String concentratorSn) {

        log.debug("服务端升级指令下发");
        Result result = new Result();
        if (upgradeTag.contains(concentratorSn)) {
            // 集中器正在远程升级中
            result.setCode(RzIotErrMessage.CONCENTRATOR_REMOTE_UPGRADE_IS_UPDATING);
            return result;
        }
        upgradeTag.add(concentratorSn);

        ConcentratorMessageBase concentratorMessageBase = new ConcentratorMessageBase();
        concentratorMessageBase.setOperateCode(RzIotConcentratorConstParam.PUBLISH_REMOTE_UPGRADE);
        concentratorMessageBase.setSerialNo(concentratorSn);

        String heard = concentratorMessageBase.encode();
        StringBuffer sb = null;
        CountDownLatch countDownLatch = null;
        try {
            // 握手
            log.debug("远程升级-握手");
            sb = new StringBuffer(heard);
            sb.append(RzIotDigit.intToHexString(1,2));
            sb.append(RzIotDigit.intToHexString(0,1));
            this.sendMessage(sb.toString(), concentratorSn);
            countDownLatch = new CountDownLatch(1);
            ConcentratorPublishServiceImpl.cdlMap.put(concentratorSn, countDownLatch);
            countDownLatch.await(CDLTIME, TimeUnit.MILLISECONDS);

            // 擦除
            log.debug("远程升级-擦除");
            sb = new StringBuffer(heard);
            sb.append(RzIotDigit.intToHexString(5,2));
            sb.append(RzIotDigit.intToHexString(1,1));
            sb.append(RzIotDigit.longToHexString(remoteUpgradePublish.getSize(), 4));
            this.sendMessage(sb.toString(), concentratorSn);
            countDownLatch = new CountDownLatch(1);
            ConcentratorPublishServiceImpl.cdlMap.put(concentratorSn, countDownLatch);
            countDownLatch.await(CDLTIME, TimeUnit.MILLISECONDS);

            // 传输
            log.debug("远程升级-传输");
            String fdfsNginxServer = PropertiesUtil.getProperty("FastDFS.properties", "fdfs_nginx_server");
            String filePath = remoteUpgradePublish.getUrl().split(fdfsNginxServer + "/")[1];
            InputStream is = FastDFSUtils.getInputStream(filePath);
            BufferedInputStream bis = new BufferedInputStream(is);
            ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
            byte[] temp = new byte[1024];
            int len = -1;
            Long flag = 0L;
            while((len = bis.read(temp)) != -1) {
                sb = new StringBuffer(heard);
                // 总数据长度
                sb.append(RzIotDigit.intToHexString(9 + len,2));
                // 偏移量
                sb.append(RzIotDigit.longToHexString(flag, 4));
                // 本次传输长度
                sb.append(RzIotDigit.intToHexString(len, 2));
                // CRC校验
                sb.append(RzIotDigit.intToHexString(CRC.crc16(temp, 2), 2));
                // 本次传的输数据内容
                sb.append(RzIotDigit.bytes2HexString(temp));
                this.sendMessage(sb.toString(), concentratorSn);
                countDownLatch = new CountDownLatch(1);
                ConcentratorPublishServiceImpl.cdlMap.put(concentratorSn, countDownLatch);
                countDownLatch.await(CDLTIME, TimeUnit.MILLISECONDS);

                baos.write(temp, 0, len);
                flag++;
            }
            // 升级包总数据
            byte[] upgradeData = baos.toByteArray();

            // 结束
            log.debug("远程升级-结束");
            sb = new StringBuffer(heard);
            sb.append(RzIotDigit.intToHexString(3,2));
            sb.append(RzIotDigit.intToHexString(3,1));
            sb.append(RzIotDigit.intToHexString(CRC.crc16(upgradeData, 2), 2));
            this.sendMessage(sb.toString(), concentratorSn);
            countDownLatch = new CountDownLatch(1);
            ConcentratorPublishServiceImpl.cdlMap.put(concentratorSn, countDownLatch);
            countDownLatch.await(CDLTIME, TimeUnit.MILLISECONDS);

            // 重启
            log.debug("远程升级-重启");
            sb = new StringBuffer(heard);
            sb.append(RzIotDigit.intToHexString(1,2));
            sb.append(RzIotDigit.intToHexString(4,1));
            this.sendMessage(sb.toString(), concentratorSn);
            countDownLatch = new CountDownLatch(1);
            ConcentratorPublishServiceImpl.cdlMap.put(concentratorSn, countDownLatch);
            countDownLatch.await(CDLTIME, TimeUnit.MILLISECONDS);

        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            result.setCode(RzIotErrMessage.CONCENTRATOR_REMOTE_UPGRADE_FAILED);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            result.setCode(RzIotErrMessage.CONCENTRATOR_REMOTE_UPGRADE_FAILED);
        } catch (MyException e) {
            log.error(e.getMessage(), e);
            result.setCode(RzIotErrMessage.CONCENTRATOR_REMOTE_UPGRADE_FAILED);
        }
        // 移除
        upgradeTag.remove(concentratorSn);

        return result;
    }
}
