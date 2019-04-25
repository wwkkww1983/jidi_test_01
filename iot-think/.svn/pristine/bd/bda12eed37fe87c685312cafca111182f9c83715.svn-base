package com.rz.iot.think.service;

import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.show.UserManagerShowList;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Author by xuxiake, Date on 2019/3/5.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
public interface UserInfoService {

    /**
     * 系统登录
     * @param username
     * @param password
     * @param captcha
     * @return
     */
    Result login(String username, String password);

    /**
     * 用户名远程搜索
     * @param name 用户姓名
     * @return
     */
    Result remote(String name);

    /**
     * 根据 token获取用户信息
     * @param token
     * @param session
     * @return
     */
    Result getUserInfo(String token, HttpSession session);
}
