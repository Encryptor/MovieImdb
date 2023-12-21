package com.canopytax.interview.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.canopytax.interview.R
import com.canopytax.interview.adapters.MoviesAdapter
import com.canopytax.interview.ui.MainActivity
import com.canopytax.interview.ui.MovieViewModel
import com.canopytax.interview.util.Constants.Companion.TAG
import com.canopytax.interview.util.Resource

class PopularMoviesFragment: Fragment(R.layout.fragment_popular_movies){

    lateinit var viewModel: MovieViewModel
    lateinit var movieAdapter: MoviesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel
        setRecyclerview()

        var movieDetailFragment = MovieDetailFragment()

        movieAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("movie", it)
            }
            findNavController().navigate(
                R.id.action_popularMoviesFragment_to_movieDetailFragment,
                bundle
            )
        }

        viewModel.popularMovies.observe(viewLifecycleOwner, Observer { response ->
            when(response) {
                is Resource.Loading -> {
                    showProgressBar()
                }
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {
                        movieAdapter.differ.submitList(it.results)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let {
                        Log.e(TAG, "Error received")
                    }
                }
            }
        })
    }

    private fun hideProgressBar() {
        activity?.findViewById<ProgressBar>(R.id.paginationProgressBar)?.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        activity?.findViewById<ProgressBar>(R.id.paginationProgressBar)?.visibility = View.VISIBLE
    }

    private fun setRecyclerview() {
        movieAdapter = MoviesAdapter()
        activity?.findViewById<RecyclerView>(R.id.rvPopularMovies)?.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(activity)
        }

    }
}