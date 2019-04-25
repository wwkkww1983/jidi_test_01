package com.rz.iot.think.websocket.screen.model;

/**
 * Author by xuxiake, Date on 2019/3/27.
 * PS: Not easy to write code, please indicate.
 * Description：接收屏幕消息最外层封装
 */
public class ReceiveBase {

    // 唯一的消息ID
    private String _id;
    // 消息类型
    private String _type;
    // 消息内容
    private Object result;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
