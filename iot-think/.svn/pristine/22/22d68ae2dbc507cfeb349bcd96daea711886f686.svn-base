package com.rz.iot.think.service.impl;

import com.rz.iot.think.mapper.IotBuilderPicMapper;
import com.rz.iot.think.model.FileShowSimple;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.service.IotBuilderPicService;
import com.rz.iot.think.utils.CommonFunctions;
import com.rz.iot.think.utils.RzIotDBConstParam;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author by xuxiake, Date on 2019/3/14.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
@Service("iotBuilderPicService")
public class IotBuilderPicServiceImpl implements IotBuilderPicService {

    @Resource
    private IotBuilderPicMapper iotBuilderPicMapper;

    /**
     * 施工图片的上传
     * @param files 图片文件
     * @return
     */
    @Override
    public Result upload(MultipartFile[] files, HttpServletRequest request) {

        List<FileShowSimple> fileShowSimples = CommonFunctions.fileUpload(files, request);
        List<String> urls = new ArrayList<>();
        for (FileShowSimple f : fileShowSimples){
            urls.add(f.getUrl());
        }
        Map<String,Object> map = new HashMap<>();
        map.put("urls",urls);
        Result result = new Result();
        result.setData(map);
        return result;
    }

    @Override
    public List<String> getBuilderPics(Integer businessId, Integer businessType) {
        return iotBuilderPicMapper.findByBusinessId(businessId, RzIotDBConstParam.BUSSINESS_TYPE_OF_CONCENTRATOR);
    }
}
