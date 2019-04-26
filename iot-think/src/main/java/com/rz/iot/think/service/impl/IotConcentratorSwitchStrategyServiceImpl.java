package com.rz.iot.think.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rz.iot.think.mapper.IotConcentratorBrightnessStrategyMapper;
import com.rz.iot.think.mapper.IotConcentratorStrategyRelMapper;
import com.rz.iot.think.mapper.IotConcentratorSwitchBrightnessStrategyRelMapper;
import com.rz.iot.think.mapper.IotConcentratorSwitchStrategyMapper;
import com.rz.iot.think.model.*;
import com.rz.iot.think.model.show.IotSwitchBrightnessShowDetail;
import com.rz.iot.think.service.IotBusinessUserRelService;
import com.rz.iot.think.service.IotConcentratorService;
import com.rz.iot.think.service.IotConcentratorSwitchStrategyService;
import com.rz.iot.think.utils.RzIotErrMessage;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 集中器开关策略的业务实现类
 * @author rycony
 * @created 2019/3/26
 */
@Service
@Transactional
public class IotConcentratorSwitchStrategyServiceImpl implements IotConcentratorSwitchStrategyService {
    Logger logger = LoggerFactory.getLogger(IotConcentratorSwitchStrategyServiceImpl.class);
    @Resource
    private IotConcentratorSwitchStrategyMapper iotConcentratorSwitchStrategyMapper;
    @Resource
    private IotConcentratorStrategyRelMapper iotConcentratorStrategyRelMapper;
    @Resource
    private IotConcentratorSwitchBrightnessStrategyRelMapper iotConcentratorSwitchBrightnessStrategyRelMapper;
    @Resource
    private IotConcentratorBrightnessStrategyMapper iotConcentratorBrightnessStrategyMapper;
    @Resource
    private IotBusinessUserRelService iotBusinessUserRelService;
    @Resource
    private IotConcentratorService iotConcentratorService;

    /**
     * 插入集中器开关策略以及调光策略
     * @param iotConcentratorSwitchStrategy
     * @return
     */
    @Override
    public IotConcentratorSwitchStrategy insertIotConcentratorSwitchStrategy(IotConcentratorSwitchStrategy iotConcentratorSwitchStrategy) {
        if(iotConcentratorSwitchStrategy != null){
            iotConcentratorSwitchStrategyMapper.insertSelective(iotConcentratorSwitchStrategy);
            //在获取最新查询的数据id
            IotConcentratorSwitchStrategy findLastOne = iotConcentratorSwitchStrategyMapper.findLast();
            findLastOne.setId(findLastOne.getId()+ 1);
            return findLastOne;
        }
        return null;
    }

