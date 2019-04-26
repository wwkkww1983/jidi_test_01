package com.rz.iot.think.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rz.iot.think.mapper.IotScreenMapper;
import com.rz.iot.think.mapper.screen.*;
import com.rz.iot.think.model.IotScreen;
import com.rz.iot.think.model.Page;
import com.rz.iot.think.model.Result;
import com.rz.iot.think.model.UserInfo;
import com.rz.iot.think.model.param.IotScreenPlayStrategyAddParam;
import com.rz.iot.think.model.param.IotScreenPlayStrategyListQueryParam;
import com.rz.iot.think.model.screen.*;
import com.rz.iot.think.model.show.*;
import com.rz.iot.think.service.IotBusinessUserRelService;
import com.rz.iot.think.service.IotScreenPlayStrategyService;
import com.rz.iot.think.service.IotScreenProgramService;
import com.rz.iot.think.utils.FastDFSUtils;
import com.rz.iot.think.utils.PropertiesUtil;
import com.rz.iot.think.utils.RzIotDBConstParam;
import com.rz.iot.think.websocket.screen.ScreenSendHandler;
import com.rz.iot.utils.RzIotDatetime;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: yyjuan
 * @Date: 2019/3/22 0022 11:08
 * @Description:
 */
@Service
@Slf4j
public class IotScreenPlayStrategyServiceImpl implements IotScreenPlayStrategyService {

    @Value("${screen.preDownloadURL}")
    public String preDownloadURL;
    @Value("${screen.notificationURL}")
    public String notificationURL;
    @Resource
    private IotScreenPlayStrategyMapper iotScreenPlayStrategyMapper;
    @Resource
    private IotScreenProgramService iotScreenProgramService;
    @Resource
    private ScreenSendHandler screenSendHandler;
    @Resource
    private IotScreenMaterialKeyRelMapper iotScreenMaterialKeyRelMapper;
    @Resource
    private IotScreenVideoInfoMapper iotScreenVideoInfoMapper;
    @Resource
    private IotScreenPicInfoMapper iotScreenPicInfoMapper;
    @Resource
    private IotScreenPlayStrategyCommandRelMapper iotScreenPlayStrategyCommandRelMapper;
    @Resource
    private IotScreenMapper iotScreenMapper;
    @Resource
    private IotBusinessUserRelService iotBusinessUserRelService;
    @Resource
    private IotScreenProgramInfoMapper iotScreenProgramInfoMapper;
    @Resource
    private IotScreenPlayStrategyRelMapper iotScreenPlayStrategyRelMapper;

    /**
     * 信息屏播放详情
     * @param playStrategyId 策略id
     * @return
     */
    @Override
    public Result detail(Integer playStrategyId) {

        Result result = new Result();
        if (playStrategyId == null) {
            return Result.paramNull(result);
        }

        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        // 鉴权
        IotScreenProgramInfo programInfo = iotScreenProgramInfoMapper.findByStrategyId(playStrategyId);

        if (programInfo != null) {
            boolean authorized = iotBusinessUserRelService.isAuthorized(programInfo.getId(), RzIotDBConstParam.BUSSINESS_TYPE_OF_SCREEN_PROGRAM, userInfo.getId());
            if (!authorized) {
                return Result.unAuthorized(result);
            }
        } else {
            return Result.unAuthorized(result);
        }

        IotScreenPlayStrategyShowDetail playStrategy = iotScreenPlayStrategyMapper.detail(playStrategyId);

        List<IotScreenShowSendStatus> screens = iotScreenPlayStrategyCommandRelMapper.findScreenByStrategyId(playStrategyId);

        playStrategy.setScreens(screens);
        playStrategy.setProgramInfo(programInfo);

        result.setData(playStrategy);

        return result;
    }

