package com.hafizcode.moviesandtv.ui.home.content.helper

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DataViewModelTest {

    private lateinit var viewModel: DataViewModel

    @Before
    fun setUp() {
        viewModel = DataViewModel()
    }

    @Test
    fun getMovies() {
        val movies = viewModel.getMovies()
        assertNotNull(movies)
        assertEquals(10, movies.size)
    }

    @Test
    fun getTvs() {
        val tvs = viewModel.getTvs()
        assertNotNull(tvs)
        assertEquals(10, tvs.size)
    }
}