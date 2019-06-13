package com.deushdezt.laboratorio4.Adapter



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.deushdezt.laboratorio4.Database.pojos.Movie
import com.deushdezt.laboratorio4.R
import kotlinx.android.synthetic.main.cardview_movie.view.*

class MovieAdapter(var movies:List<Movie>,val clickListener: (Movie)-> Unit): RecyclerView.Adapter<MovieAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int):ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_movie,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount():Int{
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder,position:Int){
        holder.bind(movies[position],clickListener)
    }

    fun updateList(newMovies : List<Movie>){
        newMovies.forEach{
            println("Nueva movie :o")
        }
        this.movies=newMovies
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(movie: Movie,clickListener: (Movie) -> Unit) = with(itemView){
            this.movie_rate_cv.text=movie.imdbRating
            this.movie_plot_cv.text=movie.Plot
            this.movie_runtime_cv.text=movie.Runtime
            this.movie_title_cv.text = movie.Title
            Glide.with(itemView.context).load(movie.Poster)
                .placeholder(R.drawable.ic_launcher_background)
                .into(movie_image_cv)
            this.setOnClickListener{clickListener(movie)}
        }
    }
}