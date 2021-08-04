package com.hafizcode.moviesandtv.ui.home.content.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hafizcode.moviesandtv.data.DataEntity
import com.hafizcode.moviesandtv.databinding.ItemRowBinding
import com.hafizcode.moviesandtv.utils.Helper.IMAGE_API_ENDPOINT
import com.hafizcode.moviesandtv.utils.Helper.setImageWithGlide

class TvAdapter(private val callback: TvFragment) :
    RecyclerView.Adapter<TvAdapter.TvViewHolder>() {

    private val listTV = ArrayList<DataEntity>()

    fun setTV(tv: List<DataEntity>?) {
        if (tv == null) return
        listTV.clear()
        listTV.addAll(tv)
        notifyDataSetChanged()
    }

    inner class TvViewHolder(private val binding: ItemRowBinding) :
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