package com.rz.iot.think.model.param;

import lombok.Data;

/**
 * Author by xuxiake, Date on 2019/4/4.
 * PS: Not easy to write code, please indicate.
 * Description：节目策略列表查询参数
 */
@Data
public class IotScreenPlayStrategyListQueryParam {

    // 策略名称
    private String name;
    // 策略状态
    private Integer status;
}
