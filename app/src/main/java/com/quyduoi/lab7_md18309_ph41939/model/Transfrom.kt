package com.example.kot104.model

import com.quyduoi.lab7_md18309_ph41939.model.Movie
import com.quyduoi.lab7_md18309_ph41939.response.MovieResponse
import com.quyduoi.lab7_md18309_ph41939.ui.screens.MovieFormData

class Transfrom {
    fun MovieResponse.toMovie(): Movie {
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

    fun MovieFormData.toMovieRequest(): MovieRequest {
//        val filmIdInt = try {
//            this.id?.toIntOrNull()
//        } catch (e: NumberFormatException) {
//            null
//        }
        val durationInt = try {
            this.duration.toInt()
        } catch (e: NumberFormatException) {
            0
        }
        return MovieRequest(
            filmId = this.id,
            filmName = this.filmName,
            duration = durationInt,
            releaseDate = this.releaseDate,
            genre = this.genre,
            national = this.national,
            description = this.description,
            image = this.imageUrl
        )
    }

    fun Movie?.toMovieFormData() = this?.let {
        MovieFormData(
            this.id,
            this.filmName,
            this.duration,
            this.releaseDate,
            this.genre,
            this.national,
            this.description,
            this.image
        )
    }
}