    /**
     * 下发信息屏播放策略
     * @param strategyId 策略id
     * @return
     */
    @Transactional
    @Override
    public Result sendStrategy(Integer strategyId) {

        Result result = new Result();

        if (strategyId == null) {
            return Result.paramNull(result);
        }

        IotScreenPlayStrategy iotScreenPlayStrategy = iotScreenPlayStrategyMapper.selectByPrimaryKey(strategyId);
        // 节目id
        Integer programId = iotScreenPlayStrategy.getProgramId();

        IotScreenProgramInfoShowDetail programInfo = (IotScreenProgramInfoShowDetail) iotScreenProgramService.programDetail(programId).getData();

        // layers
        List<Layer> layers = new ArrayList<>();
        List<IotScreenProgramLayer> programLayers = programInfo.getProgramLayers();
        for (IotScreenProgramLayer programLayer : programLayers) {

            Source source = null;
            if (programLayer instanceof IotScreenProgramVideoLayer) {
                IotScreenProgramVideoLayer programVideoLayer = (IotScreenProgramVideoLayer) programLayer;
                IotScreenVideoSource videoSource = programVideoLayer.getSource();

                source = new VideoSource(
                        videoSource.getId(),
                        videoSource.getMd5(),
                        videoSource.getName(),
                        videoSource.getLeft(),
                        videoSource.getTop(),
                        videoSource.getWidth(),
                        videoSource.getHeight(),
                        videoSource.getSize(),
                        videoSource.getPlayTime(),
                        videoSource.getTimeSpan(),
                        videoSource.getEntryEffectTimeSpan(),
                        videoSource.getExitEffectTimeSpan(),
                        videoSource.getEntryEffectStr(),
                        videoSource.getExitEffectStr(),
                        videoSource.getType());

            } else if (programLayer instanceof IotScreenProgramImageLayer) {

                IotScreenProgramImageLayer programImageLayer = (IotScreenProgramImageLayer) programLayer;
                IotScreenImageSource imageSource = programImageLayer.getSource();

                source = new ImageSource(
                        imageSource.getId(),
                        imageSource.getMd5(),
                        imageSource.getName(),
                        imageSource.getLeft(),
                        imageSource.getTop(),
                        imageSource.getWidth(),
                        imageSource.getHeight(),
                        imageSource.getSize(),
                        imageSource.getPlayTime(),
                        imageSource.getTimeSpan(),
                        imageSource.getEntryEffectTimeSpan(),
                        imageSource.getExitEffectTimeSpan(),
                        imageSource.getEntryEffectStr(),
                        imageSource.getExitEffectStr(),
                        imageSource.getType(),
                        "");

            } else if (programLayer instanceof IotScreenProgramSingleLineTextLayer) {
                IotScreenProgramSingleLineTextLayer singleLineTextLayer = (IotScreenProgramSingleLineTextLayer) programLayer;
                IotScreenLineTextSource lineTextSource = singleLineTextLayer.getSource();

                source = new SingleLineTextSource(
                        lineTextSource.getId(),
                        null,
                        lineTextSource.getName(),
                        lineTextSource.getLeft(),
                        lineTextSource.getTop(),
                        lineTextSource.getWidth(),
                        lineTextSource.getHeight(),
                        null,
                        lineTextSource.getPlayTime(),
                        lineTextSource.getTimeSpan(),
                        lineTextSource.getEntryEffectTimeSpan(),
                        lineTextSource.getExitEffectTimeSpan(),
                        lineTextSource.getEntryEffectStr(),
                        lineTextSource.getExitEffectStr(),
                        lineTextSource.getType(),
                        lineTextSource.getSpeed(),
                        lineTextSource.getHtml(),
                        lineTextSource.getLineHeight());

            } else if (programLayer instanceof IotScreenProgramDigitalClockLayer) {
                IotScreenProgramDigitalClockLayer digitalClockLayer = (IotScreenProgramDigitalClockLayer) programLayer;
                IotScreenDigitalClockSource digitalClockSource = digitalClockLayer.getSource();

                source = new DigitalClockSource(
                        digitalClockSource.getId(),
                        null,
                        digitalClockSource.getName(),
                        digitalClockSource.getLeft(),
                        digitalClockSource.getTop(),
                        digitalClockSource.getWidth(),
                        digitalClockSource.getHeight(),
                        null,
                        digitalClockSource.getPlayTime(),
                        digitalClockSource.getTimeSpan(),
                        digitalClockSource.getEntryEffectTimeSpan(),
                        digitalClockSource.getExitEffectTimeSpan(),
                        digitalClockSource.getEntryEffectStr(),
                        digitalClockSource.getExitEffectStr(),
                        digitalClockSource.getType(),
                        digitalClockSource.getLineHeight(),
                        digitalClockSource.getHtml());

            } else if (programLayer instanceof IotScreenProgramWeatherLayer) {
                IotScreenProgramWeatherLayer weatherLayer = (IotScreenProgramWeatherLayer) programLayer;
                IotScreenWeatherSource weatherSource = weatherLayer.getSource();

                source = new WeatherSource(
                        weatherSource.getId(),
                        null,
                        weatherSource.getName(),
                        weatherSource.getLeft(),
                        weatherSource.getTop(),
                        weatherSource.getWidth(),
                        weatherSource.getHeight(),
                        null,
                        weatherSource.getPlayTime(),
                        weatherSource.getTimeSpan(),
                        weatherSource.getEntryEffectTimeSpan(),
                        weatherSource.getExitEffectTimeSpan(),
                        weatherSource.getEntryEffectStr(),
                        weatherSource.getExitEffectStr(),
                        weatherSource.getType(),
                        weatherSource.getCity(),
                        weatherSource.getCode(),
                        weatherSource.getHtml(),
                        weatherSource.getLineHeight());

            }
            Layer layer = new Layer();
            List<Source> sources = new ArrayList<>();
            sources.add(source);
            layer.setSources(sources);
            layers.add(layer);
        }

        // program

        Program program = new Program();
        program.setName(programInfo.getName());
        program.setWidth(programInfo.getWidth());
        program.setHeight(programInfo.getHeight());
        program.setTotalSize(programInfo.getTotalSize());
        program.setLayers(layers);

        // schedule

        Schedule schedule = new Schedule();

        if (!StringUtils.isEmpty(iotScreenPlayStrategy.getWeekfilter())) {
            schedule.setWeekFilter(RzIotDatetime.getPlayWeek(iotScreenPlayStrategy.getWeekfilter()));
            schedule.setFilterType(FilterType.Week);
        }
        schedule.setDateType(DateType.Range);
        schedule.setTimeType(TimeType.Range);
        schedule.setStartDate(RzIotDatetime.dateToString(iotScreenPlayStrategy.getStartDate(), "yyyy-MM-dd"));
        schedule.setEndDate(RzIotDatetime.dateToString(iotScreenPlayStrategy.getEndDate(), "yyyy-MM-dd"));
        schedule.setStartTime(RzIotDatetime.dateToString(iotScreenPlayStrategy.getStartTime(), "HH:mm"));
        schedule.setEndTime(RzIotDatetime.dateToString(iotScreenPlayStrategy.getEndTime(), "HH:mm"));

        List<Schedule> schedules = new ArrayList<>();
        schedules.add(schedule);

        // taskItem
        TaskItem taskItem = new TaskItem();
        taskItem.set_program(program);
        taskItem.setSchedules(schedules);

        // task
        List<TaskItem> items = new ArrayList<>();
        items.add(taskItem);
        ProgramsTask programsTask = new ProgramsTask();
        programsTask.setItems(items);

        // command
        String commandNo = UUID.randomUUID().toString();
        Command command = new Command();
        command.set_type("PlayXixunTask");
        command.setNotificationURL(notificationURL);
        command.setPreDownloadURL(preDownloadURL);
        command.setTask(programsTask);
        command.setId(commandNo);

        // 判断是否是重复发送
        List<IotScreenShowSendStatus> screens = iotScreenPlayStrategyCommandRelMapper.findScreenByStrategyId(strategyId);
        if (screens != null && screens.size() > 0) {
            // 删除已保存的记录
            iotScreenPlayStrategyCommandRelMapper.delByStrategyId(strategyId);
        }

        List<IotScreenPlayStrategyRel> iotScreenPlayStrategyRels = iotScreenPlayStrategyRelMapper.findByStrategyId(strategyId);

        List<IotScreenPlayStrategyCommandRel> iotScreenPlayStrategyCommandRels = new ArrayList<>();
        List<String> cardIds = new ArrayList<>();
        for (IotScreenPlayStrategyRel item : iotScreenPlayStrategyRels) {

            IotScreenPlayStrategyCommandRel iotScreenPlayStrategyCommandRel = new IotScreenPlayStrategyCommandRel();
            iotScreenPlayStrategyCommandRel.setScreenId(item.getScreenId());
            iotScreenPlayStrategyCommandRel.setPlayStrategyId(strategyId);
            iotScreenPlayStrategyCommandRel.setCommandNo(commandNo);
            iotScreenPlayStrategyCommandRel.setStatus(RzIotDBConstParam.SCREEN_PLAY_STRATEGY_SEND_STATUS_OF_SENDING);
            iotScreenPlayStrategyCommandRels.add(iotScreenPlayStrategyCommandRel);

            IotScreen screen = iotScreenMapper.selectByPrimaryKey(item.getScreenId());
            cardIds.add(screen.getSn());
        }

        iotScreenPlayStrategyCommandRelMapper.insertBatch(iotScreenPlayStrategyCommandRels);

        for (String cardId : cardIds) {

            screenSendHandler.commandXixunPlayer(cardId, command, strategyId);
        }

        return result;
    }

