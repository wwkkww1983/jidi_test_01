package com.rz.iot.think.utils;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author by xuxiake, Date on 2019/3/16.
 * PS: Not easy to write code, please indicate.
 * Description：excel导入导出工具类
 */
public class ExcelUtils {

    /**
     * excel导出（写excel）
     * @param out 输出流
     * @param data 数据
     * @param headLineMun 表头占的行数
     * @param columnWidth 列宽
     * @param clazz 模型Class
     * @param <T> 泛型
     */
    public static <T extends BaseRowModel> void writeExl(OutputStream out, List<T> data, Integer headLineMun, Integer columnWidth, Class<T> clazz) {

        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
        //写第一个sheet, sheet1
        Sheet sheet1 = new Sheet(1, headLineMun, clazz);
        sheet1.setSheetName("Sheet1");

        Map columnWidthMap = new HashMap();

        for (int i = 0; i < headLineMun; i++) {
            columnWidthMap.put(i, columnWidth);
        }
        // 设置列宽 设置每列的宽度
        sheet1.setColumnWidthMap(columnWidthMap);
        //or 设置自适应宽度
        //sheet1.setAutoWidth(Boolean.TRUE);

        writer.write(data, sheet1);
        writer.finish();
    }

    /**
     *
     * excel导入（读取excel）
     * @param in 输入流
     * @param headLineMun 表头占的行数
     * @param clazz 模型Class
     * @param <T> 泛型
     * @return
     */
    public static <T extends BaseRowModel> List<T> readExl(InputStream in, Integer headLineMun, Class<T> clazz) {

        // 解析每行结果在listener中处理
        ExcelListener listener = new ExcelListener<T>();

        ExcelReader excelReader = new ExcelReader(in, ExcelTypeEnum.XLSX, null, listener);
        Sheet sheet1 = new Sheet(1, headLineMun, clazz);
        excelReader.read(sheet1);
        List<T> datas = listener.getDatas();
        return datas;
    }
}
