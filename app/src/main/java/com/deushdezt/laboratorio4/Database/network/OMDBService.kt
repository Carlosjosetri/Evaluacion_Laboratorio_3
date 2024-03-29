package com.deushdezt.laboratorio4.Database.network

import com.deushdezt.laboratorio4.Database.pojos.Movie
import com.deushdezt.laboratorio4.Database.pojos.MovieFake
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val OMDB_BASE_URL = "http://www.omdbapi.com/"
const val OMDB_API_KEY = "4625dd51"

interface OMDBService {

    @GET("?apikey=4625dd51")
    fun getMovies(@Query("s")movie: String): Deferred<Response<MovieFake>>

  @GET("?apikey=4625dd51")
  fun getInfo(
      @Query("i") s:String
   ) : Deferred<Response<Movie>>

    companion object {
        fun  getMovieService():OMDBService = Retrofit.Builder()
            .baseUrl(OMDB_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build().create(OMDBService::class.java)
    }
}