package com.deushdezt.laboratorio4.activities

import android.content.Intent
import android.content.res.Configuration
import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.deushdezt.laboratorio4.AppConstants
import com.deushdezt.laboratorio4.R
import com.deushdezt.laboratorio4.fragments.MainContentFragment
import com.deushdezt.laboratorio4.fragments.MainListFragment
import com.deushdezt.laboratorio4.Database.pojos.Movie
import com.deushdezt.laboratorio4.fragments.MainContentFragment.Companion.newInstance
import com.google.gson.Gson
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity(), MainListFragment.SearchNewMovieListener {
    private lateinit var mainFragment : MainListFragment
    private lateinit var mainContentFragment: MainContentFragment

    private var movieList = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  movieList = savedInstanceState?.getParcelableArrayList(AppConstants.dataset_saveinstance_key) ?: ArrayList()

        initMainFragment()
    }



    fun initMainFragment(){
//        mainFragment = MainListFragment.newInstance(movieList)
//
//        val resource = if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
//            R.id.main_fragment
//        else {
//            mainContentFragment = newInstance(Movie())
//            changeFragment(R.id.land_main_cont_fragment, mainContentFragment)
//
//            R.id.land_main_fragment
//        }
//
//        changeFragment(resource, mainFragment)
    }

    fun addMovieToList(movie: Movie) {
        movieList.add(movie)
        mainFragment.updateMoviesAdapter(movieList)
        Log.d("Number", movieList.size.toString())
    }

    override fun searchMovie(movieName: String) {

    }

    override fun managePortraitItemClick(movie: Movie) {

    }

    private fun changeFragment(id: Int, frag: androidx.fragment.app.Fragment){ supportFragmentManager.beginTransaction().replace(id, frag).commit() }

    override fun manageLandscapeItemClick(movie: Movie) {
        mainContentFragment = newInstance(movie)
        changeFragment(R.id.land_main_cont_fragment, mainContentFragment)
    }


}

