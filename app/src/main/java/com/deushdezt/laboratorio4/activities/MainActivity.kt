package com.deushdezt.laboratorio4.activities


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.deushdezt.laboratorio4.Adapter.MovieAdapter
import com.deushdezt.laboratorio4.Database.ViewModel.MovieViewModel
import com.deushdezt.laboratorio4.Fragments.MovieListFragment

import com.deushdezt.laboratorio4.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.movies_list_fragment.*


class MainActivity : AppCompatActivity() {

        lateinit var adapter : MovieAdapter
        lateinit var viewModel : MovieViewModel
        lateinit var mainFragment: MovieListFragment

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            //bind()
            initMainFragment()

    }

//    private fun bind(){
//        adapter = MovieAdapter(ArrayList())
//
//        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
//        rv_movies.apply{
//            adapter=this@MainActivity.adapter
//            layoutManager= LinearLayoutManager(this@MainActivity)
//        }
//        viewModel.getAll().observe(this, Observer{
//            adapter.updateList(it)
//        })
//        btn_movie.setOnClickListener{
//            viewModel.retrieveMovies(et_movie.text.toString())
//       }
//
//    }

    fun initMainFragment(){
        mainFragment = MovieListFragment()
        val resource = R.id.main_fragment
        changeFragment(resource,mainFragment)
    }

    private fun changeFragment(id: Int, frag: Fragment){
        supportFragmentManager.beginTransaction().replace(id, frag).commit() }


}

