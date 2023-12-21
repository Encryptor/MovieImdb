package com.canopytax.interview.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canopytax.interview.MoviesResponse
import com.canopytax.interview.PostMovieRating
import com.canopytax.interview.repository.MovieRepository
import com.canopytax.interview.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class MovieViewModel(
    val movieRepository: MovieRepository
): ViewModel() {

    val popularMovies: MutableLiveData<Resource<MoviesResponse>> = MutableLiveData()

    init {
        getPopularMovies()
    }

    fun getPopularMovies() = viewModelScope.launch {
        popularMovies.postValue(Resource.Loading())
        val response = movieRepository.getPopularMovies()
        popularMovies.postValue(processPopularMovieResponse(response))
    }

    fun postMovieRating(movieId: Int, postMovieRating: PostMovieRating) = viewModelScope.launch {
       movieRepository.submitMovieRating(movieId, postMovieRating)
    }

    private fun processPopularMovieResponse(response: Response<MoviesResponse>): Resource<MoviesResponse> {
        if (response.isSuccessful) {
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }
}