package com.example.laboratorio05lara.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.laboratorio05lara.MovieReviewerApplication
import com.example.laboratorio05lara.data.ViewModels.MovieModel
import com.example.laboratorio05lara.repository.MovieRepository

class MovieViewModel(private val repository: MovieRepository):ViewModel() {
    fun getMovies() = repository.getMovies()
    fun addMovies(movie: MovieModel) = repository.addMovie(movie)

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }
    }
}