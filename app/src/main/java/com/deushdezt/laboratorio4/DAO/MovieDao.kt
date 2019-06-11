package com.deushdezt.laboratorio4.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.deushdezt.laboratorio4.pojos.Movie

@Dao
interface MovieDao{

    @Query("SELECT * from movies ORDER BY id ASC")
    fun getAllMovies() : LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: Movie)

    @Query("SELECT * FROM movies WHERE title LIKE :pattern")
    fun searchMoviePattern(pattern : String): LiveData<List<Movie>>

}