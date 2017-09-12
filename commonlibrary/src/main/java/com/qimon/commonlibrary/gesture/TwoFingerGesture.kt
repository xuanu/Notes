package com.qimon.commonlibrary.gesture

import android.content.Context
import android.graphics.Point
import android.util.FloatMath
import android.view.MotionEvent
import android.view.ViewConfiguration

/**
 * 双指事件处理
 * <pre>
 *      author  ：zzx
 *      e-mail  ：zhengzhixuan18@gmail.com
 *      time    ：2017/09/12
 *      desc    ：
 *      version:：1.0
 * </pre>
 * @author zzx
 */
class TwoFingerGesture(context: Context, gesture: OnGesture?) {
    private val mGesture by lazy { gesture }
    private val mContext by lazy { context }
    private var mSpace = 0f
    private var mPoint0: Point? = null
    private var mPoint1: Point? = null

    fun onTouch(event: MotionEvent): Boolean {
        return if (event == null || event.pointerCount != 2) {
            true
        } else doGesture(event)
    }

    private fun doGesture(event: MotionEvent): Boolean {
        //能到这里，肯定是双指了。我也只要滑动的事件
        when (event.action and MotionEvent.ACTION_MASK) {
            MotionEvent.ACTION_MOVE -> {
                if (event.pointerCount != 2) return true
                pointSpace(event)
            }
        }
        return true
    }

    private fun pointSpace(event: MotionEvent) {
        //旧的两个点，要同时移动一定距离，才算触发事件
        if (mPoint0 == null || mPoint1 == null) {
            mPoint0 = Point(event.getX(0).toInt(), event.getY(0).toInt())
            mPoint1 = Point(event.getX(1).toInt(), event.getY(1).toInt())
            return
        }
        val tempPoint0 = Point(event.getX(0).toInt(), event.getY(0).toInt())
        val tempPoint1 = Point(event.getX(1).toInt(), event.getY(1).toInt())
        val slop = ViewConfiguration.get(mContext).scaledTouchSlop
        if (Math.abs(tempPoint0.x - mPoint0!!.x) < slop && Math.abs(tempPoint0.x - mPoint0!!.x) < slop) {
            return
        }
        if (Math.abs(tempPoint1.x - mPoint1!!.x) < slop && Math.abs(tempPoint1.x - mPoint1!!.x) < slop) {
            return
        }
        //计算新旧两点距离
        val oldX: Double = Math.abs(mPoint0?.x ?: 0 - mPoint1!!.x).toDouble()
        val oldY: Double = Math.abs(mPoint0?.y ?: 0 - mPoint1!!.y).toDouble()
        val oldSpace = Math.sqrt(oldX * oldX + oldY * oldY)
        val newX: Double = Math.abs(event.getX(0) - event.getX(1)).toDouble()
        val newY: Double = Math.abs(event.getY(0) - event.getY(1)).toDouble()
        val newSpace = Math.sqrt(newX * newX + newY * newY)
        if (mGesture != null) {
            val interval = newSpace - oldSpace
            if (interval > 0) mGesture?.zoomBig(interval) else mGesture?.zoomSmall(interval)
        }
        //
        mPoint0?.x = event.getX(0).toInt()
        mPoint0?.y = event.getY(0).toInt()
        mPoint1?.x = event.getX(1).toInt()
        mPoint1?.y = event.getY(1).toInt()
    }

}
