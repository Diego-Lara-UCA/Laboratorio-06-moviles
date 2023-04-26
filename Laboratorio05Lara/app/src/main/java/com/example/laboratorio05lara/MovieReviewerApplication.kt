package com.example.laboratorio05lara

import android.app.Application
import com.example.laboratorio05lara.data.movies
import com.example.laboratorio05lara.repository.MovieRepository

class MovieReviewerApplication: Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}