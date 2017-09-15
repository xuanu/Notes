package cn.zeffect.notes;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.MotionEvent;
import android.view.View;

import com.qimon.commonlibrary.gesture.OnGesture;
import com.qimon.commonlibrary.gesture.ZGesture;

import cn.zeffect.notes.down.DownActivity;
import cn.zeffect.notes.memoryleak.MemoryLeakActivity;
import cn.zeffect.notes.utils.IntentUtils;

public class MainActivity extends Activity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    private View mView;
    private ZGesture mGesture = new ZGesture(this, new OnGesture() {
        @Override
        public void onTopUp() {
            Snackbar.make(mView, "上", Snackbar.LENGTH_SHORT).show();
        }

        @Override
        public void onBottomUp() {
            Snackbar.make(mView, "下", Snackbar.LENGTH_SHORT).show();
        }

        @Override
        public void onLeftUp() {
            Snackbar.make(mView, "左", Snackbar.LENGTH_SHORT).show();
        }

        @Override
        public void onRightUp() {
            Snackbar.make(mView, "右", Snackbar.LENGTH_SHORT).show();
        }

        @Override
        public void onSingleUp() {
            Snackbar.make(mView, "单击", Snackbar.LENGTH_SHORT).show();
        }

        @Override
        public void onDoubleUp() {
            Snackbar.make(mView, "双击", Snackbar.LENGTH_SHORT).show();
        }

        @Override
        public void onDown() {
        }

        @Override
        public void onUp() {
        }

        @Override
        public void onMove(MotionEvent event1) {
        }

        @Override
        public void onLongClick() {
            Snackbar.make(mView, "长按", Snackbar.LENGTH_SHORT).show();
        }

        @Override
        public void on2ZoomBigMove(Double pDouble) {
            Snackbar.make(mView, "放大：" + pDouble, Snackbar.LENGTH_SHORT).show();
        }

        @Override
        public void on2ZoomSmallMove(Double pDouble) {
            Snackbar.make(mView, "缩小：" + pDouble, Snackbar.LENGTH_SHORT).show();
        }

        @Override
        public void on2LeftMove(Float pFloat) {
            Snackbar.make(mView, "双指向左：" + pFloat, Snackbar.LENGTH_SHORT).show();
        }

        @Override
        public void on2RightMove(Float p) {
            Snackbar.make(mView, "双指向右：" + p, Snackbar.LENGTH_SHORT).show();
        }

        @Override
        public void on2TopMove(Float pFloat) {
            Snackbar.make(mView, "双指向上：" + pFloat, Snackbar.LENGTH_SHORT).show();
        }

        @Override
        public void on2BottomMove(Float pFloat) {
            Snackbar.make(mView, "双指向下：" + pFloat, Snackbar.LENGTH_SHORT).show();
        }

        @Override
        public void on2TopUp(Float pFloat) {
            Snackbar.make(mView, "双指向上，抬起时：" + pFloat, Snackbar.LENGTH_SHORT).show();
        }

        @Override
        public void on2BottomUp(Float pFloat) {
            Snackbar.make(mView, "双指向下，抬起时：" + pFloat, Snackbar.LENGTH_SHORT).show();
        }

        @Override
        public void on2LeftUp(Float pFloat) {
            Snackbar.make(mView, "双指向左，抬起时：" + pFloat, Snackbar.LENGTH_SHORT).show();
        }

        @Override
        public void on2RightUp(Float pFloat) {
            Snackbar.make(mView, "双指向右，抬起时：" + pFloat, Snackbar.LENGTH_SHORT).show();
        }

        @Override
        public void on2ZoomBigUp(Double pDouble) {
            Snackbar.make(mView, "双指放大抬起时：" + pDouble, Snackbar.LENGTH_SHORT).show();
        }

        @Override
        public void on2ZoomSmallUp(Double pDouble) {
            Snackbar.make(mView, "双指缩小抬起时：" + pDouble, Snackbar.LENGTH_SHORT).show();
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mView = findViewById(R.id.root_layout);
        findViewById(R.id.goMemory).setOnClickListener(this);
        findViewById(R.id.gotoDown).setOnClickListener(this);
        findViewById(R.id.gotoPlay).setLongClickable(true);
        findViewById(R.id.gotoPlay).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View pView, MotionEvent pEvent) {
                return mGesture.onTouchEvent(pEvent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.goMemory:
                IntentUtils.goTarget(MainActivity.this, MemoryLeakActivity.class);
                break;
            case R.id.gotoDown:
                IntentUtils.goTarget(MainActivity.this, DownActivity.class);
                break;
        }
    }
}
