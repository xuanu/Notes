package utils.cn.zeffect.downlibrary;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import utils.cn.zeffect.downlibrary.utils.OrmUtils;

/**
 * 下载管理器
 * <pre>
 *      author  ：zzx
 *      e-mail  ：zhengzhixuan18@gmail.com
 *      time    ：2017/08/01
 *      desc    ：
 *      version:：1.0
 * </pre>
 *
 * @author zzx
 */

public class DownService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        OrmUtils.defaultInit(getApplicationContext());
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
