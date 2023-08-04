package com.example.samplemvvemproject.utils
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton


class AppSp(val prefs:SharedPreferences ) {

    fun getString(key:String): String {
        return prefs.getString(key, "") ?: ""
    }

    fun saveString(key:String ,value: String) {
        prefs.edit().putString(key, value).apply()
    }


    fun saveBoolean(key:String ,value: Boolean) {
        prefs.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key:String): Boolean {
        return prefs.getBoolean(key, false)
    }


    fun saveInt(key:String ,value: Int) {
        prefs.edit().putInt(key, value).apply()
    }

    fun getInt(key:String): Int {
        return prefs.getInt(key, -1)
    }

    fun saveLong(key:String ,value: Long) {
        prefs.edit().putLong(key, value).apply()
    }

    fun getLong(key:String): Long {
        return prefs.getLong(key, -1)
    }

    fun clearAllSharedPreferences() {
        prefs.edit().clear().apply()
    }

}

