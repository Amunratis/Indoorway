package com.example.indroorway.ui

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.indroorway.App
import com.example.indroorway.R
import com.example.indroorway.baseClasses.BaseActivity
import com.example.indroorway.models.CountriesPojo

import com.example.indroorway.utils.RestApi
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [ItemDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class MainActivity : BaseActivity() {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var mTwoPane: Boolean = false
    private var searchView: SearchView? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: SimpleItemRecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        (application as App).getNetComponent()?.inject(this)


        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        toolbar.title = title

        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        if (findViewById<View>(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true
        }

        recyclerView = findViewById<View>(R.id.item_list)!! as RecyclerView
        setupRecyclerView(recyclerView)

    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {

        try {
            val countries = retrofit.create(RestApi::class.java).getCountries()

            countries.enqueue(object : Callback<List<CountriesPojo>> {

                override fun onResponse(call: Call<List<CountriesPojo>>, response: Response<List<CountriesPojo>>) {

                    val countries = response.body()

                    Log.d("Latte", countries?.get(0)?.latlng.toString())

                    recyclerView.adapter = countries?.let { SimpleItemRecyclerViewAdapter(this@MainActivity, it, mTwoPane) }
                    recyclerViewAdapter=recyclerView.adapter  as SimpleItemRecyclerViewAdapter
                }

                override fun onFailure(call: Call<List<CountriesPojo>>, t: Throwable) {
                    Log.d("Latte", t.message)
                    Toast.makeText(this@MainActivity, "Error Fetching Data!", Toast
                            .LENGTH_LONG).show()
                }
            })
        } catch (e: Exception) {
            Log.d("Error", e.message)
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        // Associate search_layout configuration with the SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = menu.findItem(R.id.action_search)
                .actionView as SearchView
        searchView!!.setSearchableInfo(searchManager
                .getSearchableInfo(componentName))
        searchView!!.maxWidth = Integer.MAX_VALUE
        // listening to search query text change
        searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String): Boolean {
                // filter recycler view when query submitted
                recyclerViewAdapter.filter.filter(query)
                return false
            }
            override fun onQueryTextChange(query: String): Boolean {
                // filter recycler view when text is changed
                recyclerViewAdapter.filter.filter(query)
                return false
            }
        })
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.action_search) {
            true
        } else super.onOptionsItemSelected(item)
    }
    override fun onBackPressed() {
        // close search view on back button pressed
        if (!searchView!!.isIconified) {
            searchView!!.isIconified = true
            return
        }
        super.onBackPressed()
    }
}
