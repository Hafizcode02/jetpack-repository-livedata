package com.hafizcode.moviesandtv.data.source.remote.api

import com.hafizcode.moviesandtv.BuildConfig
import com.hafizcode.moviesandtv.data.source.remote.response.ListResponse
import com.hafizcode.moviesandtv.data.source.remote.response.MovieResponse
import com.hafizcode.moviesandtv.data.source.remote.response.TVResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/now_playing")
    fun getMovies(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): Call<ListResponse<MovieResponse>>

    @GET("movie/{movie_id}")
    fun getDetailMovies(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): Call<MovieResponse>

    @GET("tv/tv_airing_today")
    fun getTVs(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): Call<ListResponse<TVResponse>>

    @GET("tv/{tv_id}")
    fun getTvDetail(
        @Path("tv_id") tvId: Int,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): Call<TVResponse>

}