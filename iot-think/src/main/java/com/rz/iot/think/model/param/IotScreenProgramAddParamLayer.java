package com.rz.iot.think.model.param;

import lombok.Data;

/**
 * Author by xuxiake, Date on 2019/4/2.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
@Data
public class IotScreenProgramAddParamLayer {

    // 信息屏节目布局类型 布局类型 1：视频；2：图片；3：文字；4：数字时钟；5：天气
    public Integer sourceType;

    // 层级 0最上层
    public Integer zIndex;
    // source 布局
    public IotScreenProgramAddParamSource source;
}
