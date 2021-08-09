package com.hafizcode.moviesandtv.ui.home.content.helper

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
class DataViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTV = DataDummy.generateDummyTV()

    private lateinit var viewModel: DataViewModel

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<DataEntity>>

    @Before
    fun setUp() {
        viewModel = DataViewModel(movieRepository)
    }

    @Test
    fun getMovies() {
        val movie = MutableLiveData<List<DataEntity>>()
        movie.value = dummyMovie

        `when`(movieRepository.getMovies()).thenReturn(movie)

        val dataListMovie = viewModel.getMovies().value

        verify(movieRepository).getMovies()
        assertNotNull(dataListMovie)
        assertEquals(10, dataListMovie?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }

    @Test
    fun getTVs() {
        val tvs = MutableLiveData<List<DataEntity>>()
        tvs.value = dummyTV

        `when`(movieRepository.getTVs()).thenReturn(tvs)

        val dataListTvs = viewModel.getTvs().value

        verify(movieRepository).getTVs()
        assertNotNull(dataListTvs)
        assertEquals(10, dataListTvs?.size)

        viewModel.getTvs().observeForever(observer)
        verify(observer).onChanged(dummyTV)
    }
}