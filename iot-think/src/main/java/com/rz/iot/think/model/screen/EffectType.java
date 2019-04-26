
/*
特效
*/
package com.rz.iot.think.model.screen;

public enum EffectType {
	None,		
	ALPHA_IN,					//淡入
	ALPHA_OUT,					//淡出
	MOVING_LEFT,				//连续左移
	MOVING_RIGHT,				//连续右移
	MOVING_TOP,					//连续上移
	MOVING_BOTTOM,				//连续下移
	ZOOM_IN,					//放大
	ZOOM_OUT,					//缩小
	ZOOM_IN_LEFT_BOTTOM,		//左下角放大
	ZOOM_IN_LEFT_TOP,			//左上角放大
	ZOOM_IN_RIGHT_TOP,			//右上角放大
	ZOOM_IN_RIGHT_BOTTOM,		//右下角放大
	ZOOM_OUT_LEFT_BOTTOM,		//左下角缩小
	ZOOM_OUT_LEFT_TOP,			//左上角缩小
	ZOOM_OUT_RIGHT_TOP,			//右上角缩小
	ZOOM_OUT_RIGHT_BOTTOM,		//右下角缩小
	ROTATE_RIGHT,				//向右旋转
	ROTATE_LEFT					//向左旋转
}
