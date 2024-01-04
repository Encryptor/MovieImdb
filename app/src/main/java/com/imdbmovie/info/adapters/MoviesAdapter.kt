package com.imdbmovie.info.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.imdbmovie.info.R
import com.imdbmovie.info.Results
import com.imdbmovie.info.util.Constants.Companion.MOIVE_POSTER_BASE_URL

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val differCallback = object: DiffUtil.ItemCallback<Results>() {
        override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_movie_preview,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(MOIVE_POSTER_BASE_URL + movie.poster_path).into(findViewById(R.id.ivImage))
            findViewById<TextView>(R.id.tvTitle).text = movie.title

            setOnClickListener {
                onItemClickListener?.let { it(movie) }
            }
        }
    }

    private var onItemClickListener: ((Results) -> Unit)? = null

    fun setOnItemClickListener(listener: (Results) -> Unit) {
        onItemClickListener = listener
    }
}