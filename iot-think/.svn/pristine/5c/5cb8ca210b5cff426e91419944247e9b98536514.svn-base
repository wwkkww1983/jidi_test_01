

/*
包装单行文本
*/
package com.rz.iot.think.model.screen;

import lombok.Data;

import java.io.Serializable;

@Data
@SuppressWarnings("deprecation")
public class SingleLineTextSource  extends Source implements Serializable {

	public int speed ;					//文字走动速度，指所有文字通过width一次的时长（单位秒）
	public String html;					//单行文本做成html形式赋值给该属性
	private Double lineHeight;

	public SingleLineTextSource(String id, String md5, String name, Integer left, Integer top, Integer width, Integer height, Long size, Integer playTime, Integer timeSpan, int entryEffectTimeSpan, int exitEffectTimeSpan, String entryEffectStr, String exitEffectStr, String _type, int speed, String html, Double lineHeight) {
		super(id, md5, name, left, top, width, height, size, playTime, timeSpan, entryEffectTimeSpan, exitEffectTimeSpan, entryEffectStr, exitEffectStr, _type);
		this.speed = speed;
		this.html = html;
		this.lineHeight = lineHeight;
	}
}
