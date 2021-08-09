package com.hafizcode.moviesandtv.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.hafizcode.moviesandtv.data.DataEntity
import com.hafizcode.moviesandtv.data.source.MovieRepository
import com.hafizcode.moviesandtv.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyTv = DataDummy.generateDummyTV()[0]
    private val dummyMovieId = dummyMovie.id
    private val dummyTvId = dummyTv.id

    private lateinit var detailViewModel: DetailViewModel

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<DataEntity>

    @Before
    fun setUp() {
        detailViewModel = DetailViewModel(movieRepository)
    }

    @Test
    fun getDetailMovie() {
        val movie = MutableLiveData<DataEntity>()
        movie.value = dummyMovie

        `when`(movieRepository.getMovieDetail(dummyMovieId.toInt())).thenReturn(movie)

        val movieData = detailViewModel.getDetailMovie(dummyMovieId.toInt()).value as DataEntity

        verify(movieRepository).getMovieDetail(dummyMovieId.toInt())

        assertNotNull(movieData)

        assertEquals(dummyMovie.id, movieData.id)
        assertEquals(dummyMovie.title, movieData.title)
        assertEquals(dummyMovie.description, movieData.description)
        assertEquals(dummyMovie.genre, movieData.genre)
        assertEquals(dummyMovie.releasedYear, movieData.releasedYear)
        assertEquals(dummyMovie.ratingFor, movieData.ratingFor)
        assertEquals(dummyMovie.ratingFilm, movieData.ratingFilm)
        assertEquals(dummyMovie.playedHour, movieData.playedHour)
        assertEquals(dummyMovie.imgPoster, movieData.imgPoster)

        detailViewModel.getDetailMovie(dummyMovieId.toInt()).observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }

    @Test
    fun getDetailTvs() {
        val tvs = MutableLiveData<DataEntity>()
        tvs.value = dummyTv

        `when`(movieRepository.getTVDetail(dummyTvId.toInt())).thenReturn(tvs)

        val tvsData = detailViewModel.getDetailTV(dummyTvId.toInt()).value as DataEntity

        verify(movieRepository).getTVDetail(dummyTvId.toInt())

        assertNotNull(tvsData)

        assertEquals(dummyTv.id, tvsData.id)
        assertEquals(dummyTv.title, tvsData.title)
        assertEquals(dummyTv.description, tvsData.description)
        assertEquals(dummyTv.genre, tvsData.genre)
        assertEquals(dummyTv.releasedYear, tvsData.releasedYear)
        assertEquals(dummyTv.ratingFor, tvsData.ratingFor)
        assertEquals(dummyTv.ratingFilm, tvsData.ratingFilm)
        assertEquals(dummyTv.playedHour, tvsData.playedHour)
        assertEquals(dummyTv.imgPoster, tvsData.imgPoster)

        detailViewModel.getDetailTV(dummyTvId.toInt()).observeForever(observer)
        verify(observer).onChanged(dummyTv)
    }

}