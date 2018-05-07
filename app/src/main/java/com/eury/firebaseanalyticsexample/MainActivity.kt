package com.eury.firebaseanalyticsexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mFirebaseAnalytics: FirebaseAnalytics? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)


        val tvShows = ArrayList<TvShow>()
        tvShows.add(TvShow("The Big Bang Theory",
                "Mensa-fied best friends and roommates Leonard and Sheldon, physicists who work at the California Institute of Technology, may be able to tell everybody more than they want to know about quantum physics, but getting through most basic social situations, especially ones involving women.",
                "https://cdn.movieweb.com/img.albums/TVoo5uoul0PFru_1_200/The-Big-Bang-Theory.jpg"))

        tvShows.add(TvShow("Friends",
                "Three young men and three young women - of the BFF kind - live in the same apartment complex and face life and love in New York. They're not above sticking their noses into one another's businesses and swapping romantic partners.",
                "https://i0.wp.com/minhtienff.com/wp-content/uploads/2017/10/Friends.jpg?w=200"))

        tvShows.add(TvShow("Married... with Children",
                "The antithesis of the loving \"Cosby Show\" family, \"Married ... With Children\" focused on the Bundys, a suburban Chicago family who would rather eat nails than say a kind word to one another.",
                "http://iart.toaos.tk/i/tvshow/286508511_largethumb.jpg"))

        tvShows.add(TvShow("The Walking Dead",
                "Based on the comic book series written by Robert Kirkman, this gritty drama portrays life in the months and years that follow a zombie apocalypse.",
                "https://cdn.movieweb.com/img.albums/TS8zYyioaIj6be_78_200/The-Walking-Dead.jpg"))

        val adapter = TvShowsAdapter(tvShows) {tvShow ->
            /*val bundle = Bundle()
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, tvShow.name)
            mFirebaseAnalytics?.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)*/

            val bundle = Bundle()
            bundle.putString("show_name", tvShow.name)
            mFirebaseAnalytics?.logEvent("show_selected", bundle)

            Log.d(MainActivity@this.localClassName, tvShow.name)
        }

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recyclerView.adapter = adapter
    }
}
