package com.hafizcode.moviesandtv.ui.home.content.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hafizcode.moviesandtv.R
import com.hafizcode.moviesandtv.data.DataEntity
import com.hafizcode.moviesandtv.databinding.ItemRowBinding

class TvAdapter(private val callback: TvFragment) :
    RecyclerView.Adapter<TvAdapter.TvViewHolder>() {

    private val listTV = ArrayList<DataEntity>()

    fun setTV(tv: List<DataEntity>?) {
        if (tv == null) return
        listTV.clear()
        listTV.addAll(tv)
    }

    inner class TvViewHolder(private val binding: ItemRowBinding) :
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val itemRowBinding =
            ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvViewHolder(itemRowBinding)
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val tvs = listTV[position]
        holder.bind(tvs)
    }

    override fun getItemCount(): Int = listTV.size
}