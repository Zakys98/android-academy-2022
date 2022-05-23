package com.strv.movies.data

import com.strv.movies.model.Trailer
import com.strv.movies.model.TrailerDTO
import javax.inject.Inject

class TrailerMapper @Inject constructor(): Mapper<TrailerDTO, Trailer> {
    override fun map(from: TrailerDTO): Trailer {
        return Trailer(
            iso_639_1 = from.iso_639_1,
            iso_3166_1 = from.iso_3166_1,
            name = from.name,
            key = from.key,
            site = from.site,
            size = from.size,
            type = from.type,
            official = from.official,
            publishedAt = from.publishedAt,
            id = from.id,
        )
    }
}