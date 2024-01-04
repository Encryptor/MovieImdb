package com.imdbmovie.info.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.imdbmovie.info.databinding.ActivityPopularMoviesBinding
import com.imdbmovie.info.repository.MovieRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPopularMoviesBinding
    lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPopularMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = MovieRepository()
        val viewModelProviderFactory = MovieViewModelProviderFactory(repository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(MovieViewModel::class.java)
    }
}