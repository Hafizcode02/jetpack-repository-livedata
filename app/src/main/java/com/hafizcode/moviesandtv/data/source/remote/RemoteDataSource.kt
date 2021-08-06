package com.hafizcode.moviesandtv.data.source.remote

import com.hafizcode.moviesandtv.data.source.remote.api.ApiClient
import com.hafizcode.moviesandtv.data.source.remote.response.MovieResponse
import com.hafizcode.moviesandtv.data.source.remote.response.RatedForResponse
import com.hafizcode.moviesandtv.data.source.remote.response.TVRatedResponse
import com.hafizcode.moviesandtv.data.source.remote.response.TVResponse
import com.hafizcode.moviesandtv.utils.EspressoIdlingResource
import retrofit2.await

class RemoteDataSource {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    suspend fun getMovies(callback: LoadMoviesCallback) {
        try {
            EspressoIdlingResource.increment()
            ApiClient.instance.getMovies().await().result?.let { listMovie ->
                callback.onAllMoviesReceived(listMovie)
                EspressoIdlingResource.decrement()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    suspend fun getMovieDetail(movieId: Int, callback: LoadMovieDetailCallback) {
        try {
            EspressoIdlingResource.increment()
            ApiClient.instance.getDetailMovies(movieId).await().let { movie ->
                ApiClient.instance.getRatedForMovies(movieId).await().let { movieRated ->
                    callback.onMovieDetailReceived(movie, movieRated)
                    EspressoIdlingResource.decrement()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    suspend fun getTVs(callback: LoadTvCallback) {
        try {
            EspressoIdlingResource.increment()
            ApiClient.instance.getTVs().await().result?.let { listTV ->
                callback.onAllTvShowsReceived(listTV)
                EspressoIdlingResource.decrement()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    suspend fun getTVDetail(tvId: Int, callback: LoadTvDetailCallback) {
        try {
            EspressoIdlingResource.increment()
            ApiClient.instance.getTvDetail(tvId).await().let { tv ->
                ApiClient.instance.getRatedForTV(tvId).await().let { tvRated ->
                    callback.onTvShowDetailReceived(tv, tvRated)
                    EspressoIdlingResource.decrement()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponse: List<MovieResponse>)
    }

    interface LoadMovieDetailCallback {
        fun onMovieDetailReceived(movieResponse: MovieResponse, ratedForResponse: RatedForResponse)
    }

    interface LoadTvCallback {
        fun onAllTvShowsReceived(tvShowResponse: List<TVResponse>)
    }

    interface LoadTvDetailCallback {
        fun onTvShowDetailReceived(tvShowResponse: TVResponse, tvRatedResponse: TVRatedResponse)
    }
}