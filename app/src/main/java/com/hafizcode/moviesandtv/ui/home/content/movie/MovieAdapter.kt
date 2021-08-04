package com.hafizcode.moviesandtv.ui.home.content.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hafizcode.moviesandtv.data.DataEntity
import com.hafizcode.moviesandtv.databinding.ItemRowBinding
import com.hafizcode.moviesandtv.utils.Helper.IMAGE_API_ENDPOINT
import com.hafizcode.moviesandtv.utils.Helper.setImageWithGlide

class MovieAdapter(private val callback: MovieFragment) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val listMovies = ArrayList<DataEntity>()

    fun setMovies(movies: List<DataEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
        notifyDataSetChanged()
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
                setImageWithGlide(
                    itemView.context,
                    IMAGE_API_ENDPOINT + data.imgPoster,
                    imgItemPhoto
                )
                itemView.setOnClickListener {
                    callback.onItemClicked(data)
                }
            }
        }
    }

}