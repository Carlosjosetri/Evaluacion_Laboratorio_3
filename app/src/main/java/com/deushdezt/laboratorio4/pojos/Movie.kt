package com.deushdezt.laboratorio4.pojos

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movies")
data class Movie (
    @ColumnInfo(name = "title") val Title:String = "N/A",
    @ColumnInfo(name = "year") val Year:String = "N/A",
    @ColumnInfo(name = "release") val Released: String = "N/A",
    @ColumnInfo(name = "runtime") val Runtime:String = "N/A",
    @ColumnInfo(name = "genre") val Genre:String = "N/A",
    @ColumnInfo(name = "director") val Director:String = "N/A",
    @ColumnInfo(name = "actors") val Actors:String = "N/A",
    @ColumnInfo(name = "plot") val Plot:String = "N/A",
    @ColumnInfo(name = "language") val Language:String = "N/A",
    @ColumnInfo(name = "imdb") val imdbRating:String = "N/A",
    @ColumnInfo(name = "poster") val Poster:String = "N/A"
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id : Int = 0
    constructor(parcel: Parcel) : this(
        Title = parcel.readString(),
        Year = parcel.readString(),
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

