package com.deushdezt.laboratorio4.Database.pojos

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


@Entity(tableName = "movies")
data class Movie (
    @PrimaryKey @field:Json(name = "Title") val Title:String = "N/A",
    @field:Json(name = "Year") val Year:String = "N/A",
    @field:Json(name = "imdbID") val id:String = "N/A",
    @field:Json(name = "Released") val Released: String = "N/A",
    @field:Json(name = "Runtime") val Runtime:String = "N/A",
    @field:Json(name = "Genre") val Genre:String = "N/A",
    @field:Json(name = "Director") val Director:String = "N/A",
    @field:Json(name = "Actors") val Actors:String = "N/A",
    @field:Json(name = "Plot") val Plot:String = "N/A",
    @field:Json(name = "Language") val Language:String = "N/A",
    @field:Json(name = "imdbRating") val imdbRating:String = "N/A",
    @field:Json(name = "Poster") val Poster:String = "N/A"
) : Parcelable {
    constructor(parcel: Parcel) : this(
        Title = parcel.readString(),
        Year = parcel.readString(),
        id = parcel.readString(),
        Released = parcel.readString(),
        Runtime = parcel.readString(),
        Genre = parcel.readString(),
        Director = parcel.readString(),
        Actors = parcel.readString(),
        Plot = parcel.readString(),
        Language = parcel.readString(),
        imdbRating = parcel.readString(),
        Poster = parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Title)
        parcel.writeString(Year)
        parcel.writeString(id)
        parcel.writeString(Released)
        parcel.writeString(Runtime)
        parcel.writeString(Genre)
        parcel.writeString(Director)
        parcel.writeString(Actors)
        parcel.writeString(Plot)
        parcel.writeString(Language)
        parcel.writeString(imdbRating)
        parcel.writeString(Poster)
    }

    override fun describeContents() = 0

    companion object {
        @JvmField val CREATOR = object : Parcelable.Creator<Movie> {
            override fun createFromParcel(parcel: Parcel): Movie = Movie(parcel)
            override fun newArray(size: Int): Array<Movie?> = arrayOfNulls(size)
        }
    }

}