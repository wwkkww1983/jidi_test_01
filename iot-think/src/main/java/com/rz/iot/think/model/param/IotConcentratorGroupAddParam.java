package com.rz.iot.think.model.param;

import java.util.List;

/**
 * Author by xuxiake, Date on 2019/3/23.
 * PS: Not easy to write code, please indicate.
 * Description：集中器组新增更新
 */
public class IotConcentratorGroupAddParam {

    // 集中器组id
    private Integer id;
    // 集中器组名称
    private String name;
    // 集中器id列表
    private List<Integer> concentratorIds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getConcentratorIds() {
        return concentratorIds;
    }

    public void setConcentratorIds(List<Integer> concentratorIds) {
        this.concentratorIds = concentratorIds;
    }
}
