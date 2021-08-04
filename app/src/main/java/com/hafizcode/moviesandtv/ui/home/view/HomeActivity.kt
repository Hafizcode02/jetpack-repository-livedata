package com.hafizcode.moviesandtv.ui.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.hafizcode.moviesandtv.R
import com.hafizcode.moviesandtv.databinding.ActivityHomeBinding
import com.hafizcode.moviesandtv.ui.home.content.helper.DataViewModel
import com.hafizcode.moviesandtv.viewmodel.ViewModelFactory
import com.synnapps.carouselview.ImageListener

class HomeActivity : AppCompatActivity() {

    private lateinit var dataViewModel: DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        val factory = ViewModelFactory.getInstance()
        dataViewModel = ViewModelProvider(this, factory)[DataViewModel::class.java]

        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        activityHomeBinding.viewPager.adapter = sectionPagerAdapter
        activityHomeBinding.tabs.setupWithViewPager(activityHomeBinding.viewPager)

        val carouselImages = intArrayOf(
            R.drawable.slider_avengers,
            R.drawable.slider_naruto,
            R.drawable.slider_ipman,
            R.drawable.slider_ncis
        )

        val imageListener = ImageListener { position, imageView ->
            imageView.setImageResource(carouselImages[position])
        }

        activityHomeBinding.carouselView.pageCount = carouselImages.size
        activityHomeBinding.carouselView.setImageListener(imageListener)
    }
}