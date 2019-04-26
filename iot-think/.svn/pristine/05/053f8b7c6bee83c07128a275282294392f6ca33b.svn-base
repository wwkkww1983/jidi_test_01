package com.rz.iot.think.model;

import com.rz.iot.think.utils.RzIotDBConstParam;
import com.rz.iot.think.utils.RzIotErrMessage;

import java.io.Serializable;

public class Result implements Serializable {

    private Integer code;
    private Object data;
    private String message;

    public Result() {
        this.code = RzIotErrMessage.REQUEST_SUCCESS;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
        this.message = RzIotErrMessage.getErrMessage(code);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    /**
     * 参数为空
     * @param result
     * @return
     */
    public static Result paramNull(Result result) {

        result.setCode(RzIotErrMessage.PARAM_IS_NULL);
        result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.PARAM_IS_NULL));
        return result;
    }

    /**
     * 没有权限
     * @param result
     * @return
     */
    public static Result unAuthorized(Result result) {

        result.setCode(RzIotErrMessage.IS_NOT_AUTHORIZED);
        result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.IS_NOT_AUTHORIZED));
        return result;
    }
}
