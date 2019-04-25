package com.rz.iot.think.model.show;

/**
 * Author by xuxiake, Date on 2019/3/14.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
public class IotStreetlightInstallDevShowList {

    // 设备类型 1：摄像头；2：显示屏；3：WiFi；4：环境传感器
    private Integer devType;
    // 设备id
    private Integer devId;
    // 设备状态 状态 0：未激活； 1:正常运行；2：离线；3：故障；
    private Integer status;
    // 设备名称
    private String name;
    // 设备序列号
    private String sn;
    // 设备厂商
    private String manufacturer;
    // 设备版本
    private String version;
    // 网络类型 0：固网；1：移动4G；2：电信4G；3：联通4G；5:5G网络
    private Integer netType;
    // ip
    private String ip;
    // 端口
    private Integer port;

    public Integer getDevType() {
        return devType;
    }

    public void setDevType(Integer devType) {
        this.devType = devType;
    }

    public Integer getDevId() {
        return devId;
    }

    public void setDevId(Integer devId) {
        this.devId = devId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getNetType() {
        return netType;
    }

    public void setNetType(Integer netType) {
        this.netType = netType;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
