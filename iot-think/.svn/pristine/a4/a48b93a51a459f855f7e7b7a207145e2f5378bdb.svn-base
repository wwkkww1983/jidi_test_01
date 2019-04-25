
package com.rz.iot.think.model.screen;

import lombok.Data;

import java.util.UUID;

/**
 * Created by yyjuan on 2019/03/15.
 * 信息屏策略下发汇总类
 */
@Data
public class Command{
	public String _type ;
	public  String id ;
	//文件下载url = preDownloadURL + source.id
	public String preDownloadURL ;
	//返回节目下载进度的url
	public String notificationURL ;
	//需要播放的task内容
	public ProgramsTask task;

	public Command() {
		this.id = UUID.randomUUID().toString();
	}
}


