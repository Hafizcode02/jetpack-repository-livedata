package com.hafizcode.moviesandtv.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hafizcode.moviesandtv.R

object Helper {

    const val IMAGE_API_ENDPOINT = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/"

    fun convertMinutesToHour(runTime: Int): String {
        val hour = runTime / 60
        val minutes = runTime % 60

        return "${hour}h ${minutes}m"
    }

    fun convertDate(dateText: String): String {
        return ""
    }

    fun setImageWithGlide(context: Context, imagePath: String, imageView: ImageView) {
        Glide.with(context).clear(imageView)
        Glide.with(context).load(imagePath).apply(
            RequestOptions.placeholderOf(R.drawable.ic_loading_black)
                .error(R.drawable.ic_error_image)
        ).into(imageView)
    }
}