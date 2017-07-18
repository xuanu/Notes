package cn.zeffect.notes.utils;

import android.content.Context;
import android.content.Intent;

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

public class IntentUtils {
    public static void goTarget(Context pContext, Class<?> target) {
        pContext.startActivity(new Intent(pContext, target));
    }
}
