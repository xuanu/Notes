package cn.zeffect.notes.recycler

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import cn.zeffect.notes.R
import org.jetbrains.anko.find

/**
 * <pre>
 *      author  ：zzx
 *      e-mail  ：zhengzhixuan18@gmail.com
 *      time    ：2017/09/19
 *      desc    ：
 *      version:：1.0
 * </pre>
 * @author zzx
 * // TODO 用@see描述一下当前类的方法及简单解释
 */
class RecyclerActivity : Activity() {
    private val mContext by lazy { this }
    private val mRecycler by lazy { find<RecyclerView>(R.id.recycler) }
    private val mDatas by lazy { arrayListOf<String>() }
    private val mAdapter by lazy { MyAdapter(mDatas) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        initView()
    }

    private fun initView() {
        mRecycler?.layoutManager = LinearLayoutManager(this)
        val tempAdapter = AdapterWrapper(mAdapter)
        tempAdapter.addHeader(TextView(mContext).apply { text = "头部1" })
        tempAdapter.addHeader(TextView(mContext).apply { text = "头部2" })
        tempAdapter.addHeader(TextView(mContext).apply { text = "头部3" })
        tempAdapter.addHeader(TextView(mContext).apply { text = "头部4" })
        tempAdapter.addFooter(TextView(mContext).apply { text = "尾部1" })
        tempAdapter.addFooter(TextView(mContext).apply { text = "尾部2" })
        tempAdapter.addFooter(TextView(mContext).apply { text = "尾部3" })
        tempAdapter.addFooter(TextView(mContext).apply { text = "尾部4" })
        tempAdapter.setEmptyView(LayoutInflater.from(mContext).inflate(R.layout.layout_default_empty, null))
        mRecycler.adapter = tempAdapter
        find<Button>(R.id.clear).setOnClickListener { val size = mDatas.size; mDatas.clear();mAdapter.notifyDataSetChanged() }
        find<Button>(R.id.add).setOnClickListener { mDatas.add("随机时间${System.currentTimeMillis()}");mAdapter.notifyItemInserted(mDatas.size - 1) }
        find<Button>(R.id.remove).setOnClickListener { val size = mDatas.size - 1;mDatas.removeAt(size);mAdapter.notifyItemRemoved(size) }
        find<Button>(R.id.update).setOnClickListener { mDatas[0] = "当前时间${System.currentTimeMillis()}";mAdapter.notifyItemChanged(0) }
    }


}