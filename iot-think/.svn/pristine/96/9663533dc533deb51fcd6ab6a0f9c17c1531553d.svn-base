package com.rz.iot.think.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rz.iot.think.mapper.*;
import com.rz.iot.think.model.*;
import com.rz.iot.think.model.param.IotConcentratorGroupAddParam;
import com.rz.iot.think.model.param.IotConcentratorListQueryParam;
import com.rz.iot.think.model.show.IotConcentratorGroupShowDetail;
import com.rz.iot.think.model.show.IotConcentratorGroupShowList;
import com.rz.iot.think.model.show.IotConcentratorShowList;
import com.rz.iot.think.service.IotBusinessUserRelService;
import com.rz.iot.think.service.IotConcentratorGroupService;
import com.rz.iot.think.service.IotConcentratorSwitchStrategyService;
import com.rz.iot.think.utils.RzIotDBConstParam;
import com.rz.iot.think.utils.RzIotErrMessage;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Author by xuxiake, Date on 2019/3/22.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
@Service("iotConcentratorGroupService")
public class IotConcentratorGroupServiceImpl implements IotConcentratorGroupService {

    @Resource
    private IotConcentratorGroupMapper iotConcentratorGroupMapper;
    @Resource
    private IotConcentratorMapper iotConcentratorMapper;
    @Resource
    private IotBusinessUserRelService iotBusinessUserRelService;
    @Resource
    private IotConcentratorGroupListMapper iotConcentratorGroupListMapper;
    @Resource
    private IotBusinessUserRelMapper iotBusinessUserRelMapper;
    @Resource
    private IotConcentratorStrategyRelMapper iotConcentratorStrategyRelMapper;
    @Resource
    private IotConcentratorSwitchStrategyService iotConcentratorSwitchStrategyService;

    /**
     * 查询集中器组列表
     * @param page 分页参数
     * @param param 查询参数
     * @return
     */
    @Override
    public Result findAll(Page page, IotConcentratorListQueryParam param) {

        Result result = new Result();
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<IotConcentratorGroupShowList> list = iotConcentratorGroupMapper.findAll(userInfo.getId(), param);
        PageInfo<IotConcentratorGroupShowList> pageInfo = new PageInfo<>(list);

        List<IotConcentratorGroupShowList> concentratorGroups = new ArrayList<>();

        for (IotConcentratorGroupShowList item : list) {
            List<IotConcentratorShowList> concentrators = iotConcentratorMapper.findByGroupId(item.getId());
            item.setConcentrators(concentrators);
            // 在线状态标记
            Integer statusflag = 1;
            // 开关状态标记
            Integer switchStatusflag = 1;
            for (IotConcentratorShowList concentrator : concentrators) {
                if (concentrator.getStatus() == RzIotDBConstParam.DEVICE_STATUS_OF_OFFLINE) {
                    // 集中器组下有一个集中器离线，则判定集中器组离线
                    statusflag = RzIotDBConstParam.DEVICE_STATUS_OF_OFFLINE;
                }
                if (concentrator.getSwitchStatus() == RzIotDBConstParam.CONCENTRATOR_SWITCH_STATUS_OF_ON) {
                    // 集中器组下有一个集中器是开启状态，则判定集中器组是开启状态
                    switchStatusflag = RzIotDBConstParam.CONCENTRATOR_SWITCH_STATUS_OF_ON;
                }
            }
            item.setStatus(statusflag);
            item.setSwitchStatus(switchStatusflag);
            // 查询条件过滤
            // TODO: 2019/3/23 会导致分页参数与数据对应不上，待优化
            if (param.getStatus() != null) {
                if (item.getStatus() != param.getStatus()) {
                    continue;
                }
            }
            if (param.getSwitchStatus() != null) {
                if (item.getSwitchStatus() != param.getSwitchStatus()) {
                    continue;
                }
            }
            concentratorGroups.add(item);
        }

        page.setOtherParam(pageInfo);
        page.setList(concentratorGroups);
        result.setData(page);
        return result;
    }

    /**
     * 集中器详情
     * @param groupId 集中器组id
     * @return
     */
    @Override
    public Result detail(Integer groupId) {

        Result result = new Result();
        if (groupId == null) {
            return Result.paramNull(result);
        }
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        // 鉴权
        boolean authorized = iotBusinessUserRelService.isAuthorized(groupId, RzIotDBConstParam.BUSSINESS_TYPE_OF_CONCENTRATOR_GROUP, userInfo.getId());
        if (!authorized) {
            return Result.unAuthorized(result);
        }
        IotConcentratorGroup concentratorGroup = iotConcentratorGroupMapper.selectByPrimaryKey(groupId);
        List<IotConcentratorShowList> concentrators = iotConcentratorMapper.findByGroupId(groupId);
        IotConcentratorGroupShowDetail iotConcentratorGroupShowDetail = new IotConcentratorGroupShowDetail();
        iotConcentratorGroupShowDetail.setId(concentratorGroup.getId());
        iotConcentratorGroupShowDetail.setName(concentratorGroup.getName());
        iotConcentratorGroupShowDetail.setConcentrators(concentrators);

        result.setData(iotConcentratorGroupShowDetail);

        return result;
    }

