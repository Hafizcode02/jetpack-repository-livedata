package com.hafizcode.moviesandtv.ui.home.content.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hafizcode.moviesandtv.R
import com.hafizcode.moviesandtv.data.DataEntity
import com.hafizcode.moviesandtv.databinding.FragmentMovieBinding
import com.hafizcode.moviesandtv.ui.detail.DetailActivity
import com.hafizcode.moviesandtv.ui.home.content.helper.DataCallback
import com.hafizcode.moviesandtv.ui.home.content.helper.DataViewModel

class MovieFragment : Fragment(), DataCallback {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val viewModel =
                ViewModelProvider(
                    this,
                    ViewModelProvider.NewInstanceFactory()
                )[DataViewModel::class.java]
            val movies = viewModel.getMovies()

            val adapter = MovieAdapter(this)
            adapter.setMovies(movies)

            with(fragmentMovieBinding.rvMovie) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }

    override fun onItemClicked(data: DataEntity) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.DATA_ID, data.id)
        intent.putExtra(DetailActivity.DATA_TYPE, R.string.type_movie.toString())
        startActivity(intent)
    }

}