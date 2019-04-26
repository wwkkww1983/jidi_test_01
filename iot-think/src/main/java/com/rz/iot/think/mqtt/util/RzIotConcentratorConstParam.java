package com.rz.iot.think.mqtt.util;

/**
 * Author by xuxiake, Date on 2019/4/11.
 * PS: Not easy to write code, please indicate.
 * Description: 
 */
public class RzIotConcentratorConstParam {

    public static final int TYPE_SINGLE_PHASE = 1; // 一相
    public static final int TYPE_THREE_PHASE = 3;  // 三相

    public static final int TYPE_A_PHASE  = 1; // A 相
    public static final int TYPE_B_PHASE  = 2; // B 相
    public static final int TYPE_C_PHASE  = 3; // C 相
    public static final int TYPE_UNION_PHASE  = 4; // 合 相

    public static final int DATA_HEAD_LENGTH = 26; // 消息头长度

    // 错误状态
    public static final int FAULT_STATUS_PRODUCE  = 1; // 故障产生
    public static final int FAULT_STATUS_RECOVERY = 0; // 故障恢复

    // 错误级别
    public static final int FAULT_LEVEL_OK   = 1; // 正常
    public static final int FAULT_LEVEL_WARN    = 2; // 告警
    public static final int FAULT_LEVEL_PROTECT = 3; // 保护
    public static final int FAULT_LEVEL_Off = 4; // 离线

    // 电箱状态 0:故障；1:正常运行；2：未激活；3：离线；9:已被删除;
    public static final int EB_STATUS_FAULT        = 0;//0:故障；
    public static final int EB_STATUS_0K           = 1;//1:正常运行；
    public static final int EB_STATUS_OFFLINE      = 2;//2：离线；
    public static final int EB_STATUS_INACTIVATED = 8;//8：未激活；
    public static final int EB_STATUS_DELETE       = 9;//9:已被删除;

    // 时间方案周期模式：
    public static final int CYCLE_TYPE_DATE  = 1;  // 日期
    public static final int CYCLE_TYPE_WEEK  = 2;  // 星期
    public static final int CYCLE_TYPE_LONGITUDE_AND_LATITUDE = 3; //经纬度

    //指令下发上报状态 iot_electric_box_subscribe_report 0: 等待客户端应答；1：客户端成功应答; 2：未知客户端应答; 3：执行失败
    public static final int REPORT_STATUS_WAIT = 0;  //等待客户端应答
    public static final int REPORT_STATUS_OK = 1;  //客户端成功应答
    public static final int REPORT_STATUS_UNKNOWN = 2;  //未知客户端应答
    public static final int REPORT_STATUS_FAIL = 3;  //执行失败

    // 集中器发布指令
    public static final int PUBLISH_COMMON               = 0x80;  // 服务端控制命令下发
    public static final int PUBLISH_CTRL_CMD             = 0x82;  // 服务端输出控制命令下发
    public static final int PUBLISH_WARN_CONFIG          = 0x84;  // 服务端告警参数下发
    public static final int PUBLISH_SWITCH_STRATEGY      = 0x83;  // 服务端预约参数下发
    public static final int PUBLISH_TIMING               = 0x86;  // 校时命令下发
    public static final int PUBLISH_ENERGY_REPORT_TIME   = 0x85;  // 电量定时上报时间下发
    public static final int PUBLISH_REMOTE_UPGRADE       = 0x8F;  // 服务端升级指令下发

    public static final int PUBLISH_TIME_OUT  = 120; // 发布状态上报超时时长，单位：秒
    public static final int PUBLISH_SWITCH_STRATEGY_T  = 131; // 服务端预约参数下发 十进制数据

    // 集中器上报
    public static final int REPORT_OF_FAULT = 0x01;  // 告警信息上报
    public static final int REPORT_OF_SWITCH_STATUS = 0x02;  // 开关状态上报
    public static final int REPORT_OF_ELECTRIC_PARAM = 0x03;  // 电气参数上报
    public static final int REPORT_OF_FAULT_PARAM = 0x04;  // 告警参数上报
    public static final int REPORT_OF_CONFIG_PARAM = 0x05;  // 配置参数上报
    public static final int REPORT_OF_CURRENT_TIME = 0x06;  // 当前时间上报
    public static final int REPORT_OF_SWITCH_STRATEGY = 0x07;  // 开关策略（预约方案）上报
    public static final int REPORT_OF_ENERGY = 0x09;  // 电量上报
    public static final int REPORT_OF_ENVIRONMENT_PARAM = 0x0A;  // 环境参数上报
    public static final int REPORT_OF_HEARTBEAT_AND_SIGNAL_STRENGTH = 0x0B;  // 心跳&信号强度上报
    public static final int REPORT_OF_AUTH = 0x0E;  // 身份认证上报
    public static final int REPORT_OF_REMOTE_UPGRADE = 0x0F;  // 远程升级上报