    /**
     * 根据开关策略id查询开关策略
     * @param id
     * @return
     */
    @Override
    public Result findIotConcentratorSwitchStrategy(Integer id) {
        Result result = new Result();
        if(id == null){
            result.setCode(RzIotErrMessage.PARAM_IS_NULL);
            result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.PARAM_IS_NULL));
            return result;
        }

        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();

        IotConcentratorSwitchStrategy iotConcentratorSwitchStrategy = iotConcentratorSwitchStrategyMapper.findIotConcentratorSwitchStrategy(id,userInfo.getId());

        result.setData(iotConcentratorSwitchStrategy);
        return result;
    }

    /**
     * 根据查询条件查询出所有的开关策略
     * @param iotConcentratorSwitchStrategy
     * @param page
     * @return
     */
    @Override
    public Result findIotConcentratorSwitchStrategyList(IotConcentratorSwitchStrategy iotConcentratorSwitchStrategy,Page<IotConcentratorSwitchStrategy> page) {
        Result result = new Result();

        //设置起始
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();


        List<IotConcentratorSwitchStrategy> iotConcentratorSwitchStrategys = iotConcentratorSwitchStrategyMapper.findIotConcentratorSwitchStrategyList(iotConcentratorSwitchStrategy,userInfo.getId());

        PageInfo<IotConcentratorSwitchStrategy> pageInfo = new PageInfo<IotConcentratorSwitchStrategy>(iotConcentratorSwitchStrategys);
        page.setOtherParam(pageInfo);
        result.setData(page);

        result.setMessage("find all iotConcentratorSwitchStrategys success");
        return result;
    }


    /**
     * 编辑开关策略
     * @param iotSwitchBrightnessShowDetail
     * @return
     */
    @Override
    public Result editIotConcentratorSwitchStrategy(IotSwitchBrightnessShowDetail iotSwitchBrightnessShowDetail) {
        Result result = new Result();
        if(iotSwitchBrightnessShowDetail == null){
            result.setCode(RzIotErrMessage.PARAM_IS_NULL);
            result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.PARAM_IS_NULL));
            return result;
        }

        //修改开关策略
        IotConcentratorSwitchStrategy iotConcentratorSwitchStrategy = iotSwitchBrightnessShowDetail.getIotConcentratorSwitchStrategy();
        if(iotConcentratorSwitchStrategy != null){
            iotConcentratorSwitchStrategyMapper.updateByPrimaryKeySelective(iotConcentratorSwitchStrategy);
        }

        //修改调光策略
        List<IotConcentratorBrightnessStrategy> list = iotSwitchBrightnessShowDetail.getIotConcentratorBrightnessStrategyList();

        Integer switchId = iotConcentratorSwitchStrategy.getId();
        //则删除开关策略与调光策略的关联表,以及删除调光策略
        //如果根据开关策略id查询关系表有关联调光策略.即
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(switchId);
        //删除对应的关联表以及调光策略
        List<IotConcentratorSwitchBrightnessStrategyRel> list1 = iotConcentratorSwitchBrightnessStrategyRelMapper.findBySwitchId(switchId);

        iotConcentratorSwitchBrightnessStrategyRelMapper.deleteBySwitchId(temp);

        if(list1 != null && list1.size() > 0){
            for(IotConcentratorSwitchBrightnessStrategyRel temp1 : list1){
                iotConcentratorBrightnessStrategyMapper.deleteById(temp1.getBrightnessId());
            }
        }

        List<Integer> ids = new ArrayList<Integer>();

        if(list != null && list.size() > 0){
            for(IotConcentratorBrightnessStrategy iotConcentratorBrightnessStrategy : list){
                ids.add(iotConcentratorBrightnessStrategy.getId());
            }
            //重新建立关系
            iotConcentratorSwitchBrightnessStrategyRelMapper.insertIotConcentratorSwitchBrightnessStrategyRel(switchId,ids);
            iotConcentratorBrightnessStrategyMapper.insertIotConcentratorBrightnessStrategys(list);
        }


        return result;
    }

    /**
     * 根据开关策略id删除开关策略
     * @param ids
     * @return
     */
    @Override
    public Result delete(List<Integer> ids) {
        Result result = new Result();

        //获取当前用户
        UserInfo userInfo = (UserInfo)SecurityUtils.getSubject().getPrincipal();

        if(ids == null){
            result.setCode(RzIotErrMessage.PARAM_IS_NULL);
            result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.PARAM_IS_NULL));
            return result;
        }

        //如果集中器与开关策略绑定,则先删除关联关系
        //提示是否删除用户与集中器之间的关系
        if(ids != null && ids.size() > 0){
            for(Integer id : ids){
                //查询出所有关联该开关策略的集中器,然后在删除关联关系
                List<IotConcentratorStrategyRel> list = iotConcentratorStrategyRelMapper.selectBySwitchId(id);
                if(list != null && list.size() > 0){
                    //如果该开关策略所关联的集中器有关联
                    for(IotConcentratorStrategyRel rel : list){
                        IotBusinessUserRel iotBusinessUserRel = iotBusinessUserRelService.findIotBusinessUserRel(userInfo.getId(),rel.getConcentratorId());
                        if(iotBusinessUserRel != null){
                            //当code为10000时,需要先删除用户与集中器关系
                            result.setCode(10000);
                            result.setMessage("please delete user-concentrator-rel");
                            return result;
                        }
                    }

                    iotConcentratorStrategyRelMapper.deleteList(list);
                }
            }
        }

        iotConcentratorSwitchStrategyMapper.deleteByPrimaryKeys(ids);

        //在删除开关策略与调光策略的关联关系
        iotConcentratorSwitchBrightnessStrategyRelMapper.deleteBySwitchId(ids);

        return result;
    }


    /**
     * 绑定集中器与开关策略
     * @param iotSwitchBindConcentrator
     * @return
     */
    @Override
    public Result bindSwitchConcentrator(IotSwitchBindConcentrator iotSwitchBindConcentrator) {
        Result result = new Result();

        if(iotSwitchBindConcentrator == null){
            result.setCode(RzIotErrMessage.PARAM_IS_NULL);
            result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.PARAM_IS_NULL));
            return result;
        }

        iotConcentratorStrategyRelMapper.bindSwitchConcentrator(iotSwitchBindConcentrator);

        //当发送集中器类型为集中器组,则更改所有组下的集中器.
        if(iotSwitchBindConcentrator.getConcentratorType().equals("2")){

        }
        return result;
    }

    /**
     * 解除集中器与开关策略的绑定
     * @param iotSwitchBindConcentrator
     * @return
     */
    @Override
    public Result unbindSwitchConcentrator(IotSwitchBindConcentrator iotSwitchBindConcentrator) {
        Result result = new Result();
        if(iotSwitchBindConcentrator == null){
            result.setCode(RzIotErrMessage.PARAM_IS_NULL);
            result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.PARAM_IS_NULL));
            return result;
        }

        iotConcentratorStrategyRelMapper.unbindSwitchConcentrator(iotSwitchBindConcentrator);
        return result;
    }

    /**
     * 重新下发策略到集中器
     * @param iotSwitchBindConcentrator
     * @return
     */
    @Override
    public Result resendSwitchConcentrator(IotSwitchBindConcentrator iotSwitchBindConcentrator) {
        Result result = new Result();

        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        if(iotSwitchBindConcentrator == null){
            result.setCode(RzIotErrMessage.PARAM_IS_NULL);
            result.setMessage(RzIotErrMessage.getErrMessage(RzIotErrMessage.PARAM_IS_NULL));
            return result;
        }

        for(int concentratorId : iotSwitchBindConcentrator.getConcentratorId()){
            //获取每个集中器的开关策略,在对集中器进行重新发送
            IotConcentratorSwitchStrategy iotConcentratorSwitchStrategy = iotConcentratorSwitchStrategyMapper.findSwitchStrategyByConcentratorId(concentratorId,userInfo.getId());

            //在调用集中器发送接口进行发送..
        }

        result.setCode(1);

        return result;
    }

    /**
     * 批量打开集中器与集中器组
     * @param iotSwitchBindConcentrator
     * @return
     */
    @Override
    public Result openOrCloseConcentrators(IotSwitchBindConcentrator iotSwitchBindConcentrator) {
        Result result = new Result();
        /**
         * 批量打开集中器(组)开关
         * 开关状态:
         *      1.打开  0.关闭
         */
        //对集中器(立即)直接发送开关处理.

        //处理完对集中器进行更改.
        iotConcentratorService.updateConcentrators(iotSwitchBindConcentrator);
        result.setMessage("update success");
        //在下发指令给集中器进行开关操作


        return result;
    }

    /**
     * 查询开关策略的显示详情(开关策略以及调光策略)
     * @param id
     * @return
     */
    @Override
    public Result findIotSwitchStrategyShowDetail(Integer id) {
        /**
         * 编辑开关策略:
         *      判断开关策略是否绑定集中器:
         *              1.如果绑定集中器,那么只能修改名称
         *              2.如果没有绑定集中器,那么全部信息都可以修改
         */
        Result result = new Result();

        if(id == null){
            result.setCode(RzIotErrMessage.PARAM_IS_NULL);
            result.setMessage("PARAM_IS_NULL");
            return result;
        }
        //查询开关与集中器之间的关系
        List<IotConcentratorStrategyRel> concentratorStrategyRel = iotConcentratorStrategyRelMapper.selectBySwitchId(id);

        //查询开关表,回显数据 code:1.表示只能修改名称,2.表示全部都能修改
        IotConcentratorSwitchStrategy iotConcentratorSwitchStrategy = iotConcentratorSwitchStrategyMapper.selectByPrimaryKey(id);

        //在查询出对应的调光策略
        List<IotConcentratorBrightnessStrategy> list = iotConcentratorSwitchBrightnessStrategyRelMapper.findIotSwitchStrategyShowDetail(id);

        IotSwitchBrightnessShowDetail iotSwitchBrightnessShowDetail = new IotSwitchBrightnessShowDetail();
        iotSwitchBrightnessShowDetail.setIotConcentratorSwitchStrategy(iotConcentratorSwitchStrategy);
        iotSwitchBrightnessShowDetail.setIotConcentratorBrightnessStrategyList(list);

        result.setData(iotSwitchBrightnessShowDetail);
        if(concentratorStrategyRel != null && concentratorStrategyRel.size() > 0){
            //则只能修改名称
            //返回一个标识码标识只能修改名称
            result.setCode(1);
            return result;
        }

        //内容可以全部修改
        result.setCode(2);
        return result;
    }

    /**
     * 对集中器进行批量调光
     * @param iotSwitchBindConcentrator
     * @return
     */
    @Override
    public Result brightConcentrators(IotSwitchBindConcentrator iotSwitchBindConcentrator) {
        Result result = new Result();

        List<Integer> concentratorIds = iotSwitchBindConcentrator.getConcentratorId();

        for(Integer concentratorId : concentratorIds){
            //对集中器进行批量处理.直接发送给集中器.
        }

        return result;
    }

    /**
     * 查询出未绑定的集中器(组)
     * @return
     * @param concentratorType
     */
    @Override
    public Result findUnbindConcentrator(Integer concentratorType) {
        Result result = new Result();

        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();

        //集中器
        List<IotConcentrator> list = new ArrayList<IotConcentrator>();
        //集中器组
        List<IotConcentratorGroup> groupList = new ArrayList<IotConcentratorGroup>();

        //查询出未绑定的集中器
        if(concentratorType == 1){
            list = iotConcentratorSwitchStrategyMapper.findUnbindConcentrator(userInfo.getId());
            result.setData(list);
            return result;
        }else if(concentratorType == 2){
            groupList = iotConcentratorSwitchStrategyMapper.findUnbindConcentratorGroup(userInfo.getId());
            result.setData(groupList);
            return result;
        }
        return result;
    }
}
