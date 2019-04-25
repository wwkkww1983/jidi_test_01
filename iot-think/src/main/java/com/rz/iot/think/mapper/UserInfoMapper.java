package com.rz.iot.think.mapper;

import com.rz.iot.think.model.UserInfo;
import com.rz.iot.think.model.show.UserInfoShowAreaInfo;
import com.rz.iot.think.model.show.UserManagerShowList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    UserInfo findByUsername(String username);

    /**
     * 查找所有用户
     * @return
     */
    List<UserManagerShowList> findAll(@Param("userManagerShowList") UserManagerShowList userManagerShowList);

    /**
     * 用户名远程搜索
     * @param name 用户姓名
     * @return
     */
    List<UserInfo> remote(String name);

    /**
     * 获取用户地域信息
     * @param userId 用户id
     * @return
     */
    UserInfoShowAreaInfo getAreaInfo(Integer userId);
}