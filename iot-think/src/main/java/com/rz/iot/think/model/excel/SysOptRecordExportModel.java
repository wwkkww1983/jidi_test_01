package com.rz.iot.think.model.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.util.Date;

public class SysOptRecordExportModel extends BaseRowModel {

    @ExcelProperty(value = {"用户名", "用户名", "用户名"}, index = 0)
    private String name;

    @ExcelProperty(value = {"IP", "IP", "IP"}, index = 1)
    private String ip;

    @ExcelProperty(value = {"MAC", "MAC", "MAC"}, index = 2)
    private String mac;

    @ExcelProperty(value = {"操作模块", "操作模块", "操作模块"}, index = 3)
    private String module;

    @ExcelProperty(value = {"操作类型", "操作类型", "操作类型"}, index = 4)
    private String opt_type;

    @ExcelProperty(value = {"Web/App", "Web/App", "Web/App"}, index = 5)
    private String opt_mode;

    @ExcelProperty(value = {"变更内容", "变更内容", "变更内容"}, index = 6)
    private String content;

    @ExcelProperty(value = {"创建时间", "创建时间", "创建时间"}, index = 7)
    private Date createTime;

    @ExcelProperty(value = {"更新时间", "更新时间", "更新时间"}, index = 8)
    private Date updateTime;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getOpt_type() {
        return opt_type;
    }

    public void setOpt_type(String opt_type) {
        this.opt_type = opt_type;
    }

    public String getOpt_mode() {
        return opt_mode;
    }

    public void setOpt_mode(String opt_mode) {
        this.opt_mode = opt_mode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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