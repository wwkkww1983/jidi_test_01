package com.rz.iot.think.model.param;

/**
 * Author by xuxiake, Date on 2019/4/1.
 * PS: Not easy to write code, please indicate.
 * Description：节目列表查询
 */
public class IotScreenProgramInfoListQueryParam {

    // 节目名称
    private String name;
    // 用户id
    private Integer userId;
    // 状态，1:正常，5：待下载、6：已下载
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
