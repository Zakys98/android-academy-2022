package com.strv.movies.ui.moviedetail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.strv.movies.extension.fold
import com.strv.movies.network.MovieRepository
import com.strv.movies.ui.navigation.MoviesNavArguments
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val movieId =
        requireNotNull(savedStateHandle.get<Int>(MoviesNavArguments.MOVIE_ID_KEY)) {
            "Movie id is missing..."
        }

    private val _viewState = MutableStateFlow(MovieDetailViewState(loading = true))
    val viewState = _viewState.asStateFlow()

    init {
        viewModelScope.launch {
            val movieVideoDeferred = async { fetchMovieTrailer() }
            val movieDetailDeferred = async { fetchMovieDetail() }
            movieDetailDeferred.await()
            movieVideoDeferred.await()
        }
    }

    private suspend fun fetchMovieDetail(){
        movieRepository.getMovieDetail(movieId = movieId).fold(
            { error ->
                Log.e("TAG", "MovieError: $error")
                _viewState.update {
                    MovieDetailViewState(error = error)
                }
            }, { movie ->
                Log.e("TAG", "MovieSuccess: $movie")
                val trailer = _viewState.value.videoKey
                _viewState.update {
                    MovieDetailViewState(movie = movie, videoKey = trailer)
                }
            }
        )
    }

    private suspend fun fetchMovieTrailer(){
        movieRepository.getMovieDetailVideos(movieId = movieId).fold(
            { error ->
                Log.e("TAG", "MovieError: $error")
                _viewState.update {
                    MovieDetailViewState(error = error)
                }
            }, { trailerList ->
                Log.e("TAG", "MovieTrailerKey: ${trailerList.first().key}")
                val movie = _viewState.value.movie
                _viewState.update {
                    MovieDetailViewState(movie = movie, videoKey = trailerList.first().key)
                }
            }
        )
    }

    fun updateVideoProgress(progress: Float) {
        _viewState.update { it.copy(videoProgress = progress) }
    }
}