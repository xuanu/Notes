# Notes
android开发笔记

1. **[安卓性能优化](https://github.com/xuanu/Notes/blob/master/Notes/optimize/%E5%AE%89%E5%8D%93%E4%B8%AD%E7%9A%84%E6%80%A7%E8%83%BD%E4%BC%98%E5%8C%96.md)**;  
2. **[设计实现简单的下载功能](https://github.com/xuanu/Notes/blob/master/Notes/download/%E8%AE%BE%E8%AE%A1%E5%AE%9E%E7%8E%B0%E4%B8%80%E4%B8%AA%E7%AE%80%E5%8D%95%E4%B8%8B%E8%BD%BD%E5%8A%9F%E8%83%BD.md)**
3. **[MediaPlay的简单封装，支持顺序播放多个音频。](https://github.com/xuanu/Notes/blob/master/Notes/MediaPlayer%E7%9A%84%E7%AE%80%E5%8D%95%E5%B0%81%E8%A3%85.md)**
4. [手势监听的封装，上下左右，单击，双击，长按，move,down,up,pressed](https://github.com/xuanu/Notes/blob/master/commonlibrary/src/main/java/com/qimon/commonlibrary/gesture/ZGesture.kt);
> 如果onFling不回调，设置View.setLongClickable(true)
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