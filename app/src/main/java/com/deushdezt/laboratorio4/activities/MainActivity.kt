package com.deushdezt.laboratorio4.activities


import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.deushdezt.laboratorio4.Adapter.MovieAdapter
import com.deushdezt.laboratorio4.Database.ViewModel.MovieViewModel
import com.deushdezt.laboratorio4.Database.pojos.Movie
import com.deushdezt.laboratorio4.Fragments.MainContentFragment
import com.deushdezt.laboratorio4.Fragments.MovieListFragment

import com.deushdezt.laboratorio4.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.movies_list_fragment.*


class MainActivity : AppCompatActivity() , MovieListFragment.SearchNewMovieListener{

    override fun managePortraitItemClick(movie: Movie) {
        val movieBundle = Bundle()
        movieBundle.putParcelable("movie",movie)
        startActivity(Intent(this, MovieViewerActivity::class.java).putExtras(movieBundle))
    }

    lateinit var contentFragment: MainContentFragment
        lateinit var mainFragment: MovieListFragment

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            //bind()
            initMainFragment()

    }

    fun initMainFragment(){
        mainFragment = MovieListFragment()
        val resource = if(resources.configuration.orientation== Configuration.ORIENTATION_PORTRAIT)
            R.id.main_fragment
        else{
            contentFragment = MainContentFragment.newInstance(Movie())
            changeFragment(R.id.land_main_cont_fragment,contentFragment)
            R.id.land_main_fragment
        }
        changeFragment(resource,mainFragment)
    }

    override fun manageLandscapeItemClick(movie: Movie) {
        contentFragment = MainContentFragment.newInstance(movie)
        changeFragment(R.id.land_main_cont_fragment, contentFragment)
    }

    private fun changeFragment(id: Int, frag: Fragment){
        supportFragmentManager.beginTransaction().replace(id, frag).commit() }


}

