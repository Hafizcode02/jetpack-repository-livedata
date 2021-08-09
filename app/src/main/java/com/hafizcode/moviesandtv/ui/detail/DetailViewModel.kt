package com.hafizcode.moviesandtv.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hafizcode.moviesandtv.data.DataEntity
import com.hafizcode.moviesandtv.data.source.MovieRepository

class DetailViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getDetailMovie(movieId: Int): LiveData<DataEntity> = movieRepository.getMovieDetail(movieId)
    fun getDetailTV(tvId: Int): LiveData<DataEntity> = movieRepository.getTVDetail(tvId)
}