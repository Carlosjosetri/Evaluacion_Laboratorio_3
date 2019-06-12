package com.deushdezt.laboratorio4

import com.deushdezt.laboratorio4.Database.pojos.Movie

object AppConstants{
    val dataset_saveinstance_key = "CLE"
    val MAIN_LIST_KEY = "key_list_movies"
}

interface MyMovieAdapter {
    fun changeDataSet(newDataSet : List<Movie>)
}