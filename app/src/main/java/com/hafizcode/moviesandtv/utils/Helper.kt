@file:Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.hafizcode.moviesandtv.utils

import android.annotation.SuppressLint
import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hafizcode.moviesandtv.R
import java.text.SimpleDateFormat

object Helper {

    const val IMAGE_API_ENDPOINT = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/"
    const val MOVIE_TYPE = "MOVIE"
    const val TV_TYPE = "TV"

    fun convertMinutesToHour(runTime: Int): String {
        val hour = runTime / 60
        val minutes = runTime % 60

        return "${hour}h ${minutes}m"
    }


    @SuppressLint("SimpleDateFormat")
    fun convertDate(dateText: String): String {
        val parser = SimpleDateFormat("yyyy-mm-dd")
        val formatter = SimpleDateFormat("dd MMMM yyyy")
        return formatter.format(parser.parse(dateText))
    }

    fun setImageWithGlide(context: Context, imagePath: String, imageView: ImageView) {
        Glide.with(context).clear(imageView)
        Glide.with(context).load(imagePath).apply(
            RequestOptions.placeholderOf(R.drawable.ic_loading_black)
                .error(R.drawable.ic_error_image)
        ).into(imageView)
    }
}