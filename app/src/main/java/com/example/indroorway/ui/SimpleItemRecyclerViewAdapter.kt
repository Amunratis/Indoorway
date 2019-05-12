package com.example.indroorway.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import com.example.indroorway.models.CountriesPojo


internal class SimpleItemRecyclerViewAdapter internal constructor(private val mParentActivityMain: MainActivity,
                                                                  private val mValues: List<CountriesPojo>,
                                                                  private val mTwoPane: Boolean) : RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>(),Filterable {

    private var  countriesSearchList: List<CountriesPojo>

    init {
        this.countriesSearchList = mValues
    }

    override fun getFilter(): Filter {

        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): Filter.FilterResults {
                val charString = charSequence.toString()

                if (charString.isEmpty()) {
                    countriesSearchList = mValues
                } else {
                    val filteredList = ArrayList<CountriesPojo>()
                    for (row in mValues) {
                        if (row.name!!.toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row)
                        }
                    }
                    countriesSearchList = filteredList
                }
                val filterResults = Filter.FilterResults()
                filterResults.values = countriesSearchList
                filterResults.count = countriesSearchList.size
                return filterResults
            }
            override fun publishResults(charSequence: CharSequence, filterResults: Filter.FilterResults) {
                countriesSearchList = filterResults.values as List<CountriesPojo>
                notifyDataSetChanged()
            }
        }
    }

    private val mOnClickListener = View.OnClickListener { view ->


        val country = view.tag as CountriesPojo

        if (mTwoPane) {
            val fragment = ItemDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("parcelable", country)
                }
            }
            mParentActivityMain.supportFragmentManager.beginTransaction()
                    .replace(com.example.indroorway.R.id.item_detail_container, fragment)
                    .commit()
        } else {

            val context = view.context
            val intent = Intent(context, ItemDetailActivity::class.java)
            intent.putExtra("parcelable",country)

            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(com.example.indroorway.R.layout.item_list_content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.mContentView.text = countriesSearchList[position].name



        holder.itemView.tag = countriesSearchList[position]
        holder.itemView.setOnClickListener(mOnClickListener)
    }

    override fun getItemCount(): Int {
        return countriesSearchList.size
    }

    internal inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val mContentView: TextView = view.findViewById<View>(com.example.indroorway.R.id.content) as TextView

    }
}