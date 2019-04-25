package com.rz.iot.think.controller;

import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.param.IotStreetlightAddParam;
import com.rz.iot.think.model.param.IotStreetlightDelParam;
import com.rz.iot.think.model.param.IotStreetlightListQueryParam;
import com.rz.iot.think.service.IotStreetlightService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Author by xuxiake, Date on 2019/3/13.
 * PS: Not easy to write code, please indicate.
 * Description：路灯controller
 */
@RestController
@RequestMapping("/streetlight")
public class IotStreetlightController {

    @Resource
    private IotStreetlightService iotStreetlightService;

    /**
     * 查询所有路灯
     * @return
     */
    @RequestMapping("/findAll")
    public Result findAll(Page page, IotStreetlightListQueryParam param) {
        return iotStreetlightService.findAll(page, param);
    }

    /**
     * 路灯详情
     * @param streetlightId
     * @return
     */
    @RequestMapping("/detail")
    public Result detail(Integer streetlightId) {
        return iotStreetlightService.detail(streetlightId);
    }

    /**
     * 增加路灯
     * @param param
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody IotStreetlightAddParam param) {

        return iotStreetlightService.add(param);
    }

    /**
     * 更新路灯信息
     * @param param
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody IotStreetlightAddParam param) {

        return iotStreetlightService.update(param);
    }

    /**
     * 删除路灯
     * @param param
     * @return
     */
    @RequestMapping("/del")
    public Result del(@RequestBody IotStreetlightDelParam param) {

        return iotStreetlightService.del(param.getStreetlightIds());
    }

    /**
     * excel导出
     * @param response
     */
    @RequestMapping("/exportExl")
    public void exportExl(HttpServletResponse response) {

        iotStreetlightService.exportExl(response);
    }

    /**
     * excel批量导入
     * @param file
     * @return
     */
    @RequestMapping("/importExl")
    public Result importExl(MultipartFile file) {

        return iotStreetlightService.importExl(file);
    }

    /**
     * excel导入模板下载
     * @param response
     */
    @RequestMapping("/templateDownload")
    public void templateDownload(HttpServletResponse response) {

        iotStreetlightService.templateDownload(response);
    }
}
