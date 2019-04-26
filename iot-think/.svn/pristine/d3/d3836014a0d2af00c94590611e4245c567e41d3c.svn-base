package com.rz.iot.think.model.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * 描述:
 * 单灯控制器excel导入信息类
 *
 * @author Zhouyz
 * @create 2019-03-25 15:02
 */

public class SlcExportModel extends BaseRowModel {
    @ExcelProperty(value  = {"单灯控制器SN", "单灯控制器SN", "单灯控制器SN"}, index = 0)
    private String sn;
    @ExcelProperty(value = {"单灯控制器名称", "单灯控制器名称", "单灯控制器名称"}, index = 1)
    private String name;
    @ExcelProperty(value = {"路灯杆编号（id）", "路灯杆编号（SN）","路灯杆编号（id）" }, index=2)
    private Integer streetlightId;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStreetlightId() {
        return streetlightId;
    }

    public void setStreetlightId(Integer streetlightId) {
        this.streetlightId = streetlightId;
    }
    @Override
    public String toString(){
        return "SlcExportModel{" + "sn='" + sn + "'" +
                ", name='" + name +"'" +
                ", streetlightId='" + streetlightId +"'" +
                "}";
    }
}