    /**
     * 增加集中器组
     * @param param
     * @return
     */
    @Transactional
    @Override
    public Result add(IotConcentratorGroupAddParam param) {

        Result result = new Result();
        if (StringUtils.isEmpty(param.getName()) || param.getConcentratorIds().size() == 0) {
            return Result.paramNull(result);
        }
        // 集中器的区、路从集中器取得（不同区或者不同路的集中器不能新建集中器组）
        List<IotConcentrator> concentrators = iotConcentratorMapper.findByIds(param.getConcentratorIds());
        Long roadIdGroup = null;
        Integer areaRelIdGroup = null;
        for (IotConcentrator concentrator : concentrators) {
            Long roadId = concentrator.getRoadId();
            Integer areaRelId = concentrator.getAreaRelId();
            if (roadId != null && areaRelId != null) {
                if (roadIdGroup == null) {
                    roadIdGroup = roadId;
                    areaRelIdGroup = areaRelId;
                }
                if (roadId != roadIdGroup) {
                    result.setCode(RzIotErrMessage.CONCENTRATOR_GROUP_ADD_ROAD_IS_DIFFERENT);
                    return result;
                }
            }
        }

        // 增加集中器组
        IotConcentratorGroup concentratorGroup = new IotConcentratorGroup();
        concentratorGroup.setName(param.getName());
        if (areaRelIdGroup != null) {
            concentratorGroup.setAreaRelId(areaRelIdGroup);
        }
        if (roadIdGroup != null) {
            concentratorGroup.setRoadId(new Integer(roadIdGroup + ""));
        }
        iotConcentratorGroupMapper.insertSelective(concentratorGroup);

        // 增加集中器组与用户关联关系
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        if (userInfo.getStatus() == RzIotDBConstParam.USER_STATUS_OF_NORMAL) {
            IotBusinessUserRel iotBusinessUserRel = new IotBusinessUserRel();
            iotBusinessUserRel.setUserId(userInfo.getId());
            iotBusinessUserRel.setBusinessId(concentratorGroup.getId());
            iotBusinessUserRel.setBusinessType(RzIotDBConstParam.BUSSINESS_TYPE_OF_CONCENTRATOR_GROUP);
            iotBusinessUserRelMapper.insertSelective(iotBusinessUserRel);
        }

        // 批量增加集中器组id集中器id关联关系
        List<IotConcentratorGroupList> iotConcentratorGroupLists = new ArrayList<>();
        for (Integer concentratorId : param.getConcentratorIds()) {
            IotConcentratorGroupList iotConcentratorGroupList = new IotConcentratorGroupList();
            iotConcentratorGroupList.setConcentratorId(concentratorId);
            iotConcentratorGroupList.setGroupId(concentratorGroup.getId());
            iotConcentratorGroupLists.add(iotConcentratorGroupList);
        }
        iotConcentratorGroupListMapper.insertBatch(iotConcentratorGroupLists);

        return result;
    }

    /**
     * 更新集中器组
     * @param param
     * @return
     */
    @Transactional
    @Override
    public Result update(IotConcentratorGroupAddParam param) {

        Result result = new Result();
        if (param.getId() == null || StringUtils.isEmpty(param.getName())) {
            return Result.paramNull(result);
        }

        // 更新集中器组
        IotConcentratorGroup concentratorGroup = new IotConcentratorGroup();
        concentratorGroup.setId(param.getId());
        concentratorGroup.setName(param.getName());
        iotConcentratorGroupMapper.updateByPrimaryKeySelective(concentratorGroup);

        return result;
    }

    /**
     * 删除集中器组
     * @param groupIds 集中器组id
     * @return
     */
    @Transactional
    @Override
    public Result del(List<Integer> groupIds) {

        Result result = new Result();
        if (groupIds.size() == 0) {
            return Result.paramNull(result);
        }
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();

        for (Integer groupId : groupIds) {
            // 鉴权
            boolean authorized = iotBusinessUserRelService.isAuthorized(groupId, RzIotDBConstParam.BUSSINESS_TYPE_OF_CONCENTRATOR_GROUP, userInfo.getId());
            if (!authorized) {
                return Result.unAuthorized(result);
            }
        }

        for (Integer groupId : groupIds) {

            // 删除集中器组id集中器id关联关系
            iotConcentratorGroupListMapper.delByGroupId(groupId);

            // 删除集中器组关联策略
            IotConcentratorStrategyRel iotConcentratorStrategyRel = iotConcentratorStrategyRelMapper.findByConcentratorId(groupId, RzIotDBConstParam.CONCENTRATOR_TYPE_OF_CONCENTRATOR_GROUP);
            List<Integer> ids = new ArrayList<>();
            ids.add(iotConcentratorStrategyRel.getStrategyId());
            iotConcentratorSwitchStrategyService.delete(ids);

            // 删除集中器用户关联关系
            iotBusinessUserRelMapper.delRel(groupId, userInfo.getId(), RzIotDBConstParam.BUSSINESS_TYPE_OF_CONCENTRATOR_GROUP);

            // 删除集中器组
            IotConcentratorGroup concentratorGroup = new IotConcentratorGroup();
            concentratorGroup.setId(groupId);
            concentratorGroup.setStatus(RzIotDBConstParam.DATA_STATUS_OF_DELETE);
            iotConcentratorGroupMapper.updateByPrimaryKeySelective(concentratorGroup);
        }

        return result;
    }
}
