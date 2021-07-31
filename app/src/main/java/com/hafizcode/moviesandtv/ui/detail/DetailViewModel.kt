package com.hafizcode.moviesandtv.ui.detail

import androidx.lifecycle.ViewModel
import com.hafizcode.moviesandtv.data.DataEntity
import com.hafizcode.moviesandtv.utils.DataDummy

class DetailViewModel : ViewModel() {
    private lateinit var movieId: String
    private lateinit var tvId: String
    private lateinit var result: DataEntity

    private fun getListMovie(): ArrayList<DataEntity> =
        DataDummy.generateDummyMovies() as ArrayList<DataEntity>

    private fun getListTv(): ArrayList<DataEntity> =
        DataDummy.generateDummyTV() as ArrayList<DataEntity>

    fun setMovieId(movieId: String) {
        this.movieId = movieId
    }

    fun setTvId(tvId: String) {
        this.tvId = tvId
    }

    fun getMovieById(): DataEntity {
        val listMovie = getListMovie()
        for (movie in listMovie) {
            if (movie.id == movieId) {
                result = movie
                break
            }
        }
        return result
    }

    fun getTvById(): DataEntity {
        val listTv = getListTv()
        for (tv in listTv) {
            if (tv.id == tvId) {
                result = tv
                break
            }
        }
        return result
    }
}