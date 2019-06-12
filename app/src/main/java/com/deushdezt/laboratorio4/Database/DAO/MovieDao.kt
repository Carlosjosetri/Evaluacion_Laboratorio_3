package com.deushdezt.laboratorio4.Database.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.deushdezt.laboratorio4.Database.pojos.Movie

@Dao
interface MovieDao{

    @Query("SELECT * from movies ")
    fun getAllMovies() : LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: Movie)

    @Query("SELECT * FROM movies WHERE title LIKE :pattern")
    fun searchMoviePattern(pattern : String): LiveData<List<Movie>>

    @Query("DELETE FROM movies")
    suspend fun delete()

}