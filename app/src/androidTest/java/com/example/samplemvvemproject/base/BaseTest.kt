package com.example.samplemvvemproject.base


import com.example.samplemvvemproject.Backend.ServicesInterface
import com.example.samplemvvemproject.dataSource.RemoteDataSource
import com.example.samplemvvemproject.dataSource.LocalDataSource
import com.example.samplemvvemproject.db.AppDb
import com.example.samplemvvemproject.ui.home.HomeRepo
import dagger.hilt.android.testing.HiltAndroidRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import org.junit.After

import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.junit.MockitoJUnitRunner
import javax.inject.Inject


@RunWith(JUnit4::class)
open class BaseTest {


    val testDispatcher = StandardTestDispatcher()


    @get:Rule
    var hiltRule = HiltAndroidRule(this)


    @Inject
    lateinit var appDb: AppDb

    @Inject
    public lateinit var servicesInterface: ServicesInterface

    @Inject
    public lateinit var mockRemoteDataSource: RemoteDataSource

    @Inject
    public lateinit var mockLocalDataSource: LocalDataSource

    @Before
    fun setUp() {
        hiltRule.inject()
    }


    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }
}