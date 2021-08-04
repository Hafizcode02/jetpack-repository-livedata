package com.hafizcode.moviesandtv.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class RatedForResponse(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null
)

data class ResultsItem(

	@field:SerializedName("release_dates")
	val releaseDates: List<ReleaseDatesItem?>? = null,

	@field:SerializedName("iso_3166_1")
	val iso31661: String? = null
)

data class ReleaseDatesItem(

	@field:SerializedName("note")
	val note: String? = null,

	@field:SerializedName("release_date")
	val releaseDate: String? = null,

	@field:SerializedName("type")
	val type: Int? = null,

	@field:SerializedName("iso_639_1")
	val iso6391: String? = null,

	@field:SerializedName("certification")
	val certification: String? = null
)
