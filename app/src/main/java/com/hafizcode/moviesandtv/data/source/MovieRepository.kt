package com.hafizcode.moviesandtv.data.source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hafizcode.moviesandtv.data.DataEntity
import com.hafizcode.moviesandtv.data.source.remote.RemoteDataSource
import com.hafizcode.moviesandtv.data.source.remote.response.MovieResponse
import com.hafizcode.moviesandtv.data.source.remote.response.TVResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MovieRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    MovieDataSource {

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

    override fun getMovieDetail(movieId: Int): LiveData<List<DataEntity>> {
        TODO("Not yet implemented")
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

    override fun getTVDetail(tvId: Int): LiveData<List<DataEntity>> {
        TODO("Not yet implemented")
    }

}