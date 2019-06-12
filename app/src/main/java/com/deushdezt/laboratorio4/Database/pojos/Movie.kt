package com.deushdezt.laboratorio4.Database.pojos

import androidx.room.Entity
import com.squareup.moshi.Json


@Entity(tableName = "movies")
data class Movie (
    @field:Json(name = "title") val Title:String,
    @field:Json(name = "year") val Year:String,
    @field:Json(name = "release") val Released: String,
    @field:Json(name = "runtime") val Runtime:String,
    @field:Json(name = "genre") val Genre:String,
    @field:Json(name = "director") val Director:String,
    @field:Json(name = "actors") val Actors:String,
    @field:Json(name = "plot") val Plot:String,
    @field:Json(name = "language") val Language:String,
    @field:Json(name = "imdb") val imdbRating:String,
    @field:Json(name = "poster") val Poster:String
)