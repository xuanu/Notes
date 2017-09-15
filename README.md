# Notes
android开发笔记

1. **[安卓性能优化](https://github.com/xuanu/Notes/blob/master/Notes/optimize/%E5%AE%89%E5%8D%93%E4%B8%AD%E7%9A%84%E6%80%A7%E8%83%BD%E4%BC%98%E5%8C%96.md)**;  
2. **[设计实现简单的下载功能](https://github.com/xuanu/Notes/blob/master/Notes/download/%E8%AE%BE%E8%AE%A1%E5%AE%9E%E7%8E%B0%E4%B8%80%E4%B8%AA%E7%AE%80%E5%8D%95%E4%B8%8B%E8%BD%BD%E5%8A%9F%E8%83%BD.md)**
3. **[MediaPlay的简单封装，支持顺序播放多个音频。](https://github.com/xuanu/Notes/blob/master/Notes/MediaPlayer%E7%9A%84%E7%AE%80%E5%8D%95%E5%B0%81%E8%A3%85.md)**
4. [手势监听的封装，上下左右，单击，双击，长按,双指缩放，双指移动，move,down,up](https://github.com/xuanu/Notes/blob/master/commonlibrary/src/main/java/com/qimon/commonlibrary/gesture/ZGesture.kt);
> 简单说明一下：接口是抽象类的方式，可以选取自己想要监听的手势。
    0. 移动超过感知距离会取消单击双击长按手势
    1. 单指的上下左右，是抬起手指时判断相对按下的位置。
    2. 双指反向(相对最后点)是缩放，双指同向是on2?Move(space)(选取相对位置上，距离最大);
```
//使用方法与GestureDetector一致，仅对其进行封装，方便使用
ZGesture(context,OnGesture).onTouchEvent(event)
```
5. [点击间隔，短时间内不重复响应](https://github.com/xuanu/Notes/blob/master/commonlibrary/src/main/java/com/qimon/commonlibrary/gesture/OnClickFastListener.java)
```
View.setOnClickListener(new OnClickFastListener(time){
 public  void onFastClick(View v){
 }
});
```