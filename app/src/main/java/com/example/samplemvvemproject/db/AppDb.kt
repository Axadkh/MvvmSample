package com.example.samplemvvemproject.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.samplemvvemproject.commonModel.User
import com.example.samplemvvemproject.utils.LocalDb

@Database(entities = [User::class], version = LocalDb.DB_VERSION)
@TypeConverters(RoomTypeConverters::class)
abstract class AppDb: RoomDatabase() {

    abstract fun userDao(): UserDao
}
