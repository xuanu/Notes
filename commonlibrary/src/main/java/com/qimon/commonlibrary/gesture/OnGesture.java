package com.qimon.commonlibrary.gesture;

import android.view.MotionEvent;

/**
 * Created by Administrator on 2017/9/9.
 */

public abstract class OnGesture {
    /**
     * 上滑
     **/
    public void onTopUp() {
    }

    /***
     * 上滑，抬起
     * @param pEvent
     */
    public void onTopUp(MotionEvent pEvent) {
    }

    /**
     * 下滑
     */
    public void onBottomUp() {
    }

    public void onBottomUp(MotionEvent pEvent) {

    }

    /***左滑**/
    public void onLeftUp() {
    }

    public void onLeftUp(MotionEvent pEvent) {
    }

    /**
     * 右滑
     **/
    public void onRightUp() {
    }

    public void onRightUp(MotionEvent pEvent) {
    }

    /**
     * 按下
     **/
    public void onDown() {
    }

    public void onDown(MotionEvent pEvent) {
    }


    /**
     * 抬起
     **/
    public void onUp() {
    }

    public void onUp(MotionEvent pEvent) {
    }

    /**
     * 移动
     **/
    public void onMove(MotionEvent event) {
    }

    /**
     * 单击
     **/
    public void onSingleUp() {
    }

    public void onSingleUp(MotionEvent pEvent) {
    }

    /**
     * 双击
     **/
    public void onDoubleUp() {
    }

    public void onDoubleUp(MotionEvent pEvent) {
    }

    /**
     * 长按
     */
    public void onLongClick() {
    }

    public void onLongClick(MotionEvent pEvent) {
    }

    //**********************双指手势区

    /***
     * 双指放大
     * @param pDouble 两次间隔
     */
    public void on2ZoomBigMove(Double pDouble) {

    }

    public void on2ZoomBigUp(Double pDouble) {
    }

    /***
     * 缩小
     * @param pDouble 两次间隔
     * **/
    public void on2ZoomSmallMove(Double pDouble) {

    }

    public void on2ZoomSmallUp(Double pDouble) {

    }

    public void on2TopMove(Float pFloat) {
    }

    public void on2BottomMove(Float pFloat) {
    }

    public void on2LeftMove(Float pFloat) {
    }

    public void on2RightMove(Float pFloat) {
    }

    public void on2TopUp(Float pFloat) {
    }

    public void on2BottomUp(Float pFloat) {
    }

    public void on2LeftUp(Float pFloat) {
    }

    public void on2RightUp(Float pFloat) {
    }

    /***
     * 双指放大
     * @param pDouble 两次间隔
     *                @param pPoints0 上一次坐标
     *                                @param pPoints1 新的坐标
     */
    public void on2ZoomBigMove(ZGesture.Points pPoints0, ZGesture.Points pPoints1, Double pDouble) {

    }

    /***
     * 放大，抬起时
     * @param pPoints0 按下时坐标
     * @param pPoints1 抬起时坐标
     * @param pDouble 间隔
     */
    public void on2ZoomBigUp(ZGesture.Points pPoints0, ZGesture.Points pPoints1, Double pDouble) {
    }

    /***
     * 缩小
     * @param pDouble 两次间隔
     * **/
    public void on2ZoomSmallMove(ZGesture.Points pPoints0, ZGesture.Points pPoints1, Double pDouble) {

    }

    public void on2ZoomSmallUp(ZGesture.Points pPoints0, ZGesture.Points pPoints1, Double pDouble) {

    }

    public void on2TopMove(ZGesture.Points pPoints0, ZGesture.Points pPoints1, Float pFloat) {
    }

    public void on2BottomMove(ZGesture.Points pPoints0, ZGesture.Points pPoints1, Float pFloat) {
    }

    public void on2LeftMove(ZGesture.Points pPoints0, ZGesture.Points pPoints1, Float pFloat) {
    }

    public void on2RightMove(ZGesture.Points pPoints0, ZGesture.Points pPoints1, Float pFloat) {
    }

    public void on2TopUp(ZGesture.Points pPoints0, ZGesture.Points pPoints1, Float pFloat) {
    }

    public void on2BottomUp(ZGesture.Points pPoints0, ZGesture.Points pPoints1, Float pFloat) {
    }

    public void on2LeftUp(ZGesture.Points pPoints0, ZGesture.Points pPoints1, Float pFloat) {
    }

    public void on2RightUp(ZGesture.Points pPoints0, ZGesture.Points pPoints1, Float pFloat) {
    }

    //***************************取消事件

    /***
     * 取消手势，这个等我先想一下。
     * 移动的时候可以得到当前手指，但抬起就得不到，所以，取消了就取消了，没有了。
     * 按下两个手指，取消一个手指事件，同理3取2
     * 应该没有人要取消长按和单双击的回调吧。
     * @param finger  取消了几个手指的抬起事件
     */
    public void cancelFinger(int finger) {

    }

}
