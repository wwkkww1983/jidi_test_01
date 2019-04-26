package com.rz.iot.think.model.screen;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
 * Created by yyjuan on 2019/03/15.
 * 策略时间 Items
 */

@Data
public class Schedule implements Serializable{
    
    public String name;							//事件表名字

    //时间过滤方案
    public FilterType filterType;				//如果不按月或按星期几过滤请赋值null，参考FilterType

    public DateType dateType;					//参考DateType
    
    public String startDate;					//起始日期
    
    public String endDate;						//结束日期
    
    public TimeType timeType;					//参考TimeType
    
    public String startTime;					//起始时间
    
    public String endTime;						//结束时间

    public List<Integer> weekFilter;			//Sunday=1
    //"weekFilter": [1,3, 4],  表示过滤周一、三、四

    public List<Integer> monthFilter;			//Jan=1
    
    private static final long serialVersionUID = -7546514654L;
}

