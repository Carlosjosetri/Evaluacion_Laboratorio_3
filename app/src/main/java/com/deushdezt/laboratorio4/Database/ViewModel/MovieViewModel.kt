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
    val allMovies: LiveData<List<Movie>>

    init{
        val movieDao = MovieRoomDatabase.getDatabase(app,viewModelScope).MovieDao()
        repository = MovieRepository(movieDao)
        allMovies = repository.getAllMovies()
    }

    private suspend fun insert(movie: Movie)=repository.insert(movie)

    fun search(pattern:String)=viewModelScope.launch(Dispatchers.IO){
        repository.searchMovie(pattern)
    }

    private suspend fun delete()= repository.delete()

    fun retrieveMovies(name: String) = viewModelScope.launch(){
        this@MovieViewModel.delete()//TODO OBTENEMOS NUESTRA TABLA LIMPIA

        val response = repository.RetriveMoviesAsync(name).await()

        if (response.isSuccessful) with(response){
            //TODO WITH TRABAJA CON LA VARIABLE QUE LE MANDAS
            this.body()?.forEach{
                this@MovieViewModel.insert(it)
            }//TODO PUEDE QUE VENGA VACIO POR ESO EL NULO
        }
        else with(response){
            when(this.code()){
                404->{
                    Toast.makeText(app, "User not found", Toast.LENGTH_LONG).show()
                }
            }
        }
    }


}