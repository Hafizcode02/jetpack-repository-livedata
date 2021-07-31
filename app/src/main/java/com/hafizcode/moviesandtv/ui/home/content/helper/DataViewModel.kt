package com.hafizcode.moviesandtv.ui.home.content.helper

import androidx.lifecycle.ViewModel
import com.hafizcode.moviesandtv.data.DataEntity
import com.hafizcode.moviesandtv.utils.DataDummy

class DataViewModel : ViewModel() {
    fun getMovies(): List<DataEntity> = DataDummy.generateDummyMovies()
    fun getTvs(): List<DataEntity> = DataDummy.generateDummyTV()
}