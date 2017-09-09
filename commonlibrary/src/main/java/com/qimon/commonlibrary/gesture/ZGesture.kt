package com.qimon.commonlibrary.gesture

import android.util.Log
import android.view.MotionEvent

/**
 * Created by Administrator on 2017/9/8.
 */
class ZGesture(gesture: OnGesture?) {
    private val TAG = ZGesture::class.java.name
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
                Log.e(TAG, "down:${event.x},${event.y}")
                downX = event.x
                downY = event.y
                if (mIndex < (0)) mIndex = 0//说明没有点击过
                mIndex.inc()
                if (mIndex.rem(2) == 1) mLastTime = System.currentTimeMillis()
            }
            MotionEvent.ACTION_MOVE -> {
            }
            MotionEvent.ACTION_UP -> {
                //单双击的漂移，最多10dp
                Log.e(TAG, "当前index:$mIndex")
                if (Math.abs(downX.minus(event.x)) < 10 && Math.abs(downY.minus(event.y)) < 10) {
                    if (mIndex.rem(2) == 0) mGestureInterface?.onDoubleUp()
                    else mGestureInterface?.onSingleUp()
                } else {

                }
            }
        }
        return true
    }


    interface OnGesture {
        fun onUp() {}
        fun onSingleUp() {}
        fun onDoubleUp() {}
    }
}