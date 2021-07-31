package com.hafizcode.moviesandtv.ui.detail

import com.hafizcode.moviesandtv.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelTest {

    private lateinit var detailViewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyTv = DataDummy.generateDummyTV()[0]
    private val dummyMovieId = dummyMovie.id
    private val dummyTvId = dummyTv.id

    @Before
    fun setUp() {
        detailViewModel = DetailViewModel()
        detailViewModel.setMovieId(dummyMovieId)
        detailViewModel.setTvId(dummyTvId)
    }

    @Test
    fun getMovieById() {
        val movie = detailViewModel.getMovieById()
        assertNotNull(movie)
        assertEquals(dummyMovie.title, movie.title)
        assertEquals(dummyMovie.description, movie.description)
        assertEquals(dummyMovie.genre, movie.genre)
        assertEquals(dummyMovie.ratingFor, movie.ratingFor)
        assertEquals(dummyMovie.ratingFilm, movie.ratingFilm)
        assertEquals(dummyMovie.playedHour, movie.playedHour)
        assertEquals(dummyMovie.imgPoster, movie.imgPoster)
        assertEquals(dummyMovie.releasedYear, movie.releasedYear)
    }

    @Test
    fun getTvById() {
        val tv = detailViewModel.getTvById()
        assertNotNull(tv)
        assertEquals(dummyTv.title, tv.title)
        assertEquals(dummyTv.description, tv.description)
        assertEquals(dummyTv.genre, tv.genre)
        assertEquals(dummyTv.ratingFor, tv.ratingFor)
        assertEquals(dummyTv.ratingFilm, tv.ratingFilm)
        assertEquals(dummyTv.playedHour, tv.playedHour)
        assertEquals(dummyTv.imgPoster, tv.imgPoster)
        assertEquals(dummyTv.releasedYear, tv.releasedYear)
    }
}