package com.example.indroorway.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.indroorway.R
import com.example.indroorway.models.CountriesPojo
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.item_detail.*


/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [ItemListActivity]
 * in two-pane mode (on tablets) or a [ItemDetailActivity]
 * on handsets.
 */
/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 */
class ItemDetailFragment : Fragment(), OnMapReadyCallback  {

    private lateinit var mMap: GoogleMap
    lateinit var countriesPojo: CountriesPojo




    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val countryPosti = LatLng(countriesPojo.latlng[0], countriesPojo.latlng[1])
        mMap.addMarker(MarkerOptions().position(countryPosti).title("Marker"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(countryPosti))
    }

    /**
     * The ontent this fragment is presenting.
     */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(savedInstanceState==null) {
            arguments?.let {
                countriesPojo = it.getParcelable("parcelable") as CountriesPojo
            }



            val mapFragment = fragmentManager?.findFragmentById(R.id.map) as? SupportMapFragment
            mapFragment?.getMapAsync(this)
        }


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(com.example.indroorway.R.layout.item_detail, container, false)



        //


        // Show the dummy content as text in a TextView.

        //TODO
       /* if (mItem != null) {
            (rootView.findViewById<View>(R.id.item_detail) as TextView).text = mItem!!.details
        }
*/
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name.text = countriesPojo.name.toString()
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        val ARG_ITEM_ID = "item_id"
    }
}
