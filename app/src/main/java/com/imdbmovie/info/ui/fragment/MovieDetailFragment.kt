package com.imdbmovie.info.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.imdbmovie.info.PostMovieRating
import com.imdbmovie.info.databinding.FragmentMovieDetailBinding
import com.imdbmovie.info.ui.MainActivity
import com.imdbmovie.info.ui.MovieViewModel
import com.imdbmovie.info.util.Constants

class MovieDetailFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailBinding

    lateinit var viewModel: MovieViewModel
    val args: MovieDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel

        binding.tvMovieTitle.text = args.movie.original_title
        binding.tvMovieOverview.text = args.movie.overview
        binding.tvMovieAvgVote.text = args.movie.vote_average.toString()

        Glide.with(this)
            .load(Constants.MOIVE_POSTER_BASE_URL + args.movie.poster_path)
            .into(binding.ivMoviePoster)
    }
}