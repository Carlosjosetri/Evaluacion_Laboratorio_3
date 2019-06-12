package com.deushdezt.laboratorio4.Database.ViewModel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.deushdezt.laboratorio4.Database.MovieRoomDatabase

import com.deushdezt.laboratorio4.Database.Repository.MovieRepository

import com.deushdezt.laboratorio4.Database.pojos.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(val app: Application):AndroidViewModel(app){
    private val repository:MovieRepository


    init{
        val movieDao = MovieRoomDatabase.getInstance(app).movieDao()
        repository = MovieRepository(movieDao)
    }

    private suspend fun insert(movie: Movie)=repository.insert(movie)

    private suspend fun delete()= repository.delete()

    fun retrieveMovies(name: String) = viewModelScope.launch(){
        this@MovieViewModel.delete()

        val response = repository.RetriveMoviesAsync(name).await()

        if (response.isSuccessful) with(response){

            this.body()?.search?.forEach{
                val response2 = repository.retriveInfoAsync(it.id).await()

                if(response2.isSuccessful) with (response2){
                    this@MovieViewModel.insert(this.body()!!)
                }else with(response2){
                    when(this.code()){
                        404->{
                            Toast.makeText(app,"Error",Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
        else with(response){
            when(this.code()){
                404->{
                    Toast.makeText(app, "User not found", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun getAll(): LiveData<List<Movie>> {
        return repository.getAllMovies()
    }


}