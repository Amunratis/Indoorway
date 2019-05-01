package com.example.indroorway.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.indroorway.R
import com.example.indroorway.models.DummyContent


internal class SimpleItemRecyclerViewAdapter internal constructor(private val mParentActivityMain: MainActivity,
                                                                  private val mValues: List<DummyContent.DummyItem>,
                                                                  private val mTwoPane: Boolean) : RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {
    private val mOnClickListener = View.OnClickListener { view ->
        val item = view.tag as DummyContent.DummyItem
        if (mTwoPane) {
            val arguments = Bundle()
            arguments.putString(ItemDetailFragment.ARG_ITEM_ID, item.id)
            val fragment = ItemDetailFragment()
            fragment.arguments = arguments
            mParentActivityMain.supportFragmentManager.beginTransaction()
                    .replace(R.id.item_detail_container, fragment)
                    .commit()
        } else {
            val context = view.context
            val intent = Intent(context, ItemDetailActivity::class.java)
            intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, item.id)

            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mIdView.text = mValues[position].id
        holder.mContentView.text = mValues[position].content

        holder.itemView.tag = mValues[position]
        holder.itemView.setOnClickListener(mOnClickListener)
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    internal inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mIdView: TextView
        val mContentView: TextView

        init {
            mIdView = view.findViewById<View>(R.id.id_text) as TextView
            mContentView = view.findViewById<View>(R.id.content) as TextView
        }
    }
}