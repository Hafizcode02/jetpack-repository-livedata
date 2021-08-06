@file:Suppress("DEPRECATION")

package com.hafizcode.moviesandtv.ui.home.view

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.hafizcode.moviesandtv.R
import com.hafizcode.moviesandtv.ui.home.content.movie.MovieFragment
import com.hafizcode.moviesandtv.ui.home.content.tv.TvFragment

@Suppress("DEPRECATION")
class SectionPagerAdapter(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.film_tab, R.string.tv_tab)
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MovieFragment()
            1 -> TvFragment()
            else -> Fragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mContext.resources.getString(TAB_TITLES[position])
    }

}