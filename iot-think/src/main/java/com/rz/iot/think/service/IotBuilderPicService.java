package com.rz.iot.think.service;

import com.rz.iot.think.model.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Author by xuxiake, Date on 2019/3/14.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
public interface IotBuilderPicService {

    /**
     * 施工图片的上传
     * @param files 图片文件
     * @return
     */
    Result upload(MultipartFile[] files, HttpServletRequest request);

    List<String> getBuilderPics(Integer businessId, Integer businessType);
}
