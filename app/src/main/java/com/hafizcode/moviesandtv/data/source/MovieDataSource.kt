package com.hafizcode.moviesandtv.data.source

import androidx.lifecycle.LiveData
import com.hafizcode.moviesandtv.data.DataEntity

interface MovieDataSource {
    fun getMovies(): LiveData<List<DataEntity>>
    fun getMovieDetail(movieId: Int): LiveData<List<DataEntity>>
    fun getTVs(): LiveData<List<DataEntity>>
    fun getTVDetail(tvId: Int): LiveData<List<DataEntity>>
}