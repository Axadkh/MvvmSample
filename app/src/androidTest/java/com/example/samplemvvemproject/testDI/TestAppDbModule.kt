package com.example.samplemvvemproject.testDI

import android.content.Context
import androidx.room.Room
import com.example.samplemvvemproject.db.AppDb
import com.example.samplemvvemproject.di.AppDbModule
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@TestInstallIn(components = [SingletonComponent::class], replaces = [AppDbModule::class])
@Module
object TestAppDbModule {

    @Provides
    @Singleton
    fun provideInMemoryDb(@ApplicationContext context: Context) =
        Room.inMemoryDatabaseBuilder(
            context, AppDb::class.java
        ).allowMainThreadQueries()
            .build()

}
