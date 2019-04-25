package com.rz.iot.think.service.impl;

import com.rz.iot.think.mapper.UserInfoMapper;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.UserInfo;
import com.rz.iot.think.model.show.UserInfoShowAreaInfo;
import com.rz.iot.think.service.SysUserLoginRecordService;
import com.rz.iot.think.service.UserInfoService;
import com.rz.iot.think.utils.RedisUtils;
import com.rz.iot.think.utils.RzIotDBConstParam;
import com.rz.iot.think.utils.RzIotErrMessage;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author by xuxiake, Date on 2019/3/5.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
@Log4j2
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private HttpSession session;
    @Resource
    private RedisUtils redisUtils;
    @Resource
    private SysUserLoginRecordService sysUserLoginRecordService;
    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * 系统登录
     * @param username
     * @param password
     * @param captcha
     * @return
     */
    @Override
    public Result login(String username, String password) {

        String token = session.getId();
        Result result = new Result();
        Map<String,Object> data = new HashMap<>();
        data.put("token",token);
        result.setData(data);

        if (StringUtils.isAnyEmpty(username, password)){
            //登录信息为空
            result.setCode(RzIotErrMessage.PARAM_IS_NULL);
            return result;
        }
        //从redis中获取验证码
//        String key = "captcha:" + session.getId();
//        String captchaFromRedis = (String) redisUtils.get(key);
//
//        if (StringUtils.isEmpty(captchaFromRedis)) {
//            // 验证码超时
//            result.setCode(RzIotErrMessage.LOGIN_CAPTCHA_TIME_OUT);
//            return result;
//        }
//
//        if (!captchaFromRedis.equalsIgnoreCase(captcha)){
//            result.setCode(RzIotErrMessage.LOGIN_CAPTCHA_ERROR);
//            return result;
//        }

        //获取当前登录对象
        Subject currentUser = SecurityUtils.getSubject();
        //判断是否登陆
        if(!currentUser.isAuthenticated()) {
            UsernamePasswordToken usernamePasswordToken =
                    new UsernamePasswordToken(username, password);
            try {
                //进行登陆
                currentUser.login(usernamePasswordToken);

            } catch (UnknownAccountException uae) {//未知用户名
                //用户名不存在
                result.setCode(RzIotErrMessage.LOGIN_USERNAME_NOT_EXIST);
                return result;
            } catch (IncorrectCredentialsException ice) {
                //密码错误
                result.setCode(RzIotErrMessage.LOGIN_PASSWORD_ERROR);
                return result;
            } catch (AuthenticationException ae) {
                //所有认证异常的父异常
                log.error(ae.getMessage(),ae);
                log.debug("登录失败");
                result.setCode(RzIotErrMessage.LOGIN_FAILED);
                return result;
            }
        }
        log.debug("登录成功");
        //日志存储登入
        sysUserLoginRecordService.insertSelective(0, RzIotDBConstParam.SYS_USER_LOGIN_RECORD_LOGIN_TYPE_OF_LOGIN,null);

        return result;
    }

    /**
     * 用户名远程搜索
     * @param name 用户姓名
     * @return
     */
    @Override
    public Result remote(String name) {

        Result result = new Result();
        if (StringUtils.isEmpty(name)) {
            return Result.paramNull(result);
        }
        List<UserInfo> userInfos = userInfoMapper.remote(name);
        result.setData(userInfos);
        return result;
    }

    @Override
    public Result getUserInfo(String token, HttpSession session) {
        Result result = new Result();
        if (token==null || "".equals(token)){
            log.debug("/user/info token为空");
            result.setCode(RzIotErrMessage.TOKEN_IS_NULL);
            result.setData(null);
            return result;
        }
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        if (userInfo==null){

            log.debug("/user/info token超时");
            result.setCode(RzIotErrMessage.TOKEN_TIME_OUT);
            result.setData(null);
            return result;
        }
        // 获取用户地域信息
        UserInfoShowAreaInfo userAreaInfo = userInfoMapper.getAreaInfo(userInfo.getId());
        Map<String,Object> map = new HashMap<>();
        map.put("avatar",userInfo.getAvatar());
        map.put("name",userInfo.getUsername());
        String[] roles = new String[1];
        roles[0] = (userInfo.getType() == 0 ? "admin" : "normal");
        map.put("roles",roles);
        map.put("userAreaInfo",userAreaInfo);

        result.setData(map);
        return result;
    }
}
