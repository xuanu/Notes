# MediaPlayer的简单封装  
> 程序中要实现音频的拼接播放，主要是口语发音。封装一个工具类。  
### 构想  
1. 顺序播放实现：当前音频播放完毕之后，接着播放下一个音频，直到队列中没有音频。  
2. 播放结束的监听：原本是想支持多个监听回调的，后面想了下，去其它页面时，这个监听要么就不要了，要么音乐就停止了。所以没做。  
### 使用方法  
```
MediaUtils.getInstance().play(String[]); //顺序播放数组  
MediaUtils.getInstance().play(String[],OnPlayer); //顺序播放数组，带结束回调  
MediaUtils.getInstance().stop(); //停止播放  
```
