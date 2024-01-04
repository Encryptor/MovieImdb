package com.imdbmovie.info.repository

import com.imdbmovie.info.PostMovieRating
import com.imdbmovie.info.api.RetrofitInstance

class MovieRepository {

    suspend fun getPopularMovies() =
        RetrofitInstance.api.getPopularMovies()

    suspend fun submitMovieRating(movieId: Int, postMovieRating: PostMovieRating) =
        RetrofitInstance.api.submitMovieRating(movieId, postMovieRating)
}