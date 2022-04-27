package com.strv.movies.ui.moviesList

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.strv.movies.model.Movie

@Composable
fun MovieItem(movie: Movie) {
    Box(modifier = Modifier.padding(16.dp).clickable {  }) {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w500${movie.posterPath}",
            contentDescription = "Movie poster"
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesList(moviesList: List<Movie>) {
    LazyVerticalGrid(cells = GridCells.Fixed(2)) {
        items(moviesList) { movie ->
            MovieItem(movie = movie)
        }
    }
}