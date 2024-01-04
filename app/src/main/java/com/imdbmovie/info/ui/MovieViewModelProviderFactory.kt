package com.imdbmovie.info.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.imdbmovie.info.repository.MovieRepository

class MovieViewModelProviderFactory (
    val movieRepository: MovieRepository
): ViewModelProvider.Factory {

    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(movieRepository) as T

    }

}