package com.hafizcode.moviesandtv.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hafizcode.moviesandtv.R
import com.hafizcode.moviesandtv.data.DataEntity
import com.hafizcode.moviesandtv.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var activityDetailBinding: ActivityDetailBinding

    companion object {
        const val DATA_ID = "DATA_ID"
        const val DATA_TYPE = "DATA_TYPE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        val dataId = intent.getStringExtra(DATA_ID)!!
        val dataType = intent.getStringExtra(DATA_TYPE)!!

        supportActionBar?.title =
            if (dataType == R.string.type_movie.toString()) "Detail Movie" else "Detail TV"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]

        if (intent.extras != null) {
            if (dataType == R.string.type_movie.toString()) {
                viewModel.setMovieId(dataId)
                displayContent(viewModel.getMovieById())
            } else if (dataType == R.string.type_tv.toString()) {
                viewModel.setTvId(dataId)
                displayContent(viewModel.getTvById())
            }
        }

    }

    @SuppressLint("SetTextI18n")
    private fun displayContent(data: DataEntity) {
        Glide.with(applicationContext).load(data.imgPoster).apply(
            RequestOptions.placeholderOf(R.drawable.ic_loading_black)
                .error(R.drawable.ic_error_image)
        ).apply(RequestOptions().override(700, 700)).into(activityDetailBinding.imageItem)

        activityDetailBinding.textTitle.text = data.title
        activityDetailBinding.textRatingFilm.text = data.ratingFilm
        activityDetailBinding.textGenre.text = data.genre
        activityDetailBinding.textRatingHour.text =
            getString(R.string.rating_hour, data.ratingFor, data.playedHour)
        activityDetailBinding.textDate.text = data.releasedYear
        activityDetailBinding.textDescription.text = data.description
    }
}