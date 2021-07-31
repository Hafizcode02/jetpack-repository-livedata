package com.hafizcode.moviesandtv.ui.home.view

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.hafizcode.moviesandtv.R
import com.hafizcode.moviesandtv.ui.home.view.helper.betterScrollTo
import com.hafizcode.moviesandtv.utils.DataDummy
import org.junit.Rule
import org.junit.Test


class HomeActivityTest {

    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTv = DataDummy.generateDummyTV()

    // Set Activity test rule
    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies() {
        // Check the RecyclerView is displayed, and scrolling down the data to max position
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        // Check RecyclerView is displayed and perform click on item at position 0
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        // Check a layout component like textView must be displayed and the data is match with the dummy data
        onView(withId(R.id.image_item)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.text_rating_film)).check(matches(isDisplayed()))
        onView(withId(R.id.text_rating_film)).check(matches(withText(dummyMovie[0].ratingFilm)))
        onView(withId(R.id.text_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.text_genre)).check(matches(withText(dummyMovie[0].genre)))
        onView(withId(R.id.text_rating_hour)).check(matches(isDisplayed()))
        onView(withId(R.id.text_rating_hour)).check(matches(withText("""${dummyMovie[0].ratingFor} / ${dummyMovie[0].playedHour}""")))
        onView(withId(R.id.text_date)).check(matches(isDisplayed()))
        onView(withId(R.id.text_date)).check(matches(withText(dummyMovie[0].releasedYear)))

        onView(withId(R.id.text_description)).perform(betterScrollTo())
        onView(withId(R.id.text_description)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description)).check(matches(withText(dummyMovie[0].description)))
    }

    @Test
    fun loadTvs() {
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTv.size
            )
        )
    }

    @Test
    fun loadTvDetail() {
        // Check RecyclerView is displayed and perform click on item at position 0
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        // Check a layout component like textView must be displayed and the data is match with the dummy data
        onView(withId(R.id.image_item)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyTv[0].title)))
        onView(withId(R.id.text_rating_film)).check(matches(isDisplayed()))
        onView(withId(R.id.text_rating_film)).check(matches(withText(dummyTv[0].ratingFilm)))
        onView(withId(R.id.text_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.text_genre)).check(matches(withText(dummyTv[0].genre)))
        onView(withId(R.id.text_rating_hour)).check(matches(isDisplayed()))
        onView(withId(R.id.text_rating_hour)).check(matches(withText("""${dummyTv[0].ratingFor} / ${dummyTv[0].playedHour}""")))
        onView(withId(R.id.text_date)).check(matches(isDisplayed()))
        onView(withId(R.id.text_date)).check(matches(withText(dummyTv[0].releasedYear)))

        onView(withId(R.id.text_description)).perform(betterScrollTo())
        onView(withId(R.id.text_description)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description)).check(matches(withText(dummyTv[0].description)))
    }
}