package com.example.samplemvvemproject.db

import androidx.room.TypeConverter
import com.example.samplemvvemproject.commonModel.Interest
import com.example.samplemvvemproject.commonModel.User
import com.google.gson.Gson

class RoomTypeConverters {
    val gson = Gson()
    @TypeConverter
    fun userToString(interest: Interest) :String {
       return gson.toJson(interest)
    }

    @TypeConverter
    fun stringToUser(value: String): Interest {
        return  gson.fromJson(value,Interest::class.java)
    }

}