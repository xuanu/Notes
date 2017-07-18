package cn.zeffect.notes.memoryleak;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import cn.zeffect.notes.R;

/**
 * 模拟handler造成的内存泄露
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

public class Leak1Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak1);
        findViewById(R.id.al1_finish_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                    }
                }, 10 * 1000);
                Leak1Activity.this.finish();
            }
        });
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
}
