package com.qimon.commonlibrary.gesture

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent

/**
 * Created by Administrator on 2017/9/8.
 * 对手势事件进行封装，有上下左右，单击，双击，长按，move,pressed,up
 *
 * 如果发现onFling没有回调，请设置View.setLongClickable(true)
 */
class ZGesture(context: Context, gesture: OnGesture?) : GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    override fun onShowPress(p0: MotionEvent?) {
        mGestureInterface?.onPressed()
    }

    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        return true
    }

    override fun onDoubleTap(p0: MotionEvent?): Boolean {
        mGestureInterface?.onDoubleUp()
        mGestureInterface?.onUp()
        return true
    }

    override fun onDown(p0: MotionEvent?): Boolean {
        mGestureInterface?.onDown()
        return true
    }

    override fun onFling(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        val tempX = p1?.x ?: 0f.minus(p0?.x ?: 0f)
        val tempY = p1?.y ?: 0f.minus(p0?.y ?: 0f)
        if (Math.abs(tempX) > Math.abs(tempY)) {
            if (tempX > 0) mGestureInterface?.onRight() else mGestureInterface?.onLeft()
        } else {
            if (tempY > 0) mGestureInterface?.onBottom() else mGestureInterface?.onTop()
        }
        mGestureInterface?.onUp()
        return true
    }

    override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        mGestureInterface?.onMove(p0, p1)
        return true
    }

    override fun onLongPress(p0: MotionEvent?) {
        mGestureInterface?.onLong()
        mGestureInterface?.onUp()
    }

    override fun onDoubleTapEvent(p0: MotionEvent?): Boolean {
        return true
    }

    override fun onSingleTapConfirmed(p0: MotionEvent?): Boolean {
        mGestureInterface?.onSingleUp()
        mGestureInterface?.onUp()
        return true
    }

    private val mGestureInterface by lazy { gesture }
    private val mContext by lazy { context }
    private val mTwoFingerGesture by lazy { TwoFingerGesture(mContext, mGestureInterface) }

    /**
     * 通过这个接口，得到触摸事件
     * */
    fun onTouchEvent(event: MotionEvent): Boolean {
        return when (event.pointerCount) {
            1 -> mGestureDetector.onTouchEvent(event)//单指
            2 -> mTwoFingerGesture.onTouch(event)
            else -> true
        }
    }

    private val mGestureDetector: GestureDetector by lazy { GestureDetector(mContext, this@ZGesture).apply { this.setOnDoubleTapListener(this@ZGesture) } }

}