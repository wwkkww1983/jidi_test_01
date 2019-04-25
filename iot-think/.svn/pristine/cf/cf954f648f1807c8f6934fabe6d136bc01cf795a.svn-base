package com.rz.iot.think.model.show;

/**
 * Created by rycony on 2019/3/28 0028.
 *
 * 显示所有与开关策略绑定集中器
 */
public class IotBindConStraShow {
    // 集中器id
    private Integer id;
    // 集中器名称
    private String name;
    // 集中器序列号
    private String sn;
    // 集中器状态 0：未激活； 1:正常运行；2：离线；3：故障； 9:已被删除;
    private Integer status;
    //区
    private String districtName;
    //路
    private String roadName;
    // 集中器ip
    private String ip;
    // 集中器端口
    private Integer port;
    public String getIpPort() {
        if(this.ip != null && this.port != null){
            this.ipPort = this.ip + ":" + this.port;
        }
        return this.ipPort;
    }

    public void setIpPort(String ipPort) {
        this.ipPort = ipPort;
    }

    //集中器ip+端口 ip:port
    private String ipPort;
    //开关策略id
    private Integer strategyId;
    //开关策略名称
    private String strategyName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }


    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Integer strategyId) {
        this.strategyId = strategyId;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }
}
