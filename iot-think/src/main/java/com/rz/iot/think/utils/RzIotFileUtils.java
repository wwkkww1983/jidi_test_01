package com.rz.iot.think.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Log4j2
@Component
public class RzIotFileUtils {

    private boolean delete(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                File files[] = file.listFiles();
                for (int i=0; i<files.length; i++) {
                    delete(files[i]);
                }
            }
            file.delete();
        } else {
            log.debug("要删除的文件[{}]不存在！", file.getName());
        }
        return true;
    }

    // 删除指定的文件或指定文件夹下的所有文件
    public boolean delete(HttpServletRequest request, String folder) {
//        String path = request.getSession().getServletContext().getRealPath("/upload/"+folder);
//        delete(new File(path));
        return true;
    }

    // 删除指定的文件或指定文件夹下的指定文件
    public boolean deletes(HttpServletRequest request, String folder) {
//        String path = request.getSession().getServletContext().getRealPath("/upload/"+folder);
//        delete(new File(path));
        return true;
    }

    private static int getFileNameStartPosition(String pathAndName) {
        int start = pathAndName.lastIndexOf('/');
        if (start<0) {
            start = pathAndName.lastIndexOf('\\');
            if (start<0) {
                start = 0;
            } else {
                start += 1;
            }
        } else {
            start += 1;
        }
        return start;
    }
    // 重命名
    public static String fileRename(String pathAndName, String fileName) {
        int start = getFileNameStartPosition(pathAndName);
        int end = pathAndName.lastIndexOf('.');
        if (end<0) {
            end = pathAndName.length();
        }
        return pathAndName.replace(pathAndName.substring(start,end), fileName);
    }

    public static String getName(String pathAndName) {
        int start = getFileNameStartPosition(pathAndName);
        int end = pathAndName.lastIndexOf('.');
        if (end<0) {
            end = pathAndName.length();
        }
        return pathAndName.substring(start,end);
    }

    public static String getFileName(String pathAndName) {
        return pathAndName.substring(getFileNameStartPosition(pathAndName));
    }

    public static String getFilePath(String pathAndName) {
        int end = pathAndName.lastIndexOf('/');
        if (end<0) {
            end = pathAndName.lastIndexOf('\\');
            if (end<0) {
                return "";
            }
        }
        return pathAndName.substring(0, end);
    }

    public static String getExtName(String fileName) {
        int end = fileName.lastIndexOf('.');
        if (end>=0) {
            return fileName.substring(end+1);
        }
        return null;
    }

    public static boolean write(String pathAndName, String content) throws IOException {
        File file = new File(pathAndName);
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();

        return true;
    }
}
