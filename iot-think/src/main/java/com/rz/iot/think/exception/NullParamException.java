package com.rz.iot.think.exception;

/**
 * 描述:
 * 空参数异常
 *
 * @author Zhouyz
 * @create 2019-03-22 11:44
 */

public class NullParamException extends Exception{

    /**
     * 构造一个基本异常类
     */
    public NullParamException(){
        super();
    }

    /**
     * 构造一个基本异常类
     */
    public NullParamException(String message){
        super(message);
    }
}
