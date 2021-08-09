package com.hafizcode.moviesandtv.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hafizcode.moviesandtv.R
import com.hafizcode.moviesandtv.data.DataEntity
import com.hafizcode.moviesandtv.databinding.ActivityDetailBinding
import com.hafizcode.moviesandtv.utils.Helper.IMAGE_API_ENDPOINT
import com.hafizcode.moviesandtv.utils.Helper.MOVIE_TYPE
import com.hafizcode.moviesandtv.utils.Helper.TV_TYPE
import com.hafizcode.moviesandtv.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {
    companion object {
        const val DATA_ID = "DATA_ID"
        const val DATA_TYPE = "DATA_TYPE"
    }

    private lateinit var activityDetailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        val dataId = intent.getStringExtra(DATA_ID)!!
        val dataType = intent.getStringExtra(DATA_TYPE)!!

        supportActionBar?.title =
            if (dataType == MOVIE_TYPE) "Detail Movie" else "Detail TV"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        if (intent.extras != null) {
            if (dataType.equals(MOVIE_TYPE, true)) {
                viewModel.getDetailMovie(dataId.toInt()).observe(this, {
                    Log.d("DATA MOVIE DETAIL", it.toString())
                    displayContent(it)
                })
            } else if (dataType.equals(TV_TYPE, true)) {
                viewModel.getDetailTV(dataId.toInt()).observe(this, {
                    Log.d("DATA TV DETAIL", it.toString())
                    displayContent(it)
                })
            }
        }

    }

    private fun displayContent(data: DataEntity) {
        Glide.with(applicationContext).load(IMAGE_API_ENDPOINT + data.imgPoster).apply(
            RequestOptions.placeholderOf(R.drawable.ic_loading_black)
                .error(R.drawable.ic_error_image)
        ).apply(RequestOptions().override(700, 700)).into(activityDetailBinding.imageItem)

        activityDetailBinding.textTitle.text = data.title
        activityDetailBinding.textRatingFilm.text = data.ratingFilm
        activityDetailBinding.textGenre.text = when (data.genre?.isNotEmpty()) {
            true -> data.genre
            else -> getString(R.string.no_genres)
        }

        val tempRatingFor = when (data.ratingFor?.isNotEmpty()) {
            true -> data.ratingFor.toString()
            else -> getString(R.string.dashes)
        }
        val tempPlayedHour = when (data.playedHour?.isNotEmpty()) {
            true -> data.playedHour.toString()
            else -> getString(R.string.dashes)
        }
        activityDetailBinding.textRatingHour.text =
            getString(R.string.rating_hour, tempRatingFor, tempPlayedHour)

        activityDetailBinding.textDate.text = when (data.releasedYear?.isNotEmpty()) {
            true -> data.releasedYear
            else -> getString(R.string.dashes)
        }

        activityDetailBinding.textDescription.text = when (data.description?.isNotEmpty()) {
            true -> data.description
            else -> getString(R.string.no_description)
        }
    }
}