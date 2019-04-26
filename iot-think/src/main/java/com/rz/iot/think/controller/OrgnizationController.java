package com.rz.iot.think.controller;

import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.show.IotRoleSettingOrganizationShowDetail;
import com.rz.iot.think.service.SysOrganizationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/org")
public class OrgnizationController {

    @Resource
    private SysOrganizationService sysOrganizationService;

    /**
     * 找到所有组织
     * @return
     */
    @RequestMapping("findAll")
    public Result findAll(Page<IotRoleSettingOrganizationShowDetail> page,
                          IotRoleSettingOrganizationShowDetail iotRoleSettingOrganizationShowDetail){
        return sysOrganizationService.findAll(page, iotRoleSettingOrganizationShowDetail);
    }

    /**
     * 查询组织详情
     * @param orgId 组织id
     * @return
     */
    @RequiresPermissions("systemOrg:detail")
    @RequestMapping("detail")
    public Result detail(Integer orgId){
        return sysOrganizationService.detail(orgId);
    }

    /**
     * 增加组织
     * @param organizationDetail
     * @return
     */
    @RequestMapping("/add")
    @RequiresPermissions("systemOrg:add")
    public Result add(@RequestBody IotRoleSettingOrganizationShowDetail organizationDetail){
        return sysOrganizationService.add(organizationDetail);
    }

    /**
     * 更新组织
     * @param organizationDetail
     * @return
     */
    @RequestMapping("/update")
    @RequiresPermissions("systemOrg:update")
    public Result update(@RequestBody IotRoleSettingOrganizationShowDetail organizationDetail){
        return sysOrganizationService.update(organizationDetail);
    }

    /**
     * 删除组织
     * @param id
     * @return
     */
    @RequestMapping("/del")
    @RequiresPermissions("systemOrg:del")
    public Result del(Integer id){
        return sysOrganizationService.del(id);
    }
}