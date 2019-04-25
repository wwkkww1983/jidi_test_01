package com.rz.iot.think.mqtt.model.report;

import com.rz.iot.think.mqtt.util.RzIotConcentratorConstParam;
import lombok.Data;

/**
 * Author by xuxiake, Date on 2019/4/16.
 * PS: Not easy to write code, please indicate.
 * Description：身份认证上报
 */
@Data
public class ConcentratorAuthReport {

    // 用户名（默认 0x52,0x5A,0x57,0x4C RZWL）
    private String username;
    // 密码（默认 0x07,0x5B,0xCD,0x15‬ 123456789）
    private String password;

    /**
     * 认证
     * @return
     */
    public Boolean auth() {

        if (RzIotConcentratorConstParam.CONCENTRATOR_AUTH_USERNAME.equals(this.username)
                && RzIotConcentratorConstParam.CONCENTRATOR_AUTH_PASSWORD.equals(this.password)) {
            // 认证通过
            return true;
        }
        // 认证失败
        return false;
    }
}
