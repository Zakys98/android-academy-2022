package com.strv.movies.data.mapper

import com.strv.movies.data.entity.MovieDetailEntity
import com.strv.movies.model.MovieDetail
import com.strv.movies.model.MovieDetailDTO
import javax.inject.Inject

// Convention is to name a mapper after class of target object.
class MovieDetailMapper @Inject constructor() : Mapper<MovieDetailDTO, MovieDetail> {
    override fun map(from: MovieDetailDTO) =
        MovieDetail(
            id = from.id,
            title = from.title,
            overview = from.overview,
            releaseYear = from.releaseDate.substringBefore("-"), // ideal place to do some small tweaks to data to make it more UI ready
            posterPath = from.posterPath
        )
}

/*fun MovieDetailDTO.toEntity() = MovieDetailEntity(
    id = id,
    title = title,
    overview = overview,
    releaseDate = releaseDate,
    posterPath = posterPath,
    revenue = revenue
)

fun GenreDTO.toEntity() = GenreEntity(
    genreId = id,
    name = name
)

fun GenreDTO.toEntity(movieId: Int) = MovieGenreEntity(
    genreId = id,
    movieId = movieId
)

fun GenreEntity.toDomain() = Genre(
    id = genreId,
    name = name
)*/