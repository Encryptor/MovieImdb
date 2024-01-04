package com.imdbmovie.info.api

import com.imdbmovie.info.MoviesResponse
import com.imdbmovie.info.PostMovieRating
import com.imdbmovie.info.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesAPI {

    @GET("3/movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY
    ): Response<MoviesResponse>

    @Headers("Content-Type: application/json;charset=utf-8")
    @POST("3/movie/{movie_id}/rating")
    suspend fun submitMovieRating(
        @Path("movie_id") movie_id: Int,
        @Body postMovieRating: PostMovieRating,
        @Query("api_key") apiKey: String = API_KEY
    ): Response<Unit>

}