    // 电量类型 1：集中器；2：单灯控制器
    public static final int ELECTRIC_QUANTITY_OF_CONCENTRATOR = 1;  // 1：集中器
    public static final int ELECTRIC_QUANTITY_OF_SINGLE_LIGHT_CONTROLLER = 2;  // 2：单灯控制器

    // 故障类型
    // 1: 电流上限告警；2：电流上限保护 "电流过载"
    // 3：电压上限告警；4：电压上限保护 "电压超限"
    // 5：电压下限告警；6：电压下限保护 "漏电"
    // 7：温度上限告警；8：温度上限保护 "温度过高"
    // 9:进线剩余电流告警上限；10：进线剩余电流保护上限
    public static final String[] FAULT_TYPE_DESC = {
            "电流过载",  "电压超限",
            "漏电", "温度过高","离线"};

    // 1: 电流上限告警；
    public final static int FAULT_TYPE_ELECTRIC_CURRENT_WARN_MAX  = 1;
    // 2：电流上限保护
    public final static int FAULT_TYPE_ELECTRIC_CURRENT_PROTECT_MAX = 2;
    // 3：电压上限告警；
    public final static int FAULT_TYPE_VOLTAGE_WARN_MAX = 3;
    // 4：电压上限保护
    public final static int FAULT_TYPE_VOLTAGE_PROTECT_MAX = 4;
    // 5：电压下限告警；
    public final static int FAULT_TYPE_VOLTAGE_WARN_MIN = 5;
    // 6：电压下限保护
    public final static int FAULT_TYPE_VOLTAGE_PROTECT_MIN = 6;
    // 7：温度上限告警；
    public final static int FAULT_TYPE_TEMP_WARN_MAX = 7;
    // 8：温度上限保护
    public final static int FAULT_TYPE_TEMP_PROTECT_MAX = 8;

    // 云平台订阅（集中器发布）主题：rz_iot_think
    public final static String MQTT_PUBLISH_TOPIC = "rz_iot_think_";
    // 云平台发布（集中器订阅）主题前缀
    public final static String MQTT_REPORT_TOPIC = "rz_iot_think";

    // 集中器登录认证用户名
    public final static String CONCENTRATOR_AUTH_USERNAME = "RZWL";
    // 集中器登录认证密码
    public final static String CONCENTRATOR_AUTH_PASSWORD = "123456789";

    //灯具状态 0：灭；1：开
    public final static int LIGHT_STATUS_OFF = 0;
    public final static int LIGHT_STATUS_ON = 1;

    //隔杆模式
    //0x00：全亮；
    //0x01：隔一亮一；
    //0x02：隔二亮一；
    //0x03：隔一亮二；
    //0x04：隔二亮二；
    public final static int POLE_MODEL_ALL = 0x00;
    public final static int POLE_MODEL_ONE_ONE = 0x01;
    public final static int POLE_MODEL_TWO_ONE = 0x02;
    public final static int POLE_MODEL_ONE_TWO = 0x03;
    public final static int POLE_MODEL_TWO_TWO = 0x04;


