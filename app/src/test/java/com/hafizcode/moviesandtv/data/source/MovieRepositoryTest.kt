package com.hafizcode.moviesandtv.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.hafizcode.moviesandtv.data.source.remote.RemoteDataSource
import com.hafizcode.moviesandtv.data.source.remote.api.ApiClient
import com.hafizcode.moviesandtv.data.source.remote.response.MovieResponse
import com.hafizcode.moviesandtv.data.source.remote.response.RatedForResponse
import com.hafizcode.moviesandtv.data.source.remote.response.TVRatedResponse
import com.hafizcode.moviesandtv.data.source.remote.response.TVResponse
import com.hafizcode.moviesandtv.helper.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    // Setup Remote and Fake Movie Repository
    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote)

    // variable used to fill by response data
    private var listMovieResponse = ArrayList<MovieResponse>() as List<MovieResponse>
    private var listTVResponse = ArrayList<TVResponse>() as List<TVResponse>

    // variable used to fill by response id from index 0 data
    private var movieResponseId: Int = 0
    private var tvResponseId: Int = 0

    // variable used to fill by response detail from index 0 data
    private var movieResponseDetail: MovieResponse? = null
    private var tvsDetail: TVResponse? = null
    private var movieRatedResponse: RatedForResponse? = null
    private var tvRatedResponse: TVRatedResponse? = null

    // Get Data Movie From API Before Start Testing
    @Before
    fun getMoviesTest() {
        try {
            ApiClient.instance.getMovies().execute().body()?.result.let {
                if (it != null) {
                    listMovieResponse = it
                }
            }
            movieResponseId = listMovieResponse[0].id!!
            ApiClient.instance.getDetailMovies(movieResponseId).execute().body()
                ?.let { movie ->
                    ApiClient.instance.getRatedForMovies(movieResponseId).execute().body()
                        ?.let { movieRated ->
                            movieResponseDetail = movie
                            movieRatedResponse = movieRated
                        }
                }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    // Get Data TVs From API Before Start Testing
    @Before
    fun getTvsTest() {
        ApiClient.instance.getTVs().execute().body()?.result.let {
            if (it != null) {
                listTVResponse = it
            }
        }
        tvResponseId = listTVResponse[0].id!!
        ApiClient.instance.getTvDetail(tvResponseId).execute().body()?.let { tvs ->
            ApiClient.instance.getRatedForTV(tvResponseId).execute().body()?.let { tvRated ->
                tvsDetail = tvs
                tvRatedResponse = tvRated
            }
        }
    }


    // Start Testing
    @Test
    fun getMovies() {
        runBlocking {
            doAnswer {
                (it.arguments[0] as RemoteDataSource.LoadMoviesCallback).onAllMoviesReceived(
                    listMovieResponse
                )
                null
            }.`when`(remote).getMovies(any())
        }

        val data = LiveDataTestUtil.getValue(movieRepository.getMovies())

        runBlocking {
            verify(remote).getMovies(any())
        }

        assertNotNull(data)
        assertEquals(listMovieResponse.size.toLong(), data.size.toLong())
    }

    @Test
    fun getMovieDetail() {
        runBlocking {
            doAnswer {
                (it.arguments[1] as RemoteDataSource.LoadMovieDetailCallback).onMovieDetailReceived(
                    movieResponseDetail!!, movieRatedResponse!!
                )
                null
            }.`when`(remote).getMovieDetail(eq(movieResponseId), any())
        }

        val data =
            LiveDataTestUtil.getValue(movieRepository.getMovieDetail(movieResponseId))

        runBlocking {
            verify(remote).getMovieDetail(eq(movieResponseId), any())
        }

        assertNotNull(data)
        assertEquals(movieResponseDetail!!.id.toString(), data.id)
    }

    @Test
    fun getTVs() {
        runBlocking {
            doAnswer {
                (it.arguments[0] as RemoteDataSource.LoadTvCallback).onAllTvShowsReceived(
                    listTVResponse
                )
                null
            }.`when`(remote).getTVs(any())
        }

        val data = LiveDataTestUtil.getValue(movieRepository.getTVs())

        runBlocking {
            verify(remote).getTVs(any())
        }

        assertNotNull(data)
        assertEquals(listTVResponse.size.toLong(), data.size.toLong())
    }

    @Test
    fun getTVDetail() {
        runBlocking {
            doAnswer {
                (it.arguments[1] as RemoteDataSource.LoadTvDetailCallback).onTvShowDetailReceived(
                    tvsDetail!!, tvRatedResponse!!
                )
                null
            }.`when`(remote).getTVDetail(eq(tvResponseId), any())
        }

        val data =
            LiveDataTestUtil.getValue(movieRepository.getTVDetail(tvResponseId))

        runBlocking {
            verify(remote).getTVDetail(eq(tvResponseId), any())
        }

        assertNotNull(data)
        assertEquals(tvsDetail!!.id.toString(), data.id)
    }
}