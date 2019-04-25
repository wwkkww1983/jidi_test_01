package com.rz.iot.think.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.UserInfo;
import com.rz.iot.think.model.param.IotPowerParam;
import com.rz.iot.think.model.show.ShowIotPower;
import com.rz.iot.think.service.IotConcentratorService;
import com.rz.iot.think.service.IotPowerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author rycony
 * @version 1.0
 * @create 2019/3/22
 * 集中器电量的业务实现方法
 *
 */
@Service
@Transactional
public class IotPowerServiceImpl implements IotPowerService {
    @Resource
    private IotConcentratorService iotConcentratorService;

    /**
     * 根据条件查询集中器用电量情况.
     * @param iotPowerParam
     * @return
     */
    @Override
    public Result findList(IotPowerParam iotPowerParam, Page<ShowIotPower> page) {
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();

        Result result = new Result();
        PageHelper.startPage(page.getPageNum(),page.getPageSize());

        List<ShowIotPower> list = iotConcentratorService.findPower(iotPowerParam,userInfo.getId());


        //合计
        if(list != null && list.size() > 0){
            for(ShowIotPower temp : list){
                Double total =  0.0;
                if(temp.getConsumePower() != null && temp.getElecPrice() != null){
                   total =  temp.getConsumePower() * temp.getElecPrice();
                };
               temp.setTotalPrice(total);
            }
        }


        PageInfo pageInfo = new PageInfo(list);
        page.setOtherParam(pageInfo);
        result.setData(page);


        return result;
    }
}
