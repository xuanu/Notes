package cn.zeffect.notes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import cn.zeffect.notes.memoryleak.MemoryLeakActivity;
import cn.zeffect.notes.utils.IntentUtils;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.goMemory).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.goMemory:
                IntentUtils.goTarget(MainActivity.this, MemoryLeakActivity.class);
                break;
        }
    }
}
