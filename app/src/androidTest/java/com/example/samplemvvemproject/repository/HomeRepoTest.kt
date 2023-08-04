package com.example.samplemvvemproject.repository


import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.samplemvvemproject.base.BaseTest
import com.example.samplemvvemproject.Backend.StateApi
import com.example.samplemvvemproject.ui.home.HomeRepo
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.single
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import javax.inject.Inject
@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class HomeRepoTest : BaseTest() {

    /*@get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()*/

    @Inject
    lateinit var homeRepo: HomeRepo

    @Test
    fun fetchProductsTest() = runTest {

        val response = homeRepo.getProducts()
        val result = response.single()

        Assert.assertNotNull(result?.data)
        Assert.assertTrue(result is StateApi.Success)
        Assert.assertTrue(result?.data?.products?.size!! > 0)
    }
}


