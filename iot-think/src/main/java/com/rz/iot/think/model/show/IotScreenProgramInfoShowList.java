package com.rz.iot.think.model.show;

import java.util.Date;

/**
 * Author by xuxiake, Date on 2019/4/1.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
public class IotScreenProgramInfoShowList {

    // 节目id
    private Integer id;
    // 节目名称
    private String name;
    // 高
    private Integer height;
    // 宽
    private Integer width;
    // 分辨率
    private String resolution;
    // 创建用户
    private String createUser;
    //审核状态 1：未审核；2：审核完成；3：审核不通过；4：文件被篡改；5：未找到文件；
    private Integer verify;
    // 描述
    private String describe;
    // 状态，1:正常，5：待下载、6：已下载、9:已删除
    private Integer status;
    // 更新时间
    private Date updateTime;

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

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Integer getVerify() {
        return verify;
    }

    public void setVerify(Integer verify) {
        this.verify = verify;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
