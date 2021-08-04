package com.hafizcode.moviesandtv.ui.home.content.helper

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hafizcode.moviesandtv.data.DataEntity
import com.hafizcode.moviesandtv.data.source.MovieRepository

class DataViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getMovies(): LiveData<List<DataEntity>> = movieRepository.getMovies()
    fun getTvs(): LiveData<List<DataEntity>> = movieRepository.getTVs()
}