package com.strv.movies.model

import com.squareup.moshi.Json

data class MovieVideosDTO(
    @Json(name = "id")
    val id: Int,
    @Json(name = "results")
    val results: List<TrailerDTO>
)

data class TrailerDTO(
    @Json(name = "iso_639_1")
    val iso_639_1: String,
    @Json(name = "iso_3166_1")
    val iso_3166_1: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "key")
    val key: String,
    @Json(name = "site")
    val site: String,
    @Json(name = "size")
    val size: Int,
    @Json(name = "type")
    val type: String,
    @Json(name = "official")
    val official: Boolean,
    @Json(name = "published_at")
    val publishedAt: String,
    @Json(name = "id")
    val id: String,
)

data class Trailer(
    val iso_639_1: String,
    val iso_3166_1: String,
    val name: String,
    val key: String,
    val site: String,
    val size: Int,
    val type: String,
    val official: Boolean,
    val publishedAt: String,
    val id: String
)