package com.example.samplemvvemproject.dataSource

import com.example.samplemvvemproject.Backend.ServicesInterface
import javax.inject.Inject

class RemoteDataSource @Inject constructor( val services: ServicesInterface) {

    suspend fun getProduct() = services.getProducts()


}
