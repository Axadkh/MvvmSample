package com.example.samplemvvemproject.viewmodel


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.samplemvvemproject.base.BaseTest
import com.example.samplemvvemproject.ui.home.HomeViewModel
import com.example.samplemvvemproject.ui.home.model.ProductResponse
import com.example.samplemvvemproject.util.getOrAwaitValue
import com.example.samplemvvemproject.Backend.StateApi
import com.example.samplemvvemproject.ui.home.HomeRepo
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.withContext
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith


import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.objenesis.strategy.InstantiatorStrategy
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class HomeViewModelTest : BaseTest() {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    lateinit var homeRepo: HomeRepo

    @Test
    fun fetchProductsTest()= runTest {
        val viewModel = HomeViewModel(homeRepo)


        viewModel.fetchProducts()
        testDispatcher.scheduler.advanceUntilIdle()
           val result = viewModel.products.getOrAwaitValue()

           Assert.assertNotNull(result.data)
           Assert.assertTrue(result is StateApi.Success)
           Assert.assertTrue(result.data?.products!!.size > 0)

       }



}
