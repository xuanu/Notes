package com.qimon.commonlibrary.gesture

import android.content.Context
import android.os.Handler
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import com.qimon.commonlibrary.utils.WeakHandler
import kotlinx.coroutines.experimental.async

/**
 * Created by Administrator on 2017/9/8.
 * 对手势事件进行封装，有上下左右，单击，双击，长按，move,pressed,up
 *
 * 如果发现onFling没有回调，请设置View.setLongClickable(true)
 */
class ZGesture(context: Context, gesture: OnGesture?) {
    private val mGestureInterface by lazy { gesture }
    private val mContext by lazy { context }
    /**
     * 通过这个接口，得到触摸事件
     * */
    fun onTouchEvent(event: MotionEvent): Boolean {
        return doGesture(event)
    }

    private var mPoints = Points(0f, 0f)
    private val mDoubleRun by lazy { DoubleRunnable(mGestureInterface) }
    private val mLongPrRun = LongPreRunnable()

    private fun doGesture(event: MotionEvent): Boolean {
        when (event.action and MotionEvent.ACTION_MASK) {
            MotionEvent.ACTION_DOWN -> {
                mPoints.x1 = event.x
                mPoints.y1 = event.y
                mGestureInterface?.onDown()
                WeakHandler(mContext.mainLooper).removeCallbacks(mDoubleRun)
                WeakHandler(mContext.mainLooper).removeCallbacks(mLongPrRun)
                WeakHandler(mContext.mainLooper).postDelayed(mDoubleRun, ViewConfiguration.getDoubleTapTimeout().toLong())
                WeakHandler(mContext.mainLooper).postDelayed(mLongPrRun, ViewConfiguration.getLongPressTimeout().toLong())
            }
            MotionEvent.ACTION_POINTER_DOWN -> {
                WeakHandler(mContext.mainLooper).removeCallbacks(mDoubleRun)
                WeakHandler(mContext.mainLooper).removeCallbacks(mLongPrRun)
            }
            MotionEvent.ACTION_MOVE -> {
                mGestureInterface?.onMove(event)
            }
            MotionEvent.ACTION_POINTER_UP -> {
            }
            MotionEvent.ACTION_UP -> {
                mGestureInterface?.onUp()
                if (Math.abs(event.x - mPoints.x1) < ViewConfiguration.get(mContext).scaledTouchSlop
                        && Math.abs(event.y - mPoints.y1) < ViewConfiguration.get(mContext).scaledTouchSlop) {
                    mDoubleRun.addCount()
                    WeakHandler(mContext.mainLooper).removeCallbacks(mDoubleRun)
                    WeakHandler(mContext.mainLooper).removeCallbacks(mLongPrRun)
                } else {
                    //手松开时，距离大一点
                    val tempX = event.x.minus(mPoints.x1)
                    val tempY = event.y.minus(mPoints.y1)
                    if (Math.abs(tempX) > Math.abs(tempY)) {
                        if (tempX > 0) mGestureInterface?.onRight() else mGestureInterface?.onLeft()
                    } else {
                        if (tempY > 0) mGestureInterface?.onBottom() else mGestureInterface?.onTop()
                    }
                }
            }
        }
        return true
    }


    class DoubleRunnable(gesture: OnGesture?) : Runnable {
        var clickCount = 0
        private val mDoubleGesture by lazy { gesture }
        override fun run() {
            when (clickCount) {
                in 2..10 -> mDoubleGesture?.onDoubleUp()
                1 -> mDoubleGesture?.onSingleUp()
            }
            clickCount = 0
        }

        fun addCount() {
            clickCount++
        }

    }

    class LongPreRunnable : Runnable {
        override fun run() {
        }
    }

    /**双指，两个坐标点**/
    data class Points(var x1: Float, var y1: Float) {
        var x2: Float = 0f
        var y2: Float = 0f
    }

}