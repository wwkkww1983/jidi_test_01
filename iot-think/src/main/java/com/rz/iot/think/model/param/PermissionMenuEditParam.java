package com.rz.iot.think.model.param;

import java.util.List;

/** Author by zhangxd, Date on 2019/3/25.
* PS: Not easy to write code, please indicate.
* Description：菜单权限编辑参数
*/
public class PermissionMenuEditParam {

    //用户id
    private Integer userId;
    //菜单id列表
    private List<Integer> menuIds;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Integer> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Integer> menuIds) {
        this.menuIds = menuIds;
    }
}