package com.example.indroorway.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.indroorway.R
import com.example.indroorway.models.CountriesPojo
import org.jetbrains.anko.support.v4.toast

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
class ItemDetailFragment : Fragment() {


    /**
     * The ontent this fragment is presenting.
     */
   var mItem: CountriesPojo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments!!.containsKey("parcelable")) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.

            //TODO
         /*   mItem = DummyContent.ITEM_MAP[arguments!!.getString(ARG_ITEM_ID)]

            val activity = this.activity
            val appBarLayout = activity!!.findViewById<View>(R.id.toolbar_layout) as CollapsingToolbarLayout

            if (appBarLayout != null) {
                appBarLayout.title = mItem!!.content
            }*/
            mItem= arguments!!.getParcelable("parcelable") as CountriesPojo?
            toast(mItem?.name.toString())
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.item_detail, container, false)

        // Show the dummy content as text in a TextView.

        //TODO
       /* if (mItem != null) {
            (rootView.findViewById<View>(R.id.item_detail) as TextView).text = mItem!!.details
        }
*/
        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        val ARG_ITEM_ID = "item_id"
    }
}
