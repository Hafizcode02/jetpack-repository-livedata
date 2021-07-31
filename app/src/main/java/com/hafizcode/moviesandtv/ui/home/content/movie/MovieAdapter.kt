package com.hafizcode.moviesandtv.ui.home.content.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hafizcode.moviesandtv.R
import com.hafizcode.moviesandtv.data.DataEntity
import com.hafizcode.moviesandtv.databinding.ItemRowBinding

class MovieAdapter(private val callback: MovieFragment) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val listMovies = ArrayList<DataEntity>()

    fun setMovies(movies: List<DataEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemRowBinding =
            ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemRowBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size

    inner class MovieViewHolder(private val binding: ItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataEntity) {
            with(binding) {
                tvTitle.text = data.title
                Glide.with(itemView.context)
                    .load(data.imgPoster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading_black)
                            .error(R.drawable.ic_error_image)
                    )
                    .into(imgItemPhoto)
                itemView.setOnClickListener {
                    callback.onItemClicked(data)
                }
            }
        }
    }

}