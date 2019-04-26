package com.rz.iot.think.service;

import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.param.UserManagerParam;
import com.rz.iot.think.model.show.UserManagerShowList;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface UserManagerService {
    /**
     * 查找所有的用户
     * @return
     */
    Result findAll(Page<UserManagerShowList> page, UserManagerShowList userManagerShowList);

    /**
     * 用户详情
     * @param userId 用户id
     * @return
     */
    Result detail(Integer userId);

    /**
     * 增加用户
     * @param user
     * @return
     */
    Result add(UserManagerParam user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    Result update(UserManagerParam user);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    Result del(Integer userId);

    /**
     * 上传头像
     * @param file
     * @param request
     * @return
     */
    Result avatarUpload(MultipartFile file, HttpServletRequest request);
}