package com.example.indroorway.ui

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.indroorway.R
import com.example.indroorway.models.CountriesPojo
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_item_detail.*
import org.jetbrains.anko.toast



/**
 * An activity representing a single Item detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a [MainActivity].
 */
class ItemDetailActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    lateinit var countriesPojo: CountriesPojo


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val countryPosti = LatLng(countriesPojo.latlng[0], countriesPojo.latlng[1])
        mMap.addMarker(MarkerOptions().position(countryPosti).title("Marker"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(countryPosti))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)

        countriesPojo= intent.getParcelableExtra("parcel")
        name.text = countriesPojo.capital.toString()



        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.

            val fragment = ItemDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(
                            ItemDetailFragment.ARG_ITEM_ID,
                            intent.getStringExtra(ItemDetailFragment.ARG_ITEM_ID)
                    )
                }
            }

            supportFragmentManager.beginTransaction()
                    .add(R.id.item_detail_container, fragment)
                    .commit()
        }

    }
}
