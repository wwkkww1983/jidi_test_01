package com.rz.iot.think.controller;

import com.rz.iot.think.model.Result;
import com.rz.iot.think.service.SysUserLoginRecordService;
import com.rz.iot.think.service.UserInfoService;
import com.rz.iot.think.utils.RedisUtils;
import com.rz.iot.think.utils.RzIotDBConstParam;
import com.rz.iot.utils.ImgCodeUtil;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author by xuxiake, Date on 2019/3/5.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
@RestController
@RequestMapping("/user")
@Log4j2
public class UserInfoController {

    @Resource
    private RedisUtils redisUtils;
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private SysUserLoginRecordService sysUserLoginRecordService;

    /**
     * 系统登录
     * @param username
     * @param password
     * @param captcha
     * @return
     */
    @RequestMapping("/login")
    public Result login(String username, String password) {
        return userInfoService.login(username, password);
    }

    @RequestMapping("/getCaptcha")
    public void getCaptcha(HttpSession session, HttpServletResponse response) {

        Object[] arr = ImgCodeUtil.createImage();
        BufferedImage image = (BufferedImage) arr[0];
        String captcha = (String) arr[1];

        String key = "captcha:" + session.getId();
        // 验证码超时5分钟
        redisUtils.set(key, captcha, 300L);
        try(OutputStream os = response.getOutputStream()) {
            ImageIO.write(image,"png", os);
        } catch (IOException e) {
            log.error(e.getMessage(),e);
        }
    }

    @RequestMapping("/logout")
    public Result logout() {

        Result result = new Result();
        //日志存储登出
        sysUserLoginRecordService.insertSelective(0, RzIotDBConstParam.SYS_USER_LOGIN_RECORD_LOGIN_TYPE_OF_LOGOUT,null);
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return result;
    }

    /**
     * 用户名远程搜索
     * @param name 用户姓名
     * @return
     */
    @RequestMapping("/remote")
    public Result remote(String name) {
        return userInfoService.remote(name);
    }

    /**
     * 获取用户信息
     * @param token
     * @param session
     * @return
     */
    @RequestMapping("/info")
    @ResponseBody
    public Result info(String token, HttpSession session) {
        Result result = null;
        try {
            result = userInfoService.getUserInfo(token,session);
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查询用户菜单权限
     * @return
     */
    @RequestMapping("/permission")
    @ResponseBody
    public Result permission(){

        Result result = new Result();
        Map<String, Object> map = new HashMap<>();
        map.put("dashboard", true);
        List<String> list = new ArrayList<>();
        list.add("gismap");
        list.add("streetlightmgt");
        list.add("concentratormgt");
        list.add("vedioMonitor");
        list.add("bimmgt");
        list.add("inforelease");
        list.add("enviromenttest");
        list.add("alarmbroadcast");
        list.add("publicwifi");
        list.add("reportstatistics");
        map.put("application", list);
        result.setData(map);
        return result;
    }
}
