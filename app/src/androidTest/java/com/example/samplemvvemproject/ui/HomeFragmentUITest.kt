package com.example.samplemvvemproject.ui

import android.app.Activity
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import androidx.test.runner.lifecycle.Stage
import com.example.samplemvvemproject.ui.home.MainActivity
import org.junit.Rule
import org.junit.Test
import com.example.samplemvvemproject.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.FixMethodOrder
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING )
class HomeFragmentUITest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    //val navController = findNavController(R.id.nav_host_fragment)

    @Test
    fun a_testNavigateToHomeFragmentAndScrollRecyclerView() {
        // Find the NavController
        Thread.sleep(5000)

        Espresso.onView(withId(R.id.recycler_view))
            .check(matches(isDisplayed()))
       ;
        // Scroll the RecyclerView to a specific position
        Espresso.onView(withId(R.id.recycler_view))
            .perform(RecyclerViewActions.
            scrollToPosition<RecyclerView.ViewHolder>(getRecyclerViewItemCount(R.id.recycler_view)-1))


        Thread.sleep(2000)

        Espresso.onView(withId(R.id.recycler_view))
            .perform(RecyclerViewActions.
            scrollToPosition<RecyclerView.ViewHolder>(0))


        val positionToClick = 2
        Espresso.onView(withId(R.id.recycler_view))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(positionToClick, ViewActions.click()))

    }




    private fun getRecyclerViewItemCount(recyclerViewId: Int): Int {
        var itemCount = 0
        activityScenarioRule.scenario.onActivity {
            val recyclerView = it.findViewById<RecyclerView>(recyclerViewId)
            itemCount = recyclerView.adapter?.itemCount ?: 0
        }
        return itemCount
    }
}
