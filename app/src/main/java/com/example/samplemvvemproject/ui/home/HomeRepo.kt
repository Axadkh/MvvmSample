package com.example.samplemvvemproject.ui.home

import com.enterkomug.justlo_package.webServices.SafeApiCall
import com.example.samplemvvemproject.dataSource.RemoteDataSource
import com.example.samplemvvemproject.dataSource.LocalDataSource
import com.example.samplemvvemproject.ui.home.model.ProductResponse
import com.example.samplemvvemproject.Backend.StateApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


import javax.inject.Inject

class HomeRepo @Inject constructor(private  val remoteDataSource: RemoteDataSource, private  val  localDataSource: LocalDataSource) :
    SafeApiCall(){

    suspend fun getProducts(): Flow<StateApi<ProductResponse>?> {

        val remoteFlow = flow {

       emit(safeCall { remoteDataSource.getProduct() })

        }.flowOn(Dispatchers.IO)
        return remoteFlow
    }

    }