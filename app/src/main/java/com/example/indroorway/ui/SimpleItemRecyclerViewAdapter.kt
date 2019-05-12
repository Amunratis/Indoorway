package com.example.indroorway.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.indroorway.R
import com.example.indroorway.models.CountriesPojo


internal class SimpleItemRecyclerViewAdapter internal constructor(private val mParentActivityMain: MainActivity,
                                                                  private val mValues: List<CountriesPojo>,
                                                                  private val mTwoPane: Boolean) : RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener = View.OnClickListener { view ->

        val country = view.tag as CountriesPojo

        if (mTwoPane) {

            val fragment = ItemDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("parcelable", country)
                }
            }

            mParentActivityMain.supportFragmentManager.beginTransaction()
                    .replace(R.id.item_detail_container, fragment)
                    .commit()
        } else {

            val context = view.context
            val intent = Intent(context, ItemDetailActivity::class.java)
            intent.putExtra("parcel",country)

            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.mContentView.text = mValues[position].name



        holder.itemView.tag = mValues[position]
        holder.itemView.setOnClickListener(mOnClickListener)
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    internal inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val mContentView: TextView = view.findViewById<View>(R.id.content) as TextView

    }
}