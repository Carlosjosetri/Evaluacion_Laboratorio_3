package com.deushdezt.laboratorio4.Fragments

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deushdezt.laboratorio4.Adapter.MovieAdapter
import com.deushdezt.laboratorio4.Database.ViewModel.MovieViewModel
import com.deushdezt.laboratorio4.Database.pojos.Movie
import com.deushdezt.laboratorio4.R
import com.deushdezt.laboratorio4.activities.MovieViewerActivity
import kotlinx.android.synthetic.main.movies_list_fragment.*

class MovieListFragment : Fragment(){

    private lateinit var viewModel : MovieViewModel
    private lateinit var adapter : MovieAdapter
    private lateinit var recycler : RecyclerView
    private lateinit var btn_search : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle? ): View? {
        val view = inflater.inflate(R.layout.movies_list_fragment,container,false)
        bind(view)
        return view
    }

    private fun bind(view:View){
        recycler = view.findViewById(R.id.rv_movies)
        btn_search = view.findViewById(R.id.btn_movie)
        adapter = MovieAdapter(ArrayList(),{movie:Movie -> triggerActivity(movie)})
        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        recycler.apply{
            adapter=this@MovieListFragment.adapter
            layoutManager= LinearLayoutManager(context)
        }
        viewModel.getAll().observe(this, Observer{
            adapter.updateList(it)
        })

        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
if(isConnected){  btn_search.setOnClickListener{
    viewModel.retrieveMovies(et_movie.text.toString())
}}


    }

    fun triggerActivity(movie: Movie){
        val movieBundle = Bundle()
        movieBundle.putParcelable("movie",movie)
        startActivity(Intent(requireContext(), MovieViewerActivity::class.java).putExtras(movieBundle))
    }

}