package com.hafizcode.moviesandtv.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hafizcode.moviesandtv.data.DataEntity
import com.hafizcode.moviesandtv.data.source.remote.RemoteDataSource
import com.hafizcode.moviesandtv.data.source.remote.response.MovieResponse
import com.hafizcode.moviesandtv.data.source.remote.response.RatedForResponse
import com.hafizcode.moviesandtv.data.source.remote.response.TVRatedResponse
import com.hafizcode.moviesandtv.data.source.remote.response.TVResponse
import com.hafizcode.moviesandtv.utils.Helper.convertDate
import com.hafizcode.moviesandtv.utils.Helper.convertMinutesToHour
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MovieRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    MovieDataSource {

    private var genresData: String = ""
    private var ratedForCertification: String = ""
    private var playedHourTV: String = ""

    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteDataSource)
            }
    }

    override fun getMovies(): LiveData<List<DataEntity>> {
        val listMovieResult = MutableLiveData<List<DataEntity>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback {
                override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                    val movieList = ArrayList<DataEntity>()
                    for (response in movieResponse) {
                        val movie = DataEntity(
                            id = response.id.toString(),
                            title = response.title.toString(),
                            imgPoster = response.posterPath.toString()
                        )
                        movieList.add(movie)
                    }
                    listMovieResult.postValue(movieList)
                }

            })
        }
        return listMovieResult
    }

    override fun getMovieDetail(movieId: Int): LiveData<DataEntity> {
        val movieDetailResult = MutableLiveData<DataEntity>()
        CoroutineScope(IO).launch {
            remoteDataSource.getMovieDetail(
                movieId,
                object : RemoteDataSource.LoadMovieDetailCallback {
                    override fun onMovieDetailReceived(
                        movieResponse: MovieResponse,
                        ratedForResponse: RatedForResponse
                    ) {
                        movieResponse.genres?.forEachIndexed { index, data ->
                            if (index < 1) genresData += "${data?.name}"
                            else if (index >= 1) genresData += ", ${data?.name}"
                        }
                        ratedForResponse.results?.forEach {
                            if (it?.iso31661.equals("RU", true)) {
                                ratedForCertification =
                                    it?.releaseDates?.get(0)?.certification.toString()
                            }
                        }
                        val movie = DataEntity(
                            movieResponse.id.toString(),
                            movieResponse.title,
                            movieResponse.overview,
                            genresData,
                            convertDate(movieResponse.releaseDate.toString()),
                            ratedForCertification,
                            movieResponse.voteAverage.toString(),
                            movieResponse.runtime?.let { convertMinutesToHour(it) },
                            movieResponse.posterPath.toString()
                        )
                        movieDetailResult.postValue(movie)
                    }
                })
        }
        return movieDetailResult
    }

    override fun getTVs(): LiveData<List<DataEntity>> {
        val listTVsResult = MutableLiveData<List<DataEntity>>()
        CoroutineScope(IO).launch {
            remoteDataSource.getTVs(object : RemoteDataSource.LoadTvCallback {
                override fun onAllTvShowsReceived(tvShowResponse: List<TVResponse>) {
                    val tvsList = ArrayList<DataEntity>()
                    for (response in tvShowResponse) {
                        val tvs = DataEntity(
                            id = response.id.toString(),
                            title = response.name.toString(),
                            imgPoster = response.posterPath.toString()
                        )
                        tvsList.add(tvs)
                    }
                    listTVsResult.postValue(tvsList)
                }
            })
        }
        return listTVsResult
    }

    override fun getTVDetail(tvId: Int): LiveData<DataEntity> {
        val tvDetailResult = MutableLiveData<DataEntity>()
        CoroutineScope(IO).launch {
            remoteDataSource.getTVDetail(tvId, object : RemoteDataSource.LoadTvDetailCallback {
                override fun onTvShowDetailReceived(
                    tvShowResponse: TVResponse,
                    tvRatedResponse: TVRatedResponse
                ) {
                    tvShowResponse.genres?.forEachIndexed { index, data ->
                        if (index < 1) genresData += "${data?.name}"
                        else if (index >= 1) genresData += ", ${data?.name}"
                    }
                    tvRatedResponse.results?.forEach {
                        if (it?.iso31661.equals("RU", true)) {
                            ratedForCertification =
                                it?.rating.toString()
                        }
                    }
                    tvShowResponse.episodeRunTime?.let {
                        if (!tvShowResponse.episodeRunTime.isNullOrEmpty()) {
                            it[0]?.let { it1 ->
                                playedHourTV = convertMinutesToHour(
                                    it1
                                )
                            }
                        }
                    }
                    val tv = DataEntity(
                        tvShowResponse.id.toString(),
                        tvShowResponse.name,
                        tvShowResponse.overview,
                        genresData,
                        convertDate(tvShowResponse.firstAirDate.toString()),
                        ratedForCertification,
                        tvShowResponse.voteAverage.toString(),
                        playedHourTV,
                        tvShowResponse.posterPath.toString()
                    )
                    tvDetailResult.postValue(tv)
                }

            })
        }
        return tvDetailResult
    }

}