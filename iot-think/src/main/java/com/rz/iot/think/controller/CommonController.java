package com.rz.iot.think.controller;

import com.rz.iot.think.model.Result;
import com.rz.iot.think.utils.RzIotErrMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author by xuxiake, Date on 2019/3/5.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
@RestController
public class CommonController {


    /**
     * 未登录
     * @return
     */
    @RequestMapping("/noLogin")
    public Result noLogin() {
        Result result = new Result();
        result.setCode(RzIotErrMessage.SESSION_TIME_OUT);
        return result;
    }

    /**
     * 没有权限
     * @return
     */
    @RequestMapping("/unauthorized")
    public Result unauthorized() {
        Result result = new Result();
        result.setCode(RzIotErrMessage.IS_NOT_AUTHORIZED);
        return result;
    }
}
