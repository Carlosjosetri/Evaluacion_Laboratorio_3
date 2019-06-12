package com.deushdezt.laboratorio4.Database.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.deushdezt.laboratorio4.Database.DAO.MovieDao
import com.deushdezt.laboratorio4.Database.network.OMDBService
import com.deushdezt.laboratorio4.Database.pojos.Movie
import kotlinx.coroutines.Deferred
import retrofit2.Response

class MovieRepository(private val movieDao : MovieDao){
    fun RetriveMoviesAsync(name:String):Deferred<Response<List<Movie>>> =
        OMDBService.getMovieService().getMovies(name)

    fun getAllMovies(): LiveData<List<Movie>> = movieDao.getAllMovies()

    fun searchMovie(pattern :String): LiveData<List<Movie>> = movieDao.searchMoviePattern(pattern)


    @WorkerThread
    suspend fun insert(movie:Movie){
       movieDao.insert(movie)
    }


    @WorkerThread
    suspend fun delete(){
        return movieDao.delete()
    }

//    fun retrieveMoviesAsync(movie: String): Deferred<Response<List<Movie>>> {
//        return omdbService.getMovies(OMDB_API_KEY,movie);
//    }
}