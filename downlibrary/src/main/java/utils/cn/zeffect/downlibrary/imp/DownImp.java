package utils.cn.zeffect.downlibrary.imp;

import android.app.Service;
import android.text.TextUtils;

import com.litesuits.orm.db.assit.QueryBuilder;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import utils.cn.zeffect.downlibrary.DownService;
import utils.cn.zeffect.downlibrary.bean.Task;
import utils.cn.zeffect.downlibrary.interfaces.ListenerUtils;
import utils.cn.zeffect.downlibrary.runnable.DownRunnable;
import utils.cn.zeffect.downlibrary.utils.Constant;
import utils.cn.zeffect.downlibrary.utils.OrmUtils;

/**
 * 下载实现
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

public class DownImp {
    public static final int SERVICE_THREAD_NUM = 5;
    private Service mService;
    private ExecutorService mExecutorService = Executors.newFixedThreadPool(SERVICE_THREAD_NUM);
    private HashMap<String, DownRunnable> mRunnableHashMap = new HashMap<>();

    public DownImp(DownService pService) {
        this.mService = pService;
        OrmUtils.defaultInit(pService.getApplicationContext());
    }

    /***
     * 添加任务，如果已经添加则不添加
     * @param pTask 任务
     */
    public void addTask(Task pTask) {
        //查询数据库是否存在
        if (pTask == null) return;
        String url = pTask.getDownUrl();
        if (TextUtils.isEmpty(url)) return;
        if (!isDbExist(url)) OrmUtils.getLiteOrm().save(pTask);
        //查询当前队列是否存在
        Task tempTask = OrmUtils.getLiteOrm().query(new QueryBuilder<>(Task.class).whereEquals(Constant.URL_KEY, url)).get(0);
        tempTask.setStatus(Task.STATU_NORMAL);
        if (mRunnableHashMap.containsKey(url)) return;
        DownRunnable tempRunnable = new DownRunnable(this, tempTask);
        mRunnableHashMap.put(url, tempRunnable);
        mExecutorService.execute(tempRunnable);
    }

    /***
     * 暂停任务
     * @param url 下载地址
     */
    public void pauseTask(String url) {
        if (TextUtils.isEmpty(url)) return;
        if (mRunnableHashMap.containsKey(url)) {
            mRunnableHashMap.get(url).setStaus(Task.STATU_PAUSE);
            removeTask(url);
        }
    }

    public void removeTask(String url) {
        if (mRunnableHashMap.containsKey(url)) {
            mRunnableHashMap.remove(url);
            ListenerUtils.getInstance().removeListener(url);
        }
    }


    /**
     * 数据库是否存在这条下载记录
     *
     * @param url 下载地址
     * @return true存在false不在
     */
    public static boolean isDbExist(String url) {
        if (TextUtils.isEmpty(url)) return true;
        return OrmUtils.getLiteOrm().queryCount(new QueryBuilder(Task.class).whereEquals(Constant.URL_KEY, url)) > 0;
    }

    public Service getService() {
        return mService;
    }
}
