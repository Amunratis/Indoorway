package com.example.indroorway.ui


import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import com.example.indroorway.R
import com.example.indroorway.models.CountriesPojo



/**
 * An activity representing a single Item detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a [MainActivity].
 */
class ItemDetailActivity : AppCompatActivity() {

lateinit var countries: CountriesPojo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)


        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.

            countries=intent.getParcelableExtra<Parcelable>("parcelable") as CountriesPojo

            val fragment = ItemDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("parcelable", countries )
                }
            }

            supportFragmentManager.beginTransaction()
                    .add(R.id.item_detail_container, fragment)
                    .commit()
        }

    }
}
