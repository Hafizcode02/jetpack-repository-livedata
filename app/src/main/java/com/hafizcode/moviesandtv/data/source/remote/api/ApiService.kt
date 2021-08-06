package com.hafizcode.moviesandtv.data.source.remote.api

import com.hafizcode.moviesandtv.BuildConfig
import com.hafizcode.moviesandtv.data.source.remote.response.*
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

    @GET("movie/{movie_id}/release_dates")
    fun getRatedForMovies(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): Call<RatedForResponse>

    @GET("tv/airing_today")
    fun getTVs(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): Call<ListResponse<TVResponse>>

    @GET("tv/{tv_id}")
    fun getTvDetail(
        @Path("tv_id") tvId: Int,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): Call<TVResponse>

    @GET("tv/{tv_id}/content_ratings")
    fun getRatedForTV(
        @Path("tv_id") tvId: Int,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY
    ): Call<TVRatedResponse>

}