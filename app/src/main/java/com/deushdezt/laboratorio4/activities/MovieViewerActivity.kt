package com.deushdezt.laboratorio4.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.deushdezt.laboratorio4.Database.pojos.Movie
import com.deushdezt.laboratorio4.R
import kotlinx.android.synthetic.main.viewer_movie.*

class MovieViewerActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.viewer_movie)
        val movie : Movie = intent.extras.getParcelable("movie")

        Glide.with(this)
            .load(movie.Poster)
            .placeholder(R.drawable.ic_launcher_background)
            .into(app_bar_image_viewer)
        collapsingtoolbarviewer.title = movie.Title
        app_bar_rating_viewer.text = movie.imdbRating
        plot_viewer.text = movie.Plot
        director_viewer.text = movie.Director
        actors_viewer.text = movie.Actors
        genre_viewer.text = movie.Genre
        released_viewer.text = movie.Released
    }


}
