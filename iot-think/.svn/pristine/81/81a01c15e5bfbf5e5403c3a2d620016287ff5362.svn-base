package com.rz.iot.think.controller;

import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.SysUpdatePkg;
import com.rz.iot.think.service.SysUpdatePkgService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;

/**
 *  Author by xuxiake zhangxd, Date on 2019/4/10.
 * PS: Not easy to write code, please indicate.
 * Description：升级包管理
 */

@RestController
@RequestMapping("/updatePkg")
public class SysUpdatePkgController {

    @Resource
    private SysUpdatePkgService sysUpdatePkgService;

    /**
     * 查询所有升级包
     * @param sysUpdatePkg
     * @return
     */
    @RequestMapping("/findAll")
    public Result FindAll(Page<SysUpdatePkg> page,SysUpdatePkg sysUpdatePkg){
        return sysUpdatePkgService.FindAll(page, sysUpdatePkg);
    }

    /**
     * 批量删除升级包
     * @param map
     * @return
     */
    @RequestMapping("/delPkg")
    public Result DelPkg(@RequestBody Map<String, Object> map){
        ArrayList<Integer> temp = (ArrayList<Integer>)map.get("Id");
        Integer pkgId[] = new Integer[temp.size()];
        temp.toArray(pkgId);//list转数组
        return sysUpdatePkgService.DelPkg(pkgId);
    }

    /**
     * 上传更新包
     * @param versionNo
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    public Result upLoad(String versionNo, MultipartFile file){
        return  sysUpdatePkgService.Upload(versionNo, file);
    }
//    升级包发布 取消发布（待确认）
    public Result downLoad(){
        return new Result();
    }
}