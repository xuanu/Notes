package cn.zeffect.notes.down;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cn.zeffect.notes.R;
import utils.cn.zeffect.downlibrary.bean.Task;
import utils.cn.zeffect.downlibrary.interfaces.DownListener;
import utils.cn.zeffect.downlibrary.utils.DownUtils;

/**
 * <pre>
 *      author  ：zzx
 *      e-mail  ：zhengzhixuan18@gmail.com
 *      time    ：2017/08/02
 *      desc    ：
 *      version:：1.0
 * </pre>
 *
 * @author zzx
 */

public class DownActivity extends Activity implements DownListener, View.OnClickListener {
    private EditText inputEt;
    private Button downBtn;
    private TextView showText;
    private Button mPauseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down);
        inputEt = findViewById(R.id.input);
        downBtn = (Button) findViewById(R.id.down);
        showText = (TextView) findViewById(R.id.showText);
        mPauseBtn = (Button) findViewById(R.id.pausedown);
        downBtn.setOnClickListener(this);
        mPauseBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.down:
                String url = inputEt.getText().toString().trim();
                if (TextUtils.isEmpty(url)) return;
                if (!url.startsWith("http")) return;
                DownUtils.addTask(DownActivity.this, new Task().setDownUrl(url), this);
                break;
            case R.id.pausedown:
                String urlText = inputEt.getText().toString().trim();
                if (TextUtils.isEmpty(urlText)) return;
                if (!urlText.startsWith("http")) return;
                DownUtils.pauseTask(DownActivity.this, urlText);
                break;
        }
    }

    @Override
    public void onStart(Task pTask) {
        showText.setText(showText.getText() + "\n" + pTask.getDownUrl() + "开始下载");
    }

    @Override
    public void onPause(Task pTask) {
        showText.setText(showText.getText() + "\n" + pTask.getDownUrl() + "下载暂停");

    }

    @Override
    public void onSuccess(Task pTask) {
        showText.setText(showText.getText() + "\n" + pTask.getDownUrl() + "下载成功");
    }

    @Override
    public void onFaile(Task pTask) {
        showText.setText(showText.getText() + "\n" + pTask.getDownUrl() + "开始失败");
    }

    @Override
    public void onDowning(Task pTask) {
        int progress = (int) (pTask.getDownLength() * 1f / pTask.getTotalLength() * 100);
        showText.setText(showText.getText() + "\n" + pTask.getDownUrl() + "下载中" + progress);
    }
}