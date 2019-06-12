package com.deushdezt.laboratorio4.activities


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.deushdezt.laboratorio4.Adapter.MovieAdapter
import com.deushdezt.laboratorio4.Database.ViewModel.MovieViewModel

import com.deushdezt.laboratorio4.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

        lateinit var adapter : MovieAdapter
        lateinit var viewModel : MovieViewModel

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            bind()

    }

    private fun bind(){
        adapter = MovieAdapter(ArrayList())

        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        rv_movies.apply{
            adapter=this@MainActivity.adapter
            layoutManager= LinearLayoutManager(this@MainActivity)
        }
        viewModel.getAll().observe(this, Observer{
            adapter.updateList(it)
        })
        btn_movie.setOnClickListener{
            viewModel.retrieveMovies(et_movie.text.toString())
       }
    }





}

