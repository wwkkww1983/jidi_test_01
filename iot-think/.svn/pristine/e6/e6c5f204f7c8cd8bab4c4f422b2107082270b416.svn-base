package com.rz.iot.think.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rz.iot.think.mapper.IotAreaRelMapper;
import com.rz.iot.think.mapper.SysOrganizationMapper;
import com.rz.iot.think.mapper.SysUserOrgRelMapper;
import com.rz.iot.think.model.IotAreaRel;
import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.SysOrganization;
import com.rz.iot.think.model.show.IotRoleSettingOrganizationShowDetail;
import com.rz.iot.think.service.SysOptRecordService;
import com.rz.iot.think.service.SysOrganizationService;
import com.rz.iot.think.utils.RzIotDBConstParam;
import com.rz.iot.think.utils.RzIotErrMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysOrganizationServiceImpl implements SysOrganizationService{

    @Resource
    private SysOrganizationMapper sysOrganizationMapper;
    @Resource
    private IotAreaRelMapper iotAreaRelMapper;
    @Resource
    private SysOptRecordService sysOptRecordService;
    @Resource
    private SysUserOrgRelMapper sysUserOrgRelMapper;


    @Override
    public Result findAll(Page<IotRoleSettingOrganizationShowDetail> page,
                          IotRoleSettingOrganizationShowDetail iotRoleSettingOrganizationShowDetail) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<IotRoleSettingOrganizationShowDetail> list = sysOrganizationMapper.findAll(iotRoleSettingOrganizationShowDetail);
        PageInfo<IotRoleSettingOrganizationShowDetail> pageInfo = new PageInfo<>(list);
        page.setOtherParam(pageInfo);
        Result result = new Result();
        result.setData(page);
        return result;
    }

    @Override
    public Result detail(Integer orgId) {
        Result result = new Result();
        if (orgId==null){
            result.setCode(RzIotErrMessage.PARAM_IS_NULL);
            result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.PARAM_IS_NULL));
            return result;
        }
        IotRoleSettingOrganizationShowDetail iotRoleSettingOrganizationShowDetail = new IotRoleSettingOrganizationShowDetail();
        iotRoleSettingOrganizationShowDetail.setId(orgId);
        List<IotRoleSettingOrganizationShowDetail> list = sysOrganizationMapper.findAll(iotRoleSettingOrganizationShowDetail);
        if (list == null || list.size()==0){
            return result;
        }
        result.setData(list.get(0));
        return result;
    }

    @Override
    public Result add(IotRoleSettingOrganizationShowDetail organizationDetail) {
        SysOrganization sysOrganization = new SysOrganization();
        sysOrganization.setName(organizationDetail.getName());

        IotAreaRel iotAreaRel = new IotAreaRel();
        iotAreaRel.setProvinceId(organizationDetail.getProvinceName().getCode());
        iotAreaRel.setCityId(organizationDetail.getCityName().getCode());
        iotAreaRel.setDistrictId(organizationDetail.getDistrictName().getCode());
        iotAreaRel.setProvinceName(organizationDetail.getProvinceName().getValue());
        iotAreaRel.setCityName(organizationDetail.getCityName().getValue());
        iotAreaRel.setDistrictName(organizationDetail.getDistrictName().getValue());
        IotAreaRel iotAreaRelCheck = iotAreaRelMapper.isExists(iotAreaRel);
        if (iotAreaRelCheck==null){
            iotAreaRelMapper.insertSelective(iotAreaRel);
        }else {
            iotAreaRel = iotAreaRelCheck;
        }
        sysOrganization.setAreaRelId(iotAreaRel.getId());
        sysOrganization.setDescribe(organizationDetail.getDescribe());
        sysOrganization.setParentId(organizationDetail.getParentId());
        sysOrganization.setStatus(RzIotDBConstParam.DATA_STATUS_OF_NORMAL);

        sysOrganizationMapper.insertSelective(sysOrganization);

        //记录操作日志
        sysOptRecordService.insertSelective(0,RzIotDBConstParam.SYS_OPT_RECORD_OPT_MODULE_OF_ORG,RzIotDBConstParam.SYS_OPT_RECORD_OPT_TYPE_OF_ADD,organizationDetail);

        Result result = new Result();
        return result;

    }

    @Override
    public Result update(IotRoleSettingOrganizationShowDetail organizationDetail) {

        SysOrganization sysOrganization = new SysOrganization();
        sysOrganization.setId(organizationDetail.getId());
        sysOrganization.setName(organizationDetail.getName());
        IotAreaRel iotAreaRel = new IotAreaRel();
        iotAreaRel.setProvinceId(organizationDetail.getProvinceName().getCode());
        iotAreaRel.setCityId(organizationDetail.getCityName().getCode());
        iotAreaRel.setDistrictId(organizationDetail.getDistrictName().getCode());
        iotAreaRel.setProvinceName(organizationDetail.getProvinceName().getValue());
        iotAreaRel.setCityName(organizationDetail.getCityName().getValue());
        iotAreaRel.setDistrictName(organizationDetail.getDistrictName().getValue());
        IotAreaRel iotAreaRelCheck = iotAreaRelMapper.isExists(iotAreaRel);
        if (iotAreaRelCheck==null){
            iotAreaRelMapper.insertSelective(iotAreaRel);
        }else {
            iotAreaRel = iotAreaRelCheck;
        }
        sysOrganization.setAreaRelId(iotAreaRel.getId());
        sysOrganization.setDescribe(organizationDetail.getDescribe());
        sysOrganization.setParentId(organizationDetail.getParentId());

        sysOrganizationMapper.updateByPrimaryKeySelective(sysOrganization);

        //记录操作日志
        sysOptRecordService.insertSelective(0,RzIotDBConstParam.SYS_OPT_RECORD_OPT_MODULE_OF_ORG,RzIotDBConstParam.SYS_OPT_RECORD_OPT_TYPE_OF_ADD,organizationDetail);

        Result result = new Result();
        return result;
    }

    @Override
    public Result del(Integer orgId) {
        Result result = new Result();
        if (orgId == null){
            result.setCode(RzIotErrMessage.PARAM_IS_NULL);
            result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.PARAM_IS_NULL));
            return result;
        }

        //删除用户组织关联关系
        sysUserOrgRelMapper.delByOrgId(orgId);
        //删除组织
        SysOrganization sysOrganization = new SysOrganization();
        sysOrganization.setId(orgId);
        sysOrganization.setStatus(RzIotDBConstParam.DATA_STATUS_OF_DELETE);
        sysOrganizationMapper.updateByPrimaryKeySelective(sysOrganization);

        //记录操作日志
        Map<String,Object> map = new HashMap<>();
        map.put("orgId",orgId);
        sysOptRecordService.insertSelective(0,RzIotDBConstParam.SYS_OPT_RECORD_OPT_MODULE_OF_ORG,RzIotDBConstParam.SYS_OPT_RECORD_OPT_TYPE_OF_DELETE,map);

        return result;
    }
}