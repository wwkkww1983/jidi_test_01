package com.rz.iot.think.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by xuxiake, Date on 2019/3/16.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
public class ExcelListener<T> extends AnalysisEventListener {

    //自定义用于暂时存储data。
    //可以通过实例获取该值
    private List<T> datas = new ArrayList<>();

    @Override
    public void invoke(Object object, AnalysisContext context) {

        T t = (T) object;
        datas.add(t);//数据存储到list，供批量处理，或后续自己业务逻辑处理。
//        doSomething(t);//根据自己业务做处理
    }
    private void doSomething(T t) {
        //1、入库调用接口
    }
    public void doAfterAllAnalysed(AnalysisContext context) {
        // datas.clear();//解析结束销毁不用的资源
    }
    public List<T> getDatas() {
        return datas;
    }
    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
