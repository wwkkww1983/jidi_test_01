package com.rz.iot.think.model.screen;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


/**
 * Created by yyjuan on 2019/03/15.
 * 信息屏策略 Items
 */
@Data
public class TaskItem implements Serializable{

	private static final long serialVersionUID = 8498744488474009758L;
	public String _id;					//UUID
	public Program _program;			//将包装好的节目赋值给他、

	//播放过滤时间方案，设为null则没有时间过滤
	//List<Schedules>
	public List schedules;	//可以为一个program添加多个定时段

	public int priority;				//节目优先级，0为最高优先级，数字越大优先级越小；选填

	public int repeatTimes;				//重复次数，如何启用（待验证）；

	public transient int version;					//版本参见program中的version，默认为null，选填

	public TaskItem() {
		this._id = UUID.randomUUID().toString();
		this.repeatTimes = 1;
	}
}