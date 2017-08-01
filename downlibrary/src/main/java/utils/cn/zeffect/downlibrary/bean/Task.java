package utils.cn.zeffect.downlibrary.bean;

import com.litesuits.orm.db.annotation.Table;

import java.io.Serializable;
import java.util.ArrayList;

import utils.cn.zeffect.downlibrary.utils.Constant;

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
@Table(Constant.TABLE_NAME_TASK)
public class Task implements Serializable{
    private int id;
    private String uuid;
    private String downUrl;
    private String saveDir;
    private String saveName;
    private long totalLength;
    private long downLength;
    private ArrayList<Block> blocks;

    public int getId() {
        return id;
    }

    public Task setId(int pId) {
        id = pId;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public Task setUuid(String pUuid) {
        uuid = pUuid;
        return this;
    }

    public String getDownUrl() {
        return downUrl;
    }

    public Task setDownUrl(String pDownUrl) {
        downUrl = pDownUrl;
        return this;
    }

    public String getSaveDir() {
        return saveDir;
    }

    public Task setSaveDir(String pSaveDir) {
        saveDir = pSaveDir;
        return this;
    }

    public String getSaveName() {
        return saveName;
    }

    public Task setSaveName(String pSaveName) {
        saveName = pSaveName;
        return this;
    }

    public long getTotalLength() {
        return totalLength;
    }

    public Task setTotalLength(long pTotalLength) {
        totalLength = pTotalLength;
        return this;
    }

    public long getDownLength() {
        return downLength;
    }

    public Task setDownLength(long pDownLength) {
        downLength = pDownLength;
        return this;
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public Task setBlocks(ArrayList<Block> pBlocks) {
        blocks = pBlocks;
        return this;
    }
}
