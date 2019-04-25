package com.rz.iot.think.model.screen;

import lombok.Data;

/**
 * Author by xuxiake, Date on 2019/3/29.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
@Data
public class DigitalClockSource extends Source {

    private Double lineHeight;

    private String html;

    public DigitalClockSource(String id, String md5, String name, Integer left, Integer top, Integer width, Integer height, Long size, Integer playTime, Integer timeSpan, int entryEffectTimeSpan, int exitEffectTimeSpan, String entryEffectStr, String exitEffectStr, String _type, Double lineHeight, String html) {
        super(id, md5, name, left, top, width, height, size, playTime, timeSpan, entryEffectTimeSpan, exitEffectTimeSpan, entryEffectStr, exitEffectStr, _type);
        this.lineHeight = lineHeight;
        this.html = html;
    }
}
