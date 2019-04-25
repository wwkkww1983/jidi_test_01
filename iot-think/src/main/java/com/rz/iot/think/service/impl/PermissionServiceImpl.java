package com.rz.iot.think.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rz.iot.think.mapper.IotBusinessUserRelMapper;
import com.rz.iot.think.mapper.SysMenuMapper;
import com.rz.iot.think.mapper.SysUserMenuRelMapper;
import com.rz.iot.think.mapper.UserInfoMapper;
import com.rz.iot.think.model.*;
import com.rz.iot.think.model.param.PermissionDataEditParam;
import com.rz.iot.think.model.param.PermissionMenuEditParam;
import com.rz.iot.think.model.show.PermissionShowDataList;
import com.rz.iot.think.model.show.UserManagerShowList;
import com.rz.iot.think.service.PermissionService;
import com.rz.iot.think.service.SysOptRecordService;
import com.rz.iot.think.utils.RzIotDBConstParam;
import com.rz.iot.think.utils.RzIotErrMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private SysMenuMapper sysMenuMapper;
    @Resource
    private SysUserMenuRelMapper sysUserMenuRelMapper;
    @Resource
    private IotBusinessUserRelMapper iotBusinessUserRelMapper;
    @Resource
    private SysOptRecordService sysOptRecordService;


    @Override
    public Result findUserList(Page<UserManagerShowList> page, UserManagerShowList userManagerShowList) {
        userManagerShowList.setType(RzIotDBConstParam.USER_STATUS_OF_NORMAL);
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<UserManagerShowList> list = userInfoMapper.findAll(userManagerShowList);
        PageInfo<UserManagerShowList> pageInfo = new PageInfo<>(list);
        page.setOtherParam(pageInfo);
        Result result = new Result();
        result.setData(page);
        return result;
    }

    @Override
    public Result menuOwned(Page<SysMenu> page, Integer userId) {
        Result result = new Result();
        if (userId==null){
            result.setCode(RzIotErrMessage.PARAM_IS_NULL);
            result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.PARAM_IS_NULL));
            return result;
        }
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<SysMenu> list = sysMenuMapper.findAllMenuByUserId(userId);
        PageInfo<SysMenu> pageInfo = new PageInfo<>(list);
        page.setOtherParam(pageInfo);
        Map<String,Object> map = new HashMap<>();
        map.put("page",page);
        map.put("userId",userId);
        result.setData(map);
        return result;
    }

    @Override
    public Result menuNotOwned(Page<SysMenu> page, Integer userId) {
        Result result = new Result();
        if (userId==null){
            result.setCode(RzIotErrMessage.PARAM_IS_NULL);
            result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.PARAM_IS_NULL));
            return result;
        }
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<SysMenu> list = sysMenuMapper.menuNotOwned(userId);
        PageInfo<SysMenu> pageInfo = new PageInfo<>(list);
        page.setOtherParam(pageInfo);
        Map<String,Object> map = new HashMap<>();
        map.put("page",page);
        map.put("userId",userId);
        result.setData(map);
        return result;
    }

    @Override
    public Result addMenu(PermissionMenuEditParam param) {

        Result result = new Result();
        if (param == null){
            result.setCode(RzIotErrMessage.PARAM_IS_NULL);
            result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.PARAM_IS_NULL));
            return result;
        }
        sysUserMenuRelMapper.insertBatch(param);

        //记录操作日志
        sysOptRecordService.insertSelective(0,RzIotDBConstParam.SYS_OPT_RECORD_OPT_MODULE_OF_PERMISSION,RzIotDBConstParam.SYS_OPT_RECORD_OPT_TYPE_OF_ADD,param);

        return result;
    }

    @Override
    public Result delMenu(PermissionMenuEditParam param) {

        Result result = new Result();
        if (param == null){
            result.setCode(RzIotErrMessage.PARAM_IS_NULL);
            result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.PARAM_IS_NULL));
            return result;
        }
        sysUserMenuRelMapper.delBatch(param);

        //记录操作日志
        sysOptRecordService.insertSelective(0,RzIotDBConstParam.SYS_OPT_RECORD_OPT_MODULE_OF_PERMISSION,RzIotDBConstParam.SYS_OPT_RECORD_OPT_TYPE_OF_DELETE,param);

        return result;
    }

    @Override
    public Result dataOwned(Page<PermissionShowDataList> page, Integer userId, Integer businessType) {

        Result result = new Result();
        if (userId==null){
            result.setCode(RzIotErrMessage.PARAM_IS_NULL);
            result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.PARAM_IS_NULL));
            return result;
        }
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<PermissionShowDataList> list = iotBusinessUserRelMapper.dataOwned(userId);
        PageInfo<PermissionShowDataList> pageInfo = new PageInfo<>(list);
        page.setOtherParam(pageInfo);
        Map<String,Object> map = new HashMap<>();
        map.put("page",page);
        map.put("userId",userId);
        result.setData(map);
        return result;

    }

    @Override
    public Result dataNotOwned(Page<PermissionShowDataList> page, Integer userId, Integer businessType) {
        Result result = new Result();
        if (userId==null){
            result.setCode(RzIotErrMessage.PARAM_IS_NULL);
            result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.PARAM_IS_NULL));
            return result;
        }
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<PermissionShowDataList> list = iotBusinessUserRelMapper.dataNotOwned(userId);
        PageInfo<PermissionShowDataList> pageInfo = new PageInfo<>(list);
        page.setOtherParam(pageInfo);
        Map<String,Object> map = new HashMap<>();
        map.put("page",page);
        map.put("userId",userId);
        result.setData(map);
        return result;
    }

    @Override
    public Result addData(PermissionDataEditParam param) {

        Result result = new Result();
        if (param == null){
            result.setCode(RzIotErrMessage.PARAM_IS_NULL);
            result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.PARAM_IS_NULL));
            return result;
        }
        List<IotBusinessUserRel> iotBusinessUserRels = new ArrayList<>();
        for (IotBusinessUserRel e : param.getBusinesses()){
            e.setUserId(param.getUserId());
            iotBusinessUserRels.add(e);
        }
        iotBusinessUserRelMapper.insertBatch(iotBusinessUserRels);

        //记录操作日志
        sysOptRecordService.insertSelective(0,RzIotDBConstParam.SYS_OPT_RECORD_OPT_MODULE_OF_PERMISSION,RzIotDBConstParam.SYS_OPT_RECORD_OPT_TYPE_OF_ADD, param);

        return result;
    }

    @Override
    public Result delData(PermissionDataEditParam param) {

        Result result = new Result();
        if (param==null){
            result.setCode(RzIotErrMessage.PARAM_IS_NULL);
            result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.PARAM_IS_NULL));
            return result;
        }
        iotBusinessUserRelMapper.delBatch(param);

        //记录操作日志
        sysOptRecordService.insertSelective(0,RzIotDBConstParam.SYS_OPT_RECORD_OPT_MODULE_OF_PERMISSION,RzIotDBConstParam.SYS_OPT_RECORD_OPT_TYPE_OF_DELETE, param);

        return result;
    }
}