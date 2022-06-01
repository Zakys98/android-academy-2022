package com.strv.movies.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.strv.movies.data.dao.MoviesDao
import com.strv.movies.data.entity.MovieDetailEntity
import com.strv.movies.database.MoviesDatabase.Companion.DATABASE_VERSION

@Database(
    version = DATABASE_VERSION,
    entities = [
        MovieDetailEntity::class
    ]
)
abstract class MoviesDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "movies_database"
    }

    abstract fun getMoviesDao(): MoviesDao
}