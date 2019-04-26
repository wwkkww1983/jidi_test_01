package com.rz.iot.think.model.show;

/**
 * Author by zhangxd, Date on 2019/10/39.
 * PS: Not easy to write code, please indicate.
 * Description：用户管理查询所有用户
 */
public class UserManagerShowList {
    //用户id
    private Integer id;
    //用户名
    private String name;
    //组织名称
    private String orgName;
    //组织id
    private Integer orgId;
    //组织用户关联表主键id
    private Integer userOrgRelId;
    //省
    private String provinceName;
    //市
    private String cityName;
    //区
    private String districtName;
    //登录账号
    private String username;
    //邮箱
    private String email;
    //手机号
    private String mobile;
    //用户类型（0管理员|1普通用户）
    private Integer type;
    //公司、单位
    private String company;
    //描述、备注
    private String describe;
    //头像地址
    private String avatar;
    //省市区
    private String areaName;
    //状态
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        this.name = name;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getUserOrgRelId() {
        return userOrgRelId;
    }

    public void setUserOrgRelId(Integer userOrgRelId) {
        this.userOrgRelId = userOrgRelId;
    }

    @Override
    public String toString() {
        return "UserManagerShowList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orgName='" + orgName + '\'' +
                ", orgId=" + orgId +
                ", userOrgRelId=" + userOrgRelId +
                ", provinceName='" + provinceName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", districtName='" + districtName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", type=" + type +
                ", company='" + company + '\'' +
                ", describe='" + describe + '\'' +
                ", avatar='" + avatar + '\'' +
                ", areaName='" + areaName + '\'' +
                ", status=" + status +
                '}';
    }
}