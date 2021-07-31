package com.hafizcode.moviesandtv.ui.home.content.tv

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hafizcode.moviesandtv.R
import com.hafizcode.moviesandtv.data.DataEntity
import com.hafizcode.moviesandtv.databinding.FragmentTvBinding
import com.hafizcode.moviesandtv.ui.detail.DetailActivity
import com.hafizcode.moviesandtv.ui.home.content.helper.DataCallback
import com.hafizcode.moviesandtv.ui.home.content.helper.DataViewModel

class TvFragment : Fragment(), DataCallback {

    private lateinit var fragmentTvBinding: FragmentTvBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvBinding = FragmentTvBinding.inflate(layoutInflater, container, false)
        return fragmentTvBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[DataViewModel::class.java]
            val tvs = viewModel.getTvs()

            val adapter = TvAdapter(this)
            adapter.setTV(tvs)

            with(fragmentTvBinding.rvTv) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }

    override fun onItemClicked(data: DataEntity) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.DATA_ID, data.id)
        intent.putExtra(DetailActivity.DATA_TYPE, R.string.type_tv.toString())
        startActivity(intent)
    }
}