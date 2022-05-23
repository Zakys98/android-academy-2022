package com.strv.movies.network

import com.strv.movies.data.MovieDetailMapper
import com.strv.movies.data.MovieMapper
import com.strv.movies.data.TrailerMapper
import com.strv.movies.extension.Either
import com.strv.movies.model.Movie
import com.strv.movies.model.MovieDetail
import com.strv.movies.model.Trailer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val api: MovieApi,
    private val movieDetailMapper: MovieDetailMapper,
    private val movieMapper: MovieMapper,
    private val trailerMapper: TrailerMapper
) {
    suspend fun getMovieDetail(movieId: Int): Either<String, MovieDetail> {
        return try {
            val movie = api.getMovieDetail(movieId = movieId)
            Either.Value(movieDetailMapper.map(movie))
        } catch (exception: Throwable) {
            Either.Error(exception.localizedMessage?: "Network error")
        }
    }

    suspend fun getMovieDetailVideos(movieId: Int): Either<String, List<Trailer>> {
        return try {
            val movieVideos = api.getMovieDetailVideos(movieId = movieId)
            Either.Value(movieVideos.results.map { trailerMapper.map(it) })
        } catch (exception: Throwable) {
            Either.Error(exception.localizedMessage?: "Network error")
        }
    }

    suspend fun getPopularMovies(): Either<String, List<Movie>> {
        return try {
            val popularMovies = api.getPopularMovies()
            Either.Value(popularMovies.results.map { movieMapper.map(it) })
        } catch (exception: Throwable) {
            Either.Error(exception.localizedMessage?: "Network error")
        }
    }
}