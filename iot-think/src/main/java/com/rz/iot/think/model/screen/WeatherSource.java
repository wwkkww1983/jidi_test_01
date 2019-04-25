package com.rz.iot.think.model.screen;

import lombok.Data;

/**
 * Author by xuxiake, Date on 2019/3/29.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
@Data
public class WeatherSource extends Source {

    // 展示天气的城市
    private String city;
    // 展示天气的城市代号
    private Integer code;
    private String html;
    private Double lineHeight;

    public WeatherSource(String id, String md5, String name, Integer left, Integer top, Integer width, Integer height, Long size, Integer playTime, Integer timeSpan, int entryEffectTimeSpan, int exitEffectTimeSpan, String entryEffectStr, String exitEffectStr, String _type, String city, Integer code, String html, Double lineHeight) {
        super(id, md5, name, left, top, width, height, size, playTime, timeSpan, entryEffectTimeSpan, exitEffectTimeSpan, entryEffectStr, exitEffectStr, _type);
        this.city = city;
        this.code = code;
        this.html = html;
        this.lineHeight = lineHeight;
    }
}
