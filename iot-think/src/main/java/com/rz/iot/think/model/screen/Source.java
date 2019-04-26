package com.rz.iot.think.model.screen;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;


@SuppressWarnings("deprecation")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "_type")
@JsonSubTypes(value = { @Type(value = ImageSource.class,name="Image"),
		@Type(value = VideoSource.class, name="Video"),
		//@Type(value = ClockData.class, name="AnalogClock"),
		//@Type(value = CountdownSource.class, name="Countdown"),
		@Type(value = SingleLineTextSource.class, name="SingleLineText"),
		@Type(value = MultiLineTextSource.class, name="MultiLineText"),
		@Type(value = DigitalClockSource.class, name="DigitalClock"),
//		@Type(value = FlashSource.class, name="Flash"),
		//@Type(value = AudioSource.class, name="Audio"),
		@Type(value = WeatherSource.class, name="Weather")
})

/**
 * Created by yyjuan on 2019/03/15.
 * 素材播放方法
 */
@Data
public abstract class Source{
	public String id; 				//UUID进行赋值--》改为，此处为素材下载的拼接字符串
	
	public String md5;				//素材如果有大小需要计算它的md5
	
	public String name;				//素材名字
    
    public Integer left;				//显示在左上角的坐标
    
    public Integer top;
    
    public Integer width;				//宽高
    
    public Integer height;
    
    public Long size;				//文件大小
    
    public Integer playTime;			//起始播放时间
    
    public Integer timeSpan;			//持续播放时长

    public EffectType entryEffect;	//入场特效
    
    public int entryEffectTimeSpan; //入场特效播放时长
    
    public EffectType exitEffect;	//出场特效
    
    public int exitEffectTimeSpan;	//出场特效播放时长

    public String entryEffectStr;

    public String exitEffectStr;

    //修改属性
    //播放类型
    public String _type;
    //语言
    public String language;
    //时区
    public int timezone;

    public Source() {
    }

    public Source(String id, String md5, String name, Integer left, Integer top, Integer width, Integer height, Long size, Integer playTime, Integer timeSpan, int entryEffectTimeSpan, int exitEffectTimeSpan, String entryEffectStr, String exitEffectStr, String _type) {
        this.id = id;
        this.md5 = md5;
        this.name = name;
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
        this.size = size;
        this.playTime = playTime;
        this.timeSpan = timeSpan;
        this.entryEffectTimeSpan = entryEffectTimeSpan;
        this.exitEffectTimeSpan = exitEffectTimeSpan;
        this.entryEffectStr = entryEffectStr;
        this.exitEffectStr = exitEffectStr;
        this._type = _type;
        this.entryEffect = EffectType.valueOf(entryEffectStr);
        this.exitEffect = EffectType.valueOf(exitEffectStr);
        this.language = "en";
        this.timezone = 8;
    }
}
