package com.deushdezt.laboratorio4.activities


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.deushdezt.laboratorio4.R

class MainActivity : AppCompatActivity() {

        lateinit var adapter : MovieAdapter
        lateinit var viewModel : MovieViewModel

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun bind(){
        adapter = ReposAdapter(ArrayList())
        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        rv_movies.apply{
            adapter=this@MainActivity.adapter
            layoutManager=LinearLayoutManager(this@MainActivity)
        }
        viewModel.getAll().observer(this,Observer{
            adapter.updateList(it)
        })
        btn_movie.setOnClickListener{
            viewModel.retrieveMovies(et_movie.text.toString())
        }
    }





}