    /**
     * 信息屏下载素材的接口
     * @param key
     * @param response
     */
    @Override
    public void downloadMaterial(String key, HttpServletResponse response) {
        IotScreenMaterialKeyRel iotScreenMaterialKeyRel = iotScreenMaterialKeyRelMapper.selectByKey(key);
        Integer materialType = iotScreenMaterialKeyRel.getMaterialType();
        Integer materialId = iotScreenMaterialKeyRel.getMaterialId();

        String fdfsNginxServer = PropertiesUtil.getProperty("FastDFS.properties", "fdfs_nginx_server");
        String filePath = "";
        if (materialType == RzIotDBConstParam.MATERTAL_TYPE_OF_PICTURE) {
            IotScreenPicInfo iotScreenPicInfo = iotScreenPicInfoMapper.selectByPrimaryKey(materialId);
            String picUrl = iotScreenPicInfo.getPicUrl();
            filePath = picUrl.split(fdfsNginxServer + "/")[1];
        } else if (materialType == RzIotDBConstParam.MATERTAL_TYPE_OF_VIDEO) {
            IotScreenVideoInfo iotScreenVideoInfo = iotScreenVideoInfoMapper.selectByPrimaryKey(materialId);
            String videoUrl = iotScreenVideoInfo.getVideoUrl();
            filePath = videoUrl.split(fdfsNginxServer + "/")[1];
        }

        OutputStream out = null;
        BufferedInputStream bis = null;
        try {
            InputStream is = FastDFSUtils.getInputStream(filePath);
            out = response.getOutputStream();
            IOUtils.copy(is, out);
        } catch (Exception e) {
            log.error("文件下载失败", e);
        } finally {
            try {
                if (bis!=null) {
                    // 关闭文件输入流
                    bis.close();
                }
                if (out!=null) {
                    // 关闭输出流
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 屏幕策略列表
     * @param page 分页参数
     * @param param 查询参数
     * @return
     */
    @Override
    public Result findList(Page page, IotScreenPlayStrategyListQueryParam param) {

        Result result = new Result();
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<IotScreenPlayStrategyShowList> list = iotScreenPlayStrategyMapper.findList(userInfo.getId(), param);
        PageInfo<IotScreenPlayStrategyShowList> pageInfo = new PageInfo<>(list);

        for (IotScreenPlayStrategyShowList item : list) {
            List<IotScreenShowSendStatus> screens = iotScreenPlayStrategyCommandRelMapper.findScreenByStrategyId(item.getId());
            item.setScreens(screens);
        }
        page.setOtherParam(pageInfo);
        result.setData(page);
        return result;
    }

    /**
     * 获取xixunplay下载进度
     * @param param
     */
    @Transactional
    @Override
    public void getDownloadProgress(DownloadProgressModel param) {

        String commandId = param.getCommandId();
        Integer progress = param.getProgress();
        if (progress.intValue() == 100) {
            List<IotScreenPlayStrategyCommandRel> iotScreenPlayStrategyCommandRels = iotScreenPlayStrategyCommandRelMapper.findByCommandNo(commandId);
            if (iotScreenPlayStrategyCommandRels != null && iotScreenPlayStrategyCommandRels.size() > 0) {
                IotScreenPlayStrategyCommandRel iotScreenPlayStrategyCommandRel = iotScreenPlayStrategyCommandRels.get(0);
                Integer playStrategyId = iotScreenPlayStrategyCommandRel.getPlayStrategyId();
                IotScreenProgramInfo programInfo = iotScreenProgramInfoMapper.findByStrategyId(playStrategyId);
                if (programInfo.getStatus() != RzIotDBConstParam.MATERIAL_STATUS_OF_HAVING_DOWNLOADED) {

                    programInfo.setStatus(RzIotDBConstParam.MATERIAL_STATUS_OF_HAVING_DOWNLOADED);
                    iotScreenProgramInfoMapper.updateByPrimaryKeySelective(programInfo);
                }
            }
        }
    }

    /**
     * 删除播放策略
     * @param strategyId 策略id
     * @return
     */
    @Transactional
    @Override
    public Result del(Integer strategyId) {

        Result result = new Result();
        if (strategyId == null) {
            return Result.paramNull(result);
        }

        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        // 鉴权
        IotScreenProgramInfo programInfo = iotScreenProgramInfoMapper.findByStrategyId(strategyId);

        if (programInfo != null) {
            boolean authorized = iotBusinessUserRelService.isAuthorized(programInfo.getId(), RzIotDBConstParam.BUSSINESS_TYPE_OF_SCREEN_PROGRAM, userInfo.getId());
            if (!authorized) {
                return Result.unAuthorized(result);
            }
        } else {
            return Result.unAuthorized(result);
        }

        // 删除策略屏幕关联关系
        iotScreenPlayStrategyRelMapper.delByStrategyId(strategyId);

        // 删除策略
        IotScreenPlayStrategy iotScreenPlayStrategy = new IotScreenPlayStrategy();
        iotScreenPlayStrategy.setStatus(RzIotDBConstParam.DATA_STATUS_OF_DELETE);
        iotScreenPlayStrategyMapper.updateByPrimaryKeySelective(iotScreenPlayStrategy);

        // 关联节目不删除

        return result;
    }

    /**
     * 停止播放
     * @param playStrategyId 策略id
     * @param operation 0：停止；1：播放
     * @return
     */
    @Override
    public Result stopPlayer(Integer playStrategyId, Integer operation) {

        Result result = new Result();
        if (playStrategyId == null) {
            return Result.paramNull(result);
        }
        if (operation == null) {
            operation = RzIotDBConstParam.SCREEN_STOP_PLAYER_OF_STOP;
        }
        Boolean flag = operation == RzIotDBConstParam.SCREEN_STOP_PLAYER_OF_STOP ? true : false;

        List<IotScreenShowSendStatus> screens = iotScreenPlayStrategyCommandRelMapper.findScreenByStrategyId(playStrategyId);
        for (IotScreenShowSendStatus screen : screens) {
            screenSendHandler.stopPlayer(screen.getSn(), flag);
        }
        return result;
    }

    /**
     * 新增策略
     * @param param
     * @return
     */
    @Override
    public Result add(IotScreenPlayStrategyAddParam param) {

        Result result = new Result();
        if (param.getScreenIds() == null || param.getScreenIds().size() == 0) {
            return Result.paramNull(result);
        }
        // 增加策略
        IotScreenPlayStrategy screenPlayStrategy = new IotScreenPlayStrategy();
        screenPlayStrategy.setName(param.getName());
        screenPlayStrategy.setStartDate(param.getStartDate());
        screenPlayStrategy.setEndDate(param.getEndDate());
        screenPlayStrategy.setWeekfilter(param.getWeekfilter());
        screenPlayStrategy.setStartTime(param.getStartTime());
        screenPlayStrategy.setEndTime(param.getEndTime());
        screenPlayStrategy.setProgramId(param.getProgramId());

        iotScreenPlayStrategyMapper.insertSelective(screenPlayStrategy);

        // 增加策略屏幕关联
        List<IotScreenPlayStrategyRel> iotScreenPlayStrategyRels = new ArrayList<>();
        for (Integer screenId : param.getScreenIds()) {
            IotScreenPlayStrategyRel iotScreenPlayStrategyRel = new IotScreenPlayStrategyRel();
            iotScreenPlayStrategyRel.setPlayStrategyId(screenPlayStrategy.getId());
            iotScreenPlayStrategyRel.setScreenId(screenId);
            iotScreenPlayStrategyRels.add(iotScreenPlayStrategyRel);
        }
        iotScreenPlayStrategyRelMapper.insertBatch(iotScreenPlayStrategyRels);

        return result;
    }
}
