package com.rz.iot.think.service;

import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.SysUpdatePkg;
import org.springframework.web.multipart.MultipartFile;

public interface SysUpdatePkgService {

    /**
     * 查询所有升级包
     * @param page
     * @param sysUpdatePkg
     * @return
     */
    Result FindAll(Page<SysUpdatePkg> page, SysUpdatePkg sysUpdatePkg);

    /**
     * 删除升级包
     * @param pkgId
     * @return
     */
    Result DelPkg(Integer[] pkgId);

    /**
     * 上传升级包
     * @param versioNo
     * @param file
     * @return
     */
    Result Upload(String versioNo, MultipartFile file);
}