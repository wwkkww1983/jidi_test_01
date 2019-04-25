package com.rz.iot.think.model.param;

import com.rz.iot.think.model.*;

import java.util.List;

/**
 * 描述:
 * 接受新增集中器记录的参数实体类
 *
 * @author Zhouyz
 * @create 2019-03-22 15:52
 */

public class AddConcentratorParam {

    //集中器信息
    private IotConcentrator concentrator;
    //单灯控制器列表
    private List<SlcInsertParam> slcList;
    //进线
    private List<IotConcentratorLineIn> lineInList;
    //出线
    private List<IotConcentratorLineOut> lineOutList;
    //建造商信息
    private IotBuilder iotBuilder;
    //施工现场图片
    private List<IotBuilderPic> iotBuilderPicList;

    public IotConcentrator getConcentrator() {
        return concentrator;
    }

    public void setConcentrator(IotConcentrator concentrator) {
        this.concentrator = concentrator;
    }

    public List<SlcInsertParam> getSlcList() {
        return slcList;
    }

    public void setSlcList(List<SlcInsertParam> slcList) {
        this.slcList = slcList;
    }

    public List<IotConcentratorLineIn> getLineInList() {
        return lineInList;
    }

    public void setLineInList(List<IotConcentratorLineIn> lineInList) {
        this.lineInList = lineInList;
    }

    public List<IotConcentratorLineOut> getLineOutList() {
        return lineOutList;
    }

    public void setLineOutList(List<IotConcentratorLineOut> lineOutList) {
        this.lineOutList = lineOutList;
    }

    public IotBuilder getIotBuilder() {
        return iotBuilder;
    }

    public void setIotBuilder(IotBuilder iotBuilder) {
        this.iotBuilder = iotBuilder;
    }

    public List<IotBuilderPic> getIotBuilderPicList() {
        return iotBuilderPicList;
    }

    public void setIotBuilderPicList(List<IotBuilderPic> iotBuilderPicList) {
        this.iotBuilderPicList = iotBuilderPicList;
    }
}
