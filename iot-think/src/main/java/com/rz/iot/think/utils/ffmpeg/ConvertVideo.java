package com.rz.iot.think.utils.ffmpeg;

import com.rz.iot.think.utils.RzIotFileUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Component
public class ConvertVideo {

    @Value("${ffmpeg_path}")
    private String ffmpegPath;

    /**
     * @param inputFile:需要转换的视频
     * @param outputFile：转换后的视频
     * @return
     */
    public boolean convert(String inputFile, String outputFile) {
        if (!checkFile(inputFile)) {
            log.debug(inputFile + " is not file");
            return false;
        }
        if (process(inputFile, outputFile)) {
            log.debug(inputFile+", 转换成功！");
            return true;
        }
        return false;
    }

    // 检查文件是否存在
    private boolean checkFile(String path) {
        File file = new File(path);
        if (!file.isFile()) {
            return false;
        }
        return true;
    }

    /**
     * @param inputFile
     * @param outputFile
     * @return
     * 转换视频文件
     */
    private boolean process(String inputFile, String outputFile) {
        int type = checkContentType(inputFile);
        boolean status = false;
        if (type == 0) {
            status = processFLV(inputFile, outputFile);// 直接将文件转为flv文件
        } else if (type == 1) {
            status = false;
        }
        return status;
    }

    private int checkContentType(String inputFile) {
        String type = inputFile.substring(inputFile.lastIndexOf(".") + 1,
                inputFile.length()).toLowerCase();
        // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
        if (type.equals("avi")) {
            return 0;
        } else if (type.equals("mpg")) {
            return 0;
        } else if (type.equals("wmv")) {
            return 0;
        } else if (type.equals("3gp")) {
            return 0;
        } else if (type.equals("mov")) {
            return 0;
        } else if (type.equals("mp4")) {
            return 0;
        } else if (type.equals("asf")) {
            return 0;
        } else if (type.equals("asx")) {
            return 0;
        } else if (type.equals("flv")) {
            return 0;
        }
        // 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等),
        // 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
        else if (type.equals("wmv9")) {
            return 1;
        } else if (type.equals("rm")) {
            return 1;
        } else if (type.equals("rmvb")) {
            return 1;
        }
        return 9;
    }
    // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）直接转换为目标视频
    private boolean processFLV(String inputFile, String outputFile) {
        if (!checkFile(inputFile)) {
            log.debug(inputFile + " is not file");
            return false;
        }
        List<String> commend = new ArrayList<String>();

        // 取视频的名称
        String ConvertFileName = RzIotFileUtils.getFileName(inputFile);
        int index = ConvertFileName.lastIndexOf('.');
        if (index > -1 && ConvertFileName.length() > index) {
            ConvertFileName = ConvertFileName.substring(0, index);
        }

        commend.add(ffmpegPath);
        commend.add("-i");
        commend.add(inputFile);
//        commend.add("-title");
//        commend.add("1111");
        commend.add("-ab");
        commend.add("128");
        commend.add("-acodec");
        commend.add("libmp3lame");
        commend.add("-ac");
        commend.add("1");
        commend.add("-ar");
        commend.add("22050");
        commend.add("-r");
        commend.add("29.97");
        commend.add("-s");
        commend.add("320X240");
        commend.add("-aspect");
        commend.add("4:3");

        //高品质
        commend.add("-qscale");
        commend.add("6");
        //低品质
//      commend.add("-b");
//      commend.add("512");



        commend.add("-y");
        commend.add(outputFile);
        StringBuffer test = new StringBuffer();
        for (int i = 0; i < commend.size(); i++) {
            test.append(commend.get(i) + " ");
        }

        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
            Process p = builder.start();
            final InputStream is1 = p.getInputStream();
            final InputStream is2 = p.getErrorStream();

            ConvertIOThread convertIOThread1 = new ConvertIOThread(is1);
            ConvertIOThread convertIOThread2 = new ConvertIOThread(is2);
            convertIOThread1.start();
            convertIOThread2.start();

            if (p.waitFor() != 0) {
                log.error("执行系统命令【"+test.toString()+"】错误,错误代码：" + p.exitValue());
                // 删除生成的文件
                new File(outputFile).delete();
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    static class ConvertIOThread extends Thread {
        private InputStream inputStream;

        public ConvertIOThread(InputStream in) {
            inputStream = in;
        }

        public void run() {
            BufferedReader br2 = new BufferedReader(
                    new InputStreamReader(inputStream));
            try {
                String line = null;
                while ((line = br2.readLine()) != null) {
                    if (line != null)
                        System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
