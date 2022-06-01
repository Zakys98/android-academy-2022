package com.strv.movies.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.strv.movies.data.entity.MovieDetailEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieDetail(entity: MovieDetailEntity)

    @Query("SELECT * FROM movie_detail WHERE movie_id = :movieId")
    fun observeMovieDetail(movieId: Int): Flow<MovieDetailEntity?>
}