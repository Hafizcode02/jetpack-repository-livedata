package com.hafizcode.moviesandtv.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataEntity(
    var id: String,
    var title: String?,
    var description: String? = null,
    var genre: String? = null,
    var releasedYear: String? = null,
    var ratingFor: String? = null,
    var ratingFilm: String? = null,
    var playedHour: String? = null,
    var imgPoster: String,
) : Parcelable
