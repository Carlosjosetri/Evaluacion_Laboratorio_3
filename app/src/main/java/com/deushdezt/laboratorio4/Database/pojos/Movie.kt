package com.deushdezt.laboratorio4.Database.pojos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


@Entity(tableName = "movies")
data class Movie (
    @PrimaryKey @field:Json(name = "Title") val Title:String,
    @field:Json(name = "Year") val Year:String,
    @field:Json(name = "imdbID") val id:String,
    @field:Json(name = "Released") val Released: String,
    @field:Json(name = "Runtime") val Runtime:String,
    @field:Json(name = "Genre") val Genre:String,
    @field:Json(name = "Director") val Director:String,
    @field:Json(name = "Actors") val Actors:String,
    @field:Json(name = "Plot") val Plot:String,
    @field:Json(name = "Language") val Language:String,
    @field:Json(name = "imdbRating") val imdbRating:String,
    @field:Json(name = "Poster") val Poster:String
)