package com.rz.iot.think.controller;


import com.rz.iot.think.model.*;
import com.rz.iot.think.model.show.SysOptRecordShowList;
import com.rz.iot.think.model.show.SysUserLoginRecordShowList;
import com.rz.iot.think.service.LogsManagerService;
import com.rz.iot.think.service.SysDeviceConnRecordService;
import com.rz.iot.think.service.SysOptRecordService;
import com.rz.iot.think.service.SysUserLoginRecordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Author by xuxiake zhangxd, Date on 2019/3/27.
 * PS: Not easy to write code, please indicate.
 * Description：日志管理
 */
@RestController
@RequestMapping("/logs")
public class LogsManagerController {
    @Resource
    private SysOptRecordService sysOptRecordService;
    @Resource
    private SysUserLoginRecordService sysUserLoginRecordService;
    @Resource
    private SysDeviceConnRecordService sysDeviceConnRecordService;
    @Resource
    private LogsManagerService logsManagerService;

    /**
     * 查找操作日志
     * @param page
     * @param sysOptRecordShowList
     * @return
     */
    @RequestMapping("/findOptLogs")
    public Result findOptLogs(Page<SysOptRecordShowList> page, SysOptRecordShowList sysOptRecordShowList){
        return sysOptRecordService.findAll(page, sysOptRecordShowList);
    }

    /**
     * 查找登陆日志
     * @param page
     * @param sysUserLoginRecordShowList
     * @return
     */

    @RequestMapping("/findUserLoginLogs")
    public Result findUserLoginLogs(Page<SysUserLoginRecordShowList> page, SysUserLoginRecordShowList sysUserLoginRecordShowList){
        return  sysUserLoginRecordService.findAll(page, sysUserLoginRecordShowList);
    }

    /**
     * 查找系统日志
     * @param page
     * @param sysDeviceConnRecord
     * @return
     */
    @RequestMapping("/findDataLogs")
    public  Result findDataLogs(Page<SysDeviceConnRecord> page, SysDeviceConnRecord sysDeviceConnRecord){
        return sysDeviceConnRecordService.findAll(page, sysDeviceConnRecord);
    }

    /**
     * 导出当前日志为Excel
     * @param name  name值对应不同日志表导出 sysOptRecord（操作日志）  sysUserLoginRecord（登录日志）  sysDeviceConnRecord（设备日志）
     * @param response
     */
    @RequestMapping("/exportExcel")
    public void outExcel(String name, HttpServletResponse response){
        logsManagerService.ExportExcel(name, response);
    }
}