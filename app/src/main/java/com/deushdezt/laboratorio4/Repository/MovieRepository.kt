package com.deushdezt.laboratorio4.Repository

import androidx.lifecycle.LiveData
import com.deushdezt.laboratorio4.DAO.MovieDao
import com.deushdezt.laboratorio4.pojos.Movie

class MovieRepository(private val movie : MovieDao){

    fun getAllMovies(): LiveData<List<Movie>> = movie.getAllMovies()

    fun searchMovie(pattern :String): LiveData<List<Movie>> = movie.searchMoviePattern(pattern)
}