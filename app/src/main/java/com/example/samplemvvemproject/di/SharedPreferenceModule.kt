package com.example.samplemvvemproject.di

import android.content.Context
import android.content.SharedPreferences

import com.example.samplemvvemproject.utils.AppSp
import com.example.samplemvvemproject.utils.SP_File_NAME


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferenceModule {


    @Singleton
    @Provides
    fun providePreference(@ApplicationContext context : Context): SharedPreferences {
         val file = SP_File_NAME
        return context.getSharedPreferences(file, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideJustSP(sp:SharedPreferences): AppSp {
        return AppSp(sp)
    }

}