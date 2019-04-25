package com.rz.iot.think.service;

import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.show.IotRoleSettingOrganizationShowDetail;

public interface SysOrganizationService {
    /**
     * 找到所有组织
     * @return
     */
    Result findAll(Page<IotRoleSettingOrganizationShowDetail> page,
                   IotRoleSettingOrganizationShowDetail iotRoleSettingOrganizationShowDetail);

    /**
     * 组织详情
     * @param orgId 组织id
     * @return
     */
    Result detail(Integer orgId);

    /**
     * 增加组织
     * @param organizationDetail
     * @return
     */
    Result add(IotRoleSettingOrganizationShowDetail organizationDetail);

    /**
     * 更新组织
     * @param organizationDetail
     * @return
     */
    Result update(IotRoleSettingOrganizationShowDetail organizationDetail);

    /**
     * 删除组织
     * @param orgId 组织id
     * @return
     */
    Result del(Integer orgId);
}