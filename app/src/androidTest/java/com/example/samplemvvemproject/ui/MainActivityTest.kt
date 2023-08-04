package com.example.samplemvvemproject.ui

import android.provider.ContactsContract
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.samplemvvemproject.ui.home.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MainActivityTest {



    @get:Rule
    val mainActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)



    fun test_recyclerview_scroll(){

    }
    @Before
    fun setup(){

    }

    @After
    fun tearDown(){

    }

}