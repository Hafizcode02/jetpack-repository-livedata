package com.hafizcode.moviesandtv.di

import com.hafizcode.moviesandtv.data.source.MovieRepository
import com.hafizcode.moviesandtv.data.source.remote.RemoteDataSource

object Injection {
    fun provideMovieRepository(): MovieRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return MovieRepository.getInstance(remoteDataSource)
    }
}