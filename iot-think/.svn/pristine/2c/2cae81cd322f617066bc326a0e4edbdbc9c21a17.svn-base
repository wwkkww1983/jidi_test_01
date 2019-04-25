package com.rz.iot.think.model.screen;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Created by yyjuan on 2019/03/15.
 * 信息屏策略命令下发类,Task
 */
@Data
public class ProgramsTask implements Serializable{

	private static final long serialVersionUID = -1826460787972724543L;
	public String _id;					//使用UUID赋值
	public String name;					//节目名
	public List<TaskItem> items;		//命令信息

	public ProgramsTask() {
		this._id = UUID.randomUUID().toString();
		this.name = "MyTask";
	}
}
