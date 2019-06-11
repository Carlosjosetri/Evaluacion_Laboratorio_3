package com.deushdezt.laboratorio4.Repository

import androidx.lifecycle.LiveData
import com.deushdezt.laboratorio4.DAO.MovieDao
import com.deushdezt.laboratorio4.network.OMDBService
import com.deushdezt.laboratorio4.network.OMDB_API_KEY
import com.deushdezt.laboratorio4.pojos.Movie
import kotlinx.coroutines.Deferred
import retrofit2.Response

class MovieRepository(private val movie : MovieDao,private val omdbService: OMDBService){

    fun getAllMovies(): LiveData<List<Movie>> = movie.getAllMovies()

    fun searchMovie(pattern :String): LiveData<List<Movie>> = movie.searchMoviePattern(pattern)

    fun retrieveMoviesAsync(movie: String): Deferred<Response<List<Movie>>> {
        return omdbService.getMovies(OMDB_API_KEY,movie);
    }
}