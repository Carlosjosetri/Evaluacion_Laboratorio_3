package com.deushdezt.laboratorio4.network

import com.deushdezt.laboratorio4.pojos.Movie
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

    @GET()
    fun getMovies(
        @Query("apikey") apikey:String,
        @Query("s") s:String
    ) : Deferred<Response<List<Movie>>>

    companion object{

        var INSTANCE: OMDBService? = null


        fun getGithubService(): OMDBService{
            if (INSTANCE!=null){
                return INSTANCE!!
            }else{
                INSTANCE = Retrofit
                    .Builder()
                    .baseUrl(OMDB_BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .build()
                    .create(OMDBService::class.java)
                return INSTANCE!!
            }
        }
    }
}