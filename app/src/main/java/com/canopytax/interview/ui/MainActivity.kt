package com.canopytax.interview.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.canopytax.interview.databinding.ActivityPopularMoviesBinding
import com.canopytax.interview.repository.MovieRepository

// TODO - API Key
// 6dac54e6fff5819e01edeee0cb1e6e60

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