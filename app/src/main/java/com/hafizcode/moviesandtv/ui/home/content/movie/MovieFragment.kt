package com.hafizcode.moviesandtv.ui.home.content.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hafizcode.moviesandtv.data.DataEntity
import com.hafizcode.moviesandtv.databinding.FragmentMovieBinding
import com.hafizcode.moviesandtv.ui.detail.DetailActivity
import com.hafizcode.moviesandtv.ui.home.content.helper.DataCallback
import com.hafizcode.moviesandtv.ui.home.content.helper.DataViewModel
import com.hafizcode.moviesandtv.utils.Helper.MOVIE_TYPE
import com.hafizcode.moviesandtv.viewmodel.ViewModelFactory

class MovieFragment : Fragment(), DataCallback {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding
    private lateinit var viewModel: DataViewModel

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
        fragmentMovieBinding.rvMovie.apply {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = MovieAdapter(this@MovieFragment)
        }

        val factory = ViewModelFactory.getInstance()
        activity?.let {
            viewModel = ViewModelProvider(it, factory)[DataViewModel::class.java]
        }

        viewModel.getMovies().observe(viewLifecycleOwner, { listMovie ->
            fragmentMovieBinding.rvMovie.adapter?.let { adapter ->
                when (adapter){
                    is MovieAdapter -> adapter.setMovies(listMovie)
                }
            }
        })
    }

    override fun onItemClicked(data: DataEntity) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.DATA_ID, data.id)
        intent.putExtra(DetailActivity.DATA_TYPE, MOVIE_TYPE)
        startActivity(intent)
    }

}