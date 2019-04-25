package com.rz.iot.think.handler;

import com.rz.iot.think.mapper.screen.IotScreenVideoInfoMapper;
import com.rz.iot.think.model.screen.IotScreenVideoInfo;
import com.rz.iot.think.utils.FastDFSUtils;
import com.rz.iot.think.utils.PropertiesUtil;
import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.*;
import java.util.UUID;

/**
 * @Author:jidi
 * @Date:2019/04/08 16:22
 * @Description:素材上传线程
 **/
public class IotScreenMaterialUploadThread implements Runnable {

    private IotScreenVideoInfoMapper iotScreenVideoInfoMapper;
    private IotScreenVideoInfo iotScreenVideoInfo;
    private String localConvertUrl;

    public IotScreenMaterialUploadThread() {
    }

    public IotScreenMaterialUploadThread(IotScreenVideoInfoMapper iotScreenVideoInfoMapper, IotScreenVideoInfo iotScreenVideoInfo, String localConvertUrl) {
        this.iotScreenVideoInfoMapper = iotScreenVideoInfoMapper;
        this.iotScreenVideoInfo = iotScreenVideoInfo;
        this.localConvertUrl = localConvertUrl;
    }

    @Override
    public void run() {
        try{
            //转码文件上传到服务器
            File convertFile = new File(localConvertUrl);
            //转码文件的名字
            String convertFileName = convertFile.getName();
            //转码文件后缀名
            String convertFileExtName = convertFileName.substring(convertFileName.lastIndexOf(".") + 1, convertFileName.length());
            FileInputStream in = new FileInputStream(convertFile);
            BufferedInputStream b = new BufferedInputStream(in);
            ByteArrayOutputStream bao = new ByteArrayOutputStream(1024);
            byte[] byt = new byte[1024];
            int length = -1;
            while((length = b.read(byt)) != -1) {
                bao.write(byt, 0, length);
            }
            FastDFSUtils fastDFSUtils2 = new FastDFSUtils("classpath:FastDFS.properties");
            String path2 = fastDFSUtils2.uploadFile(bao.toByteArray(), convertFileExtName);
            String fdfsNginxServer2 = PropertiesUtil.getProperty("FastDFS.properties", "fdfs_nginx_server");
            String convertUrl = fdfsNginxServer2 + "/" + path2;

            //关闭流
            in.close();
            b.close();
            bao.close();

            //视频转码后的地址
            iotScreenVideoInfo.setConvertUrl(convertUrl);
        }catch (Exception e){
            e.printStackTrace();
        }

        //更新视频转码后的地址
        iotScreenVideoInfoMapper.updateConvertUrl(iotScreenVideoInfo);
    }

    public IotScreenVideoInfoMapper getIotScreenVideoInfoMapper() {
        return iotScreenVideoInfoMapper;
    }

    public IotScreenVideoInfo getIotScreenVideoInfo() {
        return iotScreenVideoInfo;
    }

    public void setIotScreenVideoInfoMapper(IotScreenVideoInfoMapper iotScreenVideoInfoMapper) {
        this.iotScreenVideoInfoMapper = iotScreenVideoInfoMapper;
    }

    public void setIotScreenVideoInfo(IotScreenVideoInfo iotScreenVideoInfo) {
        this.iotScreenVideoInfo = iotScreenVideoInfo;
    }

    public String getConvertUrl() {
        return localConvertUrl;
    }

    public void setConvertUrl(String localConvertUrl) {
        this.localConvertUrl = localConvertUrl;
    }
}
