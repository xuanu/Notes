package cn.zeffect.notes;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

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

public class MyApp extends Application {
    @Override public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
