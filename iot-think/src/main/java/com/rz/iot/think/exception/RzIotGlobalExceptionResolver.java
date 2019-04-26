package com.rz.iot.think.exception;

import com.rz.iot.think.model.Result;
import com.rz.iot.think.utils.RzIotErrMessage;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author by xuxiake, Date on 2019/3/13.
 * PS: Not easy to write code, please indicate.
 * Description: 全局异常拦截
 */
@ControllerAdvice
@Log4j2
public class RzIotGlobalExceptionResolver {

    /**
     * 拦截没有权限的异常，返回41000代码
     * @param e
     * @return
     */
    @ExceptionHandler(value = AuthorizationException.class)
    @ResponseBody
    public Result exceptionHandler(AuthorizationException e) {
        log.error(e.getMessage(),e);
        Result result = new Result();
        result.setCode(RzIotErrMessage.IS_NOT_AUTHORIZED);
        result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.IS_NOT_AUTHORIZED));
        return result;
    }

    /**
     * 空指针异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public Result nullPointerExceptionHandler(NullPointerException e){
        log.error(e.getMessage(),e);
        Result result = new Result();
        result.setCode(50000);
        result.setMessage("后台空指针异常，请查看后台日志");
        return result;
    }

    /**
     * 参数空异常
     * @param e 异常实体
     */
    @ExceptionHandler(value = NullParamException.class)
    @ResponseBody
    public Result nullParamExceptionHandler(NullParamException e){
        log.error(e.getMessage(),e);
        String msg = e.getMessage();
        Result result = new Result();
        result.setCode(50000);
        result.setMessage(msg);
        return result;
    }

    /**
     * 全局异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception e){
        log.error(e.getMessage(),e);
        Result result = new Result();
        result.setCode(RzIotErrMessage.EXCEPTION);
        result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.EXCEPTION));
        return result;
    }

}