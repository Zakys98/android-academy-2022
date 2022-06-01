package com.strv.movies.database

import android.content.Context
import androidx.room.Room
import com.strv.movies.data.dao.MoviesDao
import com.strv.movies.database.MoviesDatabase.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            MoviesDatabase::class.java,
            DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideMoviesDao(database: MoviesDatabase): MoviesDao =
        database.getMoviesDao()
}