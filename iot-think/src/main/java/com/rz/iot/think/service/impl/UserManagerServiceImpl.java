package com.rz.iot.think.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rz.iot.think.mapper.IotBusinessUserRelMapper;
import com.rz.iot.think.mapper.SysUserOrgRelMapper;
import com.rz.iot.think.mapper.UserInfoMapper;
import com.rz.iot.think.model.*;
import com.rz.iot.think.model.param.UserManagerParam;
import com.rz.iot.think.model.show.UserManagerShowList;
import com.rz.iot.think.service.SysOptRecordService;
import com.rz.iot.think.service.UserManagerService;
import com.rz.iot.think.utils.CommonFunctions;
import com.rz.iot.think.utils.RzIotDBConstParam;
import com.rz.iot.think.utils.RzIotErrMessage;
import com.rz.iot.think.utils.RzIotFileUtils;
import com.rz.iot.utils.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Author by zhangxd, Date on 2019/4/.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
@Service("userManagerService")
public class UserManagerServiceImpl implements UserManagerService{

    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private SysUserOrgRelMapper sysUserOrgRelMapper;
    @Resource
    private SysOptRecordService sysOptRecordService;
    @Resource
    private IotBusinessUserRelMapper iotBusinessUserRelMapper;


    @Override
    public Result findAll(Page<UserManagerShowList> page, UserManagerShowList userManagerShowList) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<UserManagerShowList> list = userInfoMapper.findAll(userManagerShowList);
        PageInfo<UserManagerShowList> pageInfo = new PageInfo<>(list);

        page.setOtherParam(pageInfo);
        Result result = new Result();
        result.setData(page);
        return result;
    }

    @Override
    public Result detail(Integer userId) {
        Result result = new Result();
        if (userId==null){
            result.setCode(RzIotErrMessage.PARAM_IS_NULL);
            result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.PARAM_IS_NULL));
            return result;
        }
        UserManagerShowList userManagerShowList = new UserManagerShowList();
        userManagerShowList.setId(userId);
        List<UserManagerShowList> list = userInfoMapper.findAll(userManagerShowList);
        if (list == null || list.size()==0){
            return result;
        }
        result.setData(list.get(0));
        return result;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    @Override
    public Result add(UserManagerParam user) {

        //增加用户
        UserInfo userInfo = new UserInfo();
        userInfo.setName(user.getName());
        userInfo.setType(user.getType());
        userInfo.setUsername(user.getUsername());
        //密码加密
        String password = PasswordEncoder.encode(user.getPassword(), user.getUsername());
        userInfo.setPassword(password);
        userInfo.setMobile(user.getMobile());
        userInfo.setEmail(user.getEmail());
        userInfo.setCompany(user.getCompany());
        userInfo.setDescribe(user.getDescribe());
        userInfo.setStatus(RzIotDBConstParam.DATA_STATUS_OF_NORMAL);
        //设置头像
        userInfo.setAvatar(user.getAvatar());
        userInfoMapper.insertSelective(userInfo);

        //设置组织用户关联
        SysUserOrgRel sysUserOrgRel = new SysUserOrgRel();
        sysUserOrgRel.setOrgId(user.getOrgId());
        sysUserOrgRel.setUserId(userInfo.getId());
        sysUserOrgRelMapper.insertSelective(sysUserOrgRel);

        //记录操作日志
        sysOptRecordService.insertSelective(0,RzIotDBConstParam.SYS_OPT_RECORD_OPT_MODULE_OF_USER,RzIotDBConstParam.SYS_OPT_RECORD_OPT_TYPE_OF_ADD, user);

        Result result = new Result();
        return result;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    @Override
    public Result update(UserManagerParam user) {
        //更新用户
        UserInfo userInfo = new UserInfo();
        userInfo.setId(user.getId());
        userInfo.setName(user.getName());
        userInfo.setType(user.getType());
        userInfo.setUsername(user.getUsername());
        //密码加密
        if (user.getPassword()!=null && !"".equals(user.getPassword())){
            String password = PasswordEncoder.encode(user.getPassword(), user.getUsername());
            userInfo.setPassword(password);
        }
        userInfo.setMobile(user.getMobile());
        userInfo.setEmail(user.getEmail());
        userInfo.setCompany(user.getCompany());
        userInfo.setDescribe(user.getDescribe());
        userInfo.setStatus(RzIotDBConstParam.DATA_STATUS_OF_NORMAL);
        //设置头像
        userInfo.setAvatar(user.getAvatar());
        userInfoMapper.updateByPrimaryKeySelective(userInfo);

        //更新组织用户关联关系
        SysUserOrgRel sysUserOrgRel = new SysUserOrgRel();
        sysUserOrgRel.setId(user.getUserOrgRelId());
        sysUserOrgRel.setOrgId(user.getOrgId());
        sysUserOrgRel.setUserId(userInfo.getId());
        if(user.getUserOrgRelId() == null){
            sysUserOrgRelMapper.insertSelective(sysUserOrgRel);
        }else {
            sysUserOrgRelMapper.updateByPrimaryKeySelective(sysUserOrgRel);
        }

        //记录操作日志  登录模式，操作类型（用户，组织，权限） 操作模块（增 删 改）
        sysOptRecordService.insertSelective(0,RzIotDBConstParam.SYS_OPT_RECORD_OPT_MODULE_OF_USER,RzIotDBConstParam.SYS_OPT_RECORD_OPT_TYPE_OF_UPDATE, user);

        Result result = new Result();
        return result;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    @Override
    public Result del(Integer userId) {

        Result result = new Result();
        if (userId == null){
            result.setCode(RzIotErrMessage.PARAM_IS_NULL);
            result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.PARAM_IS_NULL));
            return result;
        }

        //删除用户
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userId);
        userInfo.setStatus(RzIotDBConstParam.DATA_STATUS_OF_DELETE);
        userInfoMapper.updateByPrimaryKeySelective(userInfo);

        //删除组织用户关联关系
        sysUserOrgRelMapper.delByUserId(userId);

        //删除业务（集中器、路灯、集中器组...）与用户关联关系
        iotBusinessUserRelMapper.delByUserId(userId);

        //记录操作日志
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        sysOptRecordService.insertSelective(0,RzIotDBConstParam.SYS_OPT_RECORD_OPT_MODULE_OF_USER,RzIotDBConstParam.SYS_OPT_RECORD_OPT_TYPE_OF_DELETE, map);

        return result;
    }

    @Override
    public Result avatarUpload(MultipartFile file, HttpServletRequest request) {

        MultipartFile[] files = new MultipartFile[1];
        files[0] = file;
        List<FileShowSimple> fileShowSimples = CommonFunctions.fileUpload(files, request);
        Result result = new Result();
        if (fileShowSimples != null && fileShowSimples.size()>0){
            Map<String,Object> map = new HashMap<>();
            map.put("url",fileShowSimples.get(0).getUrl());
            result.setData(map);
        }
        return result;
    }
}