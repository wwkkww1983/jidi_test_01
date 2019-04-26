package com.rz.iot.think.service;
/**
 * Created by Administrator on 2019/3/19 0019.
 */

import com.rz.iot.think.exception.NullParamException;
import com.rz.iot.think.model.IotSwitchBindConcentrator;
import com.rz.iot.think.model.param.IotPowerParam;
import com.rz.iot.think.model.show.ConcentratorDetail;
import com.rz.iot.think.model.show.ShowIotPower;
import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.param.AddConcentratorParam;
import com.rz.iot.think.model.param.IotConcentratorListQueryParam;
import com.rz.iot.think.model.show.IotConcentratorShowList;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * 描述:
 * 集中器
 *
 * @author Zhouyz
 * @create 2019-03-19 16:31
 */
public interface IotConcentratorService {
    /**
     * 用集中器id获取详细的集中器信息
     * @param concentratorId 集中器id
     * @return 查询结果
     */
    HashMap getDetailById(Integer concentratorId);

    /**
     * 用集中器id获取单灯控制器信息列表
     * @param concentratorId 集中器id
     * @return 返回查询结果
     */
    List<HashMap> getSlcInfosByConcentratorId(Integer concentratorId);

    /**
     * 根据集中器id查询详细的集中器信息，给集中器详情页面使用
     * @param concentratorId 集中器页面
     * @return 查询结果
     */
    ConcentratorDetail concentratorDetail(Integer concentratorId);

    /**
     * 根据开关和集中器绑定类修改集中器
     * @param iotSwitchBindConcentrator
     */
    void updateConcentrators(IotSwitchBindConcentrator iotSwitchBindConcentrator);
    /**
     * 为集中器详情页获取单灯控制器和路灯的相关信息
     * @param concentratorId 集中器id
     * @return 返回查询结果
     */
    List<HashMap> getSlcForConcentrator(Integer concentratorId);

    /**
     * 获取进出线信息
     * @return 返回查询结果
     */
    HashMap getLineInAndOut(Integer concentratorId);

    /**
     * 获取施工方信息
     * @param concentratorId 集中器id
     * @return 返回查询结果
     */
    HashMap builderInfos(Integer concentratorId);

    /**
     * 查询集中器列表
     * @param page 分页参数
     * @param param 查询参数
     * @return
     */
    Result findAll(Page<IotConcentratorShowList> page, IotConcentratorListQueryParam param);

    /**
     * 根据集中器的序列号查询单灯控制器
     * @param sn 集中器序列号
     * @return
     */
    Result findSingleLightsByCSN(String sn);

    /**
     * 根据电量条件参数查询出集中器用电量情况
     * @param
     */
    List<ShowIotPower> findPower(IotPowerParam iotPowerParam,Integer id);

    /**
     * 查询未分组的集中器
     * @return
     */
    Result findNoGroup();

    /**
     * 添加集中器
     * @param addConcentratorParam 和集中器相关的参数
     * @throws NullParamException 空参数异常
     */
    void addConcentratorInfos(AddConcentratorParam addConcentratorParam) throws NullParamException;

    /**
     * 更新集中器信息
     * @param addConcentratorParam 集中器信息相关参数
     * @throws NullParamException 空参数异常
     */
    void updateConcentratorInfos(AddConcentratorParam addConcentratorParam) throws NullParamException;

    /**
     * 删除集中器信息
     * @param concentratorId 集中器id
     * @throws NullParamException 空参数异常
     */
    void deleteConcentrator(Integer concentratorId) throws NullParamException;
    /**
     * 导入单灯控制器信息
     * @param file 输入文件
     * @return 返回单灯控制器的sn
     */
    List<HashMap<String, Object>> importExcel(MultipartFile file);

    /**
     * 单灯控制器excel导入模板下载
     * @param response excel文件
     */
    void templateDownload(HttpServletResponse response);

    /**
     * 查询所有与开关策略绑定的集中集中器(组)
     * @return 与开关策略绑定集中器(组)
     */
    Result findBindConStrategy(Integer concentratorType);
}
