package com.example.samplemvvemproject.db

import androidx.room.*
import com.example.samplemvvemproject.commonModel.User


@Dao
interface UserDao {

    @Query("SELECT * From User")
     suspend fun getUserLiveData(): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(model: User)

    @Query("DELETE FROM User")
    suspend fun deleteUser()

    @Update
    suspend fun updateUser(model: User)



}