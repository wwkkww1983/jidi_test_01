package com.rz.iot.think.controller;

import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.param.IotScreenProgramAddParam;
import com.rz.iot.think.model.param.IotScreenProgramDelParam;
import com.rz.iot.think.model.param.IotScreenProgramInfoListQueryParam;
import com.rz.iot.think.model.param.IotScreenProgramVerifyParam;
import com.rz.iot.think.service.IotScreenProgramService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: yyjuan
 * @Date: 2019/3/22 0022 09:57
 * @Description: 节目
 */
@RestController
@RequestMapping("/screenProgram")
public class IotScreenProgramController {

    @Resource
    private IotScreenProgramService iotScreenProgramService;

    /**
     * 增加节目
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody IotScreenProgramAddParam param){

        return iotScreenProgramService.add(param);
    }

    /**
     * 信息屏节目列表
     * @param page 分页参数
     * @param param 查询参数
     * @return
     */
    @RequestMapping("/findList")
    public Result findList(Page page, IotScreenProgramInfoListQueryParam param){

        return iotScreenProgramService.findList(page, param);
    }

    /**
     * 节目详细字段
     * @param programId 节目id
     * @return
     */
    @RequestMapping("/programDetail")
    public Result programDetail(Integer programId){

        return iotScreenProgramService.programDetail(programId);
    }

    /**
     * 节目删除
     * @param id
     * @return
     */
    @RequestMapping("/delProgram")
    public Result delProgram(Integer id){

        return new Result();
    }

    /**
     * 节目审批
     * @param param
     * @return
     */
    @RequiresPermissions("admin:verifyProgram")
    @RequestMapping("/verifyProgram")
    public Result verifyProgram(@RequestBody IotScreenProgramVerifyParam param){

        return  iotScreenProgramService.verifyProgram(param);
    }

    /**
     * 更新节目
     * @param param
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody IotScreenProgramAddParam param) {

        return iotScreenProgramService.update(param);
    }

    /**
     * 节目删除
     * @param param
     * @return
     */
    @RequestMapping("/del")
    public Result del(@RequestBody IotScreenProgramDelParam param) {
        return iotScreenProgramService.del(param);
    }

    /**
     * 节目复制
     * @param programId 节目id
     * @return
     */
    @RequestMapping("/copy")
    public Result copy(Integer programId) {
        return iotScreenProgramService.copy(programId);
    }
}
