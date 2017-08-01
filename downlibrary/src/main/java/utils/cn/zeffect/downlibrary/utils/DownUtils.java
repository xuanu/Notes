package utils.cn.zeffect.downlibrary.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;

import java.io.File;
import java.util.UUID;

import utils.cn.zeffect.downlibrary.DownService;
import utils.cn.zeffect.downlibrary.bean.Task;

/**
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

public class DownUtils {
    public static void addTask(Context pContext, String url) {
        addTask(pContext, url, "");
    }

    public static void addTask(Context pContext, String url, String dir) {
        addTask(pContext, url, "", "");
    }

    public static void addTask(Context pContext, String url, String dir, String name) {
        if (pContext == null) throw new NullPointerException("context null");
        if (TextUtils.isEmpty(url)) return;
        if (TextUtils.isEmpty(dir))
            dir = Environment.getExternalStorageDirectory() + File.separator + Constant.DIR_NAME;
        File dirFile = new File(dir);
        if (!dirFile.isDirectory())
            dir = Environment.getExternalStorageDirectory() + File.separator + Constant.DIR_NAME;
        File dirFile2 = new File(dir);
        if (!dirFile2.exists()) dirFile2.mkdirs();
        if (TextUtils.isEmpty(name)) name = UUID.randomUUID().toString();
        Intent dataIntent = new Intent(pContext, DownService.class);
        Task newTask = new Task().setDownUrl(url)
                .setSaveDir(dir)
                .setSaveName(name);
        dataIntent.putExtra(Constant.CONTENT_KEY, newTask);
        dataIntent.setAction(Constant.START_ACTION);
        pContext.startService(dataIntent);
    }

    public static void pauseTask(Context pContext, String url) {
        if (pContext == null) throw new NullPointerException("context null");
        if (TextUtils.isEmpty(url)) return;
        pContext.startService(new Intent(pContext, DownService.class).setAction(Constant.PAUSE_ACTION));
    }
}
