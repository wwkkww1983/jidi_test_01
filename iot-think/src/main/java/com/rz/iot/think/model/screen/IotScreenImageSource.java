package com.rz.iot.think.model.screen;

import java.util.Date;

public class IotScreenImageSource {
    private Integer pkId;

    private String id;

    private String md5;

    private String name;

    private Integer left;

    private Integer top;

    private Integer width;

    private Integer height;

    private Long size;

    private Integer playTime;

    private Integer timeSpan;

    private String entryEffectStr;

    private String exitEffectStr;

    private Integer entryEffectTimeSpan;

    private Integer exitEffectTimeSpan;

    private String type;

    private Integer picId;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public IotScreenImageSource() {
    }

    public IotScreenImageSource(String id, String md5, String name, Integer left, Integer top, Integer width, Integer height, Long size, Integer playTime, Integer timeSpan, String entryEffectStr, String exitEffectStr, Integer entryEffectTimeSpan, Integer exitEffectTimeSpan, String type, Integer picId) {
        this.id = id;
        this.md5 = md5;
        this.name = name;
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
        this.size = size;
        this.playTime = playTime;
        this.timeSpan = timeSpan;
        this.entryEffectStr = entryEffectStr;
        this.exitEffectStr = exitEffectStr;
        this.entryEffectTimeSpan = entryEffectTimeSpan;
        this.exitEffectTimeSpan = exitEffectTimeSpan;
        this.type = type;
        this.picId = picId;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5 == null ? null : md5.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Integer getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Integer playTime) {
        this.playTime = playTime;
    }

    public Integer getTimeSpan() {
        return timeSpan;
    }

    public void setTimeSpan(Integer timeSpan) {
        this.timeSpan = timeSpan;
    }

    public String getEntryEffectStr() {
        return entryEffectStr;
    }

    public void setEntryEffectStr(String entryEffectStr) {
        this.entryEffectStr = entryEffectStr == null ? null : entryEffectStr.trim();
    }

    public String getExitEffectStr() {
        return exitEffectStr;
    }

    public void setExitEffectStr(String exitEffectStr) {
        this.exitEffectStr = exitEffectStr == null ? null : exitEffectStr.trim();
    }

    public Integer getEntryEffectTimeSpan() {
        return entryEffectTimeSpan;
    }

    public void setEntryEffectTimeSpan(Integer entryEffectTimeSpan) {
        this.entryEffectTimeSpan = entryEffectTimeSpan;
    }

    public Integer getExitEffectTimeSpan() {
        return exitEffectTimeSpan;
    }

    public void setExitEffectTimeSpan(Integer exitEffectTimeSpan) {
        this.exitEffectTimeSpan = exitEffectTimeSpan;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
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