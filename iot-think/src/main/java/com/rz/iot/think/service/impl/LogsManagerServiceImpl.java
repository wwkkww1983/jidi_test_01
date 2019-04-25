package com.rz.iot.think.service.impl;

import com.rz.iot.think.mapper.SysDeviceConnRecordMapper;
import com.rz.iot.think.mapper.SysOptRecordMapper;
import com.rz.iot.think.mapper.SysUserLoginRecordMapper;
import com.rz.iot.think.model.SysDeviceConnRecord;
import com.rz.iot.think.model.SysOptRecord;
import com.rz.iot.think.model.SysUserLoginRecord;
import com.rz.iot.think.model.UserInfo;
import com.rz.iot.think.model.excel.SysDeviceConnRecordExportModel;
import com.rz.iot.think.model.excel.SysOptRecordExportModel;
import com.rz.iot.think.model.excel.SysUserLoginRecordExportModel;
import com.rz.iot.think.model.show.SysOptRecordShowList;
import com.rz.iot.think.model.show.SysUserLoginRecordShowList;
import com.rz.iot.think.service.LogsManagerService;
import com.rz.iot.think.utils.ExcelUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Log4j2
@Service
public class LogsManagerServiceImpl implements LogsManagerService{

    @Resource
    SysOptRecordMapper sysOptRecordMapper;
    @Resource
    SysDeviceConnRecordMapper sysDeviceConnRecordMapper;
    @Resource
    SysUserLoginRecordMapper sysUserLoginRecordMapper;


    @Override
    public void ExportExcel(String name, HttpServletResponse response) {
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        String fileName = null;
        try(OutputStream out = response.getOutputStream()) {
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("utf-8");

            switch (name){
                case "sysOptRecord":  fileName = new String((name+" " + new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getBytes(), "UTF-8");
                    response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
                    List<SysOptRecordShowList>opt = sysOptRecordMapper.findAll(null);
                    List<SysOptRecordExportModel> optList = new ArrayList<>();
                    for(SysOptRecordShowList temp: opt){
                        SysOptRecordExportModel sysOptRecordExportModel = new SysOptRecordExportModel();
                        sysOptRecordExportModel.setName(temp.getUserName());
                        sysOptRecordExportModel.setIp(temp.getClientIp());
                        sysOptRecordExportModel.setMac(temp.getClientMac());
                        sysOptRecordExportModel.setModule(temp.getModule()+"");
                        sysOptRecordExportModel.setContent(temp.getContent());
                        sysOptRecordExportModel.setOpt_mode(temp.getOptMode()+"");
                        sysOptRecordExportModel.setOpt_type(temp.getOptType()+"");
                        sysOptRecordExportModel.setCreateTime(temp.getCreateTime());
                        sysOptRecordExportModel.setUpdateTime(temp.getUpdateTime());
                        optList.add(sysOptRecordExportModel);
                        ExcelUtils.writeExl(out, optList, 3, 5000, SysOptRecordExportModel.class);
                        out.flush();
                    }
                    break;
                case "sysUserLoginRecord": fileName = new String((name+" " + new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getBytes(), "UTF-8");
                    response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
                    List<SysUserLoginRecordShowList> login = sysUserLoginRecordMapper.findAll(null);
                    List<SysUserLoginRecordExportModel> loginList = new ArrayList<>();
                    for(SysUserLoginRecordShowList temp:login){
                        SysUserLoginRecordExportModel sysUserLoginRecordExportModel = new SysUserLoginRecordExportModel();
                        sysUserLoginRecordExportModel.setName(temp.getUserName());
                        sysUserLoginRecordExportModel.setIp(temp.getClientIp());
                        sysUserLoginRecordExportModel.setMac(temp.getClientMac());
                        sysUserLoginRecordExportModel.setLogin_mode(temp.getLoginMode()+"");
                        sysUserLoginRecordExportModel.setLogin_type(temp.getLoginType()+"");
                        sysUserLoginRecordExportModel.setCreateTime(temp.getCreateTime());
                        sysUserLoginRecordExportModel.setUpdateTime(temp.getUpdateTime());
                        loginList.add(sysUserLoginRecordExportModel);
                        ExcelUtils.writeExl(out, loginList, 3, 5000, SysUserLoginRecordExportModel.class);
                        out.flush();
                    }
                    break;
                case "sysDeviceConnRecord":fileName = new String((name+" " + new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getBytes(), "UTF-8");
                    response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
                    List<SysDeviceConnRecord> device = sysDeviceConnRecordMapper.findAll(null);
                    List<SysDeviceConnRecordExportModel> devcieList = new ArrayList<>();
                    for(SysDeviceConnRecord temp:device){
                        SysDeviceConnRecordExportModel sysDeviceConnRecordExportModel = new SysDeviceConnRecordExportModel();
                        sysDeviceConnRecordExportModel.setDevice_id(temp.getDeviceId()+"");
                        sysDeviceConnRecordExportModel.setDevice_type(temp.getDeviceType()+"");
                        sysDeviceConnRecordExportModel.setConn_type(temp.getConnType()+"");
                        sysDeviceConnRecordExportModel.setMessage(temp.getMessage());
                        sysDeviceConnRecordExportModel.setCreateTime(temp.getCreateTime());
                        sysDeviceConnRecordExportModel.setUpdateTime(temp.getUpdateTime());
                        devcieList.add(sysDeviceConnRecordExportModel);
                        ExcelUtils.writeExl(out, devcieList, 3, 5000, SysDeviceConnRecordExportModel.class);
                        out.flush();
                    }
                    break;
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}