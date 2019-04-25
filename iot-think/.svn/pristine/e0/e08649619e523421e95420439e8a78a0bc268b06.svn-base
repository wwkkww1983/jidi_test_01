package com.rz.iot.think.utils.ffmpeg;

import com.rz.iot.utils.Shell;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Author by xuxiake, Date on 2018/9/30.
 * PS: Not easy to write code, please indicate.
 * Description：获取视频缩率图
 */
@Component
public class VideoThumbnail {

    @Value("${ffmpeg_path}")
    private String ffmpegPath;

    public void thumbnail(String videoPath, String thumbnailPath){

        StringBuffer sb = new StringBuffer();
        sb.append(ffmpegPath);
        sb.append(" ");
        sb.append("-i");
        sb.append(" ");
        sb.append(videoPath);
        sb.append(" -y -f image2 -ss 02.010 -t 0.001 -s 352x240 ");
        sb.append(thumbnailPath);
        Shell.exec(sb.toString());
    }
}
