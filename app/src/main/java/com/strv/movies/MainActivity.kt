package com.strv.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.strv.movies.data.OfflineMoviesProvider
import com.strv.movies.ui.detail.MovieDetail
import com.strv.movies.ui.moviesList.MoviesList
import com.strv.movies.ui.theme.MoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    //MovieItem(movie = OfflineMoviesProvider.getMovies().first())
                    //MoviesList(moviesList = OfflineMoviesProvider.getMovies())
                    MovieDetail(movieDetail = OfflineMoviesProvider.getMovieDetail(1))
                }
            }
        }
    }
}



@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MoviesTheme {
        Greeting("Android")
    }
}