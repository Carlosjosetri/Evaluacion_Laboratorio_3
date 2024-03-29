package com.deushdezt.laboratorio4.Fragments

import android.content.Context
import android.content.Intent

import android.net.ConnectivityManager
import android.net.NetworkInfo

import android.content.res.Configuration

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
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.movies_list_fragment.*




class MovieListFragment : Fragment(){

    private lateinit var viewModel : MovieViewModel
    private lateinit var adapter : MovieAdapter
    private lateinit var recycler : RecyclerView
    var listenerTool : SearchNewMovieListener? = null
    private lateinit var btn_search : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle? ): View? {
        val view = inflater.inflate(com.deushdezt.laboratorio4.R.layout.movies_list_fragment,container,false)
        bind(resources.configuration.orientation,view)
        return view
    }

    interface SearchNewMovieListener{
        fun manageLandscapeItemClick(movie: Movie)
        fun managePortraitItemClick(movie: Movie)
    }

    private fun bind(orientation:Int,view:View){
        recycler = view.findViewById(com.deushdezt.laboratorio4.R.id.rv_movies)
        btn_search = view.findViewById(com.deushdezt.laboratorio4.R.id.btn_movie)
        if(orientation== Configuration.ORIENTATION_PORTRAIT) {
            adapter = MovieAdapter(ArrayList(),{movie:Movie -> listenerTool?.managePortraitItemClick(movie)})
        }
        if(orientation==Configuration.ORIENTATION_LANDSCAPE){
            adapter = MovieAdapter(ArrayList(),{movie:Movie -> listenerTool?.manageLandscapeItemClick(movie)})
        }
        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        recycler.apply{
            adapter=this@MovieListFragment.adapter
            layoutManager= LinearLayoutManager(context)
        }
        viewModel.getAll().observe(this, Observer{
            adapter.updateList(it)
        })

        btn_search.setOnClickListener{
            if(isNetworkConnected()==true){
                viewModel.retrieveMovies(et_movie.text.toString())
            }
            else{
                   var snack: Snackbar = Snackbar.make(view,"    NO HAY CONEXIÓN A INTERNET",
                       Snackbar.LENGTH_LONG)
                    snack.show()

            }
        }
    }

    protected fun isNetworkConnected(): Boolean {
        try {
            val mConnectivityManager =
                activity!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val mNetworkInfo = mConnectivityManager.activeNetworkInfo
            return if (mNetworkInfo == null) false else true

        } catch (e: NullPointerException) {
            return false

        }

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is SearchNewMovieListener) {
            listenerTool = context
        } else {
            throw RuntimeException("Se necesita una implementación de  la interfaz")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listenerTool = null
    }


}