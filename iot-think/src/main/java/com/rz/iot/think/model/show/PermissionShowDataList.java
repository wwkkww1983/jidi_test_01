package com.rz.iot.think.model.show;

/**
 * Author by zhangxd, Date on 2019/3/25.
 * PS: Not easy to write code, please indicate.
 * Description：展示用户数据权限列表
 */
public class PermissionShowDataList {

    //业务id
    private Integer businessId;
    //业务类型（1：集中器；2：路灯；3：集中器组 4.开关策略；5：信息屏节目）
    private Integer businessType;
    //业务名称
    private String businessName;

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
}