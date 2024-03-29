package com.deushdezt.laboratorio4.Database.pojos

import com.squareup.moshi.Json

data class MovieFake(
    @field:Json(name ="Search") val search : List<Movie>,
    @field:Json(name = "totalResults") val totalResults : String
    )