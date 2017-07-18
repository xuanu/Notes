package cn.zeffect.notes.memoryleak;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import cn.zeffect.notes.R;
import cn.zeffect.notes.utils.IntentUtils;

/**
 * <pre>
 *      author  ：zzx
 *      e-mail  ：zhengzhixuan18@gmail.com
 *      time    ：2017/07/18
 *      desc    ：
 *      version:：1.0
 * </pre>
 *
 * @author zzx
 */

public class MemoryLeakActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        findViewById(R.id.goHandler).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.goHandler:
                IntentUtils.goTarget(MemoryLeakActivity.this, Leak1Activity.class);
                break;
        }
    }
}
