package com.rz.iot.think.model.show;

import com.rz.iot.think.model.screen.IotScreenImageSource;
import lombok.Data;

/**
 * Author by xuxiake, Date on 2019/3/29.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
@Data
public class IotScreenProgramImageLayer extends IotScreenProgramLayer {

    private IotScreenImageSource source;
}
