
/*
这个类型用来包装一个图片素材，除了png，bmp，jpg文件，同时可以包装gif
*/

package com.rz.iot.think.model.screen;


import lombok.Data;

import java.io.Serializable;


/**
 * Created by yyjuan on 2019/03/15.
 * 图片素材播放
 */
@Data
public class ImageSource extends Source implements Serializable{
	public String mime;		//包装gif图片时赋值"image/gif"，否则填入任意其他字符串，不要为null

	public ImageSource(String id, String md5, String name, Integer left, Integer top, Integer width, Integer height, Long size, Integer playTime, Integer timeSpan, int entryEffectTimeSpan, int exitEffectTimeSpan, String entryEffectStr, String exitEffectStr, String _type, String mime) {
		super(id, md5, name, left, top, width, height, size, playTime, timeSpan, entryEffectTimeSpan, exitEffectTimeSpan, entryEffectStr, exitEffectStr, _type);
		this.mime = mime;
	}
}
