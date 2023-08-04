package com.example.samplemvvemproject.Backend


import com.example.samplemvvemproject.ui.home.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface ServicesInterface {


    @GET("/products")
    suspend fun getProducts() :Response<ProductResponse>

}