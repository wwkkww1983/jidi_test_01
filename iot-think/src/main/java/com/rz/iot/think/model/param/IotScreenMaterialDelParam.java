package com.rz.iot.think.model.param;

import java.util.List;

/**
 * @Author:jidi
 * @Date:2019/04/02 15:08
 * @Description:删除播放素材
 **/
public class IotScreenMaterialDelParam {

    //素材类型：1.图片 2.视频
    private Integer type;

    //素材ID集合
    private List<Integer> iotScreenMaterialIds;

    public List<Integer> getIotScreenMaterialIds() {
        return iotScreenMaterialIds;
    }

    public void setIotScreenMaterialIds(List<Integer> iotScreenMaterialIds) {
        this.iotScreenMaterialIds = iotScreenMaterialIds;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
