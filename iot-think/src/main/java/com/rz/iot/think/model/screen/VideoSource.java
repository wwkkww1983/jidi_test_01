package com.rz.iot.think.model.screen;
import lombok.Data;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by yyjuan on 2019/03/15.
 * 视频素材播放方法
 */
@Data
public class VideoSource extends Source implements Serializable{


	public VideoSource(String id, String md5, String name, Integer left, Integer top, Integer width, Integer height, Long size, Integer playTime, Integer timeSpan, int entryEffectTimeSpan, int exitEffectTimeSpan, String entryEffectStr, String exitEffectStr, String _type) {
		super(id, md5, name, left, top, width, height, size, playTime, timeSpan, entryEffectTimeSpan, exitEffectTimeSpan, entryEffectStr, exitEffectStr, _type);
	}
}
