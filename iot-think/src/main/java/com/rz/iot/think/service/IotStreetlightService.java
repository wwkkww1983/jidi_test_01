package com.rz.iot.think.service;

import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.StreetlightSwitch;
import com.rz.iot.think.model.param.IotStreetlightAddParam;
import com.rz.iot.think.model.param.IotStreetlightDelParam;
import com.rz.iot.think.model.param.IotStreetlightListQueryParam;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.web.multipart.MultipartFile;
import com.rz.iot.think.model.show.GISConcentratorList;
import com.rz.iot.think.model.show.GISStreetlightShowList;
import com.rz.iot.think.model.show.IotStreetlightShowDetail;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * Author by xuxiake, Date on 2019/3/13.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
public interface IotStreetlightService {

    /**
     * 获取单灯调光页面所必须的信息列表
     * @return 返回查询结果
     */
    Result findAll(Page page, IotStreetlightListQueryParam param);

    /**
     * 路灯详情
     * @param streetlightId
     * @return
     */
    Result detail(Integer streetlightId);

    /**
     * 获取单灯调光页面所必须的信息列表
     * @return 返回查询结果
     */
    List<StreetlightSwitch> getSlcSwitchLightInfoList(HashMap map);

    /**
     * 增加路灯
     * @param param
     * @return
     */
    Result add(IotStreetlightAddParam param);

    /**
     * 删除路灯
     * @param streetlightIds 路灯ids
     * @return
     */
    Result del(List<Integer> streetlightIds);

    /**
     * 更新路灯信息
     * @param param
     * @return
     */
    Result update(IotStreetlightAddParam param);

    /**
     * excel导出
     * @param response
     */
    void exportExl(HttpServletResponse response);

    /**
     * excel批量导入
     * @param file
     * @return
     */
    Result importExl(MultipartFile file);

    /**
     * excel导入模板下载
     * @param response
     */
    void templateDownload(HttpServletResponse response);

    /**
     * 查询GIS地图页面的路灯信息
     * @param param 查询参数
     * @return 返回查询结果
     */
    List<GISStreetlightShowList> getStreetlightInGis(HashMap param);

    /**
     * 查询某片区域的集中器信息，查询参数与
     * @see IotStreetlightService#getStreetlightInGis( HashMap param) 一致
     * @param param 查询参数
     * @return 返回查询结果
     */
    List<GISConcentratorList> getConcentratorListInGIS(HashMap param);

    /**
     * 通过id查询详细的路灯信息
     * @param streetlightId 路灯id
     * @return 查询结果
     */
    IotStreetlightShowDetail findById(Integer streetlightId);

    /**
     * 查询区id和道路id
     * @return 返回查询结果
     */
    HashMap getDistrictIdAndRoadId();

    /**
     * 获取路灯挂载的故障设备的信息列表
     *
     * @return 返回查询结果
     */
    List<HashMap> getStreetlightFaults();

    /**
     * 查找未与路灯绑定的单灯控制器
     * @return
     */
    Result findNoBindingWithStreetLight();
}
