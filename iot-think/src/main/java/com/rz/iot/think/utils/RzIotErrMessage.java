package com.rz.iot.think.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Author by xuxiake, Date on 2019/3/5.
 * PS: Not easy to write code, please indicate.
 * Description：返回给前端的错误代码以及消息
 */
public class RzIotErrMessage {

    public static final Map<Integer,Object> errMessage;

    static {
        errMessage = new HashMap<>();
        errMessage.put(RzIotErrMessage.PARAM_IS_NULL,"参数错误");
        errMessage.put(RzIotErrMessage.IS_NOT_AUTHORIZED,"无访问权限");
        errMessage.put(RzIotErrMessage.SESSION_TIME_OUT,"登录过期，请重新登录");
        errMessage.put(RzIotErrMessage.RESOURCES_NOT_FOUND,"访问的资源不存在");
        errMessage.put(RzIotErrMessage.EXCEPTION,"后台程序异常");

        errMessage.put(RzIotErrMessage.LOGIN_CAPTCHA_ERROR,"登录失败，验证码错误");
        errMessage.put(RzIotErrMessage.LOGIN_CAPTCHA_TIME_OUT,"登录失败，验证码超时，请重新获取");
        errMessage.put(RzIotErrMessage.LOGIN_USERNAME_NOT_EXIST,"登录失败，用户名不存在");
        errMessage.put(RzIotErrMessage.LOGIN_PASSWORD_ERROR,"登录失败，密码错误");
        errMessage.put(RzIotErrMessage.LOGIN_FAILED,"登录失败");

        errMessage.put(RzIotErrMessage.TOKEN_IS_NULL,"获取用户信息，token为空");
        errMessage.put(RzIotErrMessage.TOKEN_TIME_OUT,"获取用户信息，token过期");

        errMessage.put(RzIotErrMessage.CONCENTRATOR_GROUP_ADD_ROAD_IS_DIFFERENT,"新增集中器组失败，所选集中器不在同一条路");

        errMessage.put(RzIotErrMessage.SCREEN_PROGRAM_DEL_PROGRAM_HAVING_LINKED_WITH_STRATEGY,"节目删除失败，节目已关联策略");

        errMessage.put(RzIotErrMessage.VERIFY_SCREEN_PROGRAM_RESOURCES_NOT_FOUND,"节目审核未通过，相关资源文件未找到");
        errMessage.put(RzIotErrMessage.VERIFY_SCREEN_PROGRAM_FILE_CHANGE,"节目审核未通过，文件被篡改");
        errMessage.put(RzIotErrMessage.VERIFY_SCREEN_PROGRAM_FAILED,"节目审核失败");

        errMessage.put(RzIotErrMessage.UPDATE_SCREEN_PROGRAM_HAVING_BEEN_VERIFIED,"节目更新失败，节目已经被审核");

        errMessage.put(RzIotErrMessage.CONCENTRATOR_REMOTE_UPGRADE_IS_UPDATING,"集中器正在远程升级中，请稍后再试");
        errMessage.put(RzIotErrMessage.CONCENTRATOR_REMOTE_UPGRADE_FAILED,"集中器远程升级失败");
    }

    public static String getErrMessage(Integer errorCode) {
        if (errorCode != null){
            if (errMessage.get(errorCode) != null) {
                return errMessage.get(errorCode).toString();
            }
        }
        return null;
    }

    public static final int REQUEST_SUCCESS = 20000; /*通用请求成功回应代码*/

    public static final int PARAM_IS_NULL = 30000; /*通用传入参数为空*/

    public static final int IS_NOT_AUTHORIZED = 41000; /*通用的无权限回应代码*/

    public static final int SESSION_TIME_OUT = 43000; /*session过期*/

    public static final int RESOURCES_NOT_FOUND = 44000; /*资源不存在*/

    public static final int EXCEPTION = 50000; /*程序异常*/

    /*******************************************************************************/

    public static final int LOGIN_CAPTCHA_ERROR = 20001; /*登录状态，验证码错误*/
    public static final int LOGIN_CAPTCHA_TIME_OUT = 20002; /*登录状态，验证码超时*/
    public static final int LOGIN_USERNAME_NOT_EXIST = 20003; /*登录状态，用户名不存在*/
    public static final int LOGIN_PASSWORD_ERROR = 20004; /*登录状态，密码错误*/
    public static final int LOGIN_FAILED = 20005; /*登录状态，登录失败*/

    public static final int TOKEN_IS_NULL = 21000; /*获取用户信息，token为空*/
    public static final int TOKEN_TIME_OUT = 22000; /*获取用户信息，token过期*/

    /*新增集中器组-所选集中器不在同一条路*/
    public static final int CONCENTRATOR_GROUP_ADD_ROAD_IS_DIFFERENT = 20101;

    /*删除屏幕节目-节目已关联策略*/
    public static final int SCREEN_PROGRAM_DEL_PROGRAM_HAVING_LINKED_WITH_STRATEGY = 20201;

    /*审核屏幕节目-相关资源文件未找到*/
    public static final int VERIFY_SCREEN_PROGRAM_RESOURCES_NOT_FOUND = 20301;
    /*审核屏幕节目-文件被篡改*/
    public static final int VERIFY_SCREEN_PROGRAM_FILE_CHANGE = 20302;
    /*审核屏幕节目-审核失败*/
    public static final int VERIFY_SCREEN_PROGRAM_FAILED = 20303;

    /*更新屏幕节目-节目已经被审核*/
    public static final int UPDATE_SCREEN_PROGRAM_HAVING_BEEN_VERIFIED = 20401;

    /*集中器远程升级-该集中器正在更新*/
    public static final int CONCENTRATOR_REMOTE_UPGRADE_IS_UPDATING = 20501;
    public static final int CONCENTRATOR_REMOTE_UPGRADE_FAILED = 20502;
}
