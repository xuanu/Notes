package cn.zeffect.notes;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.qimon.commonlibrary.gesture.OnGesture;
import com.qimon.commonlibrary.gesture.ZGesture;
import com.squareup.haha.perflib.Main;

import org.jetbrains.annotations.NotNull;

import cn.zeffect.notes.down.DownActivity;
import cn.zeffect.notes.memoryleak.MemoryLeakActivity;
import cn.zeffect.notes.utils.IntentUtils;
import cn.zeffect.notes.utils.L;

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
        public void zoomBig(Double pDouble) {
            Snackbar.make(mView, "放大：" + pDouble, Snackbar.LENGTH_SHORT).show();
        }

        @Override
        public void zoomSmall(Double pDouble) {
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
