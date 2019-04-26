package com.rz.iot.think.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rz.iot.think.mapper.SysUpdatePkgMapper;
import com.rz.iot.think.model.FileShowSimple;
import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.SysUpdatePkg;
import com.rz.iot.think.service.SysUpdatePkgService;
import com.rz.iot.think.utils.CommonFunctions;
import com.rz.iot.think.utils.RzIotDBConstParam;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUpdatePkgServiceImpl implements SysUpdatePkgService {

    @Resource
    private SysUpdatePkgMapper sysUpdatePkgMapper;

    @Override
    public Result FindAll(Page<SysUpdatePkg> page, SysUpdatePkg sysUpdatePkg) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<SysUpdatePkg> list = sysUpdatePkgMapper.findAll(sysUpdatePkg);
        PageInfo<SysUpdatePkg> pageInfo = new PageInfo<>(list);
        page.setOtherParam(pageInfo);
        Result result = new Result();
        result.setData(page);
        return result;
    }

    @Override
    public Result DelPkg(Integer[] pkgId) {
        Result result = new Result();
        if(pkgId.length!=0 && null!=pkgId){
            for(int id: pkgId){
                SysUpdatePkg sysUpdatePkg = new SysUpdatePkg();
                sysUpdatePkg.setStatus(RzIotDBConstParam.DATA_STATUS_OF_DELETE);
                sysUpdatePkg.setId(id);
                sysUpdatePkgMapper.updateByPrimaryKey(sysUpdatePkg);
            }
            result.setMessage("DELETE SUCCESS");
        }
        result.setMessage("DELETE FALSE");
        return result;
    }

    @Override
    public Result Upload(String versioNo, MultipartFile file) {
        if(null !=file){
            FileShowSimple fileShowSimple = CommonFunctions.fileUpload(file);
            SysUpdatePkg sysUpdatePkg = new SysUpdatePkg();
            sysUpdatePkg.setVersion(versioNo);
            sysUpdatePkg.setFileSize(fileShowSimple.getSize());
            sysUpdatePkg.setStatus(RzIotDBConstParam.DATA_STATUS_OF_NORMAL);
            sysUpdatePkg.setFileName(fileShowSimple.getName());
            sysUpdatePkg.setFilePath(fileShowSimple.getUrl());
            sysUpdatePkgMapper.insert(sysUpdatePkg);
        }
        Result result = new Result();
        return result;
    }
}