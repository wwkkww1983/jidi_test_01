package com.rz.iot.think.model.screen;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by yyjuan on 2019/03/15.
 * 包装节目的类
 */
@Data
public class Program implements Serializable{
	@JsonProperty("_id")
	public String  _id;					//请使用UUID赋值
	public String name;					//好记的名字
	public int width;					//节目宽，一般设为显示屏分辨率
	public int height;					//节目高，一般设为显示屏分辨率
	public long totalSize;				//将layers中的sources的size累加赋值给他，表示节目所有素材占用的空间

	//素材及摆放位置
	public List<Layer> layers;			//所有素材都包含在该list中

	//默认设为null，由播放策略统一设置时间过滤方法
	public List<Schedule> schedules;	//定时播放的时刻表

	public Program() {
		this._id = UUID.randomUUID().toString();
	}
}
