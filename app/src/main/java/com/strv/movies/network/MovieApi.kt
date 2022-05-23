package com.strv.movies.network

import com.strv.movies.model.MovieDetailDTO
import com.strv.movies.model.MovieVideosDTO
import com.strv.movies.model.PopularMoviesDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/{movieId}")
    suspend fun getMovieDetail(@Path("movieId") movieId: Int): MovieDetailDTO

    @GET("movie/{movieId}/videos")
    suspend fun getMovieDetailVideos(@Path("movieId") movieId: Int): MovieVideosDTO

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int = 1): PopularMoviesDTO
}