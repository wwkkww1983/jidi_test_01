
package com.rz.iot.think.model.screen;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
 * Created by yyjuan on 2019/03/15.
 * 时间轴和对应播放效果
 */
@Data
public class Layer implements Serializable{

	/**
	 * 一个时间轴对应一个source
	 */
	public List sources;   //素材都需要加入到这个list里面

	//一般设为false,节目效果最好
	public boolean repeat;			//如果该值为false，它会在播放时长到达后结束播放，否则他会循环播放直到list中最长的那个layer播放结束时结束播放
	private static final long serialVersionUID = -234242314654L;

	public Layer() {
		this.repeat = false;
	}
}
