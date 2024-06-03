package com.quyduoi.lab7_md18309_ph41939.response

import com.google.gson.annotations.SerializedName
import com.quyduoi.lab7_md18309_ph41939.model.Movie

data class MovieResponse(
    @SerializedName("id") val filmId: String,
    @SerializedName("filmName") val filmName: String,
    @SerializedName("duration") val duration: String,
    @SerializedName("releaseDate") val releaseDate: String,
    @SerializedName("genre") val genre: String,
    @SerializedName("national") val national: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String,
){
    fun toMovie(): Movie {
        return Movie(
            id = this.filmId,
            filmName = this.filmName,
            duration = this.duration,
            releaseDate = this.releaseDate,
            genre = this.genre,
            national = this.national,
            description = this.description,
            image = this.image
        )
    }
}