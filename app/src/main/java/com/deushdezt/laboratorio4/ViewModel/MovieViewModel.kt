package com.deushdezt.laboratorio4.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.deushdezt.laboratorio4.Database.MovieRoomDatabase
import com.deushdezt.laboratorio4.Repository.MovieRepository
import com.deushdezt.laboratorio4.pojos.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(application: Application):AndroidViewModel(application){
    private val repository:MovieRepository
    val allMovies: LiveData<List<Movie>>

    init{
        val movieDao = MovieRoomDatabase.getDatabase(application,viewModelScope).MovieDao()
        repository = MovieRepository(movieDao)
        allMovies = repository.getAllMovies()
    }

    fun search(pattern:String)=viewModelScope.launch(Dispatchers.IO){
        repository.searchMovie(pattern)
    }
}