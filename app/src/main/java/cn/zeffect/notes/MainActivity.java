package cn.zeffect.notes;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.qimon.commonlibrary.gesture.OnGesture;
import com.qimon.commonlibrary.gesture.ZGesture;

import org.jetbrains.annotations.NotNull;

import cn.zeffect.notes.down.DownActivity;
import cn.zeffect.notes.memoryleak.MemoryLeakActivity;
import cn.zeffect.notes.recycler.RecyclerActivity;
import cn.zeffect.notes.utils.IntentUtils;

public class MainActivity extends Activity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    private View mView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mView = findViewById(R.id.root_layout);
        findViewById(R.id.goMemory).setOnClickListener(this);
        findViewById(R.id.gotoDown).setOnClickListener(this);
        findViewById(R.id.gotoPlay).setOnClickListener(this);
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
            case R.id.gotoPlay:
                IntentUtils.goTarget(MainActivity.this, RecyclerActivity.class);
                break;
        }
    }

}
