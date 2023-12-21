package com.canopytax.interview.repository

import com.canopytax.interview.PostMovieRating
import com.canopytax.interview.api.RetrofitInstance

class MovieRepository {

    suspend fun getPopularMovies() =
        RetrofitInstance.api.getPopularMovies()

    suspend fun submitMovieRating(movieId: Int, postMovieRating: PostMovieRating) =
        RetrofitInstance.api.submitMovieRating(movieId, postMovieRating)
}