package com.rz.iot.think.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rz.iot.think.mapper.alarm.IotAlarmBoxMapper;
import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.alarm.IotAlarmBox;
import com.rz.iot.think.model.param.IotAlarmBoxRecorderSelectParam;
import com.rz.iot.think.model.param.IotAlarmBoxSelectDetailParam;
import com.rz.iot.think.model.param.IotAlarmBoxSelectParam;
import com.rz.iot.think.service.IotAlarmBoxService;
import com.rz.iot.utils.PasswordEncoder;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:jidi
 * @Date:2019/04/10 12:04
 * @Description:报警箱操作接口实习类
 **/
@Service("iotAlarmBoxService")
@Log4j2
public class IotAlarmBoxServiceImpl implements IotAlarmBoxService {

    @Resource
    private IotAlarmBoxMapper iotAlarmBoxMapper;

    /***
     * 分页+模糊 查询报警箱基本信息
     * @param page
     * @param iotAlarmBoxSelectParam
     * @return
     */
    @Override
    public Result findAlarmByCondition(Page<IotAlarmBoxSelectParam> page, IotAlarmBoxSelectParam iotAlarmBoxSelectParam) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<IotAlarmBoxSelectParam> list = iotAlarmBoxMapper.findAlarmByCondition(iotAlarmBoxSelectParam);
        PageInfo<IotAlarmBoxSelectParam> pageInfo = new PageInfo<>(list);
        page.setOtherParam(pageInfo);
        Result res = new Result();
        res.setData(page);
        return res;
    }

    /***
     * 查询报警箱详细信息
     * @param id
     * @return
     */
    @Override
    public Result findAlarmBoxDetail(Integer id) {
        Result res = new Result();
        IotAlarmBoxSelectDetailParam iotAlarmBoxSelectDetailParam = iotAlarmBoxMapper.findAlarmBoxDetail(id);
        res.setData(iotAlarmBoxSelectDetailParam);
        return res;
    }

    /***
     * 修改报警箱信息时，查询报警箱本身信息
     * @param id
     * @return
     */
    @Override
    public Result updateAlarmboxDetail(Integer id) {
        Result res = new Result();
        IotAlarmBox iotAlarmBox = iotAlarmBoxMapper.selectByPrimaryKey(id);
        res.setData(iotAlarmBox);
        return res;
    }

    /***
     * 修改报警箱信息
     * @param iotAlarmBox
     * @return
     */
    public Result updateAlarmbox(IotAlarmBox iotAlarmBox){
        //密码加密
        if (iotAlarmBox.getPassword()!=null && !"".equals(iotAlarmBox.getPassword())){
            String password = PasswordEncoder.encode(iotAlarmBox.getPassword(), iotAlarmBox.getAccount());
            iotAlarmBox.setPassword(password);
        }
        Result res = new Result();
        Integer i = iotAlarmBoxMapper.updateByPrimaryKeySelective(iotAlarmBox);
        if(i == 1){
            res.setMessage("修改成功！");
        }else{
            res.setMessage("修改失败！");
        }
        return res;
    }

    /***
     * 查询报警箱id集合
     * @return
     */
    @Override
    public  List<Integer> findBoxIds() {
        return iotAlarmBoxMapper.findBoxIds();
    }

    /***
     * 报警信息统计
     * @param page
     * @param iotAlarmBoxRecorderSelectParam
     * @return
     */
    public Result alarmBoxMessageStatistical(Page<IotAlarmBoxRecorderSelectParam> page, IotAlarmBoxRecorderSelectParam iotAlarmBoxRecorderSelectParam){
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<IotAlarmBoxRecorderSelectParam> list = iotAlarmBoxMapper.alarmBoxMessageStatistica(iotAlarmBoxRecorderSelectParam);
        PageInfo<IotAlarmBoxRecorderSelectParam> pageInfo = new PageInfo<>(list);
        page.setOtherParam(pageInfo);
        Result res = new Result();
        res.setData(page);
        return res;
    }
}
