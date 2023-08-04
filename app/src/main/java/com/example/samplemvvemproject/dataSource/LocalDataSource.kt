package com.example.samplemvvemproject.dataSource

import com.example.samplemvvemproject.commonModel.User
import com.example.samplemvvemproject.db.AppDb
import javax.inject.Inject


class LocalDataSource @Inject constructor(val appDb: AppDb) {

    suspend fun  getUser() = appDb.userDao().getUserLiveData()
    suspend fun  interUser(user : User) = appDb.userDao().insertUser(user)
    suspend fun  updateUser(user : User) = appDb.userDao().updateUser(user)
    suspend fun  deletedUser() = appDb.userDao().deleteUser()

}