    //集中器环境参数上报 风向
    public final static int REPORT_OF_ENVIRONMENT_WIND_DIRECTION_NORTH = 0x0001;//正北
    public final static int REPORT_OF_ENVIRONMENT_WIND_DIRECTION_NORTHEAST_NORTH = 0x0002;//东北偏北
    public final static int REPORT_OF_ENVIRONMENT_WIND_DIRECTION_NORTHEAST = 0x0004;//正东北
    public final static int REPORT_OF_ENVIRONMENT_WIND_DIRECTION_NORTHEAST_EAST = 0x0008;//东北偏东
    public final static int REPORT_OF_ENVIRONMENT_WIND_DIRECTION_EAST = 0x0010;//正东
    public final static int REPORT_OF_ENVIRONMENT_WIND_DIRECTION_SOUTHEAST_EAST = 0x0020;//东南偏东
    public final static int REPORT_OF_ENVIRONMENT_WIND_DIRECTION_SOUTHEAST = 0x0040;//正东南
    public final static int REPORT_OF_ENVIRONMENT_WIND_DIRECTION_SOUTHEAST_SOUTH = 0x0080;//东南偏南
    public final static int REPORT_OF_ENVIRONMENT_WIND_DIRECTION_SOUTH = 0x0100;//正南
    public final static int REPORT_OF_ENVIRONMENT_WIND_DIRECTION_SOUTHWEST_SOUTH = 0x0200;//西南偏南
    public final static int REPORT_OF_ENVIRONMENT_WIND_DIRECTION_SOUTHWEST = 0x0400;//正西南
    public final static int REPORT_OF_ENVIRONMENT_WIND_DIRECTION_SOUTHWEST_WEST = 0x0800;//西南偏西
    public final static int REPORT_OF_ENVIRONMENT_WIND_DIRECTION_WEST = 0x1000;//正西
    public final static int REPORT_OF_ENVIRONMENT_WIND_DIRECTION_NORTHWEST_WEST = 0x2000;//西北偏西
    public final static int REPORT_OF_ENVIRONMENT_WIND_DIRECTION_NORTHWEST = 0x4000;//正西北
    public final static int REPORT_OF_ENVIRONMENT_WIND_DIRECTION_NORTHWEST_NORTH = 0x8000;//西北偏北
    //集中器环境参数上报 雨雪
    public final static int REPORT_OF_ENVIRONMENT_SLEET_YES = 0x0000;//有雨雪
    public final static int REPORT_OF_ENVIRONMENT_SLEET_NO = 0xAAAA;//无雨雪


    /**
     * 集中器输出状态上传 信息源类型
     * 0x02 回路
     * 0x03 输出
     * 0x04 输入信号
     * 0x01 单灯控制器
     */
    public final static int CONCENTRATOR_SWITCH_STATUS_REPORT_SOURCE_OF_LOOP = 0x02; // 回路
    public final static int CONCENTRATOR_SWITCH_STATUS_REPORT_SOURCE_OF_LINE_OUT = 0x03; // 输出
    public final static int CONCENTRATOR_SWITCH_STATUS_REPORT_SOURCE_OF_LINE_IN = 0x04; // 输入信号
    public final static int CONCENTRATOR_SWITCH_STATUS_REPORT_SOURCE_OF_SLC = 0x01; // 单灯控制器

    /**
     * 集中器输出状态上传 信息源类型
     * 0x01 进线
     * 0x02 输出
     * 0x03 单灯控制器
     */
    public final static int CONCENTRATOR_FAULT_REPORT_SOURCE_OF_LINE_IN = 0x01; // 进线
    public final static int CONCENTRATOR_FAULT_REPORT_SOURCE_OF_LINE_OUT = 0x02; // 输出
    public final static int CONCENTRATOR_FAULT_REPORT_SOURCE_OF_SLC = 0x03; // 单灯控制器

    /**
     * mqtt 常量定义
     */
//    public static class MQTT {
//        public final static String HOST = "tcp://"+
//                ConfigureUtils.getStringValue("serverUrl")+":" +
//                ConfigureUtils.getStringValue("emqttdPort");
//
//        public final static boolean CLEAN_START = true;
//        public final static short KEEP_ALIVE = 30;// 低耗网络，但是又需要及时获取数据，心跳30s
//
//        public final static long RECONNECTION_ATTEMPT_MAX = 60000; // 6
//        public final static long RECONNECTION_DELAY = 60; // 2000
//
//        public final static int SEND_BUFFER_SIZE = 64; // 发送最大缓冲为2M
//
//        public final static String ELECTRIC_MQTT_PATH = "$HOME/electric_mqtt/";
//
//        // 接收配置参数
//        public final static String SUBSCRIBE_ID = "glc_switchbox_receiver";
//        public final static Topic[] SUBSCRIBE_TOPICS = {
//                // 2： 只有一次
//                new Topic("glc_iot_dev", QoS.EXACTLY_ONCE)
//        };
//
//
//        // 发送配置参数
//        public final static String PUBLISH_ID = "glc_switchbox_sender";
//        public final static Topic[] PUBLISH_TOPICS = {
//                // 2： 只有一次
//                new Topic("glc_iot_cloud_", QoS.EXACTLY_ONCE)
//        };
//    }

}