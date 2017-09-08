package com.qimon.commonlibrary.gesture

import android.view.MotionEvent

/**
 * Created by Administrator on 2017/9/8.
 */
class ZGesture(gesture: OnGesture) {
    private val mGestureInterface by lazy { gesture }
    private val DOUBLE_TIME = 100
    /**
     * 用这个来标记是单击还是双击
     * mIndex%2==0代表单击否则双击
     * */
    private var mIndex: Int = 1.unaryMinus()

    private var mLastTime: Long = 0L

    /**
     * 通过这个接口，得到触摸事件
     * */
    fun onTouchEvent(event: MotionEvent): Boolean {
        return doEvent(event)
    }

    private var downX = 0f
    private var downY = 0f

    private fun doEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                downX = event.x
                downY = event.y
                if (mIndex < (0)) mIndex = 0//说明没有点击过
                mIndex.inc()
                if (mIndex.rem(2).equals(1)) mLastTime = System.currentTimeMillis()
            }
            MotionEvent.ACTION_MOVE -> {
            }
            MotionEvent.ACTION_UP -> {
                //单双击的漂移，最多10dp

            }
        }
        return true
    }


    interface OnGesture {
    }
}