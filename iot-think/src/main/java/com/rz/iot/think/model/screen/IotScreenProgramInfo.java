package com.rz.iot.think.model.screen;

import java.util.Date;

public class IotScreenProgramInfo {
    private Integer id;

    private String name;

    private Integer height;

    private Integer width;

    private Integer totalSize;

    private Integer programLength;

    private String resolution;

    private Integer type;

    private Integer createAdmin;

    private Integer verify;

    private String describe;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public IotScreenProgramInfo() {
    }

    public IotScreenProgramInfo(Integer id, String name, Integer height, Integer width, Integer totalSize, Integer programLength, String resolution, Integer type, Integer createAdmin, String describe) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.width = width;
        this.totalSize = totalSize;
        this.programLength = programLength;
        this.resolution = resolution;
        this.type = type;
        this.createAdmin = createAdmin;
        this.describe = describe;
    }

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
        this.name = name == null ? null : name.trim();
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

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getProgramLength() {
        return programLength;
    }

    public void setProgramLength(Integer programLength) {
        this.programLength = programLength;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution == null ? null : resolution.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCreateAdmin() {
        return createAdmin;
    }

    public void setCreateAdmin(Integer createAdmin) {
        this.createAdmin = createAdmin;
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
        this.describe = describe == null ? null : describe.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}