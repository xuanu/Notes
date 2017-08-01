package utils.cn.zeffect.downlibrary.bean;

import org.json.JSONException;
import org.json.JSONObject;

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

public class Block {
    private int id;
    private int index;
    private long blockLength;
    private long downlength;
    private long start;
    private long total;

    @Override
    public String toString() {
        JSONObject dataJson = new JSONObject();
        try {
            dataJson.put("", "");
        } catch (JSONException pE) {
            pE.printStackTrace();
        } finally {
            return dataJson.toString();
        }
    }
}
