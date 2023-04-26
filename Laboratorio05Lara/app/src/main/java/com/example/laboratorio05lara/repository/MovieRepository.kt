package com.example.laboratorio05lara.repository

import com.example.laboratorio05lara.data.ViewModels.MovieModel

class MovieRepository(private val movies: MutableList<MovieModel>) {
    fun getMovies() = movies
    fun addMovie(newMovie: MovieModel) = movies.add(newMovie)
}