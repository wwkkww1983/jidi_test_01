
//用户包装多行文本，多行文本使用html显示，请将调整好显示效果的html内容赋值到html属性中。
package com.rz.iot.think.model.screen;

import java.io.Serializable;

/**
 *  Created by yyjuan on 2019/03/15.
 * 多行文本
 */

public class MultiLineTextSource extends Source implements Serializable {

	private static final long serialVersionUID = 172237393557050519L;
	public int speed ;				//翻页速度？
    public float lineHeight ;		//文字行高
    public boolean center ;			//是否居中显示
    public String html ;			//html内容
    public String textAlign;		//文本对齐方式
    public String backgroundColor;	//窗口背景色
	
	//不需要对MultiLineText做任何创建或赋值操作
}
