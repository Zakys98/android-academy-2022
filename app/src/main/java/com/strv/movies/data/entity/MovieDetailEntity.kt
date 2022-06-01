package com.strv.movies.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.strv.movies.model.MovieDetail

@Entity(tableName = "movie_detail")
data class MovieDetailEntity(
    @PrimaryKey
    @ColumnInfo(name = "movie_id") val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "overview") val overview: String?,
    @ColumnInfo(name = "release_year") val releaseYear: String,
    @ColumnInfo(name = "poster_path") val posterPath: String
)

fun MovieDetailEntity.toDomain() = MovieDetail(
    id = id,
    title = title,
    overview = overview,
    posterPath = posterPath,
    releaseYear = releaseYear
)