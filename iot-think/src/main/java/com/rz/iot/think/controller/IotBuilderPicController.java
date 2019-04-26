package com.rz.iot.think.controller;

import com.rz.iot.think.model.Result;
import com.rz.iot.think.service.IotBuilderPicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/builderPic")
public class IotBuilderPicController {

    @Resource
    private IotBuilderPicService iotBuilderPicService;
    /**
     * 施工图片的上传
     * @param file 图片文件
     * @return
     */
    @RequestMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile[] file, HttpServletRequest request){
        return iotBuilderPicService.upload(file, request);
    }
}
